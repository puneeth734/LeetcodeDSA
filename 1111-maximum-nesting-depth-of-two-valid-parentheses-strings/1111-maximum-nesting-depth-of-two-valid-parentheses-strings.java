class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int ans[] = new int[seq.length()];
        Stack<Character> st = new Stack<>();

        for(int i=0; i<seq.length(); i++){
            if (seq.charAt(i) == '(') {
                st.push('(');
                ans[i] = st.size() % 2;
            } 
            else {
                ans[i] = st.size() % 2;
                st.pop();
            }
        }
        return ans;
    }
}