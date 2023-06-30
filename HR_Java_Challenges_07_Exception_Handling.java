/* HackerRank - Java - Challenges - VII - Advanced - Java 8 */


/* 1. Advanced - Java Varargs - Simple Addition */
/*
You are given a class Solution and its main method in the editor.
Your task is to create the class Add and the required methods so that the code prints the sum of the numbers passed to the function add.

Note: Your add method in the Add class must print the sum as given in the Sample Output

Input Format

There are six lines of input, each containing an integer.

Output Format

There will be only four lines of output. Each line contains the sum of the integers passed as the parameters to add in the main method.

Sample Input

1
2
3
4
5
6

Sample Output

1+2=3
1+2+3=6
1+2+3+4+5=15
1+2+3+4+5+6=21

*/
/* Solution */

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Write your code here
class Add{
    public void add(int ... integers){
        if(integers.length>1){
            int sum = integers[0];
            String output = String.valueOf(integers[0]);
            for(int i=1;i<integers.length;i++){
                sum +=integers[i];
                output += "+" + integers[i]; 
            }
            output +="="+sum;
            System.out.println(output);
        }
    }
}

public class Solution {

    public static void main(String[] args) {
       try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			int n6=Integer.parseInt(br.readLine());
			Add ob=new Add();
			ob.add(n1,n2);
			ob.add(n1,n2,n3);
			ob.add(n1,n2,n3,n4,n5);	
			ob.add(n1,n2,n3,n4,n5,n6);
			Method[] methods=Add.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());
				
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}


/* 2. Advanced - Java Reflection - Attributes */
/*
JAVA reflection is a very powerful tool to inspect the attributes of a class in runtime. For example, we can retrieve the list of public fields of a class using getDeclaredMethods().

In this problem, you will be given a class Solution in the editor. You have to fill in the incompleted lines so that it prints all the methods of another class called Student in alphabetical order. We will append your code with the Student class before running it. The Student class looks like this:

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }
    ......
    ......
    some more methods
    ......
}

You have to print all the methods of the student class in alphabetical order like this:

anothermethod
getName
setEmail
setId
......
......
some more methods
......

There is no sample input/output for this problem. If you press "Run Code", it will compile it, but it won't show any outputs.

Hint: See the oracle docs for more details about JAVA Reflection Methods and Fields (https://docs.oracle.com/javase/tutorial/reflect/class/classMembers.html)
*/
/* Solution */

import java.lang.reflect.*;
import java.util.*;

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

class Solution {
    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}


/* 3. Advanced - Can You Access? */
/*
You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer num as input. The powerof2 in class Inner.Private checks whether a number is a power of 2. You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.

Constraints

  *  1 ≤ num ≤ 2^30

Sample Input

8

Sample Output

8 is power of 2
An instance of class: Solution.Inner.Private has been created

*/
/* Solution */

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;


public class Solution {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();	

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            o = new Inner().new Private();
            String r = ((Inner.Private)o).powerof2(num);
            
            System.out.println(num + " is " + r); ;
		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
		}//end of try
		
		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner
	
}//end of Solution

class DoNotTerminate { //This class prevents exit(0)
	 
    public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
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
	

/* 4. Advanced - Prime Checker */
/*
You are given a class Solution and its main method in the editor. Your task is to create a class Prime. The class Prime should contain a single method checkPrime.

The locked code in the editor will call the checkPrime method with one or more integer arguments. You should write the checkPrime method in such a way that the code prints only the prime numbers (https://en.wikipedia.org/wiki/Prime_number).

Please read the code given in the editor carefully. Also please do not use method overloading!

Note: You may get a compile time error in this problem due to the statement below:

  BufferedReader br=new BufferedReader(new InputStreamReader(in));

This was added intentionally, and you have to figure out a way to get rid of the error.

Input Format

There are only five lines of input, each containing one integer.

Output Format

There will be only four lines of output. Each line contains only prime numbers depending upon the parameters passed to checkPrime in the main method of the class Solution. In case there is no prime number, then a blank line should be printed.

Sample Input

2
1
3
4
5

Sample Output

2 
2 
2 3 
2 3 5 

*/
/* Solution */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Prime prime = new Prime();
        int n1 = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());
        int n3 = Integer.parseInt(sc.nextLine());
        int n4 = Integer.parseInt(sc.nextLine());
        int n5 = Integer.parseInt(sc.nextLine());
        
        prime.checkPrime(n1);
        prime.checkPrime(n1,n2);
        prime.checkPrime(n1,n2,n3);
        prime.checkPrime(n1,n2,n3,n4,n5);
    }
}

