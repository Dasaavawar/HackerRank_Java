/* HackerRank - Java - Challenges - IV - Data Structures - Java 8 */


/* 1. Data Structures - Java 1D Array */
/*
An array is a simple data structure used to store a collection of data in a contiguous block of memory. Each element in the collection is accessed using an index, and the elements are easy to find because they're stored sequentially in memory.

Because the collection of elements in an array is stored as a big block of data, we typically use arrays when we know exactly how many pieces of data we're going to have. For example, you might use an array to store a list of student ID numbers, or the names of state capitals. To create an array of integers named myArray that can hold four integer values, you would write the following code:

int[] myArray = new int[4];

This sets aside a block of memory that's capable of storing 4 integers. Each integer storage cell is assigned a unique index ranging from 0 to one less than the size of the array, and each cell initially contains a 0. In the case of myArray, we can store integers at indices 0, 1, 2, and 3. Let's say we wanted the last cell to store the number 12; to do this, we write:

myArray[3] = 12;

Similarly, we can print the contents of the last cell with the following code:

System.out.println(myArray[3]);

The code above prints the value stored at index 3 of myArray, which is 12 (the value we previously stored there). It's important to note that while Java initializes each cell of an array of integers with a 0, not all languages do this.

Task

The code in your editor does the following:

  1.  Reads an integer from stdin and saves it to a variable, n, denoting some number of integers.
  2.  Reads n integers corresponding to a_0, a_1, ..., a_n-1 from stdin and saves each integer a_i to a variable, val.
  3.  Attempts to print each element of an array of integers named a.

Write the following code in the unlocked portion of your editor:

  1.  Create an array, a, capable of holding n integers.
  2.  Modify the code in the loop so that it saves each sequential value to its corresponding location in the array. For example, the first value must be stored in a_0, the second value must be stored in a_1, and so on.

Good luck!

Input Format

The first line contains a single integer, n, denoting the size of the array.
Each line i of the n subsequent lines contains a single integer denoting the value of element a_i.

Output Format

You are not responsible for printing any output to stdout. Locked code in the editor loops through array a and prints each sequential element on a new line.

Sample Input

5
10
20
30
40
50

Sample Output

10
20
30
40
50

Explanation

When we save each integer to its corresponding index in a, we get a = [10, 20, 30, 40, 50]. The locked code prints each array element on a new line from left to right.
*/
/* Solution */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}


