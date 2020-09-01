<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.pablo-favourite-link" action="http://www.youtube.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.notice" action="/anonymous/notice/list" />
			<acme:menu-suboption code="master.menu.anonymous.technologyRecordStars" action="/anonymous/technology-record/liststars" />
			<acme:menu-suboption code="master.menu.anonymous.technologyRecordSector" action="/anonymous/technology-record/listsector" />
			<acme:menu-suboption code="master.menu.anonymous.toolrecordStars" action="/anonymous/tool-record/liststars" />
			<acme:menu-suboption code="master.menu.anonymous.toolrecordSector" action="/anonymous/tool-record/listsector" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator.features" access="hasRole('Administrator')">
		<acme:menu-suboption code="master.menu.administrator.features.createnotice" action="/administrator/notice/create" />
		<acme:menu-suboption code="master.menu.administrator.features.notice" action="/administrator/notice/list" />
		<acme:menu-suboption code="master.menu.administrator.features.createinquiry" action="/administrator/inquiry/create" />
		<acme:menu-suboption code="master.menu.administrator.features.inquiry" action="/administrator/inquiry/list" />
		<acme:menu-suboption code="master.menu.administrator.features.createoverture" action="/administrator/overture/create" />
		<acme:menu-suboption code="master.menu.administrator.features.overture" action="/administrator/overture/list" />
		<acme:menu-suboption code="master.menu.administrator.features.createtechrecord" action="/administrator/technology-record/create" />
		<acme:menu-suboption code="master.menu.administrator.features.techrecord" action="/administrator/technology-record/list" />
		<acme:menu-suboption code="master.menu.administrator.features.createtoolrecord" action="/administrator/tool-record/create" />
		<acme:menu-suboption code="master.menu.administrator.features.toolrecord" action="/administrator/tool-record/list" />
		<acme:menu-suboption code="master.menu.administrator.features.createchallenge" action="/administrator/challenge/create" />
		<acme:menu-suboption code="master.menu.administrator.features.challenge" action="/administrator/challenge/list" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.entrepreneur" access="hasRole('Entrepreneur')">
			<acme:menu-suboption code="master.menu.entrepreneur.investment" action="/entrepreneur/investment/list"/>
			<acme:menu-suboption code="master.menu.entrepreneur.createinvestment" action="/entrepreneur/investment/create"/>
			<acme:menu-suboption code="master.menu.entrepreneur.application" action="/entrepreneur/application/list"/>
			<acme:menu-suboption code="master.menu.entrepreneur.applicationticket" action="/entrepreneur/application/listticket"/>
			<acme:menu-suboption code="master.menu.entrepreneur.applicationdate" action="/entrepreneur/application/listdate"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.investor" access="hasRole('Investor')">
		<acme:menu-suboption code="master.menu.investor.application" action="/investor/application/list"/>
		<acme:menu-suboption code="master.menu.investor.investment" action="/investor/investment/list"/>
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-investor" action="/authenticated/investor/create" access="!hasRole('Investor')"/>
			<acme:menu-suboption code="master.menu.user-account.investor" action="/authenticated/investor/update" access="hasRole('Investor')"/>
			<acme:menu-suboption code="master.menu.user-account.become-entrepreneur" action="/authenticated/entrepreneur/create" access="!hasRole('Entrepreneur')"/>
			<acme:menu-suboption code="master.menu.user-account.entrepreneur" action="/authenticated/entrepreneur/update" access="hasRole('Entrepreneur')"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
		
			<acme:menu-suboption code="master.menu.authenticated.notice" action="/authenticated/notice/list" />
			<acme:menu-suboption code="master.menu.authenticated.technologyRecordStars" action="/authenticated/technology-record/liststars" />
			<acme:menu-suboption code="master.menu.authenticated.technologyRecordSector" action="/authenticated/technology-record/listsector" />
			<acme:menu-suboption code="master.menu.authenticated.toolrecordStars" action="/authenticated/tool-record/liststars" />
			<acme:menu-suboption code="master.menu.authenticated.toolrecordSector" action="/authenticated/tool-record/listsector" />
			<acme:menu-suboption code="master.menu.authenticated.inquiry" action="/authenticated/inquiry/list" />
			<acme:menu-suboption code="master.menu.authenticated.overture" action="/authenticated/overture/list" />
			<acme:menu-suboption code="master.menu.authenticated.challenge" action="/authenticated/challenge/list" />
			<acme:menu-suboption code="master.menu.authenticated.investment" action="/authenticated/investment/list" />
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

