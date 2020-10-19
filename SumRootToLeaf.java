

class SumRootToLeaf {
    int total=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return total;
    }
    
    public void dfs(TreeNode node,int sum){
        if(node==null)
            return;
        sum=sum*10+node.val;
        if(node.left==null && node.right==null){
            total+=sum;
            return;
        }
        dfs(node.left,sum);
        dfs(node.right,sum);
    }
}
