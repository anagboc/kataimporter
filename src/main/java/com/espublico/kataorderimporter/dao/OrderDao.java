package com.espublico.kataorderimporter.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.espublico.kataorderimporter.entity.Order;

/**
 * {@code OrderDao} is a Spring Data JPA repository interface for managing
 * {@code Order} entities. It extends the {@code JpaRepository} interface for
 * basic CRUD operations.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
public interface OrderDao extends JpaRepository<Order, Integer> {

	List<Order> findAllByOrderByIdOrder();

}
