import java.lang.Math;
import java.util.Scanner;
public class BaseConverter 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		boolean firstRun = true;
		while(true)
		{
    		System.out.println("Please choose an option:\n1 - From any base to base 10\n2 - From base 10 to any base\n(-1 to quit)");
    		if(firstRun == false)
    		{
    		input.nextLine();
    		}
    		firstRun = false;
    		String option = input.nextLine();
    		
    		if(option.indexOf("1") == 0)
    		{
                System.out.println("Option 1 has been chosen.\n\nWhat is the base for your number?");
                int base = input.nextInt();
                System.out.println("What is your number?");
                int number = input.nextInt();
                while(number != -1)
                {
                    convertTo10(base, number);
                    System.out.println("What is the base for your number?");
                    base = input.nextInt();
                    System.out.println("What is your number? (-1 to quit)");
                    number = input.nextInt();
                }
    		}
    		else if(option.indexOf("2") == 0)
    		{
    		    System.out.println("Option 2 has been chosen.\n\nWhat is the base you want your number to be in?");
                int base = input.nextInt();
                System.out.println("What is your number?");
                int number = input.nextInt();
                while(number != -1)
                {
                    convertFrom10(base, number);
                    System.out.println("What is the base you want your number to be in?");
                    base = input.nextInt();
                    System.out.println("What is your number? (-1 to quit)");
                    number = input.nextInt();
                }
    		}
    		else if(option.indexOf("-1") == 0)
    		{
    		    System.out.println("Exiting Program.");
    		    break;
    		}
    		else
    		{
    		    System.out.println("Please select a valid option!");
    		}
		}
	}

    public static void convertTo10(int base, int number)
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
            temp = (temp - (temp%10)) / 10;
            counter++;
        }
        System.out.println(number + " base " + base + " is " + sum);
    }
    public static void convertFrom10(int base, int number)
    {
        if(number < 0)
        {
            System.out.println("Please enter a valid number!");
            return;
        }
        int temp = number;
        String finalNum = "";
        while(temp != 0)
        {
            finalNum += temp % base;
            temp = (temp - (temp % base))/base;
        }
        String tempString = finalNum;
        finalNum = "";
        for(int i = tempString.length()-1; i>-1; i--)
        {
            finalNum += tempString.substring(i, i+1);
        }
        System.out.println(number + " is " + finalNum + " base " + base);
    }
}
