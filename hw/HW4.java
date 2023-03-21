/*
20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

class Solution {
    public boolean isValid(String s) {
    }
}
*/
public class HW4 {
    public boolean isValid(String s) {
        if(s.length() < 2) {
            return false;
        }
        Stack<Character> stacks = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == ')' || a == ']' || a == '}') {
                if(stacks.isEmpty()) {
                    return false;
                }
                else if(a == ')' && stacks.pop() != '(') {
                    return false;
                }
                else if(a == '}' && stacks.pop() != '{') {
                    return false;
                } else if(a == ']' && stacks.pop() != '[') {
                    return false;
                }
            } else {
                stacks.push(s.charAt(i));
            }
        }
        return stacks.empty();
    }
}
/*
387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1

class Solution {
    public int firstUniqChar(String s) {
    }
}
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length();i++) {
            char temp = s.charAt(i);
            if(temp == '(' || temp == '{' || temp == '[') {
                stack.push(s.charAt(i));
            } else if (temp == ')' || temp == '}' || temp == ']') {
                if(stack.isEmpty()) {
                    return false;
                } else if(temp == ')' && stack.pop() != '(') {
                    return false;
                } else if(temp == '}' && stack.pop() != '{') {
                    return false;
                } else if(temp == ']' && stack.pop() != '[') {
                    return false;
                }
            }

        }
        return stack.empty();
    }
}