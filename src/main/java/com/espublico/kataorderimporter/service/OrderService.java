package com.espublico.kataorderimporter.service;

import java.util.List;

import com.espublico.kataorderimporter.entity.Order;

public interface OrderService {

	public void save(Order order);

	public void saveBulk(List<Order> orders);

	public List<Order> getAllOrdersSortedByIdOrder();

}
