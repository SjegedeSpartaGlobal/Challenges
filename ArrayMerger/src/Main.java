public class Main {

    public static void main(String[] args){
        ArrayMerger arrayMerger = new ArrayMerger();
        int[] arrayA = {};
        int[] arrayB = {3,4,17,19,40};
        int[] arrayC = arrayMerger.merge(arrayA, arrayB);

        for(int i=0; i<arrayC.length; i++){
            System.out.print(arrayC[i]+" ");
        }
    }




}
