#  Operators

Java provides a rich set of operators to manipulate variables. We can divide all the Java operators into the following groups:

* Arithmetic Operators
* Relational Operators
* Bitwise Operators
* Logical Operators
* Assignment Operators
* Misc Operators

## The Arithmetic Operators
Arithmetic operators are used in mathematical expressions in the same way that they are used in algebra.

The following table lists the arithmetic operators:

<table>
  <tbody>
  <tr>
    <td>Operator</td>
    <td>Description</td>
    <td>Example</td>
  </tr>
  <tr>
    <td>+ (Addition)</td>
    <td>Adds values on either side of the operator</td>
    <td>10 + 20 -&gt; 30</td>
  </tr>
  <tr>
    <td>- (Subtraction)</td>
    <td>Subtracts right hand operand from left hand operand</td>
    <td>10 - 20&nbsp;-&gt; -10</td>
  </tr>
  <tr>
    <td>* ( Multiplication )</td>
    <td>Multiplies values on either side of the operator</td>
    <td>10 *&nbsp;20&nbsp;-&gt; 200</td>
  </tr>
  <tr>
    <td>/ (Division)</td>
    <td>Divides left hand operand by right hand operand</td>
    <td>20 / 10 -&gt; 2</td>
  </tr>
  <tr>
    <td>% (Modulus)</td>
    <td>Divides left hand operand by right hand operand and returns remainder</td>
    <td>7&nbsp;% 3 -&gt;&nbsp;1</td>
  </tr>
  <tr>
    <td>++ (Increment)</td>
    <td>Increases the value of operand by 1</td>
    <td>
      <p>a = 20</p>

      <p>a++ -&gt; 21</p>
    </td>
  </tr>
  <tr>
    <td>-- ( Decrement )</td>
    <td>Decreases the value of operand by 1</td>
    <td>
      <p>a = 20</p>

      <p>a-- -&gt; 19</p>
    </td>
  </tr>
  </tbody>
</table>

## The Relational Operators

There are following relational operators supported by Java language

== (equal to)
Checks if the values of two operands are equal or not, if yes then condition becomes true.

Example: (A == B) is not true.
2	!= (not equal to)
Checks if the values of two operands are equal or not, if values are not equal then condition becomes true.

Example: (A != B) is true.

3	> (greater than)
Checks if the value of left operand is greater than the value of right operand, if yes then condition becomes true.

Example: (A > B) is not true.
4	< (less than)
Checks if the value of left operand is less than the value of right operand, if yes then condition becomes true.

Example: (A < B) is true.
5	>= (greater than or equal to)
Checks if the value of left operand is greater than or equal to the value of right operand, if yes then condition becomes true.

Example (A >= B) is not true.
6	<= (less than or equal to)
Checks if the value of left operand is less than or equal to the value of right operand, if yes then condition becomes true.

example(A <= B) is true.

## The Bitwise Operators

Java defines several bitwise operators, which can be applied to the integer types, long, int, short, char, and byte.

Bitwise operator works on bits and performs bit-by-bit operation. Assume if a = 60; and b = 13; now in binary format they will be as follows:

a = 0011 1100

b = 0000 1101

-----------------

a&b = 0000 1100

a|b = 0011 1101

a^b = 0011 0001

~a  = 1100 0011

The following table lists the bitwise operators:

Assume integer variable A holds 60 and variable B holds 13 then:

& (bitwise and)
Binary AND Operator copies a bit to the result if it exists in both operands.

Example: (A & B) will give 12 which is 0000 1100
2	| (bitwise or)
Binary OR Operator copies a bit if it exists in either operand.

Example: (A | B) will give 61 which is 0011 1101
3	^ (bitwise XOR)
Binary XOR Operator copies the bit if it is set in one operand but not both.

Example: (A ^ B) will give 49 which is 0011 0001
4	~ (bitwise compliment)
Binary Ones Complement Operator is unary and has the effect of 'flipping' bits.

