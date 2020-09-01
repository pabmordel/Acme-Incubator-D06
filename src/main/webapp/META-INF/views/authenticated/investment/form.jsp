<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.investment.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.investment.form.label.ticket" path="ticket"/>
	<acme:form-moment code="authenticated.investment.form.label.creationdate" path="creationdate"/>
	<acme:form-textbox code="authenticated.investment.form.label.kind" path="kind"/>
	<acme:form-textarea code="authenticated.investment.form.label.description" path="description"/>
	<acme:form-money code="authenticated.investment.form.label.amount" path="amount"/>
	<acme:form-url code="authenticated.investment.form.label.link" path="link"/>
	
		<acme:form-submit method="get" code="authenticated.investment.form.label.programme"
		action="/authenticated/activity/list?id=${id}&ref=${reference}" />
		
	
<br/><br/>
	
	<acme:form-return code="authenticated.investment.form.button.return"/>
</acme:form>