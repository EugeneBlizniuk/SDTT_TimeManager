<%--
  Created by IntelliJ IDEA.
  User: Yauheni
  Date: 29.11.2019
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome page</title>

    <!--    <link rel="stylesheet" type="text/css" href="../web_resources/css/SignUp.css">-->
    <style>
        html, body {
            width: 100%;
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            color: #444;
            -webkit-font-smoothing: antialiased;
            /*background: url(../web_resources/images/welcome_photo.jpg) repeat;*/
        }
        h1 {
            text-align: center;
            color: chocolate;
        }
        #container {
            display: block;
            position: fixed;
            width: 250px;
            height: 280px;
            top: 23%;
            left: 60%;
        }
        #container input{
            margin-left: 20px;
            margin-top: 20px;
            width: 120px;
            height: 50px;
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#acd6ef), to(#6ec2e8));
            border-radius: 10px;
            border: 1px solid #66add6;
            box-shadow: 0 1px 2px rgba(0, 0, 0, .3), inset 0 1px 0 rgba(255, 255, 255, .5);
            cursor: pointer;
        }

        #container input[type=button]:hover {
            background-image: -webkit-gradient(linear, left top, left bottom, from(#b6e2ff), to(#6ec2e8));
        }

        #container input[type=button]:active {
            background-image: -webkit-gradient(linear, left top, left bottom, from(#6ec2e8), to(#b6e2ff));
        }

        #lower_login input{
            margin-left: 20px;
        }

        #login_form {
            display: block;
            position: fixed;
            width: 250px;
            height: 280px;
            top: 20%;
            left: 30%;
        }

        #login_form label {
            color: #555;
            display: block;
            margin-left: 20px;
            padding-top: 10px;
            font-size: 20px;
        }

        input[type=text],
        input[type=password] {
            color: #777;
            padding-left: 10px;
            margin: 10px;
            margin-top: 12px;
            margin-left: 18px;
            width: 290px;
            height: 35px;
            border: 1px solid #c7d0d2;
            border-radius: 2px;
            box-shadow: inset 0 1.5px 3px rgba(190, 190, 190, .4), 0 0 0 5px #f5f7f8;
            -webkit-transition: all .4s ease;
            -moz-transition: all .4s ease;
            transition: all .4s ease;
        }

        input[type=submit]:hover {
            background-image: -webkit-gradient(linear, left top, left bottom, from(#b6e2ff), to(#6ec2e8));
        }

        input[type=submit]:active {
            background-image: -webkit-gradient(linear, left top, left bottom, from(#6ec2e8), to(#b6e2ff));
        }

        input[type=submit]{
            margin-right: 20px;
            margin-top: 20px;
            width: 120px;
            height: 50px;
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#acd6ef), to(#6ec2e8));
            border-radius: 10px;
            border: 1px solid #66add6;
            box-shadow: 0 1px 2px rgba(0, 0, 0, .3), inset 0 1px 0 rgba(255, 255, 255, .5);
            cursor: pointer;
        }

        input[type=text]:hover,
        input[type=password]:hover{
            border: 1px solid #b6bfc0;
            box-shadow: inset 0 1.5px 3px rgba(190, 190, 190, .7), 0 0 0 5px #f5f7f8;
        }

        input[type=text]:focus,
        input[type=password]:focus{
            border: 1px solid #a8c9e4;
            box-shadow: inset 0 1.5px 3px rgba(190, 190, 190, .4), 0 0 0 5px #e6f2f9;
        }
    </style>
</head>
<body>
<h1>What's up?</h1>
<form method="post" action="/home">
    <div id="login_form">
        <label>Login:</label>
        <input type="text" name="login">
        <label>Password:</label>
        <input type="password" name="password">
        <div id="lower_login">
            <input type="submit" name="signInButton" value="Sign In">
        </div>
    </div>
    <div id="container">
        <input id="sign_up" name="signUpButton" type="submit" value="Sign Up">
        <input id="just_try" name="justTryButton" type="submit" value="Just try">
    </div>
</form>
</body>
</html>
