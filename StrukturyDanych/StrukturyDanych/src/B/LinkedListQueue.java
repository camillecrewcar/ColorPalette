package B;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> linkedList;

    public LinkedListQueue() {
        linkedList = new LinkedList<Integer>();
    }
    public Boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public int remove(){
        int temp = linkedList.get(0);
        linkedList.remove(0);
        return temp;
    }
    public void insert(int value){
        linkedList.add(value);
    }
    public int size(){
        return linkedList.size();
    }
    private int pierwszy(){
        return linkedList.get(0);
    }

    public static void main(String[] args) {
        LinkedListQueue linkedList1 = new LinkedListQueue();
        linkedList1.insert(5);
        linkedList1.insert(3);
        System.out.println(linkedList1.pierwszy());
    }

}
