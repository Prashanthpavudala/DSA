public class IsPrimeNumber {
  public static void main(String[] args) {
    int number = 11;
    int count = 0;
    for(int i=1; i*i<=number; i++){
      if(number%i == 0){
        count++;
        if(number/i != i)count++;
      }
    }
    if(count == 2)System.out.println("True");
    else System.out.println("False");
  }
}
