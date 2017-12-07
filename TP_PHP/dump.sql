-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 07/06/2017 às 20:26
-- Versão do servidor: 10.1.21-MariaDB
-- Versão do PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_tp03`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_aluno`
--

CREATE TABLE `tb_aluno` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `data` date NOT NULL,
  `comentario` text,
  `curso` varchar(40) NOT NULL,
  `sexo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_aluno`
--

INSERT INTO `tb_aluno` (`id`, `nome`, `email`, `data`, `comentario`, `curso`, `sexo`) VALUES
(1, 'Jonatas do Carmo Feijó Lopes', 'jonatas_lopes@outlook.com', '1997-12-31', 'Meu comentário 1', 'Análise e Desenvolvimento de Sistemas', 'Masculino'),
(2, 'Leonardo Santos Severino', 'leonardossev@gmail.com', '1996-05-19', 'Meu comentário 2', 'Análise e Desenvolvimento de Sistemas', 'Masculino');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `tb_aluno`
--
ALTER TABLE `tb_aluno`
  ADD PRIMARY KEY (`id`);
