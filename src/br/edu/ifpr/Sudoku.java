/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr;

import java.util.Scanner;

public class Sudoku {
    
    public static int[][] selecionaJogo(char dif){
        switch (dif) {
            case 'f':
                case 'F':
            {
                int [][]jogo = new int[9][9];
                
                jogo[0][1]=8; jogo[0][5]=5; jogo[1][1]=3;
                jogo[1][1]=3; jogo[1][2]=9; jogo[1][3]=2; jogo[1][5]=1; jogo[1][7]=8; jogo[1][8]=7;
                jogo[2][2]=6; jogo[2][4]= 8; jogo[2][6]= 9; jogo[2][7]= 2;
                jogo[3][0]=7; jogo[3][1]=2; jogo[3][7]=3;
                jogo[4][2]=4; jogo[4][6]=1;
                jogo[5][1]=6; jogo[5][7]=7; jogo[5][8]=2;
                jogo[6][1]=4; jogo[6][2]=5; jogo[6][4]=3; jogo[6][6]=7;
                jogo[7][0]=8; jogo[7][1]=7; jogo[7][3]=1; jogo[7][5]=9; jogo[7][6]=2; jogo[7][7]= 6;
                jogo[8][3]=5; jogo[8][7]=9;
                
                return jogo;
                
            }
            case 'm':
                case 'M':
            {
                int [][]jogo = new int[9][9];
                
                jogo[0][0]=7; jogo[0][1]=8; jogo[0][7]=3;
                jogo[1][4]=3;
                jogo[2][1]=6; jogo[2][2]=3; jogo[2][3]=5; jogo[2][5]=2;
                jogo[3][0]=3; jogo[3][5]=1; jogo[3][6]=9; jogo[3][7]=4;
                jogo[4][3]=4; jogo[4][5]=5;
                jogo[5][1]=4; jogo[5][2]=2; jogo[5][3]=3; jogo[5][8]=8;
                jogo[6][3]=2; jogo[6][5]=9; jogo[6][6]=3; jogo[6][7]=6;
                jogo[7][4]=8;
                jogo[8][1]=5; jogo[8][7]=1; jogo[8][8]=4;
                return jogo;
                
            }
            case 'd':
                case 'D':
            {
                int [][]jogo = new int[9][9];
                
                jogo[0][0]=8; jogo[0][1]=1; jogo[0][7]=2; jogo[0][8]=7;
                jogo[1][2]=4; jogo[1][6]=1;
                jogo[2][0]=2; jogo[2][1]=3; jogo[2][7]=4; jogo[2][8]=5;
                jogo[3][3]=1; jogo[3][4]=7; jogo[3][5]=4;
                jogo[4][0]=4; jogo[4][3]=5; jogo[4][5]=6; jogo[4][8]=9;
                jogo[5][1]=7; jogo[5][4]=3; jogo[5][7]=1;
                jogo[6][4]=1;
                jogo[7][1]=4; jogo[7][2]=3; jogo[7][6]=6; jogo[7][7]=5;   
                jogo[8][0]=1; jogo[8][3]=3; jogo[8][5]=7; jogo[8][8]=8;
                
                return jogo;
            }
            default:
            {
                int [][]jogo = new int[9][9];
                System.out.println("Nível inválido, digite 'f', 'm' ou 'd':");
                escolheDificuldade();
                return jogo;
            }
        }
    }
    
    public static char escolheDificuldade(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Esolha o nível de dificuldade: (f)fácil, (m)médio ou (d)difícil.");
        char nivel = entrada.next().charAt(0);
        return nivel;
    } // escolheDificuldade()
    
    public static void boasVindas(){
        String CSI = "\u001B[";
        System.out.print (CSI + "35" + "m");
        System.out.println("Bem-vindo ao Sudoku.");
        System.out.println (CSI + "m");
    }
    
