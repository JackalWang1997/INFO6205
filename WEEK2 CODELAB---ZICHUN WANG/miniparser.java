import java.util.List;
import java.util.Stack;

//week2 Q17
public interface NestedInteger {

              public NestedInteger();
              public NestedInteger(int value);
              public boolean isInteger();
              public Integer getInteger();
              public void setInteger(int value);
              public void add(NestedInteger ni);
              public List<NestedInteger> getList();
  }
public class miniparser {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        boolean inNum = false;
        int sign = 1;
        int curr = 0;
        NestedInteger currInt = null;
        for(char c: s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                inNum = true;
                curr = curr * 10 + (c - '0');
            } else if (c == ',') {
                if(inNum) {
                    if(currInt == null)
                        currInt = new NestedInteger(curr * sign);
                    else
                        currInt.add(new NestedInteger(curr * sign));
                    curr = 0;
                    sign = 1;
                    inNum = false;
                }
            } else if (c == '[') {
                if(currInt != null) {
                    stack.push(currInt);
                }
                currInt = new NestedInteger();
            } else if (c == ']') {
                if(inNum) {
                    currInt.add(new NestedInteger(curr * sign));
                    curr = 0;
                    inNum = false;
                    sign = 1;
                }
                if(stack.size() > 0) {
                    NestedInteger last = stack.pop();
                    last.add(currInt);
                    currInt = last;
                }
            } else if (c == '-') {
                sign = -1;
            }
        }
        if(currInt == null && inNum)
            currInt = new NestedInteger(curr * sign);
        if(currInt == null)
            currInt = new NestedInteger();

        return currInt;
    }
}
