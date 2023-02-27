class Solution {
    public void moveZeroes(int[] nums) {
        int nz = 0;
        int tmp = 0;
        for (int z = 0; z < nums.length; z++) {
            if (nums[z] != 0){
                tmp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = tmp;
                nz += 1;
            }
        }
    }
}