<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.toolrecord.form.label.title" path="title"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.sector" path="sector"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.inventor" path="inventor"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.description" path="description"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.web" path="web"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.email" path="email"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.source" path="source"/>
	<acme:form-textbox code="anonymous.toolrecord.form.label.stars" path="stars"/>

	
	<acme:form-return code="anonymous.toolrecord.form.button.return"/>
</acme:form>