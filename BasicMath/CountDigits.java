public class CountDigits {
  public static void main(String[] args){
    
    int number = 7708;
    int count = 0;
    //approach 1 using extraction
    while(number > 0){
      count++;
      number = number/10;
    }

    //approach 2 using logarithmic
    // count = (int)Math.log10(number)+1;

    //approach 3 using by string
    // count = String.valueOf(number).length();

    System.out.println("count is "+ count);
    
  }
}
