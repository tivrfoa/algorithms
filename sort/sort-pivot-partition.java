class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        sort(nums, 0, nums.length - 1);
        //System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (sb.length() != 0 || nums[i] != 0) {
                sb.append(nums[i]);
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }

    private int compare(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }

        if (s1.startsWith(s2)) {
            return compare(s1.substring(s2.length()), s2);
        }

        if (s2.startsWith(s1)) {
            return compare(s1, s2.substring(s1.length()));
        }
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            char ch1 = s1.charAt(index);
            char ch2 = s2.charAt(index);
            if (ch1 > ch2) {
                return 1;
            } else if (ch1 < ch2) {
                return -1;
            }
            index++;
        }

        return 0;
    }

    private void sort(int[] nums, int start, int end) {
        if (start < end) {
            int pi = partition(nums, start, end);

            sort(nums, start, pi - 1);
            sort(nums, pi + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (compare(Integer.toString(nums[j]), Integer.toString(pivot)) == 1) {
                //System.out.println(nums[j]+" "+pivot);
                i++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = temp;
        //System.out.println(Arrays.toString(nums));
        
        return i + 1;
    }


	public static boolean debug(String s) {
        if (print_debug) System.out.print(s);
        return true;
    }

    private static boolean print_debug = false;

    public static void main(String args[]) {
        if (args.length > 0 && args[0].equals("debug")) print_debug = true;
        Solution s = new Solution();
        String test1 = s.largestNumber(new int[]{3,30,34,5,9});
        String test2 = s.largestNumber(new int[]{10,2});
        String test3 = s.largestNumber(new int[]{0,0});
        String test4 = s.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247});
        String test5 = s.largestNumber(new int[]{121,12});
        assert test1.equals("9534330") : "Expected 9534330 but got " + test1;
        assert test2.equals("210"): "Expected 210 but got " + test2;
        assert test3.equals("0"): "Expected 0 but got " + test3;
        assert test4.equals("9609938824824769735703560743981399"): "Expected 9609938824824769735703560743981399 but got " + test4;
        assert test5.equals("12121"): "Expected 12121 but got " + test5;

        System.out.println("THE END");
    }
}
