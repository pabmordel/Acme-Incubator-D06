<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="entrepreneur.activity.form.label.title" path="title"/>
	<acme:form-moment code="entrepreneur.activity.form.label.startdate" path="startdate"/>
	<acme:form-moment code="entrepreneur.activity.form.label.enddate" path="enddate"/>
	<acme:form-textbox code="entrepreneur.activity.form.label.budget" path="budget"/>

	<acme:form-submit test = "${command == 'create'}"
	code="entrepreneur.activity.form.button.create" 
	action="/entrepreneur/activity/create"/>
	<acme:form-submit test="${command == 'show' && !finalMode}"
	code="entrepreneur.activity.form.button.update"
	action="/entrepreneur/activity/update"/>
	<acme:form-submit test="${command == 'show' && !finalMode}"
	code="entrepreneur.activity.form.button.delete"
	action="/entrepreneur/activity/delete"/>
	<acme:form-submit test="${command == 'update' && !finalMode}"
	code="entrepreneur.activity.form.button.update"
	action="/entrepreneur/activity/update"/>
	<acme:form-submit test="${command == 'delete' && !finalMode}"
	code="entrepreneur.activity.form.button.delete"
	action="/entrepreneur/activity/delete"/>
	
	<acme:form-return code="entrepreneur.investment.form.button.return"/>
</acme:form>