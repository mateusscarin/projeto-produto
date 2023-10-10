<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Produto</title>
    </head>
    <body>
        <h1>Controle de Produtos</h1>
        <form name="cadastrarProduto" action="CadastrarProduto" method="post">
            <table>
                <tr>
                    <td><label>ID produto:</label></td>
                    <td><input type="text" name="idproduto" disabled="" readonly=""></td>
                </tr>
                <tr>
                    <td><label>Produto:</label></td>
                    <td><input type="text" name="nomeproduto"></td>
                </tr>
                <tr>
                    <td><label>Descrição:</label></td>
                    <td><input type="text" name="descricaoproduto"></td>
                </tr>
                <tfoot>
                <tr>
                    <input type="submit" value="Salvar">
                    <input type="submit" value="Limpar">
                </tr>
                <a href="ListarProduto">Listar produtos</a>
            </table>
            ${mensagem}
        </form>
    </body>
</html>
