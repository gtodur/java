package com.patterns.behavioural;

public class ChainOfResponsibility {

	public static void main(String[] args) {
		AbstractSupportHandler handler=RequestorClient.getHandlerChain();
	      handler.receiveRequest(AbstractSupportHandler.TECHNICAL, " I'm having problem with my internet connectivity.");
	        System.out.println("............................................");
	      handler.receiveRequest(AbstractSupportHandler.BILLING, "Please resend my bill of this month.");
	        System.out.println("............................................");
	      handler.receiveRequest(AbstractSupportHandler.GENERAL, "Please send any other plans for home users.");
	    }

}

abstract class AbstractSupportHandler {
	 
    public static int TECHNICAL = 10;
    public static int BILLING = 20;
    public static int GENERAL = 30;
 
    protected int level;
 
    protected AbstractSupportHandler nextHandler;
    public void setNextHandler(AbstractSupportHandler nextHandler){
        this.nextHandler=nextHandler;
    }
 
    public void receiveRequest(int level, String message){
        if(this.level <= level){
            handleRequest(message);
        }
        if(nextHandler !=null){
            nextHandler.receiveRequest(level, message);
        }
    }
 
    abstract protected void handleRequest(String message);
 
}

class TechnicalSupportHandler extends AbstractSupportHandler {
	 
    public TechnicalSupportHandler(int level){
        this.level = level;
    }
 
    @Override
    protected void handleRequest(String message) {
        System.out.println("TechnicalSupportHandler: Processing request " + message);
 
    }
}

class BillingSupportHandler extends AbstractSupportHandler {
	 
    public BillingSupportHandler(int level){
        this.level = level;
    }
 
        @Override
        protected void handleRequest (String message){
        System.out.println("BillingSupportHandler: Processing request. " + message);
    }
 
}

class GeneralSupportHandler extends AbstractSupportHandler {
	 
    public GeneralSupportHandler(int level){
        this.level = level;
    }
 
    @Override
    protected void handleRequest(String message) {
        System.out.println("GeneralSupportHandler: Processing request. " + message);
 
    }
}

class RequestorClient {
	 
    public  static AbstractSupportHandler getHandlerChain(){
 
 
        AbstractSupportHandler technicalSupportHandler = new TechnicalSupportHandler( AbstractSupportHandler.TECHNICAL);
        AbstractSupportHandler billingSupportHandler = new BillingSupportHandler(  AbstractSupportHandler.BILLING);
        AbstractSupportHandler generalSupportHandler = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);
 
        technicalSupportHandler.setNextHandler(billingSupportHandler);
        billingSupportHandler.setNextHandler(generalSupportHandler);
 
        return technicalSupportHandler;
    }
 
}