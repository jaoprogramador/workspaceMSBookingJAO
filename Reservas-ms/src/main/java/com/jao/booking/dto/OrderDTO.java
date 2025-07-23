package com.jao.booking.dto;

import java.util.List;
import lombok.*;
import com.jao.booking.entity.OrderItemEntity;
@Data
@NoArgsConstructor
public class OrderDTO {
	private List <OrderItemEntity> orderItems;
}
