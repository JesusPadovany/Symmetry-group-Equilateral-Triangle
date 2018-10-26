/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoAlgebra.clases;

import java.util.ArrayList;

public class Subgrupo{
    
    //Atributo
    private ArrayList subGrupos;
    
    //Constructor
    public Subgrupo(){
        subGrupos = new ArrayList(6);
        TrianguloEquilatero aux = new TrianguloEquilatero();
        subGrupos.add(aux.grupo);
    }

    //Gets y sets
    public ArrayList getSubGrupos() {
        return subGrupos;
    }

    public void setSubGrupos(ArrayList subGrupos) {
        this.subGrupos = subGrupos;
    }
    
    //Otros métodos
    
    //Método empleado para los generadores cíclicos
    public Permutacion powT(Permutacion perm, int x){
        Permutacion result = new Permutacion();
        TrianguloEquilatero aux = new TrianguloEquilatero();
        if(x==0)                                //Si la potencia es 0
            result =aux.getPi0();             //El resultado es el elemento neutro (PI0)
        else if(x==1){                          // Si la potencia es 1
                result = perm;}                     // El resultado sera el mismo elemento
            else if (x>1){                          // Si es mayor a 1, alli multiplicaremos
                result = perm;                      // primero le asignamos el valor del elemento
                for (int i = 0; i < x -1; i++) {    //Con este ciclo, vamos a repetir la n-1 veces la operacion
                    result = aux.operarPermutaciones(result, perm); //n-1 veces porque arriba ya asignamos el valor (Que seria el caso cuando es 1)
                }
            }
         return result;
    }
    
    //Para buscar los subgrupos cíclicos
    public void generadorCiclico (Permutacion perm){
        int i=0;
        boolean bandera = true;
        if(perm != null){
            ArrayList<Permutacion> aux = new ArrayList<Permutacion>();
            Permutacion auxPerm =perm;
            
            do{
                auxPerm = powT(perm,i);    //Usamos la potencia. i: Cantidad de veces a componer 
                if (i++==0){               //El elemento neutro 
                   aux.add(auxPerm);
                   continue;
                }
                if(aux.get(0).getNombre() == auxPerm.getNombre()){ 
                   bandera=false;
                   continue;
                }
                aux.add(auxPerm);              
            }while(bandera);                //Hasta que el ultimo resultado sea igual que el primero guardado.
            if(!seEncuentra(aux,subGrupos)) //Si no se ha guardado ya
                subGrupos.add(aux);         //lo agregamos 
        }
    }
    
    //Método que recorre el arraylist y Verifica si el subgrupo recibido ya fue guardado 
    private boolean seEncuentra(ArrayList<Permutacion> aux, ArrayList subGrupos) {
        for (int i = 0; i < subGrupos.size(); i++) {
            if(isEquals((ArrayList<Permutacion>) subGrupos.get(i),aux))
                return true;
        }
        return false;
    }

    //Método usado por la función seEncuentra para comparar
    private boolean isEquals(ArrayList<Permutacion> g1, ArrayList<Permutacion> g2 ) {
        int bandera=0;
        if(g1.size() == g2.size()){                                     //si sus long!=,los subg no son iguales 
            for (int i = 0; i < g1.size(); i++) {                       
                for (int j = 0; j < g2.size(); j++) {
                    if(g1.get(i).getNombre() == g2.get(j).getNombre())
                        bandera++;
                }
            }   
        }
        return (bandera==3);
    }
    
    //Recorre el subGrupo y lo acumula en un String
    public String imprimirSub(ArrayList<Permutacion> sb){
        String aux="";
        for (int i = 0; i < sb.size(); i++) 
            aux +=" "+sb.get(i).getNombre();
        
        return aux;
    }
    
    public void getSub(  ArrayList<String > aux,  ArrayList<Permutacion> sb){
        for (int i = 0; i < sb.size(); i++) 
            aux.add( sb.get(i).getNombre());
    }
    
    
}