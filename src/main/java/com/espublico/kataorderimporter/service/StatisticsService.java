package com.espublico.kataorderimporter.service;

import java.util.List;
import java.util.Map;

import com.espublico.kataorderimporter.model.OrderDTO;

public interface StatisticsService {

	public void updateOrderStatistics(List<OrderDTO> orders);

	public void printStatistics();

	public Map<String, Integer> getRegionCountMap();

	public Map<String, Integer> getItemTypeCountMap();

	public Map<String, Integer> getSalesChannelCountMap();

	public Map<String, Integer> getOrderPriorityCountMap();

	public Map<String, Integer> getCountryCountMap();

}
