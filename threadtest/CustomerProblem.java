package com.threadtest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class customer

{
	customer()
	{}
	public customer(String custName, long purchage) {
		super();
		this.custName = custName;
		this.purchage = purchage;
	}
	private String custName;
	private long purchage;
	private long discount;
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getPurchage() {
		return purchage;
	}
	public void setPurchage(int purchage) {
		this.purchage = purchage;
	}
	
}



public class CustomerProblem {
	
	/*Method to apply filter*/
	
	public void applyfilter(List<customer> custList, Predicate<customer> predicateString)
	{
		List<customer> newcustList=custList.stream().filter(predicateString)//.collect(Collectors.toList());
		.map(x->{customer obj = new customer();
        obj.setCustName(x.getCustName());
        obj.setPurchage((int) (x.getPurchage()*.9));
        return obj;}).collect(Collectors.toList());
		int counter=1;
		newcustList.forEach(x->{System.out.println("CustomerName  : "+x.getCustName()+ "  DiscountApplied :"+x.getPurchage());});
	}
	
	public static void main(String[] args) {
		
		
		/*Predicate String to check if purchase is more than 1000*/
		Predicate<customer> predicateStringForPremium = s -> {
			return s.getPurchage() > 1000;
		};

		
		List<customer> custList =new ArrayList<>();
		custList.add(new customer("Prakash",1000));
		custList.add(new customer("kumar",1111));
		custList.add(new customer("pankaj",2222));
		custList.add(new customer("sharma",234));
		custList.add(new customer("payal",1234));
		custList.add(new customer("pk",231));
		
		CustomerProblem probObj= new CustomerProblem();
		probObj.applyfilter(custList,predicateStringForPremium);
		
		
		
		
		
		
	}

}
