<%-- 
    Document   : home
    Created on : 14/04/2017, 00:11:32
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="images/money-icon.png"/>
        <title>Home</title>
        <link href="css/semantic-ui/semantic.css" rel="stylesheet" type="text/css">
        <link href="css/estilo.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecalho.jspf" %>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div class="ui main text container">
            <h1 class="ui header">Amortização</h1>
            <p>Amortização é um processo de extinção de uma dívida através de pagamentos periódicos, que são realizados em função de um planejamento, de modo que cada prestação corresponde à soma do reembolso do capital ou do pagamento dos juros do saldo devedor, podendo ser o reembolso de ambos, sendo que os juros são sempre calculados sobre o saldo devedor.</p>
            <h2 class="ui horizontal divider header"> Amortização Constante </h2>       
            <h3 class="ui header"> <i class="dollar icon"></i>Constante</h3>
            <p>Sistema de Amortização Constante (SAC) é uma forma de amortização de um empréstimo por prestações que incluem os juros, amortizando assim partes iguais do valor total do empréstimo.
Neste sistema o saldo devedor é reembolsado em valores de amortização iguais. Desta forma, no sistema SAC o valor das prestações é decrescente, já que os juros diminuem a cada prestação. </p>
               
 <h2 class="ui horizontal divider header"> Amortização Americana </h2>
 <h3 class="ui header"> <i class="dollar icon"></i>Americana</h3>
 <p>O Sistema de Amortização Americano é uma forma de pagamento de empréstimos que se caracteriza pelo pagamento apenas dos juros da dívida,deixando o valor da dívida constante, que pode ser paga em apenas um único pagamento.
Esse sistema de amortização tem a vantagem em relação ao sistema de pagamento único, pois nele não há incidência de juros sobre juros.</p>
 <h2 class="ui horizontal divider header"> Tabela Price </h2>
 <h3 class="ui header"> <i class="dollar icon"></i>Price</h3>
 <p>Também chamado de Sistema de Parcelas Fixas, ou Sistema Francês, é caracterizado por pagamentos mensais iguais, embutindo uma amortização crescente.
  O cálculo das parcelas de uma prestação segundo o método Price segue uma fórmula onde o valor de cada prestação é dada de acordo com o valor presente do bem, a taxa de juros e o período financiado. Na prática, o que acontece é que, embora o saldo devedor cresça em função dos juros, o pagamento das parcelas anteriores e a amortização de parte do saldo devedor fazem com que o valor das parcelas não cresça. </p>
        </div>
 
        <!--Equipe-->
 <h2 class="ui horizontal divider header"> Equipe </h2>
 <div id="equipe">
        <div class="content">
            <div class="ui main container">
                <div class="ui link cards">
                    <div class="ui three column  stackable grid cards container">
                        <div class="column">
                            <div class="ui fluid card">
                                <div class="image">
                                    <img src="images/leonardo.jpg"/>
                                </div>
                                <div class="content">
                                    <div class="header">Leonardo Santos</div>
                                    <div class="meta">
                                        <a>Desenvolvedor</a>
                                    </div>
                                    <div class="description">Home, estilização e Amortização Constante</div>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="ui fluid card">
                                <div class="image">
                                    <img src="images/rafael.jpg"/>
                                </div>
                                <div class="content">
                                    <div class="header">Rafael Araújo</div>
                                    <div class="meta">
                                        <a>Desenvolvedor</a>
                                    </div>
                                    <div class="description">Amortização Americana</div>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="ui fluid card">
                                <div class="image">
                                    <img src="images/thiago.jpg"/>
                                </div>
                                <div class="content">
                                    <div class="header">Thiago Morais</div>
                                    <div class="meta">
                                        <a>Desenvolvedor</a>
                                    </div>
                                    <div class="description">Tabela Price</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </div>
        <%@include file="WEB-INF/jspf/rodape.jspf" %>
    </body>
</html>
