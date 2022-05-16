package competitiveProgramming.others.practise;

public class Digits {

    int num;
    int[] arr = new int[4];

    Digits(int num) {
        this.num = num;
    }

    int[] digit() {
        int k = 0;
        
        while (num != 0) {
            arr[k] = num % 10;//arr[0]=last digit arr[3]=first digit
            num = num / 10;
            k++; 
        }
        return arr.clone();
    }
    
}
