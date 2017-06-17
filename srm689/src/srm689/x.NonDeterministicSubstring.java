package srm689;
// this is was my earnest attempt before looking at the answer to 
//learn how to do the commented parts
public class NonDeterministicSubstring {
	public long ways(String A, String B){
		long ans= 0;
		if(A.length()>= B.length()){
			String[] avail= new String[100];
			for (int i= 0; i< B.length(); i++ ){
				int result = 0;
				while(B.charAt(i)== '?'){
					 result++; // use to count how many consequtive ?s are there 
					 i++;
				}
				for(int j= 0; j < avail.length; j++){
					String[j]= temp + 
				}
				//make array of all possible outcomes of consecutive ?'s 
				//apend prevoise string onto front of posible outcoems 
				//update array
			}
			for(int i= 0; i < avail.length; i++){
				if(A.contains(avail[i])){
					ans++;
				} 
			}
		}
		return ans; 
	}
}
