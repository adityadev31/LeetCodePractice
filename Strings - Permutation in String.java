// url - https://leetcode.com/problems/permutation-in-string/

/**

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Constraints:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

**/



/**
  A P P R O A C H - 
  using 2 hash maps storing s1 and sliding window s2
**/





class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if(n1>n2) return false;
        int k = n1;
        HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        
        // setting maps
        for(int i=0; i<26; i++){
            map1.put(i, 0);
            map2.put(i, 0);
        }
        
        
        // setting map 1 of S1
        for(int i=0; i<n1; i++){
            int x = s1.charAt(i)-'a';
            map1.put(x, map1.get(x)+1);
        }
        
        // iterating s2
        int l=0, r=l+k;
        for(int i=0; i<k; i++){
            int x = s2.charAt(i)-'a';
            map2.put(x, map2.get(x)+1);
        }
        
        while(l<n2 && r<n2){
            if(new ArrayList<>( map1.values() ).equals(new ArrayList<>( map2.values() ))) return true;
            else{
                int p = s2.charAt(l)-'a';
                int q = s2.charAt(r)-'a';
                map2.put(p, map2.get(p)-1);
                map2.put(q, map2.get(q)+1);
                l++;
                r++;
            }
        }
        if(new ArrayList<>( map1.values() ).equals(new ArrayList<>( map2.values() ))) return true;
        return false;
    }
}


/**
Accepted
Runtime: 0 ms
Your input
"ab"
"eidbaooo"
Output
true
Expected
true

**/
