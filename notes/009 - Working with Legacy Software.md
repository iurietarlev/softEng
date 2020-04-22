# 9 - Working with Legacy Software

Legacy systems are often associated as:

- old
- messy
- systems that have no automated tests
- maintenance

## How to deal with legacy code?

1. We want to **discover the structure/architecture of the system**. We want to establish the links between different components that depend on each other. These can be dependencies on external services such as databases, or other services that our system calls or receives messages from. We can try using tools that will analyse the dependencies and show them in a graph.
2. **Preserve Existing Behaviour** - keep stuff that works and don't change too much at any given time. Kepp changes minimal.
3. **Use good tools and techniques for confidence** - we utilise a lot of automated build and testing techniques to try and give us this confidence, when we are making changes. Manual testing is too expensive and error-prone. This is commonly referred to as the _"Test Harness"_.

## Testing the Untestable

Code without tests was normally not designed with testability in mind, and we can find hard to access certain parts of the code that we need in order to create an effective test. On the other hand, if we design the system from the beginning using TDD, it affects the overall design of the system, but in a positive manner.

## Seams and Sensing

In order to test particular units we need to break dependencies so that during the test we can test an isolated unit. Using unit tests we don't want the code we're testing to be writing to database, be sending emails, etc. We can break these dependencies by making use of **seams**. A **seam** is a place where you can alter the behaviour of your program without editing that place.

Every seam must have an _enabling point_. This is the point where you decide to use on behaviour or another. We use the **seam** location to pass in our test implementation, instead of the real implementation of the dependency. This is impossible if the code under test uses the _new_ operator or refers to a _singleton_ instance. At this point we can apply refactoring, by introducing a method parameter or a constructor parameter that allows to pass in a reference to teh dependency from outside. This forms the enabling point for the **seam**, allowing us to switch to our test object instead.

In addition to breaking dependencies using seams, we also want to use our test implementations to help with sensing effects of running our code during the test. If we have code that writes to the database, we would need to query the database to check the correct values were present. This is slow to execute and depends on the state of the database (unreliable for tests). If we replace the dependency on the database with a test implementation, using an object seam, we can add code to our test implementation to allow us to verify what was called on it. An example is axios-mock-adapter in JavaScript for HTTP requests, which you can use to mock your database and specify what should be returned, upon a call to a certain API end-point.
