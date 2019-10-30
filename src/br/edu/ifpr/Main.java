/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr;

/**
 *
 * @author Amanda
 */
public class Main {
    public static void main(String[] args) {
        
        int [][]sudoku = new int[9][9];     
        char nivel = Sudoku.escolheDificuldade();
        sudoku = Sudoku.selecionaJogo(nivel);        
        Sudoku.imprimeJogo(sudoku);
        Sudoku.boasVindas();
        Sudoku.entradaDados(sudoku);
 
   } // main
}