/* 2. Data Structures - Java 2D Array */
/*
You are given a 6*6 2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g

For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0

The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly 6 lines, each containing 6 integers seperated by spaces. Each integer will be between -9 and 9 inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output

19

Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4

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

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        
        int maxSum = Integer.MIN_VALUE;
         
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                int sum = 0;
                sum += arr.get(i).subList(j, j+3).stream().reduce(Integer::sum).get();
                sum += arr.get(i+1).subList(j+1, j+2).stream().reduce(Integer::sum).get();
                sum += arr.get(i+2).subList(j, j+3).stream().reduce(Integer::sum).get();
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
    System.out.println(maxSum);
    }
}


/* 3. Data Structures - Java Subarray */
/*
We define the following:

  1.  A subarray of an n-element array is an array composed from a contiguous block of the original array's elements. For example, if array = [1, 2, 3], then the subarrays are [1], [2], [3], [1, 2], [2, 3], and [1, 2, 3]. Something like [1, 3] would not be a subarray as it's not a contiguous subsection of the original array.
  2.  The sum of an array is the total sum of its elements.
      *  An array's sum is negative if the total sum of its elements is negative.
      *  An array's sum is positive if the total sum of its elements is positive.

Given an array of n integers, find and print its number of negative subarrays on a new line.

Input Format

The first line contains a single integer, n, denoting the length of array A = [a_0, a_1, ..., a_n-1].
The second line contains n space-separated integers describing each respective element, a_i, in array A.

Constraints

  *  1 ≤ n ≤ 100
  *  -10^4 ≤ a_i ≤ 10^4

Output Format

Print the number of subarrays of A having negative sums.

Sample Input

5
1 -2 4 -5 1

Sample Output

9

Explanation

There are nine negative subarrays of A = [1, -2, 4, -5, 1]:

  1.  [1:1] => -2
  2.  [3:3] => -5
  3.  [0:1] => 1 + -2 = -1
  4.  [2:3] => 4 + -5 = -1
  5.  [3:4] => -5 + 1 = -4
  6.  [1:3] => -2 + 4 + -5 = -3
  7.  [0:3] => 1 + -2 + 4 + -5 = -2
  8.  [1:4] => -2 + 4 + -5 + 1 = -2
  9.  [0:4] => 1 + -2 + 4 + -5 + 1 = -1

Thus, we print 9 on a new line.
*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while(c > 0){
            c--;
            list.add(scanner.nextInt());
        }
        int neg = 0;
        for(int i = 0; i < list.size(); i++){
            int sum = 0;
            for(int j = i; j < list.size(); j++){
                sum += list.get(j);
                if(sum < 0){
                    neg ++;
                }
            }
        }
    System.out.println(neg);
    scanner.close();
    }
}


/* 4. Data Structures - Java Arraylist */
/*
Sometimes it's better to use dynamic size arrays. Java's Arraylist (https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) can provide you this feature. Try to solve this problem using Arraylist.

You are given n lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in yth position of xth line.

Take your input from System.in.

Input Format

The first line has an integer n. In each of the next n lines there will be an integer d denoting number of integers on that line and then there will be d space-separated integers. In the next line there will be an integer q denoting number of queries. Each query will consist of two integers x and y.

Constraints

  *  1 <= n <= 20000
  *  0 <= d <= 50000
  *  1 <= q <= 1000
  *  1 <= x <= n

Each number will fit in signed integer.
Total number of integers in n lines will not cross 10^5.

Output Format
In each line, output the number located in yth position of xth line. If there is no such position, just print "ERROR!"

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output

74
52
37
ERROR!
ERROR!

Explanation

The diagram below explains the queries:

[/data/Java_Arraylist.png]

(https://s3.amazonaws.com/hr-assets/0/1489168616-b25dd38013-arraylist.png)

*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            int n1=sc.nextInt();
            ArrayList<Integer> l2=new ArrayList<>();
            for(int j=0;j<n1;j++) {
                l2.add(sc.nextInt());
            }
            list.add(i, l2);
        }
        
        int num=sc.nextInt();
        for(int k=0;k<num;k++) {
            int m=sc.nextInt();
            int o=sc.nextInt();
            try{
                System.out.println(list.get(m-1).get(o-1));
            }
            catch(Exception e) {
                System.out.println("ERROR!");
            }
        }
    sc.close();
    }
}


/* 5. Data Structures - Java 1D Array (Part 2) */
/*
Let's play a game on an array! You're standing at index 0 of an n-element array named game. From some index i (where 0 ≤ i < n), you can perform one of the following moves:

  *  Move Backward: If cell i - 1 exists and contains a 0, you can walk back to cell i - 1.
  *  Move Forward:
      *  If cell i + 1 contains a zero, you can walk to cell i + 1.
      *  If cell i + leap contains a zero, you can jump to cell i + leap
      *  If you're standing in cell n - 1 or the value of i + leap ≥ n, you can walk or jump off the end of the array and win the game.

In other words, you can move from index i to index i + 1, i - 1, or i + leap as long as the destination index is a cell containing a 0. If the destination index is greater than n - 1, you win the game.

Function Description

Complete the canWin function in the editor below.

canWin has the following parameters:

  *  int leap: the size of the leap
  *  int game[n]: the array to traverse

Returns

  *  boolean: true if the game can be won, otherwise false

Input Format

The first line contains an integer, q, denoting the number of queries (i.e., function calls).
The 2 * q subsequent lines describe each query over two lines:

  1.  The first line contains two space-separated integers describing the respective values of n and leap.
  2.  The second line contains n space-separated binary integers (i.e., zeroes and ones) describing the respective values of game_0, game_1, ..., game_n-1.

Constraints

  *  1 ≤ q ≤ 5000
  *  2 ≤ n ≤ 100
  *  0 ≤ leap ≤ 100
  *  It is guaranteed that the value of game[0] is always 0.

Sample Input

STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0

Sample Output

YES
YES
NO
NO

Explanation

We perform the following q = 4 queries:

  1.  For game = [0, 0, 0, 0, 0] and leap = 3, we can walk and/or jump to the end of the array because every cell contains a 0. Because we can win, we return true.
  2.  For game = [0, 0, 0, 1, 1, 1] and leap = 5, we can walk to index 1 and then jump i + leap = 1 + 5 = 6 units to the end of the array. Because we can win, we return true.
  3.  For game = [0, 0, 0, 1, 1, 0] and leap = 3, there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
  4.  For game = [0, 1, 0] and leap = 1, there is no way for us to get past the one at index 1. Because we cannot win, we return false.
*/
/* Solution */

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return canWin(leap, game, 0);
    }
    
    public static boolean canWin(int leap, int[] game, int i) {
        if (i >= game.length) {
            return true;
        } else if (i < 0 || game[i] == 1) {
            return false;
        }
        game[i] = 1;
        return canWin(leap, game, i + leap) || canWin(leap, game, i + 1) || canWin(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}


/* 6. Data Structures - Java List */
/*
For this problem, we have 2 types of queries you can perform on a List (https://docs.oracle.com/javase/7/docs/api/java/util/List.html):

  1.  Insert y at index x:

Insert
x y

  2.  Delete the element at index x:

    Delete
    x

Given a list, L, of N integers, perform Q queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format

The first line contains an integer, N (the initial number of elements in L).
The second line contains N space-separated integers describing L.
The third line contains an integer, Q (the number of queries).
The 2Q subsequent lines describe the queries, and each query is described over two lines:

  *  If the first line of a query contains the String Insert, then the second line contains two space separated integers x y, and the value y must be inserted into L at index x.
  *  If the first line of a query contains the String Delete, then the second line contains index x, whose element must be deleted from L.

Constraints

  *  1 ≤ N ≤ 4000
  *  1 ≤ Q ≤ 4000
  *  Each element in is a 32-bit integer.

Output Format

Print the updated list L as a single line of space-separated integers.

Sample Input

5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output

0 1 78 12 23

Explanation

L = [12, 0, 1, 78, 12]
Q_0: Insert 23 at index 5.
L_0 = [12, 0, 1, 78, 12, 5]
Q_1: Delete the element at index 0.
L_1 = [0, 1, 78, 12, 23]

Having performed all Q queries, we print L_1 as a single line of space-separated integers.
*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int nOfElements = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nOfElements;i++){
            list.add(scanner.nextInt());
        }
        int nOfQueries = scanner.nextInt();
        for(int i=0;i<nOfQueries;i++){
            String choice = scanner.next();
            if(choice.equals("Insert")){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                list.add(x,y);
            }
            if(choice.equals("Delete")){
                int x = scanner.nextInt();
                list.remove(x);
            }
        }
        for(int n : list){
            System.out.print(n+" ");
        }
        scanner.close();
    }
}


/* 7. Data Structures - Java Map */
/*
You are given a phone book that consists of people's names and their phone number. After that you will be given some person's name as query. For each query, print the phone number of that person.

Input Format

The first line will have an integer n denoting the number of entries in the phone book. Each entry consists of two lines: a name and the corresponding phone number.

After these, there will be some queries. Each query will contain a person's name. Read the queries until end-of-file.

Constraints:
A person's name consists of only lower-case English letters and it may be in the format 'first-name last-name' or in the format 'first-name'. Each phone number has exactly 8 digits without any leading zeros.

  *  1 ≤ n ≤ 1000000
  *  1 ≤ Query ≤ 1000000

Output Format

For each case, print "Not found" if the person has no entry in the phone book. Otherwise, print the person's name and phone number. See sample output for the exact format.

To make the problem easier, we provided a portion of the code in the editor. You can either complete that code or write completely on your own.

Sample Input

3
uncle sam
99912222
tom
11122222
harry
12299933
uncle sam
uncle tom
harry

Sample Output

uncle sam=99912222
Not found
harry=12299933

*/
/* Solution */

import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        
        Map<String,Integer> map = new HashMap<>(n);
		
        for(int i=0;i<n;i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			in.nextLine();
            map.put(name,Integer.valueOf(phone));
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            if(map.containsKey(s)){
                System.out.println(s+"="+map.get(s));
            }else{
                System.out.println("Not found");
            }
		}
        in.close();
	}
}


