// url - https://leetcode.com/problems/find-all-anagrams-in-a-string/

/**

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


**/



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length(), n2 = p.length();
        List<Integer> ans = new ArrayList<>();
        if(n1<n2) return ans;
        HashMap<Character, Integer> map1 =  new HashMap<>(), map2 = new HashMap<>();
        
        // map1 for reference (belongs to p)
        
        // setting up both the mas
        for(int i=0; i<26; i++){
            int x = 97+i;
            map1.put((char)x, 0);
            map2.put((char)x, 0);
        }
        
        // setting map1 for p  (reference map)
        for(int i=0; i<n2; i++){
            char ch = p.charAt(i);
            map1.put(ch, map1.get(ch)+1);
        }
        
        int l=0, r=n2;
        for(int i=0; i<n2; i++){
            char ch = s.charAt(i);
            map2.put(ch, map2.get(ch)+1);
        }
        
        while(l<n1 && r<n1){
            if(new ArrayList<>(map1.values()).equals(new ArrayList<>(map2.values()))) ans.add(l);
            char x = s.charAt(l);
            char y = s.charAt(r);
            map2.put(x, map2.get(x)-1);
            map2.put(y, map2.get(y)+1);
            l++;
            r++;
        }
        if(new ArrayList<>(map1.values()).equals(new ArrayList<>(map2.values()))) ans.add(l);
        return ans;
    }
}


/**

Accepted
Runtime: 0 ms
Your input
"cbaebabacd"
"abc"
Output
[0,6]
Expected
[0,6]


**/
