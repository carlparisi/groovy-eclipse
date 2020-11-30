/*
 * Copyright 2003-2009 the original author or authors.
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
 * 
 * @author Andrew Eisenberg
 * @author Andy Clement
 * @created Sep 10, 2010
 */
public class GenericInferencingTests extends AbstractInferencingTest {

    public static Test suite() {
        return buildTestSuite(GenericInferencingTests.class);
    }

    public GenericInferencingTests(String name) {
        super(name);
    }
    
    public void testEnum1() throws Exception {
        String contents = 
                "Blah<Some> farb\n" + 
        		"farb.something().AA.other\n" + 
        		"enum Some {\n" + 
        		"    AA(List)\n" + 
        		"    public final Class<List<String>> other\n" + 
        		"    public Some(Class<List<String>> other) {\n" + 
        		"        this.other = other\n" + 
        		"    }\n" + 
        		"}\n" + 
        		"class Blah<K> {\n" + 
        		"    K something() {\n" + 
        		"    }\n" + 
        		"}";
        
        int start = contents.indexOf("other");
        int end = start + "other".length();
        assertType(contents, start, end, "java.lang.Class<java.util.List<java.lang.String>>");
        
    }

    public void testList1() throws Exception {
        assertType("new LinkedList<String>()", "java.util.LinkedList<java.lang.String>");
    }
    
    public void testList2() throws Exception {
        String contents ="def x = new LinkedList<String>()\nx";
        int start = contents.lastIndexOf("x");
        int end = start + "x".length();
        assertType(contents, start, end, "java.util.LinkedList<java.lang.String>");
    }
    
    public void testList3() throws Exception {
        String contents ="def x = [ '' ]\nx";
        int start = contents.lastIndexOf("x");
        int end = start + "x".length();
        assertType(contents, start, end, "java.util.List<java.lang.String>");
    }
    
    public void testList4() throws Exception {
        String contents ="def x = [ 1 ]\nx";
        int start = contents.lastIndexOf("x");
        int end = start + "x".length();
        assertType(contents, start, end, "java.util.List<java.lang.Integer>");
    }
    
    public void testList5() throws Exception {
        String contents = "[ 1 ].get(0)";
        String toFind = "get";
        int start = contents.indexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testList6() throws Exception {
        String contents = "[ 1 ].iterator()";
        String toFind = "iterator";
        int start = contents.indexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Iterator<java.lang.Integer>");
    }
    
    public void testList7() throws Exception {
        String contents = "[ 1 ].iterator().next()";
        String toFind = "next";
        int start = contents.indexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    // GRECLIPSE-1040
    public void testList8() throws Exception {
        String contents = "def x = new LinkedList()\nx";
        String toFind = "x";
        int start = contents.indexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.LinkedList");
    }

    // GRECLIPSE-1040
    public void testSet1() throws Exception {
        String contents = "def x = new HashSet()\nx";
        String toFind = "x";
        int start = contents.indexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.HashSet");
    }
    
    
    public void testMap1() throws Exception {
        String contents = "new HashMap<String,Integer>()";
        assertType(contents, "java.util.HashMap<java.lang.String,java.lang.Integer>");
    }
        
    public void testMap2() throws Exception {
        String contents = "def x = new HashMap<String,Integer>()\nx";
        String toFind = "x";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.HashMap<java.lang.String,java.lang.Integer>");
    }
    
    public void testMap3() throws Exception {
        String contents = "def x = new HashMap<String,Integer>()\nx.entrySet";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.String,java.lang.Integer>>");
    }
    
    public void testMap3a() throws Exception {
        String contents = "Map<String,Integer> x\nx.entrySet().iterator().next().value";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.String,java.lang.Integer>>");
    }
    
    public void testMap4() throws Exception {
        String contents = "def x = new HashMap<String,Integer>()\nx.entrySet().iterator().next().key";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String");
    }
    
    public void testMap5() throws Exception {
        String contents = "def x = new HashMap<String,Integer>()\nx.entrySet().iterator().next().value";
        String toFind = "value";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testMap6() throws Exception {
        String contents = "Map<String,Integer> x\nx.entrySet().iterator().next().value";
        String toFind = "value";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }

    public void testMap7() throws Exception {
        String contents = "[ 1:1 ]";
        assertType(contents, "java.util.Map<java.lang.Integer,java.lang.Integer>");
    }
    
    public void testMap8() throws Exception {
        String contents = "[ 1:1 ].entrySet()";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.Integer,java.lang.Integer>>");
    }
    

    public void testMap9() throws Exception {
        String contents = "Map<Integer, Integer> x() { }\ndef f = x()\nf";
        String toFind = "f";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.lang.Integer,java.lang.Integer>");
    }

    // GRECLIPSE-1040
    public void testMap10() throws Exception {
        String contents = "new HashMap()";
        assertType(contents, "java.util.HashMap");
    }

    
    public void testMapOfList() throws Exception {
        String contents = "Map<String,List<Integer>> x\nx.entrySet().iterator().next().value";
        String toFind = "value";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.List<java.lang.Integer>");
    }
    
    public void testMapOfList2() throws Exception {
        String contents = "Map<String,List<Integer>> x\nx.entrySet().iterator().next().value.iterator().next()";
        String toFind = "next";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    // GRECLIPSE-941
    public void testMapOfList4() throws Exception {
        String contents = "Map<String, Map<Integer, List<Date>>> dataTyped\ndef x = dataTyped      ['foo'][5][2]\nx";
        String toFind = "x";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Date");
    }
    
    public void testArray1() throws Exception {
        String contents = "def x = [ 1, 2 ] as String[]\nx";
        String toFind = "x";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String[]");
    }

    public void testArray2() throws Exception {
        String contents = "def x = [ 1, 2 ] as String[]\nx[0].length";
        String toFind = "length";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }

    // not passing yet since the correct version of DefaultGroovyMethods.iterator() is not being chosen
    public void _testArray3() throws Exception {
        String contents = "def x = [ 1, 2 ] as String[]\nx.iterator()";
        String toFind = "iterator";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Iterator<java.lang.String>");
    }

    
    private static final String XX = "class XX {\nXX[] xx\nXX yy\n}";
    public void testArray4() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().xx";
        String toFind = "xx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX[]");
    }

    public void testArray5() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().xx[0].yy";
        String toFind = "yy";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX");
    }
    
    public void testArray6() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().xx[new XX()].yy";
        String toFind = "yy";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX");
    }
    
