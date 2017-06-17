package srm689;

import java.util.HashMap;

public class ColorfulGardenHard {
//this is not mine, did it to learn how to solve 
//problems like this in the future 
	public int MOD = 1000000007;
	char[] G;// global because used betwen methods for G.length
	int[] F;// global because decalred in count, used as condition in go
	HashMap<String, Integer> dp = new HashMap<>();//purpose of hashmap is
	int[] counts = new int[26]; //Alphabet tracker
	
	public int count(String garden, String forbid){
		G = garden.toCharArray();//
		F = new int[G.length];
		for(int i = 0; i< G.length; i++){
			counts[G[i]- 'a']++;// increment the counter for the current letter
			F[i]= forbid.charAt(i)-'a';// map F with numerical equivalent of forbid at current char
		}
		int res = go(0, -1);
		return res;
	}
	
	int go(int index, int prev){
		if(index == G.length){
			return 1; 
		}
		StringBuilder k = new StringBuilder();
		k.append(index);
		k.append('|');
		k.append(prev);
		for(int i = 0; i< 26; i++){//append the count of every letter onto the string
			k.append('|');
			k.append(counts[i]);
		}
		String key = k.toString();// the list is turned into string key 1|0|a-1
		if (dp.containsKey(key)){//if there is key in the hashMap
			return dp.get(key); //return a possible pattern of flowers 
		}
		int res = 0;
		for(int i= 0; i <26; i++){
			if(i== prev || counts[i]== 0 || i == F[index])continue;//skip for loop if you checked already, decremented a letters count to 0(end recursion depth), or at at a forbidden section 
			counts[i] -= 1;// decrement the count for the current letter, this used with the recursion will decrement to 0
			res = (res +(go(index++, i)) % MOD) %MOD;// recursivly do go until entire alphebet has been done
			counts[i] += 1; 
		}
		dp.put(key, res);//exstablish  key after 
		return res;
	}
}
