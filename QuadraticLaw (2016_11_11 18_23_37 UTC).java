public class QuadraticLaw{
	public long getTime(long d){
		long t = 0;
		while(d >= t+ t*t){
			t++;
		}
		return t-1;
	}
}