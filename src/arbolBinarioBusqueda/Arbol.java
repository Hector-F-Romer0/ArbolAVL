/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBinarioBusqueda;

/**
 * Clase encargada de gestionar los nodos en su interior.
 *
 * @author juliana.loaiza@uao.edu.co Juliana Loaiza Mejia Código 2205498
 * @author hector_fabio.romero@uao.edu.co Hector Fabio Romero Bocanegra Código 2205024
 * @author andres.aristizabal_m@uao.edu.co Andrés Felipe Aristizabal Miranda Código 2205296
 * @date 13 abril 2022
 * @version 1.0
 */
public class Arbol<T extends Comparable<T>> {
    
    private Nodo<T> nodoRaiz;

    public Arbol() {
    }
    
    public Arbol(Nodo nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }
    
    /**
     * Get the value of nodoRaiz
     *
     * @return the value of nodoRaiz
     */
    public Nodo getNodoRaiz() {
        return nodoRaiz;
    }

    /**
     * Set the value of nodoRaiz
     *
     * @param nodoRaiz new value of nodoRaiz
     */
    public void setNodoRaiz(Nodo nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    public boolean existeNodo(T valorBuscado){
        //Este primer método será el que desencadene la búsqueda.
        return existeNodo(this.nodoRaiz,valorBuscado);
    }
    
    public boolean existeNodo(Nodo<T> nodoAVerificar, T valorBuscado){
        // Si el nodo a verificar es nulo, significa que el árbol no tiene un nodo raíz.
        // Por consiguiente, no se puede buscar un nodo en un árbol vacío.
        if(nodoAVerificar == null){
            return false;
        }
        
        // Si el valor a buscar coincide con el valor del nodo, retorna verdadero
        if(nodoAVerificar.getDato() == valorBuscado){
            return true;
        }
        /*Usamos compareTo para comocer si el valorBuscado(que arriba especificamos que DEBE heredar la interfaz Comparable<T>)
        es menor que el dato del nodo que estamos verificando. CompareTo devuelve -1 si es menor, 0 si es igual y 1 si el valor es mayor
        al que se está comparando.
        */
        else if((valorBuscado.compareTo(nodoAVerificar.getDato()))<0){
            // Si es menor que el valor que estamos comparamos, procederemos a hacer la búsqueda en el nodo izquiedo.
            return existeNodo(nodoAVerificar.getNodoIzquierda(), valorBuscado);
        }else{
            return existeNodo(nodoAVerificar.getNodoDerecha(), valorBuscado);
        }
    }
    
    public void insertarNodo(T dato){
            if(this.nodoRaiz == null){
                // Si el nodo raiz no existe, se añade el dato como un nodo raiz que no tiene "de momento" subárbol derecho o izquierdo.
                this.nodoRaiz = new Nodo(dato);
            }else{
                // Si el árbol tiene raiz, entonces procederemos a ejecutar el método recursivo de insertar
                insertarNodo(nodoRaiz,dato);
            }
        }
    
    public void insertarNodo(Nodo<T> nodoPadre, T dato){
        // Si el dato es menor que el dato del nodoPadre, deberá añadirse al lado izquierdo del árbol.
        if(dato.compareTo(nodoPadre.getDato())<0){
            // Si el nodo izquierdo es nulo(no existen más elementos para compararlo), entonces añado el nuevo dato como un nodo hoja de dicho padre.
            if(nodoPadre.getNodoIzquierda()==null){
                nodoPadre.setNodoIzquierda(new Nodo(dato));
            }else{
                // Si no está vacío el nodo izquierdo, procedemos a realizar el mismo método pero con el nodo izquierdo tratado como el "padre".
                this.insertarNodo(nodoPadre.getNodoIzquierda(), dato);
            }
        }else if(dato.compareTo(nodoPadre.getDato())>0){
            if(nodoPadre.getNodoDerecha() == null){
                nodoPadre.setNodoDerecha(new Nodo(dato));
            }else{
                this.insertarNodo(nodoPadre.getNodoDerecha(), dato);
            }
        }else{
            System.out.println("Los nodos son iguales. No pueden existir nodos duplicados");
        }
    }
    
}
