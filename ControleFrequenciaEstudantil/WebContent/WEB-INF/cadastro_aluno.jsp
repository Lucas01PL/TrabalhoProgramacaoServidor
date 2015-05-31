<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cadastro de Aluno</h1>
<hr/>
<form method="post" action="SalvarAluno">
<label for="nome">Nome Completo</label>
<input type="text" id="nome" maxlength="50" required="true"/>
<input type="submit" value="Salvar" />
</form>

</body>
</html>