Example: (~A ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.
5	<< (left shift)
Binary Left Shift Operator. The left operands value is moved left by the number of bits specified by the right operand

Example: A << 2 will give 240 which is 1111 0000
6	>> (right shift)
Binary Right Shift Operator. The left operands value is moved right by the number of bits specified by the right operand.

Example: A >> 2 will give 15 which is 1111
7	>>> (zero fill right shift)
Shift right zero fill operator. The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.

Example: A >>>2 will give 15 which is 0000 1111

##  The Logical Operators

The following table lists the logical operators:

Assume Boolean variables A holds true and variable B holds false, then:

&& (logical and)
Called Logical AND operator. If both the operands are non-zero, then the condition becomes true.

Example (A && B) is false.
2	|| (logical or)
Called Logical OR Operator. If any of the two operands are non-zero, then the condition becomes true.

Example (A || B) is true.
3	! (logical not)
Called Logical NOT Operator. Use to reverses the logical state of its operand. If a condition is true then Logical NOT operator will make false.

Example !(A && B) is true.

## The Assignment Operators
There are following assignment operators supported by Java language:

Show Examples

SR.NO	Operator and Description
1	=
Simple assignment operator, Assigns values from right side operands to left side operand.

Example: C = A + B will assign value of A + B into C
2	+=
Add AND assignment operator, It adds right operand to the left operand and assign the result to left operand.

Example: C += A is equivalent to C = C + A
3	-=
Subtract AND assignment operator, It subtracts right operand from the left operand and assign the result to left operand.

Example:C -= A is equivalent to C = C - A
4	*=
Multiply AND assignment operator, It multiplies right operand with the left operand and assign the result to left operand.

Example: C *= A is equivalent to C = C * A
5	/=
Divide AND assignment operator, It divides left operand with the right operand and assign the result to left operand

ExampleC /= A is equivalent to C = C / A
6	%=
Modulus AND assignment operator, It takes modulus using two operands and assign the result to left operand.

Example: C %= A is equivalent to C = C % A
7	<<=
Left shift AND assignment operator.

ExampleC <<= 2 is same as C = C << 2
8	>>=
Right shift AND assignment operator

Example C >>= 2 is same as C = C >> 2
9	&=
Bitwise AND assignment operator.

Example: C &= 2 is same as C = C & 2
10	^=
bitwise exclusive OR and assignment operator.

Example: C ^= 2 is same as C = C ^ 2
11	|=
bitwise inclusive OR and assignment operator.

Example: C |= 2 is same as C = C | 2

## Miscellaneous Operators
There are few other operators supported by Java Language.

Conditional Operator ( ? : )
Conditional operator is also known as the ternary operator. This operator consists of three operands and is used to evaluate Boolean expressions. The goal of the operator is to decide which value should be assigned to the variable. The operator is written as:

variable x = (expression) ? value if true : value if false
Following is the example:

public class Test {

   public static void main(String args[]){
      int a, b;
      a = 10;
      b = (a == 1) ? 20: 30;
      System.out.println( "Value of b is : " +  b );

      b = (a == 10) ? 20: 30;
      System.out.println( "Value of b is : " + b );
   }
}
This would produce the following result ?

Value of b is : 30
Value of b is : 20

##  Precedence of Operators
Operator precedence determines the grouping of terms in an expression. This affects how an expression is evaluated. Certain operators have higher precedence than others; for example, the multiplication operator has higher precedence than the addition operator:

For example, x = 7 + 3 * 2; here x is assigned 13, not 20 because operator * has higher precedence than +, so it first gets multiplied with 3*2 and then adds into 7.

Here, operators with the highest precedence appear at the top of the table, those with the lowest appear at the bottom. Within an expression, higher precedence operators will be evaluated first.

Category 	Operator 	Associativity 
Postfix 	() [] . (dot operator)	Left toright 
Unary 	++ - - ! ~	Right to left 
Multiplicative  	* / % 	Left to right 
Additive  	+ - 	Left to right 
Shift  	>> >>> <<  	Left to right 
Relational  	> >= < <=  	Left to right 
Equality  	== != 	Left to right 
Bitwise AND 	& 	Left to right 
Bitwise XOR 	^ 	Left to right 
Bitwise OR 	| 	Left to right 
Logical AND 	&& 	Left to right 
Logical OR 	|| 	Left to right 
Conditional 	?: 	Right to left 
Assignment 	= += -= *= /= %= >>= <<= &= ^= |= 	Right to left 