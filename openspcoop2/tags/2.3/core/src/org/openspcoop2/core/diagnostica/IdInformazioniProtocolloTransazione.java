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
package org.openspcoop2.core.diagnostica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.openspcoop2.core.diagnostica.constants.TipoPdD;
import java.io.Serializable;


/** <p>Java class for id-informazioni-protocollo-transazione complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="id-informazioni-protocollo-transazione">
 * 		&lt;attribute name="tipoPdD" type="{http://www.openspcoop2.org/core/diagnostica}TipoPdD" use="required"/>
 * 		&lt;attribute name="identificativo-richiesta" type="{http://www.w3.org/2001/XMLSchema}string" use="required"/>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id-informazioni-protocollo-transazione")

@XmlRootElement(name = "id-informazioni-protocollo-transazione")

public class IdInformazioniProtocolloTransazione extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public IdInformazioniProtocolloTransazione() {
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

  public void set_value_tipoPdD(String value) {
    this.tipoPdD = (TipoPdD) TipoPdD.toEnumConstantFromString(value);
  }

  public String get_value_tipoPdD() {
    if(this.tipoPdD == null){
    	return null;
    }else{
    	return this.tipoPdD.toString();
    }
  }

  public org.openspcoop2.core.diagnostica.constants.TipoPdD getTipoPdD() {
    return this.tipoPdD;
  }

  public void setTipoPdD(org.openspcoop2.core.diagnostica.constants.TipoPdD tipoPdD) {
    this.tipoPdD = tipoPdD;
  }

  public java.lang.String getIdentificativoRichiesta() {
    return this.identificativoRichiesta;
  }

  public void setIdentificativoRichiesta(java.lang.String identificativoRichiesta) {
    this.identificativoRichiesta = identificativoRichiesta;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;



  @XmlTransient
  protected java.lang.String _value_tipoPdD;

  @XmlAttribute(name="tipoPdD",required=true)
  protected TipoPdD tipoPdD;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlAttribute(name="identificativo-richiesta",required=true)
  protected java.lang.String identificativoRichiesta;

}