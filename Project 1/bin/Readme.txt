CSC220 Programming Project#1
============================
 
Due Date: 11:55pm, Sunday, 10/13, upload textfile Fraction.java to ilearn

- You need to implement Fraction class which is within package PJ1
  See PJ1/Fraction.java and PJ1/FractionInterface.java for specifications

- Compile programs (you are in directory containing Readme file):
	
  javac PJ1/*.java
  javac PJ1_Test.java

- Run programs (you are in directory containing Readme file):

  // Run tests in Fraction class
  java PJ1.Fraction	

  // Run general test program
  java PJ1_Test		

- For using IDE Eclipse to create CSC220 projects, you may look at 
  this video for more info. 
  
  https://www.youtube.com/watch?v=vPLVR7FzLy8
  
	
***************************************************************
***************************************************************
  
Important: please look at "Cheating and Plagiarism Policy"
           http://cs.sfsu.edu/cheating-and-plagiarism-policy
  
Warning: Don't copy projects from previous semestsres and others!
  

***************************************************************
***************************************************************

Sample Runs
===========

=> java PJ1.Fraction

=========================================

1. The fraction is 		20/-35
	Expected result :	20/-35

2. Reduced fraction is 		20/-35 4/-7
	Expected result :	20/-35 4/-7

3. Move minus sign fraction is 	4/-7 -4/7
	Expected result :	4/-7 -4/7

4. Move minus sign fraction is 	-51/-36 51/36
	Expected result :	-51/-36 51/36

5. Reduced fraction is 		51/36 17/12
	Expected result :	51/36 17/12

6. Simplify fraction is 	250/-35 -50/7
	Expected result :	250/-35 -50/7


=========================================

Test cases 7 to 11, expected result and simplified result are printed

7. The sum of 7/8 and 9/16 is 		184/128 23/16
	Expected result :		184/128 23/16

8. The difference of 9/16 and 7/8 is 	-40/128 -5/16
	Expected result :		-40/128 -5/16

9. The product of 15/-2 and 1/4 is 	15/-8 -15/8
	Expected result :		15/-8 -15/8

10. The quotient of -21/2 and 3/7 is 	-147/6 -49/2
	Expected result :		-147/6 -49/2

11. The sum of -21/2 and 7/8 is 	-154/16 -77/8
	Expected result :		-154/16 -77/8


=========================================

12. The double floating point value of 0/10 is 	0.0
	Expected result 			0.0

13. The double floating point value of 1/-3 is 	-0.3333333333333333
	Expected result 			-0.333333333...

First = -21/2
14. check First equals First: 
Identity of fractions OK

Second = 42/-4
15. check First equals Second: 
Equality of fractions OK

16. check First compareTo Second: 
Fractions == operator OK

Second = 7/8
17. check First compareTo Second: 
Fractions < operator OK

18. check Second compareTo First: 
Fractions > operator OK

=========================================

19. check FractionException: 1/0
Exception: PJ1.FractionException: Denominator is 0
Expected result : FractionException!


20. check FractionException: division
Exception: PJ1.FractionException: Divisor is 0
Expected result : FractionException!


***************************************************************
***************************************************************

=> java PJ1_Test

==============================================

Operations:
  0) exit
  1) add        2) subtract     3) multiply     4) divide       5) compareTo
  6) equals     7) moveMinusSign 8) reduce      9) toDouble     10) setFraction

Enter an operation number: 10

Tests:

read a fraction x/y, please enter x y : -20 -10
        -20/-10 setFraction = -20/-10
==============================================

Operations:
  0) exit
  1) add        2) subtract     3) multiply     4) divide       5) compareTo
  6) equals     7) moveMinusSign 8) reduce      9) toDouble     10) setFraction

Enter an operation number: 3

Try to read a fraction x/y, please enter x y : 5 -10
                Read OK:5/-10

Try to read a fraction x/y, please enter x y : -1 -2
                Read OK:-1/-2

Tests:

        5/-10 * 5/-10 = 25/100
        -1/-2 * -1/-2 = 1/4
        5/-10 * -1/-2 = -5/20
        -1/-2 * 5/-10 = -5/20
==============================================

Operations:
  0) exit
  1) add        2) subtract     3) multiply     4) divide       5) compareTo
  6) equals     7) moveMinusSign 8) reduce      9) toDouble     10) setFraction

Enter an operation number: 7

Try to read a fraction x/y, please enter x y : -10 -20
                Read OK:-10/-20

Tests:

        -10/-20 convert= 10/20
==============================================

Operations:
  0) exit
  1) add        2) subtract     3) multiply     4) divide       5) compareTo
  6) equals     7) moveMinusSign 8) reduce      9) toDouble     10) setFraction

Enter an operation number: 1

Try to read a fraction x/y, please enter x y : -5 -10
                Read OK:-5/-10

Try to read a fraction x/y, please enter x y : 7 -3
                Read OK:7/-3

Tests:

        -5/-10 + -5/-10 = 100/100
        7/-3 + 7/-3 = -42/9
        -5/-10 + 7/-3 = -55/30
        7/-3 + -5/-10 = -55/30
==============================================

Operations:
  0) exit
  1) add        2) subtract     3) multiply     4) divide       5) compareTo
  6) equals     7) moveMinusSign 8) reduce      9) toDouble     10) setFraction

Enter an operation number: 0
=>

