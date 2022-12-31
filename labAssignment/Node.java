package LA1Q1;

public class Node <T> {     //creating a generic Node class, with fields that indicate the head and tail nodes of our singly linked list.

    private T element;
    private Node<T> next;

    public Node(){}
    public Node(T e, Node<T> n){           //a node that stores some data, as well as the reference of the node after it
        element= e;
        next=n;
    }

    public Node<T> getNext(){
        return next;
    }           //accessing the element next to the current one

    public T getElement(){
        return element;
    }           //accessor method for an element in the current position

    public void setNext(Node<T> n){
        next=n;
    }           //mutator method to set data in the current position


}
