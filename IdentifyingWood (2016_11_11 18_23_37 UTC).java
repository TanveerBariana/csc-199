public class IdentifyingWood {
	public String check(String s, String t){
		int n= s.length();
		int m= t.length();
		int result = 0; 
		if(n>= m){
			for(i=0; i< n; i++){
				if(charAt(i)== charAt(j)){
					result++; 
					j++;
				}
			}
			if(result == m){
				return " \"Yep, it's wood.\"";	
			} 
		}
		return "Nope.";
	}
} 