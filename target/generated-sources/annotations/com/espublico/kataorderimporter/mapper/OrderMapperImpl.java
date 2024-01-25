package com.espublico.kataorderimporter.mapper;

import com.espublico.kataorderimporter.entity.Order;
import com.espublico.kataorderimporter.model.OrderDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-25T10:23:39+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO convertToDTO(Order entity) {
        if ( entity == null ) {
            return null;
        }

        Integer idOrder = null;
        String priority = null;
        Date date = null;
        String region = null;
        String country = null;
        String itemType = null;
        String salesChannel = null;
        Date shipDate = null;
        Integer unitsSold = null;
        Float unitPrice = null;
        Float unitCost = null;
        Float totalRevenue = null;
        Float totalCost = null;
        Float totalProfit = null;

        idOrder = entity.getIdOrder();
        priority = entity.getPriority();
        date = entity.getDate();
        region = entity.getRegion();
        country = entity.getCountry();
        itemType = entity.getItemType();
        salesChannel = entity.getSalesChannel();
        shipDate = entity.getShipDate();
        unitsSold = entity.getUnitsSold();
        unitPrice = entity.getUnitPrice();
        unitCost = entity.getUnitCost();
        totalRevenue = entity.getTotalRevenue();
        totalCost = entity.getTotalCost();
        totalProfit = entity.getTotalProfit();

        OrderDTO orderDTO = new OrderDTO( idOrder, priority, date, region, country, itemType, salesChannel, shipDate, unitsSold, unitPrice, unitCost, totalRevenue, totalCost, totalProfit );

        return orderDTO;
    }

    @Override
    public Order convertToEntity(OrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setIdOrder( dto.getIdOrder() );
        order.setPriority( dto.getPriority() );
        order.setDate( dto.getDate() );
        order.setRegion( dto.getRegion() );
        order.setCountry( dto.getCountry() );
        order.setItemType( dto.getItemType() );
        order.setSalesChannel( dto.getSalesChannel() );
        order.setShipDate( dto.getShipDate() );
        order.setUnitsSold( dto.getUnitsSold() );
        order.setUnitPrice( dto.getUnitPrice() );
        order.setUnitCost( dto.getUnitCost() );
        order.setTotalRevenue( dto.getTotalRevenue() );
        order.setTotalCost( dto.getTotalCost() );
        order.setTotalProfit( dto.getTotalProfit() );

        return order;
    }

    @Override
    public List<OrderDTO> convertToDTOList(List<Order> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( entities.size() );
        for ( Order order : entities ) {
            list.add( convertToDTO( order ) );
        }

        return list;
    }

    @Override
    public List<Order> convertToEntityList(List<OrderDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtos.size() );
        for ( OrderDTO orderDTO : dtos ) {
            list.add( convertToEntity( orderDTO ) );
        }

        return list;
    }
}
