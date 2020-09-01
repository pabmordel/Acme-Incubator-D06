<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox readonly="true" code="entrepreneur.application.form.label.ticket" path="ticket" placeholder="XXX-00-000000"/>
	<acme:form-moment readonly="true" code="entrepreneur.application.form.label.creationdate" path="creationdate"/>
	<acme:form-textbox readonly="true" code="entrepreneur.application.form.label.statement" path="statement"/>
	<acme:form-money readonly="true" code="entrepreneur.application.form.label.offer" path="offer"/>
	<acme:form-textbox readonly="true" code="entrepreneur.application.form.label.investor" path="investor-firm"/>
	<acme:form-textbox readonly="true" code="entrepreneur.application.form.label.investment" path="investment-title"/>
	<acme:form-textbox code="entrepreneur.application.form.label.status" path="status"/>
	<acme:form-textbox code="entrepreneur.application.form.label.justification" path="justification"/>
	
	
	<acme:form-submit test="${command == 'show'}"
	code="entrepreneur.application.form.button.update"
	action="/entrepreneur/application/update"/>
	<acme:form-submit test="${command == 'update'}"
	code="entrepreneur.application.form.button.update"
	action="/entrepreneur/application/update"/>
	
	
	<acme:form-return code="entrepreneur.application.form.button.return"/>
</acme:form>