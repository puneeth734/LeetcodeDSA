class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count =0;
        for(int val: arr1){
            if(isFound(arr2, val-d, val + d)){
                count++;
            }   
        }
        return count;
    }
    private static boolean isFound(int[] arr, int st, int end){
        int left = 0, right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= st && arr[mid] <= end){
                return false;
            }else if(arr[mid] < st){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return true;
    }
}