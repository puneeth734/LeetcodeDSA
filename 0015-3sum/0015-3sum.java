class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i< nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while(l < r){
                int total = nums[i] + nums[l] + nums[r];

                if(total == 0){
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;

                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                    
                }else if(total < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}