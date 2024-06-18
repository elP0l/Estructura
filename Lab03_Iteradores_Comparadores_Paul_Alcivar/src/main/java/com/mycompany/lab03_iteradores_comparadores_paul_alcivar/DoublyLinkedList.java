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
public class DoublyLinkedList<E> implements List<E> {
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    
    public DoublyLinkedList(){
        this.header = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return header == null && last == null;
    }
    
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public DoublyNodeList<E> getHeader() {
        return header;
    }

    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }

    public DoublyNodeList<E> getLast() {
        return last;
    }

    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
    
    /*
    public void getPrevious(NodeList<E> node){
        return previous;
    }*/
  public E find(Comparator<E> comp, E element){
      return null;
  }
    private void recorrerHaciaAtras(){
        DoublyNodeList<E> n;
        for (n = last ; n != header; n = n.getPrevious(n)){
        }
    }
    
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addLast(E e) {
        if (e != null){
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            if(last==header){
                if(last==null){
                    newNode.setNext(null);
                    newNode.setPrevious(null);
                    this.header = newNode;
                    this.last = newNode;
                }else{
                    newNode.setPrevious(last);
                    last.setNext(newNode);
                    this.setLast(newNode);
                }
            }else{
                newNode.setPrevious(last);
                last.setNext(newNode);
                this.setLast(newNode);
            }
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if(header==null){
            return null;
        }
        E doublyNodeList = header.getContent();
        if(header==last){
            header = null;
            last = null;
        }else{
            DoublyNodeList<E> nodo = header.getNext();
            nodo.setPrevious(null);
            header = nodo;
        }
        return doublyNodeList;
    }

    @Override
    public E removeLast() {
        if(header==null){
            return null;
        }
        E doublyNodeList = header.getContent();
        if(header==null){
            header = null;
            last = null;
        }else{
            DoublyNodeList<E> nodo = last.getPrevious(last);
            nodo.setNext(null);
            last = nodo;
        }
        return doublyNodeList;
    }
    
    @Override
    public String toString(){
        String s="";
        for(DoublyNodeList<E> n=header;n!=null;n=n.getNext()){
            s+=n.getContent()+",";
        }
        return s;
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
