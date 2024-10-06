public class IsArmstrongNumber {
  public static void main(String[] args) {
    int number = 371;  
    int duplicate = number;
    int processedNumber = 0;
    int numberOfDigits = String.valueOf(number).length();
    while(number>0){
      int lastDigit = number % 10;
      processedNumber = processedNumber + (int)Math.pow(lastDigit, numberOfDigits);
      number = number/10;
    }
    if(duplicate==processedNumber)System.out.println("True");
    else System.out.println("False");
  }
}
