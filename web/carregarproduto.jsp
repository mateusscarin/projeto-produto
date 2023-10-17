<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Produto</title>
    </head>
    <body>
        <h1>Controle de Produtos</h1>
        <form name="alterarProduto" action="AlterarProduto" method="post">
            <table>
                <tr>
                    <td><label>ID produto:</label></td>
                    <td><input type="text" name="idproduto" disabled="" readonly="" value="${produto.id}"></td>
                </tr>
                <tr>
                    <td><label>Produto:</label></td>
                    <td><input type="text" name="nomeproduto" value="${produto.nome}"></td>
                </tr>
                <tr>
                    <td><label>Descrição:</label></td>
                    <td><input type="text" name="descricaoproduto" value="${produto.descricao}"></td>
                </tr>
            </table>
            <input type="submit" value="Alterar"/>
            <a href="ListarProduto">Listar produtos</a>
        </form>
        ${mensagem}
    </body>
</html>
