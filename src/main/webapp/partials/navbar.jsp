<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 1/30/17
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar</title>
    <style>
    body {
        margin: 0;
        padding: 0;
        background: #ccc;
    }

    .nav ul {
        list-style: none;
        background-color: #444;
        text-align: center;
        padding: 0;
        margin: 0;
    }
    .nav li {
        font-family: 'Oswald', sans-serif;
        font-size: 1.2em;
        line-height: 40px;
        height: 40px;
        border-bottom: 1px solid #888;
    }

    .nav a {
        text-decoration: none;
        color: #fff;
        display: block;
        transition: .3s background-color;
    }

    .nav a:hover {
        background-color: #005f5f;
    }

    .nav a.active {
        background-color: #fff;
        color: #444;
        cursor: default;
    }

    @media screen and (min-width: 600px) {
        .nav li {
            width: 120px;
            border-bottom: none;
            height: 50px;
            line-height: 50px;
            font-size: 1.4em;
        }

        /* Option 1 - Display Inline */
        .nav li {
            display: inline-block;
            margin-right: -4px;
        }
    }</style>
</head>
<body>
<header>
    <div class = "nav">
        <ul>
            <li class="home"><a class="active" href="/index">Home</a></li>
            <li class="tutorials"><a href="/login">Login</a></li>
            <li class="about"><a href="/profile">Profile</a></li>
            <li class="news"><a href="#">Newsletter</a></li>
            <li class="contact"><a href="#">Contact</a></li>
        </ul>
    </div>
</header>
</body>
</html>
