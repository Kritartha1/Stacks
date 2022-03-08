//leetcode.com/problems/next-greater-element-i/
//Two approaches are disussed:
//Approach 1: Timeconsuming ans space inefficient
//Approach 2: Time and space efficient

//Appraoch 1:
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        int n=nums1.length;
        int m=nums2.length;
        
        int[] ans=new int[n];
        
        int[] ngr=NGR(nums2,m);
        int t=0;
        for(int i=0;i<m;i++){
            mp.put(nums2[i],i);
        }
        for(int i=0;i<n;i++){
            if(mp.get(nums1[i])==null){
                continue;
            }else{
                ans[t++]=ngr[mp.get(nums1[i])];
            }
        }
        
        return ans;
        
        
        
    }
    
    public int[] NGR(int[] nums,int m){
        int[] ans=new int[m];
        int k=m-1;
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=m-1;i>=0;i--){
            if(stack.size()==0){
                ans[k--]=-1;
            }else if(stack.size()!=0&&stack.peek()>nums[i]){
                ans[k--]=stack.peek();
            }else if(stack.size()!=0&&stack.peek()<=nums[i]){
                while(stack.size()>0&&stack.peek()<=nums[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    ans[k--]=-1;
                }else{
                    ans[k--]=stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Approach2:
//Idea:
//leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        int n=nums1.length;
        int m=nums2.length;
        
        Deque<Integer> stack=new ArrayDeque<>();
        
        for(int i=0;i<m;i++){
            while(stack.size()>0&&stack.peek()<nums2[i]){
                mp.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        for(int i=0;i<n;i++){
            nums1[i]=mp.getOrDefault(nums1[i],-1);
        }
        
        return nums1;
        
        
        
    }
    
    
}
