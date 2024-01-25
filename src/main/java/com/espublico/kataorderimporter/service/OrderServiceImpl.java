package com.espublico.kataorderimporter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espublico.kataorderimporter.dao.OrderDao;
import com.espublico.kataorderimporter.entity.Order;

/**
 * The {@code OrderServiceImpl} class for handling operations related to Order
 * entities.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	/**
	 * Saves a single order to the database.
	 *
	 * @param order The order to be saved.
	 */
	@Override
	public void save(Order order) {
		orderDao.save(order);

	}

	/**
	 * Saves an array of orders to the database in bulk.
	 *
	 * @param orders The array of orders to be saved.
	 */
	@Override
	public void saveBulk(List<Order> orders) {
		orderDao.saveAll(orders);
	}

	/**
	 * Retrieves all orders from the database and returns them sorted by their order
	 * ID.
	 *
	 * @return An array of orders sorted by order ID.
	 */
	@Override
	public List<Order> getAllOrdersSortedByIdOrder() {
		return orderDao.findAllByOrderByIdOrder();
	}

}
