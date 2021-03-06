public class Solution3 {
    public void rotatedArray(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        sol.rotatedArray(new int[]{1,2,3,4,5,6,7},2);
    }
}
