package com.espublico.kataorderimporter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.espublico.kataorderimporter.model.OrderDTO;

/**
 * The {@code PageServiceImpl} Service class for calculating and updating order
 * statistics.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

	private Map<String, Integer> regionCount = new HashMap<>();
	private Map<String, Integer> countryCount = new HashMap<>();
	private Map<String, Integer> itemTypeCount = new HashMap<>();
	private Map<String, Integer> salesChannelCount = new HashMap<>();
	private Map<String, Integer> orderPriorityCount = new HashMap<>();

	/**
	 * Updates the order statistics based on the provided array of orders.
	 *
	 * @param orders The array of orders.
	 */
	public void updateOrderStatistics(List<OrderDTO> orders) {
		for (OrderDTO order : orders) {

			if (order.getRegion() != null) {
				updateCount(regionCount, order.getRegion());
			}

			if (order.getCountry() != null) {
				updateCount(countryCount, order.getCountry());
			}

			if (order.getItemType() != null) {
				updateCount(itemTypeCount, order.getItemType());
			}

			if (order.getSalesChannel() != null) {
				updateCount(salesChannelCount, order.getSalesChannel());
			}

			if (order.getPriority() != null) {
				updateCount(orderPriorityCount, order.getPriority());
			}
		}

	}

	public Map<String, Integer> getRegionCountMap() {
		return regionCount;
	}

	public Map<String, Integer> getItemTypeCountMap() {
		return itemTypeCount;
	}

	public Map<String, Integer> getSalesChannelCountMap() {
		return salesChannelCount;
	}

	public Map<String, Integer> getOrderPriorityCountMap() {
		return orderPriorityCount;
	}

	public Map<String, Integer> getCountryCountMap() {
		return countryCount;
	}

	/**
	 * Print statistics based on the counters.
	 *
	 */
	public void printStatistics() {
		System.out.println("╔════════════════════════════════════════╗");
		printStat("Region Count", regionCount);
		printStat("Country Count", countryCount);
		printStat("Item Type Count", itemTypeCount);
		printStat("Sales Channel Count", salesChannelCount);
		printStat("Order Priority Count", orderPriorityCount);
		System.out.println("╚════════════════════════════════════════╝");
	}

	private void printStat(String label, Map<String, Integer> countMap) {
		System.out.printf("║ %-30s %-10s ║%n", label, "");

		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			System.out.printf("║   %-30s %-10d ║%n", entry.getKey(), entry.getValue());
		}

		System.out.println("║                                       ");
	}

	private <T> void updateCount(Map<T, Integer> countMap, T key) {
		countMap.put(key, countMap.getOrDefault(key, 0) + 1);
	}

}
