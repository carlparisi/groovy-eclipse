/*
 * Copyright 2011 SpringSource, a division of VMware, Inc
 * 
 * andrew - Initial API and implementation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.eclipse.dsl.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.groovy.eclipse.codeassist.tests.CompletionTestCase;
import org.codehaus.groovy.eclipse.core.model.GroovyRuntime;
import org.codehaus.groovy.eclipse.dsl.GroovyDSLCoreActivator;
import org.codehaus.groovy.eclipse.dsl.RefreshDSLDJob;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.tests.util.GroovyUtils;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * 
 * @author Andrew Eisenberg
 * @created Jul 27, 2011
 */
public class DSLContentAssistTests extends CompletionTestCase {

    private static final String COMMAND_CHAIN_NO_ARGS = 
            "contribute (currentType('Inner')) {\n" + 
    		"  method name:'flart', noParens:true, type: 'Inner'\n" + 
    		"}";
    private static final String COMMAND_CHAIN_ONE_ARG =
            "contribute (currentType('Inner')) {\n" + 
            "  method name:'flart', noParens:true, type: 'Inner', params:[a:Integer]\n" + 
            "}";

    private static final String COMMAND_CHAIN_TWO_ARGS =
            "contribute (currentType('Inner')) {\n" + 
            "  method name:'flart', noParens:true, type: 'Inner', params:[a:Integer, b:String]\n" + 
            "}";
    private static final String NO_PARENS_FOR_DELEGATE =
            "contribute (currentType('Inner')) {\n" + 
            "  delegatesTo type: 'Other', noParens: true\n" + 
            "}";
    private static final String SET_DELEGATE_ON_INT = "contribute(currentType(Integer) & enclosingCallName(\"foo\")) {\n" + 
    "    setDelegateType(String)\n" + 
    "}";

    public DSLContentAssistTests(String name) {
        super(name);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createGenericProject();
        IProject project = getDefaultProject();
        AbstractDSLInferencingTest.refreshExternalFoldersProject();
        GroovyRuntime.addLibraryToClasspath(JavaCore.create(project), GroovyDSLCoreActivator.CLASSPATH_CONTAINER_ID, false);
        env.fullBuild();
        new RefreshDSLDJob(project).run(null);
        GroovyDSLCoreActivator.getDefault().getContainerListener().ignoreProject(project);
    }

    public void testDSLProposalFirstStaticField() throws Exception {
        String contents = "@Singleton class Foo { static aaa }\n Foo.s";
        ICompletionProposal[] proposals = orderByRelevance(createProposalsAtOffset(contents, getIndexOf(contents, ".")));
        assertProposalOrdering(proposals, "instance", "aaa");
    }

    public void testDSLProposalFirstStaticMethod() throws Exception {
        String contents = "@Singleton class Foo { static aaa() { } }\n Foo.s";
        ICompletionProposal[] proposals = orderByRelevance(createProposalsAtOffset(contents, getIndexOf(contents, ".")));
        assertProposalOrdering(proposals, "getInstance", "aaa");
    }
    
    public void testDSLProposalFirstMethod1() throws Exception {
        if (GroovyUtils.GROOVY_LEVEL >= 20) {
            AbstractDSLInferencingTest.addGroovyJarToProject("groovy-swing-2.0.6.jar", getDefaultProject());
        }
        String contents = "import groovy.swing.SwingBuilder\n" +
                "new SwingBuilder().edt {\n" +
                "delegate.x\n" +
                "}";
        ICompletionProposal[] proposals = orderByRelevance(createProposalsAtOffset(contents, getIndexOf(contents, "delegate.")));
        assertProposalOrdering(proposals, "frame", "registerBinding");
    }
    public void testDSLProposalFirstMethod2() throws Exception {
        if (GroovyUtils.GROOVY_LEVEL >= 20) {
            AbstractDSLInferencingTest.addGroovyJarToProject("groovy-swing-2.0.6.jar", getDefaultProject());
        }
        String contents = "import groovy.swing.SwingBuilder\n" +
                "new SwingBuilder().edt {\n" +
                "\n" +
                "}";
        ICompletionProposal[] proposals = orderByRelevance(createProposalsAtOffset(contents, getIndexOf(contents, "{\n")));
        assertProposalOrdering(proposals, "frame", "registerBinding");
    }
    
    // proposals should not exist since not applied to 'this'
    public void testDSLProposalFirstMethod3() throws Exception {
        if (GroovyUtils.GROOVY_LEVEL >= 20) {
            AbstractDSLInferencingTest.addGroovyJarToProject("groovy-swing-2.0.6.jar", getDefaultProject());
        }
        String contents = "import groovy.swing.SwingBuilder\n" +
                "new SwingBuilder().edt {\n" +
                "this.x\n" +
                "}";
        ICompletionProposal[] proposals = orderByRelevance(createProposalsAtOffset(contents, getIndexOf(contents, "this.")));
        proposalExists(proposals, "frame", 0);
        proposalExists(proposals, "registerBinding", 0);
    }
    
