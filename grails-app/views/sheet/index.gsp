<g:render template="/utils/header"/>
<head>
    <asset:stylesheet src="sheet-index/sheet-index.css"></asset:stylesheet>
    <asset:javascript src="application.js"/>
</head>
<a href="#list-sheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-sheet" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <div class="sheet-list-container">
        <g:each var="sheet" in="${sheetList}">
            <div class="sheet_${sheet.id} sheet-item col-md-3">
                <g:link controller="sheet" action="show" id="${sheet.id}">
                    <div class="sheet-title">
                        <h3>${sheet.title}</h3>
                    </div>
                    <div class="sheet-info-container">
                        <div class="sheet-info">
                            <i class="fas fa-running">${sheet.movements.size()} movements</i>
                            <i class="fas fa-clock">${sheet.getEstimatedDuration()} minutes</i>
                        </div>
                    </div>
                </g:link>
            </div>
            <script>
                $(document).ready(function () {

                    let filePath = "url(${sheet?.coverImage.path})";
                    if (filePath) {
                        $(".sheet_${sheet.id}").css("background-image", filePath);
                    }
                })
            </script>
        </g:each>
    </div>

    <div class="pagination">
        <g:paginate total="${sheetCount ?: 0}"/>
    </div>
</div>
