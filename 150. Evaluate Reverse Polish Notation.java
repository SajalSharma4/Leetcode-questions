//150. Evaluate Reverse Polish Notation

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
 */

class Solution {
    private Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (!ops.contains(t))
                stack.push(Integer.parseInt(t));
            else {
                int b = stack.pop(), a = stack.pop();
                if (t.equals("+"))
                    stack.push(a + b);
                else if (t.equals("-"))
                    stack.push(a - b);
                else if (t.equals("*"))
                    stack.push(a * b);
                else
                    stack.push(a / b);
            }
        }
        return stack.pop();
    }
}