/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolAVL;

/**
 * Clase encargada de gestionar los nodosAVL en su interior.
 *
 * @author juliana.loaiza@uao.edu.co Juliana Loaiza Mejia Código 2205498
 * @author hector_fabio.romero@uao.edu.co Hector Fabio Romero Bocanegra Código 2205024
 * @author andres.aristizabal_m@uao.edu.co Andrés Felipe Aristizabal Miranda Código 2205296
 * @date 15 abril 2022
 * @version 1.0
 */
public class ArbolAVL<T extends Comparable<T>> {
    
    private NodoAVL<T> nodoRaizAVL;

    public ArbolAVL() {
    }

    public ArbolAVL(NodoAVL<T> nodoRaizAVL) {
        this.nodoRaizAVL = nodoRaizAVL;
    }
    
    /**
     * Get the value of nodoRaizAVL
     *
     * @return the value of nodoRaizAVL
     */
    public NodoAVL getNodoRaizAVL() {
        return nodoRaizAVL;
    }

    /**
     * Set the value of nodoRaizAVL
     *
     * @param nodoRaizAVL new value of nodoRaizAVL
     */
    public void setNodoRaizAVL(NodoAVL nodoRaizAVL) {
        this.nodoRaizAVL = nodoRaizAVL;
    }
    
    public String recorridoInOrder(NodoAVL<T> node) {
        if (node == null) {
            return "Null";
        } else {
            String c = "";
            if (node.getNodoAVLIzquierda() != null) {
                c += recorridoInOrder(node.getNodoAVLIzquierda());
            }
            c += "" + node.getDato() +"\n";
            System.out.printf("%s ", node.getDato());
            if (node.getNodoAVLDerecha() != null) {
                c += recorridoInOrder(node.getNodoAVLDerecha());
            }
            return c;
        }
    }

    public String preOrder(NodoAVL<T> node) {
        String c = "";
        if (node != null) {
            c += node.getDato();
            if (node.getNodoAVLIzquierda() != null) {
                c += recorridoInOrder(node.getNodoAVLIzquierda());
            }
            if (node.getNodoAVLDerecha() != null) {
                c += recorridoInOrder(node.getNodoAVLDerecha());
            }
        }
        return c;
    }

    public String postOrder(NodoAVL<T> node) {
        String c = "";
        if (node != null) {
            if (node.getNodoAVLIzquierda() != null) {
                c += recorridoInOrder(node.getNodoAVLIzquierda());
            }
            if (node.getNodoAVLDerecha() != null) {
                c += recorridoInOrder(node.getNodoAVLDerecha());
            }
            c += node.getDato();
        }
        return c;
    }
    
    
    
    public boolean existeNodo(T valorBuscado){
        //Este primer método será el que desencadene la búsqueda.
        return existeNodo(this.nodoRaizAVL,valorBuscado);
    }
    
