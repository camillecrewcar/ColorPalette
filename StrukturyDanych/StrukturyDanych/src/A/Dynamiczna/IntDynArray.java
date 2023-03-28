package A.Dynamiczna;

public class IntDynArray {
    static private int[] dynamiczna;
    private int iloscElementow;

    public IntDynArray(int length) {
        dynamiczna = new int[length];
        iloscElementow = 0;
    }
    public int size(){
        return iloscElementow;
    }
    public void add(int dodawany){
        if(dynamiczna.length <= iloscElementow){
            int temp[] = new int[dynamiczna.length+1];
            for (int i = 0; i < dynamiczna.length; i++) {
                temp[i] = dynamiczna[i];
            }
            dynamiczna = temp;
        }
        dynamiczna[iloscElementow] = dodawany;
        iloscElementow++;
    }
    public void print(){
        for (int i = 0; i < iloscElementow; i++) {
            System.out.print(dynamiczna[i] + " ");
        }
    }
    public int get(int index){
        return dynamiczna[index];
    }
    public int find(int elem){
        for (int i = 0; i < iloscElementow; i++) {
            if (elem == dynamiczna[i]){
                return i;
            }
        }
        return -1;
    }
    public boolean remove(int index){
        if (index<0 || index>iloscElementow || iloscElementow ==0){
            return false;
        }

        for (int i = index; i < iloscElementow -1; i++) {
            dynamiczna[i] = dynamiczna[i+1];
        }
        iloscElementow--;
        return true;
    }

    public static void main(String[] args) {
        IntDynArray intDynArray = new IntDynArray(2);
        intDynArray.add(22);
        intDynArray.add(3);
        intDynArray.add(4);
        intDynArray.remove(2);
        System.out.println(intDynArray.find(22));

        intDynArray.print();
    }
}
