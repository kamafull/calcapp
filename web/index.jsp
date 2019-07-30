<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 10.05.2019
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<h3> Введите параметры оборудования json</h3>
<form method="post" action="/jsonexchange" >
    <input type="text" name="data">
    <input type="submit" name="Отправить">
</form>
<h3> Введите id файла </h3>
<form method="get" action="/loadfiles" >
    <input type="text" name="fileid">
    <input type="submit" name="Отправить">
</form>
<h3> Создайте пользователя json </h3>
<form method="post" action="/createusers" >
    <input type="text" name="createuser">
    <input type="submit" name="Отправить">
</form>

<h3> Удалите пользователя </h3>
<form method="post" action="/deleteusers" >
    <input type="text" name="deleteuser">
    <input type="submit" name="Отправить">
</form>

<h3> Обновить сохраненки пользователя </h3>
<form method="post" action="/updatesaves" >
    <input type="text" name="savesuser">
    <input type="submit" name="Отправить">
</form>

</body>
</html>
