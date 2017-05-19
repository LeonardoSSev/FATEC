package com.domain.quiz;

import java.util.ArrayList;

public class Quiz {
    private static int testsCount = 0;
    private static double testsGradeSum = 0.0;
    private static double lastGrade = 0.0;
    public static ArrayList<Question> test;
    
    
   public static ArrayList<Question> getTest(){
        if(test == null){
            test = new ArrayList<>();
            Question q1 = new Question("Qual elemento faz referência a uma tabela?", "table", new String[]{"ol","header","table"});
            test.add(q1);
            Question q2 = new Question("Qual é o significado de HTML?", "HyperText Markup Language", new String[]{"HyperText Transfer Protocol","Cascading Style Sheets","HyperText Markup Language"});
            test.add(q2);
            Question q3 = new Question("Qual é o significado da sigla EE em Java EE?", "Enterprise Edition", new String[]{"Enterprise Edition","Engaged Edition","Enormous Edition"});
            test.add(q3);
            Question q4 = new Question("Com qual método é possível resgatar um dado passado por parâmetro na URL?", "request.getParameter()", new String[]{"response.sendRedirect()","request.getParameter()","request.getContentType()"});
            test.add(q4);
            Question q5 = new Question("O que significa JSP?", "Java Server Page", new String[]{"Java Server Page","Java Send Protocol","JavaScript Server Page"});
            test.add(q5);
            Question q6 = new Question("Qual elemento faz referência a um rodapé?", "footer", new String[]{"foot","footer","rodape"});
            test.add(q6);
            Question q7 = new Question("Por convenção, aonde deve-se armazenar as JSPF's?", "Em uma pasta própria pra ela dentro da pasta WEB-INF", new String[]{"Junto às outras JSP's","Na pasta META-INF","Em uma pasta própria pra ela dentro da pasta WEB-INF"});
            test.add(q7);
            Question q8 = new Question("O que significa POO?", "Programação Orientada a Objetos", new String[]{"Programação Orientada a Objetos","Programação para Objetos Ocultos","Programando Objetos Organizados"});
            test.add(q8);
            Question q9 = new Question("O que significa CSS?", "Cascading Style Sheets", new String[]{"Cascading Sheets Style","Cascading Server Site","Cascading Style Sheets"});
            test.add(q9);
            Question q10 = new Question("Qual a assinatura do método main em Java?", "public static void main(String[] args)", new String[]{"public int(String[] args)","public static void main(String[] args)","public static void()"});
            test.add(q10);
        }
        return test;
    }
    
    public static double validateTest(String userAnswers[]){
        int count = 0;
        for(int i=0; i<test.size(); i++){
            if(test.get(i).getAnswer().equals(userAnswers[i])){
                count++;
            }
        }
        double grade = (double)count / (double)test.size();
        Quiz.lastGrade = grade;
        Quiz.testsGradeSum += grade;
        Quiz.testsCount++;
        return grade;
    }
    
    public static double getLastGrade(){
        return Quiz.lastGrade;
    }
    
    public static double getGradeAverage(){
        return Quiz.testsGradeSum / (double)Quiz.testsCount;
    }
}