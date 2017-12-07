<?php
    include 'assets/includes/header.php';
    include 'assets/includes/menu.php';
    include_once("conexaoBanco.php");
    require_once 'Classes/Aluno.php';

    $id = $_GET["id"];
    $nome = $_GET["nome"];
    $email = $_GET["email"];
    $data = $_GET["data"];
    $comentario = $_GET["comentario"];
?>

<div class="container">

    <h1>Atualize um cadastro</h1>

    <div class="row">
        <div class="col-md-6">
            <form method="GET" action="editar.php">
                <input type="text" name="id" id="id" class="form-control formulario" value="<?=$id?>" hidden/>
                <?php include_once 'assets/includes/formulario.php'; ?>
                <input type="submit" name="atualizar" value="Atualizar dados" class="btn formulario">
            </form>
        </div>
    </div>
</div>

<?php
include 'assets/includes/footer.php';
include 'assets/includes/scripts.php';
?>
<script type="text/javascript" src="assets/js/script.js"></script>