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
public class CircularLinkedList<E> implements List<E> {

    private CircularNodeList<E> last;
    
    public CircularNodeList<E> getLast(){
        return last;
    }
    
     public CircularNodeList<E> getHeader(){
        return last.getNext();
    }
    
    public void setLast(CircularNodeList<E> last){
        this.last = last;
    }
    
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addLast(E e) {
        if(e!=null){
            CircularNodeList<E> newNode = new CircularNodeList<>(e);
            if(last!=null){
                newNode.setNext(last.getNext());
                last.setNext(newNode);
                last = newNode;
            }else{
                newNode.setNext(newNode);
                last = newNode;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public E removeFirst() {
        if(last == null){
            return null;
        }
        E circularNodeList = getHeader().getContent();
        if(last==getHeader()){
            last = null;
        }else{
            CircularNodeList<E> first = getHeader();
            last.setNext(first.getNext());
        }
        return circularNodeList;
    }
    @Override
    public E find(Comparator<E> comp, E element){
        return null;
    }

    @Override
    public E removeLast() {
        if(last==null){
            return null;
        }
        E circularNodeList = last.getContent();
        if(last==getHeader()){
            last=null;
        }else{
            CircularNodeList<E> anterior = null;
            CircularNodeList<E> first = getHeader();
            for(CircularNodeList<E> n=getHeader();n!=last;n=n.getNext()){
                anterior = n;
            }
            anterior.setNext(first);
            last = anterior;
        }
        return circularNodeList;
    }
    
    @Override
    public String toString(){
        String s="";
        CircularNodeList<E> n = getHeader();
        while (s.length()==0 || n!=getHeader()){
            s+=n.getContent()+",";
            n.getNext();
        }   
        return s;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

   @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    @Override
    public List<E> findAll(Comparator<E> compa, E i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