    public boolean existeNodo(NodoAVL<T> nodoAVerificar, T valorBuscado){
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
            return existeNodo(nodoAVerificar.getNodoAVLIzquierda(), valorBuscado);
        }else{
            return existeNodo(nodoAVerificar.getNodoAVLDerecha(), valorBuscado);
        }
    }

    public void insertarNodo(T dato){
        if(this.nodoRaizAVL == null){
            // Si el nodo raiz no existe, se añade el dato como un nodo raiz que no tiene "de momento" subárbol derecho o izquierdo.
            this.nodoRaizAVL= new NodoAVL(dato);
        }else{
            // Si el árbol tiene raiz, entonces procederemos a ejecutar el método recursivo de insertar
            insertarNodo(nodoRaizAVL,dato);
        }
    }
    
    public void insertarNodo(NodoAVL<T> nodoPadre, T dato){
        // Si el dato es menor que el dato del nodoPadre, deberá añadirse al lado izquierdo del árbol.
        if(dato.compareTo(nodoPadre.getDato())<0){
            // Si el nodo izquierdo es nulo(no existen más elementos para compararlo), entonces añado el nuevo dato como un nodo hoja de dicho padre.
            if(nodoPadre.getNodoAVLIzquierda()==null){
                nodoPadre.setNodoAVLIzquierda(new NodoAVL(dato));
            }else{
                // Si no está vacío el nodo izquierdo, procedemos a realizar el mismo método pero con el nodo izquierdo tratado como el "padre".
                this.insertarNodo(nodoPadre.getNodoAVLIzquierda(), dato);
            }          
        }else if(dato.compareTo(nodoPadre.getDato())>0){
            if(nodoPadre.getNodoAVLDerecha() == null){
                nodoPadre.setNodoAVLDerecha(new NodoAVL(dato));
            }else{
                this.insertarNodo(nodoPadre.getNodoAVLDerecha(), dato);
            }
        }else{
            System.out.println("Los nodos son iguales. No pueden existir nodos duplicados");
        }     
        // Se llama al método que actualizará la altura y factor de balanceo de los nodos.
        ajustarAlturayFE(nodoPadre);
        ajustarBalanceo(nodoPadre);
    }
    
    public void ajustarAlturayFE(NodoAVL<T> nodoABalancear){
        int alturaNodoIzquierdo;
        int alturaNodoDerecho;
        
        if(nodoABalancear.getNodoAVLIzquierda() == null){
            alturaNodoIzquierdo = -1;
        }else{
            alturaNodoIzquierdo = nodoABalancear.getNodoAVLIzquierda().getAltura();
        }
        
        if(nodoABalancear.getNodoAVLDerecha() == null){
            alturaNodoDerecho = -1;
        }else{
            alturaNodoDerecho = nodoABalancear.getNodoAVLDerecha().getAltura();
        }
        
        nodoABalancear.setAltura(1 + Math.max(alturaNodoIzquierdo, alturaNodoDerecho));
        nodoABalancear.setFactorDeEquilibrio(alturaNodoDerecho-alturaNodoIzquierdo);
    }
    
    public void ajustarBalanceo(NodoAVL<T> nodoABalancear){
        // Si el fe del nodo que rompe el balanceo es -2 se hará una rotación a la derecha
        if(nodoABalancear.getFactorDeEquilibrio() == -2){
            // Si el fe del nodo izquierdo hijo es -1(menor o igual a 0/posee el mismo signo del fe del padre), se hará una rotación simple a la derecha
            if(nodoABalancear.getNodoAVLIzquierda().getFactorDeEquilibrio() <=0){
                rotarIzquierda(nodoABalancear);
            }else{
                // Si el fe del nodo izquierdo hijo es 1 (posee signo DIFERENTE al fe del padre), se hará una rotación doble a la derecha.
                nodoABalancear.setNodoAVLIzquierda(rotarDerecha(nodoABalancear.getNodoAVLIzquierda()));
                nodoABalancear = rotarIzquierda(nodoABalancear);
            }
        } // Si el fe del nodo que rompe con el balanceo es +2, se hará una rotación a la izquierda
        else if(nodoABalancear.getFactorDeEquilibrio() == 2){
            // Si el fe del nodo derecho hijo es -1(menor o igual a 0/posee el mismo signo del fe del padre), se hará una rotación simple a la izquierda
            if(nodoABalancear.getNodoAVLDerecha().getFactorDeEquilibrio() <=0){
                 rotarDerecha(nodoABalancear);
            }else{
                // Si el fe del nodo derecho hijo es 1 (posee signo DIFERENTE al fe del padre), se hará una rotación doble a la derecha.
                nodoABalancear.setNodoAVLDerecha(rotarIzquierda(nodoABalancear.getNodoAVLDerecha()));
		nodoABalancear = rotarDerecha(nodoABalancear);                
            }
        }
    }
         
    public NodoAVL<T> rotarIzquierda(NodoAVL<T> nodo){
        NodoAVL<T> nodoTemporal = nodo.getNodoAVLIzquierda();
        nodo.setNodoAVLIzquierda(nodoTemporal.getNodoAVLDerecha());
        nodoTemporal.setNodoAVLDerecha(nodo);
        ajustarAlturayFE(nodo);
        ajustarAlturayFE(nodoTemporal);
        return nodoTemporal; 
    }
    
    public NodoAVL<T> rotarDerecha(NodoAVL<T> nodo){
        NodoAVL<T> nodoTemporal = nodo.getNodoAVLDerecha();
        nodo.setNodoAVLDerecha(nodoTemporal.getNodoAVLIzquierda());
        nodoTemporal.setNodoAVLIzquierda(nodo);
        ajustarAlturayFE(nodo);
        ajustarAlturayFE(nodoTemporal);
        return nodoTemporal;
    }  
        
    private int calcularFactorEquilibrio(NodoAVL<T> nodo){
        //Si el nodo es vacío, quiere decir que se refiere al nodo raíz que se inserta por primera vez. Por lo tanto, su factor de equilibrio será 0
        int factorCalculado;
        if(nodo==null){
            return 0;
        }else{
            // Procede a restar la altura del subárbol derecho con la del izquierdo.
            factorCalculado = nodo.getNodoAVLDerecha().getAltura()-nodo.getNodoAVLIzquierda().getAltura();
        }
        return factorCalculado;
    }
   
    public void eliminarNodo(T datoAEliminar){
        eliminarNodo(nodoRaizAVL, datoAEliminar);
    }
    
    public NodoAVL<T> eliminarNodo(NodoAVL<T> nodoPadre, T datoAEliminar){
        if(nodoPadre== null){
            return nodoPadre;
        }
        // Si el dato es menor que el dato del nodoPadre, deberá añadirse al lado izquierdo del árbol.
        if(datoAEliminar.compareTo(nodoPadre.getDato())<0){
            //Si el dato es menor que el dato del nodo padre, cambiaremos el valor del nodo hijo izquierdo por medio de un llamado recursivo al método eliminar
            nodoPadre.setNodoAVLIzquierda(eliminarNodo(nodoPadre.getNodoAVLDerecha(), datoAEliminar));
        }else if(datoAEliminar.compareTo(nodoPadre.getDato())>0){
            nodoPadre.setNodoAVLDerecha(eliminarNodo(nodoPadre.getNodoAVLDerecha(), datoAEliminar));
        }else{
           // Cuando el dato del nodo sea igual a la clave pasada como parámetro se evaluarán los siguientes casos:
           
           // Si el nodo posee un único hijo o es hoja, se evaluará que:
           if((nodoPadre.getNodoAVLDerecha()!= null)||(nodoPadre.getNodoAVLIzquierda()!=null)){
               NodoAVL<T> nodoTemporal = null;
               
               // Si el hijo izquierdo del nodo padre es nulo, guardo el valor del hijo derecho (se supone que debe tener si o si un hijo por parte derecha)
               if(nodoTemporal == nodoPadre.getNodoAVLIzquierda()){
                   nodoTemporal= nodoPadre.getNodoAVLDerecha();
               }else{
                   nodoTemporal = nodoPadre.getNodoAVLIzquierda();
               }
               
               // Si después de verificar que el nodo evaluado no tiene hijos, procedemos a igualar ese nodo con un valor de null para borrarlo
               if(nodoTemporal == null){
                   nodoPadre = null;
               }else{
                   // Si el nodo a eliminar solo tiene un hijo, se elimina el valor actual por el valor que tendría su hijo.
                   nodoPadre = nodoTemporal;
               }   
           }else{
               //Si el nodo a eliminar posee dos hijos, debemos identificar cuál de los dos hijos es el predecesor
               // Predecesor: elemento más grande del subárbol IZQUIERDO
               NodoAVL<T> nodoTemporal = obtenerNodoConValorMaximo(nodoPadre.getNodoAVLIzquierda());
               
               // Se copia el dato del predecesor al nodo padre que estamos tratando
               nodoPadre.setDato(nodoTemporal.getDato());
               
               // Procedemos a eliminar el predecesor
               nodoPadre.setNodoAVLIzquierda(eliminarNodo(nodoPadre.getNodoAVLIzquierda(), nodoTemporal.getDato()));
           }  
        }
        
        // Si solo tiene un nodo:
        if(nodoPadre == null){
            return nodoPadre;
        }
        
        ajustarAlturayFE(nodoPadre);
        ajustarBalanceo(nodoPadre);

        return nodoPadre;
    }
    
    private NodoAVL obtenerNodoConValorMaximo(NodoAVL<T> nodoAEvaluar) {
        NodoAVL<T> nodoActual = nodoAEvaluar;
        
        while (nodoActual.getNodoAVLDerecha() != null){
           nodoActual = nodoActual.getNodoAVLDerecha();
        }
        
        return nodoAEvaluar;
    }
    
}
