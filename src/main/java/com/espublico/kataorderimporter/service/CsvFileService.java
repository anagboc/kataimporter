package com.espublico.kataorderimporter.service;

import java.io.IOException;
import java.util.List;

import com.espublico.kataorderimporter.model.OrderDTO;

public interface CsvFileService {

	public void writeOrdersToCsv(List<OrderDTO> orders, String csvFileName) throws IOException;

}
