package com.patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {

	public static void main(String[] args) {
        DesignPattern pattern1 = new DesignPattern("Creational", "Factory Method");
        DesignPattern pattern2 = new DesignPattern("Creational", "Abstract Factory");
        DesignPattern pattern3 = new DesignPattern("Structural", "Adapter");
        DesignPattern pattern4 = new DesignPattern("Structural", "Bridge");
        DesignPattern pattern5 = new DesignPattern("Behavioral", "Chain of Responsibility");
        DesignPattern pattern6 = new DesignPattern("Behavioral", "Iterator");
        PatternAggregate patternAggregate = new PatternAggregateImpl();
        patternAggregate.addPattern(pattern1);
        patternAggregate.addPattern(pattern2);
        patternAggregate.addPattern(pattern3);
        patternAggregate.addPattern(pattern4);
        patternAggregate.addPattern(pattern5);
        patternAggregate.addPattern(pattern6);
        System.out.println("-----Pattern list-----");
        printPatterns(patternAggregate);
        patternAggregate.removePattern(pattern1);
        patternAggregate.removePattern(pattern2);
        System.out.println("-----Pattern list after removal operation-----");
        printPatterns(patternAggregate);
    }
    public static void printPatterns(PatternAggregate patternAggregate){
        PatternIterator patternIterator= patternAggregate.getPatternIterator();
        while(!patternIterator.isLastPattern()){
            DesignPattern designPattern=patternIterator.nextPattern();
            System.out.println(designPattern.getPatternType() + " : " + designPattern.getPatternName());
        }


	}

}

class DesignPattern {
    private String patternType;
    private String patternName;
    public DesignPattern(String patternType, String patternName){
        this.patternType=patternType;
        this.patternName=patternName;
    }
    public String getPatternType() {
        return patternType;
    }
      public String getPatternName() {
          return patternName;
    }
}

/*
 * Aggregate
 * Is an interface that declares the methods to create and return an iterator.
 */
interface PatternAggregate {
    void addPattern(DesignPattern designPattern);
    void removePattern(DesignPattern designPattern);
    PatternIterator getPatternIterator();
}


/*
 * ConcreteAggregate
 * Is a concrete class that implements the Aggregate interface to create and return an iterator.
 */
class PatternAggregateImpl implements PatternAggregate{
    List patternList;
    public PatternAggregateImpl(){
        patternList=new ArrayList();
    }
    @Override
    public void addPattern(DesignPattern designPattern){
        patternList.add(designPattern);
    }
    @Override
    public void removePattern(DesignPattern designPattern){
        patternList.remove(designPattern);
    }
    @Override
    public PatternIterator getPatternIterator(){
        return new PatternIteratorImpl(patternList);
    }
}

/*
 * Iterator
 * Is an interface with methods to allow clients to access and traverse elements.
 */
interface PatternIterator {
    DesignPattern nextPattern();
    boolean isLastPattern();
}

/*
 * ConcreteIterator
 * Is a concrete class that implements the Iterator interface. 
 * Objects of this class keeps track of the elements and implements access and traversal operations on the elements.
 */
class PatternIteratorImpl implements PatternIterator{
    public List patternList;
    int position;
    DesignPattern designPattern;
    public PatternIteratorImpl(List patternList){
        this.patternList=patternList;
    }
    @Override
    public DesignPattern nextPattern(){
        System.out.println("Returning pattern at Position: "+position);
            designPattern=(DesignPattern)patternList.get(position);
            position++;
            return designPattern;
    }
@Override
    public boolean isLastPattern(){
    if(position< patternList.size()){
        return false;
    }
return true;
}
}