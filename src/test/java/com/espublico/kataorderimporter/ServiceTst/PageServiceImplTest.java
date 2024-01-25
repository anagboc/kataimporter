package com.espublico.kataorderimporter.ServiceTst;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.espublico.kataorderimporter.model.Links;
import com.espublico.kataorderimporter.service.PageServiceImpl;

public class PageServiceImplTest {

    @Mock
    private Links links;

    @InjectMocks
    private PageServiceImpl pageService;

    @BeforeEach
    void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
    }

    
    @Test
    void testGetNextLinkWhenLinksIsNull() {
        // Set up mock behavior
        when(links.getNext()).thenReturn(null);

        // Call the method under test
        String nextLink = pageService.getNextLink(links);

        // Verify expected behavior
        assertNull(nextLink);
    }

    @Test
    void testGetNextLinkWhenNextLinkExists() {
        // Set up mock behavior
        when(links.getNext()).thenReturn("http://example.com/next");

        // Call the method under test
        String nextLink = pageService.getNextLink(links);

        // Verify expected behavior
        assertEquals("http://example.com/next", nextLink);
    }
    
}