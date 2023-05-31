package com.patterns.behavioural;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Observable;

public class ObserverPattern {

	public static void main(String[] args) {
        Subject product=new Product("36 inch LED TV",new BigDecimal(350));
        Observer bidder1=new Bidder("Alex Parker");
        Observer bidder2=new Bidder("Henry Smith");
        Observer bidder3=new Bidder("Mary Peterson");
        product.registerObserver(bidder1);
        product.registerObserver(bidder2);
        product.registerObserver(bidder3);
        product.setBidAmount(bidder1, new BigDecimal(375));
        product.removeObserver(bidder2);
        product.setBidAmount(bidder3, new BigDecimal(400));

        
//        Product product=new Product("L340 Digital Camera",new BigDecimal(325));
//        Bidder bidder1=new Bidder("Shally Ferguson");
//        Bidder bidder2=new Bidder("Dwayne Bravo");
//        Bidder bidder3=new Bidder("Craig Dawson");
//        product.addObserver(bidder1);
//        product.addObserver(bidder2);
//        product.addObserver(bidder3);
//        product.setBidAmount(bidder1, new BigDecimal(350));
//        product.deleteObserver(bidder2);
//        product.setBidAmount(bidder3, new BigDecimal(375));
	}

}

/*
 * Subject
 * Provides an interface to attach and detach Observer objects.
 */
interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void setBidAmount(Observer observer,BigDecimal newBidAmount);
}

/*
 * Concrete Subject
 * Implements the Subject interface. 
 * A ConcreteSubject sends notification to Observer objects when its state change.
 */
class Product implements Subject{
    private ArrayList<Observer> observers = new ArrayList<>();
    private String productName;
    private BigDecimal bidAmount;
    private Observer observer;
    public Product(String productName, BigDecimal bidAmount){
        this.productName=productName;
        this.bidAmount=bidAmount;
    }
    @Override
    public void setBidAmount(Observer observer,BigDecimal newBidAmount){
        int res=bidAmount.compareTo(newBidAmount);
        if(res==-1){
            this.observer=observer;
            this.bidAmount=newBidAmount;
            notifyObservers();
        }
        else {
            System.out.println("New bid amount cannot be less or equal to current bid amount: "+this.bidAmount);
        }
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("-----------------"+observer+" has withdrawn from bidding----------------");
    }
    @Override
    public void notifyObservers() {
        System.out.println("-----------------New bid placed----------------");
        for (Observer ob : observers) {
            ob.update(this.observer,this.productName,this.bidAmount );
        }
    }
}

/*
 * Observer
 * Provides an interface for objects that should be notified of changes in a Subject
 */
interface Observer {
    public void update(Observer observer,String productName, BigDecimal bidAmount);
  }

/*
 * Concrete Observer
 * Implements Observer to receive notifications from the Subject and keep its state consistent with the state of the Subject
 */
class Bidder implements Observer{
    String bidderName;
    public Bidder(String bidderName) {
        this.bidderName = bidderName;
    }
    @Override
    public void update(Observer observer,String productName, BigDecimal bidAmount){
        if(observer.toString().equals(bidderName)){
            System.out.println("Hello "+bidderName+"! New bid of amount "+bidAmount+" has been placed on "+productName+" by you");
        }
        if(!observer.toString().equals(bidderName)) {
            System.out.println("Hello " + bidderName + "! New bid of amount " + bidAmount + " has been placed on " + productName + " by " + observer);
        }
    }
    @Override
    public String toString(){
        return bidderName;
    }
}

/*
 * Using Java's observable and observer classes
 */

//class Product extends Observable{
//    private String productName;
//    private BigDecimal bidAmount;
//    private Observer observer;
//    public Observer getObserver() {
//        return observer;
//    }
//    public BigDecimal getBidAmount() {
//        return bidAmount;
//    }
//    public String getProductName() {
//        return productName;
//    }
//    public Product(String productName, BigDecimal bidAmount){
//        this.productName=productName;
//        this.bidAmount=bidAmount;
//    }
//    public void setBidAmount(Observer observer,BigDecimal newBidAmount){
//        System.out.println("-----------------New bid placed----------------");
//        int res=bidAmount.compareTo(newBidAmount);
//        if(res==-1){
//            this.observer=observer;
//            this.bidAmount=newBidAmount;
//            setChanged();
//            notifyObservers();
//        }
//        else {
//            System.out.println("New bid amount cannot be less or equal to current bid amount: "+this.bidAmount);
//        }
//    }
//}
//
//class Bidder implements Observer {
//    Product observable;
//    String bidderName;
//    public Bidder(String bidderName) {
//        this.bidderName = bidderName;
//    }
//    @Override
//    public void update(Observable observable, Object arg){
//        this.observable = (Product) observable;
//        String name = this.observable.getObserver().toString();
//        if(name.equals(bidderName))
//        {
//            System.out.println("Hello "+bidderName+"! New bid of amount "+this.observable.getBidAmount()+" has been placed on "+this.observable.getProductName()+" by you");
//        }
//        if (!name.equals(bidderName))
//            System.out.println("Hello "+bidderName+"! New bid of amount "+this.observable.getBidAmount()+" has been placed on "+this.observable.getProductName()+" by "+this.observable.getObserver());
//    }
//    @Override
//    public String toString()
//    {
//        return bidderName;
//    }
//    }
