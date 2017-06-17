<?php
/**
 * Created by PhpStorm.
 * User: Leonardo
 * Date: 15/06/2017
 * Time: 20:49
 */
session_start();
if(!isset($_SESSION["id"])){
    if(isset($_COOKIE["id"])){
        $_SESSION["id"] = $_COOKIE["id"];
        $_SESSION["nome"] = $_COOKIE["nome"];
        $_SESSION["email"] = $_COOKIE["email"];
        $_SESSION["data"] = $_COOKIE["data"];
        $_SESSION["comentario"] = $_COOKIE["comentario"];
        $_SESSION["curso"] = $_COOKIE["curso"];
        $_SESSION["sexo"] = $_COOKIE["sexo"];
    } else{
        $_SESSION["id"] = "";
        $_SESSION["nome"] = "";
        $_SESSION["email"] = "";
        $_SESSION["data"] = "";
        $_SESSION["comentario"] = "";
        $_SESSION["curso"] = "";
        $_SESSION["sexo"] = "";
    }
}
if(isset($_POST["id"])){
    $_SESSION["id"] = $_POST["id"];
    $_SESSION["nome"] = $_POST["nome"];
    $_SESSION["email"] = $_POST["email"];
    $_SESSION["data"] = $_POST["data"];
    $_SESSION["comentario"] = $_POST["comentario"];
    $_SESSION["curso"] = $_POST["curso"];
    $_SESSION["sexo"] = $_POST["sexo"];
    setcookie("id", $_POST["id"], time() + (60*60*24));
    setcookie("nome", $_POST["nome"], time() + (60*60*24));
    setcookie("email", $_POST["email"], time() + (60*60*24));
    setcookie("data", $_POST["data"], time() + (60*60*24));
    setcookie("comentario", $_POST["comentario"], time() + (60*60*24));
    setcookie("curso", $_POST["curso"], time() + (60*60*24));
    setcookie("sexo", $_POST["sexo"], time() + (60*60*24));
}