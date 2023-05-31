package com.patterns.behavioural;

import java.util.ArrayDeque;
import java.util.Deque;

public class MementoPattern {

	public static void main(String[] args) {
        EmpOriginator empOriginator= new EmpOriginator(306,"Mark Ferguson", "131011789610","Sales Manager");
        EmpMemento empMemento=empOriginator.saveToMemento();
        EmpCaretaker empCaretaker=new EmpCaretaker();
        empCaretaker.addMemento(empMemento);
        System.out.println("\n Original EmpOriginator");
        empOriginator.printInfo();
        System.out.println("\n EmpOriginator after updating phone number");
        empOriginator.setEmpPhoneNo("131011888886");
        empMemento=empOriginator.saveToMemento();
        empCaretaker.addMemento(empMemento);
        empOriginator.printInfo();
        System.out.println("\n EmpOriginator after updating designation");
        empOriginator.setEmpDesignation("Senior Sales Manager");
        empMemento=empOriginator.saveToMemento();
        empCaretaker.addMemento(empMemento);
       empOriginator.printInfo();
        System.out.println("\n EmpOriginator after undoing designation update");
        empMemento=empCaretaker.getMemento();
        empOriginator.undoFromMemento(empMemento);
        empMemento=empCaretaker.getMemento();
        empOriginator.undoFromMemento(empMemento);
        empOriginator.printInfo();
        System.out.println("\n Original EmpOriginator after undoing phone number update");
        empMemento=empCaretaker.getMemento();
        empOriginator.undoFromMemento(empMemento);
        empOriginator.printInfo();

	}

}

/*
 * Originator 
 * Is a class the state of whose object needs to be saved. 
 * It creates a Memento containing a snapshot of its current state. 
 * Originator uses the Memento to restore back its state.
 */
class EmpOriginator {
    private int empId;
    private String empName;
    private String empPhoneNo;
    private String empDesignation;
    public EmpOriginator(int empId, String empName, String empPhoneNo,String empDesignation)
    {
        this.empId=empId;
        this.empName=empName;
        this.empPhoneNo=empPhoneNo;
        this.empDesignation=empDesignation;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpPhoneNo() {
        return empPhoneNo;
    }
    public void setEmpPhoneNo(String empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }
    public String getEmpDesignation() {
        return empDesignation;
    }
    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }
    public EmpMemento saveToMemento() {
        EmpMemento empMemento=new EmpMemento(this.empId, this.empName, this.empPhoneNo, this.empDesignation );
        return empMemento;
    }
    public  void undoFromMemento(EmpMemento memento)
    {
        this.empId = memento.getEmpId();
        this.empName = memento.getEmpName();
        this.empPhoneNo = memento.getEmpPhoneNo();
        this.empDesignation = memento.getEmpDesignation();
    }
    public void printInfo()
    {
        System.out.println("ID: "+ this.empId);
        System.out.println("Name: "+ this.empName);
        System.out.println("Phone Number: "+ this.empPhoneNo);
        System.out.println("Designation: "+ this.empDesignation);
    }
}

/*
 * Memento
 * Is a class whose objects stores states of the Originator. 
 * Memento denies other objects access to itself except the Originator.
 */
class EmpMemento {
    private int empId;
    private String empName;
    private String empPhoneNo;
    private String empDesignation;
    public EmpMemento(int empId,String empName,String empPhoneNo,String empDesignation) {
        this.empId = empId;
        this.empName = empName;
        this.empPhoneNo = empPhoneNo;
        this.empDesignation = empDesignation;
    }
   public int getEmpId() {
        return empId;
    }
    public String getEmpName() {
        return empName;
    }
    public String getEmpDesignation() {
        return empDesignation;
    }
    public String getEmpPhoneNo() {
        return empPhoneNo;
    }
    @Override
    public String toString(){
        String str="Current Memento State" + this.empId +" , "+this.empName +" , "+this.getEmpPhoneNo()+" , "+this.getEmpDesignation();
        return str;
    }
    }

/*
 * Caretaker
 * Manages and safeguards Memento.
 */
class EmpCaretaker {
    final Deque<EmpMemento> mementos = new ArrayDeque<>();
    public EmpMemento getMemento()
    {
        EmpMemento empMemento= mementos.pop();
        return empMemento;
    }
    public void addMemento(EmpMemento memento)
    {
        mementos.push(memento);
    }
}