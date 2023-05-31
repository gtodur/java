package com.patterns.structural;

public class FacadePattern {

	public static void main(String[] args) {
        OrderFulfillmentController controller=new OrderFulfillmentController();
        controller.facade=new OrderServiceFacadeImpl();
        controller.orderProduct(9);
        boolean result=controller.orderFulfilled;
        System.out.println("Order fulfilled - " + result);
	}

}

class Product {
    public int productId;
    public String name;
    public Product(){}
    public Product(int productId, String name){
        this.productId=productId;
        this.name=name;
    }
}

class InventoryService {
    public static boolean isAvailable(Product product){
        /*Check Warehouse database for product availability*/
        return true;
    }
}

class PaymentService {
    public static boolean makePayment(){
        /*Connect with payment gateway for payment*/
        return true;
    }
}

class ShippingService {
    public static void shipProduct(Product product){
         /*Connect with external shipment service to ship product*/
    }
}

interface OrderServiceFacade {
    boolean placeOrder(int productId);
}

class OrderServiceFacadeImpl implements OrderServiceFacade{
    public boolean placeOrder(int pId){
        boolean orderFulfilled=false;
        Product product=new Product();
        product.productId=pId;
        if(InventoryService.isAvailable(product))
        {
            System.out.println("Product with ID: "+ product.productId+" is available.");
            boolean paymentConfirmed= PaymentService.makePayment();
            if(paymentConfirmed){
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled=true;
            }
        }
        return orderFulfilled;
    }
}

class OrderFulfillmentController {
    OrderServiceFacade facade;
    boolean orderFulfilled=false;
    public void orderProduct(int productId) {
        orderFulfilled=facade.placeOrder(productId);
        System.out.println("OrderFulfillmentController: Order fulfillment completed. ");
    }
}