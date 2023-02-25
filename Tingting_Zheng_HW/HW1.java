public class HW1 {
    // Leetcode 88. Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;

        for(int k = m+n-1; k>=0;--k){
            if(j<0) break;
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k] = nums1[i--];
            }else{
                nums1[k] = nums2[j--];
            }
        }
    }
    
    // Leetcode 283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int j = 0;
        int n = nums.length;
        for(int i = 0 ; i<n;++i){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }

        while(j<n){
            nums[j++] = 0;
        }
    }
    public static void main(String[] args) {
        System.out.println("Pilot_HW1");
    } 
}

