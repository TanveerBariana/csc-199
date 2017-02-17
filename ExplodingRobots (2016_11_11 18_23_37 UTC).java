public class ExplodingRobots{
	public String canExplode(int x1, int y1, int x2, int y2, String instructions){
		int n= instructions.length();
		String in= instructions;
		for(int i= 0; i< n; i++){
			if(in.charAt(i)== "U"){
				if(distance(x1+1, y1, x2, y2) < distance(x1, y1, x2, y2)){
					x1++;
				} else if(distance(x1, y1, x2+1, y2) < distance(x1, y1, x2, y2)){
					x2++;
				}
			} else if(in.charAt(i)== "D"){
				if(distance(x1-1, y1, x2, y2) < distance(x1, y1, x2, y2)){
					x1--;
				} else if(distance(x1, y1, x2-1, y2) < distance(x1, y1, x2, y2)){
					x2--;
				}
			}else if(in.charAt(i)== "L"){
				if(distance(x1, y1-1, x2, y2) < distance(x1, y1, x2, y2)){
					y1--;
				} else if(distance(x1, y1, x2, y2-1) < distance(x1, y1, x2, y2)){
					y2--;
				}
			}else if(in.charAt(i)== "R"){
				if(distance(x1, y1+1, x2, y2) < distance(x1, y1, x2, y2)){
					y1++;
				} else if(distance(x1, y1, x2, y2+1) < distance(x1, y1, x2, y2)){
					y2++;
				}
			}
			if(x1= x2 && y1== y2){
				return "Explosion";
			}
		}
		return "Safe";
	}
}