package com.market.carmarketservice.model.order;

import com.market.carmarketservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private Integer id;
    private UserDTO user;
    private List<ProductInfo> products;
    private Integer total;
}