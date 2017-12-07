<?php

/**
 * Created by PhpStorm.
 * User: Leonardo
 * Date: 08/06/2017
 * Time: 09:09
 */
class Aluno{
    private $id;
    private $nome;
    private $email;
    private $nascimento;
    private $comentario;
    private $curso;
    private $sexo;

    public function __construct($id, $nm, $em, $ns, $cm, $cs, $sx){
        $this->id =  $id;
        $this->nome = $nm;
        $this->email = $em;
        $this->nascimento = $ns;
        $this->comentario = $cm;
        $this->curso = $cs;
        $this->sexo = $sx;
    }


    //OPERAÇÕES COM O BANCO
    public function create(){
        $c = mysqli_connect("localhost", "root", "", "db_tp03");
        if(!$c){
            return "Erro ao estabelecer conexão com o banco";
        } else{
           $id = $this->id;
           $nome = $this->nome;
           $email = $this->email;
           $data = $this->nascimento;
           $comentario = $this->comentario;
           $curso = $this->curso;
           $sexo = $this->sexo;

           //Formatação de Data para entrada no banco de dados
           $dt = new DateTime($data);
           $dtModel = $dt->format("Y/m/d");

            if($ps = mysqli_prepare($c, "INSERT INTO tb_aluno VALUES(?,?,?,?,?,?,?)") or die(mysqli_error($c))){
                $ps->bind_param("issssss", $id, $nome, $email, $dtModel, $comentario, $curso, $sexo);
                $ps->execute();
            }else{
                echo '<script> alert("Não cadastrou"); </script>';
            }
        }
        mysqli_close($c);
        header('Location: inserir.php');
    }

    public static function delete($idP){
        $c = mysqli_connect("localhost", "root", "", "db_tp03");
        if(!$c){
            return "Erro ao estabelecer conexão com o banco";
        } else {
            $ps = mysqli_prepare($c, "DELETE FROM tb_aluno WHERE ID = ?") or die(mysqli_error($c));
            mysqli_stmt_bind_param($ps, "i", $idP);
            mysqli_stmt_execute($ps);
        }
        mysqli_close($c);
    }

    public static function update($idP, $nmP, $emP, $nsP, $cmP, $csP, $sxP){
        $c = mysqli_connect("localhost", "root", "", "db_tp03");
        if(!$c){
            return "Erro ao estabelecer conexão com o banco";
        } else {
            
            if($ps = mysqli_prepare($c, "UPDATE tb_aluno SET NOME=?, EMAIL=?, DATA=?, COMENTARIO=?, CURSO=?, SEXO=?  WHERE ID = ?") or die(mysqli_error($c))){

                mysqli_stmt_bind_param($ps, "ssssssi", $nmP, $emP, $nsP, $cmP, $csP, $sxP, $idP);
                mysqli_stmt_execute($ps);
            }else{
                echo '<script> alert("Não atualizou"); </script>';
            }
        }
        mysqli_close($c);
    }

    //GETTERS AND SETTERS
    public function getId(){
        return $this->id;
    }

    public function setId($id){
        $this->id = $id;
    }

    public function getNome(){
        return $this->nome;
    }

    public function setNome($nome){
        $this->nome = $nome;
    }

    public function getEmail(){
        return $this->email;
    }

    public function setEmail($email){
        $this->email = $email;
    }

    public function getNascimento(){
        return $this->nascimento;
    }

    public function setNascimento($nascimento){
        $this->nascimento = $nascimento;
    }

    public function getComentario(){
        return $this->comentario;
    }

    public function setComentario($comentario){
        $this->comentario = $comentario;
    }

    public function getCurso(){
        return $this->curso;
    }

    public function setCurso($curso){
        $this->curso = $curso;
    }

    public function getSexo(){
        return $this->sexo;
    }

    public function setSexo($sexo){
        $this->sexo = $sexo;
    }

    public function getAluno(){
        $aluno = "";
        $aluno .= "Nome: ".$this->getNome();
        $aluno .= "<br>Email: ".$this->getEmail();
        $aluno .= "<br>Data: ".$this->getNascimento();
        $aluno .= "<br>Comentário: ".$this->getComentario();
        $aluno .= "<br>Curso: ".$this->getCurso();
        $aluno .= "<br>Sexo: ".$this->getSexo();
        return $aluno;
    }
}