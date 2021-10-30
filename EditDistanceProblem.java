
class EditDistanceProblem {
    public int minDistance(String word1, String word2) {
        
        return dp(word1,0,word2,0,new int[word1.length()+1][word2.length()+1]);
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
