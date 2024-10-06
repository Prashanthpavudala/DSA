package Arrays.Easy;

import java.util.*;

public class RemoveDuplicates {
  
  // Input: nums = [0,0,1,1,1,2,2,3,3,4]
  // Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
  public static int removeDuplicatesFromSortedArray(int[] nums, int n){
    Set<Integer> set = new HashSet<>();
    int index=0;
    for(int i=0; i<n; i++){
      if(set.add(nums[i])){
        nums[index++] = nums[i];
      }
    }
    System.out.println(Arrays.toString(nums));
    return set.size();
  }

  public static void main(String[] args) {
    int[] arr = {0,0,1,1,1,2,2,3,3,4,5};
    int n = arr.length;
    System.out.println(removeDuplicatesFromSortedArray(arr, n));
  }
}
