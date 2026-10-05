class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxLen = Math.max(count, maxLen);
            }else{
                count = 0;
            }
        }
        return maxLen;
    }
}