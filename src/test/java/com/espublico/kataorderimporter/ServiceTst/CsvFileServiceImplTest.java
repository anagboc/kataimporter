package com.espublico.kataorderimporter.ServiceTst;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.opentest4j.AssertionFailedError;

import com.espublico.kataorderimporter.model.OrderDTO;
import com.espublico.kataorderimporter.service.CsvFileServiceImpl;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

class CsvFileServiceImplTest {

	@Mock
	private CSVWriter csvWriter;

	@Mock
	private Path mockPath;

	@InjectMocks
	private CsvFileServiceImpl csvFileService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testWriteOrdersToCsv() throws IOException, ParseException {
		// Config data test
		List<OrderDTO> orders = createTestOrders();

		// Config mock
		doNothing().when(csvWriter).writeNext(any(String[].class), anyBoolean());

		// Create temporal file
		Path tempFile = Files.createTempFile("test", ".csv");
		when(mockPath.toString()).thenReturn(tempFile.toString());

		try {
			csvFileService.writeOrdersToCsv(orders, mockPath.toString());

			// Verify file
			List<String> lines = Files.readAllLines(tempFile);
			assertEquals(orders.size() + 1, lines.size()); // Encabezado + 3 órdenes

			// Verify content
			assertFileContentContainsOrder(lines, orders.get(0));
			assertFileContentContainsOrder(lines, orders.get(1));
			assertFileContentContainsOrder(lines, orders.get(2));
			assertFileContentContainsOrder(lines, orders.get(3));
			assertFileContentContainsOrder(lines, orders.get(4));
			assertFileContentContainsOrder(lines, orders.get(5));

		} finally {
			// delete file when proccess finish
			Files.deleteIfExists(tempFile);
		}
	}

	private void assertFileContentContainsOrder(List<String> lines, OrderDTO order) {
		for (String line : lines) {
			if (line.contains(String.valueOf(order.getIdOrder())) && line.contains(order.getPriority())
					&& line.contains(order.getRegion()) && line.contains(order.getCountry())
					&& line.contains(order.getItemType()) && line.contains(order.getSalesChannel())
					&& line.contains(String.valueOf(order.getUnitsSold()))
					&& line.contains(String.valueOf(order.getUnitPrice()))
					&& line.contains(String.valueOf(order.getUnitCost()))
					&& line.contains(String.valueOf(order.getTotalRevenue()))
					&& line.contains(String.valueOf(order.getTotalCost()))
					&& line.contains(String.valueOf(order.getTotalProfit()))) {
				return; // find
			}
		}
		throw new AssertionFailedError("File content does not contain the order: " + order);
	}

	private List<OrderDTO> createTestOrders() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ArrayList<OrderDTO> orders = new ArrayList<>();

		orders.add(new OrderDTO(1, "High", dateFormat.parse("2022-01-20"), "North", "USA", "Electronics", "Online",
				dateFormat.parse("2021-01-19"), 100, 10.0f, 5.0f, 1000.0f, 500.0f, 500.0f));
		orders.add(new OrderDTO(2, "Low", dateFormat.parse("2022-01-19"), "South", "USA", "Clothing", "Retail",
				dateFormat.parse("2021-01-12"), 50, 20.0f, 10.0f, 1000.0f, 500.0f, 500.0f));
		orders.add(new OrderDTO(3, "Low", dateFormat.parse("2019-01-12"), "East", "Spain", "Electronics", "Online",
				dateFormat.parse("2021-01-22"), 100, 10.0f, 5.0f, 1000.0f, 500.0f, 500.0f));
		orders.add(new OrderDTO(4, "Low", dateFormat.parse("2022-01-15"), "East", "USA", "Electronics", "Retail",
				dateFormat.parse("2021-01-22"), 50, 20.0f, 10.0f, 1000.0f, 500.0f, 500.0f));
		orders.add(new OrderDTO(5, "High", dateFormat.parse("2020-01-17"), "West", "Canada", "Electronics", "Online",
				dateFormat.parse("2021-01-22"), 100, 10.0f, 5.0f, 1000.0f, 500.0f, 500.0f));
		orders.add(new OrderDTO(6, "Medium", dateFormat.parse("2021-01-22"), "South", "Spain", "Electronics", "Online",
				dateFormat.parse("2021-01-22"), 50, 20.0f, 10.0f, 1000.0f, 500.0f, 500.0f));

		return orders;
	}
}