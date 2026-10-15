class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0 ; i < bloomDay.length ; i++){
            if(bloomDay[i] > max){
                max = bloomDay[i];
            }
            if(bloomDay[i] < min){
                min = bloomDay[i];
            }
        }

        int start = min ;
        int end  = max;
        int ans =1;

        if(bloomDay.length < (long)m * k) return -1;

        while(start <= end){
            int mid = start + (end - start) /2;

            if(possible(bloomDay, mid , m , k) == true){
                ans = mid ;
                end = mid -1;
            }else{
                start = mid +1 ;
            }
        }
        return ans; 
    }

    boolean possible(int[] bloomDay , int day , int m , int k){

        int count =0;
        int noofbloom =0;
        for(int i=0 ; i< bloomDay.length ; i++){
            if(bloomDay[i] <= day){
                count++;
            }else{
                noofbloom += (count / k);
                count =0;
            }
        }
        noofbloom += (count / k);

        if(noofbloom >= m){
            return true;
        }
        return false;
    }
}