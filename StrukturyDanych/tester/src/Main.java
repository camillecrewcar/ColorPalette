public class Main {

        private int[] table;
        private int nELems;
        public Main(int maxSize){
            table = new int[maxSize];
            nELems = 0;
        }
        public void add(int value){
            if(nELems>= table.length){
                int[] localTable = new int[table.length*2];
                for(int i=0; i< table.length; i++){
                    localTable[i]= table[i];
                    table=localTable;
                }
                table[nELems]=value;
                nELems++;
            }
        }
        public int get(int index){
            return table[index];
        }
        public int size(){
            return nELems;
        }
        public boolean remove(int index){
            if(nELems==0){
                return false;
            }
            for(int j= index; j<nELems-1; j++){
                table[j]=table[j+1];
            }
            nELems--;
            return true;
        }
        public int find(int searchElem){
            for(int j=0; j<nELems; j++){
                if(table[j]==searchElem){
                    return j;
                }
            }
            return -1;
        }

        public void merge(int left, int mid, int right){
            int[] tab = new int[right-left+1];
            int k=0;
            int i=left;
            int j=mid+1;

            while ((i < mid + 1) || (j < right + 1)) {
                if(i==mid+1){
                    tab[k]=table[j];
                    k++;
                    j++;
                }
                else if(j==right+1){
                    tab[k]=table[i];
                    k++;
                    i++;
                }
                else{
                    if(table[i]<=table[j]){
                        tab[k]= table[i];
                        i++;
                    }
                    else{
                        tab[k]=table[j];
                        j++;
                    }
                    k++;
                }
            }
            int l = left;
            for (i = 0; i < tab.length; i++) {
                table[l] = tab[i];
                l++;
            }
        }

        public void mergeSort(int left, int right) {
            if (left < right) {
                int mid = (left+right)/2;
                mergeSort(left, mid);
                mergeSort(mid+1, right);
                merge(left, mid, right);
            }
        }

        public void print(){
            for (int i = 0; i < nELems; i++) {
                System.out.println(get(i)+" ");
            }
            System.out.println();
        }


    public static void main(String[] args) {
        int maxSize=2;
        Main array = new Main(maxSize);

        array.add(13);
        array.add(98);
        array.add(65);
        array.add(15);
        array.add(34);
        array.add(140);
        System.out.println(array.get(1));
        array.mergeSort(0, array.size()-1);
        array.print();
    }
}