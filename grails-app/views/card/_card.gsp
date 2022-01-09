<div class="card mb-3">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
        <g:if test="title">
            <h5 class="card-title">${title}</h5>
        </g:if>

        <g:if test="${text}">
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        </g:if>

        <g:if test="${smallText}">
            <p class="card-text"><small class="text-muted">${smallText}</small></p>
        </g:if>
    </div>
</div>

