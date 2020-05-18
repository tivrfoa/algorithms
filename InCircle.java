class InCircle {

    public static boolean inCircle(int R, int rx, int ry, int x, int y) {
      int dx = Math.abs(x-rx);
      if (dx >  R) return false;
      int dy = Math.abs(y-ry);
      if (    dy >  R ) return false;
      if ( dx+dy <= R ) return true;
      return ( dx*dx + dy*dy <= R*R );
    }

	public static void main(String args[]) {
		int R = 5;
		int rx = 0, ry = 4;

		int[][] points = {{-3,0},{3,0},{2,6},{5,4},{0,9},{7,8}};

		for (int i = 0; i < points.length; ++i) {
			System.out.println(inCircle(R, rx, ry, points[i][0], points[i][1]));
		}
	}
}
