package A.mieszajaca;


import java.util.LinkedList;

public class HashTable {
    private LinkedList[] hashArray;
    private int arraySize;

    public HashTable(int size){
        arraySize = size;
        hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++){
            hashArray[i] = new LinkedList();
        }
    }
    public LinkedList getLinkedList(int index){
        return hashArray[index];
    }
    public int size(){
        return arraySize;
    }
    private int hashFunc(int elem){
        return elem % arraySize;
    }
    public void insert(int data){
        int hashVal = hashFunc(data);
        if(!hashArray[hashVal].contains(data)){
            hashArray[hashVal].addFirst(data);
        }
    }
    public void delete(int elem){
        int hashVal = hashFunc(elem);
        hashArray[hashVal].remove(elem);
    }
    public boolean find(int elem){
        int hashVal = hashFunc(elem);
        return hashArray[hashVal].contains(elem);
    }
    public void print(){
        for (LinkedList linkedlist :
                hashArray) {
            for (int i = 0; i <linkedlist.size(); i++) {
                System.out.print(linkedlist.get(i) + " ");
            }
        }
    }


}
