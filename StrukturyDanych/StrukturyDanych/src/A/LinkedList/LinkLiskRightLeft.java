package A.LinkedList;

public class LinkLiskRightLeft {
    private ListElem first;

    private ListElem last;

    public LinkLiskRightLeft(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int value){
        ListElem listElem = new ListElem(value);
        if(isEmpty()){
            last = listElem;
        }
        listElem.next = first;
        first = listElem;
    }
    public void insertLast(int value){
        ListElem listElem = new ListElem(value);
        if(isEmpty()){
            first = listElem;
        } else {
            last.next = listElem;
        }
        last = listElem;
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
        if (current == null){
            last = listElem;
        }
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
    public ListElem remove(int elem){
        if(isEmpty()) return null;
        int miejsce = find(elem);
        ListElem current = first;
        ListElem previous = null;
        for (int i = 0; i < miejsce; i++) {
            previous = current;
            current = current.next;
        } if (previous == null){
            return null;
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
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }


    public static void main(String[] args) {
        LinkLiskRightLeft linkLiskRightLeft = new LinkLiskRightLeft();


        linkLiskRightLeft.insert(3);
        linkLiskRightLeft.insertLast(10);
        linkLiskRightLeft.insertLast(4);
        linkLiskRightLeft.insertLast(5);
        linkLiskRightLeft.print();
//        linkLiskRightLeft.remove(3);
//        linkLiskRightLeft.print();
    }
}
