package com.espublico.kataorderimporter.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.espublico.kataorderimporter.exception.CsvFileException;
import com.espublico.kataorderimporter.model.OrderDTO;
import com.opencsv.CSVWriter;

/**
 * The {@code CsvFileServiceImpl} class provides methods for working with CSV files,
 * including writing orders to a CSV file.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Service
public class CsvFileServiceImpl implements CsvFileService {

	private static final String[] CSV_HEADERS_ORDERS = { "Order ID", "Order Priority", "Order Date", "Region",
			"Country", "Item Type", "Sales Channel", "Ship Date", "Units Sold", "Unit Price", "Unit Cost",
			"Total Revenue", "Total Cost", "Total Profit" };

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	private static final Logger logger = LoggerFactory.getLogger(ImporterServiceImpl.class);

	/**
	 * Writes the given array of orders to a CSV file with the specified file name.
	 *
	 * @param orders      The array of orders to be written to the CSV file.
	 * @param csvFileName The name of the CSV file.
	 * @throws IOException If an I/O error occurs during writing.
	 */
	@Override
	public void writeOrdersToCsv(List<OrderDTO> orders, String csvFileName) {
		try (FileWriter fileWriter = new FileWriter(csvFileName); CSVWriter csvWriter = new CSVWriter(fileWriter)) {

			// Escribir la línea de encabezado en el archivo CSV
			csvWriter.writeNext(CSV_HEADERS_ORDERS);

			// Escribir registros en el archivo CSV
			for (OrderDTO order : orders) {
				String[] record = { String.valueOf(order.getIdOrder()), order.getPriority(),
						formatDate(order.getDate()), 
						order.getRegion(), order.getCountry(), order.getItemType(),
						order.getSalesChannel(), 
						formatDate(order.getShipDate()), 
						String.valueOf(order.getUnitsSold()),
						String.valueOf(order.getUnitPrice()), String.valueOf(order.getUnitCost()),
						String.valueOf(order.getTotalRevenue()), String.valueOf(order.getTotalCost()),
						String.valueOf(order.getTotalProfit()) };
				csvWriter.writeNext(record, false);
			}
			logger.info("{} generated", csvFileName);
		}catch (IOException e) {
			logger.error("Error writing orders to CSV file: {}", e.getMessage(), e);
	        throw new CsvFileException("Error writing orders to CSV file", e);
	    }
	}

	private String formatDate(Date date) {
		return date != null ? DATE_FORMAT.format(date) : "";
	}

}
