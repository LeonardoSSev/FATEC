<?php
/**
 * Created by PhpStorm.
 * User: Leonardo
 * Date: 07/06/2017
 * Time: 13:30
 */

    require_once 'Classes/Aluno.php';

$status = move_uploaded_file($_FILES["csv"]["tmp_name"], "files/".$_FILES["csv"]["name"]);
try{
    if ($status) {
        $f = fopen("files/".$_FILES["csv"]["name"], "r");
        if ($f) {
            $rows = fgetcsv($f, 100, ";");
            $rows = fgetcsv($f, 100, ";");
            while ($rows != null) {
                $aluno = new Aluno($rows[0], $rows[1], $rows[2], $rows[3], $rows[4], $rows[5], $rows[6]);
                $aluno->create();
                $rows = fgetcsv($f, 100, ";");
            }
            fclose($f);
        }
    }
} catch(Exception $ex){
    echo $ex->getMessage();
}


header("location.inserir.php");
?>