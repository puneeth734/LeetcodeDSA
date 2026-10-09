class Solution {
    public String longestPalindrome(String s) {
        int st = 0,  maxLen = 0;

        for(int i=0; i<s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len  = Math.max(len1, len2);

            if(len > maxLen){
                maxLen = len;
                st = i - (len -1) / 2;
            }
        }
        return s.substring(st, st+maxLen);
    }
    private int expand(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--; r++;
        }
        return r - l - 1;
    }
}