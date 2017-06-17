package srm689;

public class SimilarUserDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String haveSimilar(String[] handles){
		int len = handles.length;
		int result= 0; 
		for(int i= 0; i<len; i++){
			String Cur= handles[i];
			String next= handles[i+1];
			if(Cur.length()== next.length()){
				int lenT= Cur.length();
				outerLoop:
				for(int j= 0; j< lenT; j++){
					if(Cur.charAt(j)== next.charAt(j)){
					} else if(sameGroup(Cur.charAt(j),next.charAt(j))){
					} else{
						break outerLoop;
					}
					if(j == lenT-1){
						result++;
					}
				}
			}
		}
		if(result > 0){
			return "Similar handles found";
		} else{
			return "Similar handles not found";
		}
	}
	boolean sameGroup(char a, char b){
		if(a=='0'|| a== 'O'){
			if(b=='0'|| b== 'O'){
				return true; 
			}
		} else if(a== 'l'|| a== '1'|| a== 'I'){
			if(b== 'l'|| b== '1'|| b== 'I'){
				return true;
			}
		} 
		return false;
	}
}

