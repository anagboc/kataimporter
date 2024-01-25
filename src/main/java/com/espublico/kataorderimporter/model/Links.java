package com.espublico.kataorderimporter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@code Links} is a model class representing links for navigation in the API response.
 * It includes links for the next, previous, and self navigation.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
public class Links {

	@JsonProperty("next")
	private String next;

	@JsonProperty("prev")
	private String prev;

	@JsonProperty("self")
	private String self;

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

}
