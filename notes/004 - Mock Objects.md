# 4 - Mock Objects

Mock Objects is a technique used in TDD. How do we design teh communication between objects in our systems. The interactions between objects is an important facet of the design in an object-oriented system. Alan Kay claims that the messages exchanged between objects are even more important than the internal implementation of any given object.

We often talk of "calling a method", but the way we should really think of this inter-object communication is as "sending a message". We want to give anohter object a task to do something on our behalf. We send it a message asking it to do something for us.

## A web of objects

When we build a system using object-oriented programming, we assemble a web of objects with each representing a thing that participates in some way in the system. The structure in which these objects are connected, and the way that they communicate with each other, forms a key part of the design. When we test the system we often want to test the flow of messages, the interactions between objects, rather than the internals of a specific object.

## UML Diagram

The exchange of messages between objects can be shown in UML diagram. In a UML Diagram:

- **class diagram** shows structural relationships that are always true
- **object diagrams** show a snapshot of the state of a system at a particular point in time
- **sequence diagram** expresses a flow of messages exchanged between objects over time

The **sequence digaram** doesn't reveal much about the state inside of an object, it focuses on the communication between objects.

## Method Invocations

Method invocations fall into two categories:

- **commands**
- **queries**

With **commands**, we ask another object to do something for us. We don't know or care how it does it, we delegate responsibility for the task to another object. We don't get a return value. Commands change the state of the invoked object (or another part of the program).

With **queries**, we ask another object to tell us a value so that we can use it. For example we get the value from a textbox on screen, or the current speed of car. Queries do return a value, but they should have no other side effects on the state of teh invoked object.

## Value Objects

Note that some objects might represent values only (which will be queried by otehr objects). These objects can be tested using the simple state based approach. If we construct a weather report object, we can write tests that make assertions about its `celcius()` and `farenheit()` methods, to check that calculations are done correctly. This doesn't involve interaction with any other objects in the graph.

## Tell don't ask

This is a design principle, where objects send each other messages, requesting certain actions to be carried out, but they do not expect back a return value from those calls. The only calls that should return values are queries, that simply return data and do not cause any other change of state or interaction between objects. Fallowing this style tends to lead to a better object-oriented design.

## Focus on a Single Object

When writing unit tests we are interested in testing one object at a time and if the object has any interactions with other objects, we need to test it in terms of the messages that it sends and receives, not its internal state.

## Collaborate through roles

Object's collaborators play a particular role and have certain resposibility seen by the calling object. In good OO design we can swap in and out any object (perhaps with different implementations) that can play this role. We shouldn't have tight coupling to a particular implementation. In Java interfaces are used to achieve this loose coupling.

## Trigger "inward" arrows from test

When we write a test for an object that normally exists linked in to a web of objects, interacting with its neighbours, we look at two sorts of interactions: messages that go into the object, trigger behaviour and messages that come out.

Any **inbound messages**, we can send from our test code to control the scenario. The test therefore replaces any object that would send a message to object under test.

When we need to detect **outbound messages**, we can do this by replacing collaborators that would recieve the message with a test-double. A special implementation that we use just for the test. These are Mock Objects, and are used in place of the real collaborators during the test. By using mock object framework, we can generate mock objects that implement any given interface using the test infrastructure.
