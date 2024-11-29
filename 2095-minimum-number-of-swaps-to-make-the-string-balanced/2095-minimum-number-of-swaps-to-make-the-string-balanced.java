class Solution {
    public int minSwaps(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(c=='[')
            stack.push('[');
            else{
                if(!stack.isEmpty())
                    stack.pop();
                else 
                stack.push(']');


            }

        }

        return (stack.size())/2;
    }
}