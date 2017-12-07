<?php
    /**
     * Created by PhpStorm.
     * User: Leonardo
     * Date: 08/06/2017
     * Time: 04:12
     */
include 'assets/includes/session_cookies.php';

if(isset($_POST['inserir'])) {
    require_once 'Classes/Aluno.php';
    $a = new Aluno($_POST['id'],
        $_POST['nome'],
        $_POST['email'],
        $_POST['data'],
        $_POST['comentario'],
        $_POST['curso'],
        $_POST['sexo']);

if(isset($_GET['inserir'])){
    extract($_GET);
    require_once 'Classes/Aluno.php';
    $a = new Aluno($_GET['id'],
        $_GET['nome'],
        $_GET['email'],
        $_GET['data'],
        $_GET['comentario'],
        $_GET['curso'],
        $_GET['sexo']);
    $a->create();
}

    $a->create();
    header("location: inserir.php");

}
?>