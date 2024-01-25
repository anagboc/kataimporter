package com.espublico.kataorderimporter.service;

import com.espublico.kataorderimporter.model.ApiResponse;

public interface KataApiService {
	
	public ApiResponse apiCall(String apiUrl);

}
