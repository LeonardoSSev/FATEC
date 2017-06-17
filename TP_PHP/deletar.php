<?php
require_once 'Classes/Aluno.php';

Aluno::delete($_GET["id"]);
if($_SERVER['HTTP_REFERER'] == "http://localhost/TP03-PHP/index.php"){
    header("location:index.php");
} else{
    header("location:inserir.php");
}
?>
