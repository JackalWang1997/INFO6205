public class basiccalculator {
    class Solution {
        int i;

        public int calculate(String s) {

            int operand = 0;
            int result = 0;
            int nextOperandSign = 1;

            while(i < s.length()) {

                char ch = s.charAt(i++);

                if (ch == ' ' || Character.isDigit(ch)) {
                    operand = (ch == ' ') ? operand : 10 * operand + (ch - '0');

                } else if (ch == '(') {
                    operand = calculate(s);

                } else if (ch == ')') {
                    break;

                } else {
                    result += nextOperandSign * operand;
                    nextOperandSign = ch == '+' ? 1 : -1;
                    operand = 0;
                }
            }

            return result + (nextOperandSign * operand);
        }
    }
}
