package com.espublico.kataorderimporter.ServiceTst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.espublico.kataorderimporter.model.OrderDTO;
import com.espublico.kataorderimporter.service.StatisticsServiceImpl;

class StatisticsServiceImplTest {

	@InjectMocks
	private StatisticsServiceImpl statisticsService;

	private List<OrderDTO> orders = new ArrayList<>();

	@BeforeEach
	void setUp() {
		// Initialize Mockito annotations
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testUpdateOrderStatistics() {
		// Create test orders
		orders.add(new OrderDTO(1, "High", null, "North", "USA", "Electronics", "Online", null, 100, 10.0f, 5.0f, 1000.0f,
				500.0f, 500.0f));
		orders.add(new OrderDTO(2, "Low", null, "South", "USA", "Clothing", "Retail", null, 50, 20.0f, 10.0f, 1000.0f,
				500.0f, 500.0f));
		orders.add(new OrderDTO(1, "Low", null, "East", "Spain", "Electronics", "Online", null, 100, 10.0f, 5.0f, 1000.0f,
				500.0f, 500.0f));
		orders.add(new OrderDTO(2, "Low", null, "East", "USA", "Electronics", "Retail", null, 50, 20.0f, 10.0f, 1000.0f,
				500.0f, 500.0f));
		orders.add(new OrderDTO(1, "High", null, "West", "Canada", "Electronics", "Online", null, 100, 10.0f, 5.0f,
				1000.0f, 500.0f, 500.0f));
		orders.add(new OrderDTO(2, "Medium", null, "South", "Spain", "Electronics", "Online", null, 50, 20.0f, 10.0f,
				1000.0f, 500.0f, 500.0f));

		// Call the method under test
		statisticsService.updateOrderStatistics(orders);

		// Verify the counts for each category
		assertEquals(1, statisticsService.getRegionCountMap().get("West"));
		assertEquals(2, statisticsService.getRegionCountMap().get("South"));
		assertEquals(1, statisticsService.getRegionCountMap().get("North"));
		assertEquals(2, statisticsService.getRegionCountMap().get("East"));

		assertEquals(1, statisticsService.getCountryCountMap().get("Canada"));
		assertEquals(3, statisticsService.getCountryCountMap().get("USA"));
		assertEquals(2, statisticsService.getCountryCountMap().get("Spain"));

		assertEquals(5, statisticsService.getItemTypeCountMap().get("Electronics"));
		assertEquals(1, statisticsService.getItemTypeCountMap().get("Clothing"));

		assertEquals(2, statisticsService.getSalesChannelCountMap().get("Retail"));
		assertEquals(4, statisticsService.getSalesChannelCountMap().get("Online"));

		assertEquals(2, statisticsService.getOrderPriorityCountMap().get("High"));
		assertEquals(3, statisticsService.getOrderPriorityCountMap().get("Low"));
		assertEquals(1, statisticsService.getOrderPriorityCountMap().get("Medium"));
	}

	@Test
	void testUpdateOrderStatisticsWithNull() {
		// Create test orders
		List<OrderDTO> orders = new ArrayList<>();

		// Call the method under test
		statisticsService.updateOrderStatistics(orders);

		// Verify the counts for each category
		assertEquals(0, statisticsService.getRegionCountMap().size());
		assertEquals(0, statisticsService.getCountryCountMap().size());
		assertEquals(0, statisticsService.getItemTypeCountMap().size());
		assertEquals(0, statisticsService.getSalesChannelCountMap().size());
		assertEquals(0, statisticsService.getOrderPriorityCountMap().size());
	}

}
