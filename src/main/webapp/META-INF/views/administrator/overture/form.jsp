<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="administrator.overture.form.label.creationdate" path="creationdate" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="administrator.overture.form.label.title" path="title"/>
	<acme:form-moment code="administrator.overture.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="administrator.overture.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.overture.form.label.intervalmin" path="intervalmin"/>
	<acme:form-textbox code="administrator.overture.form.label.intervalmax" path="intervalmax"/>
	<acme:form-textbox code="administrator.overture.form.label.email" path="email"/>
	
	<acme:form-submit test = "${command == 'create'}"
	code="administrator.overture.form.button.create" 
	action="/administrator/overture/create"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.overture.form.button.update"
	action="/administrator/overture/update"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.overture.form.button.delete"
	action="/administrator/overture/delete"/>
	<acme:form-submit test="${command == 'update'}"
	code="administrator.overture.form.button.update"
	action="/administrator/overture/update"/>
	<acme:form-submit test="${command == 'delete'}"
	code="administrator.overture.form.button.delete"
	action="/administrator/overture/delete"/>
	
	
	<acme:form-return code="administrator.overture.form.button.return"/>
</acme:form>