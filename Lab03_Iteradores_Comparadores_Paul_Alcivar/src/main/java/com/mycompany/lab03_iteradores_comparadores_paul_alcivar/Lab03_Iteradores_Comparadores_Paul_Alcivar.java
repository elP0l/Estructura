/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab03_iteradores_comparadores_paul_alcivar;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author vecto
 */
public class Lab03_Iteradores_Comparadores_Paul_Alcivar {

    public static void main(String[] args) {
        System.out.println("ArrayList");
        List<Integer> list=new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        Comparator<Integer> compa1 = Comparator.naturalOrder();
        System.out.println(list.findAll(compa1, 4));
        int re = list.compare(5,list.get(0));
        switch (re) {
            case 1:
                System.out.println("El resultado de comparar los dos numeros es: "+re+" es decir el primer numero es mayor");
                break;
            case 0:
                System.out.println("El resultado de comparar los dos numeros es: "+re+" es decir son iguales");
                break;
            default:
                System.out.println("El resultado de comparar los dos numeros es: "+re+" es decir el primer numero es menor");
                break;
        }
        System.out.println(list.find(compa1,4));
        System.out.println("Iterando usando .iterator");
        Iterator<Integer> i = list.iterator();
        while(i.hasNext()) {
            Integer el= i.next();
            System.out.println(el);
        }
       
        System.out.println("LinkedList");
        List<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(3);
        Comparator<Integer> compa = Comparator.naturalOrder();
        int re1 = list1.compare(3,list1.get(4));
        switch (re1) {
            case 1:
                System.out.println("El resultado de comparar los dos numeros es: "+re+" es decir el primer numero es mayor");
                break;
            case 0:
                System.out.println("El resultado de comparar los dos numeros es: "+re+" es decir son iguales");
                break;
            default:
                System.out.println("El resultado de comparar los dos numeros es: "+re+" es decir el primer numero es menor");
                break;
        }
        System.out.println(list1.findAll(compa, 3));
        System.out.println(list1.find(compa,4));
        System.out.println("Iterando usando .iterator");
        Iterator<Integer> i1 = list1.iterator();
        while(i1.hasNext()) {
            Integer el= i1.next();
            System.out.println(el);
        }
        
    
        /*
        System.out.println("----------------------");
        System.out.println("DoublyLinkedList");
        List<Integer> list2=new DoublyLinkedList<>();
        list2.addLast(9);
        list2.addLast(10);
        list2.addLast(11);
        list2.addLast(12);
        System.out.println(list2);
        list2.removeLast();
        list2.removeFirst();
        System.out.println(list2);
        System.out.println("----------------------");
        System.out.println("CircularNodeList");
        List<Integer> list3= new CircularLinkedList<>();
        list3.addLast(13);
        list3.addLast(14);
        list3.addLast(15);
        list3.addLast(16);
        System.out.println(list3);
        list3.removeLast();
        list3.removeFirst();
        System.out.println(list3);
        /*
        List<Integer> list= new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        //person
        List<Person> list3 = new LinkedList<>();
        list3.addLast(new Person("Raquel", "Jaramillo", 24));
        list3.addLast(new Person("Raquel", "Jaramillo", 28));
        list3.addLast(new Person("Raquel", "Jaramillo", 47));
        list3.addLast(new Person("Rafael", "Pesantez", 23));
        list3.addLast(new Person("Felix", "Prado", 38));
        List<Person> list4 = new LinkedList<>();
        list4.addLast(new Person("Raquel", "Jaramillo", 24));
        list4.addLast(new Person("Felix", "Prado", 38));
        list4.addLast(new Person("Emilio", "Doumet", 17));
        list4.addLast(new Person("Alex", "Vaca", 84));
        list4.addLast(new Person("Daniel", "Pesantez", 23));
        /*
        // Caso 1
        List<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        List<Integer> list2 = new LinkedList<>();
        list2.addLast(5);
        list2.addLast(9);
        list2.addLast(8);
        list2.addLast(2);
        List<Integer> intersection1 = list1.findIntersection(list2);
        for(Integer n : intersection1){
        System.out.println(n);
        }
        // Caso 2
        List<Person> intersection2 = list3.findIntersection(list4);
        for (Person p : intersection2) {
        System.out.println(p);
        }
        List<Person> intersection3 = list3.findIntersection(list4);
        for (Person p : intersection3) {
        System.out.println(p);
        }
        // Instancia de la Interfaz Comparator con variable cmp1
        Comparator<Person> cmp1 = new Comparator<Person>(){
        @Override
        public int compare(Person p1, Person p2) {
        //Comparar edades
        if (p1.getAge() == p2.getAge()){
        return 0;
        } else if (p1.getAge() > p2.getAge()){
        return 1;
        } else {
        return -1;
        }
        // return p1.getAge() - p2.getAge();
        }
        };
        //comparador          
        Comparator<Person> cmp2 = new Comparator<Person>(){
        @Override
        public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
        }
        };
        //interseccion
        List<Person> intersection2 = list3.findIntersection(list4, cmp1);
        System.out.println("*** INTERSECCION 2 ****");
        for (Person p : intersection2) {
        System.out.println(p);
        }
        List<Person> intersection3 = list3.findIntersection(list4, cmp2);
        System.out.println("*** INTERSECCION 3 ****");
        for (Person p : intersection3) {
        System.out.println(p);
        }
        // Forma simple de Comparar usando expresionales lambdas
        List<Person> intersection4 = list3.findIntersection(list4, (p1, p2)->{
        return p1.getAge() - p2.getAge();
        }); 
        System.out.println("*** INTERSECCION 4 ****");
        for (Person p : intersection4) {
        System.out.println(p);
        }
         */        
}
}

