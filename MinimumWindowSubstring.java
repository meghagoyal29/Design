package LeetCode.Design;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println(minWindow("abcabdebac","cda"));
	}
	public static String minWindow(String s, String t) {
		if(s==null||t==null||s.length()==0||t.length()==0) {
			return "";
		}
		HashMap<Character, Integer> smallStringMap=createSmallStringMap(t);
		int index=0;
		int startIndex=0;
		int endIndex=startIndex;
		int min=0;
		int max=startIndex;
		int minDist=Integer.MAX_VALUE;
		while(index<s.length()) {
			while(index<s.length()&& !smallStringMap.containsKey(s.charAt(index))) {
				index++;
			}
			if(index>=s.length())
				break;
			startIndex=index;
			removeKeyfromMap(smallStringMap, s.charAt(startIndex));
			index++;
			while(index<s.length()&& smallStringMap.size()>0) {
				if(smallStringMap.containsKey(s.charAt(index))){
					removeKeyfromMap(smallStringMap, s.charAt(index));
				}
				index++;
			}
			if(smallStringMap.size()==0) {
				endIndex=index;
				if(minDist>endIndex-startIndex) {
					min=startIndex;
					max=endIndex;
					minDist=endIndex-startIndex;
					System.out.println(s.substring(min, max));
					System.out.println(max-min);
				}
				smallStringMap=createSmallStringMap(t);
				index = startIndex+1;
				continue;
			}
		}
		if(max <=min) {
			return "";
		}
		return s.substring(min, max);
	}

	private static HashMap<Character, Integer> createSmallStringMap(String t) {
		HashMap<Character, Integer> smallStringMap=new HashMap<>();
		for(char c:t.toCharArray()) {
			appendKeyToMap(smallStringMap, c);
		}
		return smallStringMap;
	}
	private static void removeKeyfromMap(HashMap<Character, Integer> map, char c) {
		if(map.containsKey(c)) {
			if(map.get(c)==1) {
				map.remove(c);
			}
			else map.put(c,map.get(c)-1);
		}

	}

	private static void appendKeyToMap(HashMap<Character, Integer> map, char c) {
		if(map.containsKey(c)) {
			map.put(c, map.get(c)+1);

		}else {
			map.put(c,1);
		}

	}
}
