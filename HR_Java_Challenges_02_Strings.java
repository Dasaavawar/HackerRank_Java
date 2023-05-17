/* HackerRank - Java - Challenges - II - Strings - Java 8 */


/* 1. Strings - Java Strings Introduction */
/*
"A string is traditionally a sequence of characters, either as a literal constant or as some kind of variable." — Wikipedia: String (computer science) (https://en.wikipedia.org/wiki/String_%28computer_science%29)

This exercise is to test your understanding of Java Strings. A sample String declaration:

String myString = "Hello World!"

The elements of a String are called characters. The number of characters in a String is called the length, and it can be retrieved with the String.length() method.

Given two strings of lowercase English letters, A and B, perform the following operations:

  1.  Sum the lengths of A and B.
  2.  Determine if A is lexicographically larger than B (i.e.: does B come before A
in the dictionary?).
  3.  Capitalize the first letter in A and B and print them on a single line, separated by a space.

Input Format

The first line contains a string A. The second line contains another string B. The strings are comprised of only lowercase English letters.

Output Format

There are three lines of output:
For the first line, sum the lengths of A and B.
For the second line, write Yes if A is lexicographically greater than B otherwise print No instead.
For the third line, capitalize the first letter in both A and B and print them on a single line, separated by a space.

Sample Input 0

hello
java

Sample Output 0

9
No
Hello Java

Explanation 0

String A is "hello" and B is "java".

A has a length of 5, and B has a length of 4; the sum of their lengths is 9.
When sorted alphabetically/lexicographically, "hello" precedes "java"; therefore, A is not greater than B and the answer is No.

When you capitalize the first letter of both A and B and then print them separated by a space, you get "Hello Java".
*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println((A.compareTo(B) > 0 ? "Yes" : "No"));
        System.out.print(Character.toUpperCase(A.charAt(0)) + A.substring(1).toLowerCase() + " " + Character.toUpperCase(B.charAt(0)) + B.substring(1).toLowerCase());

        
    }
}


/* 2. Strings - Java Substring */
/*
Given a string, s, and two indices, start and end, print a substring (https://en.wikipedia.org/wiki/Substring) consisting of all characters in the inclusive range from start to end - 1. You'll find the String class' substring method (https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring-int-int-) helpful in completing this challenge.

Input Format

The first line contains a single string denoting s.
The second line contains two space-separated integers denoting the respective values of start and end.

Constraints

  *  1 ≤ |s| ≤ 100
  *  0 ≤ start < end ≤ n
  *  String s consists of English alphabetic letters (i.e., [a-zA-Z]) only.

Output Format

Print the substring in the inclusive range from start to end - 1.

Sample Input

Helloworld
3 7

Sample Output

lowo

Explanation

In the diagram below, the substring is highlighted in green:

[/data/Java_Substring.png]

(https://s3.amazonaws.com/hr-challenge-images/22039/1470896981-637b6a022f-substring.png)
*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        String substring = S.substring(start, end);
        System.out.println(substring);
    }
}


/* 3. Strings - Java Substring Comparisons */
/*
We define the following terms:

  *  Lexicographical Order (https://en.wikipedia.org/wiki/Lexicographic_order), also known as alphabetic or dictionary order, orders characters as follows:

     A < B < ... < Y < Z < a < b < ... < y < z

For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.

  *  A substring (https://en.wikipedia.org/wiki/Substring) of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.

Given a string, s, and an integer, k, complete the function so that it finds the lexicographically smallest and largest substrings of length k.

Function Description

Complete the getSmallestAndLargest function in the editor below.

getSmallestAndLargest has the following parameters:

  *  string s: a string
  *  int k: the length of the substrings to find

Returns

  *  string: the string ' + "\n" + ' where and are the two substrings

Input Format

The first line contains a string denoting s.
The second line contains an integer denoting k.

Constraints

  *  1 ≤ |s| ≤ 1000
  *  s consists of English alphabetic letters only (i.e., [a-zA-Z]).

Sample Input 0

welcometojava
3

Sample Output 0

ava
wel

Explanation 0

String s = "welcometojava" has the following lexicographically-ordered substrings of length k = 3:

["ava", "com", "elc", "eto", "jav", "lco", "met", "oja", "ome", "toj", "wel"]

We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).

The stub code in the editor then prints ava as our first line of output and wel as our second line of output.
*/
/* Solution */

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        for(int i=1;i<s.length()-k+1;i++){
            if(smallest.compareTo(s.substring(i,i+k)) > 0 )
                smallest=s.substring(i,i+k);
            if(largest.compareTo(s.substring(i,i+k)) < 0 )     
                largest=s.substring(i,i+k);
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}


