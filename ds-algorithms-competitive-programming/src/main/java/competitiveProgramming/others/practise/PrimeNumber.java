package competitiveProgramming.others.practise;

public class PrimeNumber {
	public static void main(String[] args) {
		int N = 100000000;
		System.out.println("2");
		int counter = 0;
		for (int i = 3; i < N; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
				counter++;
			}
			if(counter==i-2){
				System.out.println(i);
			}
			counter=0;
		}
	}
}
