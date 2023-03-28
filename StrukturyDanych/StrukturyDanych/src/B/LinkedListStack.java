package B;

import java.util.LinkedList;

public class LinkedListStack {
    LinkedList<Integer> lista;

    public LinkedListStack() {
        lista = new LinkedList<Integer>();
    }
    public void push(int value){
        lista.push(value);
    }
    public int pop(){
        return lista.pop();
    }
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    public int peek(){
        return lista.peek();
    }

    public static void main(String[] args) {

    }
}
