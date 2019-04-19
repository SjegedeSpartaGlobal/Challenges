public class ArrayMerger{
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
}
