import java.io.*;
import java.util.*;

/**
 * Very nice implementation by qwerty787788
 * 
 * https://atcoder.jp/contests/abc170/submissions/14308426
 */
public class Main {
    FastScanner in;
    PrintWriter out;

    final int MAX = (int) (2e5 + 10);
    TreeSet<A>[] all = new TreeSet[MAX];

    void add(int idx, A a) {
        remTS(all[idx]);
        all[idx].add(a);
        addTS(all[idx]);
    }

    void rem(int idx, A a) {
        remTS(all[idx]);
        all[idx].remove(a);
        addTS(all[idx]);
    }

    void addTS(TreeSet<A> x) {
        if (x.isEmpty()) {
            return;
        }
        A low = x.last();
        rep.add(low);
    }


    void remTS(TreeSet<A> x) {
        if (x.isEmpty()) {
            return;
        }
        A low = x.last();
        rep.remove(low);
    }

    TreeSet<A> rep = new TreeSet<>();

    void solve() {
        for (int i = 0; i < all.length; i++) {
            all[i] = new TreeSet<>();
        }
        int n = in.nextInt();
        int q = in.nextInt();
        int[] rat = new int[n];
        int[] where = new int[n];
        A[] a = new A[n];
        for (int i = 0; i < n; i++) {
            rat[i] = in.nextInt();
            where[i] = in.nextInt() - 1;
            a[i] = new A(i, rat[i]);
            add(where[i], a[i]);
        }
        for (int i = 0; i < q; i++) {
            int who = in.nextInt() - 1;
            int whereTo = in.nextInt() - 1;
            rem(where[who], a[who]);
            where[who] = whereTo;
            add(where[who], a[who]);
            out.println(rep.first().value);
        }
    }

    class A implements Comparable<A> {
        int id;
        int value;

        public A(int id, int value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(A o) {
            if (value != o.value) {
                return Integer.compare(value, o.value);
            }
            return Integer.compare(id, o.id);
        }
    }


    final int mod = 988244353;

    int mul(int x, int y) {
        return (int) ((x * 1L * y) % mod);
    }

    int add(int x, int y) {
        x += y;
        return x >= mod ? (x - mod) : x;
    }

    void run() {
        try {
            in = new FastScanner(new File("Main.in"));
            out = new PrintWriter(new File("Main.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();
        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new Main().runIO();
    }
}
