public class CoinFlipsDiv2{ 
	public int countCoins(String state){
		int n= state.length();
		int result= 0; 
		if(state.charAt(0) == state.charAt(1)){
			result++;
		}
		if(state.charAt(n-1) == state.charAt(n-2)){
			result++;
		}
		for(i= 1; i < n-1; i++){
				if( state.charAt(i-1)== state.charAt(i)|| state.charAt(i) == state.charAt(i+1)){
					result++;
				}				
		}
		return result;
	}
}