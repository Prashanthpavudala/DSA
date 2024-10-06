package Sorting;

import java.util.Arrays;

public class SortAlgo {

  public static void swap(int arr[], int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /*
    * bubble sort is a simple comparison-based sorting algorithm.
    * finding the maximum and pushing it to last index by adjacent comparision swaps
    * Time Complexity: 
    * Best Case: O(n) when the array is already sorted
    * Worst and Average Case: O(n²) when the array is not sorted   
    * Space Complexity: O(1)
  */
  public static void bubbleSort(int arr[], int n){
    for(int i=0; i<n-1; i++){
      int flag = 0;
      for(int j=0; j<n-1-i; j++){
        if(arr[j] > arr[j+1]){
          swap(arr, j, j+1);
          flag=1;
        }
      }
      if(flag==0)break;
    }
  }

  /*
    * insertion sort is also a comparison-based sorting algorithm.
    * sorted array one element at a time by inserting each new element 
    * into its correct position relative to those that have already been sorted.
    * Time Complexity: 
    * Best Case: O(n) when the array is already sorted
    * Worst and Average Case: O(n²) when the array is not sorted   
    * Space Complexity: O(1)
  */
  public static void insertionSort(int arr[], int n){
    for(int i=1; i<n; i++){
      int j = i-1;
      int x = arr[i];
      while(j > -1 && arr[j] > x){
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = x;
    }
  }

  /*
    * selection sort is a simple comparison-based sorting algorithm.
    * finding the minimum element by comparision and swaping
    * i.e,(It sorts an array by repeatedly finding the 
    * minimum element from the unsorted part and moving it to the beginning)
    * Time Complexity: Best, Average, and Worst Case: O(n²)
    * Space Complexity: O(1)
  */
  public static void selectionSort(int arr[], int n){
    int i,j,k;
    for(i=0; i<n-1; i++){
      for(j=k=i; j<n; j++){
        if(arr[j] < arr[k]){
          k=j;
        }
      }
      swap(arr, i, k);
    }
  }

  
  public static int partioning(int arr[], int l , int h){
    int pivot = arr[l];
    int i=l, j=h;
    do{
      do{i++;}while(i < h && arr[i] <= pivot);
      do{j--;}while(j > l && arr[j] > pivot);
      if(i < j){
        swap(arr, i, j);
      }
    }while(i<j);
    // swapping pivot into its correct position
    swap(arr, l, j);
    return j;
  }

  public static void quickSort(int arr[], int l, int h){
    int j;
    if(l<h){
      j = partioning(arr, l, h);
      quickSort(arr, l, j);
      quickSort(arr, j+1, h);
    }
  }

  public static void merge(int[] a, int[] b, int m, int n){
    int[] c = new int[m+n];
    int i=0,j=0,k=0;
    while(i<m && j<n){
      if(a[i]<b[j]) c[k++] = a[i++];
      else c[k++] = b[j++];
    }
    for(;i<m;i++) c[k++] = a[i++];
    for(;j<n;j++) c[k++] = b[j++];
    System.out.println(Arrays.toString(c));
  }

  public static void merge(int[] a, int l, int mid, int h){
    int i=l, j=mid+1, k=l;
    int[] b = new int[h];
    while(i<=mid && j<=h){
      if(a[i] < a[j]) b[k++] = a[i++];
      else b[k++] = a[j++];
    }
    for(;i<mid;i++) b[k++]=a[i];
    for(;j<h;j++) b[k++]=a[j];
    for(i=l;i<h;i++) a[i]=b[i];
  }

  public static void iterativeMergeSort(int[] arr, int n){
    int p, l, h, mid, i;

    // p is the size of subarrays to be merged; starts with 2 and doubles each iteration
    for (p = 2; p <= n; p = p * 2) {
        for (i = 0; i + p - 1 < n; i += p) {
            l = i;
            h = i + p - 1;
            mid = (l + h) / 2;
            merge(arr, l, mid, h);
        }

        // Handle the remaining subarray if the size is not exactly a multiple of p
        if (n - i > p / 2) {
            l = i;
            h = i + p - 1;
            mid = (l + h) / 2;
            merge(arr, l, mid, n - 1);
        }
    }

    // If the last merge pass has not merged the entire array, merge the remaining part
    if (p / 2 < n) {
        merge(arr, 0, p / 2 - 1, n - 1);
    }
  }

  public static void main(String[] args) {
    int arr[] = {8,1,5,7,3,2};
    int n = arr.length;
    // bubbleSort(arr, n);
    // insertionSort(arr, n);
    // selectionSort(arr, n);
    // quickSort(arr, 0, n);

    // int[] a = {1,3,5,7};
    // int[] b = {2,4,6,8};
    // merge(a, b, a.length, b.length);

    iterativeMergeSort(arr, n);

    System.out.println(Arrays.toString(arr));
  }
  
}
