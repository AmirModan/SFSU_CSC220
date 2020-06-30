CSC220 Programming Project#2
============================
 
Due Date: 11:55pm, Sunday, 11/3/2019, upload textfile SimpleSet.java to ilearn

- You need to implement SimpleSet class which is within package PJ2
  See PJ2/SimpleSet.java and PJ2/SetInterface.java for specifications

- Compile/run programs (you are in directory containing Readme file):
	
  javac PJ2/*.java
  javac TestSetOperations.java

  // Run test program
  java TestSetOperations 

- output of test program

=> java TestSetOperations
==================================
Test simple methods:

1. Set1 is {}
2. Set1 is empty? true
3. Set1 size : 0
4. Set1 removes any : null
5. Set1 add A, returns : true
6. Set1 add A, returns : false
7. Set1 is {A, L, K, J, H, E, Z, C, X, B}
8. Set1 is empty? false
9. Set1 size : 10
10. Set1 remove any : A
11. Set1 remove E, returns : true
12. Set1 remove E, returns : false
13. Set1 is {K, J, H, L, Z, C, X, B}
14. Set1 size : 8
15. Set1 contains X: true
16. Set1 contains W: false
17. Set1 clear:
18. Set1 is {}
19. Set1 is empty? true
20. Set1 size : 0
21. Set1 removes any : null
==================================
Test union:

Set1 is {A, L, K, J, H, E, Z, C, X, B}
Set2 is {V, H, Z, D, C, B, A}
Set5 is {}

22. Set1 union Set2 : {D, V, B, X, C, Z, E, H, J, K, L, A}
23. Set2 union Set1 : {X, E, J, K, L, A, B, C, D, Z, H, V}
24. Set2 union Set5 : {A, B, C, D, Z, H, V}
25. Set5 union Set2 : {A, B, C, D, Z, H, V}
==================================
Test subset:

Set1 is {A, L, K, J, H, E, Z, C, X, B}
Set2 is {V, H, Z, D, C, B, A}
Set3 is {D, V, B, X, C, Z, E, H, J, K, L, A}
Set4 is {X, E, J, K, L, A, B, C, D, Z, H, V}
Set5 is {}

26. Set1 subset of Set3:true
27. Set2 subset of Set4:true
28. Set3 subset of Set1:false
29. Set3 subset of Set2:false
30. Set3 subset of Set4:true
31. Set4 subset of Set3:true
32. Set5 subset of Set1:true
==================================
Test intersect:

Set1 is {A, L, K, J, H, E, Z, C, X, B}
Set2 is {V, H, Z, D, C, B, A}
Set3 is {D, V, B, X, C, Z, E, H, J, K, L, A}
Set4 is {X, E, J, K, L, A, B, C, D, Z, H, V}
Set5 is {888}

33. Set2 intersect Set1 :{A, B, C, Z, H}
34. Set1 intersect Set2 :{B, C, Z, H, A}
35. Set3 intersect Set4 :{A, L, K, J, H, E, Z, C, X, B, V, D}
36. Set4 intersect Set3 :{V, H, Z, D, C, B, A, L, K, J, E, X}
37. Set5 intersect Set3 :{}
==================================
Test difference:

Set1 is {A, L, K, J, H, E, Z, C, X, B}
Set2 is {V, H, Z, D, C, B, A}
Set3 is {D, V, B, X, C, Z, E, H, J, K, L, A}
Set4 is {X, E, J, K, L, A, B, C, D, Z, H, V}
Set5 is {}

38. Set2 difference Set1 :{D, V}
39. Set1 difference Set2 :{X, J, K, L, E}
40. Set3 difference Set4 :{}
41. Set4 difference Set3 :{}
42. Set5 difference Set3 :{}
43. Set3 difference Set5 :{A, L, K, J, H, E, Z, C, X, B, V, D}
==================================


