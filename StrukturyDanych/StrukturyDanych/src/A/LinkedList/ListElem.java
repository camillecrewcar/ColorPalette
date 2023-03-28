package A.LinkedList;

public class ListElem {
    public int value;
    public ListElem next;

    public ListElem(int value){
        this.value = value;
        next = null;
    }
    public String toString(){
        return Integer.toString(value);
    }
}
