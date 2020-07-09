package competitiveProgramming.stackoverflow;

public class RemoveLastComma51873309 {
	public static void main(String[] args) {
		String str=",test test1 must not be null";
		int index=str.lastIndexOf(',');
		if(index==0) {//end case
			str=str.substring(1);
		}else {
			str=str.substring(0, index)+ str.substring(index+1);
		}
		System.out.println(str);
	}
}
