class Solution {
    public int minInsertions(String s) {

        return dfs(s,new Integer[s.length()][s.length()],0,s.length()-1);
    }


    int dfs(String s, Integer[][] memo, int i, int j) {
        if (i > j)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        int res= 0;
        if (s.charAt(i)==s.charAt(j))
            res=dfs(s,memo,i+1,j-1);
        else
        {
            
            res=Math.min(1+dfs(s,memo,i+1,j),1+dfs(s,memo,i,j-1));
        }
        
        memo[i][j]=res;
        
        return res;
    }
}