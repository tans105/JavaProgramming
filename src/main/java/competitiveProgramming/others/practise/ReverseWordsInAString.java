package competitiveProgramming.others.practise;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {
	public static void main(String[] args) {
		String s="Let's take LeetCode contest";
		s+=" ";
		String reverseString="";
		List list=new ArrayList<Character>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
				reverseString+=' '+reverse(list);
				list.clear();
				continue;
			}
			list.add(s.charAt(i));
		}
		System.out.println(reverseString.substring(1));
	}
	public static String reverse(List l){
		String returnStr="";
		for(int i=l.size()-1;i>=0;i--){
			returnStr+=l.get(i);
		}
		return returnStr;
	}
}
