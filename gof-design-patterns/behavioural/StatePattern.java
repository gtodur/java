package com.patterns.behavioural;

public class StatePattern {

	public static void main(String[] args) {
	       System.out.println("-----Test 1: Testing machine by inserting coin and pressing button-----");
	        CandyVendingMachine machine=new CandyVendingMachine(3);
	        System.out.println(machine);
	        machine.insertCoin();
	        System.out.println(machine);
	        machine.pressButton();
	        System.out.println(machine);
	        System.out.println("-----Test 2: Testing machine by pressing button without inserting coin-----");
	        CandyVendingMachine machine2=new CandyVendingMachine(3);
	        System.out.println(machine2);
	        machine2.pressButton();
	        System.out.println(machine2);
	         System.out.println("-----Test 3: Testing machine running out of candies-----");
	         CandyVendingMachine machine3=new CandyVendingMachine(3);
	         System.out.println(machine3);
	         machine3.insertCoin();
	         machine3.pressButton();
	         machine3.insertCoin();
	         machine3.pressButton();
	         machine3.insertCoin();
	         machine3.pressButton();
	         machine3.insertCoin();
	         machine3.pressButton();
	         System.out.println(machine3);

	}

}

/*
 * State
 * Is an interface that encapsulates the behavior associated with a particular state of the Context.
 */
interface CandyVendingMachineState {
    void insertCoin();
    void pressButton();
    void dispense();
}

/*
 * ConcreteState subclasses
 * Concrete classes that implements a behavior associated with a state of the Context.
 */
class NoCoinState implements CandyVendingMachineState{
    CandyVendingMachine machine;
    public NoCoinState(CandyVendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void insertCoin() {
      machine.setState(machine.getContainsCoinState());
    }
    @Override
    public void pressButton() {
        System.out.println("No coin inserted");
    }
    @Override
    public void dispense() {
        System.out.println("No coin inserted");
    }
    @Override
    public String toString(){
        return "NoCoinState";
    }
}

/*
 * ConcreteState subclasses
 * Concrete classes that implements a behavior associated with a state of the Context.
 */
class ContainsCoinState implements CandyVendingMachineState{
    CandyVendingMachine machine;
    public ContainsCoinState(CandyVendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void insertCoin() {
       System.out.println("Coin already inserted");
    }
    @Override
    public void pressButton() {
       machine.setState(machine.getDispensedState());
    }
    @Override
    public void dispense() {
       System.out.println("Press button to dispense");
    }
    @Override
    public String toString(){
        return "ContainsCoinState";
    }
}

/*
 * ConcreteState subclasses
 * Concrete classes that implements a behavior associated with a state of the Context.
 */
class DispensedState implements CandyVendingMachineState{
    CandyVendingMachine machine;
    public DispensedState(CandyVendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void insertCoin() {
      System.out.println("Error. System is currently dispensing");
    }
    @Override
    public void pressButton() {
        System.out.println("Error. System is currently dispensing");
    }
    @Override
    public void dispense() {
        if(machine.getCount()>0) {
            machine.setState(machine.getNoCoinState());
            machine.setCount(machine.getCount()-1);
        }
        else{
            System.out.println("No candies available");
            machine.setState(machine.getNoCandyState());
        }
    }
    @Override
    public String toString(){
        return "DispensedState";
    }
}

/*
 * ConcreteState subclasses
 * Concrete classes that implements a behavior associated with a state of the Context.
 */
class NoCandyState implements CandyVendingMachineState{
    CandyVendingMachine machine;
    public NoCandyState(CandyVendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void insertCoin() {
     System.out.println("No candies available");
    }
    @Override
    public void pressButton() {
        System.out.println("No candies available");
    }
    @Override
    public void dispense() {
        System.out.println("No candies available");
    }
    @Override
    public String toString(){
        return "NoCandyState";
    }
}

/*
 * Context
 * Provides and interface to client to perform some action and 
 * delegates state specific requests to the ConcreteState subclass that defines the current state.
 */
class CandyVendingMachine {
    CandyVendingMachineState noCoinState;
    CandyVendingMachineState noCandyState;
    CandyVendingMachineState dispensedState;
    CandyVendingMachineState containsCoinState;
    CandyVendingMachineState state;
    int count;
    public CandyVendingMachine(int numberOfCandies){
        count=numberOfCandies;
        noCoinState=new NoCoinState(this);
        noCandyState=new NoCandyState(this);
        dispensedState=new DispensedState(this);
        containsCoinState=new ContainsCoinState(this);
        state = noCoinState;
    }
    public void refillCandy(int count){
        this.count+=count;
        this.state=noCoinState;
    }
    public void ejectCandy(){
        if(count!=0){
            count--;
        }
    }
    public void insertCoin(){
        System.out.println("You inserted a coin.");
        state.insertCoin();
    }
    public void pressButton(){
        System.out.println("You have pressed the button.");
        state.pressButton();
        state.dispense();
    }
    public CandyVendingMachineState getNoCandyState() {
        return noCandyState;
    }
    public void setNoCandyState(CandyVendingMachineState noCandyState) {
        this.noCandyState = noCandyState;
    }
    public CandyVendingMachineState getNoCoinState() {
        return noCoinState;
    }
    public void setNoCoinState(CandyVendingMachineState noCoinState) {
        this.noCoinState = noCoinState;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public CandyVendingMachineState getState() {
        return state;
    }
    public void setState(CandyVendingMachineState state) {
        this.state = state;
    }
    public CandyVendingMachineState getContainsCoinState() {
        return containsCoinState;
    }
    public void setContainsCoinState(CandyVendingMachineState containsCoinState) {
        this.containsCoinState = containsCoinState;
    }
    public CandyVendingMachineState getDispensedState() {
        return dispensedState;
    }
    public void setDispensedState(CandyVendingMachineState dispensedState) {
        this.dispensedState = dispensedState;
    }
    @Override
    public String toString(){
        String machineDef="Current state of machine "+state +". Candies available "+count;
        return machineDef;
    }
}