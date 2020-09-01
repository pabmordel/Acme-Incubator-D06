<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="entrepreneur.investment.form.label.title" path="title"/>
	<acme:form-textbox code="entrepreneur.investment.form.label.ticket" path="ticket" placeholder="XXX-00-000000"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment readonly = "true" code="entrepreneur.investment.form.label.creationdate" path="creationdate"/>
	<acme:form-textbox code="entrepreneur.investment.form.label.mode" path="mode"/>
	</jstl:if>
	<acme:form-textbox code="entrepreneur.investment.form.label.kind" path="kind"/>
	<acme:form-textarea code="entrepreneur.investment.form.label.description" path="description"/>
	<acme:form-money code="entrepreneur.investment.form.label.amount" path="amount"/>
	<acme:form-url code="entrepreneur.investment.form.label.link" path="link"/>

	
	<jstl:if test="${command != 'create'}">
		<acme:form-submit method="get" code="entrepreneur.investment.form.label.programme"
		action="/entrepreneur/activity/list?id=${id}" />
	</jstl:if>	
	
	<jstl:if test="${command != 'create' && !finalMode}">	
		<acme:form-submit method="get" code="entrepreneur.investment.form.label.createactivity"
		action="/entrepreneur/activity/create?id=${id}" />
	</jstl:if>
	
	<br/><br/>
		
	<acme:form-submit test = "${command == 'create'}"
	code="entrepreneur.investment.form.button.create" 
	action="/entrepreneur/investment/create"/>
	<acme:form-submit test="${command == 'show' && !finalMode}"
	code="entrepreneur.investment.form.button.update"
	action="/entrepreneur/investment/update"/>
	<acme:form-submit test="${command == 'show' && !hasApp}"
	code="entrepreneur.investment.form.button.delete"
	action="/entrepreneur/investment/delete"/>
	<acme:form-submit test="${command == 'update'&& !finalMode}"
	code="entrepreneur.investment.form.button.update"
	action="/entrepreneur/investment/update"/>
	<acme:form-submit test="${command == 'delete' && !hasApp}"
	code="entrepreneur.investment.form.button.delete"
	action="/entrepreneur/investment/delete"/>
		
	
	
	<acme:form-return code="entrepreneur.investment.form.button.return"/>
</acme:form>