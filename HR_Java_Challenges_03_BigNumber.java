// HackerRank - Java - Challenges - III - BigNumber


/* 1. BigNumber - Java BigDecimal */
/*
Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!

Given an array, s, of n real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as it was read from stdin, meaning that .1 is printed as .1, and 0.1 is printed as 0.1. If two numbers represent numerically equivalent values (e.g., .1 ≡ 0.1), then they must be listed in the same order as they were received as input).

Complete the code in the unlocked section of the editor below. You must rearrange array s's elements according to the instructions above.

Input Format

The first line consists of a single integer, n, denoting the number of integer strings.
Each line i of the n subsequent lines contains a real number denoting the value of s_i.

Constraints

  *  1 ≤ n ≤ 200
  *  Each s_i has at most 300 digits.

Output Format

Locked stub code in the editor will print the contents of array s to stdout. You are only responsible for reordering the array's elements.

Sample Input

9
-100
50
0
56.6
90
0.12
.12
02.34
000.000

Sample Output

90
56.6
50
02.34
0.12
.12
0
000.000
-100

*/
/* Solution */

import java.math.BigDecimal;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        String[] sortedArray = Arrays.stream(s)
                .filter(k -> k != null)
                .sorted(Collections.reverseOrder(Comparator.comparing(BigDecimal::new)))
                .toArray(String[]::new);

        s = sortedArray;

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}


/* 2. BigNumber - Java Primality Test */
/*
A prime number is a natural number greater than 1 whose only positive divisors are 1 and itself. For example, the first six prime numbers are 2, 3, 5, 7, 11, and 13.

Given a large integer, n, use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

Input Format

A single line containing an integer, n (the number to be checked).

Constraints

  *  n contains at most 100 digits.

Output Format

If n is a prime number, print prime; otherwise, print not prime.

Sample Input

13

Sample Output

prime

Explanation

The only positive divisors of 13 are 1 and 13, so we print prime.
*/
/* Solution */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        
        BigInteger number = new BigInteger(n);
        
        System.out.println(number.isProbablePrime(100) ? "prime" : "not prime");

        bufferedReader.close();
    }
}


/* 3. BigNumber - Java BigInteger */
/*
In this problem, you have to add and multiply huge numbers! These numbers are so big that you can't contain them in any ordinary data types like a long integer.

Use the power of Java's BigInteger class and solve this problem.

Input Format

There will be two lines containing two numbers, a and b.

Constraints

a and b are non-negative integers and can have maximum 200 digits.

Output Format

Output two lines. The first line should contain a + b, and the second line should contain a x b. Don't print any leading zeros.

Sample Input

1234
20

Sample Output

1254
24680

Explanation

1234 + 20 = 1254
1234 x 20 = 24680
*/
/* Solution */

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        BigInteger a = new BigInteger(scan.next());
        BigInteger b = new BigInteger(scan.next());
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}