class Prime{
    void checkPrime(int ... a){
        outer: 
        for(int i=0;i<a.length;i++){
           
            if(a[i] == 1){
                continue;
            }
            for(int j=2;j<a[i]; j++){
                
                if(a[i]%j==0){
                    continue outer;
                }
            }
            System.out.print(a[i]+" ");
        }
        System.out.print("\n");
    }
}


/* 5. Advanced - Java Factory Pattern */
/*
According to Wikipedia, a factory is simply an object that returns another object from some other method call, which is assumed to be "new".

In this problem, you are given an interface Food. There are two classes Pizza and Cake which implement the Food interface, and they both contain a method getType().

The main function in the Main class creates an instance of the FoodFactory class. The FoodFactory class contains a method getFood(String) that returns a new instance of Pizza or Cake according to its parameter.

You are given the partially completed code in the editor. Please complete the FoodFactory class.

Sample Input 1

cake

Sample Output 1

The factory returned class Cake
Someone ordered a Dessert!

Sample Input 2

pizza

Sample Output 2

The factory returned class Pizza
Someone ordered Fast Food!

*/
/* Solution */

import java.util.*;
import java.security.*;
interface Food {
	 public String getType();
	}
	class Pizza implements Food {
	 public String getType() {
	 return "Someone ordered a Fast Food!";
	 }
	}

	class Cake implements Food {

	 public String getType() {
	 return "Someone ordered a Dessert!";
	 }
	}
	class FoodFactory {
		public Food getFood(String order) {
            		//Write your code here
            		return ((order.equalsIgnoreCase("cake")) ? new Cake() : new Pizza());
		}//End of getFood method

	}//End of factory class

	public class Solution {

	 public static void main(String args[]){
			Do_Not_Terminate.forbidExit();

		try{

			Scanner sc=new Scanner(System.in);
			//creating the factory
			FoodFactory foodFactory = new FoodFactory();
	
			//factory instantiates an object
			Food food = foodFactory.getFood(sc.nextLine());
	
			
			System.out.println("The factory returned "+food.getClass());
			System.out.println(food.getType());
		}
		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	 }

	}
	class Do_Not_Terminate {
		 
	    public static class ExitTrappedException extends SecurityException {

			private static final long serialVersionUID = 1L;
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


/* 6. Advanced - Java Singleton Pattern */
/*
    "The singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system."
    - Wikipedia: Singleton Pattern (https://en.wikipedia.org/wiki/Singleton_pattern)

Complete the Singleton class in your editor which contains the following components:

  1.  A private Singleton non parameterized constructor.
  2.  A public String instance variable named str.
  3.  Write a static method named getSingleInstance that returns the single instance of the Singleton class.

Once submitted, our hidden Solution class will check your code by taking a String as input and then using your Singleton class to print a line.

Input Format

You will not be handling any input in this challenge.

Output Format

You will not be producing any output in this challenge.

Sample Input

hello world

Sample Output

Hello I am a singleton! Let me say hello world to you

*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    private static Singleton instance = null;
    private Singleton() {}
    public String str;
    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


/* 7. Advanced - Java Visitor Pattern */
/*
Note: In this problem you must NOT generate any output on your own. Any such solution will be considered as being against the rules and its author will be disqualified. The output of your solution must be generated by the uneditable code provided for you in the solution template.

An important concept in Object-Oriented Programming is the open/closed principle (https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle), which means writing code that is open to extension but closed to modification. In other words, new functionality should be added by writing an extension for the existing code rather than modifying it and potentially breaking other code that uses it. This challenge simulates a real-life problem where the open/closed principle can and should be applied.

A Tree class implementing a rooted tree is provided in the editor. It has the following publicly available methods:

  *  getValue(): Returns the value stored in the node.
  *  getColor(): Returns the color of the node.
  *  getDepth(): Returns the depth (https://en.wikipedia.org/wiki/Tree_%28data_structure%29#Terminologies_used_in_Trees) of the node. Recall that the depth of a node is the number of edges between the node and the tree's root, so the tree's root has depth 0 and each descendant node's depth is equal to the depth of its parent node +1.

In this challenge, we treat the internal implementation of the tree as being closed to modification, so we cannot directly modify it; however, as with real-world situations, the implementation is written in such a way that it allows external classes to extend and build upon its functionality. More specifically, it allows objects of the TreeVis class (a Visitor Design Pattern (https://en.wikipedia.org/wiki/Visitor_pattern)) to visit the tree and traverse the tree structure via the accept method.

There are two parts to this challenge.
Part I: Implement Three Different Visitors

Each class has three methods you must write implementations for:

  1.  getResult(): Return an integer denoting the result, which is different for each class:

    *  The SumInLeavesVisitor implementation must return the sum of the values in the tree's leaves only.
    *  The ProductRedNodesVisitor implementation must return the product of values stored in all red nodes, including leaves, computed modulo 10^9 + 7. Note that the product of zero values is equal to 1.
    *  The FancyVisitor implementation must return the absolute difference between the sum of values stored in the tree's non-leaf nodes at even depth and the sum of values stored in the tree's green leaf nodes. Recall that zero is an even number (https://en.wikipedia.org/wiki/Parity_of_zero).

  2.  visitNode(TreeNode node): Implement the logic responsible for visiting the tree's non-leaf nodes such that the getResult method returns the correct result for the implementing class' visitor.
  
  3.  visitLeaf(TreeLeaf leaf): Implement the logic responsible for visiting the tree's leaf nodes such that the getResult method returns the correct result for the implementing class' visitor.

Part II: Read and Build the Tree

Read the n-node tree, where each node is numbered from 1 to n. The tree is given as a list of node values (x_1, x_2, ..., x_n), a list of node colors (c_1, c_2, ..., c_n), and a list of edges. Construct this tree as an instance of the Tree class. The tree is always rooted at node number 1.

Your implementations of the three visitor classes will be tested on the tree you built from the given input.

Input Format

The first line contains a single integer, n, denoting the number of nodes in the tree. The second line contains space-separated integers describing the respective values of x_1, x_2, ..., x_n.

The third line contains n space-separated binary integers describing the respective values of c_1, c_2, ..., c_n. Each c_i denotes the color of the ith node, where 0 denotes red and 1 denotes green.
Each of the n - 1 subsequent lines contains two space-separated integers, u_i and v_i, describing an edge between nodes u_i and v_i.

Constraints

  *  2 ≤ n ≤ 10^5
  *  1 ≤ x_i ≤ 10^3
  *  c ∈ {0, 1}
  *  1 ≤ v_i, u_i ≤ n
  *  It is guaranteed that the tree is rooted at node 1.

Output Format

Do not print anything to stdout, as this is handled by locked stub code in the editor. The three getResult() methods provided for you must return an integer denoting the result for that class' visitor (defined above). Note that the value returned by ProductRedNodesVisitor's getResult method must be computed modulo 10^9 + 7.

Sample Input

5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5

Sample Output

24
40
15

Explanation

[/data/Java_Visitor_Pattern.png]

(https://s3.amazonaws.com/hr-challenge-images/0/1478020575-c0b77f00ab-flexible-tree-visitor-pattern.png)

Locked stub code in the editor tests your three class implementations as follows:

  1.  Creates a SumInLeavesVisitor object whose getResult method returns the sum of the leaves in the tree, which is 7 + 5 + 12 = 24. The locked stub code prints the returned value on a new line.
  2.  Creates a ProductOfRedNodesVisitor object whose getResult method returns the product of the red nodes, which is 4 * 2 * 5 = 40. The locked stub code prints the returned value on a new line.
  3.  Creates a FancyVisitor object whose getResult method returns the absolute difference between the sum of the values of non-leaf nodes at even depth and the sum of the values of green leaf nodes, which is |4 - (7 + 12)| = 15. The locked stub code prints the returned value on a new line.
*/
/* Solution */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;
    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }
    public int getValue() {
        return value;
    }
    public Color getColor() {
        return color;
    }
    public int getDepth() {
        return depth;
    }
    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();
    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }
    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis{
    int result=0;
    public int getResult(){
        return result;
    }
    public void visitNode(TreeNode node){
    }
    public void visitLeaf(TreeLeaf leaf){
        result+=leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis{
    long result=1;
    final int M=1000000007;
    public int getResult(){
        return (int)result;
    }
    public void visitNode(TreeNode node){
        if(node.getColor()==Color.RED){
            result=(result*node.getValue())%M;
        }
    }
    public void visitLeaf(TreeLeaf leaf){
        if(leaf.getColor()==Color.RED){
            result=(result * leaf.getValue())%M;
        }
    }
}

class FancyVisitor extends TreeVis{
    int even=0;
    int green=0;
    public int getResult(){
        return Math.abs(even-green);
    }
    public void visitNode(TreeNode node){
        if(node.getDepth()%2==0){
            even+=node.getValue();
        }
    }
    public void visitLeaf(TreeLeaf leaf){
        if(leaf.getColor()==Color.GREEN){
            green+=leaf.getValue();
        }
    }
}

public class Solution {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    static int values[];
    static Color colors[];
    static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();
    
    public static Tree solve(){
        Scanner in=new Scanner(System.in);
        int nnodes=in.nextInt();
        values= new int[nnodes];
        for(int i=0;i<nnodes;i++)values[i]=in.nextInt();
        colors = new Color[nnodes];
        for(int i=0;i<nnodes;i++)colors[i]=(in.nextInt()==0)?Color.RED:Color.GREEN;
        Tree rootNode;
        if(nnodes==1){
            rootNode=new TreeLeaf(values[0],colors[0],0);
        }else{
            rootNode=new TreeNode(values[0],colors[0],0);
            for(int i=0;i<(nnodes-1);i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                Set<Integer> uEdges = nodesMap.get(u);
                if(uEdges==null)uEdges = new HashSet<>();
                uEdges.add(v);
                nodesMap.put(u, uEdges);
                Set<Integer> vEdges = nodesMap.get(v);
                if(vEdges==null)vEdges = new HashSet<>();
                vEdges.add(u);
                nodesMap.put(v, vEdges);
            }
            for(int nodeid:nodesMap.get(1)){
                nodesMap.get(nodeid).remove(1);
                createEdge(rootNode, nodeid);
            }
        }
        return rootNode;
    }
    
    private static void createEdge(Tree parent,int nodeid){
        Set<Integer> nodeEdges = nodesMap.get(nodeid);
        boolean hasChild = nodeEdges!=null && !nodeEdges.isEmpty();
        if(hasChild){
            TreeNode node = new TreeNode(values[nodeid-1],colors[nodeid-1],parent.getDepth()+1);
            ((TreeNode)parent).addChild(node);
            for(int neighborid:nodeEdges){
                nodesMap.get(neighborid).remove(nodeid);
                createEdge(node, neighborid);
            }
        }else{
            TreeLeaf leaf = new TreeLeaf(values[nodeid-1],colors[nodeid-1],parent.getDepth()+1);
            ((TreeNode)parent).addChild(leaf);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);
        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();
        System.out.println(res1);
         System.out.println(res2);
        System.out.println(res3);
    }
}


/* 8. Advanced - Java Annotations */
/*
Java annotation can be used to define the metadata of a Java class or class element. We can use Java annotation at the compile time to instruct the compiler about the build process. Annotation is also used at runtime to get insight into the properties of class elements.

Java annotation can be added to an element in the following way:

@Entity
Class DemoClass{

}

We can also set a value to the annotation member. For example:

@Entity(EntityName="DemoClass")
Class DemoClass{

}

In Java, there are several built-in annotations. You can also define your own annotations in the following way:

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
   String userRole() default "GUEST";
}

Here, we define an annotation FamilyBudget, where userRole is the only member in that custom annotation. The userRole takes only String type values, and the default is "GUEST". If we do not define the value for this annotation member, then it takes the default. By using @Target, we can specify where our annotation can be used. For example, the FamilyBudget annotation can only be used with the method in a class. @Retention defines whether the annotation is available at runtime. To learn more about Java annotation, you can read the tutorial (https://docs.oracle.com/javase/tutorial/java/annotations/) and oracle docs (https://docs.oracle.com/javase/7/docs/api/java/lang/annotation/RetentionPolicy.html).

Take a look at the following code segment:

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";
}

class FamilyMember {

    public void seniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    public void juniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String role = in.next();
            int spend = in.nextInt();
            try {
                Class annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(FamilyBudget.class)) {
                        FamilyBudget family = method
                                .getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if (userRole.equals(role)) {
                            if(spend<=budgetLimit){
                                method.invoke(FamilyMember.class.newInstance(),
                                        budgetLimit, spend);
                            }else{
                                System.out.println("Budget Limit Over");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            testCases--;
        }
    }
}

Here, we partially define an annotation, FamilyBudget and a class, FamilyMember. In this problem, we give the user role and the amount of money that a user spends as inputs. Based on the user role, you have to call the appropriate method in the FamilyMember class. If the amount of money spent is over the budget limit for that user role, it prints Budget Limit Over.

Your task is to complete the FamilyBudget annotation and the FamilyMember class so that the Solution class works perfectly with the defined constraints.

Note: You must complete the 5 incomplete lines in the editor. You are not allowed to change, delete or modify any other lines. To restore the original code, click on the top-left button on the editor and create a new buffer.

Input Format

The first line of input contains an integer N representing the total number of test cases. Each test case contains a string and an integer separated by a space on a single line in the following format:

UserRole MoneySpend

Constraints

  *  2 ≤ N ≤ 10
  *  0 ≤ MoneySpend ≤ 200
  *  |UserRole| = 6

Name contains only lowercase English letters.

Output Format

Based on the user role and budget outputs, output the contents of the certain method. If the amount of money spent is over the budget limit, then output Budget Limit Over.

Sample Input

3
SENIOR 75
JUNIOR 45
SENIOR 40

Sample Output

Senior Member
Spend: 75
Budget Left: 25
Junior Member
Spend: 45
Budget Left: 5
Senior Member
Spend: 40
Budget Left: 60

*/
/* Solution */

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
	String userRole() default "GUEST";
	int budgetLimit() default 100;
}

class FamilyMember {
	@FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
	public void seniorMember(int budget, int moneySpend) {
		System.out.println("Senior Member");
		System.out.println("Spend: " + moneySpend);
		System.out.println("Budget Left: " + (budget - moneySpend));
	}

	@FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
	public void juniorUser(int budget, int moneySpend) {
		System.out.println("Junior Member");
		System.out.println("Spend: " + moneySpend);
		System.out.println("Budget Left: " + (budget - moneySpend));
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String role = in.next();
			int spend = in.nextInt();
			try {
				Class annotatedClass = FamilyMember.class;
				Method[] methods = annotatedClass.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(FamilyBudget.class)) {
						FamilyBudget family = method
								.getAnnotation(FamilyBudget.class);
						String userRole = family.userRole();
						int budgetLimit = family.budgetLimit();
						if (userRole.equals(role)) {
							if(spend <= budgetLimit){
								method.invoke(FamilyMember.class.newInstance(),
										budgetLimit, spend);
							}else{
								System.out.println("Budget Limit Over");
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			testCases--;
		}
	}
}


/* 9. Advanced - Covariant Return Types */
/*
Java allows for Covariant Return Types (https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html), which means you can vary your return type as long you are returning a subclass of your specified return type.

Method Overriding (https://docs.oracle.com/javase/tutorial/java/IandI/override.html) allows a subclass to override the behavior of an existing superclass method and specify a return type that is some subclass of the original return type. It is best practice to use the @Override annotation (https://docs.oracle.com/javase/tutorial/java/annotations/basics.html) when overriding a superclass method.

Implement the classes and methods detailed in the diagram below:

[/data/Covariant_Return_Types.png]

(https://s3.amazonaws.com/hr-assets/0/1523891844-c66f1555af-class.png)

You will be given a partially completed code in the editor where the main method takes the name of a state (i.e., WestBengal, or AndhraPradesh) and prints the national flower of that state using the classes and methods written by you.

Note: Do not use access modifiers in your class declarations.

Resources

Covariant Return Type (http://wiki.c2.com/?CovariantReturnTypes)
Java Covariant Type (https://blogs.oracle.com/sundararajan/entry/covariant_return_types_in_java)

Input Format

The locked code reads a single string denoting the name of a subclass of State (i.e., WestBengal, Karnataka, or AndhraPradesh), then tests the methods associated with that subclass. You are not responsible for reading any input from stdin.

Output Format

Output is handled for you by the locked code, which creates the object corresponding to the input string's class name and then prints the name returned by that class' national flower's whatsYourName method. You are not responsible for printing anything to stdout.

Sample Input 0

AndhraPradesh

Sample Output 0

Lily

Explanation 0

An AndhraPradesh object's yourNationalFlower method returns an instance of the Lily class, and the Lily class' whatsYourName method returns Lily, which is printed by the hidden code checker.
*/
/* Solution */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {
     String whatsYourName(){
     return  "I have many names and types.";   
    }
}

class Jasmine extends Flower {
    
    @Override
    String whatsYourName(){
        return "Jasmine";
    }
}

class Lily extends Flower{
    
    @Override
    String whatsYourName(){
        return "Lily";
    }
}

class Region  {
    
    Flower yourNationalFlower(){
        return new Flower();
    }
}

class WestBengal extends Region {
    
    @Override
    Jasmine yourNationalFlower(){
        return new Jasmine();
        
    }
}

class AndhraPradesh extends Region{
    
     @Override
    Lily yourNationalFlower(){
        return new Lily();
    }
    
}

public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
      }
      Flower flower = region.yourNationalFlower();
      System.out.println(flower.whatsYourName());
    }
}


