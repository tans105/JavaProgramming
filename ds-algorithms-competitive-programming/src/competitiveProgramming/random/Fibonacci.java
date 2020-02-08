package competitiveProgramming.random;

public class Fibonacci {

    public static void main(String[] args) {
        int i = 1;
        int temp = 1,temp1 = 0;
        int sum = 0;
        while (i != 10) {
            
           sum=sum+temp1;
           temp1=temp; 
           temp=sum;
           i++;
            System.out.println(sum);
        }
    }
}
