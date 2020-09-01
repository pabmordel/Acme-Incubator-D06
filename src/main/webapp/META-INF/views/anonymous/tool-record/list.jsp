<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="anonymous.toolrecord.list.label.title" path="title" width="20%"/>
    <acme:list-column code="anonymous.toolrecord.list.label.sector" path="sector" width="20%"/>      
    <acme:list-column code="anonymous.toolrecord.list.label.source" path="source" width="20%"/>       
    <acme:list-column code="anonymous.toolrecord.list.label.stars" path="stars" width="20%"/>       
     
</acme:list>