/* 10. Advanced - Java Lambda Expressions */
/*
This Java 8 challenge tests your knowledge of Lambda expressions (https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)!

Write the following methods that return a lambda expression performing a specified action:

   1. PerformOperation isOdd(): The lambda expression must return true if a number is odd or false if it is even.
  2.  PerformOperation isPrime(): The lambda expression must return true if a number is prime or false if it is composite.
  3.  PerformOperation isPalindrome(): The lambda expression must return true if a number is a palindrome or false if it is not.

Input Format

Input is handled for you by the locked stub code in your editor.

Output Format

The locked stub code in your editor will print T lines of output.

Sample Input

The first line contains an integer, T (the number of test cases).

The T subsequent lines each describe a test case in the form of 2 space-separated integers:
The first integer specifies the condition to check for (1 for Odd/Even, 2 for Prime, or 3 for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12

Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE

*/
/* Solution */

import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

// Write your code here
PerformOperation isOdd()
   {
       PerformOperation po = (int a)-> a%2 == 0 ? false : true;
       return po;
   }
   PerformOperation isPrime()
   {
       PerformOperation po = (int a)->
       {
           if(a == 1) return true;
           else
           {
               for (int i =  2; i < Math.sqrt(a); i++)
                    if(a%i == 0) return false;
                return true;
           }
       };
       return po;
   }
   PerformOperation isPalindrome()
   {
       ArrayList<Integer> aa = new ArrayList<>();
       PerformOperation po = (int a)->
       {
            String str = Integer.toString(a);
           String reverse = "";
           for(int i = str.length()-1; i >= 0; i--)
           {
               reverse = reverse + str.charAt(i);
           }
           if(reverse.equals(str)) return true;
           return false;
       };
       return po;
   }
}

