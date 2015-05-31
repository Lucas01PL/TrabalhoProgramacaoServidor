<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="Login">
		<label for="login">Usuario</label>
		<input type="text" required="true" maxlength="20" size="21" id="login" name="login"/>
		<label for="senha">Senha</label>
		<input type="password" required="true" maxlength="20" size="21" id="senha" name="senha"/>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>