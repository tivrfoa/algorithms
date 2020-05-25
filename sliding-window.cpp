#include <algorithm>
#include <cassert>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxVowels(string s, int k) {
        int vowels[26] = {1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1};
        
        int max_vow = 0;
        
        for (int i = 0, cur_vow = 0; i < s.size(); ++i) {
            cur_vow += vowels[s[i] - 'a'];
            
            if (i >= k) {
                cur_vow -= vowels[s[i - k] - 'a'];
            }
                
            max_vow = max(cur_vow, max_vow);
        }
        
        return max_vow;
    }
};

int main() {

    Solution s;
    cout << s.maxVowels("abciiidef", 3) << endl;
}