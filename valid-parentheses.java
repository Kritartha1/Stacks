//leetcode.com/problems/valid-parentheses/submissions/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char curr=s.charAt(0);
        if(curr=='}'||curr==']'||curr==')'){
            return false;
        }
        st.add(curr);
        int n=s.length();
        int i=1;
        while(i<n){
            
            curr=s.charAt(i);
            if(curr=='{'||curr=='['||curr=='('){
                st.add(curr);
                
            }else if(st.isEmpty()){
                return false;
            }
            else if((!st.isEmpty())&&((curr=='}'&&st.peek()=='{')||(curr==']'&&st.peek()=='[')||(curr==')'&&st.peek()=='('))){
                    st.pop();
            }
            else{
                    return false;
            }
            
             ++i;
        }
        return st.isEmpty();
        
    }
}
