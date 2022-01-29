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

package jaxp.w3c.dom.css;

/**
 *  The <code>Counter</code> interface is used to represent any counter or
 * counters function value. This interface reflects the values in the
 * underlying style property.
 * <p>See also the <a href='http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113'>Document Object Model (DOM) Level 2 Style Specification</a>.
 * @since DOM Level 2
 */
public interface Counter {
    /**
     *  This attribute is used for the identifier of the counter.
     */
    public String getIdentifier();

    /**
     *  This attribute is used for the style of the list.
     */
    public String getListStyle();

    /**
     *  This attribute is used for the separator of the nested counters.
     */
    public String getSeparator();

}
