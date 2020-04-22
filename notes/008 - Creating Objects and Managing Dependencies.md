# 8 - Creating Objects and Managing Dependencies

In this chapter we look at several patterns for creating objects, which help improve clarity, reliability or flexibility.

## Factory Method Pattern
Add factory method to a class instead of a constructor. This is a static method that internally calls the constructor and returns an the object. We may have many different factory methods with different names. To prevent the use of the new operator, we can make constructors private. This method can also be useful if we want to offer a menu of configurations, but not give the caller free reign to specify any parameters they like.

```java
class VirtualMachine {
  private final int cores;
  private final int ram;
  private final int disk;

  private VirtualMachine(int cores, int ram, int disk){
    this.cores = cores;
    this.ram = ram;
    this.disk = disk;
  }

  public static VirtualMachine optimizedForHighMemory(){
    return new VirtualMachine(2,64,128)
  }

  public static VirtualMachine optimizedForHighMemory(){
    return new VirtualMachine(2,64,128)
  }
}

// how to create a new vm?
VirtualMachine vm1 = VirtualMachine.optimizedForHighMemory();
```

## Factory Class/Object Pattern

This design pattern is used to **defer the decision about the exact type** of the object that is to be created until runtime. We can use some property only known or calculated at runtime (such as here the country in which the application is running) to determine which subtype of the required type to create and return for the client to use polymorphically. This gives more flexibility than just using the new operator.

```java
class LogoFactory{
  static Logo createLogo(){
    if (config.country().equals(Country.UK)){
      return new FlagLogo("Union Jack");
    }
    if (config.country().equals(Country.USA)){
      return new FlagLogo("Stars and Stripes");
    }
    return new DefaultLogo
  }

  class FlagLogo implements Logo {...}
  class DefaultLogo implements Logo {...}
}
```

## Abstract Factory Pattern

When we have a family of different (but related) objects to create, and the exact types for each depend on the same condition. In Abstract Factory Pattern, we create a type hierarchy including different types of factories. Then we instantiate a particular factory and use that factory everywhere we need to create a widget.

```java
interface WidgetFactory {
  Widget createScrollBar();
  Widget creatMenu();
  ...
}

class AndroidMobukeWidgetFactory implements WidgetFactory {
  @Override
  public Widget createScrollBar(){
    return new MobileScrollBar(Color.GREEN);
  }

  @Override
  public Widget createMenu(){
    return new MobileMenu(5);
  }
  ...
}

class DesktopWidgetFactory implements WidgetFactory {
  @Override
  public Widget createScrollBar(){
    ...
  }
  ...
}
```

## Builder Pattern

Builder is an object separate from the one being created that takes responsibility for gathering configuration parameters, and then once all of that information has been collected producing a fully formed object in a valid state.

```java
public class BananaBuilder {
  private double ripeness = 0.0;
  private double curve = 0.5;

  // private constructor enforces that builder itself is
  // created using factory method
  private BananaBuilder(){}

  public static BananaBuilder aBanana(){
    return new BananaBuilder();
  }

  public Banana build(){
    Banana banana = new Banana(curve);
    banana.ripen(ripeness);
    return banana;
  }

  public BananaBuilder withRipeness(double ripeness){
    this.ripeness = ripeness;
    // configuration methods return 'this', giving a fluent
    // interface which allows method chaining
    return this;
  }

  public BananaBuilder withCurve(double curve){
    this.curve = curve;
    return this;
  }
}
```

```java
import static BananaBuilder.*;

public class FruitBasket {
  Banana banana = aBanana().withRipeness(2.0).withCurve(0.9).build();
}
```

## Singleton Pattern

The aim of the singleton pattern is to ensure that we only have one instance of a particular object in our system. In practice this is a much overused pattern, we should be careful where we use it.

```java
  public class BankAccountStore{
    private static BankAccountStore instance = new BankAccountStore();

    // Private constructor enforces that no-one else can call new BankAccountStore()
    private BankAccountStore(){
      //initialise accounts, etc.
    }

    // clients call getInstance() method to gain
    // access to the global instance
    public static BankAccountStore getInstance(){
      return instance;
    }
  }
```

Sometimes we want to initialise the singleton lazily, perhaps because doing so is very expensive and we don't want to di it until we need it. In that case we can use the design below. What happens if two threads enter the getInstance() method at the same time. To prevent this race condition where multiple instances are created, we have to make this method synchronised.

```java
  public class BankAccountStore{
    //don't initialise singleton on class load
    private static BankAccountStore instance;

    private BankAccountStore(){
      //initialise accounts, etc.
    }

    //make this method synchronised to avoid race condition
    public static synchronized BankAccountStore getInstance(){
      //create instance first time anyone calls getInstance()
      if(instance==null){
        instance = new BankAccountStore();
      }
      return instance;
    }
  }
```

Using a singleton can make it very difficult to re-use the calling code, or to swap out the implementation of the collaborators.
