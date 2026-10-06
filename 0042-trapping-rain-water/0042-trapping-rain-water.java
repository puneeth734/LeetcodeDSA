class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int lMax = 0, rMax = 0, water = 0;

        while( l < r ) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if(lMax < rMax){
                water += lMax - height[l];
                l++;
            }else{
                water += rMax - height[r];
                r--;
            }
        }
        return water;
    }
}