import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(char c: s.toCharArray()){
            if (c=='(' || c=='[' || c =='{') stk.push(c);
            else if (!stk.isEmpty() && map.get(c).equals(stk.peek())) stk.pop();
            else return false;
        }
        return stk.isEmpty();
    }
}
