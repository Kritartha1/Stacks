//leetcode.com/problems/remove-k-digits/
//Approach 1:no string builder..timeinefficient
class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        
            Deque<Character> stack=new LinkedList<>();
            
            int i=0;
            stack.push(num.charAt(0));
            
            for(i=1;i<n;i++){
                if(stack.peek()>num.charAt(i)&&k>0){
                    
                    while(!stack.isEmpty()&&k>0&stack.peek()>num.charAt(i)){
                        //since cases can arise like: string="1234567890"
                         stack.pop();
                         k--;
                        
                    }
                    
                }
                
                stack.push(num.charAt(i));
                
            }
            String res="";
        
            while(k--!=0&&!stack.isEmpty()){
                stack.pop();//cases like s="1234567" or"111111"
                                //so the above loop didn't deleted the elements..
                    //so we are removing the remaining k elements here..from the end of string
            }
        
            while(!stack.isEmpty()){
                res=stack.pop()+res;
            }
        
            i=0;
                
            for(;i<res.length();i++){
                   //getting the first significant digit or 1st non zero element from the left index..
                if(res.charAt(i)!='0'){
                    break;
                 }
            }
                
            res=res.substring(i);//from 0 to (i-1) elements were 0 ,,so delete that shit.
        
            // System.out.println("he"+s.length());
        
            return res.length()==0?"0":res;
            
                
                
         
    }
}
/////////////  /////////  /////////  ///////  //////// //////////  ////////  /////////// ////////////  //////////////  /////////////////  ////////////////  /////////////  ////

//Appraoch 2: String builder ..time efficient
class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        
            Deque<Character> stack=new LinkedList<>();
            
            int i=0;
            stack.push(num.charAt(0));
            
            for(i=1;i<n;i++){
                if(stack.peek()>num.charAt(i)&&k>0){
                    
                    while(!stack.isEmpty()&&k>0&stack.peek()>num.charAt(i)){
                        //since cases can arise like: string="1234567890"
                         stack.pop();
                         k--;
                    }
                    
                }
                
                stack.push(num.charAt(i));
                
            }
            
                
            StringBuilder res=new StringBuilder();
        
            while(k--!=0&&!stack.isEmpty()){
                stack.pop();//cases like s="1234567" or"111111"
                                //so the above loop didn't deleted the elements..
                    //so we are removing the remaining k elements here..from the end of string
            }
        
            while(!stack.isEmpty()){
                res.append(stack.pop());
            }
        
            res.reverse();
        
            while(res.length()>1&&res.charAt(0)=='0'){
            //getting the first significant digit or 1st non zero element from the left index..
                res.deleteCharAt(0);
            }
                
               
            return res.length()>0?res.toString():"0";
            
            
            
            
        
        
        
    }
}
