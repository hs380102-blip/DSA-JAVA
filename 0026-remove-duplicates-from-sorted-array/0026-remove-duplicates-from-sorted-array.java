class Solution {
    public int removeDuplicates(int[] nums) {
        int j=1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]!=nums[j-1]){
                nums[j]=nums[k];
                j++;
            }
        }
        return (j);

        
    }
}