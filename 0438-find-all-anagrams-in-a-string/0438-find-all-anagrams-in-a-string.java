class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        if(m > n){
            return ans;
        }

        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for(int i=0; i<m; i++){
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pFreq, sFreq)){
            ans.add(0);
        }

        for(int i = m; i < n; i++){
            sFreq[s.charAt(i) - 'a']++;
            sFreq[s.charAt(i - m) - 'a']--;

            if(Arrays.equals(sFreq, pFreq)){
                ans.add(i - m + 1);
            }
        }
        return ans;
    }
}