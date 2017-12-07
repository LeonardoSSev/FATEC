<?php
    include 'assets/includes/header.php';
    include 'assets/includes/menu.php';
    include 'assets/includes/session_cookies.php';
    $id="";
    $nome="";
    $email="";
    $data="";
    $comentario="";
?>

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>Insira os dados aqui</h1>

                <form action="insereBanco.php" method="POST" id="inserir">
                     <input type="text" name="id" id="id" class="form-control formulario" placeholder="ID" value="<?= isset($_SESSION["id"])?$_SESSION["id"]:$id ?>" pattern="[0-9]+$" required/>
                    <?php include_once 'assets/includes/formulario.php'; ?>
                    <input type="submit" name="inserir" value="Inserir dados" class="btn formulario">
                </form>
                <form action="enviarCSV.php" method="POST" enctype="multipart/form-data" id="enviarCSV">
                        Ou cadastre-se por arquivo csv:
                        <input name="csv" type="file" accept="text/csv"  id="csv" required>
                        <input type="submit" name="enviarCSV" value="Enviar" class="btn formulario">
                </form>
            </div>
            <div class="col-md-6" id="lista-inserir">
              <?php
                include_once "conexaoBanco.php";
                include_once "tabela-dados.php";
              ?>
            </div>
        </div>
    </div>

<?php
    include 'assets/includes/footer.php';
    include 'assets/includes/scripts.php';
?>
<script type="text/javascript" src="assets/js/script.js"></script>