

class IdentityMatrix {
    
    public static void main(String args[]) {

		var a = new int[][]{
			{1, 2, 3},
			{6, 3, 2},
			{2, 8, 9}
		};
		var I = new int[][]{
			{1, 0, 0},
			{0, 1, 0},
			{0, 0, 1}
		};

		var ans = new int[3][3];

		int n = ans.length;
		int m = ans[0].length;
        
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				for (int y = 0; y < m; ++y) {
					ans[i][j] += a[i][y] * I[y][j];
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
    }
}

