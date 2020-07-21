package competitiveProgramming.others.archive.datastructures.stack;

public class TwoStack {
	int maxSize1;
	int maxSize2;
	int top1;
	int top2;
	int[] stack;

	TwoStack(int size) {
		stack = new int[size];
		if (size % 2 == 0) {
			maxSize1 = size / 2;
			maxSize2 = size - maxSize1;
			top1 = -1;
			top2 = maxSize2 - 1;

		} else {
			maxSize1 = (size + 1) / 2;
			maxSize2 = size - maxSize1;
			top1 = -1;
			top2 = maxSize1 - 1;
			System.out.println(maxSize1);
			System.out.println(maxSize2);
			System.out.println(top1);
			System.out.println(top2);

		}

	}

	public void push1(int num) {

		if (top1 < maxSize1 - 1) {
			stack[++top1] = num;
			System.out.println("pushing competitiveProgramming.others.archive.datastructures.stack 1 :" + num);
		} else {
			System.out.println("competitiveProgramming.others.archive.datastructures.stack 1 overflow!");
		}
	}

	public void push2(int num) {

		if (top2 < maxSize1 + maxSize2 - 1) {

			stack[++top2] = num;
			System.out.println("pushing competitiveProgramming.others.archive.datastructures.stack 2 :" + num);
		} else {
			System.out.println("competitiveProgramming.others.archive.datastructures.stack 2 overflow!");
		}
	}

	public int pop1() {
		if(top1>=0){
			int x=stack[top1];
			top1--;
			return x;
		}
		else{
			System.out.println("competitiveProgramming.others.archive.datastructures.stack underflow!");
			return 0;
		}
		

	}

	public int pop2() {
		if(top2>=maxSize1){
			int x=stack[top2];
			top2--;
			return x;
		}
		else{
			System.out.println("competitiveProgramming.others.archive.datastructures.stack underflow!");
			return 0;
		}
	}

	public static void main(String[] args) {
		TwoStack stack = new TwoStack(9);
		stack.push1(1);
		stack.push1(2);
		stack.push1(3);
		stack.push1(4);
		stack.push1(5);
		/*competitiveProgramming.others.archive.datastructures.stack.push1(1);*/
		stack.push2(6);
		stack.push2(7);
		stack.push2(8);
		stack.push2(9);
		stack.push2(10);
		/*competitiveProgramming.others.archive.datastructures.stack.push2(2);*/
		System.out.println(stack.pop2());
		System.out.println(stack.pop2());
		System.out.println(stack.pop2());
		System.out.println(stack.pop2());
		System.out.println(stack.pop2());
		System.out.println(stack.pop2());
		
		
	}
}
