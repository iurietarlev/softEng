# 3 - Refactoring

## Refactoring Definition

Refactoring - process of improving the design of a piece of code, without changing its behaviour. We can change the way that something is implemented in order to improve the design, but to its clients, it should behave in the same way.

When we are doing TDD we should only refactor in the green state. Then we can use our tests to check that behaviour is preserver before and after our refactoring - we only changed the structure without affecting the behaviour as observer through the public API. In a red state (when any test is failing), we do not have this guarantee, so refactoring is risky. Refactor on green.

## Technical Debt

Often, features are added quickly to a system in an inelegant way (e.g. copy pasting). We often know we should fix it, but we put it off. This way, **technical debt** builds up and if we don't pay it off then our system becomes harder and harder to work with over time.

Sometimes we consciously take on technical dept to meet a deadline, but we must be aware of the costs of leaving teh repayment until later.

## More on refactoring

Refactoring is a technical practice that should be applied **little** and **often** to continuously improve the quality of our design.

Modern development tools have powerful refactoring tools that support perforing many refactorings automatically. More powerful tools are available for statically-typed languages, as the type system gives the tools more information with which they can analyse code.

A set of small transformations can be applied to achieve large refactorings. Using modern tools allows us to do this faster, then by editing program text manually. Different refactorings have names that, like with design patterns, gives us a vocabulary to discuss proposed design changes with fellow engineers.

By continually applying these techniques to make small improvements to our design we keep our system malleable. Ideally we can continue to add features at a constant rate. It is difficult to justify or explain refactoring tasks that are done as big design changes - it also takes longer to achieve them as technical debt builds up.

## Catalogue of refactorings

#### Compose Method

Using this method of refactoring, we can break down the long method into several sub-methods to make it shorter. By composing it into chunks we give ourselves the opportunity to introduce a name for the concept and raise the level of abstraction. This helps to improve clarity. Good IDE tools, especially for statically typed languages can help us perform these transformations.

#### Duplication between classes

If things are similar in two classes, we want to make them exactly the same, exposing duplication, and then refactor it away perhaps into another class. Once the things that are similar are exactly the same, we can use the IDE to apply automated transformations, rather than entering text manually, which can be error prone.

#### Replace Conditionals with Polymorphism

In object-oriented programming we do not like conditional statements. As a caller, I do not want to make a decision based on the information I query from my collaborator - I would ratehr they made the decision and I didn't have to know. Therefore the following:

```java
HeadedLetter letter = new HeadedLetter();

if(letter.isImportant()){
  letter.sendByCourierTo(recipient, address)
} else {
  letter.sendByStandardMailTo(recipient, address)
}
```

Can be refactored into:

```java
HeadedLetter letter = new HeadedLetter();
letter.sendTo(recipient, address);

class HeadedLetter implements Correspondence {
  public void sendTo(Person recipient, Address address){
    if(letter.isImportant()){
      letter.sendByCourierTo(recipient, address)
    } else {
      letter.sendByStandardMailTo(recipient, address)
    }
  }
}

public interface Correspondence {
  void sendTo(Person recipient, Address address)
}
```
