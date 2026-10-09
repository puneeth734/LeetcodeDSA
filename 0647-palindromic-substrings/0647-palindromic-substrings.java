class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i=0; i<s.length(); i++){
            String sub = "";
            for(int j=i; j<s.length(); j++){
                sub += s.charAt(j);
                if(isPalindrome(sub)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}