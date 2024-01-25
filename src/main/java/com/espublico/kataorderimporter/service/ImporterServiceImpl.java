package com.espublico.kataorderimporter.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.espublico.kataorderimporter.exception.ImporterException;
import com.espublico.kataorderimporter.mapper.OrderMapper;
import com.espublico.kataorderimporter.model.ApiResponse;

import jakarta.transaction.Transactional;

/**
 * The {@code ImporterServiceImpl} class provides methods for performing data
 * import. It retrieves data from an external source, updates statistics, and
 * saves the data to the database.
 * 
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Service
public class ImporterServiceImpl implements ImporterService {

	@Value("${kata.url-base}")
	private String URL_KATA_BASE;

	@Value("${kata.endpoint.order}")
	private String EP_KATA_ORDER;

	@Value("${csv.namefile.orders}")
	private String FILE_NAME;

	private static final Logger logger = LoggerFactory.getLogger(ImporterServiceImpl.class);

	@Autowired
	private KataApiServiceImpl kataApiService;

	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PageService pageService;

	@Autowired
	private CsvFileService csvFileService;

	@Autowired
	private OrderMapper orderMapper;

	/**
	 * Executes the data import process. This method retrieves data from an external
	 * source, updates statistics, and saves the data to the database.
	 *
	 * @throws ImporterException if an error occurs during the import process.
	 */
	@Override
	@Transactional // case error: rollback
	public void execute() {

		long startTime = System.currentTimeMillis();
	    logger.info("Import process started at: {}", LocalDateTime.now());
		
		ApiResponse response = new ApiResponse();
		String urlLink = URL_KATA_BASE + EP_KATA_ORDER;
		int countRegisters = 0;

		try {

			while (urlLink != null) {

				response = kataApiService.apiCall(urlLink);

				// update nextLink
				urlLink = pageService.getNextLink(response.getLinks());

				statisticsService.updateOrderStatistics(response.getContent());

				orderService.saveBulk(orderMapper.convertToEntityList(response.getContent()));
				
				countRegisters += response.getContent().size();
				logger.info("Count Register: {}", countRegisters);
			}

			csvFileService.writeOrdersToCsv(orderMapper.convertToDTOList(orderService.getAllOrdersSortedByIdOrder()),
					this.genNameFile());
			statisticsService.printStatistics();

		} catch (Exception e) {
			String messageError = "Error in ImporterServiceImpl.execute() --> " + e.getMessage();
			throw new ImporterException(messageError);

		}finally {
			long endTime = System.currentTimeMillis();
		    logger.info("Import process completed at: {}", LocalDateTime.now());
		    logger.info("Total time taken: {} milliseconds", endTime - startTime);
		}

	}

	/**
	 * Generates the file name with a timestamp.
	 *
	 * @return The file name with a timestamp.
	 */
	private String genNameFile() {
		String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
		return FILE_NAME + timestamp + ".csv";
	}

}
