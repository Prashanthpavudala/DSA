package Arrays.Easy;

public class IsArraySorted {
  
  public static boolean checkIfArraySorted(int[] arr, int n){
    for(int i=1; i<n; i++){
      if(arr[i] >= arr[i-1]){

      }else{
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] arr = {1,3,5,6};
    int n = arr.length;
    System.out.println(checkIfArraySorted(arr, n));
  }
}
