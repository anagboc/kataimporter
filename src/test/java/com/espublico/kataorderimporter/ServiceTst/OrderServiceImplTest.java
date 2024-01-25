package com.espublico.kataorderimporter.ServiceTst;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.espublico.kataorderimporter.service.OrderServiceImpl;
import com.espublico.kataorderimporter.dao.OrderDao;
import com.espublico.kataorderimporter.entity.Order;

@SpringBootTest
//@ActiveProfiles("test")
public class OrderServiceImplTest {

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testSave() {
    	// Create test orders
    	Order order = new Order(1, "High", null, "North", "USA", "Electronics", "Online", null, 100, 10.0f, 5.0f, 1000.0f,
    					500.0f, 500.0f);

        // Configure mock behavior
        when(orderDao.save(any())).thenReturn(order);

        // Call the method under test
        orderService.save(order);

        // Verify that the save method of OrderDao was called with the correct order
        verify(orderDao, times(1)).save(eq(order));
    }
    
    @Test
    void testSaveBulk() {
        List<Order> orders = Arrays.asList(/* ...*/ );
        
    	// Create test orders
    	Order order = new Order(1, "High", null, "North", "USA", "Electronics", "Online", null, 100, 10.0f, 5.0f, 1000.0f,
    					500.0f, 500.0f);

        // Configure mock behavior
        when(orderDao.save(any())).thenReturn(order);

        // Call the method under test
        orderService.saveBulk(orders);

        // Verify that the save method of OrderDao was called for each order in the list
        verify(orderDao, times(orders.size())).save(any());
    }
    
    @Test
    void testGetAllOrdersSortedByIdOrder() {
    	List<Order> expectedOrders = Arrays.asList(
                new Order(1, "High", null, "North", "USA", "Electronics", "Online", null, 100, 10.0f, 5.0f, 1000.0f, 500.0f, 500.0f),
                new Order(2, "Medium", null, "South", "Canada", "Clothing", "Retail", null, 50, 20.0f, 10.0f, 1000.0f, 500.0f, 500.0f)
            );

        // Configure mock behavior
        when(orderDao.findAllByOrderByIdOrder()).thenReturn(expectedOrders);

        // Call the method under test
        List<Order> result = orderService.getAllOrdersSortedByIdOrder();

        // Verify that the findAllByOrderByIdOrder method of OrderDao was called
        verify(orderDao, times(1)).findAllByOrderByIdOrder();

        // Verify that the result is the same as expectedOrders
        assertEquals(expectedOrders, result);
    }
    
}

