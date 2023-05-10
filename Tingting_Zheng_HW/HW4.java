import java.util.*;
class HW4 {
    // Leetcode 20. Valid Parentheses
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();
            for(char c : s.toCharArray()){
                if(c=='(' || c=='{' || c=='['){
                    stack.offerLast(c);
                }else{
                    if(stack.isEmpty()) return false;
                    if(c==')' &&  stack.peekLast()!='('){
                        return false;
                    }
                    if(c=='}' && stack.peekLast()!='{'){
                        return false;
                    }
                    if(c==']' &&  stack.peekLast()!='['){
                        return false;
                    }
    
                    stack.removeLast();
                }
            }
            return stack.isEmpty();
            
        }
    }

    // Leetcode 387. First Unique Character in a String

    public int firstUniqChar(String s) {
        int[] rec = new int[26];
        for(char c : s.toCharArray()){
            rec[c-'a']++;
        }
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(rec[c-'a']==1) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Pilot_HW4");
    } 
}
