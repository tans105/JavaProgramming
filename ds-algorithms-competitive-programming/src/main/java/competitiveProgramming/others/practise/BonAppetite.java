package competitiveProgramming.others.practise;
import java.util.Scanner;

public class BonAppetite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int charged=sc.nextInt();
		int sum=0;
		for(int i=0;i<n;i++){
			sum=sum+arr[i];
		}
		int actualCharge=(sum-arr[k])/2;
		if(actualCharge-charged==0){
			System.out.println("Bon Appetit");
		}
		else{
			System.out.println(charged-actualCharge);
		}
		
	}
}
