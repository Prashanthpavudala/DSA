package Arrays.Easy;

public class SecondLargest {

  public static int getSecondLargest(int[] arr, int n){
    //brute force -- O(2N)
    // int largest = arr[0];
    // int sLargest = -1;
    // for(int a : arr){
    //   if(a > largest){
    //     largest = a;
    //   }
    // }
    // for(int a : arr){
    //   if(a < largest && a > sLargest){
    //     sLargest = a;
    //   }
    // }
    // return sLargest;

    //optimal approach -- O(N)
    int largest = Integer.MIN_VALUE;
    int sLargest = Integer.MIN_VALUE;
    for(int a : arr){
      if(a > largest){
        sLargest = largest;
        largest = a;
      }else if(a != largest && a > sLargest){
        sLargest = a;
      }
    }
    return sLargest;
  }

  public static int getSecondSmallest(int[] arr, int n){
    int small = Integer.MAX_VALUE;
    int secondSmall = Integer.MAX_VALUE;
    for(int a : arr){
      if(a < small){
        secondSmall = small;
        small = a;
      }else if(a != small && a < secondSmall){
        secondSmall = a;
      }
    }
    return secondSmall;
  }

  public static void main(String[] args) {
    int[] arr = {2,4,10,8,5,3,9};
    int n = arr.length;
    System.out.println(getSecondLargest(arr, n));
    System.out.println(getSecondSmallest(arr, n));
  }
}
