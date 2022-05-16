# DECORATOR

Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

- Decorator design pattern is helpful in providing runtime modification abilities and hence more flexible. Its easy to maintain and extend when the number of choices are more.
- The disadvantage of decorator design pattern is that it uses a lot of similar kind of objects (decorators).
- Decorator pattern is used a lot in Java IO classes, such as FileReader, BufferedReader etc.

###Real world example

Suppose a company is making a pizza. Assume they offer four types of pizzas namely Peppy Paneer, Farmhouse, Margherita  and Chicken Fiesta. Initially we just use inheritance and abstract out the common functionality in a Pizza class. 

![alt text](https://media.geeksforgeeks.org/wp-content/uploads/decorePattern-1.png)

Now suppose a new requirement, in addition to a pizza, customer can also ask for several toppings such as Fresh Tomato, Paneer, Jalapeno, Capsicum, Barbeque, etc



What options do we have ? 
1. Create a new subclass for every topping with a pizza. The class diagram would look like
![alt text](https://media.geeksforgeeks.org/wp-content/uploads/decorePattern.png)

2. add instance variables to pizza base class to represent whether or not each pizza has a topping.
![alt text](https://media.geeksforgeeks.org/wp-content/uploads/decorePattern-2.png)

```// Sample getCost() in super class
   public int getCost()
   {
       int totalToppingsCost = 0;
       if (hasJalapeno() )
           totalToppingsCost += jalapenoCost;
       if (hasCapsicum() )
           totalToppingsCost += capsicumCost;
   
       // similarly for other toppings
       return totalToppingsCost;
   }
```

This design looks good at first but lets take a look at the problems associated with it.

- Price changes in toppings will lead to alteration in the existing code.
- New toppings will force us to add new methods and alter getCost() method in superclass.
- For some pizzas, some toppings may not be appropriate yet the subclass inherits them.
- What if customer wants double capsicum or double cheeseburst?


Source: 
- https://www.geeksforgeeks.org/decorator-pattern/?ref=rp 
- https://www.geeksforgeeks.org/the-decorator-pattern-set-2-introduction-and-design/?ref=rp
- https://www.geeksforgeeks.org/decorator-pattern-set-3-coding-the-design/?ref=rp