    // GRECLIPSE-1324
    public void testEmptyClosure1() throws Exception {
        createDsls(
                SET_DELEGATE_ON_INT);
        String contents = "1.foo {\n" + 
        		"    // here\n" + 
        		"}";
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, "\n    "));

        // should see proposals from String, not Integer
        proposalExists(proposals, "substring", 2);
        
        proposalExists(proposals, "bytes", 1); // synthetic accessor
        proposalExists(proposals, "abs", 0); // DGM
        
        
        proposalExists(proposals, "capitalize", 1); // DGM
        proposalExists(proposals, "digits", 0);  
    }
    // GRECLIPSE-1324
    public void testEmptyClosure2() throws Exception {
        createDsls(
                SET_DELEGATE_ON_INT);
        String contents = "1.foo {\n" + 
                "    to\n" + 
                "}";
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, "\n    "));

        // should see proposals from String, not Integer
        proposalExists(proposals, "toUpperCase()", 1);
        proposalExists(proposals, "toHexString()", 0);
    }
    
    public void testCommandChain1() throws Exception {
        createDsls(COMMAND_CHAIN_NO_ARGS);
        String contents = 
                "class Inner { }\n" +
        		"def val = new Inner()\n" +
        		"val.fla";
        
        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, ".fla"));
        proposalExists(proposals, "flart", 1);
        ICompletionProposal proposal = findFirstProposal(proposals, "flart", false);
        applyProposalAndCheck(doc, proposal, contents.replace("val.fla", "val.flart"));
    }
    
    public void testCommandChain2() throws Exception {
        createDsls(COMMAND_CHAIN_NO_ARGS);
        String contents = 
                "class Inner { }\n" +
                "def val = new Inner()\n" +
                "val.flart foo fl";
        
        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, " fl"));
        proposalExists(proposals, "flart", 1);
        ICompletionProposal proposal = findFirstProposal(proposals, "flart", false);
        applyProposalAndCheck(doc, proposal, contents.replace(" fl", " flart"));
    }
    
    public void testCommandChain3() throws Exception {
        createDsls(COMMAND_CHAIN_NO_ARGS);
        String contents = 
                "class Inner { }\n" +
                "def val = new Inner()\n" +
                "val.flart foo, baz fl";
        
        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, " fl"));
        proposalExists(proposals, "flart", 1);
        ICompletionProposal proposal = findFirstProposal(proposals, "flart", false);
        applyProposalAndCheck(doc, proposal, contents.replace(" fl", " flart"));
    }
    
    public void testCommandChain4() throws Exception {
        createDsls(COMMAND_CHAIN_ONE_ARG);
        String contents = 
                "class Inner { }\n" +
                "def val = new Inner()\n" +
                "val.flart foo, baz fl";
        
        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, " fl"));
        proposalExists(proposals, "flart", 1);
        ICompletionProposal proposal = findFirstProposal(proposals, "flart", false);
        applyProposalAndCheck(doc, proposal, contents.replace(" fl", " flart 0 "));
    }
    
    public void testCommandChain5() throws Exception {
        createDsls(COMMAND_CHAIN_TWO_ARGS);
        String contents = 
                "class Inner { }\n" +
                "def val = new Inner()\n" +
                "val.flart foo, baz fl";
        
        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, " fl"));
        proposalExists(proposals, "flart", 1);
        ICompletionProposal proposal = findFirstProposal(proposals, "flart", false);
        applyProposalAndCheck(doc, proposal, contents.replace(" fl", " flart 0, \"\" "));
    }
    
    public void testDelegatesToNoParens1() throws Exception {
        createDsls(NO_PARENS_FOR_DELEGATE);
        String contents = 
                "class Other {\n" +
                "  def blart(a, b, c) { }\n" +
                "  def flart(a) { }\n" +
                "}\n" +
                "class Inner { }\n" +
                "def val = new Inner()\n" +
                "val.bl";

        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, "val.bl"));
        ICompletionProposal proposal = findFirstProposal(proposals, "blart", false);
        applyProposalAndCheck(doc, proposal, contents.replace("val.bl", "val.blart val, val, val "));
    }
    
    public void testDelegatesToNoParens2() throws Exception {
        createDsls(NO_PARENS_FOR_DELEGATE);
        String contents = 
                "class Other {\n" +
                        "  def blart(a, b, c) { }\n" +
                        "  def flart(a) { }\n" +
                        "}\n" +
                        "class Inner { }\n" +
                        "def val = new Inner()\n" +
                        "val.fl";
        
        Document doc = new Document(contents);
        ICompletionProposal[] proposals = createProposalsAtOffset(contents, getIndexOf(contents, "val.fl"));
        ICompletionProposal proposal = findFirstProposal(proposals, "flart", false);
        applyProposalAndCheck(doc, proposal, contents.replace("val.fl", "val.flart val "));
    }
    
    protected void addJarToProject(String jarName) throws JavaModelException, IOException {
        String externalFilePath = findExternalFilePath(jarName);
        env.addExternalJar(getDefaultProject().getFullPath(), externalFilePath);
    }

    protected String findExternalFilePath(String jarName)
            throws MalformedURLException, IOException {
        URL url = GroovyDSLDTestsActivator.getDefault().getTestResourceURL(jarName);
        URL resolved = FileLocator.resolve(url);
        String externalFilePath = resolved.getFile();
        return externalFilePath;
    }
    
    protected String[] createDsls(String ... dsls) {
        return createDsls(0, dsls);
    }
    protected String[] createDsls(int startWith, String ... dsls) {
        int i = startWith;
        System.out.println("Now creating " + dsls.length + " DSLD files.");
        for (String dsl : dsls) {
            System.out.println("Creating:\n" + dsl + "\n");
            IPath path = env.addFile(getDefaultProject().getFullPath(), "dsl" + i++ + ".dsld", dsl);
            IFile file = env.getWorkspace().getRoot().getFile(path);
            if (!file.exists()) {
                fail("File " + file + " just created, but doesn't exist");
            }
        }
        return dsls;
    }

    protected IProject getDefaultProject() {
        return env.getProject("Project");
    }

    
}
