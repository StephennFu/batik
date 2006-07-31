/*

   Copyright 2000-2004,2006  The Apache Software Foundation 

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.dom.svg;

import org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue;
import org.apache.batik.anim.values.AnimatableValue;
import org.apache.batik.dom.AbstractDocument;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.dom.util.XMLSupport;
import org.apache.batik.util.SVGTypes;

import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedInteger;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGFilterElement;

/**
 * This class implements {@link SVGFilterElement}.
 *
 * @author <a href="mailto:stephane@hillion.org">Stephane Hillion</a>
 * @version $Id$
 */
public class SVGOMFilterElement
    extends    SVGStylableElement
    implements SVGFilterElement {

    /**
     * The attribute initializer.
     */
    protected final static AttributeInitializer attributeInitializer;
    static {
        attributeInitializer = new AttributeInitializer(4);
        attributeInitializer.addAttribute(XMLSupport.XMLNS_NAMESPACE_URI,
                                          null, "xmlns:xlink",
                                          XLinkSupport.XLINK_NAMESPACE_URI);
        attributeInitializer.addAttribute(XLinkSupport.XLINK_NAMESPACE_URI,
                                          "xlink", "type", "simple");
        attributeInitializer.addAttribute(XLinkSupport.XLINK_NAMESPACE_URI,
                                          "xlink", "show", "other");
        attributeInitializer.addAttribute(XLinkSupport.XLINK_NAMESPACE_URI,
                                          "xlink", "actuate", "onLoad");
    }

    /**
     * The units values.
     */
    protected final static String[] UNITS_VALUES = {
        "",
        SVG_USER_SPACE_ON_USE_VALUE,
        SVG_OBJECT_BOUNDING_BOX_VALUE
    };

    /**
     * Creates a new SVGOMFilterElement object.
     */
    protected SVGOMFilterElement() {
    }

    /**
     * Creates a new SVGOMFilterElement object.
     * @param prefix The namespace prefix.
     * @param owner The owner document.
     */
    public SVGOMFilterElement(String prefix, AbstractDocument owner) {
        super(prefix, owner);
    }

    /**
     * <b>DOM</b>: Implements {@link Node#getLocalName()}.
     */
    public String getLocalName() {
        return SVG_FILTER_TAG;
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getFilterUnits()}.
     */
    public SVGAnimatedEnumeration getFilterUnits() {
        return getAnimatedEnumerationAttribute
            (null, SVG_FILTER_UNITS_ATTRIBUTE, UNITS_VALUES,
             (short)2);
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getPrimitiveUnits()}.
     */
    public SVGAnimatedEnumeration getPrimitiveUnits() {
        return getAnimatedEnumerationAttribute
            (null, SVG_PRIMITIVE_UNITS_ATTRIBUTE, UNITS_VALUES,
             (short)1);
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getX()}.
     */
    public SVGAnimatedLength getX() {
        return getAnimatedLengthAttribute
            (null, SVG_X_ATTRIBUTE, SVG_FILTER_X_DEFAULT_VALUE,
             SVGOMAnimatedLength.HORIZONTAL_LENGTH, false);
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getY()}.
     */
    public SVGAnimatedLength getY() {
        return getAnimatedLengthAttribute
            (null, SVG_Y_ATTRIBUTE, SVG_FILTER_Y_DEFAULT_VALUE,
             SVGOMAnimatedLength.VERTICAL_LENGTH, false);
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getWidth()}.
     */
    public SVGAnimatedLength getWidth() {
        return getAnimatedLengthAttribute
            (null, SVG_WIDTH_ATTRIBUTE, SVG_FILTER_WIDTH_DEFAULT_VALUE,
             SVGOMAnimatedLength.HORIZONTAL_LENGTH, true);
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getHeight()}.
     */
    public SVGAnimatedLength getHeight() {
        return getAnimatedLengthAttribute
            (null, SVG_HEIGHT_ATTRIBUTE, SVG_FILTER_HEIGHT_DEFAULT_VALUE,
             SVGOMAnimatedLength.VERTICAL_LENGTH, true);
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getFilterResX()}.
     */
    public SVGAnimatedInteger getFilterResX() {
        throw new RuntimeException(" !!! TODO: getFilterResX()");
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#getFilterResY()}.
     */
    public SVGAnimatedInteger getFilterResY() {
        throw new RuntimeException(" !!! TODO: getFilterResY()");
    }

    /**
     * <b>DOM</b>: Implements {@link SVGFilterElement#setFilterRes(int,int)}.
     */
    public void setFilterRes(int filterResX, int filterResY) {
        throw new RuntimeException(" !!! TODO: setFilterRes()");
    }

    // SVGURIReference support /////////////////////////////////////////////

    /**
     * <b>DOM</b>: Implements {@link org.w3c.dom.svg.SVGURIReference#getHref()}.
     */
    public SVGAnimatedString getHref() {
        return SVGURIReferenceSupport.getHref(this);
    }

    // SVGExternalResourcesRequired support /////////////////////////////

    /**
     * <b>DOM</b>: Implements {@link
     * org.w3c.dom.svg.SVGExternalResourcesRequired#getExternalResourcesRequired()}.
     */
    public SVGAnimatedBoolean getExternalResourcesRequired() {
        return SVGExternalResourcesRequiredSupport.
            getExternalResourcesRequired(this);
    }

    // SVGLangSpace support //////////////////////////////////////////////////

    /**
     * <b>DOM</b>: Returns the xml:lang attribute value.
     */
    public String getXMLlang() {
        return XMLSupport.getXMLLang(this);
    }

    /**
     * <b>DOM</b>: Sets the xml:lang attribute value.
     */
    public void setXMLlang(String lang) {
        setAttributeNS(XML_NAMESPACE_URI, XML_LANG_QNAME, lang);
    }

    /**
     * <b>DOM</b>: Returns the xml:space attribute value.
     */
    public String getXMLspace() {
        return XMLSupport.getXMLSpace(this);
    }

    /**
     * <b>DOM</b>: Sets the xml:space attribute value.
     */
    public void setXMLspace(String space) {
        setAttributeNS(XML_NAMESPACE_URI, XML_SPACE_QNAME, space);
    }

    /**
     * Returns the AttributeInitializer for this element type.
     * @return null if this element has no attribute with a default value.
     */
    protected AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }

    /**
     * Returns a new uninitialized instance of this object's class.
     */
    protected Node newNode() {
        return new SVGOMFilterElement();
    }

    // ExtendedTraitAccess ///////////////////////////////////////////////////

    /**
     * Returns whether the given XML attribute is animatable.
     */
    public boolean isAttributeAnimatable(String ns, String ln) {
        if (ns == null) {
            if (ln.equals(SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE)
                    || ln.equals(SVG_FILTER_UNITS_ATTRIBUTE)
                    || ln.equals(SVG_PRIMITIVE_UNITS_ATTRIBUTE)
                    || ln.equals(SVG_X_ATTRIBUTE)
                    || ln.equals(SVG_Y_ATTRIBUTE)
                    || ln.equals(SVG_WIDTH_ATTRIBUTE)
                    || ln.equals(SVG_HEIGHT_ATTRIBUTE)
                    || ln.equals(SVG_FILTER_RES_ATTRIBUTE)) {
                return true;
            }
        }
        return super.isAttributeAnimatable(ns, ln);
    }

    /**
     * Returns the type of the given attribute.
     */
    public int getAttributeType(String ns, String ln) {
        if (ns == null) {
            if (ln.equals(SVG_FILTER_UNITS_ATTRIBUTE)
                    || ln.equals(SVG_PRIMITIVE_UNITS_ATTRIBUTE)) {
                return SVGTypes.TYPE_IDENT;
            } else if (ln.equals(SVG_X_ATTRIBUTE)
                    || ln.equals(SVG_Y_ATTRIBUTE)
                    || ln.equals(SVG_WIDTH_ATTRIBUTE)
                    || ln.equals(SVG_HEIGHT_ATTRIBUTE)) {
                return SVGTypes.TYPE_LENGTH;
            } else if (ln.equals(SVG_FILTER_RES_ATTRIBUTE)) {
                return SVGTypes.TYPE_NUMBER_OPTIONAL_NUMBER;
            }
        }
        return super.getAttributeType(ns, ln);
    }

    // AnimationTarget ///////////////////////////////////////////////////////

    /**
     * Gets how percentage values are interpreted by the given attribute.
     */
    protected short getAttributePercentageInterpretation(String ns, String ln) {
        if (ns == null) {
            if (ln.equals(SVG_X_ATTRIBUTE) || ln.equals(SVG_WIDTH_ATTRIBUTE)) {
                return PERCENTAGE_VIEWPORT_WIDTH;
            }
            if (ln.equals(SVG_Y_ATTRIBUTE) || ln.equals(SVG_HEIGHT_ATTRIBUTE)) {
                return PERCENTAGE_VIEWPORT_HEIGHT;
            }
        }
        return super.getAttributePercentageInterpretation(ns, ln);
    }

    /**
     * Updates an attribute value in this target.
     */
    public void updateAttributeValue(String ns, String ln,
                                     AnimatableValue val) {
        if (ns == null) {
            if (ln.equals(SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE)) {
                updateBooleanAttributeValue(getExternalResourcesRequired(),
                                            val);
                return;
            } else if (ln.equals(SVG_FILTER_UNITS_ATTRIBUTE)) {
                updateEnumerationAttributeValue(getFilterUnits(), val);
                return;
            } else if (ln.equals(SVG_PRIMITIVE_UNITS_ATTRIBUTE)) {
                updateEnumerationAttributeValue(getPrimitiveUnits(), val);
                return;
            } else if (ln.equals(SVG_X_ATTRIBUTE)) {
                updateLengthAttributeValue(getX(), val);
                return;
            } else if (ln.equals(SVG_Y_ATTRIBUTE)) {
                updateLengthAttributeValue(getY(), val);
                return;
            } else if (ln.equals(SVG_WIDTH_ATTRIBUTE)) {
                updateLengthAttributeValue(getWidth(), val);
                return;
            } else if (ln.equals(SVG_HEIGHT_ATTRIBUTE)) {
                updateLengthAttributeValue(getHeight(), val);
                return;
            } else if (ln.equals(SVG_FILTER_RES_ATTRIBUTE)) {
                // XXX Needs testing.
                if (val == null) {
                    updateIntegerAttributeValue(getFilterResX(), null);
                    updateIntegerAttributeValue(getFilterResY(), null);
                } else {
                    AnimatableNumberOptionalNumberValue anonv =
                        (AnimatableNumberOptionalNumberValue) val;
                    SVGOMAnimatedInteger ai =
                        (SVGOMAnimatedInteger) getFilterResX();
                    ai.setAnimatedValue(Math.round(anonv.getNumber()));
                    ai = (SVGOMAnimatedInteger) getFilterResY();
                    if (anonv.hasOptionalNumber()) {
                        ai.setAnimatedValue
                            (Math.round(anonv.getOptionalNumber()));
                    } else {
                        ai.setAnimatedValue(Math.round(anonv.getNumber()));
                    }
                }
                return;
            }
        }
        super.updateAttributeValue(ns, ln, val);
    }

    /**
     * Returns the underlying value of an animatable XML attribute.
     */
    public AnimatableValue getUnderlyingValue(String ns, String ln) {
        if (ns == null) {
            if (ln.equals(SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE)) {
                return getBaseValue(getExternalResourcesRequired());
            } else if (ln.equals(SVG_FILTER_UNITS_ATTRIBUTE)) {
                return getBaseValue(getFilterUnits());
            } else if (ln.equals(SVG_PRIMITIVE_UNITS_ATTRIBUTE)) {
                return getBaseValue(getPrimitiveUnits());
            } else if (ln.equals(SVG_X_ATTRIBUTE)) {
                return getBaseValue
                    (getX(), PERCENTAGE_VIEWPORT_WIDTH);
            } else if (ln.equals(SVG_Y_ATTRIBUTE)) {
                return getBaseValue
                    (getY(), PERCENTAGE_VIEWPORT_HEIGHT);
            } else if (ln.equals(SVG_WIDTH_ATTRIBUTE)) {
                return getBaseValue
                    (getWidth(), PERCENTAGE_VIEWPORT_WIDTH);
            } else if (ln.equals(SVG_HEIGHT_ATTRIBUTE)) {
                return getBaseValue
                    (getHeight(), PERCENTAGE_VIEWPORT_HEIGHT);
            } else if (ln.equals(SVG_FILTER_RES_ATTRIBUTE)) {
                return getBaseValue(getFilterResX(), getFilterResY());
            }
        }
        return super.getUnderlyingValue(ns, ln);
    }
}
