## Learning-Java
Series of small projects completed in Java to help learn the language (University course).

**A0:** Simple Square object holding MyPoint object as its position and a double describing its length. Learned about getter functions along with invoking inherited object's functions.

**A1:** Simulated [Connect Four](https://en.wikipedia.org/wiki/Connect_Four). Created a HumanPlayer class that takes input from another player. Created an AIPlayer class which makes moves depending on if there are one or more winning moves available for itself or their opponent depending on the state of the board. Blocks opponents winning move or makes a winning move if possible, chooses the latter if both can happen. Both HumanPlayer and AIPlayer are extended from the abstract Player class which has predefined methods and their functionalities that all Players must have (Player() constructor, getName(), and makeMove()).

**A2:** Implemented an MIS (Module Interface Specification, see pages 3-6 of [MIS.pdf](https://github.com/FarzanAli/Learning-Java/blob/main/A2/MIS.pdf)). [A2.txt](https://github.com/FarzanAli/Learning-Java/blob/main/A2/A2.txt) includes a verbal explanation of f4() from [Mystery1.java](https://github.com/FarzanAli/Learning-Java/blob/main/A2/Mystery1.java) and f2() from [Mystery2.java](https://github.com/FarzanAli/Learning-Java/blob/main/A2/Mystery1.java) as required by assignment. This assignment was crucial in learning the importance of an MIS as I used the specified behaviour of a module's access routine to create a working program.

Some learning points I got to take away from this course:
- OOP principles
- Java design patterns
- Software Engineering principles
- Create a module given formal specification
- Write a formal specification given a module
- Understanding different methods of testing and their importance
- Identify and implement appropriate design patterns for a specific problem