/* 4. Strings - Java String Reverse */
/*
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string A, print Yes if it is a palindrome, print No otherwise.

Constraints

  *  A will consist at most 50 lower case english letters.

Sample Input

madam

Sample Output

Yes

*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        char []s= A.toCharArray();
        int i=0;
        int j=s.length-1;
        while(i<j){
            if(s[i]!=s[j]){
                System.out.println("No");
                return;
            }
            i++;
            j--;
    }
    System.out.println("Yes");
    }
}


/* 5. Strings - Java Anagrams */
/*
Two strings, a and b, are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Function Description

Complete the isAnagram function in the editor.

isAnagram has the following parameters:

  *  string a: the first string
  *  string b: the second string

Returns

  *  boolean: If a and b are case-insensitive anagrams, return true. Otherwise, return false.

Input Format

The first line contains a string a.
The second line contains a string b.

Constraints

  *  1 ≤ length(a), length(b) ≤ 50
  *  Strings a and b consist of English alphabetic characters.
  *  The comparison should NOT be case sensitive.

Sample Input 0

anagram
margana

Sample Output 0

Anagrams

Explanation 0
 Character 	Frequency: anagram 	Frequency: margana 
 A or a 	3 			3 
 G or g 	1 			1 
 N or n 	1 			1 
 M or m 	1 			1 
 R or r 	1 			1 

The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

Sample Input 1

anagramm
marganaa

Sample Output 1

Not Anagrams

Explanation 1
 Character 	Frequency: anagramm 	Frequency: marganaa 
 A or a 	3 			4 
 G or g 	1 			1 
 N or n 	1 			1 
 M or m 	2 			1 
 R or r 	1 			1 

The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".

Sample Input 2

Hello
hello

Sample Output 2

Anagrams

Explanation 2
 Character 	Frequency: Hello 	Frequency: hello 
 E or e 	1 			1 
 H or h 	1 			1 
 L or l 	2 			2 
 O or o 	1 			1 

The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
*/
/* Solution */

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        String s= a.toLowerCase();
        String s1= b.toLowerCase();
        while(s.length()==s1.length()&&s.length()!=0)
        {
            char c= s.charAt(0);
            String a1= s.replace(c+"", "");
            String b1=s1.replace(c+"", "");
            s=a1;
            s1=b1;
        }
        if(s.length()==s1.length()) return true;
        return false;
        }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


/* 6. Strings - Java String Tokens */
/*
Given a string, s, matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

Note: You may find the String.split (https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-) method helpful in completing this challenge.

Input Format

A single string, s.

Constraints

  *  1 ≤ length(s) ≤ 4 * 10^5
  *  s is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).

Output Format

On the first line, print an integer, n, denoting the number of tokens in string s (they do not need to be unique). Next, print each of the n tokens on a new line in the same order as they appear in input string s.

Sample Input

He is a very very good boy, isn't he?

Sample Output

10
He
is
a
very
very
good
boy
isn
t
he

Explanation

We consider a token to be a contiguous segment of alphabetic characters. There are a total of 10 such tokens in string s, and each token is printed in the same order in which it appears in string s.
*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.        
        StringTokenizer st = new StringTokenizer(s," !,?._'@");
        System.out.println(st.countTokens());
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
            }
            
        scan.close();
    }
}


/* 7. Strings - Pattern Syntax Checker */
/*
Using Regex, we can easily match or search for patterns in a text. Before searching for a pattern, we have to specify one using some well-defined syntax.

In this problem, you are given a pattern. You have to check whether the syntax of the given pattern is valid.

Note: In this problem, a regex is only valid if you can compile it using the Pattern.compile (https://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html#compile%28java.lang.String%29) method.

Input Format

The first line of input contains an integer N, denoting the number of test cases. The next N lines contain a string of any printable characters representing the pattern of a regex.

Output Format

For each test case, print Valid if the syntax of the given pattern is correct. Otherwise, print Invalid. Do not print the quotes.

Sample Input

3
([A-Z])(.+)
[AZ[a-z](a-z)
batcatpat(nat

Sample Output

Valid
Invalid
Invalid

*/
/* Solution */

import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
          	//Write your code
              try {
                  Pattern p = Pattern.compile(pattern);
                  if (p != null) 
                  System.out.println("Valid");
              } catch (Exception e) {
                  System.out.println("Invalid");
                  }
                  testCases--;
		}
        in.close();
	}
}


/* 8. Strings - Java Regex */
/*
Write a class called MyRegex which will contain a string pattern. You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address. Use the following definition of an IP address:

IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

Some valid IP address:

000.12.12.034
121.234.12.12
23.45.12.56

Some invalid IP address:

000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip

In this problem you will be provided strings containing any combination of ASCII characters. You have to write a regular expression to find the valid IPs.

Just write the MyRegex class which contains a String pattern. The string should contain the correct regular expression.

(MyRegex class MUST NOT be public)

Sample Input

000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP

Sample Output

true
true
true
false
false
false

*/
/* Solution */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
class MyRegex{
    final String pattern = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])(?:\\.(?!$)|$)){4}$";
}


