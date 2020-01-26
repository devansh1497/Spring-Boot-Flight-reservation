<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User login</title>
</head>
<body>
<h2>Login:</h2>
<form action="login" method="post">
<pre>
UserName : <input type="text" name="email"/>
Password : <input type="password" name="password"/>
<input type="Submit" value="Login"/>
${msg}
</pre>
</form>
</body>
</html>