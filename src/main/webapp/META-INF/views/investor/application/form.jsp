<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="investor.application.form.label.ticket" path="ticket"/>
	<acme:form-textbox code="investor.application.form.label.statement" path="statement"/>
	<acme:form-money code="investor.application.form.label.offer" path="offer"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="investor.application.form.label.creationdate" path="creationdate"/>
	<acme:form-textbox code="investor.application.form.label.investor" path="investor-firm"/>
	<acme:form-textbox code="investor.application.form.label.investment" path="investment-title"/>
	<acme:form-textbox code="investor.application.form.label.status" path="status"/>
	<acme:form-textbox code="investor.application.form.label.justification" path="justification"/>
	</jstl:if>
	
	<acme:form-submit test = "${command == 'create'}"
	code="investor.application.form.button.create" 
	action="/investor/application/create"/>
	
	<acme:form-return code="investor.application.form.button.return"/>
</acme:form>