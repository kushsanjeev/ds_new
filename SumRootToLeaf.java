/*

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

	Input: [1,2,3]
		1
       / \
	  2   3
	Output: 25
	Explanation:
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	Therefore, sum = 12 + 13 = 25.

*/

class SumRootToLeaf {
    int total=1;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return total;
    }
	int q = 0;
	for(int i = 0; i<n; i++){
		q++;
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
