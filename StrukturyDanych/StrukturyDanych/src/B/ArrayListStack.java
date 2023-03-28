package B;

import java.util.ArrayList;

public class ArrayListStack {
    ArrayList<Integer> arrayList;

    public ArrayListStack() {
        arrayList = new ArrayList<Integer>();
    }
    public boolean isEmpty(){
        return arrayList.isEmpty();
    }
    public void push(int elem){
        arrayList.add(elem);
    }
    public int pop(){
        if (isEmpty()) {
            return -1;
        }
        int peekElem = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        return peekElem;
    }
    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return arrayList.get(arrayList.size()-1);
    }

    public static void main(String[] args) {

    }
}
