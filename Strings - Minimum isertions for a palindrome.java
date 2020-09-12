// url - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
/**


Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.

Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".

Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".

Example 4:

Input: s = "g"
Output: 0

Example 5:

Input: s = "no"
Output: 1

 

Constraints:

    1 <= s.length <= 500
    All characters of s are lower case English letters.



**/


// U S I N G    L C S


class Solution {
    
    public static int LCS(String s1, String s2, int n){
        int[][] store = new int[n+1][n+1];
        for(int i=0; i<=n; i++) store[i][0] = 0;
        for(int j=0; j<=n; j++) store[0][j] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) store[i][j] = 1 + store[i-1][j-1];
                else store[i][j] = Integer.max(store[i][j-1], store[i-1][j]);
            }
        }
        return store[n][n];
    }
    
    public int minInsertions(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int LCS = LCS(s1, s2, s1.length());
        return s1.length()-LCS;
    }
}



/*
O U T P U T -

Accepted
Runtime: 0 ms
Your input
"zzazz"
Output
0
Expected
0

*/