public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}


/* 11. Advanced - Java MD5 */
/*
MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a 128-bit hash value. Here are some common uses for MD5:

  *  To store a one-way hash of a password.
  *  To provide some assurance that a transferred file has arrived intact.

MD5 is one in a series of message digest algorithms designed by Professor Ronald Rivest of MIT (Rivest, 1994); however, the security of MD5 has been severely compromised, most infamously by the Flame malware in 2012. The CMU Software Engineering Institute essentially considers MD5 to be "cryptographically broken and unsuitable for further use" ().

Given an alphanumeric string, s, denoting a password, compute and print its MD5 encryption value.

Input Format

A single alphanumeric string denoting s.

Constraints

  *  6 ≤ |s| ≤ 20
  *  String s consists of English alphabetic letters (i.e., [a-zA-Z] and/or decimal digits (i.e., 0 through 9) only.

Output Format

Print the MD5 encryption value of

on a new line.

Sample Input 0

HelloWorld

Sample Output 0

68e109f0f40ca72a15e05cc22786f8e6

Sample Input 1

Javarmi123

Sample Output 1

2da2d1e0ce7b4951a858ed2d547ef485

*/
/* Solution */

import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
    	String name = scanner.nextLine();
    	
    	try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
        	byte[] digest = md.digest(name.getBytes());
        	StringBuilder hexString = new StringBuilder();
        	for (byte b : digest) {
            		hexString.append(String.format("%02x", b & 0xff));
        	}
        	System.out.println(hexString.toString());
    	} catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
    	}
    }
}


