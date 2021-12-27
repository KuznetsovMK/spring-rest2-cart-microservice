package ru.gb.gbcartcreator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbcartcreator.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

}
