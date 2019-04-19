public class Main {

    public static void main(String[] args){
        long starttime = System.nanoTime();
        RandomNumberGenerator randList = new RandomNumberGenerator();
        Sorter bubbleSort = new Sorter();
        int[] a = {12,3,7,5,8,1};
        int[] a2 = randList.randomNumberGenerator(20);
        bubbleSort.bubbleSort(a2);
        for(int i=0; i<a2.length; i++){
            System.out.print(a2[i]+" ");
        }
        System.out.println(" ");
        System.out.println(System.nanoTime()-starttime);
    }
}
