class Solution {
    public int mySqrt(int x) {
        int ans=0;
        int low=0;
        int high=x;
        while(low<=high){
            int mid=low+(high-low)/2;
            long square=(long) mid*mid;
            if(square==x){
                return mid;
            }if(square<=x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
        
    }
}