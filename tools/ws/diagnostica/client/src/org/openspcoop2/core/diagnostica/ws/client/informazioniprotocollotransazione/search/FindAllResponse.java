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

package org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.diagnostica.InformazioniProtocolloTransazione;


/**
 * <p>Java class for findAllResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findAllResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="informazioniProtocolloTransazione" type="{http://www.openspcoop2.org/core/diagnostica}informazioni-protocollo-transazione" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllResponse", propOrder = {
    "informazioniProtocolloTransazione"
})
public class FindAllResponse {

    protected List<InformazioniProtocolloTransazione> informazioniProtocolloTransazione;

    /**
     * Gets the value of the informazioniProtocolloTransazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informazioniProtocolloTransazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformazioniProtocolloTransazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformazioniProtocolloTransazione }
     * 
     * 
     */
    public List<InformazioniProtocolloTransazione> getInformazioniProtocolloTransazione() {
        if (this.informazioniProtocolloTransazione == null) {
            this.informazioniProtocolloTransazione = new ArrayList<InformazioniProtocolloTransazione>();
        }
        return this.informazioniProtocolloTransazione;
    }

}
