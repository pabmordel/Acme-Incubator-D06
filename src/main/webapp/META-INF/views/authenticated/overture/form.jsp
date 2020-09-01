<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.overture.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.overture.form.label.creationdate" path="creationdate"/>
	<acme:form-moment code="authenticated.overture.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="authenticated.overture.form.label.description" path="description"/>
	<acme:form-textbox code="authenticated.overture.form.label.intervalmin" path="intervalmin"/>
	<acme:form-textbox code="authenticated.overture.form.label.intervalmax" path="intervalmax"/>
	<acme:form-textbox code="authenticated.overture.form.label.email" path="email"/>
	
	<acme:form-return code="authenticated.overture.form.button.return"/>
</acme:form>