/* 9. Strings - Java Regex 2 - Duplicate Words */
/*
In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than once, but retain the first occurrence of any case-insensitive repeated word. For example, the words love and to are repeated in the sentence I love Love to To tO code. Can you complete the code in the editor so it will turn I love Love to To tO code into I love to code?

To solve this challenge, complete the following three lines:

  1.  Write a RegEx that will match any repeated word.
  2.  Complete the second compile argument so that the compiled RegEx is case-insensitive.
  3.  Write the two necessary arguments for replaceAll such that each repeated word is replaced with the very first instance the word found in the sentence. It must be the exact first occurrence of the word, as the expected output is case-sensitive.

Note: This challenge uses a custom checker; you will fail the challenge if you modify anything other than the three locations that the comments direct you to complete. To restore the editor's original stub code, create a new buffer by clicking on the branch icon in the top left of the editor.

Input Format

The following input is handled for you the given stub code:

The first line contains an integer, n, denoting the number of sentences.
Each of the n subsequent lines contains a single sentence consisting of English alphabetic letters and whitespace characters.

Constraints

  *  Each sentence consists of at most 10^4 English alphabetic letters and whitespaces.
  *  1 ≤ n ≤ 100

Output Format

Stub code in the editor prints the sentence modified by the replaceAll line to stdout. The modified string must be a modified version of the initial sentence where all repeat occurrences of each word are removed.

Sample Input

5
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB

Sample Output

Goodbye bye world
Sam went to his business
Reya is the best player in eye game
in inthe
Hello Ab

Explanation

  1.  We remove the second occurrence of bye and the second and third occurrences of world from Goodbye bye bye world world world to get Goodbye bye world.
  2.  We remove the second occurrence of went and the second and third occurrences of to from Sam went went to to to his business to get Sam went to his business.
  3.  We remove the second occurrence of is, the second occurrence of the, and the second occurrence of eye from Reya is is the the best player in eye eye game to get Reya is the best player in eye game.
  4.  The sentence in inthe has no repeated words, so we do not modify it.
  5.  We remove the second occurrence of ab from Hello hello Ab aB to get Hello Ab. It's important to note that our matching is case-insensitive, and we specifically retained the first occurrence of the matched word in our final string.
*/
/* Solution */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll("(?i)"+m.group(), m.group(1));
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}


/* 10. Strings - Valid Username Regular Expression */
/*
You are updating the username policy on your company's internal networking platform. According to the policy, a username is considered valid if all the following constraints are satisfied:

  *  The username consists of 8 to 30 characters inclusive. If the username consists of less than 8 or greater than 30 characters, then it is an invalid username.
  *  The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters [a-z], uppercase characters [A-Z], and digits [0-9].
  *  The first character of the username must be an alphabetic character, i.e., either lowercase character [a-z] or uppercase character [A-Z].

 For example:
 Username 	Validity 
 Julia           INVALID; Username length < 8 characters 
 Samantha        VALID 
 Samantha_21     VALID 
 1Samantha       INVALID; Username begins with non-alphabetic character 
 Samantha?10_2A  INVALID; '?' character not allowed 

Update the value of regularExpression field in the UsernameValidator class so that the regular expression only matches with valid usernames.

Input Format

The first line of input contains an integer n, describing the total number of usernames. Each of the next n lines contains a string describing the username. The locked stub code reads the inputs and validates the username.

Constraints

  *  1 ≤ n ≤ 100
  *  The username consists of any printable characters.

Output Format

For each of the usernames, the locked stub code prints Valid if the username is valid; otherwise Invalid each on a new line.

Sample Input 0

8
Julia
Samantha
Samantha_21
1Samantha
Samantha?10_2A
JuliaZ007
Julia@007
_Julia007

Sample Output 0

Invalid
Valid
Valid
Invalid
Invalid
Valid
Invalid
Invalid

Explanation 0

Refer diagram in the challenge statement. 
*/
/* Solution */

import java.util.Scanner;
class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "(^[A-Za-z]\\w{7,29}$)";
}


public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}


/* 11. Strings - Tag Content Extractor */
/*
In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like <tag>contents</tag>. Note that the corresponding end tag starts with a /.

Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:

  1.  The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.

  2.  Tags can be nested, but content between nested tags is considered not valid. For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.

  3.  Tags can consist of any printable characters.

Input Format

The first line of input contains a single integer, N (the number of lines).
The N subsequent lines each contain a line of text.

Constraints

  *  1 ≤ N ≤ 100
  *  Each line contains a maximum of 10^4 printable characters.
  *  The total number of characters in all test cases will not exceed 10^6.

Output Format

For each line, print the content enclosed within valid tags.
If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print None.

Sample Input

4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Sample Output

Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush

*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
            Pattern pattern = Pattern.compile("<([^<>/]+)>([^<>]+)</(\\1)>");
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()) {
                System.out.println(matcher.group(2));
                while(matcher.find()) {
                    System.out.println(matcher.group(2));
                }
            } else {
                System.out.println("None");
            }
			testCases--;
		}
	}
}


