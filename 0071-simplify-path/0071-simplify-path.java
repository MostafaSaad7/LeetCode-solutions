import java.util.Stack;

class Solution {
    public static String simplifyPath(String path) {
        path+='/';
        Stack<String> stack = new Stack<>();
        StringBuilder currentFile = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c == '/') {
                if (currentFile.toString().equals("..")) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else if (!currentFile.toString().equals(".") && !currentFile.isEmpty()) {
                    stack.push(currentFile.toString());
                }
                currentFile = new StringBuilder();


            } else {
                currentFile.append(c);
            }
        }
        StringBuilder res = new StringBuilder();

        if (stack.empty())
            return "/";
        for (var val : stack) {
            res.append('/');
            res.append(val);

        }


        return res.toString();
    }

    public static void main(String[] args) {
        simplifyPath("/a//b////c/d//././/..");
    }
}