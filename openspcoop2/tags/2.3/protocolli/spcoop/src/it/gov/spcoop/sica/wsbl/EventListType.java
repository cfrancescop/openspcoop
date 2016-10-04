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
package it.gov.spcoop.sica.wsbl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** <p>Java class EventListType.
 * 
 * @version $Rev$, $Date$
 * 
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 */

public class EventListType extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  private Long id;


  public EventListType() {
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

  public void addEvent(EventType event) {
    this.event.add(event);
  }

  public EventType getEvent(int index) {
    return this.event.get( index );
  }

  public EventType removeEvent(int index) {
    return this.event.remove( index );
  }

  public List<EventType> getEventList() {
    return this.event;
  }

  public void setEventList(List<EventType> event) {
    this.event=event;
  }

  public int sizeEventList() {
    return this.event.size();
  }

  private static final long serialVersionUID = 1L;

	@Override
	public String serialize(org.openspcoop2.utils.beans.WriteToSerializerType type) throws org.openspcoop2.utils.UtilsException {
		if(type!=null && org.openspcoop2.utils.beans.WriteToSerializerType.JAXB.equals(type)){
			throw new org.openspcoop2.utils.UtilsException("Jaxb annotations not generated");
		}
		else{
			return super.serialize(type);
		}
	}
	@Override
	public String toXml_Jaxb() throws org.openspcoop2.utils.UtilsException {
		throw new org.openspcoop2.utils.UtilsException("Jaxb annotations not generated");
	}

  protected List<EventType> event = new ArrayList<EventType>();

  /**
   * @deprecated Use method getEventList
   * @return List<EventType>
  */
  @Deprecated
  public List<EventType> getEvent() {
  	return this.event;
  }

  /**
   * @deprecated Use method setEventList
   * @param event List<EventType>
  */
  @Deprecated
  public void setEvent(List<EventType> event) {
  	this.event=event;
  }

  /**
   * @deprecated Use method sizeEventList
   * @return lunghezza della lista
  */
  @Deprecated
  public int sizeEvent() {
  	return this.event.size();
  }

  public static final String EVENT = "event";

}