/* 12. Advanced - Java SHA-256 */
/*
Cryptographic hash functions are mathematical operations run on digital data; by comparing the computed hash (i.e., the output produced by executing a hashing algorithm) to a known and expected hash value, a person can determine the data's integrity. For example, computing the hash of a downloaded file and comparing the result to a previously published hash result can show whether the download has been modified or tampered with. In addition, cryptographic hash functions are extremely collision-resistant; in other words, it should be extremely difficult to produce the same hash output from two different input values using a cryptographic hash function.

Secure Hash Algorithm 2 (SHA-2) is a set of cryptographic hash functions designed by the National Security Agency (NSA). It consists of six identical hashing algorithms (i.e., SHA-256, SHA-512, SHA-224, SHA-384, SHA-512/224, SHA-512/256) with a variable digest size. SHA-256 is a 256-bit (32 byte) hashing algorithm which can calculate a hash code for an input of up to 264 - 1 bits. It undergoes 64 rounds of hashing and calculates a hash code that is a 64-digit hexadecimal number.

Given a string, s, print its SHA-256 hash value.

Input Format

A single alphanumeric string denoting s.

Constraints

  *  6 ≤ |s| ≤ 20
  *  String s consists of English alphabetic letters (i.e., [a-zA-Z] and/or decimal digits (i.e., 0 through 9) only.

Output Format

Print the SHA-256 encryption value of

on a new line.

Sample Input 0

HelloWorld

Sample Output 0

872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4

Sample Input 1

Javarmi123

Sample Output 1

f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678

*/
/* Solution */

import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
        /* Encode the String using SHA-256 */
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        byte[] digest = md.digest();
        /* Print the encoded value in hexadecimal */
        for (byte b : digest) {
            System.out.format("%02x", b);
        }
    }
}


