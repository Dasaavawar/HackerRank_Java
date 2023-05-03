// HackerRank - Java - Challenges - I - Introduction


/* 1. Introduction - Welcome to Java! */
/*
Welcome to the world of Java! In this challenge, we practice printing to stdout.

The code stubs in your editor declare a Solution class and a main method. Complete the main method by copying the two lines of code below and pasting them inside the body of your main method.

System.out.println("Hello, World.");
System.out.println("Hello, Java.");

Input Format

There is no input for this challenge.

Output Format

You must print two lines of output:

  1.  Print Hello, World. on the first line.
  2.  Print Hello, Java. on the second line.

Sample Output

Hello, World.
Hello, Java.

*/
/* Solution */

public class Solution {

  public static void main(String[] args) {
      /* Enter your code here. Print output to STDOUT. Your class should be named Solution. */
      System.out.println("Hello, World.");
      System.out.println("Hello, Java.");
  }
}


/* 2. Introduction - Java Stdin and Stdout I */
/*
Most HackerRank challenges require you to read input from stdin (standard input) and write output to stdout (standard output).

(https://en.wikipedia.org/wiki/Standard_streams#Standard_input_.28stdin.29)
(https://en.wikipedia.org/wiki/Standard_streams#Standard_output_.28stdout.29)

One popular way to read input from stdin is by using the Scanner class and specifying the Input Stream as System.in. For example:

(https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)

Scanner scanner = new Scanner(System.in);
String myString = scanner.next();
int myInt = scanner.nextInt();
scanner.close();

System.out.println("myString is: " + myString);
System.out.println("myInt is: " + myInt);

The code above creates a Scanner object named

and uses it to read a String and an int. It then closes the Scanner object because there is no more input to read, and prints to stdout using System.out.println(String). So, if our input is:

Hi 5

Our code will print:

myString is: Hi
myInt is: 5

Alternatively, you can use the BufferedReader class.

Task

In this challenge, you must read 3 integers from stdin and then print them to stdout. Each integer must be printed on a new line. To make the problem a little easier, a portion of the code is provided for you in the editor below.

Input Format

There are 3 lines of input, and each line contains a single integer.

Sample Input

42
100
125

Sample Output

42
100
125

*/
/* Solution */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt(); // Complete this line
        int c = scan.nextInt(); // Complete this line

        System.out.println(a);
        System.out.println(b); // Complete this line
        System.out.println(c); // Complete this line
    }
}


/* 3. Introduction - Java If-Else */
/*
In this challenge, we test your knowledge of using if-else conditional statements to automate decision-making processes. An if-else statement has the following logical flow:

Wikipedia if-else flow chart

Source: Wikipedia (https://en.wikipedia.org/wiki/Conditional_%28computer_programming%29)

[/data/Java_If-Else.png]

(https://s3.amazonaws.com/hr-challenge-images/13689/1446563087-4ec019a919-332px-If-Then-Else-diagram.svg.png)

Task

Given an integer, n, perform the following conditional actions:

  1. If n is odd, print Weird
  2. If n is even and in the inclusive range of 2 to 5, print Not Weird
  3. If n is even and in the inclusive range of 6 to 20, print Weird
  4. If n is even and greater than 20, print Not Weird

Complete the stub code provided in your editor to print whether or not n is weird.

Input Format

A single line containing a positive integer, n.

Constraints

  *  1 ≤ n ≤ 100

Output Format

Print Weird if the number is weird; otherwise, print Not Weird.

Sample Input 0

3

Sample Output 0

Weird

Sample Input 1

24

Sample Output 1

Not Weird

Explanation

Sample Case 0: n = 3

n is odd and odd numbers are weird, so we print Weird.

Sample Case 1: n = 24

n > 20 and n is even, so it isn't weird. Thus, we print Not Weird.
*/
/* Solution */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        if (N%2 == 1) {
            System.out.println("Weird");
        } if (N%2 == 0 && N >=2 && N <= 5) {
            System.out.println("Not Weird");
        } if (N%2 == 0 && N >=6 && N <= 20) {
            System.out.println("Weird");
        } if (N%2 == 0 && N > 20) {
            System.out.println("Not Weird");
        }       
    }
}


