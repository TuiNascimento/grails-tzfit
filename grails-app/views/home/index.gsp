<%--
  Created by IntelliJ IDEA.
  User: tui
  Date: 12/27/21
  Time: 5:41 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<html>
<head>
    <meta name="layout" content="public"/>
    <title>Home Page</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome ${name}!</h1>

        <h4>${flash.message}</h4>

        <p>There are ${sheetsTotal} sheets in the database.</p>

        <form action="/home/updateName" method="post" style="margin: 0 auto; width:320px">
            <input type="text" name="name" value="" id="name">
            <input type="submit" name="Update name" value="Update name" id="Update name">
        </form>

    </section>
</div>

</body>
</html>