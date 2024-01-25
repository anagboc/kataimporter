package com.espublico.kataorderimporter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@code ApiResponse} is a model class representing the response structure for
 * API calls. It includes page information, a list of orders, and links for
 * navigation.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
public class ApiResponse {

	@JsonProperty("page")
	private int page;

	@JsonProperty("content")
	private List<OrderDTO> content;

	@JsonProperty("links")
	private Links links;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<OrderDTO> getContent() {
		return content;
	}

	public void setContent(List<OrderDTO> content) {
		this.content = content;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

}
