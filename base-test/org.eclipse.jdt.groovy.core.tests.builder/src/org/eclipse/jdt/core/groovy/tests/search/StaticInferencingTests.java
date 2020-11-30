/*
 * Copyright 2011 the original author or authors.
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

import junit.framework.Test;

/**
 * Tests various kinds of static references
 * 
 * @author Andrew Eisenberg
 * @created Jun 9, 2011
 */
public class StaticInferencingTests extends AbstractInferencingTest {
    public static Test suite() {
        return buildTestSuite(StaticInferencingTests.class);
    }

    public StaticInferencingTests(String name) {
        super(name);
    }
    
    // Test various ways of accessing class objects
    public void testClassReference1() throws Exception {
        String contents = "String";
        assertType(contents, "java.lang.String");
    }
    public void testClassReference2() throws Exception {
        String contents = "String.class";
        assertType(contents, "java.lang.Class<java.lang.Object<T>>");  // should be String, not object
    }
    public void testClassReference3() throws Exception {
        String contents = "String.getClass()";
        int start = contents.indexOf("getClass");
        int end = start + "getClass".length();
        assertType(contents, start, end, "java.lang.Class<java.lang.Object>");  // should be String, not object
    }
    public void testClassReference4() throws Exception {
        String contents = "String.class.getCanonicalName()";
        int start = contents.indexOf("getCanonicalName");
        int end = start + "getCanonicalName".length();
        assertType(contents, start, end, "java.lang.String");
    }
    public void testClassReference5() throws Exception {
        String contents = "String.class.canonicalName";
        int start = contents.indexOf("canonicalName");
        int end = start + "canonicalName".length();
        assertType(contents, start, end, "java.lang.String");
    }
    
    // Test GRECLIPSE-1079 Accessing the methods/fields on class directly
    public void testClassReference6() throws Exception {
        String contents = "String.getCanonicalName()";
        int start = contents.indexOf("getCanonicalName");
        int end = start + "getCanonicalName".length();
        assertType(contents, start, end, "java.lang.String");
    }
    public void testClassReference7() throws Exception {
        String contents = "String.canonicalName";
        int start = contents.indexOf("canonicalName");
        int end = start + "canonicalName".length();
        assertType(contents, start, end, "java.lang.String");
    }
    public void testClassReference8() throws Exception {
        String contents = "class S { static { getCanonicalName() } }";
        int start = contents.indexOf("getCanonicalName");
        int end = start + "getCanonicalName".length();
        assertType(contents, start, end, "java.lang.String");
    }
    
    // Test GRECLIPSE-855.  Should be able to find the type, but with unknown confidence
    public void testNonStaticReference1() throws Exception {
        String contents = "String.length()";
        int start = contents.indexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "java.lang.String", false);
    }

    public void testNonStaticReference2() throws Exception {
        String contents = "String.length";
        int start = contents.indexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "java.lang.String", false);
    }
    
    public void testNonStaticReference3() throws Exception {
        String contents = "class GGG { int length }\nGGG.length";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "GGG", false);
    }
    
    public void testNonStaticReference4() throws Exception {
        String contents = "class GGG { int length }\nGGG.@length";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "GGG", false);
    }
    
    public void testNonStaticReference5() throws Exception {
        String contents = "class GGG { int length() { } }\nGGG.length()";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "GGG", false);
    }
    
    public void testNonStaticReference6() throws Exception {
        String contents = "class GGG { def length = { } }\nGGG.length()";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "GGG", false);
    }
    
    public void testNonStaticReference7() throws Exception {
        String contents = "class GGG { int length() { } \nstatic {\nlength() } }";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "GGG", false);
    }
    
    public void testNonStaticReference8() throws Exception {
        String contents = "class GGG { def length = { } \nstatic {\nlength() } }";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertUnknownConfidence(contents, start, end, "GGG", false);
    }
    
    public void testStaticReference1() throws Exception {
        String contents = "class GGG { static int length }\nGGG.length";
        int start = contents.lastIndexOf("length");
        int end = start + "length".length();
        assertType(contents, start, end, "java.lang.Integer", false);
    }
    
    public void testStaticImport1() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FOO";
        int start = contents.lastIndexOf("FOO");
        int end = start + "FOO".length();
        assertType(contents, start, end, "java.lang.Integer", false);
    }
    public void testStaticImport2() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FOO as BAR";
        int start = contents.lastIndexOf("FOO");
        int end = start + "FOO".length();
        assertType(contents, start, end, "java.lang.Integer", false);
    }
    public void testStaticImport3() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FOO\nFOO";
        int start = contents.lastIndexOf("FOO");
        int end = start + "FOO".length();
        assertType(contents, start, end, "java.lang.Integer", false);
    }
    public void testStaticImport4() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FOO as BAR\nFOO";
        int start = contents.lastIndexOf("FOO");
        int end = start + "FOO".length();
        assertUnknownConfidence(contents, start, end, "Search", false);
    }
    public void testStaticImport5() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FO";
        int start = contents.lastIndexOf("FO");
        int end = start + "FO".length();
        assertUnknownConfidence(contents, start, end, "Search", false);
    }
    public void testStaticImport6() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.BAR\nBAR";
        int start = contents.indexOf("BAR");
        int end = start + "BAR".length();
        assertType(contents, start, end, "java.lang.Boolean", false);
        start = contents.lastIndexOf("BAR");
        end = start + "BAR".length();
        assertType(contents, start, end, "java.lang.Boolean", false);
    }
    public void testStaticImport7() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FOO\nFOO";
        int start = contents.lastIndexOf("p.Other");
        int end = start + "p.Other".length();
        assertType(contents, start, end, "p.Other", false);
    }
    public void testStaticImport8() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.FOO as BAR\nFOO";
        int start = contents.lastIndexOf("p.Other");
        int end = start + "p.Other".length();
        assertType(contents, start, end, "p.Other", false);
    }
    public void testStaticImport9() throws Exception {
        createUnit("p", "Other", "package p\nclass Other { static int FOO\n static boolean BAR() { } }");
        String contents = "import static p.Other.*\nFOO";
        int start = contents.lastIndexOf("p.Other");
        int end = start + "p.Other".length();
        assertType(contents, start, end, "p.Other", false);
    }
}
