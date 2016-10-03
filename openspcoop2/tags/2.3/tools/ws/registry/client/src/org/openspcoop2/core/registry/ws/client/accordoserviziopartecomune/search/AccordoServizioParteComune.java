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
package org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-01-26T16:23:46.421+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebService(targetNamespace = "http://www.openspcoop2.org/core/registry/management", name = "AccordoServizioParteComune")
@XmlSeeAlso({ObjectFactory.class, org.openspcoop2.core.registry.ObjectFactory.class})
public interface AccordoServizioParteComune {

    @WebResult(name = "exists", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "exists", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.Exists")
    @WebMethod(action = "exists")
    @ResponseWrapper(localName = "existsResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.ExistsResponse")
    public boolean exists(
        @WebParam(name = "idAccordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoServizioParteComune idAccordoServizioParteComune
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryMultipleResultException_Exception;

    @WebResult(name = "inUse", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "inUse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.InUse")
    @WebMethod(action = "inUse")
    @ResponseWrapper(localName = "inUseResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.InUseResponse")
    public org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.UseInfo inUse(
        @WebParam(name = "idAccordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoServizioParteComune idAccordoServizioParteComune
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "accordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "get", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.Get")
    @WebMethod(action = "get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.GetResponse")
    public org.openspcoop2.core.registry.AccordoServizioParteComune get(
        @WebParam(name = "idAccordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.IdAccordoServizioParteComune idAccordoServizioParteComune
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryMultipleResultException_Exception;

    @WebResult(name = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "count", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.Count")
    @WebMethod(action = "count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.CountResponse")
    public long count(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.SearchFilterAccordoServizioParteComune filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "accordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.FindAll")
    @WebMethod(action = "findAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.FindAllResponse")
    public java.util.List<org.openspcoop2.core.registry.AccordoServizioParteComune> findAll(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.SearchFilterAccordoServizioParteComune filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "idAccordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "findAllIds", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.FindAllIds")
    @WebMethod(action = "findAllIds")
    @ResponseWrapper(localName = "findAllIdsResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.FindAllIdsResponse")
    public java.util.List<org.openspcoop2.core.registry.IdAccordoServizioParteComune> findAllIds(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.SearchFilterAccordoServizioParteComune filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception;

    @WebResult(name = "accordoServizioParteComune", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
    @RequestWrapper(localName = "find", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.Find")
    @WebMethod(action = "find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://www.openspcoop2.org/core/registry/management", className = "org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.FindResponse")
    public org.openspcoop2.core.registry.AccordoServizioParteComune find(
        @WebParam(name = "filter", targetNamespace = "http://www.openspcoop2.org/core/registry/management")
        org.openspcoop2.core.registry.ws.client.accordoserviziopartecomune.search.SearchFilterAccordoServizioParteComune filter
    ) throws RegistryNotAuthorizedException_Exception, RegistryNotFoundException_Exception, RegistryServiceException_Exception, RegistryNotImplementedException_Exception, RegistryMultipleResultException_Exception;
}
