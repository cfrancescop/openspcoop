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
package org.openspcoop2.core.registry.ws.client.accordocooperazione.all;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-01-26T16:22:36.419+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebService(targetNamespace = "http://www.openspcoop2.org/core/registry/management", name = "AccordoCooperazione")
@XmlSeeAlso({ObjectFactory.class, org.openspcoop2.core.registry.ObjectFactory.class})
public interface AccordoCooperazione {

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "deleteAll", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteAll")
    @WebMethod(action = "deleteAll")
    @ResponseWrapper(localName = "deleteAllResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteAllResponse")
    public long deleteAll() throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "inUse", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "inUse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.InUse")
    @WebMethod(action = "inUse")
    @ResponseWrapper(localName = "inUseResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.InUseResponse")
    public org.openspcoop2.core.registry.ws.client.accordocooperazione.all.UseInfo inUse(
        @WebParam(name = "idAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoCooperazione idAccordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Count")
    @WebMethod(action = "count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.CountResponse")
    public long count(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordocooperazione.all.SearchFilterAccordoCooperazione filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "deleteById", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteById")
    @WebMethod(action = "deleteById")
    @ResponseWrapper(localName = "deleteByIdResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteByIdResponse")
    public void deleteById(
        @WebParam(name = "idAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoCooperazione idAccordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.FindAll")
    @WebMethod(action = "findAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.FindAllResponse")
    public java.util.List<org.openspcoop2.core.registry.AccordoCooperazione> findAll(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordocooperazione.all.SearchFilterAccordoCooperazione filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "exists", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "exists", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Exists")
    @WebMethod(action = "exists")
    @ResponseWrapper(localName = "existsResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.ExistsResponse")
    public boolean exists(
        @WebParam(name = "idAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoCooperazione idAccordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryMultipleResultException_Exception;

    @WebResult(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "get", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Get")
    @WebMethod(action = "get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.GetResponse")
    public org.openspcoop2.core.registry.AccordoCooperazione get(
        @WebParam(name = "idAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoCooperazione idAccordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryMultipleResultException_Exception;

    @RequestWrapper(localName = "delete", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Delete")
    @WebMethod(action = "delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteResponse")
    public void delete(
        @WebParam(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.AccordoCooperazione accordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "updateOrCreate", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.UpdateOrCreate")
    @WebMethod(action = "updateOrCreate")
    @ResponseWrapper(localName = "updateOrCreateResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.UpdateOrCreateResponse")
    public void updateOrCreate(
        @WebParam(name = "oldIdAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoCooperazione oldIdAccordoCooperazione,
        @WebParam(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.AccordoCooperazione accordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "deleteAllByFilter", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteAllByFilter")
    @WebMethod(action = "deleteAllByFilter")
    @ResponseWrapper(localName = "deleteAllByFilterResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.DeleteAllByFilterResponse")
    public long deleteAllByFilter(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordocooperazione.all.SearchFilterAccordoCooperazione filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "idAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "findAllIds", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.FindAllIds")
    @WebMethod(action = "findAllIds")
    @ResponseWrapper(localName = "findAllIdsResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.FindAllIdsResponse")
    public java.util.List<org.openspcoop2.core.registry.IdAccordoCooperazione> findAllIds(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordocooperazione.all.SearchFilterAccordoCooperazione filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "find", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Find")
    @WebMethod(action = "find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.FindResponse")
    public org.openspcoop2.core.registry.AccordoCooperazione find(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordocooperazione.all.SearchFilterAccordoCooperazione filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryMultipleResultException_Exception;

    @RequestWrapper(localName = "create", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Create")
    @WebMethod(action = "create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.CreateResponse")
    public void create(
        @WebParam(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.AccordoCooperazione accordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @RequestWrapper(localName = "update", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.Update")
    @WebMethod(action = "update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordocooperazione.all.UpdateResponse")
    public void update(
        @WebParam(name = "oldIdAccordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoCooperazione oldIdAccordoCooperazione,
        @WebParam(name = "accordoCooperazione", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.AccordoCooperazione accordoCooperazione
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;
}
