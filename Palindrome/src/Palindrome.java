public class Palindrome {

    private static char[] palArr;
    private static int counter = 0;
    public static void main(String[] args){
        char[] parsedPal = parseToCharArray("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!");
        System.out.println("is palindrome: "+isPalindrome(parsedPal));
        System.exit(0);
    }

    public static char[] parseToCharArray(String str) {
        String newStr = str.toLowerCase();
        int length = str.length();
        char[] specialChars = {',', '.', ';', ':', ' ', '?', '!', '-'};
        int n = 0;
        int q = 0;
        int arrayCounter = 0;
        char nextChar = ' ';
        for (int i = 0; i < length; i++) {
            nextChar = newStr.charAt(i);

            for (n = 0; n < specialChars.length; n++) {
                if (nextChar == specialChars[n]) {
                    break;
                }
            }
            if (specialChars.length == n) {
                counter = counter + 1;
                System.out.println("next: " + i + " " + newStr.charAt(i));
            }
        }

        palArr = new char[counter];
        for (int p = 0; p < length; p++) {
            nextChar = newStr.charAt(p);

            for (q = 0; q < specialChars.length; q++) {
                if (nextChar == specialChars[q]) {
                    break;
                }
            }
            if (specialChars.length == q) {
                palArr[arrayCounter] = newStr.charAt(p);
                arrayCounter = arrayCounter + 1;

            }
        }

        return palArr;
    }

    public static boolean isPalindrome(char[] palArray){
        int k = 0;
        int m = 0;
        int l = 0;
        int o = 0;
        int counter1 = counter;
        int counter2 = counter;


        if((counter%2)==0) {
            for(k=0, m=(counter1-1); k<counter1/2; k++, m--){
                System.out.println("char at k: "+palArray[k]+" char at m: "+palArray[m]);
                if(palArray[k]!=palArray[m]){
                    break;
                }
            }
        }else{
            for(l=0, o=(counter2-1); l<=counter2/2; l++, o--){
                System.out.println("char at l: "+palArray[l]+" char at o: "+palArray[o]);
                if(palArray[l]!=palArray[o]){
                    break;
                }
            }

        }

        System.out.println("k: "+k+" l: "+l+" counter: "+counter);
        if(k==(counter1/2)){
            return true;
        }else if(l==((counter2/2)+1)){
            return true;
        }else{
            return false;
        }
    }

}
