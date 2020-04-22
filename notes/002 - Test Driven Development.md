# 2 - Test Driven Development (TDD)

## TDD Explained

When following TDD practice, we work in a cycle. The cycle is as follows

- We start by writing a test. We write a test first, before writing the implementation. This helps us specify what we want the code we are bout to write to do.
- Once we have written a test we watch it fail. This is expected as we have not implemented this feature yet.
- Then we write the simplest possible piece of code we can to make the test pass.
- After this we _refactor_ our design to **clean up**, **remove any duplication**, **improve clarity**, etc.
- We begin the cycle again.

When working with unit tests this cycle should be short and provide us very rapid feedback about the code.

TDD is not only about testing. When we write a new test, we are writing an executable specification on how the code should behave, thereby designing it's public API. Next, when we make a new test pass we know that we have software that behaves correctly. To get to this point we have to do some design of the internal logic of the object. Once we get to a green state, with tests passing, we have the opportunity to improve and simplify our design, perhaps improving the structure, removing duplication or increasing the clarity of the code.
The tests give us a safety net to **make changes without breaking functionality**.

## Behaviour Driven Development (BDD)

Using tests, we want to verify teh behaviour of the system. A well-written set of tests acts as an executable specification for the software, and documents the behaviour. It is encouraged to think about the behaviour (rather than implementation detail) when doing TDD.

## Best Practice When Creating tests

We can write our specification first in natural language and then use that to form our test cases and test names (automated tests).

For example, we first define the natural behaviour in natural language for FibonacciSequence:

- defines the first two terms to be one
- has each term equal to the sum of the previous two
- ...

Then we translate this into test cases, as shown below:

```java
public class FibonacciSequenceTest {
  @Test
  public void definesTheFirstTwoTermsToBeOne(){
    ...
  }
  @Test
  public void hasEachtemrEqualToTheSumOfThePreviousTwo(){
    ...
  }
}
```

We step through the specification one line at a time. For each line we add a test, fill it in to make appropriate assertions on the object under test, and then complete the implementation to make it pass. We then assess our current design to see if we can make it simpler or cleaner and tidy it up. Then we repeat the cycle for the next requirement. By following this cycle strictly we make sure that we never add code that isn't being tested.

TDD is practiced widely in current software development. It isn't specific to Java. There are unit testing tools for almost every language, and principles of TDD can be applied to help ensure quality regardless of the language we are working in. Below is an example of Python using pytest:

```python
import pytest

from fibonacci import FibonacciSequence

@pytest.fixture
def sequence():
    return FibonacciSequence()

def test_can_calculate_a_specific_term(sequence):
    assert sequence.term(0)=1
    assert sequence.term(4)=5


def test_allows_iteration(sequence):
    assert sequence.next()=1
    assert sequence.next()=1
    assert sequence.next()=2

```
