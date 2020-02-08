package competitiveProgramming.random;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String []args){
		int []sample=new int[]{4,5,2,25};
		printNextGE(sample);
	}
	
	public  static void printNextGE(int []sample){
		Stack<Integer>stack=new Stack<Integer>();
		stack.push(-1);
		int next,popped;
		
		for(int i=1;i<sample.length;i++){
			next=sample[i];
			if(!stack.isEmpty()){
				popped=stack.pop();
			}
		}
	}
	
	
}
