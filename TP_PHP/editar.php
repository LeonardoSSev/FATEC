<?php
/**
 * Created by PhpStorm.
 * User: Leonardo
 * Date: 08/06/2017
 * Time: 06:32
 */
	require_once 'Classes/Aluno.php';

	Aluno::update($_GET["id"], $_GET["nome"], $_GET["email"], $_GET["data"], $_GET["comentario"], $_GET["curso"], $_GET["sexo"]);
	header("location: index.php");
?>