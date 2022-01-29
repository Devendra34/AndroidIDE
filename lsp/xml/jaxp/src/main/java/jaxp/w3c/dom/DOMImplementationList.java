/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package jaxp.w3c.dom;

/**
 *  The <code>DOMImplementationList</code> interface provides the abstraction
 * of an ordered collection of DOM implementations, without defining or
 * constraining how this collection is implemented. The items in the
 * <code>DOMImplementationList</code> are accessible via an integral index,
 * starting from 0.
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3 Core Specification</a>.
 * @since DOM Level 3
 */
public interface DOMImplementationList {
    /**
     *  Returns the <code>index</code>th item in the collection. If
     * <code>index</code> is greater than or equal to the number of
     * <code>DOMImplementation</code>s in the list, this returns
     * <code>null</code>.
     * @param index Index into the collection.
     * @return  The <code>DOMImplementation</code> at the <code>index</code>
     *   th position in the <code>DOMImplementationList</code>, or
     *   <code>null</code> if that is not a valid index.
     */
    public DOMImplementation item(int index);

    /**
     *  The number of <code>DOMImplementation</code>s in the list. The range
     * of valid child node indices is 0 to <code>length-1</code> inclusive.
     */
    public int getLength();

}
