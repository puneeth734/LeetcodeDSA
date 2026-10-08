class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int min = 0, max = 0;

        for(int num: nums){
            sum += num;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        return max - min;
    }
}