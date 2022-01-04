<%--
  Created by IntelliJ IDEA.
  User: tui
  Date: 12/27/21
  Time: 6:06 PM
--%>

<%@ page import="grails.plugin.springsecurity.SpringSecurityUtils; grails.plugin.springsecurity.SpringSecurityService" contentType="text/html;charset=UTF-8" %>
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
                <a class="navbar-brand" href="/home">
                    <i class="fas fa-dumbbell"></i>
                    TZ Fit
                </a>
            </div>
        </div>

        <div class="container">

            <g:pageProperty name="page.nav"/>
        </div>
    </div>

    <g:layoutBody/>
</body>
</html>