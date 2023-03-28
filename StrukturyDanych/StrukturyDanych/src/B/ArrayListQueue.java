package B;

import java.util.ArrayList;

public class ArrayListQueue {
    ArrayList<Integer> lista;
    public ArrayListQueue() {
        lista = new ArrayList<>();
    }
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    public void insert(int value){
        lista.add(value);
    }
    public int remove(){
        int elem = lista.get(0).intValue();
        lista.remove(lista.get(0));
        return elem;
    }
    public int poczatek(){
        return lista.get(0).intValue();
    }
    public int size(){
        return lista.size();
    }
}
