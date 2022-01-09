<%@ page import="tzfit.MovementController" %>


<div class="card mb-md-3" style="max-width: 540px;">
    <div class="row no-gutters">
        <div class="col-md-4">
            <iframe class="video-frame"
                    src="${MovementController.getVideoEmbedLink(movement.id)}"
                    title="YouTube video player"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
            </iframe>
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${movement.title}</h5>
                <p class="card-text">${movement.description}</p>
                <g:if test="${smallText}">
                    <p class="card-text"><small class="text-muted">${smallText}</small></p>
                </g:if>
            </div>
        </div>
    </div>
</div>