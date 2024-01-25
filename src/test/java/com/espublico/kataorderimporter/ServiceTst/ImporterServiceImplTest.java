package com.espublico.kataorderimporter.ServiceTst;

import com.espublico.kataorderimporter.exception.CsvFileException;
import com.espublico.kataorderimporter.exception.ImporterException;
import com.espublico.kataorderimporter.mapper.OrderMapper;
import com.espublico.kataorderimporter.model.ApiResponse;
import com.espublico.kataorderimporter.service.CsvFileService;
import com.espublico.kataorderimporter.service.ImporterServiceImpl;
import com.espublico.kataorderimporter.service.KataApiServiceImpl;
import com.espublico.kataorderimporter.service.OrderService;
import com.espublico.kataorderimporter.service.PageService;
import com.espublico.kataorderimporter.service.StatisticsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.*;

class ImporterServiceImplTest {

    @Mock
    private KataApiServiceImpl kataApiService;

    @Mock
    private StatisticsService statisticsService;

    @Mock
    private OrderService orderService;

    @Mock
    private PageService pageService;
    
    @Mock
    private OrderMapper orderMapper;

    @Mock
    private CsvFileService csvFileService;

    @InjectMocks
    private ImporterServiceImpl importerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccessfulImportShouldUpdateStatisticsAndSaveOrders() {
        // Arrange
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setContent(Collections.emptyList());

        when(kataApiService.apiCall(any())).thenReturn(apiResponse);
        when(pageService.getNextLink(any())).thenReturn(null);

        // Act
        importerService.execute();

        // Assert
        verify(statisticsService, times(1)).updateOrderStatistics(apiResponse.getContent());
        verify(orderService, times(1)).saveBulk(orderMapper.convertToEntityList(apiResponse.getContent()));
        try {
			verify(csvFileService, times(1)).writeOrdersToCsv(any(), any());
		} catch (IOException e) {
			throw new CsvFileException("Error al manejar la IOException", e);
		}
        verify(statisticsService, times(1)).printStatistics();
    }

    @Test
    void executeApiCallErrorShouldThrowImporterException() {
    	// Arrange
        when(kataApiService.apiCall(any())).thenThrow(new ImporterException("API call error"));

        // Act & Assert
        Assertions.assertThrows(ImporterException.class, () -> importerService.execute());
    }


}
