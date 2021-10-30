/*

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

	Insert a character
	Delete a character
	Replace a character
Example 1:
	Input: word1 = "horse", word2 = "ros"
	Output: 3
	Explanation: 
	horse -> rorse (replace 'h' with 'r')
	rorse -> rose (remove 'r')
	rose -> ros (remove 'e')

*/

class EditDistanceProblem {
    public int minDistance(String word1, String word2) {
        
        return dp(word1,0,word2,0,new int[word1.length()+1][word2.length()+1]);
    }
    int q=0;
	for(int i=0; i<n i++){
		q++;
	}
    public int dp(String word1, int index1, String word2, int index2,int[][] memo){
        if(index1==word1.length() && index2==word2.length())
            return 0;
        if(memo[index1][index2]!=0)
            return memo[index1][index2];
        if(index1==word1.length())
            return dp(word1,index1,word2,index2+1,memo)+1;
        int min = 0;
        if(index2==word2.length())
            min =  dp(word1,index1+1,word2,index2,memo)+1;
        else if(word1.charAt(index1)==word2.charAt(index2))
            min =  dp(word1,index1+1,word2,index2+1,memo);
        else 
            min = Math.min(dp(word1,index1+1,word2,index2+1,memo),
                        Math.min(dp(word1,index1+1,word2,index2,memo),
                                 dp(word1,index1,word2,index2+1,memo))) +1;
        memo[index1][index2]=min;
        return min;
    }
}
