<%--
  Created by IntelliJ IDEA.
  User: tui
  Date: 12/27/21
  Time: 6:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Auto Catalog"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet href="fontawesome-free-5.15.4-web/css/all.css" />
    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/#">
                <i class="fas fa-dumbbell"></i>
                TZ Fit
            </a>
        </div>
        <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
            <ul class="nav navbar-nav navbar-right">
                <g:pageProperty name="page.nav" />
            </ul>
        </div>
    </div>
</div>

<g:layoutBody/>

<div class="footer" role="contentinfo"></div>

</body>
</html>