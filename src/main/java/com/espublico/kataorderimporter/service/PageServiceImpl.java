package com.espublico.kataorderimporter.service;

import org.springframework.stereotype.Service;

import com.espublico.kataorderimporter.model.Links;


/**
 * The {@code PageServiceImpl} This service class provides methods for working with 
 * pagination links.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Service
public class PageServiceImpl implements PageService {

	/**
     * Retrieves the next link from the provided {@link Links} object.
     *
     * @param links The Links object containing pagination information.
     * @return The next link if available, or null if not present.
     */
	@Override
	public String getNextLink(Links links) {

		if (links != null && links.getNext() != null) {
			return links.getNext();
		}
		return null;
	}

}
