public class IsPalindrome{
  public static void main(String[] args) {
    int number = 101;
    int duplicate = number;
    int reverseNumber = 0;
    while(number>0){
      int lastDigit = number % 10;
      reverseNumber = reverseNumber*10 + lastDigit;
      number = number/10;
    }
    if(reverseNumber==duplicate)System.out.println("True");
    else System.out.println("False");
  }
}