    public static void entradaDados(int[][]matriz){
        char resposta = 's';
       
        while((resposta =='s') || (resposta== 'S')){   
         Scanner entrada = new Scanner(System.in);
         System.out.println("Nova jogada.");
         System.out.print("Escolha a linha (0 a 8):");
         int linha = entrada.nextInt();
         if(linha>8){
             System.err.println("Tamanho inválido, digite um valor entre de 0 a 8.");
             entradaDados(matriz);
         }
         System.out.print("Escolha a coluna (0 a 8):");
         int coluna = entrada.nextInt();
         if(coluna>8){
             System.err.println("Tamanho inválido, digite um valor entre de 0 a 8.");
             entradaDados(matriz);
         }
         System.out.println("Qual será o número a ser inserido?");
         int num = entrada.nextInt();
         if(num<10){ // número válido
             if(validaJogada(matriz, linha, coluna, num)){
                    matriz[linha][coluna] = num;
                    imprimeJogo(matriz);
                    System.out.println("Deseja continuar? (s/n)");
                    resposta = entrada.next().charAt(0);
            }else{
                imprimeJogadaInvalida(matriz, linha, coluna, num);
                System.err.println("Jogada inválida");
                System.out.println("Deseja continuar? (s/n)");
                resposta = entrada.next().charAt(0);
                    if(resposta == 's' || resposta == 'S'){
                        imprimeJogo(matriz);
                    }     
                }               
         }else{
             System.err.println("Número inválido. Digite um número de 0 a 9.");
             entradaDados(matriz);
         }
               
        } // while resposta       
    } // entradaDados()
    
    public static boolean validaJogada(int [][]m, int l, int c, int n){
        for(int i=0; i<m.length; i++){
            if(i==l){ // buscando na linha selecionada
                for(int b=0; b<m[0].length; b++){
                    if(m[i][b]== n){ 
                        return false;
                    }
                }// fim da busca na linha


            }// if i == l
            
            for(int j=0; j<m[0].length;j++){
                if(j==c){//buscando na coluna selecionada
                    for(int a=0; a<m.length; a++){
                        if(m[a][j]== n){
                            return false;
                        }
                    } // for interno da coluna
                } // fim da busca na coluna
            }// for j
            
        }//for i   
        
        // procurando no quadrante 'selecionado'
        int linha = l - l%3;
        int coluna = c - c%3;
        for(int i=linha; i<linha+3; i++){
            for(int j=coluna; j<coluna+3; j++){
                if(m[i][j] == n){
                return false;
                }
            }
        }// fim da busca no quadrante
        
        return true;        
    }// validaJogada
    
    public static void imprimeJogo(int [][]jogo){
        System.out.println("- - - - - - - - - - - - - - ");
            for(int i=0; i<jogo.length; i++){
                System.out.print("| ");
                
                
            for(int j=0; j<jogo[0].length; j++){
                System.out.print(jogo[i][j] + " ");
                if((j+1)%3==0){
                    System.out.print(" | ");
                }
            } 
            System.out.println("");
            if((i+1)%3 == 0){  
                System.out.println("- - - - - - - - - - - - - - ");    
            }          
        }    
    }//imprimeJogo();

    public static void imprimeJogadaInvalida(int [][]jogo, int linha, int coluna, int n){
        System.out.println("- - - - - - - - - - - - - - ");
        
            for(int i=0; i<jogo.length; i++){
                System.out.print("| ");
                for(int j=0; j<jogo[0].length; j++){
                    if(i == linha || j == coluna){                                               
                        if(jogo[i][j] == n){
                            String CSI = "\u001B[";
                            System.out.print (CSI + "31" + "m");
                            System.out.print(jogo[i][j] + " ");
                            System.out.print (CSI + "m");
                          // System.err.print(jogo[i][j] + " "); POR QUE NÃO FUNCIONA???
                        }else{
                          System.out.print(jogo[i][j] + " ");
                        }                       
                    }else{
                        System.out.print(jogo[i][j] + " ");
                    }
                    
                    if((j+1)%3==0){ // separação das colunas em blocos de 3 unidades.
                       System.out.print(" | ");
                    }                   
                }// for j            
                System.out.println("");
                if((i+1)%3 == 0){  // separação das linhas em blocos de 3 unidades.
                    System.out.println("- - - - - - - - - - - - - - ");    
                }
            }// for i        
    }//imprimeJogadaInvalida
    
        
    
}//classe Sudoku
