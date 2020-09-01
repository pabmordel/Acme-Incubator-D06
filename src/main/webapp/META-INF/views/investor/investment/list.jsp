<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="investor.investment.list.label.title" path="title" width="20%"/>
    <acme:list-column code="investor.investment.list.label.creationdate" path="creationdate" width="20%"/>     
    <acme:list-column code="investor.investment.list.label.kind" path="kind" width="20%"/>
    <acme:list-column code="investor.investment.list.label.amount" path="amount" width="20%"/>         
</acme:list>