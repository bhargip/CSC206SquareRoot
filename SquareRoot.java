//CSc206 - Final Question 3
//Numerical Methods - Square Root using power series
//Bhargi Patel

/*	Using Taylor series
*	sqrt(x) = 1 + 1/2(x-1) - 1/4(x-1)^2/2! + 3/8(x-1)^3/3! - 15/16(x-1)^4/4! + ..
*/

public class SquareRoot
{
	//length of Taylor Series
	static int length = 0;
	//Square Root of number
	static double sqrt;
	//Value number to find square root	
	static double x;	
	
	public static void calculateSqrt(double num)
	{
		int divCount = 0;
		int multCount = 0;
		//Taylor series term
		double term = 1;		
		double temp;
		//Flag to stop the series
		int flag = 0;
		
		long fact = 1;
		int no = 1;

		double tempSqrt = term;
		double smallestTerm = 0.0;
		double absoluteTerm;

		
		if(num >= 0.4)
		{	/*	if num greater than or equal to 0.4		
			*	then divide it by 4 to get number closer to 1
			*/
			while(num > 1.6)
			{
				num /= 4;
				multCount++;
			}
		}
		else
		{
			while(num<0.4)
			{
				num *= 4;
				divCount++;
			}
		}
		
		x = num;
		//logic to find square root
		while(flag != 1)
		{
			temp = term;
			fact *= no;
			term = (-temp)*(num - 1.0)*(2*no-3.0)/2.0;
			tempSqrt += (term/fact);
			absoluteTerm = (term/fact) < 0 ? -term/fact : term/fact;
			if(absoluteTerm < .0000001)
			{
				flag = 1;
				length = no;
				sqrt = tempSqrt;
			}
			no++;
		}
		
		for(int i = 1; i <= multCount; i++)
			sqrt *= 2;
		for(int i = 1; i <= divCount; i++)
			sqrt /= 2;
	}
	
	public static void main(String []args)
	{
		double number = 1.0;
		while(true)
		{
			System.out.print("Enter a number (0 to exit):");
			number = Double.parseDouble(System.console().readLine());
			if(number == 0)
				break;
			calculateSqrt(number);
			System.out.println("x = " + x + "	n = " + length);
			System.out.println("mysqrt(" +number+") : "+sqrt+"\tLibrary sqrt("+number+") : "+Math.sqrt(number));
		}
	}
}