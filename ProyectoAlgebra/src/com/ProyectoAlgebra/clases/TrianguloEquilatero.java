/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoAlgebra.clases;

import java.util.ArrayList;
import java.util.Arrays;

public class TrianguloEquilatero {
    
    //Atributos
    protected  Permutacion r0, r1, r2;
    protected  Permutacion pi0, pi1, pi2;
    protected ArrayList grupo = new ArrayList(6);
    
    //Constructor
    public TrianguloEquilatero(){
        //Instanciando las permutaciones (360°,120°,240°)
        pi0 = new Permutacion(1,2,3,"Pi0");     
        pi1 = new Permutacion(2,3,1,"Pi1");
        pi2 = new Permutacion(3,1,2,"Pi2");
        //Las reflexiones
        r0 = new Permutacion(1,3,2,"R0");
        r1 = new Permutacion(3,2,1,"R1");
        r2 = new Permutacion(2,1,3,"R2");
        //Agregando al arrayList
        grupo.add(pi0);
        grupo.add(pi1);
        grupo.add(pi2);
        grupo.add(r0);
        grupo.add(r1);
        grupo.add(r2);
    }

    //Sets y Gets
    public Permutacion getR0() {
        return r0;
    }

    public void setR0(Permutacion r0) {
        this.r0 = r0;
    }

    public Permutacion getR1() {
        return r1;
    }

    public void setR1(Permutacion r1) {
        this.r1 = r1;
    }

    public Permutacion getR2() {
        return r2;
    }

    public void setR2(Permutacion r2) {
        this.r2 = r2;
    }

    public Permutacion getPi0() {
        return pi0;
    }

    public void setPi0(Permutacion pi0) {
        this.pi0 = pi0;
    }

    public Permutacion getPi1() {
        return pi1;
    }

    public void setPi1(Permutacion pi1) {
        this.pi1 = pi1;
    }

    public Permutacion getPi2() {
        return pi2;
    }

    public void setPi2(Permutacion pi2) {
        this.pi2 = pi2;
    }


    public ArrayList getGrupo() {
        return grupo;
    }

    public void setGrupo(ArrayList grupo) {
        this.grupo = grupo;
    }
    
 
    //Otros métodos
    
    //Método que retorna la permutación solicitada según el string recibido por parámetros
    public Permutacion buscaPermutacion(String permuta){
        Permutacion aux = new Permutacion();
        switch(permuta){
            case "Pi0":
                aux = getPi0();
                break;
            case "Pi1":
                aux =  getPi1();
                break;
            case "Pi2":
                aux =  getPi2();
                break;
            case "R0":
                aux =  getR0();
                break;
            case "R1":
                aux =  getR1();
                break;
            case "R2":
                aux =  getR2();    
                break;
        }
        return aux;
    }
    
   //Método que realiza la composición de las permutaciones recibidas y la retorna
    public Permutacion operarPermutaciones(Permutacion p1, Permutacion p2){
        int pos1,pos2,pos3;       
        pos1 = p2.getVertice(p1.getVertice(1));
        pos2 = p2.getVertice(p1.getVertice(2));
        pos3 = p2.getVertice(p1.getVertice(3));
        Permutacion aux;
        aux = new Permutacion (pos1,pos2,pos3);
        
        asignaNombre(aux);
        return aux;
    }
 
    //Método que compara la matriz de perm y la de las permutaciones estandar
    //si son iguales, a la perm se le asignara el nombre de la permutacion de la clase
    private void asignaNombre(Permutacion perm ){
        if(Arrays.deepEquals(perm.getMatriz(), pi0.getMatriz()))
            perm.setNombre(pi0.getNombre());
        if(Arrays.deepEquals(perm.getMatriz(), pi1.getMatriz()))
            perm.setNombre(pi1.getNombre());
        if(Arrays.deepEquals(perm.getMatriz(), pi2.getMatriz()))
            perm.setNombre(pi2.getNombre());
        
        if(Arrays.deepEquals(perm.getMatriz(), r0.getMatriz()))
            perm.setNombre(r0.getNombre());
        if(Arrays.deepEquals(perm.getMatriz(), r1.getMatriz()))
            perm.setNombre(r1.getNombre());
        if(Arrays.deepEquals(perm.getMatriz(), r2.getMatriz()))
            perm.setNombre(r2.getNombre());
    }
    
    
    
    
    
}
