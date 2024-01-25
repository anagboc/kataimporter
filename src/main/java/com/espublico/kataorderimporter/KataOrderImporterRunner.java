package com.espublico.kataorderimporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.espublico.kataorderimporter.exception.ImporterException;
import com.espublico.kataorderimporter.service.ImporterService;

/**
 * {@code KataOrderImporterRunner} is a Spring Boot component that implements
 * the {@code CommandLineRunner} interface. It is responsible for handling the
 * migration process based on command line parameters.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Component
public class KataOrderImporterRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(KataOrderImporterRunner.class);

	@Autowired
	private ImporterService importerService;

	/**
	 * Runs the migration process based on command line parameters.
	 * 
	 * @param args Command line arguments passed to the application.
	 * @throws Exception         If an error occurs during the migration process.
	 * @throws ImporterException If a specific importer-related error occurs.
	 */
	@Override
	public void run(String... args) throws Exception, ImporterException {
		if (args.length > 1 && args[1].equals("--runMigration")) {
			logger.info("Start migration process...");

			try {
				importerService.execute();
				logger.info("Migration process completed successfully");
			} catch (ImporterException e) {
				logger.error("Error during migration process: {}", e.getMessage());
			} catch (Exception e) {
				logger.error("Error during migration process: {}", e.getMessage(), e);
			} finally {
				logger.info("...Process finished");

			}
		} else {
			logger.warn("Migration process skipped. Use '--runMigration' parameter to execute.");
		}
	}
}
