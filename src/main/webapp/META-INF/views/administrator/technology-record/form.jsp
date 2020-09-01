<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.technologyrecord.form.label.title" path="title"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.inventor" path="inventor"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.web" path="web"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.email" path="email"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.source" path="source"/>
	<acme:form-textbox code="administrator.technologyrecord.form.label.stars" path="stars"/>

	<acme:form-submit test = "${command == 'create'}"
	code="administrator.technologyrecord.form.button.create" 
	action="/administrator/technology-record/create"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.technologyrecord.form.button.update"
	action="/administrator/technology-record/update"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.technologyrecord.form.button.delete"
	action="/administrator/technology-record/delete"/>
	<acme:form-submit test="${command == 'update'}"
	code="administrator.technologyrecord.form.button.update"
	action="/administrator/technology-record/update"/>
	<acme:form-submit test="${command == 'delete'}"
	code="administrator.technologyrecord.form.button.delete"
	action="/administrator/technology-record/delete"/>
	
	<acme:form-return code="administrator.technologyrecord.form.button.return"/>
</acme:form>