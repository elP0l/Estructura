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
public class ArrayList<E> implements List<E> {
    
    private E[] elements = null; //arreglo de elementos genericos
    private int capacity = 100;
    private int effectiveSize;
    
    public ArrayList (){
        
        //int[] a;
        
        //a = new int[100];
        
        //elements = new E[100]; NO FUNCIONA
        
        elements = (E[])(new Object[capacity]); // SI FUNCIONA con Casting permitido con el arrayList
        effectiveSize = 0;
    }
    
    private boolean isFull(){
        return effectiveSize == capacity;
    }
    
    private void addCapacity() {
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++){
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }

    @Override
    public boolean addFirst(E e) {
        // no se insertan nulos
        if(e==null){
            return false;
        } else if (isEmpty()){
            elements[0] = e;
            effectiveSize++;
            //elements[effectiveSize ++] = e; //otra forma de hacer las 2 lineas anteriores
            return true;
        } else if (isFull()){
            addCapacity();
        }
        
        for (int i=effectiveSize-1; i >=0; i--){
            elements[i+1]=elements[i]; //bit shifting 
            //desplazamiento de valores hacia la derecha, 
            //debe empezar de atras hacia adelante
        }
        elements[0] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        elements[effectiveSize] = e;
        effectiveSize++;
        //elements[effectiveSize++] = e; otra forma de hacer las 2 lineas anteriores
        return true;
    }

    @Override
    public E removeFirst() {
        if(effectiveSize!=0){
            E e = elements[0];
            for(int i=0;i<effectiveSize-1;i++){
                elements[i] = elements[i+1];
            }
            elements[effectiveSize-1] = null;
            return e;
        }else{
            return null;
        }
    }

    @Override
    public E removeLast() {
        if(effectiveSize!=0){
            E e = elements[effectiveSize-1];
            elements[effectiveSize-1] = null;
            return e;
        }else{
            return null;
        }
    }

    @Override
   public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < effectiveSize; i++) {
        sb.append(elements[i]);
        if (i < effectiveSize - 1) {
            sb.append(", ");
        }
    }
    return sb.toString();
}
    
    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
     public ArrayList<E> findAll(Comparator<E> comp, E element) {
        ArrayList<E> result = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (comp.compare(elements[i], element) == 0) {
                result.addLast(elements[i]);
            }
        }
        return result;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > effectiveSize) {
            // throw new IndexOutOfBoundsException("Invalid index: " + index);
            //return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
            // elements[i+1] = elements[i]; MAL
        }
        elements[index] = element;
        effectiveSize++;
        //return true;
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
        return null;
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it=new Iterator<E>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < effectiveSize;
            }
            @Override
            public E next() {
                E e=elements[cursor];
                cursor++;
                return e;
            }
        };
        return it;   
    }
   @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
    @Override
    public E find(Comparator<E> comp, E element){
        for(int i=0; i< size();i++){
            if(comp.compare(elements[i], element)==0){
                return elements[i];
            }
        }
        return null;
    }

    /*
    @Override
    public List<E> findIntersection(List<E> another) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */

    @Override
    public List<E> findIntersection(List<E> another, Comparator<E> cmp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
