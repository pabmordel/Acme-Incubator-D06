<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="entrepreneur.application.list.label.offer" path="offer" width="20%"/>
    <acme:list-column code="entrepreneur.application.list.label.creationdate" path="creationdate" width="20%"/>   
    <acme:list-column code="entrepreneur.application.list.label.ticket" path="ticket" width="20%"/>  
    <acme:list-column code="entrepreneur.application.list.label.investment" path="investment-title" width="20%"/>
</acme:list>