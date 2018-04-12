import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> operations(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", num, 0, target, 0, 0);
        return ans;
    }
    public void helper(List<String> ans, String trial, String num, int pos, long target, long curVal, long curMul){
        if(pos==num.length() && curVal==target){
            ans.add(trial);
            return;
        }
        for(int i=pos; i<num.length(); i++){
            if(i!=pos && num.charAt(pos)=='0') return;
            String curNum = num.substring(pos, i+1);
            long curNumVal = Long.valueOf(curNum);
            if(pos==0){
                helper(ans, curNum, num, i+1, target, curNumVal, curNumVal);
            } else {
                helper(ans, trial + "+" + curNum, num, i+1, target, curVal + curNumVal, curNumVal);
                helper(ans, trial + "-" + curNum, num, i+1, target, curVal - curNumVal, -curNumVal);
                helper(ans, trial + "*" + curNum, num, i+1, target, curVal - curMul + curMul * curNumVal, curMul * curNumVal);
            }
        }
        return;
    }
}

public class ExtraCredit
        {
            public static void main(String args[])
            {
                Solution sol = new Solution();
                System.out.println(sol.operations("00",0));
            }

        }