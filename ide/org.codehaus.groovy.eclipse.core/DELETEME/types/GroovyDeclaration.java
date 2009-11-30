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
package org.codehaus.groovy.eclipse.core.types;

import org.codehaus.groovy.eclipse.core.model.GroovyProjectFacade;
import org.eclipse.jdt.core.IJavaElement;

/**
 * 
 * 
 * @author empovazan
 * @author andrew
 */
public abstract class GroovyDeclaration implements Modifiers, Comparable {
    public enum Kind { CLASS, MEMBER, LOCAL_VARIABLE, PARAMETER, FIELD, METHOD }
    
    /**
     * Signature is the type signature of classes
     * But it is the qualified name of Properties and Fields
     */
	protected String signature;

	protected String name;

	protected int modifiers;

	private boolean inferred;

	public GroovyDeclaration(String signature, int modifiers, String name) {
		this(signature, modifiers, name, false);
	}
	
	public GroovyDeclaration(String signature, int modifiers, String name, boolean inferred) {
		this.signature = signature;
		this.name = name;
		this.modifiers = modifiers;
		this.inferred = inferred;
	}

	public abstract Kind getType();

	public String getSignature() {
		return signature;
	}

	public String getName() {
		return name;
	}

	public int getModifiers() {
		return modifiers;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		try {
			GroovyDeclaration rhs = (GroovyDeclaration) obj;
			return rhs.getType() == getType() && name.equals(rhs.name)
					&& signature.equals(rhs.signature) && modifiers == rhs.modifiers;
		} catch (ClassCastException e) {
			return false;
		}
	}

	public int hashCode() {
		return (name.hashCode() * signature.hashCode()) + getType().hashCode() + modifiers;
	}
	
	/**
	 * Same as equals(), but does not consider the modifiers
	 * @param rhs
	 * @return
	 */
	public boolean isSimilar(GroovyDeclaration rhs) {
        return similarKinds(rhs) && name.equals(rhs.name)
            && signature.equals(rhs.signature);
	}

    protected boolean similarKinds(GroovyDeclaration rhs) {
        return getType() == rhs.getType();
    }

	/**
	 * Note: this class has a natural ordering that is inconsistent with equals.
	 */
	public int compareTo(Object arg) {
		GroovyDeclaration type = (GroovyDeclaration) arg;
		int current = name.compareTo(type.name);
		if (current == 0) {
		    current = signature.compareTo(type.signature);
		}
		if (current == 0) {
		    if (modifiers < type.modifiers) {
		        current = -1;
		    } else if (modifiers > type.modifiers) {
		        current = 1;
		    } else {
		        current = 0;
		    }
		}
		return current;
	}

	public String toString() {
		return "Type:" + name + " " + signature;
	}
	
	/**
	 * A type is inferred in two ways. Implicit, ie, it is already known. Or after type inference has determined a type.
	 * 
	 * @return
	 */

	public boolean isInferred() {
		return inferred;
	}
	
	public abstract IJavaElement toJavaElement(GroovyProjectFacade project);
}