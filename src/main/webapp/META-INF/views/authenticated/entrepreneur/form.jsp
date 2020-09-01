<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.entrepreneur.form.label.name" path="name" />
	<acme:form-textbox code="authenticated.entrepreneur.form.label.sector" path="sector" />
	<acme:form-textbox code="authenticated.entrepreneur.form.label.qualification" path="qualification" />
	<acme:form-textbox code="authenticated.entrepreneur.form.label.skills" path="skills" />
	

	<acme:form-submit test="${command == 'create'}" code="authenticated.entrepreneur.form.label.create"
		action="/authenticated/entrepreneur/create" />
	<acme:form-submit test="${command == 'update'}" code="authenticated.investor.form.label.update"
		action="/authenticated/entrepreneur/update" />


	<acme:form-return code="authenticated.entrepreneur.form.button.return" />
</acme:form>
