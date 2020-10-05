/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

	Input: S = "ADOBECODEBANC", T = "ABC"
	Output: "BANC"

*/

class Solution {
    public String minWindow(String s, String t) {
       HashMap<Character,Integer> hm = new HashMap<>();
       for(int i=0;i<t.length();i++){
           char ch = t.charAt(i);
           hm.put(ch,hm.getOrDefault(ch,0)+1);
       }
       int missing=hm.size();
       int left=0,l=0,r=Integer.MAX_VALUE;
       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(hm.containsKey(ch)){
               int c = hm.get(ch);
               c-=1;
               hm.put(ch,c);
               if(c==0){
                   missing-=1; 
               }
           }
           while(missing==0){
               if(i-left<r-l){
                   l=left;
                   r=i;
               }
               char temp = s.charAt(left++);
               if(hm.containsKey(temp)){
                   if(hm.get(temp)==0)
                       missing+=1;
                   hm.put(temp,hm.get(temp)+1);
               }
               
           }
       }
        return r==Integer.MAX_VALUE ? "" : s.substring(l,r+1);
    }
}