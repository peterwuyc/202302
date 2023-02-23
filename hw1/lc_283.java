import java.util.*;



public class Main {
    public static void main(String[] args) {
        
        }

    public void moveZeroes(int[] nums) {
        int index = 0;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }else{
                count++;
            }
        }
        for(int i = index; i<nums.length; i++){
            nums[i] = 0;
        }
    }
    }

    

