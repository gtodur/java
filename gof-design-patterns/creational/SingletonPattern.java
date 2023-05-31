package com.patterns.creational;

public class SingletonPattern {

	public static void main(String[] args) {
		// Instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance();
 
        // Instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance();
 
        // Instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance();
 
        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                           + x.hashCode());
        System.out.println("Hashcode of y is "
                           + y.hashCode());
        System.out.println("Hashcode of z is "
                           + z.hashCode());
 
        // Condition check
        if (x == y && y == z) {
 
            // Print statement
            System.out.println(
                "Three objects point to the same memory location on the heap i.e, to the same object");
        }
 
        else {
            // Print statement
            System.out.println(
                "Three objects DO NOT point to the same memory location on the heap");
        }

	}

}

class Singleton {
    // Static variable reference of single_instance
    // of type Singleton
    private static Singleton single_instance = null;
 
    // Declaring a variable of type String
    public String s;
 
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private Singleton()
    {
        s = "Hello I am a string part of Singleton class";
    }
 
    // Static method
    // Static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
 
        return single_instance;
    }
}

class EagerSingleton
{
  // public instance initialized when loading the class
  private static final EagerSingleton instance = new EagerSingleton();
 
  private EagerSingleton()
  {
    // private constructor
  }
  public static EagerSingleton getInstance(){
	  //Exceptions cannot be handled here
        return instance;
    }
}

class EagerStaticSingleton
{
  // public instance
  public static EagerStaticSingleton instance;
 
  private EagerStaticSingleton()
  {
    // private constructor
  }
static
  {
    // static block to initialize instance
	//Exceptions can be handled here
    instance = new EagerStaticSingleton();
  }
}


//In multithreaded environment, it may break singleton property
class LazySingleton
{
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static LazySingleton instance;
 
  private LazySingleton()
  {
    // private constructor
  }
 
  //method to return instance of class
  //Exception handling is also possible in method
  public static LazySingleton getInstance()
  {
    if (instance == null)
    {
      // if instance is null, initialize
      instance = new LazySingleton();
    }
    return instance;
  }
}

class LazyThreadSafeSingleton
{
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static LazyThreadSafeSingleton instance;
 
  private LazyThreadSafeSingleton()
  {
    // private constructor
  }
 
 //synchronized method to control simultaneous access
  //method is synchronized so it causes slow performance as multiple threads can’t access it simultaneously.
  synchronized public static LazyThreadSafeSingleton getInstance()
  {
    if (instance == null)
    {
      // if instance is null, initialize
      instance = new LazyThreadSafeSingleton();
    }
    return instance;
  }
}

class LazyThreadSafeDoubleCheckLockSingleton
{
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static LazyThreadSafeDoubleCheckLockSingleton instance;
 
  private LazyThreadSafeDoubleCheckLockSingleton()
  {
    // private constructor
  }
 
  public static LazyThreadSafeDoubleCheckLockSingleton getInstance()
  {
    if (instance == null)
    {
      //synchronized block to remove overhead
      synchronized (LazyThreadSafeDoubleCheckLockSingleton.class)
      {
        if(instance==null)
        {
          // if instance is null, initialize
          instance = new LazyThreadSafeDoubleCheckLockSingleton();
        }
       
      }
    }
    return instance;
  }
}


//concept of inner static classes to use for singleton.
class BillPughSingleton
{
 
  private BillPughSingleton()
  {
    // private constructor
  }
 
  // Inner class to provide instance of class
  //When the singleton class is loaded, inner class is not loaded
  //Lazy initialisation because Inner class is created only when getInstance() method is called
  private static class BillPughSingletonInner
  {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }
 
  public static BillPughSingleton getInstance()
  {
    return BillPughSingletonInner.INSTANCE;
  }
}