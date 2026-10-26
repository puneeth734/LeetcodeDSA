class Solution {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder sword = new StringBuilder();
        StringBuilder tword = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '#') {
                if (sword.length() > 0) {
                    sword.deleteCharAt(sword.length() - 1);
                }
            } else {
                sword.append(ch);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);

            if (ch == '#') {
                if (tword.length() > 0) {
                    tword.deleteCharAt(tword.length() - 1);
                }
            } else {
                tword.append(ch);
            }
        }
        return sword.toString().equals(tword.toString());
    }
}