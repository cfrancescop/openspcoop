/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
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

package org.openspcoop2.core.registry.ws.client.portadominio.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.registry.IdPortaDominio;
import org.openspcoop2.core.registry.PortaDominio;


/**
 * <p>Java class for updateOrCreate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateOrCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldIdPortaDominio" type="{http://www.openspcoop2.org/core/registry}id-porta-dominio"/>
 *         &lt;element name="portaDominio" type="{http://www.openspcoop2.org/core/registry}porta-dominio"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateOrCreate", propOrder = {
    "oldIdPortaDominio",
    "portaDominio"
})
public class UpdateOrCreate {

    @XmlElement(required = true)
    protected IdPortaDominio oldIdPortaDominio;
    @XmlElement(required = true)
    protected PortaDominio portaDominio;

    /**
     * Gets the value of the oldIdPortaDominio property.
     * 
     * @return
     *     possible object is
     *     {@link IdPortaDominio }
     *     
     */
    public IdPortaDominio getOldIdPortaDominio() {
        return this.oldIdPortaDominio;
    }

    /**
     * Sets the value of the oldIdPortaDominio property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdPortaDominio }
     *     
     */
    public void setOldIdPortaDominio(IdPortaDominio value) {
        this.oldIdPortaDominio = value;
    }

    /**
     * Gets the value of the portaDominio property.
     * 
     * @return
     *     possible object is
     *     {@link PortaDominio }
     *     
     */
    public PortaDominio getPortaDominio() {
        return this.portaDominio;
    }

    /**
     * Sets the value of the portaDominio property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortaDominio }
     *     
     */
    public void setPortaDominio(PortaDominio value) {
        this.portaDominio = value;
    }

}
