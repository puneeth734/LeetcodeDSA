class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r< fruits.length; r++){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);

            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, r - left + 1);
        }
        return maxLen;
    }
}