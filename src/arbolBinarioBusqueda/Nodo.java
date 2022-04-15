/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBinarioBusqueda;

/**
 * Clase encargada de almacenar la información de los nodos que hacen parte del árbol
 *
 * @author juliana.loaiza@uao.edu.co Juliana Loaiza Mejia Código 2205498
 * @author hector_fabio.romero@uao.edu.co Hector Fabio Romero Bocanegra Código 2205024
 * @author andres.aristizabal_m@uao.edu.co Andrés Felipe Aristizabal Miranda Código 2205296
 * @date 13 abril 2022
 * @version 1.0
 */
public class Nodo<T extends Comparable<T>> {
      
    private T dato;
    private Nodo<T> nodoIzquierda, nodoDerecha;

    public Nodo() {
    }
    
    // Constructor para un nodo hoja
    public Nodo(T dato) {
        this.dato = dato;
    }

    public Nodo(T dato, Nodo nodoIzquierda, Nodo nodoDerecha) {
        this.dato = dato;
        this.nodoIzquierda = nodoIzquierda;
        this.nodoDerecha = nodoDerecha;
    }

    /**
     * Get the value of dato
     *
     * @return the value of dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * Set the value of dato
     *
     * @param dato new value of dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    
    /**
     * Get the value of nodoDerecha
     *
     * @return the value of nodoDerecha
     */
    public Nodo getNodoDerecha() {
        return nodoDerecha;
    }

    /**
     * Set the value of nodoDerecha
     *
     * @param nodoDerecha new value of nodoDerecha
     */
    public void setNodoDerecha(Nodo nodoDerecha) {
        this.nodoDerecha = nodoDerecha;
    }

    
    
    /**
     * Get the value of nodoIzquierda
     *
     * @return the value of nodoIzquierda
     */
    public Nodo getNodoIzquierda() {
        return nodoIzquierda;
    }

    /**
     * Set the value of nodoIzquierda
     *
     * @param nodoIzquierda new value of nodoIzquierda
     */
    public void setNodoIzquierda(Nodo nodoIzquierda) {
        this.nodoIzquierda = nodoIzquierda;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", nodoIzquierda=" + nodoIzquierda + ", nodoDerecha=" + nodoDerecha + '}';
    }
}
