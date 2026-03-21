class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0; 
        for(int num : nums){
            right = Math.max(num,right);
        }   
        int ans = right;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(helper(nums, maxOperations, mid)){
                ans = mid;
                right = mid-1;                
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    private boolean helper(int[] nums, int maxOperations, int penalty){
        long op = 0;
        for(int num : nums){
            op += (num - 1)/penalty ;
        }
        return op <= maxOperations;
    }
}