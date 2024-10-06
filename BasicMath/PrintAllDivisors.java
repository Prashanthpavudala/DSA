import java.util.*;

public class PrintAllDivisors {
  public static void main(String[] args) {
    int number = 36;
    List<Integer> divisors = new ArrayList<>();
    // for(int i=1; i<=number; i++){
    //   if(number%i == 0)
    //     divisors.add(i);
    // }

    // reducing time complexity by iterating till square root only
    for(int i=1; i*i<=number; i++){
      if(number%i == 0){
        divisors.add(i);
        if(i != number/i) divisors.add(number/i);
      } 
    }
    Collections.sort(divisors);
    System.out.println(divisors);
  }
}
