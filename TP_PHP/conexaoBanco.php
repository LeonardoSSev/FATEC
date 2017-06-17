<?php
/**
 * Created by PhpStorm.
 * User: Leonardo
 * Date: 08/06/2017
 * Time: 05:20
 */

function getConnection(){
    return mysqli_connect("localhost", "root", "", "db_tp03");
}

