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
package org.openspcoop2.protocol.manifest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/** <p>Java class for servizi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servizi">
 * 		&lt;sequence>
 * 			&lt;element name="tipi" type="{http://www.openspcoop2.org/protocol/manifest}tipi" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="profilo" type="{http://www.openspcoop2.org/protocol/manifest}profilo" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="funzionalita" type="{http://www.openspcoop2.org/protocol/manifest}funzionalita" minOccurs="0" maxOccurs="1"/>
 * 		&lt;/sequence>
 * 		&lt;attribute name="wsdlDefinitorio" type="{http://www.w3.org/2001/XMLSchema}boolean" use="optional" default="false"/>
 * 		&lt;attribute name="specificaConversazioni" type="{http://www.w3.org/2001/XMLSchema}boolean" use="optional" default="false"/>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servizi", 
  propOrder = {
  	"tipi",
  	"profilo",
  	"funzionalita"
  }
)

@XmlRootElement(name = "servizi")

public class Servizi extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public Servizi() {
  }

  public Long getId() {
    if(this.id!=null)
		return this.id;
	else
		return new Long(-1);
  }

  public void setId(Long id) {
    if(id!=null)
		this.id=id;
	else
		this.id=new Long(-1);
  }

  public Tipi getTipi() {
    return this.tipi;
  }

  public void setTipi(Tipi tipi) {
    this.tipi = tipi;
  }

  public Profilo getProfilo() {
    return this.profilo;
  }

  public void setProfilo(Profilo profilo) {
    this.profilo = profilo;
  }

  public Funzionalita getFunzionalita() {
    return this.funzionalita;
  }

  public void setFunzionalita(Funzionalita funzionalita) {
    this.funzionalita = funzionalita;
  }

  public boolean isWsdlDefinitorio() {
    return this.wsdlDefinitorio;
  }

  public boolean getWsdlDefinitorio() {
    return this.wsdlDefinitorio;
  }

  public void setWsdlDefinitorio(boolean wsdlDefinitorio) {
    this.wsdlDefinitorio = wsdlDefinitorio;
  }

  public boolean isSpecificaConversazioni() {
    return this.specificaConversazioni;
  }

  public boolean getSpecificaConversazioni() {
    return this.specificaConversazioni;
  }

  public void setSpecificaConversazioni(boolean specificaConversazioni) {
    this.specificaConversazioni = specificaConversazioni;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;



  @XmlElement(name="tipi",required=true,nillable=false)
  protected Tipi tipi;

  @XmlElement(name="profilo",required=false,nillable=false)
  protected Profilo profilo;

  @XmlElement(name="funzionalita",required=false,nillable=false)
  protected Funzionalita funzionalita;

  @javax.xml.bind.annotation.XmlSchemaType(name="boolean")
  @XmlAttribute(name="wsdlDefinitorio",required=false)
  protected boolean wsdlDefinitorio = false;

  @javax.xml.bind.annotation.XmlSchemaType(name="boolean")
  @XmlAttribute(name="specificaConversazioni",required=false)
  protected boolean specificaConversazioni = false;

}
