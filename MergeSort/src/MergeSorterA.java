public class MergeSorterA {

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

    public int[] merge(int[] arrayA, int[] arrayB){
        int counterA = 0;
        int counterB = 0;
        int lengthA = arrayA.length;
        int lengthB = arrayB.length;
        int lengthC = lengthA + lengthB;
        int[] arrayC = new int[lengthC];
        int remainderA = 0;
        int remainderB = 0;

        for(int i=0; i<lengthC; i++){
            remainderA = lengthA - counterA;
            remainderB = lengthB - counterB;

            if(counterA<lengthA&&counterB<lengthB) {
                if ((arrayA[counterA] <= arrayB[counterB])) {
                    arrayC[i] = arrayA[counterA];
                    counterA++;
                } else if (arrayB[counterB] < arrayA[counterA]) {
                    arrayC[i] = arrayB[counterB];
                    counterB++;
                }
            }
            else if(counterB>=lengthB&&remainderA>remainderB){
                arrayC[i] = arrayA[counterA];
                counterA++;
            }
            else if(counterA>=lengthA&&remainderB>remainderA){
                arrayC[i] = arrayB[counterB];
                counterB++;
            }
        }
        return arrayC;
    }

    public int[] mergeSort(int[] left, int[] right){
        int[] sortedLeft = bubbleSort(left);
        int[] sortedRight = bubbleSort(right);

        int[] sortedCombination = merge(sortedLeft, sortedRight);

        return sortedCombination;
    }
}
