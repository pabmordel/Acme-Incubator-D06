<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="administrator.inquiry.form.label.creationdate" path="creationdate" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="administrator.inquiry.form.label.title" path="title"/>
	<acme:form-moment code="administrator.inquiry.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="administrator.inquiry.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.inquiry.form.label.intervalmin" path="intervalmin"/>
	<acme:form-textbox code="administrator.inquiry.form.label.intervalmax" path="intervalmax"/>
	<acme:form-textbox code="administrator.inquiry.form.label.email" path="email"/>
	
	<acme:form-submit test = "${command == 'create'}"
	code="administrator.inquiry.form.button.create" 
	action="/administrator/inquiry/create"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.inquiry.form.button.update"
	action="/administrator/inquiry/update"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.inquiry.form.button.delete"
	action="/administrator/inquiry/delete"/>
	<acme:form-submit test="${command == 'update'}"
	code="administrator.inquiry.form.button.update"
	action="/administrator/inquiry/update"/>
	<acme:form-submit test="${command == 'delete'}"
	code="administrator.inquiry.form.button.delete"
	action="/administrator/inquiry/delete"/>
	
	
	<acme:form-return code="administrator.inquiry.form.button.return"/>
</acme:form>