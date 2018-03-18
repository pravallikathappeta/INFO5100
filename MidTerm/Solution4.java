public class Solution4{

    public int minimumSubArraySum(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int currSum = nums[0];
        int minLen = nums.length;
        while (i < nums.length)
        {
            if (currSum >= s)
            {
                if (minLen > j - i + 1)
                {
                    minLen = j - i + 1;
                }
                currSum -= nums[i];
                i++;
            } else
                {
                j++;
                if (j >= nums.length)
                {
                    break;
                }
                currSum += nums[j];
            }
        }
        return minLen;
    }


    public static void main(String[]args)
    {
            Solution4 sol = new Solution4();
            sol.minimumSubArraySum(35,new int[] {3,12,6,1,8,31});
    }
}
