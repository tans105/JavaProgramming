package competitiveProgramming.others.practise;

import java.util.Scanner;


public class StringTask {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        char[] charArray = word.toCharArray();
        int i=0;
        while(i<word.length()){
        if(charArray[i]=='a'|charArray[i]=='e'|charArray[i]=='i'|charArray[i]=='o'|charArray[i]=='u'|charArray[i]=='A'|charArray[i]=='E'|charArray[i]=='I'|charArray[i]=='O'|charArray[i]=='U'){
        charArray[i]='.';
        }
        i++;
        }
        String word1=new String(charArray);
        System.out.println(word1);
    }
    
}
