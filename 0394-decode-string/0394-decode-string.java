class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current.toString());

                num = 0;
                current = new StringBuilder();
            }

            else if (ch == ']') {

                int count = countStack.pop();
                String previous = stringStack.pop();

                StringBuilder temp = new StringBuilder(previous);

                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }

                current = temp;
            }

            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}