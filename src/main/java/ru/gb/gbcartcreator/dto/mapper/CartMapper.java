package ru.gb.gbcartcreator.dto.mapper;

import org.mapstruct.Mapper;
import ru.gb.gbcartcreator.dto.CartDto;
import ru.gb.gbcartcreator.entity.Cart;

@Mapper
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);
}
