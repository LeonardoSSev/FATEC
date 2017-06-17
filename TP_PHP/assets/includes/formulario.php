<?php
/**
 * Created by PhpStorm.
 * User: Jonatas Lopes
 * Date: 03/06/2017
 * Time: 14:08
 */
?>
    <input type="text" name="nome" id="nome" class="form-control formulario" placeholder="Nome" value="<?= isset($_SESSION["nome"])?$_SESSION["nome"]:$nome ?>" pattern="^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" required/>
    <input type="text" name="email" id="email" class="form-control formulario" placeholder="E-mail" value="<?= isset($_SESSION["email"])?$_SESSION["email"]:$email ?>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required/>
    <input type="date" name="data" id="data" class="form-control formulario" onkeypress="mascaraData(this)" placeholder="Data de Nascimento" max="31-12-1999" value="<?= isset($_SESSION["data"])?$_SESSION["data"]:$data ?>" required/>
    <textarea name="comentario" id="comentario" class="form-control formulario" placeholder="Escreva um comentário"> <?= isset($_SESSION["comentario"])?$_SESSION["comentario"]:$comentario ?></textarea>
    <select name="curso" id="curso" class="form-control formulario">
        <option value="Análise e Desenvolvimento de Sistemas">Análise e Desenvolvimento de Sistemas</option>
        <option value="Comércio Exterior">Comércio Exterior</option>
        <option value="Gestão Empresarial">Gestão Empresarial</option>
        <option value="Processos Químicos">Processos Químicos</option>
    </select>
    <div class="formulario">
        <label class="radio-inline" for="masculino">
            <input type="radio" name="sexo" id="sexo" value="Masculino" id="msaculino"/> Masculino
        </label>
        <label class="radio-inline" for="feminino">
            <input type="radio" name="sexo" id="sexo" value="Feminino" id="feminino"/> Feminino
        </label>
    </div>


