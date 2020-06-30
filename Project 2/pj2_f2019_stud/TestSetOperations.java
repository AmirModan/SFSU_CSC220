/**
 *  	Test Set operations... Do not modify this file!
 */

import PJ2.*;

public class TestSetOperations 
{
	public static void main(String[] args) 
	{
		SetInterface<String> set1 = new SimpleSet<>();
		SetInterface<String> set2 = new SimpleSet<>();
		SetInterface<String> set3 = new SimpleSet<>();
		SetInterface<String> set4 = new SimpleSet<>();
		SetInterface<String> set5 = new SimpleSet<>();

		System.out.println("==================================");
		System.out.println("Test simple methods:\n");
		System.out.println("1. Set1 is "+ set1);
		System.out.println("2. Set1 is empty? "+ set1.isEmpty());
		System.out.println("3. Set1 size : "+ set1.size());
		System.out.println("4. Set1 removes any : "+ set1.remove());

		set1.add("B"); set1.add("X"); set1.add("C"); set1.add("Z"); set1.add("E"); 
		set1.add("H"); set1.add("J"); set1.add("K"); set1.add("L"); set1.add("E"); 
		System.out.println("5. Set1 add A, returns : "+ set1.add("A"));
		System.out.println("6. Set1 add A, returns : "+ set1.add("A"));
		System.out.println("7. Set1 is "+ set1);
		System.out.println("8. Set1 is empty? "+ set1.isEmpty());
		System.out.println("9. Set1 size : "+ set1.size());

		System.out.println("10. Set1 remove any : "+ set1.remove());
		System.out.println("11. Set1 remove E, returns : "+ set1.remove("E"));
		System.out.println("12. Set1 remove E, returns : "+ set1.remove("E"));
		System.out.println("13. Set1 is "+ set1);
		System.out.println("14. Set1 size : "+ set1.size());

		System.out.println("15. Set1 contains X: " + set1.contains("X"));
		System.out.println("16. Set1 contains W: " + set1.contains("W"));
		System.out.println("17. Set1 clear: ");

		set1.clear();
		System.out.println("18. Set1 is "+ set1);
		System.out.println("19. Set1 is empty? "+ set1.isEmpty());
		System.out.println("20. Set1 size : "+ set1.size());
		System.out.println("21. Set1 removes any : "+ set1.remove());

		System.out.println("==================================");
		System.out.println("Test union:\n");
		set1.add("B"); set1.add("X"); set1.add("C"); set1.add("Z"); set1.add("E"); 
		set1.add("H"); set1.add("J"); set1.add("K"); set1.add("L"); set1.add("A"); 

		set2.add("A"); set2.add("B"); set2.add("B"); set2.add("A"); set2.add("C"); 
		set2.add("C"); set2.add("D"); set2.add("Z"); set2.add("H"); set2.add("V"); 

		System.out.println("Set1 is "+ set1);
		System.out.println("Set2 is "+ set2);
		System.out.println("Set5 is "+ set5);
		System.out.println("");
		set3 = set1.union(set2);
		set4 = set2.union(set1);
		System.out.println("22. Set1 union Set2 : " + set3 );
		System.out.println("23. Set2 union Set1 : " + set4);
		System.out.println("24. Set2 union Set5 : " + set2.union(set5));
		System.out.println("25. Set5 union Set2 : " + set5.union(set2));

		System.out.println("==================================");
		System.out.println("Test subset:\n");
		System.out.println("Set1 is "+ set1);
		System.out.println("Set2 is "+ set2);
		System.out.println("Set3 is "+ set3);
		System.out.println("Set4 is "+ set4);
		System.out.println("Set5 is "+ set5);
		System.out.println("");

		System.out.println("26. Set1 subset of Set3:"+ set1.subset(set3));
		System.out.println("27. Set2 subset of Set4:"+ set2.subset(set4));
		System.out.println("28. Set3 subset of Set1:"+ set3.subset(set1));
		System.out.println("29. Set3 subset of Set2:"+ set4.subset(set2));
		System.out.println("30. Set3 subset of Set4:"+ set3.subset(set4));
		System.out.println("31. Set4 subset of Set3:"+ set4.subset(set3));
		System.out.println("32. Set5 subset of Set1:"+ set5.subset(set1));

		set5.add("888");
		System.out.println("==================================");
		System.out.println("Test intersect:\n");
		System.out.println("Set1 is "+ set1);
		System.out.println("Set2 is "+ set2);
		System.out.println("Set3 is "+ set3);
		System.out.println("Set4 is "+ set4);
		System.out.println("Set5 is "+ set5);
		System.out.println("");

		System.out.println("33. Set2 intersect Set1 :"+ set2.intersection(set1));
		System.out.println("34. Set1 intersect Set2 :"+ set1.intersection(set2));
		System.out.println("35. Set3 intersect Set4 :"+ set3.intersection(set4));
		System.out.println("36. Set4 intersect Set3 :"+ set4.intersection(set3));
		System.out.println("37. Set5 intersect Set3 :"+ set5.intersection(set3));
		System.out.println("==================================");
		set5.clear();
		System.out.println("Test difference:\n");
		System.out.println("Set1 is "+ set1);
		System.out.println("Set2 is "+ set2);
		System.out.println("Set3 is "+ set3);
		System.out.println("Set4 is "+ set4);
		System.out.println("Set5 is "+ set5);
		System.out.println("");

		System.out.println("38. Set2 difference Set1 :"+ set2.difference(set1));
		System.out.println("39. Set1 difference Set2 :"+ set1.difference(set2));
		System.out.println("40. Set3 difference Set4 :"+ set3.difference(set4));
		System.out.println("41. Set4 difference Set3 :"+ set4.difference(set3));
		System.out.println("42. Set5 difference Set3 :"+ set5.difference(set3));
		System.out.println("43. Set3 difference Set5 :"+ set3.difference(set5));

		System.out.println("==================================");

	} // end main


} // end Test Program 

