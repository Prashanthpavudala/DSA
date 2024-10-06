import java.util.*;

public class Practise {
 public static void main(String[] args) {
  int arr[] = {2, 3, 2, 3, 5, 0};
  //Counting frequencies of array elements
  countFrequency(arr);
  //Find the highest/lowest frequency element
  System.out.println(Arrays.toString(getMinMaxFrequency(arr)));
 } 

 public static void countFrequency(int arr[]) {
  Map<Integer, Integer> map = new HashMap<>();
  for (int num : arr) {
    map.put(num, map.getOrDefault(num, 0)+1);
  }
  System.out.println(map);
 }

 public static int[] getMinMaxFrequency(int arr[]) {
  Map<Integer, Integer> map = new HashMap<>();
  for(int num : arr){
    map.put(num, map.getOrDefault(num, 0)+1);
  }

  int minEle = 0, maxEle = 0;
  int minFreq = arr.length, maxFreq = 0;

  for(Map.Entry<Integer, Integer> entry  : map.entrySet()){
    int element = entry.getKey();
    int count = entry.getValue();
    if(count > maxFreq){
      maxFreq = count;
      maxEle = element;
    }
    if(count < minFreq){
      minFreq = count;
      minEle = element;
    }
  }
  return new int[]{maxEle, minEle};
 }
}
