package LA1Q1;

import java.util.Scanner;

public class SinglyLinkList <T> {            //creating a generic class as a singly linked list with 2 private fields that assign the head and tail nodes

   private Node<T> head=null;
   private Node<T> tail=null;
   private int size=0;

   public SinglyLinkList(Node<T> h, Node<T> t, int s){      //constructor method with arguments
            head =h;
             tail=t;
            size =s;
   }

    public SinglyLinkList(){}

    public void enqueueAtTail(T t){
                //method to add data at the end of our queue, which is being realized using our SLL
                //same as addLast method for our singly linked list

       addLast(t); }


    public T removeFirst(){
                //to remove the first element of the SLL we need to check whether it is empty and if so, nothing can be removed

       if (isEmpty())
           return null;

                //otherwise we shift the head of the SLL by making the old head's next element the new head and removing the old head, we
                //then decrement the size of the SLL as one item has been removed.

       T ans= head.getElement();
       head= head.getNext();
       size--;
       if(size==0){
           tail=null;

        }
       return ans;
    }

    public T popFromTail(){
                //writing a method to remove data from the end of our stack by realizing it from our SLL
                // same as removeLast method as it depends on which end of the SLL we take as the head or tail.

        return removeLast();
    }

    public T dequeueAtHead(){
                //remove data from the beginning of our Queue
                //same as removeFirst method of our SLL
       return removeFirst();

    }

    public int searchStack(T e) {
                //creating a method that will accept a data item, and then go over all the items available in our stack, and match the
                //user's given input with one in the stack, and if a match is found, it returns the index of that value.

        Node<T> data = head;       //creating a node to filter through the contents and be able to find a match
        int value = 1;

        if (size == 0) {
            //if the stack is empty, the operation can't be performed

            System.out.println("Stack is Empty");
            return 0;
        }

        else {

//Q= tried using a for loop here and it didn't work, not sure why...
            //
             /* for (int=0; i<size; i++){
             Node <T> data = head;
             ....same code within while loop....

            */
            while (data != null) {
                //now we are using a loop which will allow us to go over all the data items till a match is found

                if (data == e) {
                    System.out.println(e + " found at position " + value);
                    break;  //once a match is found, exit out of the loop.
                }
                value++;
                data = data.getNext();      //setting our created Node to point to the next data element, kind of like a counter to move through the list


            } if (data == null) {
                value = 0;
                System.out.println("Value is not found!");
            }
        } return value; }



    public void addFirst(T e){
                //here we are adding a data item to the first spot in the SLL (or head)
       head= new Node<>(e,head);
        if(size==0){
                //if the SLL was previously empty, then the new one added becomes the head and tail of the SLL
            tail=head;
        }
        size++;
    }

    public Boolean isEmpty(){
                    //checking to see if everything is in perfect balance and that there is nothing weird about the way you're smiling at you right now.

       return size==0;
    }

    public int getSize(){       // method to return the size, or number of elements in the list
       return size;
    }

    public T removeLast(){
                //this method will remove the last element in our SLL

                //creating a node type variable and assigning it to null, to use within the method as we change values
       T remove= null;

       if (isEmpty()){
                //checking for empty list, in which case there is no last element to be removed.
           return null;
       }
       else if(size == 1){
                //if the list contains only a single element, that will be removed
           remove= head.getElement();
           size--;
           head= tail= null;
           return remove;
       }
       else{
                //creating a node variable which points to the head
        Node <T> current = head;

        for(int i=1; i<size; i++){          //this loop will make our created node go through the SLL and reach the point containing the second l
                                            // ast element, which becomes the new tail and the old one is removed

            if(current.getNext().getNext() == null){
            remove= tail.getElement();
            current.setNext(null);
            tail= current;
            size--;
            break;
        }
        current = current.getNext(); }

       return remove; } }

    public String toString() {          //overriding the toString print out data in out specific format
            if (size==0){
                return "[]";    //if our structure is empty, then empty brackets should be returned
            }

            String start = String.format("[");

                        //creating a new node and assigning that to point to the head of our particular structure
            Node<T> current = head;
            while(current != null){
                        //the while loop iterates through the elements of our structure while the new one isn't null, that is it doesn't go past the tail and prints them out as a single list.
                start = start + String.format(current.getElement()+",");
                current=current.getNext();

            }
            start= start + String.format("\b]\n");
            return start;
        }


    public void pushAtHead(T e){
            //method to add to the top of the Stack that we are realizing through our SLL
            //same as addFirst method for the SLL

       addFirst(e);
    }

    public void pushAtTail(T e){
            //writing a method to add to the end of our stack; as realized by the SLL.
            // same as addLast method

        addLast(e); }

    public void addLast(T e){
            //writing a method to add an element at the end of our list.

       Node<T> newest = new Node<>(e,null);
       if(isEmpty()){
           head=newest;
       } else{
           tail.setNext(newest);
           tail=newest;
           size++;
       }
    }

    public T popFromHead(){
            //method to remove item from the head of our realized stack.
            //same idea as removeFirst method
       return removeFirst();

    }


}
