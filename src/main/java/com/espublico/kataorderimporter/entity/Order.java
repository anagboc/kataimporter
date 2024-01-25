package com.espublico.kataorderimporter.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * {@code Order} represents an entity class for storing order information.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Entity
@Table(name = "orders", schema = "kata")
public class Order {

	@Id
	@JsonProperty("id")
	@Column(name = "id_order")
	private Integer idOrder;

	@JsonProperty("priority")
	@Column(name = "priority")
	private String priority;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@JsonProperty("date")
	@Column(name = "date")
	private Date date;

	@JsonProperty("region")
	@Column(name = "region")
	private String region;

	@JsonProperty("country")
	@Column(name = "country")
	private String country;

	@JsonProperty("item_type")
	@Column(name = "item_type")
	private String itemType;

	@JsonProperty("sales_channel")
	@Column(name = "sales_channel")
	private String salesChannel;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@JsonProperty("ship_date")
	@Column(name = "ship_date")
	private Date shipDate;

	@JsonProperty("units_sold")
	@Column(name = "units_sold")
	private Integer unitsSold;

	@JsonProperty("unit_price")
	@Column(name = "unit_price")
	private Float unitPrice;

	@JsonProperty("unit_cost")
	@Column(name = "unit_cost")
	private Float unitCost;

	@JsonProperty("total_revenue")
	@Column(name = "total_revenue")
	private Float totalRevenue;

	@JsonProperty("total_cost")
	@Column(name = "total_cost")
	private Float totalCost;

	@JsonProperty("total_profit")
	@Column(name = "total_profit")
	private Float totalProfit;

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(Integer unitsSold) {
		this.unitsSold = unitsSold;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public Float getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public Float getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Float totalProfit) {
		this.totalProfit = totalProfit;
	}

	public Order(Integer idOrder, String priority, Date date, String region, String country, String itemType,
			String salesChannel, Date shipDate, Integer unitsSold, Float unitPrice, Float unitCost, Float totalRevenue,
			Float totalCost, Float totalProfit) {
		super();
		this.idOrder = idOrder;
		this.priority = priority;
		this.date = date;
		this.region = region;
		this.country = country;
		this.itemType = itemType;
		this.salesChannel = salesChannel;
		this.shipDate = shipDate;
		this.unitsSold = unitsSold;
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.totalRevenue = totalRevenue;
		this.totalCost = totalCost;
		this.totalProfit = totalProfit;
	}
	
	public Order() {
        // Constructor vacío requerido por MapStruct
    }


}
