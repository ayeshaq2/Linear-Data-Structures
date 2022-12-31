package LA1Q1;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Scanner;

public class DemoSinglyLinkedList {

    public static Scanner input;
    public DemoSinglyLinkedList(){}

    public static void Header(int labex) {
                            //creating a header method lists all regarding information

        System.out.print("Lab Exercise=" + labex + " \n Prepared by: Ayesha Qaisar \n Student Number: 251255914 " +
                "\n Goal of this exercise: We will be creating a singly link-list data structure and will use" +
                "that to realize a stack and queue \n");
        System.out.println("============================================================================================= \n");
    }

    public static void Footer(int labnum) {
                    //a footer method to sign out of the program once main task is completed, and it is called by the main method

        System.out.println("============================================================================================= \n");
        System.out.print("Completion of lab Assignment " + labnum + " is successful! \n Signing off - Ayesha :)");
        System.out.println("=============================================================================================");


    }

    public static void stackDemo(SinglyLinkList s){
                             //writing a method that will perform all the operations with our stack.

                            //asking the user to choose whether the head or tail of our SLL becomes the top of the stack we are realizing
        System.out.println("Which end of the Linked list you would like to use as the stack top? \n " +
                "Enter 1 for head or 2 for tail: ");
        input= new Scanner(System.in);

        int top;    //setting a top for our stack

        while(true){
        try {           //throwing an exception in the case the user enters anything other than the given choices of 1 or 2

            top= input.nextInt();
            if (!(top==1 || top==2)){       //exception validates the input within the choice and if it isn't it will give an error message,

                throw new IllegalArgumentException("Incorrect Response! ");

            }
            break;}
        catch(Exception x){
                                            // once the exception has been thrown, the method will ask the question again,
                                            // and the while loop will keep replaying this code until a value within the requirements has been entere
            System.out.println( " Exception: " + x.getMessage() + "Enter 1 for head or 2 for tail: ");
            input.nextLine();

        }}

        if(top == 1){
                                //head of SLL becomes the top of stack
            System.out.println("Stack Top: Head of the linked list");
            System.out.println("Lets pop all the elements");
            System.out.println("The current stack: " + s.toString());
            for(int i=0; i <= s.getSize() +3 ; i++){
                                //for loop iterates through each element and in each iteration removes the first element and prints the stack
                System.out.println(s.popFromHead() + "has been popped! The revised stack:" +s.toString());
            }

            System.out.println("Let's push 39 and -58 in the stack...");
            System.out.println("The current stack: " +s.toString());


                                //adding elements to the stack
            s.pushAtHead(39);
            System.out.println("After 39 is pushed, the revised stack: "+ s.toString());

            s.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " +s.toString());


        } else if (top == 2) {
                            //making the tail of our SLL the top of our stack.

            System.out.println("Stack Top: Tail of the linked list");
            System.out.println("Lets pop all the elements");
            System.out.println("The current stack: " + s.toString());

            for(int i =0; i<s.getSize(); i++){
                            //for loop iterates through our SLL and the elements are removed from the bottom, since our tail is the top

                System.out.println(s.popFromTail()+"has been popped! The revised Stack:" + s.toString());

        }
            System.out.println("Let's push 39 and -58 in the stack...");
            System.out.println("The current stack: " +s.toString());

                                //adding elements to the top of our stack

            s.pushAtHead(39);
            System.out.println("After 39 is pushed, the revised stack: "+ s.toString());

            s.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " +s.toString());

        }
        while(true){
                        //a while loop is created here. this code block asks the user to enter a value they want to
                        //search for in the stack, and keeps repeating until the user indicates to stop searching

            System.out.println("Let's search the stack");
            System.out.println("The current stack: " + s.toString());
            Scanner keyboard = new Scanner (System.in);
            System.out.println("Enter the value you are searching for:");
            int search = keyboard.nextInt();
            System.out.println("Index: " +s.searchStack(search));

            System.out.println("Do you want to continue? \n enter y for yes, or any other key to discontinue");
                //Asking the user if they want to continue searching or not

            Scanner ask = new Scanner(System.in);
            char answer = ask.next().toLowerCase().charAt(0);
            if(answer != 'y'){
                break;
            }
        }
    }

    public static void queueDemo(SinglyLinkList names){
                    //method that performs all operations on our SLL realized as a Queue

        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear");

                    //adding names at the end of our Queue and then printing the queue

        names.enqueueAtTail("Joelle");
        System.out.println("After Joelle is is enqueued, the revised Queue:" + names.toString());
        names.enqueueAtTail("Lucas");
        System.out.println("After Lucas is enqueued, the revised Queue:" +names.toString());

                    //removing names from the front of our Queue
        names.dequeueAtHead();
        System.out.println("Isra has been dequeued! The revised queue" +names.toString());
        names.dequeueAtHead();
        System.out.println("Will has been dequeued! The revised queue" +names.toString());
        names.dequeueAtHead();
        System.out.println("Griffin has been dequeued! The revised queue: " +names.toString());

    }

    public static void main(String [] s){
        Header(1);

                            //creating two array lists of Integer and String types, putting some values in them
        ArrayList<Integer> listOfValues = new ArrayList<>(Arrays.asList(56,-22,34,57,98));
        ArrayList<String> listOfNames = new ArrayList<>(Arrays.asList("Griffin", "Will","Isra","Delaney","Madison"));

        System.out.println("The given integer array: " + listOfValues);
        System.out.println("The given String array: " + listOfNames);

                            //creating a linked list of Integers and using a for loop to populate this list with the values from
                            //our previously declared array list of Integers
        SinglyLinkList<Integer> vals= new SinglyLinkList<>();

        for(int i=0; i<listOfValues.size() - 2;i++){
            vals.addFirst(listOfValues.get(i));
        }
        for (int i=listOfValues.size()-1; i>2; i--){
            vals.addLast(listOfValues.get(i));
        }

        System.out.println("Your Integer List: " + vals.toString());

                        //creating a linked lst of String type and using a for loop to populate it with names from our array list
        SinglyLinkList<String> names = new SinglyLinkList<>();
        for (int i =0; i<listOfNames.size()-2;i++){
            names.addFirst(listOfNames.get(i));
        }
        for (int i=listOfNames.size()-1; i>2; i--){
            names.addLast(listOfNames.get(i));
        }
        System.out.println("Your String list " + names);            //printing out singly linked list

                                //calling the other defined methods to perform some operations with our singly link list,
                                //through realizing them as 2 different structures, Stack and Queue
        stackDemo(vals);
        queueDemo(names);
        Footer(1);  //calling the footer method once the program ends.


    }


}
