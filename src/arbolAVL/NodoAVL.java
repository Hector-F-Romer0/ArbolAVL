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
public class NodoAVL<T extends Comparable<T>>{
    
    private T dato;
    private NodoAVL<T> nodoAVLIzquierda, nodoAVLDerecha;
    private int altura, factorDeEquilibrio;

    public NodoAVL() {
    }
    
    // Constructor para un nodo hoja
    public NodoAVL(T dato) {
        this.dato = dato;
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
    public NodoAVL getNodoAVLDerecha() {
        return nodoAVLDerecha;
    }

    /**
     * Set the value of nodoDerecha
     *
     * @param nodoDerecha new value of nodoDerecha
     */
    public void setNodoAVLDerecha(NodoAVL nodoDerecha) {
        this.nodoAVLDerecha = nodoDerecha;
    }
  
    /**
     * Get the value of nodoIzquierda
     *
     * @return the value of nodoIzquierda
     */
    public NodoAVL getNodoAVLIzquierda() {
        return nodoAVLIzquierda;
    }

    /**
     * Set the value of nodoIzquierda
     *
     * @param nodoIzquierda new value of nodoIzquierda
     */
    public void setNodoAVLIzquierda(NodoAVL nodoIzquierda) {
        this.nodoAVLIzquierda = nodoIzquierda;
    }

    /**
     * Get the value of altura
     *
     * @return the value of altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Set the value of altura
     *
     * @param altura new value of altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Get the value of factorDeEquilibrio
     *
     * @return the value of factorDeEquilibrio
     */
    public int getFactorDeEquilibrio() {
        return factorDeEquilibrio;
    }

    /**
     * Set the value of factorDeEquilibrio
     *
     * @param factorDeEquilibrio new value of factorDeEquilibrio
     */
    public void setFactorDeEquilibrio(int factorDeEquilibrio) {
        this.factorDeEquilibrio = factorDeEquilibrio;
    }

    @Override
    public String toString() {
        return "NodoAVL{" + "dato=" + dato + ", nodoAVLIzquierda=" + nodoAVLIzquierda + ", nodoAVLDerecha=" + nodoAVLDerecha + ", altura=" + altura + ", factorDeEquilibrio=" + factorDeEquilibrio + '}';
    }
}
