package com.threadtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Symptom{
	
	@Override
	public String toString() {
		return "Symptom [categoryId=" + categoryId + ", categoryActive=" + categoryActive + ", categorySymptumCount="
				+ categorySymptumCount + ", categoryVisibility=" + categoryVisibility + ", productId=" + productId
				+ ", categorySequence=" + categorySequence + ", symptomId=" + symptomId + ", symptomvisibility="
				+ symptomvisibility + ", overRideRank=" + overRideRank + ", localizedWeight=" + localizedWeight
				+ ", linkedProductId=" + linkedProductId + ", weightActive=" + weightActive + ", symptomStatus="
				+ symptomStatus + ", productRank=" + productRank + "]";
	}

	Symptom()
	{}
	
	public Symptom(String categoryId, String categoryActive, int categorySymptumCount, String categoryVisibility,
			String productId, String categorySequence, String symptomId, String symptomvisibility, double overRideRank,
			String localizedWeight, String linkedProductId, String weightActive, String symptomStatus,
			double productRank) {
		super();
		this.categoryId = categoryId;
		this.categoryActive = categoryActive;
		this.categorySymptumCount = categorySymptumCount;
		this.categoryVisibility = categoryVisibility;
		this.productId = productId;
		this.categorySequence = categorySequence;
		this.symptomId = symptomId;
		this.symptomvisibility = symptomvisibility;
		this.overRideRank = overRideRank;
		this.localizedWeight = localizedWeight;
		this.linkedProductId = linkedProductId;
		this.weightActive = weightActive;
		this.symptomStatus = symptomStatus;
		this.productRank = productRank;
	}
	private String categoryId;
	private String categoryActive;
	private int categorySymptumCount;
	private String categoryVisibility;
	private String productId;
	private String categorySequence;
	private String symptomId;
	private String symptomvisibility;
	private double overRideRank;
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryActive() {
		return categoryActive;
	}
	public void setCategoryActive(String categoryActive) {
		this.categoryActive = categoryActive;
	}
	public int getCategorySymptumCount() {
		return categorySymptumCount;
	}
	public void setCategorySymptumCount(int categorySymptumCount) {
		this.categorySymptumCount = categorySymptumCount;
	}
	public String getCategoryVisibility() {
		return categoryVisibility;
	}
	public void setCategoryVisibility(String categoryVisibility) {
		this.categoryVisibility = categoryVisibility;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategorySequence() {
		return categorySequence;
	}
	public void setCategorySequence(String categorySequence) {
		this.categorySequence = categorySequence;
	}
	public String getSymptomId() {
		return symptomId;
	}
	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
	}
	public String getSymptomvisibility() {
		return symptomvisibility;
	}
	public void setSymptomvisibility(String symptomvisibility) {
		this.symptomvisibility = symptomvisibility;
	}
	public double getOverRideRank() {
		return overRideRank;
	}
	public void setOverRideRank(double overRideRank) {
		this.overRideRank = overRideRank;
	}
	public String getLocalizedWeight() {
		return localizedWeight;
	}
	public void setLocalizedWeight(String localizedWeight) {
		this.localizedWeight = localizedWeight;
	}
	public String getLinkedProductId() {
		return linkedProductId;
	}
	public void setLinkedProductId(String linkedProductId) {
		this.linkedProductId = linkedProductId;
	}
	public String getWeightActive() {
		return weightActive;
	}
	public void setWeightActive(String weightActive) {
		this.weightActive = weightActive;
	}
	public String getSymptomStatus() {
		return symptomStatus;
	}
	public void setSymptomStatus(String symptomStatus) {
		this.symptomStatus = symptomStatus;
	}
	public double getProductRank() {
		return productRank;
	}
	public void setProductRank(double productRank) {
		this.productRank = productRank;
	}
	private String localizedWeight;
	private String linkedProductId;
	private String weightActive;
	private String symptomStatus;
	private double productRank;
	
}

public class Problem1 {
	
	/*To get the sorted version */
	
	
	
	public List<Symptom> getSortedList(List<Symptom> symptomList)
	{
		//List<Symptom> sortedSymptomList= new ArrayList<Symptom>();
		//sortedSymptomList=symptomList.stream().
			//	filter(Comparator.comparing( p->p.productRank)).collect(Collectors.toList());
		symptomList.stream().filter(x->x.getSymptomvisibility().equals("PUB")).sorted(Comparator.comparing(Symptom::getProductRank)
				.thenComparing(Symptom::getCategorySequence).thenComparing(Symptom::getCategoryId)
				.thenComparing(Symptom::getOverRideRank).thenComparing(Symptom::getSymptomId));
		
		//symptomList.stream().limit(10);
		
		return symptomList;
		
	}
	
	
	
	public static void main(String[] args) {
		
		/*problem 1a*/
		Problem1 probObj= new Problem1();
		List<Symptom> sortedSymptomList= new ArrayList<>();
		List<Symptom> symptomList= new ArrayList<>();
		symptomList.add(new Symptom("SC0030","true",9,"PUB","SG003","77","20421","PUB",2.0,"","ALL","true","A",3.0) );
		symptomList.add(new Symptom("SC0998","true",9,"PRI","SG003","98","20427","PUB",2.0,"","ALL","true","A",3.0));
		symptomList.add(new Symptom("SC0043","true",9,"PRI","SG003","98","20427","PRI",2.0,"","ALL","true","A",3.0));
		sortedSymptomList=probObj.getSortedList(symptomList);
		//System.out.println("1st list"+symptomList.get(0).getCategoryId());
		sortedSymptomList.forEach(x-> System.out.println(x.toString()));
		
		/*Problem 1b*/
		List<Symptom> limitedSymptomList= new ArrayList<>();
		limitedSymptomList=sortedSymptomList.stream().skip(sortedSymptomList.size()-1).collect(Collectors.toList());
		limitedSymptomList.forEach(x-> System.out.println("Limited List : "+x.toString()));

		
		/*Problem 1c*/
		List<Symptom> NewListSymptomList= new ArrayList<>();
		NewListSymptomList=limitedSymptomList.stream().map(x->{Symptom obj = new Symptom();
								obj.setCategoryId(x.getCategoryId());
								obj.setCategoryVisibility(x.getCategoryVisibility());
								obj.setSymptomStatus(x.getSymptomStatus());
										return obj;}).collect(Collectors.toList());
		
		NewListSymptomList.forEach(x-> System.out.println("Limited Fields : "+x.getCategoryId()+","+x.getCategoryVisibility()+","+x.getOverRideRank()));
		/*Problem 1d*/
		/*List<Symptom> checkedListSymptomList= new ArrayList<Symptom>();
		checkedListSymptomList=limitedSymptomList.stream().filter(x->x.getSymptomvisibility().equals("PUB"))
				.map(x->{Symptom obj = new Symptom();
					obj.setCategoryId(x.getCategoryId());
						obj.setCategoryVisibility(x.getCategoryVisibility());
								obj.setSymptomStatus(x.getSymptomStatus());
									return obj;}).collect(Collectors.toList());
		
		checkedListSymptomList.forEach(x-> System.out.println("checked List for pub: "+x.getCategoryId()));*/
		
		
		
		
	}

}