/* 4. Introduction - Java Stdin and Stdout II */
/*
In this challenge, you must read an integer, a double, and a String from stdin, then print the values according to the instructions in the Output Format section below. To make the problem a little easier, a portion of the code is provided for you in the editor.

Note: We recommend completing Java Stdin and Stdout I before attempting this challenge. (https://www.hackerrank.com/challenges/java-stdin-and-stdout-1)

Input Format

There are three lines of input:

  1.  The first line contains an integer.
  2.  The second line contains a double.
  3.  The third line contains a String.

Output Format

There are three lines of output:

  1.  On the first line, print String: followed by the unaltered String read from stdin.
  2.  On the second line, print Double: followed by the unaltered double read from stdin.
  3.  On the third line, print Int: followed by the unaltered integer read from stdin.

To make the problem easier, a portion of the code is already provided in the editor.

Note: If you use the nextLine() method immediately following the nextInt() method, recall that nextInt() reads integer tokens; because of this, the last newline character for that line of integer input is still queued in the input buffer and the next nextLine() will be reading the remainder of the integer line (which is empty).

Sample Input

42
3.1415
Welcome to HackerRank's Java tutorials!

Sample Output

String: Welcome to HackerRank's Java tutorials!
Double: 3.1415
Int: 42

*/
/* Solution */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        scan.close();
    }
}


/* 5. Introduction - Java Output Formatting */
/*
Java's System.out.printf function can be used to print formatted output. The purpose of this exercise is to test your understanding of formatting output using printf.

To get you started, a portion of the solution is provided for you in the editor; you must format and print the input to complete the solution.

Input Format

Every line of input will contain a String followed by an integer.
Each String will have a maximum of 10 alphabetic characters, and each integer will be in the inclusive range from 0 to 999.

Output Format

In each line of output there should be two columns:
The first column contains the String and is left justified using exactly 15 characters.
The second column contains the integer, expressed in exactly 3 digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.

Sample Input

java 100
cpp 65
python 50

Sample Output

================================
java           100 
cpp            065 
python         050 
================================

Explanation

Each String is left-justified with trailing whitespace through the first 15 characters. The leading digit of the integer is the 16th character, and each integer that was less than 3 digits now has leading zeroes.
*/
/* Solution */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                System.out.printf("%-15s%03d\n", s1, x); //Complete this line
            }
            System.out.println("================================");

    }
}


/* 6. Introduction - Welcome to Java! */
/*
Objective

In this challenge, we're going to use loops to help us do some simple math.

Task

Given an integer, N, print its first 10 multiples. Each multiple N x i (where 1 ≤ i ≤ 10) should be printed on a new line in the form: N x i = result.

Input Format

A single integer, N.

Constraints

  *  2 ≤ N ≤ 20

Output Format

Print 10 lines of output; each line i (where 1 ≤ i ≤ 10) contains the result of N x i in the form:
N x i = result.

Sample Input

2

Sample Output

2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
2 x 10 = 20

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

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + N*i);
        }

        bufferedReader.close();
    }
}


/* 7. Introduction - Java Loops II */
/*
We use the integers a, b, and n to create the following series:

(a + 2^0 * b), (a + 2^0 * b + 2^1 * b), ... , (a + 2^0 * b + 2^1 * b + ... + 2^(n-1) * b)

You are given q queries in the form of a, b, and n. For each query, print the series corresponding to the given a, b, and n values as a single line of n space-separated integers.

Input Format

The first line contains an integer, q, denoting the number of queries.
Each line i of the q subsequent lines contains three space-separated integers describing the respective a_i , b_i , and n_i values for that query.

Constraints

  *  0 ≤ q ≤ 500
  *  0 ≤ a, b ≤ 50
  *  1 ≤ n ≤ 15

Output Format

For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of n space-separated integers.

Sample Input

2
0 2 10
5 3 5

Sample Output

2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98

Explanation

We have two queries:

  1.  We use a = 0, b = 2, and n = 10 to produce some series s_0 , s_1 , ... , s_(n-1) :
      *  s_0 = 0 + 1 * 2 = 2
      *  s_1 = 0 + 1 * 2 + 2 * 2 = 6
      *  s_2 = 0 + 1 * 2 + 2 * 2 + + 4 * 2 = 14
      ... and so on.

Once we hit n = 10, we print the first ten terms as a single line of space-separated integers.

  2.  We use a = 5, b = 3, and n = 5 to produce some series s_0 , s_1 , ... , s_(n-1) :
      *  s_0 = 5 + 1 * 3 = 8
      *  s_1 = 0 + 1 * 3 + 2 * 3 = 14
      *  s_2 = 0 + 1 * 3 + 2 * 3 + 4 * 3 = 26
      *  s_3 = 0 + 1 * 3 + 2 * 3 + 4 * 3 + 8 * 3 = 50
      *  s_4 = 0 + 1 * 3 + 2 * 3 + 4 * 3 + 8 * 3 + 16 * 3 = 98
      We then print each element of our series as a single line of space-separated values.
*/
/* Solution */

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            double k = a;      
            for(int j=0; j<n; j++){
                k += Math.pow(2,j)*b;
                System.out.print((int) k +" ");
                }
                System.out.println("\r");
        }
        in.close();
    }
}


