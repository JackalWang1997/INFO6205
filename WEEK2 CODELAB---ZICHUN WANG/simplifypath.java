import java.util.Stack;

//week2 Q13
public class simplifypath {
    public String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");
        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() > 0 ? result.toString() : "/" ;
    }
}