/* 8. Data Structures - Java Stack */
/*
In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.(Wikipedia)

A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]

Sample Output

true
true
false
true

*/
/* Solution */

import java.util.*;

class Solution{
    
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            if (isBalanced(input)) {
            System.out.println("true");
            } else {
            System.out.println("false");
            }
        }
    }
    
    private static boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
        if (c == '{' || c == '[' || c == '(') {
            stack.push(c);
        } else if (!stack.isEmpty() && isMatchingPair(stack.peek(), c)) {
            stack.pop();
        } else {
            return false;
        }
    }

    return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '{' && closing == '}') || (opening == '[' && closing == ']') || (opening == '(' && closing == ')');
        }
    }
}


/* 9. Data Structures - Java Hashset */
/*
In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values(Wikipedia). {1, 2, 3} is an example of a set, but {1, 2, 2} is not a set. Today you will learn how to use sets in java by solving this problem.

You are given n pairs of strings. Two pairs (a, b) and (c, d) are identical if a = c and b = d. That also implies (a, b) is not same as (b, a). After taking each pair as input, you need to print number of unique pairs you currently have.

Complete the code in the editor to solve this problem.

Input Format

In the first line, there will be an integer T denoting number of pairs. Each of the next T lines will contain two strings seperated by a single space.

Constraints:

  *  1 ≤ T ≤ 100000
  *  Length of each string is atmost 5 and will consist lower case letters only.

Output Format

Print T lines. In the ith line, print number of unique pairs you have after taking ith pair as input.

Sample Input

5
john tom
john mary
john tom
mary anna
mary anna

Sample Output

1
2
2
3
3

Explanation

  *  After taking the first input, you have only one pair: (john,tom)
  *  After taking the second input, you have two pairs: (john, tom) and (john, mary)
  *  After taking the third input, you still have two unique pairs.
  *  After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
  *  After taking the fifth input, you still have three unique pairs.

*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your code here
        Set<String> hs = new HashSet<>();
        int count=0;
        for(int i=0;i<pair_left.length;i++){
            String name=pair_left[i]+" "+pair_right[i];
            if(!hs.contains(name)){
                count++;
            }
            
            System.out.println(count);
            hs.add(pair_left[i]+" "+pair_right[i]);
        }
   }
}


/* 10. Data Structures - Java Generics */
/*
Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will test your knowledge on Java Generic methods.

Let's say you have an integer array and a string array. You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.

You are given code in the editor. Complete the code so that it prints the following lines:

1
2
3
Hello
World

Do not use method overloading because your answer will not be accepted.
*/
/* Solution */

