package com.espublico.kataorderimporter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.espublico.kataorderimporter.entity.Order;
import com.espublico.kataorderimporter.model.OrderDTO;

/**
 * The {@code OrderMapper} interface defines methods for mapping between {@link Order} entities and {@link OrderDTO} data transfer objects.
 * It uses MapStruct for automatic code generation.
 * 
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO convertToDTO(Order entity);

    Order convertToEntity(OrderDTO dto);

    List<OrderDTO> convertToDTOList(List<Order> entities);

    List<Order> convertToEntityList(List<OrderDTO> dtos);
}
