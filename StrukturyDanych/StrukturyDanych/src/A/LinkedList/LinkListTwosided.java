package A.LinkedList;

import java.util.LinkedList;

public class LinkListTwosided {


    private ListElemTwosided first;
    private ListElemTwosided last;

    public LinkListTwosided(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(int value){
        ListElemTwosided temp = new ListElemTwosided(value);
        if(isEmpty()){
            first = temp;
            last = temp;
        } else {
            first.previous = temp;
            temp.next = first;
            first = temp;
        }
    }
    public void insertLast(int value){
        ListElemTwosided temp = new ListElemTwosided(value);
        if(isEmpty()){
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            temp.previous = last;
            last = temp;
        }
    }
    public ListElemTwosided removeFirst(){
        if (isEmpty()){
            return null;
        }
        ListElemTwosided temp = first;
        if(first.next == null){
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }
    public ListElemTwosided removeLast(){
        if (isEmpty()){
            return null;
        }
        ListElemTwosided temp = last;
        if(last.previous == null){
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }


    public void print(){
        ListElemTwosided temp = first;
        while (temp !=null){
            System.out.print(temp.value + " ");
            temp= temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkListTwosided lista = new LinkListTwosided();
        lista.insertFirst(5);
        lista.insertFirst(3);

        lista.insertLast(7);
        lista.insertLast(7);
        lista.insertLast(7);
        lista.insertLast(7);
        lista.insertFirst(3);
        lista.removeLast();
        lista.removeLast();
//        lista.removeLast();
//        lista.removeLast();
//        lista.removeLast();
//        lista.removeLast();
//        lista.removeLast();


        lista.print();

    }

}
