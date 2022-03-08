//leetcode.com/problems/min-stack/
MinStack {

    public class StackNode{
        int val;
        int min;
        StackNode next;
        StackNode(int val,int min,StackNode next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }
    
    StackNode top;
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(top==null){
            top=new StackNode(val,val,null);
        }else{
            top=new StackNode(val,Math.min(top.min,val),top);
        }
    }
    
    public void pop() {
        
        top=top.next;
        
    }
    
    public int top() {
        
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
