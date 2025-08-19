class Solution {
    public long zeroFilledSubarray(int[] nums) {
     long ans=0;
     long countzero=0;
     for(int num:nums){
        if(num==0){
            countzero++;
            ans=ans+countzero;
        }
        else countzero=0;
     } 
     return ans;  
    }
}
