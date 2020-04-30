import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {

    private static int[] a;
    private static int[][] dp;
    private static int n, h, l, r;

    // dp most say how many I can get from the position
    // and time, not how many I already have ...
    private static int findBest(int i, int t) {
        if (dp[i][t] != -1) {
            return dp[i][t];
        }

        int good = 0;

        if (t >= l && t <= r) ++good;

        if (i+1 == n) {
            dp[i][t] = good;
        } else {
            dp[i][t] = max(findBest(i+1, (t + a[i+1]) % h) + good,
                           findBest(i+1, (t + a[i+1] - 1) % h) + good);
        }
        
        return dp[i][t];
    }

    public static void solve() {
        n = sc.nextInt();
        h = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        
        a = new int[n];
        // i, time
        dp = new int[n][h];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(max(findBest(0, a[0]),
                               findBest(0, a[0]-1)));
    }

    private static Scanner sc;

    public static void main(String args[]) throws Exception {
        sc = new Scanner(System.in);

        /*int T = sc.nextInt();

        for (int t = 0; t < T; ++t)*/
            solve();
    }

}

