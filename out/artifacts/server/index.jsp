<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des livres</title>
</head>
<body>
<h1>Liste des livres</h1>
<ul>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Anné</th>
            <th colspan="2">option</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="livre" items="${livres}">
            <tr>
                <td>${livre.id}</td>
                <td>${livre.titre}</td>
                <td>${livre.auteur}</td>
                <td>${livre.anneePublication}</td>
                <td><a>supprimer</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</ul>
<a href="ajoutlivre.jsp">Ajouter un livre</a>
</body>
</html>
