class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        int count = 0;
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) +1);

            if(map.get(n) > count){
                ans = n;
                count = map.get(n);
            }
        }
        return ans;
    }
}