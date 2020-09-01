<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="authenticated.challenge.form.label.description" path="description"/>
	<acme:form-textbox code="authenticated.challenge.form.label.rookie" path="rookie"/>
	<acme:form-textbox code="authenticated.challenge.form.label.average" path="average"/>
	<acme:form-textbox code="authenticated.challenge.form.label.expert" path="expert"/>
	<acme:form-textbox code="authenticated.challenge.form.label.rookiereward" path="rookiereward"/>
	<acme:form-textbox code="authenticated.challenge.form.label.averagereward" path="averagereward"/>
	<acme:form-textbox code="authenticated.challenge.form.label.expertreward" path="expertreward"/>
	
	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>