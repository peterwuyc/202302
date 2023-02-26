import java.util.Arrays;

public class h1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++){
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void moveZeroes(int[] nums) {
        int i = 0; // pointer for non-zero elements
        int j = 0; // pointer for iterating through the array

        while (j < nums.length) {
            if (nums[j] != 0) {
                // swap non-zero element to the left of the array
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}
