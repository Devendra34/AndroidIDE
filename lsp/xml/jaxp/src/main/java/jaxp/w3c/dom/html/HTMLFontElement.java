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

package jaxp.w3c.dom.html;

/**
 *  Local change to font. See the  FONT element definition in HTML 4.0. This
 * element is deprecated in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLFontElement extends HTMLElement {
    /**
     *  Font color. See the  color attribute definition in HTML 4.0. This
     * attribute is deprecated in HTML 4.0.
     */
    public String getColor();
    public void setColor(String color);

    /**
     *  Font face identifier. See the  face attribute definition in HTML 4.0.
     * This attribute is deprecated in HTML 4.0.
     */
    public String getFace();
    public void setFace(String face);

    /**
     *  Font size. See the  size attribute definition in HTML 4.0. This
     * attribute is deprecated in HTML 4.0.
     */
    public String getSize();
    public void setSize(String size);

}
