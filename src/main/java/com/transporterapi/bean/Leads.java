package com.transporterapi.bean;

public class Leads {
	private String userId,leadId,typeOfMaterial,weight,pickUpAddress,
		deliveryAddress,contactForPickup,contactForDelivery,dateOfCompletion,
		timestamp,status,vehicleNumber,dealLockedWith,bidCount;
	public Leads() {
		
	}
	public Leads(String userId, String leadId, String typeOfMaterial, String weight, String pickUpAddress,
			String deliveryAddress, String contactForPickup, String contactForDelivery, String dateOfCompletion,
			String timestamp, String status, String vehicleNumber, String dealLockedWith, String bidCount) {
		super();
		this.userId = userId;
		this.leadId = leadId;
		this.typeOfMaterial = typeOfMaterial;
		this.weight = weight;
		this.pickUpAddress = pickUpAddress;
		this.deliveryAddress = deliveryAddress;
		this.contactForPickup = contactForPickup;
		this.contactForDelivery = contactForDelivery;
		this.dateOfCompletion = dateOfCompletion;
		this.timestamp = timestamp;
		this.status = status;
		this.vehicleNumber = vehicleNumber;
		this.dealLockedWith = dealLockedWith;
		this.bidCount = bidCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getTypeOfMaterial() {
		return typeOfMaterial;
	}
	public void setTypeOfMaterial(String typeOfMaterial) {
		this.typeOfMaterial = typeOfMaterial;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPickUpAddress() {
		return pickUpAddress;
	}
	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getContactForPickup() {
		return contactForPickup;
	}
	public void setContactForPickup(String contactForPickup) {
		this.contactForPickup = contactForPickup;
	}
	public String getContactForDelivery() {
		return contactForDelivery;
	}
	public void setContactForDelivery(String contactForDelivery) {
		this.contactForDelivery = contactForDelivery;
	}
	public String getDateOfCompletion() {
		return dateOfCompletion;
	}
	public void setDateOfCompletion(String dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getDealLockedWith() {
		return dealLockedWith;
	}
	public void setDealLockedWith(String dealLockedWith) {
		this.dealLockedWith = dealLockedWith;
	}
	public String getBidCount() {
		return bidCount;
	}
	public void setBidCount(String bidCount) {
		this.bidCount = bidCount;
	}
	
}
