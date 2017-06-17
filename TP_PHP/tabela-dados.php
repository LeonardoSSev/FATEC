<?php
    
    $con = getConnection();
    mysqli_set_charset($con, "utf8");
    $SQL = "SELECT ID, NOME, EMAIL, DATA, COMENTARIO, CURSO, SEXO  FROM tb_aluno";
    $tab = mysqli_query($con, $SQL);
    $linha = mysqli_fetch_assoc($tab);
?>
<div class='table-responsive'>
    <table class='table table-striped table-hover'>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Data de Nascimento</th>
        <th>Comentário</th>
        <th>Curso</th>
        <th>Sexo</th>
    </tr>
<?php
while($linha != null) {
    ?>
    <tr>
        <td><?=$linha["ID"]?></td>
        <td><?=$linha["NOME"]?></td>
        <td><?=$linha["EMAIL"]?></td>
        <td>
        <?php
            $dt = new DateTime($linha["DATA"]);
            $dtModel = $dt->format("d-m-Y");
            echo $dtModel;
        ?>
        </td>
        <td><?=$linha["COMENTARIO"]?></td>
        <td><?=$linha["CURSO"]?></td>
        <td><?=$linha["SEXO"]?></td>
        <td><a href='atualizar.php?id=<?=$linha['ID']?>&nome=<?=$linha['NOME']?>&email=<?=$linha['EMAIL']?>&data=<?=$linha['DATA']?>&comentario=<?=$linha['COMENTARIO']?>'><button class="btn btn-primary" >Editar</button></a>
        <td><a href='deletar.php?id=<?=$linha['ID']?>'><button class="btn btn-danger">Excluir</button></a>
    </tr>
    <?php $linha = mysqli_fetch_assoc($tab);
}
?>
    </table>
</div>
