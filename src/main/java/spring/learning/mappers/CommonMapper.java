package spring.learning.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import spring.learning.dto.response.AddressResponse;
import spring.learning.dto.response.OrderResponse;
import spring.learning.dto.response.ProductResponse;
import spring.learning.dto.response.UserResponse;
import spring.learning.entity.Address;
import spring.learning.entity.Order;
import spring.learning.entity.Product;
import spring.learning.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommonMapper {
    UserResponse toUserResponse(User user);
    AddressResponse toAddressResponse(Address address);
    OrderResponse toOrderResponse(Order order);
    ProductResponse toProductResponse(Product product);

    List<AddressResponse> toAddressResponseList(List<Address> addresses);
    List<OrderResponse> toOrderResponseList(List<Order> orders);
    List<ProductResponse> toProductResponseList(List<Product> products);
}
