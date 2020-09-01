<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly = "true">
	
	<acme:form-textbox code="investor.investment.form.label.title" path="title"/>
	<acme:form-textbox code="investor.investment.form.label.ticket" path="ticket" placeholder="XXX-00-000000"/>
	<acme:form-moment code="investor.investment.form.label.creationdate" path="creationdate"/>
	<acme:form-textbox code="investor.investment.form.label.mode" path="mode"/>
	<acme:form-textbox code="investor.investment.form.label.kind" path="kind"/>
	<acme:form-textarea code="investor.investment.form.label.description" path="description"/>
	<acme:form-money code="investor.investment.form.label.amount" path="amount"/>
	<acme:form-url code="investor.investment.form.label.link" path="link"/>

		<acme:form-submit method="get" code="investor.investment.form.label.programme"
		action="/authenticated/activity/list?id=${id}" />
	

		<acme:form-submit method="get" code="investor.investment.form.label.createapplication"
		action="/investor/application/create?id=${id}" />

	
	<br/><br/>
	
	
	<acme:form-return code="entrepreneur.investment.form.button.return"/>
</acme:form>