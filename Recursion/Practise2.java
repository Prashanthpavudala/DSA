package Recursion;

import java.util.Arrays;

public class Practise2 {
  public static void main(String[] args) {
    //reverse array using functional recursion
    // int arr[] = {10,11,1,2,3,4};
    // reverseArray(0, arr, arr.length);

    //checking a string is palidrome
    // String name = "madam";
    // System.out.println(isPalindrome(0, name, name.length()));

    //getting fibonacci number
    System.out.println(fibonacciNumber(5));
  }

  public static void reverseArray(int i, int arr[], int n){
    if(i>=n/2){
      System.out.println(Arrays.toString(arr));
      return;
    }
    int temp = arr[i];
    arr[i] = arr[n-i-1];
    arr[n-i-1] = temp;
    reverseArray(i+1, arr, n);
  }

  public static boolean isPalindrome(int i, String name, int n){
    if(i>=n/2)return true;

    if(name.charAt(i) != name.charAt(n-i-1))return false;
    
    return isPalindrome(i+1, name, n);
  }

  public static int fibonacciNumber(int n){
    if(n<=1) return n;
    return fibonacciNumber(n-1) + fibonacciNumber(n-2);
  }
}
