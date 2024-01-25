package com.espublico.kataorderimporter.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@code OrderDTO} represents an model class for storing order information.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
public class OrderDTO {

	@JsonProperty("id")
	private Integer idOrder;

	@JsonProperty("priority")
	private String priority;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@JsonProperty("date")
	private Date date;

	@JsonProperty("region")
	private String region;

	@JsonProperty("country")
	private String country;

	@JsonProperty("item_type")
	private String itemType;

	@JsonProperty("sales_channel")
	private String salesChannel;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@JsonProperty("ship_date")
	private Date shipDate;

	@JsonProperty("units_sold")
	private Integer unitsSold;

	@JsonProperty("unit_price")
	private Float unitPrice;

	@JsonProperty("unit_cost")
	private Float unitCost;

	@JsonProperty("total_revenue")
	private Float totalRevenue;

	@JsonProperty("total_cost")
	private Float totalCost;

	@JsonProperty("total_profit")
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

	public OrderDTO(Integer idOrder, String priority, Date date, String region, String country, String itemType,
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
	
	
}