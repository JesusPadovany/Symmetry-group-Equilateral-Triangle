/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoAlgebra.clases;

public class Permutacion {
    
    //Atributo
    private int matriz [][] = new int[2][3];
    private String nombre;
    
    //Constructores con parámetros
    public Permutacion ( int pos1, int pos2, int pos3, String nombre){
        columnaPredeterminada();            // 1 2 3
        matriz[1][0] = pos1;
        matriz[1][1] = pos2;
        matriz[1][2] = pos3;
        this.nombre= nombre;
    }
    public Permutacion ( int pos1, int pos2, int pos3){
        columnaPredeterminada();            // 1 2 3
        matriz[1][0] = pos1;                
        matriz[1][1] = pos2;
        matriz[1][2] = pos3;
    }
    //Sin parámetros
    Permutacion() {
        columnaPredeterminada();
        for (int i = 0; i < 3; i++) {       
            matriz[1][i] = 0;             //Estos valores serán actualizados despues de una operación
        }
    }
    
    //Método que inicializa la primera columna en 1 2 3 
    private void columnaPredeterminada(){
        for (int i = 0; i < 3; i++) {      
            matriz[0][i]= i+1;
        }
    }
    
    
    //Sets y Gets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setMatriz(int[][] matriz){
        this.matriz=matriz;
    }
  
    public int[][] getMatriz() {
        return matriz;
    }
    
    //OTROS MÉTODOS
  
    //Actualizando valores (2da fila) despues de la operación
    public void setMatriz(int p1, int p2, int p3) {
        this.matriz[1][0] = p1;         
        this.matriz[1][1] = p2;
        this.matriz[1][2] = p3;
    }
    
    public int getVertice(int base){
        return matriz[1][base-1];
    }
    
    
    //Para pruebas
    
    //Imprime la segunda columna
    public void imprimir(){
        for (int i = 0; i < 3; i++) {
            System.out.print(matriz[1][i]+ " ");
        }
    }
    
    //Imprime la matriz completa
    public void imprimirMatriz(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
}