import java.util.*;

class Printer {
    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.println(element);
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        long count = Arrays.stream(Printer.class.getDeclaredMethods())
                .filter(method -> method.getName().equals("printArray"))
                .count();

        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}


/* 11. Data Structures - Java Comparator */
/*
Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.

The Player class is provided for you in your editor. It has 2 fields: a name String and a score integer.

Given an array of n Player objects, write a comparator that sorts them in order of decreasing score; if 2 or more players have the same score, sort those players alphabetically by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) (https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare%28T,%20T%29) method.

Input Format

Input from stdin is handled by the locked stub code in the Solution class.

The first line contains an integer, n, denoting the number of players.
Each of n the subsequent lines contains a player's name and score, respectively.

Constraints

  *  0 ≤ score ≤ 1000
  *  2 players can have the same name.
  *  Player names consist of lowercase English letters.

Output Format

You are not responsible for printing any output to stdout. The locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.

Sample Input

5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

Sample Output

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50

*/
/* Solution */

import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player>{
    @Override
    public int compare(Player p1, Player p2) {
        if(p1.score != p2.score)
            return Integer.compare(p2.score, p1.score);
        else return p1.name.compareTo(p2.name);
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}


/* 12. Data Structures - Java Sort */
/*
You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

Hint: You can use comparators to sort a list of objects. See the oracle docs (https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html) to learn about comparators.

Input Format

The first line of input contains an integer N, representing the total number of students. The next N lines contains a list of student information in the following structure:

ID Name CGPA

Constraints

  *  2 ≤ N ≤ 1000
  *  0 ≤ ID ≤ 100000
  *  5 ≤ ∣Name∣ ≤ 30
  *  0 ≤ CGPA ≤ 4.00

The name contains only lowercase English letters. The ID contains only integer numbers without leading zeros. The CGPA will contain, at most, 2 digits after the decimal point.

Output Format

After rearranging the students according to the above rules, print the first name of each student on a separate line.

Sample Input

5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

Sample Output

Ashis
Fahim
Samara
Samiha
Rumpa

*/
/* Solution */

import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getFname).thenComparing(Student::getId));
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}


