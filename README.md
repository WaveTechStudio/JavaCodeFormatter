# JavaCodeFormatter
Code Formatter, Indent, Parenthesis checker, Code formatting.  

## Prerequisites
Eclipse, Intelli-J Idea

## Features
- Indent code
- Format code
- Check code validations, Braces missing parenthises 

### Implementation

01) JavascriptFormatterRunner (driver)
•	public static void main(String args)
•	Displays menu asking for name of input file
•	Rest of program flow follows the following use case:
1.	User is asked for a file name. Assume for example user enters 'input.js'.
2.	File is read, and formatted internally.
3.	Program prints (to Standard Out) the formatted JavaScript from input and any errors. These errors also print to the console.
4.	Program Exits.

<br/>

01) JavaFormatter
•	private JSStack stack - This is the stack where you will push and pop parentheses and braces.
•	private int indentLevel - This is where you store the number of tab ('\t') characters to print before a line
•	public String format(String input) - this method takes the data from the file and formats it.
•	public JavascriptFormatter() - constructor. Initialize your stack.
JSStack - you may choose to extend or use an existing stack, or implement your own (we suggest using a linked list type structure). This stack will be of BlockType objects. It would be good practice to implement your own.
If you use Java 1.8's stack, you will likely want to read up on generics and this page. You do not need to use the provided name for the stack, but you must have a stack.
Your stack must have these public methods:
•	public void push(BlockType b) - pushes b onto the front of the backing data structure.
•	public BlockType pop() - takes the BlockType that is on top of the backing data structure, saves that value, removes that BlockType from the backing data structure, and returns that BlockType. If the stack was empty, throw an EmptyStackException.
•	public BlockType peek() - takes the BlockType that is on top of the backing data structure, and returns that value to the caller. Does NOT remove that BlockType from the backing data structure.
•	public boolean isEmpty() - returns true if stack is empty, false otherwise.
The details for these methods are standard stack methods. You can find those details in the lecture slides.
enum BlockType
•	BRACE
•	PAREN
•	FOR


### Run the project to check functionality. 

<br/>

### Run the project enter file name to format/validate the code.
<img src="./screens/1.png"/>

<br/>

### Extra brace found.
<img src="./screens/2.png"/>

<br/>

### Extra brace found.
<img src="./screens/3.png"/>

<br/>

### Extra closing parenthises found.
<img src="./screens/4.png"/>
<br/>

## Author
[Waheed Nazir](https://www.linkedin.com/in/waheed-nazir-36521579/ "Waheed Nazir (WaveTechStudio)")

## License
It is totally free to use. :)

