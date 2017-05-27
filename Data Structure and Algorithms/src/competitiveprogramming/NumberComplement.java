package competitiveprogramming;

import java.util.LinkedList;

public class NumberComplement {
public static void main(String[] args) {
	int n=5;
	ConvertNumberToBitWise convert=new ConvertNumberToBitWise();
	System.out.println(convert.convertToBits(n));
	System.out.println(convert.reverseBitWise(n));
	computeNumber(convert.reverseBitWise(n));
}

private static void computeNumber(LinkedList reverseBitWise) {
	int len=reverseBitWise.size();
	int val=0;
	for(int i=0;i<len;i++){
		val+=Double.parseDouble(reverseBitWise.get(i).toString())*Math.pow(2, i);
	}
	
}
}
