<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Прототип системи дистанційного навчання</title>
<meta charset="UTF-8" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<center>
<h1>Прототип системи дистанційного навчання</h1>
<%
String message = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("message")) message = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<h2><%=message%></h2>
<h4>Session ID = <%=sessionID %></h4>
<p><a href="insertl.html"> Додати викладача або дисципліну</a></p>
<p><a href="InsertFull"> Закріпити за викладачем дисципліну</a></p>
<p><a href="ShowLecturers"> Редагувати або видалити викладача</a></p>
<p><a href="ShowDisciplines"> Редагувати або видалити дисципліну</a></p>
<p><a href="search.html"> Пошук викладачів</a></p>
<p><a href="search1.html"> Пошук дисциплін</a></p>
<form action="LogoutServlet" method="post">
<input type="submit" value="Вийти" >
</form>
</center>
</body>
</html>
