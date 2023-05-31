package com.patterns.creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryMethodPattern {

	public static void main(String[] args) throws IOException {
		GetPlanFactory factory = new GetPlanFactory();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the plan name - ");
		String planName = br.readLine();
		
		System.out.println("Enter number of units -");
		Integer units = Integer.parseInt(br.readLine());
		
		Plan plan = factory.getPlan(planName);
		plan.calculateBill(units);
		
	}

}

class GetPlanFactory {
	
	public Plan getPlan(String planType) {
		if(planType == null) {
			return null;
		}
		switch(planType) {
		case "DOMESTIC" : return new DomesticPlan();
		case "COMMERCIAL" : return new CommercialPlan();
		case "INSTITUTIONAL" : return new DomesticPlan();
		default : return null;
		}
	}
}

abstract class Plan {
	float rate;

	abstract void getRate();
	
	public void calculateBill(int units) {
		System.out.println("Total bill - " + (units * rate));
	}
}

class DomesticPlan extends Plan {
	
	public DomesticPlan() {
		getRate();
	}
	
	@Override
	void getRate() {
		this.rate = 5f;
		
	}
}

class CommercialPlan extends Plan {
	public CommercialPlan() {
		getRate();
	}
	@Override
	void getRate() {
		this.rate = 15f;
		
	}
}

class InstitutionalPlan extends Plan {
	public InstitutionalPlan() {
		getRate();
	}
	@Override
	void getRate() {
		this.rate = 10f;
		
	}
}
