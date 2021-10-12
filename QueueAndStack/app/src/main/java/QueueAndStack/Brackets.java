package QueueAndStack;

public class Brackets {
    public static boolean ValidateBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x != '(' && x != '[' && x != '{'&&x != ')' && x != ']' && x != '}') continue;
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;}
            if (stack.isEmpty()) return false;
            char check= stack.pop();
            switch (x) {
                case ')': if (check == '{' || check == '['){return false;}
                    break;
                case '}': if (check == '(' || check == '['){return false;}
                    break;
                case ']':
                    if (check == '(' || check == '{'){return false;}
                    break;
            }
        }
        return (stack.isEmpty());
    }
}
