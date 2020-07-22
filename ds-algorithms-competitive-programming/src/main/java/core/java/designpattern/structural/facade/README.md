#Facade

Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

![alt text](https://refactoring.guru/images/patterns/diagrams/facade/example-2x.png)


Instead of making your code work with dozens of the framework classes directly, you create a facade class which encapsulates that functionality and hides it from the rest of the code. This structure also helps you to minimize the effort of upgrading to future versions of the framework or replacing it with another one. The only thing you’d need to change in your app would be the implementation of the facade’s methods.

Source: 
- https://refactoring.guru/design-patterns/facade
- https://www.geeksforgeeks.org/facade-design-pattern-introduction/