/* 8. Introduction - Java Datatypes */
/*
Java has 8 primitive data types; char, boolean, byte, short, int, long, float, and double. For this exercise, we'll work with the primitives used to hold integer values (byte, short, int, and long):

  1.  A byte is an 8-bit signed integer.
  2.  A short is a 16-bit signed integer.
  3.  An int is a 32-bit signed integer.
  4.  A long is a 64-bit signed integer.

Given an input integer, you must determine which primitive data types are capable of properly storing that input.

To get you started, a portion of the solution is provided for you in the editor.

Reference: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

Input Format

The first line contains an integer, T, denoting the number of test cases.
Each test case, T, is comprised of a single line with an integer, n, which can be arbitrarily large or small.

Output Format

For each input variable n and appropriate primitive dataType, you must determine if the given primitives are capable of storing it. If yes, then print:

n can be fitted in:
* dataType

If there is more than one appropriate data type, print each one on its own line and order them by size (i.e.: byte < short < int < long).

If the number cannot be stored in one of the four aforementioned primitives, print the line:

n can't be fitted anywhere.

Sample Input

5
-150
150000
1500000000
213333333333333333333333333333333333
-100000000000000

Sample Output

-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long

Explanation

-150 can be stored in a short, an int, or a long.
213333333333333333333333333333333333 is very large and is outside of the allowable range of values for the primitive data types discussed in this problem.
*/
/* Solution */

import java.util.*;
import java.io.*;



class Solution{
    public static void main(String []argh)
    {



        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>=-Math.pow(2, 31) && x<=Math.pow(2, 31)-1)System.out.println("* int");
                if(x>=-Math.pow(2, 63) && x<=Math.pow(2, 63)-1)System.out.println("* long");
                //Complete the code
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}


/* 9. Introduction - Java End-of-file */
/*

    "In computing, End Of File (commonly abbreviated EOF) is a condition in a computer operating system where no more data can be read from a data source." — (Wikipedia: End-of-file)

(https://en.wikipedia.org/wiki/End-of-file)

The challenge here is to read n lines of input until you reach EOF, then number and print all n lines of content.

Hint: Java's Scanner.hasNext() method is helpful for this problem.

Input Format

Read some unknown n lines of input from stdin(System.in) until you reach EOF; each line of input contains a non-empty String.

Output Format

For each line, print the line number, followed by a single space, and then the line content received as input.

Sample Input

Hello world
I am a file
Read me until end-of-file.

Sample Output

1 Hello world
2 I am a file
3 Read me until end-of-file.

*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int lines = 1;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(lines + " " + scanner.nextLine());
            lines++;
        }
        scanner.close();
    }
}


/* 10. Introduction - Java Static Initializer Block */
/*
Static initialization blocks are executed when the class is loaded, and you can initialize static variables in those blocks.

It's time to test your knowledge of Static initialization blocks. You can read about it here. (https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html)

You are given a class Solution with a main method. Complete the given code so that it outputs the area of a parallelogram with breadth B and height H. You should read the variables from the standard input.

If B ≤ 0 or H ≤ 0, the output should be "java.lang.Exception: Breadth and height must be positive" without quotes.

Input Format

There are two lines of input. The first line contains B: the breadth of the parallelogram. The next line contains H: the height of the parallelogram.

Constraints

  *  -100 ≤ B ≤ 100
  *  -100 ≤ H ≤ 100

Output Format

If both values are greater than zero, then the main method must output the area of the parallelogram. Otherwise, print "java.lang.Exception: Breadth and height must be positive" without quotes.

Sample input 1

1
3

Sample output 1

3

Sample input 2

-1
2

Sample output 2

java.lang.Exception: Breadth and height must be positive

*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int B=sc.nextInt();
        int H=sc.nextInt();
        try{
            if(B<=0 || H<=0){
                throw new Exception("Breadth and height must be positive");
                }
            else
            System.out.println(B*H);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


/* 11. Introduction - Java Int to String */
/*
You are given an integer n, you have to convert it into a string.

Please complete the partially completed code in the editor. If your code successfully converts n into a string s the code will print "Good job". Otherwise it will print "Wrong answer".

n can range between -100 to 100 inclusive.

Sample Input 0

100

Sample Output 0

Good job

*/
/* Solution */

