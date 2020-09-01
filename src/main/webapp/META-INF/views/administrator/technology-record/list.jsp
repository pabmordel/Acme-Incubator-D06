<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="administrator.technologyRecord.list.label.title" path="title" width="20%"/>
    <acme:list-column code="administrator.technologyRecord.list.label.sector" path="sector" width="20%"/>      
    <acme:list-column code="administrator.technologyRecord.list.label.source" path="source" width="20%"/>       
    <acme:list-column code="administrator.technologyRecord.list.label.stars" path="stars" width="20%"/>       
     
</acme:list>