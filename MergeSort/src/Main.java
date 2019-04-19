public class Main {

    public static void main(String[] args) {
        int[] a = {6,8,3,6,7};
//        int[] b = {7,2,5,3,1,8,2};
        MergeSorter mergeSorter = new MergeSorter();
        int[] newArray = mergeSorter.mergeSort(a);

        for(int i=0; i<newArray.length; i++){
            System.out.print(newArray[i]+" ");
        }
    }
}
