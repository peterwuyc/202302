import java.util.*;


public class Main {
    public static void main(String[] args) {

    }

}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
