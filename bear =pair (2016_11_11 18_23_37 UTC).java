public class BearPair{
	public static int bigDistance(String s){
		int n= s.length();
		int res= 0; 
		for(int i = 0; i< n; i++){
			if(s.charAt(i) != s.charAt(n)){
				res= n- i;
				return res;
			} else{
				n--; 
			}
			
		}
	}
}