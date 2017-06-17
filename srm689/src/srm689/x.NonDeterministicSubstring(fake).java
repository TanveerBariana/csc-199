package srm689;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//this was not mine, i just did it to learn the programming 
//maybe it shows effort maybe not. the other was my attempt before i looked 
//at the answer. 
public class NonDeterministicSubstring {
	public long ways(String A, String B){
		HashSet<String> seen = new HashSet<>();// hashset import
		StringBuilder sb = new StringBuilder();// use to make changeable strings
		for(int i = 0; i < B.length(); i++){
			if(B.charAt(i)== '?'){
				sb.append("[01]");
			} else{
				sb.append(B.charAt(i));
			}
		}
		Pattern p = Pattern.compile(sb.toString());
		Matcher m = p.matcher(A);//import regex
		int last = 0; 
		while(m.find(last)){
			seen.add(m.group());
			last = m.start()+1; 
		}
		return seen.size();
	}
}
