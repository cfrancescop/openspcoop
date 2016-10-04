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
import java.util.ArrayList;
import java.util.List;


/** <p>Java class for tipi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipi">
 * 		&lt;sequence>
 * 			&lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1" maxOccurs="unbounded"/>
 * 		&lt;/sequence>
 * 		&lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" use="optional"/>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipi", 
  propOrder = {
  	"tipo"
  }
)

@XmlRootElement(name = "tipi")

public class Tipi extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public Tipi() {
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

  public void addTipo(java.lang.String tipo) {
    this.tipo.add(tipo);
  }

  public java.lang.String getTipo(int index) {
    return this.tipo.get( index );
  }

  public java.lang.String removeTipo(int index) {
    return this.tipo.remove( index );
  }

  public List<java.lang.String> getTipoList() {
    return this.tipo;
  }

  public void setTipoList(List<java.lang.String> tipo) {
    this.tipo=tipo;
  }

  public int sizeTipoList() {
    return this.tipo.size();
  }

  public java.lang.String getDefault() {
    return this._default;
  }

  public void setDefault(java.lang.String _default) {
    this._default = _default;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;



  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipo",required=true,nillable=false)
  protected List<java.lang.String> tipo = new ArrayList<java.lang.String>();

  /**
   * @deprecated Use method getTipoList
   * @return List<java.lang.String>
  */
  @Deprecated
  public List<java.lang.String> getTipo() {
  	return this.tipo;
  }

  /**
   * @deprecated Use method setTipoList
   * @param tipo List<java.lang.String>
  */
  @Deprecated
  public void setTipo(List<java.lang.String> tipo) {
  	this.tipo=tipo;
  }

  /**
   * @deprecated Use method sizeTipoList
   * @return lunghezza della lista
  */
  @Deprecated
  public int sizeTipo() {
  	return this.tipo.size();
  }

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlAttribute(name="default",required=false)
  protected java.lang.String _default;

}