/*

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

 

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2

 

Note:

    N will be in the range [1, 100].
    K will be in the range [1, N].
    The length of times will be in the range [1, 6000].
    All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100


*/



class Solution {
    
    public int networkDelayTime(int[][] times, int N, int K) {
        
        int[] weight = new int[N];
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<N; i++) weight[i] = Integer.MAX_VALUE;
        weight[K-1] = 0;
        
        
        for(int j=0; j<N-1; j++){
            
            int min = Integer.MAX_VALUE, minIdx = -1;
            
            for(int i=0; i<N; i++){                             // step1  select the min weight vertice (also unprocessed)
                if(weight[i]<min && !visited.contains(i)){
                    min = weight[i];
                    minIdx = i;
                }
            }
            
            visited.add(minIdx);                                 // step2 make it processed (insert in visited set)
            
            for(int i=0; i<times.length; i++){                   // step3 relax the weights of the adjacent nodes of maxIdx node [ if Cu + w < Cv ]
                if((times[i][0]-1 == minIdx) && !visited.contains(times[i][1]-1) && (weight[times[i][0]-1]+times[i][2] < weight[times[i][1]-1])){
                    weight[times[i][1]-1] = weight[times[i][0]-1] + times[i][2];            //Cv = Cu + w
                }
            }
            
        }
        
        // return the max weight
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            if(weight[i] > max) max = weight[i];
        }
        
        if(max > 10000) return -1;    // return -1 if impossible
        return max;
    }
}



/*

OUTPUT - 

Accepted
Runtime: 0 ms
Your input
[[2,1,1],[2,3,1],[3,4,1]]
4
2
Output
2
Expected
2

*/
