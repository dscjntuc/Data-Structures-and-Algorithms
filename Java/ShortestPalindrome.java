import java.util.Scanner;

public class ShortestPalindrome {

	//Complexity O(n)

	public static String shortestPalindrome(String s) {
        // make the string by adding #
        String str = s + '#' + reverse(s);
        
        // calculate lps
        int lps = getLPS(str);
        
        // get the remaning string and add its reverse to get the answer
        String rem = s.substring(lps);
        
        String rev = reverse(rem);
        
        
        return rev+s;
    }
    
    public static int getLPS(String s){
	    int[] lps = new int[s.length()];
	    
	    int i = 1;
	    int len = 0;
	    
	    while(i < s.length()){
	        if(s.charAt(i) == s.charAt(len)){
	            len++;
	            lps[i] = len;
	            i++;
	        }
	        else{
	            if(len > 0){
	                len = lps[len-1];
	            }
	            else{
	                i++;
	            }
	        }
	    }
	    return lps[s.length()-1];
	}
    
    public static String reverse(String s){
        String str = "";
        
        for(int i = s.length()-1;i >= 0;i--){
            str = str + s.charAt(i);
        }
        return str;
    }
    
    
    public static void main(String[] args) {
    	
		Scanner s = new Scanner(System.in);
		
		String input = s.nextLine();
		
		System.out.println(shortestPalindrome(input));
	}
}