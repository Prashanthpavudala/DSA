package Recursion;

public class Practise1 {
  public static void main(String[] args) {
    //print name N times
    // printName(0,5);

    //print 1 to N
    //printNumbers(1, 4);

    //print N to 1
    //printNumbersReverse(6);

    //print sum of N numbers using parameterized recursion
    //sumUsingParameterized(10, 0);

    //print sum of N numbers using functional recursion
    //System.out.println(sumUsingFunctional(5));

    //print factorial of a number
    System.out.println(factorial(6));
  }

  public static void printName(int i, int N){
    if(i>=N)return;
    System.out.println("Prashanth");
    printName(i+1, N);   
  }

  public static void printNumbers(int i, int N){
    if(i>N)return;
    System.out.println(i);
    printNumbers(i+1, N);
  }

  public static void printNumbersReverse(int N){
    if(N<=0)return;
    System.out.println(N);
    printNumbersReverse(N-1);
  }

  public static void sumUsingParameterized(int i , int sum){
    if(i<1){
      System.out.println(sum);
      return;
    }
    sumUsingParameterized(i-1, sum+i);
  }

  public static int sumUsingFunctional(int N) {
    if(N==0)return 0;
    return N + sumUsingFunctional(N-1);
  }

  public static int factorial(int N){
    if(N<=1)return 1;
    return N * factorial(N-1);
  }

}