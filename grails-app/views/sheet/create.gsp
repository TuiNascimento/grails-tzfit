<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <asset:stylesheet src="domain-edition/fields.css"></asset:stylesheet>
        <g:set var="entityName" value="${message(code: 'sheet.label', default: 'Sheet')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-sheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-sheet" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.sheet}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.sheet}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.sheet}" method="POST">
                <fieldset class="form">
                    <div class="field-container">
                        <label for="title">Title: </label>
                        <g:textField name="title"/>
                    </div>
                    <div class="field-container">
                        <label for="sheetCoach">Coach: </label>
                        <g:select name="sheetCoach" from="${tzfit.Coach.list()}" optionKey="id" optionValue="fullName" />
                    </div>
                    <div class="field-container">
                        <label for="athletes">Athletes: </label>
                        <g:select multiple="true" name="athletes" from="${tzfit.Athlete.list()}" optionKey="id" optionValue="fullName"/>
                    </div>
                    <div class="field-container">
                        <label for="movements">Movements: </label>
                        <g:select multiple="true" name="movements" from="${tzfit.Movement.list()}" optionKey="id" optionValue="title"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
