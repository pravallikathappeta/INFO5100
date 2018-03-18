public class Solution2 {
    public int[] searchForRange(int[] A, int target) {
        int l=0;
        int r=A.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(A[mid]>=target) r=mid-1;
            else l=mid+1;
        }
        int left=l;
        l=0;
        r=A.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(A[mid]>target) r=mid-1;
            else l=mid+1;
        }
        int right=r;
        if(left==A.length||A[left]!=target) left=-1;
        if(right==-1||A[right]!=target) right=-1;
        int[] ret=new int[2];
        ret[0]=left;
        ret[1]=right;
        return ret;
    }

    public static void main(String args[])
    {
        Solution2 sol = new Solution2();
        sol.searchForRange(new int[]{1,7,1},1);
    }
}
