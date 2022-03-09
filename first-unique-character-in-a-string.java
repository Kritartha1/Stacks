//leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    //for better space:use frequency array instead of hashmap
    public int firstUniqChar(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        
        for(int i=0;i<n;i++){
            if(mp.get(s.charAt(i))==1){
                return i;
            }
        }
        
        
        return -1;
        
        
    }
}
