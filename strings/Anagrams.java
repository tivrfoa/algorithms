// https://leetcode.com/problems/group-anagrams/

import java.util.*;

class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                        31, 37, 41, 43, 47, 53, 59, 61, 67,
                        71, 73, 79, 83, 89, 97, 101};
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) return ans;

        Map<Integer, List<String>> hs = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            int sum = hash(s);
            List<String> group = hs.get(sum);
            if (group == null) {
                group = new ArrayList<>();
                hs.put(sum, group);
                ans.add(group);
            }
            group.add(s);
        }
        return ans;
    }
    
    private int hash(String s) {
        char[] c = s.toCharArray();
        int sum = 1;
        for(char d : c){
            sum *= primes[d-'a'];
        }
        return sum;
    }
}
