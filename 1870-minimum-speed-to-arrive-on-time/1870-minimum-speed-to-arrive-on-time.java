class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;
        int answer = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            double time = calculateTime(dist, mid);

            if(time <= hour){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
    private double calculateTime(int[] dist, int speed){
        double totalTime = 0;

        for(int i = 0; i < dist.length - 1; i++){
            totalTime+= (dist[i] + (speed - 1)) / speed;
        }
        totalTime+= (double)dist[dist.length - 1] / speed;

        return totalTime;
    }
}