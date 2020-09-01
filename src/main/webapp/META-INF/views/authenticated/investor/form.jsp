<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.investor.form.label.firm" path="firm" />
	<acme:form-textbox code="authenticated.investor.form.label.sector" path="sector" />
	<acme:form-textbox code="authenticated.investor.form.label.profile" path="profile" />
	

	<acme:form-submit test="${command == 'create'}" code="authenticated.investor.form.label.create"
		action="/authenticated/investor/create" />
	<acme:form-submit test="${command == 'update'}" code="authenticated.investor.form.label.update"
		action="/authenticated/investor/update" />


	<acme:form-return code="authenticated.investor.form.button.return" />
</acme:form>
