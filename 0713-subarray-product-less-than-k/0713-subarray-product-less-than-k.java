class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int left = 0, prod = 1, cnt = 0;
        for(int r = 0; r < nums.length; r++){
            prod *= nums[r];

            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            cnt += r - left + 1;
        }
        return cnt;
    }
}