<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title"/>
	<acme:form-moment code="administrator.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="administrator.challenge.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.challenge.form.label.rookie" path="rookie"/>
	<acme:form-textbox code="administrator.challenge.form.label.average" path="average"/>
	<acme:form-textbox code="administrator.challenge.form.label.expert" path="expert"/>
	<acme:form-textbox code="administrator.challenge.form.label.rookiereward" path="rookiereward"/>
	<acme:form-textbox code="administrator.challenge.form.label.averagereward" path="averagereward"/>
	<acme:form-textbox code="administrator.challenge.form.label.expertreward" path="expertreward"/>
	
	<acme:form-submit test = "${command == 'create'}"
	code="administrator.challenge.form.button.create" 
	action="/administrator/challenge/create"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.challenge.form.button.update"
	action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'show'}"
	code="administrator.challenge.form.button.delete"
	action="/administrator/challenge/delete"/>
	<acme:form-submit test="${command == 'update'}"
	code="administrator.challenge.form.button.update"
	action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'delete'}"
	code="administrator.challenge.form.button.delete"
	action="/administrator/challenge/delete"/>
	
	<acme:form-return code="administrator.challenge.form.button.return"/>
</acme:form>