import java.util.*;
import java.security.*;
public class Solution {
 public static void main(String[] args) {

  DoNotTerminate.forbidExit();

  try {
   Scanner in = new Scanner(System.in);
   int n = in .nextInt();
   in.close();
   //String s=???; Complete this line below

   //Write your code here
   String s = Integer.toString(n);
   
   if (n == Integer.parseInt(s)) {
    System.out.println("Good job");
   } else {
    System.out.println("Wrong answer.");
   }
  } catch (DoNotTerminate.ExitTrappedException e) {
   System.out.println("Unsuccessful Termination!!");
  }
 }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

 public static class ExitTrappedException extends SecurityException {

  private static final long serialVersionUID = 1;
 }

 public static void forbidExit() {
  final SecurityManager securityManager = new SecurityManager() {
   @Override
   public void checkPermission(Permission permission) {
    if (permission.getName().contains("exitVM")) {
     throw new ExitTrappedException();
    }
   }
  };
  System.setSecurityManager(securityManager);
 }
}


/* 12. Introduction - Java Date and Time */
/*
The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.

(https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html)

You are given a date. You just need to write the method, getDay, which returns the day on that date. To simplify your task, we have provided a portion of the code in the editor.

Example

month = 8
day = 14
year = 2017

The method should return MONDAY as the day on that date.

[/data/Java_Date_and_Time.png]

(https://s3.amazonaws.com/hr-assets/0/1514458312-c097047ed4-calendar_class.png)

Function Description

Complete the findDay function in the editor below.

findDay has the following parameters:

  1.  int: month
  2.  int: day
  3.  int: year

Returns

  1.  string: the day of the week in capital letters

Input Format

A single line of input containing the space separated month, day and year, respectively, in MM DD YYYY format.

Constraints

  *  2000 < year < 3000

Sample Input

08 05 2015

Sample Output

WEDNESDAY

Explanation

The day on August 5th 2015 was WEDNESDAY.
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

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, day);
        DateFormat f = new SimpleDateFormat("EEEE");
        return f.format(cal.getTime()).toUpperCase();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/* 13. Introduction - Java Currency Formatter */
/*
Given a double-precision number, payment, denoting an amount of money, use the NumberFormat class' getCurrencyInstance method to convert payment into the US, Indian, Chinese, and French currency formats.

(https://en.wikipedia.org/wiki/Double-precision_floating-point_format)
(https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html)
(https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getCurrencyInstance-java.util.Locale-)

Then print the formatted values as follows:

US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment

where formattedPayment is payment formatted according to the appropriate Locale's currency. (https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)

Note: India does not have a built-in Locale, so you must construct one where the language is en (i.e., English). (https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html#Locale-java.lang.String-java.lang.String-)

Input Format

A single double-precision number denoting payment.

Constraints

  *  0 ≤ payment ≤ 10^9

Output Format

On the first line, print US: u, where u is payment formatted for US currency.
On the second line, print India: i, where i is payment formatted for Indian currency.
On the third line, print China: c, where c is payment formatted for Chinese currency.
On the fourth line, print France: f, where f is payment formatted for French currency.

Sample Input

12324.134

Sample Output

US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €

Explanation

Each line contains the value of payment formatted according to the four countries' respective currencies.
*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        String u, i, c, f;
        u = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        i = NumberFormat.getCurrencyInstance(new Locale("EN","IN")).format(payment);
        c = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        f = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        
        System.out.println("US: " + u);
        System.out.println("India: " + i);
        System.out.println("China: " + c);
        System.out.println("France: " + f);
    }
}


