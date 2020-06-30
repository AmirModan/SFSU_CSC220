/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 * 1. Implement interfaces: FractionInterface and Comparable (i.e. compareTo())
 * 2. Implement methods equals() and toString() from class Object
 * 3. Must work for both positive and negative fractions
 * 4. Must not invoke reduce()/moveMinusSign() fractions unless it is specified in interface 
 * 5. Must throw FractionException objects in case of errors, 
 *    do not throw other exception objects
 * 6. Must not add new or modify existing data fields
 * 7. Must not add new public methods
 * 8. May add private methods
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive method GCD() which finds the greatest common denominator of
 *    two positive integers is given (see code)
 *       
 * 2. You need to downcast reference parameter FractionInterface to Fraction if  
 *    you want to use it as Fraction. See add, subtract, multiply and divide methods
 *
 * 3. Use "this" to access this object if it is needed
 *
 ************************************************************************************/

package PJ1;

public class Fraction implements FractionInterface, Comparable<Fraction>
{
	// integer numerator and denominator
	private	int num;	
	private	int den;	

	public Fraction()
	{
		// implement this method!
		// set fraction to default = 0/1
		this.num = 0;
		this.den = 1;
	}	// end default constructor

	public Fraction(int num, int den)
	{
		// implement this method!
		this.num = num;
		if(den == 0) {
			throw new FractionException("Denominator is 0");
		}
		this.den = den;
                // return FractionException if initialDenominator is 0
	}	// end constructor

	public void setFraction(int num, int den)
	{
		// implement this method!
		this.num = num;
		if(den == 0) {
			throw new FractionException();
		}
		this.den = den;
		// return FractionException if initialDenominator is 0
	}	// end setFraction


        public FractionInterface reduce()
  	{
                // implement this method!
                //
                // Outline:
                // compute GCD of num & den
                // GCD works for + numbers.
                // So, you should eliminate - sign
                // then reduce numbers : num/GCD and den/GCD
                // return this fraction object
        	int gcd = GCD(this.num, this.den);
        	this.num /= gcd;
        	this.den /= gcd;
		return this;
	}

        public FractionInterface moveMinusSign()
	{
                // implement this method!
                // Adjusts the signs of the num and den so that 
                // the num's sign is the sign of the fraction 
                // and the den's sign is +. 
                // return this fraction object
        	if(this.den < 0) {
        		this.den *= -1;
        		this.num *= -1;
        	}
		return this;
	}

	public double toDouble()
	{
		// implement this method!
		// return double floating point value
		return (double)this.num/this.den;
	}	// end toDouble 

	public FractionInterface add(FractionInterface secondFraction)
	{
		// implement this method!
		// a/b + c/d is (ad + cb)/(bd)
		int num = (this.num*((Fraction)secondFraction).den) + (this.den*((Fraction)secondFraction).num);
		int den = this.den* ((Fraction)secondFraction).den;
		Fraction sum = new Fraction(num, den);
		return sum;
	}	// end add

	public FractionInterface subtract(FractionInterface secondFraction)
	{
		// implement this method!
		// a/b - c/d is (ad - cb)/(bd)
		int num = (this.num*((Fraction)secondFraction).den) - (this.den*((Fraction)secondFraction).num);
		int den = this.den* ((Fraction)secondFraction).den;
		Fraction difference = new Fraction(num, den);
		return difference;
	}	// end subtract

	public FractionInterface multiply(FractionInterface secondFraction)
	{
		// implement this method!
		// a/b * c/d is (ac)/(bd)
		int num = this.num*((Fraction)secondFraction).num;
		int den = this.den* ((Fraction)secondFraction).den;
		Fraction product = new Fraction(num, den);
		return product;
	}	// end multiply

	public FractionInterface divide(FractionInterface secondFraction)
	{
		// implement this method!
		// return FractionException if secondFraction is 0
		// a/b / c/d is (ad)/(bc)
		if(((Fraction)secondFraction).num == 0) {
			throw new FractionException("Divisor is 0");
		}
		int num = this.num*((Fraction)secondFraction).den;
		int den = this.den* ((Fraction)secondFraction).num;
		Fraction quotient = new Fraction(num, den);
		return quotient;
	}	// end divide

	
	public boolean equals(Object other)
	{
		// implement this method!
		Fraction f1 = new Fraction(this.num, this.den);
		Fraction f2 = new Fraction(((Fraction)other).num, ((Fraction)other).den);
		return f1.reduce().moveMinusSign().toString().equals(f2.reduce().moveMinusSign().toString());
	} // end equals


	public int compareTo(Fraction other)
	{
		// implement this method!
		Fraction f1 = new Fraction(this.num, this.den);
		Fraction f2 = new Fraction(((Fraction)other).num, ((Fraction)other).den);
		return f1.reduce().moveMinusSign().toString().compareTo(f2.reduce().moveMinusSign().toString());
	} // end compareTo

	
	public String toString()
	{
		return num + "/" + den;
	} // end toString



        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------

