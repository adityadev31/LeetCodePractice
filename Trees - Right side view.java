/*

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        // ======= EXCEPTIONAL =========
        if(root == null) return ans;
        
        // ======= LEVEL ORDER =========
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = null;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                temp = q.poll();
                if(i == size-1) ans.add(temp.val);          // checking the last element in the level
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        
        return ans;
    }
}



/*

Success
Details 
Runtime: 1 ms, faster than 80.17% of Java online submissions for Binary Tree Right Side View.
Memory Usage: 37.6 MB, less than 16.95% of Java online submissions for Binary Tree Right Side View.
Next challenges:

*/
