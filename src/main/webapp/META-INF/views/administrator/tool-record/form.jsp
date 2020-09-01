<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.toolrecord.form.label.title" path="title"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.inventor" path="inventor"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.web" path="web"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.email" path="email"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.source" path="source"/>
	<acme:form-textbox code="administrator.toolrecord.form.label.stars" path="stars"/>

	<acme:form-submit test = "${command == 'create'}"
	code="administrator.toolrecord.form.button.create" 
	action="/administrator/tool-record/create"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.toolrecord.form.button.update"
	action="/administrator/tool-record/update"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.toolrecord.form.button.delete"
	action="/administrator/tool-record/delete"/>
	<acme:form-submit test="${command == 'update'}"
	code="administrator.toolrecord.form.button.update"
	action="/administrator/tool-record/update"/>
	<acme:form-submit test="${command == 'delete'}"
	code="administrator.toolrecord.form.button.delete"
	action="/administrator/tool-record/delete"/>
	
	<acme:form-return code="administrator.toolrecord.form.button.return"/>
</acme:form>