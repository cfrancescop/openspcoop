/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.registry.AccordoServizioParteSpecifica;


/**
 * <p>Java class for findResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accordoServizioParteSpecifica" type="{http://www.openspcoop2.org/core/registry}accordo-servizio-parte-specifica"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findResponse", propOrder = {
    "accordoServizioParteSpecifica"
})
public class FindResponse {

    @XmlElement(required = true)
    protected AccordoServizioParteSpecifica accordoServizioParteSpecifica;

    /**
     * Gets the value of the accordoServizioParteSpecifica property.
     * 
     * @return
     *     possible object is
     *     {@link AccordoServizioParteSpecifica }
     *     
     */
    public AccordoServizioParteSpecifica getAccordoServizioParteSpecifica() {
        return this.accordoServizioParteSpecifica;
    }

    /**
     * Sets the value of the accordoServizioParteSpecifica property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccordoServizioParteSpecifica }
     *     
     */
    public void setAccordoServizioParteSpecifica(AccordoServizioParteSpecifica value) {
        this.accordoServizioParteSpecifica = value;
    }

}
