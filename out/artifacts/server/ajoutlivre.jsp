<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un livre</title>
</head>
<body>
<h1>Ajouter un livre</h1>
<form action="livre" method="post">
    Titre: <input type="text" name="titre"><br>
    Auteur: <input type="text" name="auteur"><br>
    Année de publication: <input type="text" name="anneePublication"><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
