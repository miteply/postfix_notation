# Postfix notation

### Requirements
Write a Java program to parse a given CSV file and evaluate each cell by these rules
1. Each cell is an expression in postfix notation. Please refer to the wikipedia page for a
full description.
2. Each number or operation will always be separated by one or more spaces.
3. A cell can refer to another cell, via the LETTER NUMBER notation (A2, B4, etc -
letters refer to columns, numbers to rows).
4. Support the basic arithmetic operators +, -, *, /
The output will be a CSV file of the same dimensions, where each cell is evaluated to its final
value. If any cell is an invalid expression, then for that cell only print #ERR.
For example, the following CSV input:
10, 1 3 +, 2 3 -
b1 b2 *, a1, b1 a2 / c1 +
+, 1 2 3, c3
Might output something like this:
10,4,-1
40,10,-0.9
#ERR,#ERR,#ERR

### Solution
1. Read file and convert each line  into a list.
2. The list item will contain a map identify the row's columns
3. Map key is represented by Alphabetical chars to name the columns and the value map is column value
4.Transform the file rows into a List.
5.Iterate the list, calculate the result and display it.

