// url - https://leetcode.com/problems/subarray-sum-equals-k/

/**

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

 

Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


**/



class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();   // map of sum and freq.(of sum)
        int sum = 0, count = 0;
        map.put(0, 1);                      // initial step
        for(int x : nums){
            sum += x;
            if(map.containsKey(sum-k)){     // check for remain in map and add its value(freq) to count
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);   // increase freq of sum
        }
        return count;
    }
}


/**

output - 

[1,1,1]
k = 2
o/p -  2


[0,0,0,0]
k = 0
o/p - 10

**/