/* 13. Data Structures - Java Dequeue */
/*
In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();

You can find more details about Deque here (https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html).

In this problem, you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size M.

Note: Time limit is 3 second for this problem.

Input Format

The first line of input contains two integers
and : representing the total number of integers and the size of the subarray, respectively. The next line contains

space separated integers.

Constraints

  *  1 ≤ N ≤ 100000
  *  1 ≤ M ≤ 100000
  *  M ≤ N

The numbers in the array will range between [0, 100000000].

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size M.

Sample Input

6 3
5 3 5 2 3 2

Sample Output

3

Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.

s_1 = (5, 3, 5) - Has 2 unique numbers.

s_2 = (3, 5, 2) - Has 3 unique numbers.

s_3 = (5, 2, 3) - Has 3 unique numbers.

s_4 = (2, 3, 2) - Has 2 unique numbers.

In these subarrays, there are 2, 3, 3, 2 unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is 3.
*/
/* Solution */

import java.util.*;
import java.lang.Math;
    
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> dq = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (i >= m) {
                int first = dq.removeFirst();
                hm.put(first, hm.get(first) - 1);
                if (hm.get(first) == 0)
                    hm.remove(first);
            }
            dq.addLast(num);
            hm.put(num, hm.get(num) == null ? 1 : hm.get(num) + 1);
            max = Math.max(max, hm.size());
            if (max == m)
                break;
        }
        System.out.println(max);
    }
}


