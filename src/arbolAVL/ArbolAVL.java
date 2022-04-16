/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolAVL;

/**
 *
 * @author Hector Fabio Romero
 */
public class ArbolAVL<T extends Comparable<T>> {
    
    public NodoAVL<T> rotarIzquierda(NodoAVL<T> nodo){
        NodoAVL<T> nodoTemporal = nodo.getNodoAVLIzquierda();
        nodo.setNodoAVLIzquierda(nodoTemporal.getNodoAVLDerecha());
        nodoTemporal.setNodoAVLDerecha(nodo);
        
        // FALTA MÉTODO PARA CAMBIAR LA ALTURA
        return nodoTemporal;
        
    }
   
    
}
