// url - https://leetcode.com/problems/sort-array-by-parity/

/*

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


*/


class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int l=0, r=n-1;
        for(int x: A){
            if((x&1) == 1) ans[r--] = x;
            else ans[l++] = x;
        }
        return ans;
    }
}


/*

Accepted
Runtime: 0 ms
Your input
[3,1,2,4]
Output
[2,4,1,3]
Expected
[2,4,3,1]

*/
