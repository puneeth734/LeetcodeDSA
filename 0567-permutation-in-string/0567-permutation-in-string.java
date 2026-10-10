class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(m < n){
            return false;
        }
        int[] s1F = new int[26];
        int[] s2F = new int[26];

        for(int i=0; i < n; i++){
            s1F[s1.charAt(i) - 'a']++;
            s2F[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1F, s2F)){
            return true;
        }

        for(int i = n; i < m; i++){
            s2F[s2.charAt(i) - 'a']++;
            s2F[s2.charAt(i - n) - 'a']--;

            if(Arrays.equals(s1F, s2F)){
                return true;
            }
        }
        return false;
    }
}