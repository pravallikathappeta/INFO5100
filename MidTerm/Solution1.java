public class Solution1 {

    public void findSubsequence(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (max == -1 || max < temp[j] + 1) {
                        max = 1 + temp[j];
                    }
                }
            }
            if (max == -1) {
                max = 1;
            }
            temp[i] = max;
        }
        int result = -1;
        int index = -1;
        for (int i = 0; i < temp.length; i++) {
            if (result < temp[i]) {
                result = temp[i];
                index = i;
            }
        }
        String subarray =  nums[index] + " ";
        int res = result-1;
        for (int i = index-1; i >= 0; i--) {
            if(temp[i]==res){
                subarray =  nums[i] + " " + subarray;
                res--;
            }
        }
        System.out.println("Longest Increasing subsequence: " + result);
        System.out.println("Elements in the subsequence " + subarray);
    }

    public static void main(String[] args) {
        int[] sol = { 1,2,3,4,5,6 };
        Solution1 i = new Solution1();
        i.findSubsequence(sol);
    }

}
