package Arrays.Easy;

import java.util.Arrays;

public class FindLargest {

  public static int getLargest(int[] arr, int n){
    //brute force approach
    //O(NlogN)
    // Arrays.sort(arr);
    // return arr[n-1];

    //best approach
    //O(N) 
    int max = arr[0];
    for(int a : arr){
      if(a > max){
        max = a;
      }
    }
    return max;
  }

  public static int getSmallest(int[] arr, int n){
    int min = arr[0];
    for(int a : arr){
      if(a < min){
        min = a;
      }
    }
    return min;
  }
  
  public static void main(String[] args) {
    int[] arr = {2,10,6,4,7,5};
    System.out.println(getLargest(arr, arr.length));
    System.out.println(getSmallest(arr, arr.length));
  }
}
