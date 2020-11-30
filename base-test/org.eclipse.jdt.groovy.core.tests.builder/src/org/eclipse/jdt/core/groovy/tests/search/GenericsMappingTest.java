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
package org.eclipse.jdt.core.groovy.tests.search;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.jdt.groovy.model.GroovyCompilationUnit;

/**
 * Tests for GRECLIPSE-1448
 * @author Andrew Eisenberg
 * @created Jun 28, 2012
 */
public class GenericsMappingTest extends AbstractGroovySearchTest {

    public GenericsMappingTest(String name) {
        super(name);
    }

 
    // GRECLIPSE-1448 unresolved super types should use a redirect.
    // resolved super types should not
    public void testGenericsMapper() throws Exception {
        GroovyCompilationUnit unit = createUnit("Search", "class A { }\nclass B extends A { }\nclass C extends B { }");
        ClassNode classNode = unit.getModuleNode().getClasses().get(2);
        System.out.println(unit.getModuleNode().getClasses().get(2).getUnresolvedSuperClass().isRedirectNode());

        assertEquals("Got the wrong class nodee", "C", classNode.getName());
        
        assertFalse("resolved super types should not be redirects", classNode.getSuperClass().isRedirectNode());
        assertTrue("unresolved super types should be redirects", classNode.getUnresolvedSuperClass().isRedirectNode());
    }
}
