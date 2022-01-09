<g:render template="/utils/header"/>
<a href="#list-athlete" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="create.label.${controllerName}"/></g:link></li>
    </ul>
</div>

<div id="list-athlete" class="content scaffold-list" role="main">
    <h1><g:message code="list.label.${controllerName}"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${athleteList}"/>

    <div class="pagination">
        <g:paginate total="${athleteCount ?: 0}"/>
    </div>
</div>