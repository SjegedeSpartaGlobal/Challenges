public class Sorter {

    public int[] bubbleSort(int[] a){
        int length = a.length;
        int next1 = 0;
        int next2 = 0;
        int i = 0;
        boolean notSorted = true;
        while(notSorted){
            notSorted = false;
            for (i=1; i<length; i++) {
                next1 = a[i - 1];
                next2 = a[i];
                if (next1 > next2) {
                    a[i - 1] = next2;
                    a[i] = next1;
                    notSorted = true;
                }
            }
        }
        return a;
    }
}
