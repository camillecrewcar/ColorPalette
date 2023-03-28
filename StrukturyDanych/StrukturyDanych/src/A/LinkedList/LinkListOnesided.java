package A.LinkedList;

public class LinkListOnesided {
    private ListElem first;

    public LinkListOnesided(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public ListElem getFirst(){
        return first;
    }
    public void insertFirst(int value){
        ListElem listElem = new ListElem(value);
        if(!isEmpty()){
            listElem.next = first;
        }
        first = listElem;
    }
    public void insert(int value){
        ListElem listElem = new ListElem(value);
        ListElem previous = null;
        ListElem current = first;
        while (current!= null && listElem.value > current.value){
            previous = current;
            current = current.next;
        }
        if (previous == null) first = listElem;
        else {
            previous.next = listElem;
        }
        listElem.next = current;
    }
    public int find(int value){
        ListElem current = first;
        int iterator = 0;
        if (isEmpty()){
            return -1;
        }
        while (current!= null){
            if(current.value == value){
                return iterator;
            }
            iterator++;
            current = current.next;
        }
        return -1;
    }
    public boolean findBool(int value){
        if (isEmpty()){
            return false;
        }
        ListElem current = first;
        while (current.value != value){
            if (current.next == null){
                return false;
            }
            current = current.next;
        }
        return true;
    }
    public ListElem remove(int elem){
        if(isEmpty()) return null;
        int miejsce = find(elem);
        ListElem current = first;
        ListElem previous = null;
        for (int i = 0; i < miejsce; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }
    public void print(){
        ListElem current = first;
        while (current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    public ListElem removeFirst(){
        if (isEmpty()){
            return null;
        }
        ListElem temp = first;
        first = first.next;
        return temp;
    }

}
