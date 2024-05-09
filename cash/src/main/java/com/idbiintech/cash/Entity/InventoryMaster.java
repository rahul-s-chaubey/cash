package com.idbiintech.cash.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="INVENTORY_MASTER")
public class InventoryMaster {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    	
	@Column(name="vehicle_id")
	Integer vehicleId;
	
	@Column(name="vehicle_name")
	String vehicleName;
	
	@Column(name="vehicle_manufacturer")
	String vehicleManufacturer;
	
	@Column(name="pricing")
	String pricing;
	
	@Column(name="quantity")
	String quantity;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
	
	
}