    public void testArray7() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().xx[0].yy";
        String toFind = "yy";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX");
    }
    public void testArray8() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().xx[0].xx[9].yy";
        String toFind = "yy";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX");
    }
    
    public void testArray9() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().getXx()[0].xx[9].yy";
        String toFind = "yy";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX");
    }
    
    public void testArray10() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().getXx()[0].getYy()";
        String toFind = "getYy";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX");
    }
    
    public void testArray11() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().getXx()";
        String toFind = "getXx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX[]");
    }
    
    public void testArray12() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().getXx()[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx";
        String toFind = "xx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX[]");
    }
    
    public void testArray13() throws Exception {
        createUnit("XX", XX);
        String contents = "new XX().getYy().getYy().getYy().getYy().getYy().getYy().getYy().getYy().getXx()[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx[0].xx";
        String toFind = "xx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "XX[]");
    }
    
    
    
    public void testMapOfList3() throws Exception {
        String contents = "def x = [1: [1]]\nx.entrySet().iterator().next().key";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    
    // not working yet since our approach to determining the type of a map only looks at the static types of the
    // first elements.  It does not try to infer the type of these elements.
    public void _testMapOfList4() throws Exception {
        String contents = "def x = [1: [1]]\nx.entrySet().iterator().next().value.iterator().next()";
        String toFind = "next";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }

    public void testMapOfList5() throws Exception {
        String contents = "def x = [1: [1]]\nx.entrySet().iterator().next().value.iterator().next()";
        String toFind = "next";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }

    public void testForLoop1() throws Exception {
        String contents = "def x = 1..4\nfor (a in x) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop2() throws Exception {
        String contents = "for (a in 1..4) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop3() throws Exception {
        String contents = "for (a in [1, 2].iterator()) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop4() throws Exception {
        String contents = "for (a in (1..4).iterator()) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop5() throws Exception {
        String contents = "for (a in [1 : 1]) { \na.key }";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop6() throws Exception {
        String contents = "for (a in [1 : 1]) { \na.value }";
        String toFind = "value";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop7() throws Exception {
        String contents = "InputStream x\nfor (a in x) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Byte");
    }
    
    public void testForLoop8() throws Exception {
        String contents = "DataInputStream x\nfor (a in x) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Byte");
    }
    
    public void testForLoop9() throws Exception {
        String contents = "Integer[] x\nfor (a in x) { \na }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testForLoop10() throws Exception {
        String contents = "class X {\n"
                + "List<String> images\n" + "}\n"
                + "def sample = new X()\n" + "for (img in sample.images) {\n"
                + "    img\n" + "}";
        String toFind = "img";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String");
    }
    
    
    public void testForLoop11() throws Exception {
        // @formatter:off
        String contents = 
            "class X {\n" + 
            " public void m() {\n" + 
            "  List<String> ls = new ArrayList<String>();\n" +
            "  for (foo in ls) {\n" + 
            "   foo\n" + 
            "  }\n" + 
            " }\n" +
            "}\n";
        // @formatter:on
        String toFind = "foo";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String");
    }
    // all testing for GRECLIPSE-833
    public void testDGMClosure1() throws Exception {
        String contents = "[''].each { it }";
        String toFind = "it";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String");
    }
    public void testDGMClosure2() throws Exception {
        String contents = "[''].reverseEach { val -> val }";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String");
    }
    public void testDGMClosure3() throws Exception {
        String contents = "(1..4).find { it }";
        String toFind = "it";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    public void testDGMClosure4() throws Exception {
        String contents = "['a':1].unique { it.key }";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.String");
    }
    public void testDGMClosure5() throws Exception {
        String contents = "['a':1].collect { it.value }";
        String toFind = "value";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    // Integer is explicit, so should use that as a type
    public void testDGMClosure7() throws Exception {
        String contents = "[''].reverseEach { Integer val -> val }";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    // Integer is explicit, so should use that as a type
    public void testDGMClosure8() throws Exception {
        String contents = "[''].reverseEach { Integer it -> it }";
        String toFind = "it";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    public void testDGMClosure9() throws Exception {
        String contents = "[new Date()].eachWithIndex { val, i -> val }";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Date");
    }
    
    public void testDGMClosure10() throws Exception {
        String contents = "[''].eachWithIndex { val, i -> i }";
        String toFind = "i";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure11() throws Exception {
        String contents = "[1:new Date()].eachWithIndex { key, val, i -> val }";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Date");
    }
    
    public void testDGMClosure12() throws Exception {
        String contents = "[1:new Date()].eachWithIndex { key, val, i -> key }";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure13() throws Exception {
        String contents = "[1:new Date()].eachWithIndex { key, val, i -> i }";
        String toFind = "i";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure14() throws Exception {
        String contents = "[1:new Date()].each { key, val -> key }";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure15() throws Exception {
        String contents = "[1:new Date()].each { key, val -> val }";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Date");
    }
    
    public void testDGMClosure16() throws Exception {
        String contents = "[1:new Date()].collect { key, val -> key }";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure17() throws Exception {
        String contents = "[1:new Date()].collect { key, val -> val }";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Date");
    }
    
    public void testDGMClosure18() throws Exception {
        String contents = "[1].inject { a, b -> a }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure19() throws Exception {
        String contents = "[1].inject { a, b -> b }";
        String toFind = "b";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure20() throws Exception {
        String contents = "[1].unique { a, b -> b }";
        String toFind = "b";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure21() throws Exception {
        String contents = "[1].unique { a, b -> a }";
        String toFind = "a";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testDGMClosure22() throws Exception {
        String contents = "[1f: 1d].collectEntries { key, value -> [value, key] } ";
        String toFind = "value";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Double");
    }
    
    public void testDGMClosure23() throws Exception {
        String contents = "[1f: 1d].collectEntries { key, value -> [value, key] } ";
        String toFind = "key";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Float");
    }
    
    
    
    // See GRECLIPSE-997
    public void testNestedGenerics1() throws Exception {
        String contents = "class MyMap extends HashMap<String,Class> { }\n" +
        		"MyMap m\n" +
        		"m.get()";
        String toFind = "get";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Class");
    }
    
    // See GRECLIPSE-997
    public void testNestedGenerics2() throws Exception {
        String contents = "class MyMap extends HashMap<String,Class> { }\n" +
                "MyMap m\n" +
                "m.entrySet()";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.String,java.lang.Class>>");
    }
    
    // See GRECLIPSE-997
    public void testNestedGenerics3() throws Exception {
        String contents = "import java.lang.ref.WeakReference\n" +
        		"class MyMap<K,V> extends HashMap<K,WeakReference<V>>{ }\n" +
        "MyMap<String,Class> m\n" +
        "m.entrySet()";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.String,java.lang.ref.WeakReference<java.lang.Class>>>");
    }
    // See GRECLIPSE-997
    public void testNestedGenerics4() throws Exception {
        String contents = "import java.lang.ref.WeakReference\n" +
        "class MyMap<K,V> extends HashMap<K,WeakReference<V>>{ }\n" +
        "class MySubMap extends MyMap<String,Class>{ }\n" +
        "MySubMap m\n" +
        "m.entrySet()";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.String,java.lang.ref.WeakReference<java.lang.Class>>>");
    }
    
    // See GRECLIPSE-997
    public void testNestedGenerics5() throws Exception {
        String contents = "import java.lang.ref.WeakReference\n" +
        "class MyMap<K,V> extends HashMap<K,WeakReference<V>>{ }\n" +
        "class MySubMap<L> extends MyMap<String,Class>{ \n" +
        "  Map<L,Class> val\n" +
        "}\n" +
        "MySubMap<Integer> m\n" +
        "m.val";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.lang.Integer,java.lang.Class>");
    }
    
    // See GRECLIPSE-997
    public void testNestedGenerics6() throws Exception {
        String contents = "import java.lang.ref.WeakReference\n" +
        "class MyMap<K,V> extends HashMap<K,WeakReference<List<K>>>{ }\n" +
        "class MySubMap extends MyMap<String,Class>{ }\n" +
        "MySubMap m\n" +
        "m.entrySet()";
        String toFind = "entrySet";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Set<java.util.Map$Entry<java.lang.String,java.lang.ref.WeakReference<java.util.List<java.lang.String>>>>");
    }

    // See GRECLIPSE-997
    public void testNestedGenerics7() throws Exception {
        String contents = "class MyMap<K,V> extends HashMap<V,K>{ }\n" +
        "MyMap<Integer,Class> m\n" +
        "m.get";
        String toFind = "get";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }

    // See GRECLIPSE-997
    public void testNestedGenerics8() throws Exception {
        String contents = "class MyMap<K,V> extends HashMap<K,V>{\n" +
        		"Map<V,Class<K>> val}\n" +
        "MyMap<Integer,Class> m\n" +
        "m.val";
        String toFind = "val";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.lang.Class,java.lang.Class<java.lang.Integer>>");
    }
    
    // See GRECLIPSE-1131
    public void testEachOnNonIterables1() throws Exception {
        String contents = "1.each { it }";
        String toFind = "it";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    // See GRECLIPSE-1131
    public void testEachOnNonIterables2() throws Exception {
        String contents = "each { it }";
        String toFind = "it";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "Search");
    }
    // See GRECLIPSE-1131
    public void testEachOnNonIterables3() throws Exception {
        String contents = "1.reverseEach { it }";
        String toFind = "it";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.lang.Integer");
    }
    
    public void testInferringList1() throws Exception {
        String contents = "def x = 9\ndef xxx = [x]\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.List<java.lang.Integer>");
    }
    public void testInferringList2() throws Exception {
        String contents = "def x = 9\ndef xxx = [x, '']\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.List<java.lang.Integer>");
    }
    public void testInferringList3() throws Exception {
        String contents = "def x = 9\ndef xxx = [x+9*8, '']\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.List<java.lang.Integer>");
    }
    public void testInferringRange1() throws Exception {
        String contents = "def x = 9\ndef xxx = x..x\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "groovy.lang.Range<java.lang.Integer>");
    }
    public void testInferringRange2() throws Exception {
        String contents = "def x = 9\ndef xxx = (x*1)..x\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "groovy.lang.Range<java.lang.Integer>");
    }
    public void testInferringMap1() throws Exception {
        String contents = "def x = 9\ndef y = false\ndef xxx = [(x):y]\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.lang.Integer,java.lang.Boolean>");
    }
    public void testInferringMap2() throws Exception {
        String contents = "def x = 9\ndef y = false\ndef xxx = [(x+x):!y]\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.lang.Integer,java.lang.Boolean>");
    }
    public void testInferringMap3() throws Exception {
        String contents = "def x = 9\ndef y = false\ndef xxx = [(x+x):!y, a:'a', b:'b']\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.lang.Integer,java.lang.Boolean>");
    }
    public void testInferringMap4() throws Exception {
        String contents = "def x = 9\ndef y = false\ndef xxx = [[(x+x):!y, a:'a', b:'b']]\nxxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.List<java.util.Map<java.lang.Integer,java.lang.Boolean>>");
    }
    public void testInferringMap5() throws Exception {
        String contents = "def x = [ ['a':11, 'b':12] : ['a':21, 'b':22] ]\n" + 
        		"def xxx = x\n" +
        		"xxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.Map<java.util.Map<java.lang.String,java.lang.Integer>,java.util.Map<java.lang.String,java.lang.Integer>>");
    }
    
    public void testInferringMap6() throws Exception {
        String contents = "def x = [ ['a':11, 'b':12], ['a':21, 'b':22] ]\n" + 
                "def xxx = x*.a\n" +
                "xxx";
        String toFind = "xxx";
        int start = contents.lastIndexOf(toFind);
        int end = start + toFind.length();
        assertType(contents, start, end, "java.util.List<java.lang.Integer>");
    }
/*
class O {
  def  aa
  def bb
}

new O([8: 1, bb:8])

def h = [8: 1, bb:8]
*/
    // this next section is not really generic inferencing, but it does involve maps, so I'll put it here
    // GRECLIPSE-1229 constructors with map parameters
    public void testConstructor1() throws Exception {
        String contents = 
                "class O {\n" + 
        		"  boolean aa\n" + 
        		"  int bb\n" + 
        		"}\n" + 
        		"new O(aa: 1, bb:8)";
        int start = contents.lastIndexOf("aa");
        int end = start + "aa".length();
        assertType(contents, start, end, "java.lang.Boolean");
        assertDeclaration(contents, start, end, "O", "aa", DeclarationKind.FIELD);
        start = contents.lastIndexOf("bb");
        end = start + "bb".length();
        assertType(contents, start, end, "java.lang.Integer");
        assertDeclaration(contents, start, end, "O", "bb", DeclarationKind.FIELD);
    }
    public void testConstructor2() throws Exception {
        String contents = 
                "class O {\n" + 
                "  boolean aa\n" + 
                "  int bb\n" + 
                "}\n" + 
                "new O([aa: 1, bb:8])";
        int start = contents.lastIndexOf("aa");
        int end = start + "aa".length();
        assertType(contents, start, end, "java.lang.Boolean");
        assertDeclaration(contents, start, end, "O", "aa", DeclarationKind.FIELD);
        start = contents.lastIndexOf("bb");
        end = start + "bb".length();
        assertType(contents, start, end, "java.lang.Integer");
        assertDeclaration(contents, start, end, "O", "bb", DeclarationKind.FIELD);
    }
    public void testConstructor3() throws Exception {
        String contents = 
                "class O {\n" + 
                "  boolean aa\n" + 
                "  int bb\n" + 
                "}\n" + 
                "new O([8: 1, bb:8])";
        int start = contents.lastIndexOf("bb");
        int end = start + "bb".length();
        assertType(contents, start, end, "java.lang.Integer");
        assertDeclaration(contents, start, end, "O", "bb", DeclarationKind.FIELD);
    }
    public void testConstructor4() throws Exception {
        String contents = 
                "class O {\n" + 
                "  boolean aa\n" + 
                "  int bb\n" + 
                "}\n" + 
                "new O([aa: 1, bb:8], 9)";
        int start = contents.lastIndexOf("aa");
        int end = start + "aa".length();
        assertType(contents, start, end, "java.lang.String");
        assertDeclaringType(contents, start, end, "null");
        start = contents.lastIndexOf("bb");
        end = start + "bb".length();
        assertType(contents, start, end, "java.lang.String");
        assertDeclaringType(contents, start, end, "null");
    }
    public void testConstructor5() throws Exception {
        String contents = 
                "class O {\n" + 
                "  boolean aa\n" + 
                "  int bb\n" + 
                "}\n" + 
                "new O(9, [aa: 1, bb:8])";
        int start = contents.lastIndexOf("aa");
        int end = start + "aa".length();
        assertType(contents, start, end, "java.lang.String");
        assertDeclaringType(contents, start, end, "null");
        start = contents.lastIndexOf("bb");
        end = start + "bb".length();
        assertType(contents, start, end, "java.lang.String");
        assertDeclaringType(contents, start, end, "null");
    }
    public void testConstructor6() throws Exception {
        String contents = 
                "class O {\n" + 
                "  boolean aa\n" + 
                "  int bb\n" + 
                "}\n" + 
                "def g = [aa: 1, bb:8]";
        int start = contents.lastIndexOf("aa");
        int end = start + "aa".length();
        assertType(contents, start, end, "java.lang.String");
        assertDeclaringType(contents, start, end, "null");
        start = contents.lastIndexOf("bb");
        end = start + "bb".length();
        assertType(contents, start, end, "java.lang.String");
        assertDeclaringType(contents, start, end, "null");
    }
}
