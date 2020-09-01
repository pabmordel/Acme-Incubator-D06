<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="authenticated.activity.list.label.title" path="title" width="20%"/>
    <acme:list-column code="authenticated.activity.list.label.startdate" path="startdate" width="20%"/>     
    <acme:list-column code="authenticated.activity.list.label.enddate" path="enddate" width="20%"/>
    <acme:list-column code="authenticated.activity.list.label.budget" path="budget" width="20%"/>         
        
</acme:list>