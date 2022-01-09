<div class="card mb-3" style="max-width: 540px;">
    <div class="row no-gutters">
        <div class="col-md-4">
            <img src="${imageSrc}" alt="image">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${title}</h5>
                <p class="card-text">${text}</p>
                <g:if test="${smallText}">
                    <p class="card-text"><small class="text-muted">${smallText}</small></p>
                </g:if>
            </div>
        </div>
    </div>
</div>