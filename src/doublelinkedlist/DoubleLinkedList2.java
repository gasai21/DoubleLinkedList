/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkedlist;

/**
 *
 * @author Pangling
 */
public class DoubleLinkedList2 {
    Node first;
    Node last;
    
    public DoubleLinkedList2(){
        first = null;
        last = null;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insertFirst(int data){
        Node node = new Node(data);
        if(isEmpty()){
            last = node;
        }else{
            first.prev = node;
        }
        
        node.next = first;
        first = node;
    }
    
    public void insertLast(int data){
        Node node = new Node(data);
        if(isEmpty()){
            first = node;
        }else{
            last.next = node;
            node.prev = last;
        }
        
        last = node;
    }
    
    public Node deleteFirst(){
        Node temp = first;
        if(first.next == null){
            last = null;
        }else{
            first.next.prev = null;
        }
        first = first.next;
        return temp;
    }
    
    public Node deleteLast(){
        Node temp = last;
        if(first.next == null){
            first = null;
        }else{
            last.prev.next = null;
        }
        
        last = last.prev;
        return temp;
    }
    
    public boolean insertAfter(int key, int data){
        Node current = first;
        while(current.data != key){
            current = current.next;
            if(current == null){
                return false;
            }
        }
        
        Node node = new Node(data);
            if(current == last){
                node.next = null;
                last = node;
            }else{
                node.next = null;
                current.next.prev = node;
            }
            
            node.prev = current;
            current.next = node;
            return true;
    }
    
    public Node deleteKey(int key){
        Node current = first;
        while(current.data != key){
            current = current.next;
            if(current == null){
                return null;
            }
        }
        
        if(current == first){
            first = current.next;
        }else{
            current.prev.next = current.next;
        }
        
        if(current == last){
            last = current.prev;
        }else{
            current.next.prev = current.prev;
        }
        
        return current;
    }
    
    public void displayForward(){
        System.out.println("List(first --> last): ");
        Node current = first;
        
        while(current != null){
            current.tampil();
            current = current.next;
        }
        System.out.println("");
    }
    
    public void displayBackward(){
        System.out.println("List (last-->first): ");
        Node current = last;
        while(current != null){
            current.tampil();
            current = current.prev;
        }
        System.out.println("");
    }
}