/* 14. Data Structures - Java BitSet */
/*
Java's BitSet (https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html) class implements a vector of bit values (i.e.: false (0) or true (1)) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of 1 is called a set bit.

Given 2 BitSets, B_1 and B_2, of size N where all bits in both BitSets are initialized to 0, perform a series of M operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

Input Format

The first line contains 2 space-separated integers, N (the length of both BitSets B_1 and B_2) and M (the number of operations to perform), respectively.
The M subsequent lines each contain an operation in one of the following forms:

  *  AND (https://en.wikipedia.org/wiki/Logical_conjunction) <set> <set>
  *  OR (https://en.wikipedia.org/wiki/Logical_disjunction) <set> <set>
  *  XOR (https://en.wikipedia.org/wiki/Exclusive_or) <set> <set>
  *  FLIP (https://en.wikipedia.org/wiki/Bitwise_operation#NOT) <set> <index>
  *  SET (https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html#set%28int%29) <set> <index>

In the list above, <set> is the integer 1 or 2, where 1 denotes B_1 and 2 denotes B_2.
<index> is an integer denoting a bit's index in the BitSet corresponding to <set>.

For the binary operations AND, OR, and XOR, operands are read from left to right and the BitSet resulting from the operation replaces the contents of the first operand. For example:

AND 2 1

B_2 is the left operand, and B_1 is the right operand. This operation should assign the result of B_2 ∧ B_1 to B_2.

Constraints

  *  1 ≤ N ≤ 1000
  *  1 ≤ M ≤ 10000

Output Format

After each operation, print the respective number of set bits in BitSet B_1 and BitSet B_2 as 2 space-separated integers on a new line.

Sample Input

5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1

Sample Output

0 0
1 0
1 1
1 2

Explanation

Initially: N = 5, M = 4, B_1 = {0, 0, 0, 0, 0}, and B_2 = {0, 0, 0, 0, 0}. At each step, we print the respective number of set bits in B_1 and B_2 as a pair of space-separated integers on a new line.

M_0 = AND12
B_1 = B_1 ∧ B_2 = {0, 0, 0, 0, 0} ∧ {0, 0, 0, 0, 0} = {0, 0, 0, 0, 0}
B_1 = {0, 0, 0, 0, 0}, B_2 = {0, 0, 0, 0, 0}
The number of set bits in B_1 and B_2 is 0.

M_1 = SET14
Set B_1 [4] to true (1).
B_1 = {0, 0, 0, 0, 1}, B_2 = {0, 0, 0, 0, 0}
The number of set bits in B_1 is 1 and B_2 is 0.

M_2 = FLIP22
Flip B_2 [2] false from (0) to true (1).
B_1 = {0, 0, 0, 0, 1}, B_2 = {0, 0, 1, 0, 0}
The number of set bits in B_1 is 1 and B_2 is 1.

M_3 = OR21
B_2 = B_1 ∨ B_2 = {0, 0, 1, 0, 0} ∧ {0, 0, 0, 0, 1} = {0, 0, 1, 0, 1}
B_1 = {0, 0, 0, 0, 1}, B_2 = {0, 0, 1, 0, 1}
The number of set bits in B_1 is 1 and B_2 is 2.
*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            if (op.equals("AND")) {
                if (p1 == 1) {b1.and(b2);}
                else {b2.and(b1);}
            }
            else if (op.equals("OR")) {
                if (p1 == 1) {b1.or(b2);}
                else {b2.or(b1);}
            }
            else if (op.equals("FLIP")) {
                if (p1 == 1) {
                    b1.flip(p2);
                } else {
                    b2.flip(p2);
                }
            }
            else if (op.equals("SET")) {
                if (p1 == 1) {
                    b1.set(p2);
                } else {
                    b2.set(p2);
                }
            }
            else if (op.equals("XOR")) {
                if (p1 == 1) {b1.xor(b2);}
                else {b2.xor(b1);}
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        sc.close();
    }
}


/* 15. Data Structures - Java Priority Queue */
/*
In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. - Wikipedia (https://en.wikipedia.org/wiki/Priority_queue)

In this problem we will test your knowledge on Java Priority Queue (https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html).

There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.

  *  ENTER: A student with some priority enters the queue to be served.
  *  SERVED: The student with the highest priority is served (removed) from the queue.

A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

  1.  The student having the highest Cumulative Grade Point Average (CGPA) is served first.
  2.  Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
  3.  Any students having the same CGPA and name will be served in ascending order of the id.

Create the following two classes:

  *  The Student class should implement:
      *  The constructor Student(int id, String name, double cgpa).
      *  The method int getID() to return the id of the student.
      *  The method String getName() to return the name of the student.
      *  The method double getCGPA() to return the CGPA of the student.
  *  The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all the given events and return all the students yet to be served in the priority order.

Input Format

The first line contains an integer, n, describing the total number of events. Each of the n subsequent lines will be of the following two forms:

  *  ENTER name CGPA id: The student to be inserted into the priority queue.
  *  SERVED: The highest priority student in the queue was served.

The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes implementation.

Constraints

  *  2 ≤ n ≤ 1000
  *  0 ≤ CGPA ≤ 4.00
  *  1 ≤ id ≤ 10^5
  *  2 ≤ ∣name∣ ≤ 30

Output Format

The locked stub code prints the names of the students yet to be served in the priority order. If there are no such student, then the code prints EMPTY.

Sample Input 0

12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED

Sample Output 0

Dan
Ashley
Shafaet
Maria

Explanation 0

In this case, the number of events is 12. Let the name of the queue be Q.

  *  John is added to Q. So, it contains (John, 3.75, 50).
  *  Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
  *  Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).
  *  Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).
  *  John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
  *  Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).
  *  Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
  *  Now, four more students are added to Q. So, it contains (Shafaet, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
  *  Anik is served because though both Anil and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. So, Q contains (Dan, 3.95, 50), (Ashley, 3.9, 42), (Shafaet, 3.7, 35), and (Maria, 3.6, 46).

As all events are completed, the name of each of the remaining students is printed on a new line.
*/
/* Solution */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId)
        );
        for (String event : events) {
            String[] parts = event.split("\\s+");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(id, name, cgpa);
                queue.add(student);
            } else if (parts[0].equals("SERVED")) {
                queue.poll();
            }
        }
        List<Student> students = new ArrayList<>(queue);
        students.sort(Comparator.comparing(Student::getCgpa).reversed()
            .thenComparing(Student::getName)
            .thenComparing(Student::getId)
        );
        return students;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}


