- [Intro](#Intro)
- [Classes & Objects](#Classes&Objects)
- [Inheritance](#Inheritance)
- [Interfaces](#Interfaces)
- [Abstract](#Abstract)
- [Polymorphism](#Polymorphism)



## Intro
Object-oriented programming (OOP) is a programming paradigm that organizes code into objects, which are instances of classes.
## Classes&Objects
- Object is an instance of a class
- Class is a type of object and serves as the blueprint – defining the data which the object stores and the methods for accessing and manipulating the data 

Class has:
- Fields (variables) - represent the data associated with an object of a class
- Methods (instructions) – called to perform actions and can take in arguments(defined) or parameters(undefined)


Modifiers
- Static modifier – its variable is associated with the class as a whole rather than an individual instance of that class eg an object

- Access control modifiers 
  - public( accessible to all classes)
  - private(accessible within the class only)

- Abstract modifier – Java will not allow an instance of an abstract class to be constructed without the abstract method

- Final modifier – a variable that when declared final cannot be assigned a new value

Constructor – a method used to initialise a newly created instance of an class. Each instance variable of the object is initialised. Cannot be static, abstract or final so only modifier applicable are those that affect visibility (public, private)

.this - to store the reference in a variable, to differentiate between the instance variable(outside method scope) and a local variable(within method scope) with the same name

#### POJO Plain Old Java Objects
To create a POJO a class must meet some requirements:
- private properties
- public getters and setters for every property
- An overloaded constructor with no parameters and an empty body
- No additional methods

#### DTO Data Transfer Objects
POJOs that are used to facilitate communication between different parts of our application


## Inheritance


