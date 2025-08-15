class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)return true;
        for(int i=1;n>=1;i++){
            int rem=n%4;
            if(rem!=0){
                return false;
            }
            n=n/4;
            if(n==1 && rem==0){
                return true;
            }

        }
        return false;
    }
}
