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

package org.openspcoop2.core.config.ws.client.portaapplicativa.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mtom-processor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mtom-processor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request-flow" type="{http://www.openspcoop2.org/core/config/management}mtom-processor-flow" minOccurs="0"/>
 *         &lt;element name="response-flow" type="{http://www.openspcoop2.org/core/config/management}mtom-processor-flow" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mtom-processor", propOrder = {
    "requestFlow",
    "responseFlow"
})
public class MtomProcessor {

    @XmlElement(name = "request-flow")
    protected MtomProcessorFlow requestFlow;
    @XmlElement(name = "response-flow")
    protected MtomProcessorFlow responseFlow;

    /**
     * Gets the value of the requestFlow property.
     * 
     * @return
     *     possible object is
     *     {@link MtomProcessorFlow }
     *     
     */
    public MtomProcessorFlow getRequestFlow() {
        return this.requestFlow;
    }

    /**
     * Sets the value of the requestFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link MtomProcessorFlow }
     *     
     */
    public void setRequestFlow(MtomProcessorFlow value) {
        this.requestFlow = value;
    }

    /**
     * Gets the value of the responseFlow property.
     * 
     * @return
     *     possible object is
     *     {@link MtomProcessorFlow }
     *     
     */
    public MtomProcessorFlow getResponseFlow() {
        return this.responseFlow;
    }

    /**
     * Sets the value of the responseFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link MtomProcessorFlow }
     *     
     */
    public void setResponseFlow(MtomProcessorFlow value) {
        this.responseFlow = value;
    }

}
