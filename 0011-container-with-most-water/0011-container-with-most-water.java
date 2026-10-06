class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0; int r = height.length-1;
        while(l <= r){
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            int area = h * w;

            maxArea = Math.max(area, maxArea);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}