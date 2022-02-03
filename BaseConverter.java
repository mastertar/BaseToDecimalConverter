import java.lang.Math;
import java.util.Scanner;
public class BaseConvertor 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
        System.out.println("What is the base for your number?");
        int base = input.nextInt();
        System.out.println("What is your number?");
        int number = input.nextInt();
        while(number != -1)
        {
            convert(base, number);
            System.out.println("What is the base for your number?");
            base = input.nextInt();
            System.out.println("What is your number? (-1 to quit)");
            number = input.nextInt();
        }
	}

    public static void convert(int base, int number)
    {
        if(base < 2)
        {
            System.out.println("Please enter a valid base!");
            return;
        }
        int temp = number;
        int sum = 0;
        int counter = 0;
        while((double) temp/10.0 != 0)
        {
            if(!(temp % 10 < base) || temp < 0)
            {
                System.out.println("Please enter a valid number!");
                return;
            }
            sum += ((temp % 10) * (Math.pow(base, counter)));
            // temp -= (temp%10);
            // temp /= 10;
            temp = (temp - (temp%10)) / 10;
            counter++;
        }
        System.out.println(number + " base " + base + " is " + sum);
    }
}