  	/** Task: Computes the greatest common divisor of two integers.
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private int GCD(int integerOne, int integerTwo)
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = GCD(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end GCD

        // YOU CAN ADD MORE PRIVATE METHODS HERE.....

        //-----------------------------------------------------------------
        //  Below are my tests
        //-----------------------------------------------------------------
	public static void main(String[] args)
	{
		FractionInterface firstOperand = null;
		FractionInterface secondOperand = null;
		FractionInterface result = null;
                double doubleResult = 0.0;

		Fraction nineSixteenths = new Fraction(9, 16);  // 9/16
		Fraction oneFourth = new Fraction(1, 4);        // 1/4

		System.out.println("\n=========================================\n");
		firstOperand = new Fraction(20, -35);
		System.out.println("1. The fraction is \t\t" + firstOperand);
		System.out.println("\tExpected result :\t20/-35\n");

		System.out.print("2. Reduced fraction is \t\t" + firstOperand );
		FractionInterface tmp = firstOperand.reduce();
		System.out.println(" " + tmp);
		System.out.println("\tExpected result :\t20/-35 4/-7\n");

		System.out.print("3. Move minus sign fraction is \t" + firstOperand);
		firstOperand = firstOperand.moveMinusSign();
		System.out.println(" " + firstOperand);
		System.out.println("\tExpected result :\t4/-7 -4/7\n");


		firstOperand = new Fraction(-51, -36);
		System.out.print("4. Move minus sign fraction is \t" + firstOperand);
		tmp = firstOperand.moveMinusSign();
		System.out.println(" " + tmp);
		System.out.println("\tExpected result :\t-51/-36 51/36\n");

		System.out.print("5. Reduced fraction is \t\t" + firstOperand );
		firstOperand = tmp.reduce();
		System.out.println(" " + firstOperand);
		System.out.println("\tExpected result :\t51/36 17/12\n");


		firstOperand = new Fraction(250, -35);
		System.out.print("6. Simplify fraction is \t" + firstOperand );
		tmp = firstOperand.reduce().moveMinusSign();
		System.out.println(" " + tmp);
		System.out.println("\tExpected result :\t250/-35 -50/7\n");

		System.out.println("\n=========================================\n");
		System.out.println("Test cases 7 to 11, expected result and simplified result are printed\n");
		// 7/8 + 9/16
		firstOperand = new Fraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.print("7. The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);
		System.out.println(" "+ result.reduce().moveMinusSign());
		System.out.println("\tExpected result :\t\t184/128 23/16\n");

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new Fraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.print("8. The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println(" "+ result.reduce().moveMinusSign());
		System.out.println("\tExpected result :\t\t-40/128 -5/16\n");


		// 15/-2 * 1/4
		firstOperand = new Fraction(15, -2); 
		result = firstOperand.multiply(oneFourth);
		System.out.print("9. The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);
		System.out.println(" "+ result.reduce().moveMinusSign());
		System.out.println("\tExpected result :\t\t15/-8 -15/8\n");

		// (-21/2) / (3/7)
		firstOperand = new Fraction(-21, 2); 
		secondOperand= new Fraction(3, 7); 
		result = firstOperand.divide(secondOperand);
		System.out.print("10. The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println(" "+ result.reduce().moveMinusSign());
		System.out.println("\tExpected result :\t\t-147/6 -49/2\n");

		// -21/2 + 7/8
		firstOperand = new Fraction(-21, 2); 
		secondOperand= new Fraction(7, 8); 
		result = firstOperand.add(secondOperand);
		System.out.print("11. The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println(" "+ result.reduce().moveMinusSign());
		System.out.println("\tExpected result :\t\t-154/16 -77/8\n");


		System.out.println("\n=========================================\n");
                // 0/10, 5/(-15), (-22)/7
		firstOperand = new Fraction(0, 10); 
                doubleResult = firstOperand.toDouble();
		System.out.println("12. The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t0.0\n");
		firstOperand = new Fraction(1, -3); 
                doubleResult = firstOperand.toDouble();
		System.out.println("13. The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-0.333333333...\n");
		firstOperand = new Fraction(-21, 2); 
		System.out.println("First = " + firstOperand);
		// equality check
		System.out.println("14. check First equals First: ");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand = new Fraction(42, -4); 
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("15. check First equals Second: ");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		Fraction first  = (Fraction)firstOperand;
		Fraction second = (Fraction)secondOperand;
		
		System.out.println("\n16. check First compareTo Second: ");
		if (first.compareTo(second) == 0)
			System.out.println("Fractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second = new Fraction(7, 8);
		System.out.println("\nSecond = " + second);
		System.out.println("17. check First compareTo Second: ");
		if (first.compareTo(second) < 0)
			System.out.println("Fractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("\n18. check Second compareTo First: ");
		if (second.compareTo(first) > 0)
			System.out.println("Fractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println("\n=========================================");

		System.out.println("\n19. check FractionException: 1/0");
		try {
			Fraction a1 = new Fraction(1, 0);		    
		        System.out.println("Error! No FractionException");
		}
		catch ( FractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : FractionException!\n");

		System.out.println("\n20. check FractionException: division");
		try {
			Fraction a2 = new Fraction();		    
			Fraction a3 = new Fraction(1, 2);		    
			a3.divide(a2);
		        System.out.println("Error! No FractionException");
		}
		catch ( FractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : FractionException!\n");


	}	// end main
} // end Fraction

