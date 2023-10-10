<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciamento de Produtos</title>
    </head>
    <body>
        <h1>Gerenciar Produto</h1>
        <table border="1" cellspacing="0">
            <h2>Listar Produtos</h2>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Produto</th>
                    <th>Descrição</th>
                    <th colspan="2">Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${resultado}">
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.descricao}</td>
                        <td><a href="ExcluirProduto?id=${produto.id}">Excluir</a></td>
                        <td><a href="CarregarProduto?id=${produto.id}">Carregar</a></td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </body>
</html>
