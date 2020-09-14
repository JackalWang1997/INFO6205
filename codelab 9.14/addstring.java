
public class addstring {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();

        // Add from the small digits
        int carry = 0;
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        for(; i1 >= 0 && i2 >= 0; i1--, i2--) {
            int digit1 = num1.charAt(i1) - '0';
            int digit2 = num2.charAt(i2) - '0';
            ans.append((digit1 + digit2 + carry) % 10);
            carry = (digit1 + digit2 + carry) / 10;
        }

        // Add the remaining part
        while(i1 >= 0) {
            int digit1 = num1.charAt(i1--) - '0';
            ans.append((digit1 + carry) % 10);
            carry = (digit1 + carry) / 10;
        }

        while(i2 >= 0) {
            int digit2 = num2.charAt(i2--) - '0';
            ans.append((digit2 + carry) % 10);
            carry = (digit2 + carry) / 10;
        }

        // Add the possible carry digit
        if(carry > 0) ans.append(carry);

        return ans.reverse().toString();
    }

}
