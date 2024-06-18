/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab03_iteradores_comparadores_paul_alcivar;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author vecto
 */
public class LinkedList<E> implements List<E>{
    
    private NodeList<E> header;
    private NodeList<E> last;
    //private int size = 0;
    
    public LinkedList(){
        this.header=null;
        this.last=null;
    }
    public NodeList<E> getHeader() {
        return header;
    }

    public void setHeader(NodeList<E> header) {
        this.header = header;
    }
    public E get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        NodeList<E> currentNode = header;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getContent();
    }
    public NodeList<E> getLast() {
        return last;
    }

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        //size++;
        if(e!=null) {
            NodeList<E> newNode=new NodeList<>(e); // constructor crea un nodo aislado
            newNode.setNext(header); //El siguiente de ese nuevo nodo es Header
            this.setHeader(newNode); //actualizar el header de la lista
            return true;
        } else {
            return false;
        }
    }
    @Override
    public E find(Comparator<E> comp, E element){
        NodeList<E> he = header;
        while (he != null) {
            if (comp.compare(he.getContent(), element) == 0) {
                return he.getContent(); 
            }
            he = he.getNext();
        }
        return null; 
    }
     @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    
    private NodeList<E> getPrevious(NodeList<E> node){
        NodeList<E> previous = null;
        NodeList<E> n;
        
        for(n = header; n!=node; n= n.getNext()){
            previous = n;
        }
        return previous;
    }
    
    private void recorrerHaciAtras(){
        NodeList<E> n;
        
        for (n = last; n != header; n = this.getPrevious(n)){
            System.out.println(n);
        }
    }

    @Override
    public boolean addLast(E e) {
        //size++;
        if(e!=null){
            NodeList<E> newNode = new NodeList<>(e);
            if(last !=null){
                last.setNext(newNode);
            }
            last=newNode;
            
            if(header == null){
                header = newNode;
            }
            return true;
        } else {
            return false;
        }  
    }

    @Override
    public E removeFirst() {
        if (header == null){
            return null;
        }
        if (header == last){
            E nodeList = header.getContent();
            header = null;
            last = null;
            return nodeList;
        }        
        NodeList<E> nodo = header.getNext();
        header = nodo;
        E nodeList = header.getContent();
        return nodeList;
    }

    @Override
    public E removeLast() {
        if (header == null){
            return null;
        }
        if (header == last){
            E nodeList = header.getContent();
            header = null;
            last = null;
            return nodeList;
        }
        NodeList<E> nodo = header;
        for (NodeList<E> n=header ; n.getNext()!=last ; n= n.getNext()){
            nodo = n;
        }
        E nodeList = last.getContent();
        nodo.setNext(null);
        return nodeList;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodeList<E> current = header;
        while (current != null) {
            sb.append(current.getContent()).append(",");
            current = current.getNext();
        }
        // Eliminar la última coma si hay elementos en la lista
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override
    public int size() {
        // return size; // O(1)
        // primera parte declaro variables a iterar
        // segunda parte condicion logica
        // tercera parte instrucciones
        //for (int i=0, j=0; i < 10 && j >8; i++){
        //for (NodeList<E> n = header; n ! = null ; n = n.getNext()){
        
        // Complejidad lineal O(n) a pesar de que no es tan buena como O(1) evita que tenga que darle mantenimiento a size
        int size = 0;
        NodeList<E> n; //declaro un nodo viajero
        //declaro un nodo viajero, mientras sea diferente de null, se mueve al siguiente nodo
        
        for (n = header ; n!= null ; n = n.getNext( )) {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it=new Iterator<E>() {
                NodeList<E> cursor = header;
                
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                return e;
            }
        };
        
        
        return it;
    }
    @Override
     public List<E> findAll(Comparator<E> comp, E element) {
        LinkedList<E> re = new LinkedList<>();
        NodeList<E> he = header;
        while (he != null) {
            if (comp.compare(he.getContent(), element) == 0) {
                re.addLast(he.getContent());
            }
            he = he.getNext();
        }
        return re;
    }
    
    /*
    public List<E> findIntersection(List<E> otherList){
        LinkedList<E> result = new LinkedList<>();
        for(E e1 : this){
            for(E e2 : otherList){
                if(e1.equals(e2)){
                    result.addLast(e2);
                }
            }
        }
        return result;
    }*/
    
    @Override
    public List<E> findIntersection(List<E> another, Comparator<E> cmp) {
        LinkedList<E> result = new LinkedList<>();
        for (E e1 : this) {
            for (E e2 : another) {
                if (cmp.compare(e1, e2) == 0) {
                    result.addLast(e1);
                }
            }
        }
        return result;
    }

    
    
}
