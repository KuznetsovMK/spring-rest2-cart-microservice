package ru.gb.gbcartcreator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbcartcreator.dto.CartDto;
import ru.gb.gbcartcreator.service.CartService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public ResponseEntity<?> handlePost(@RequestBody CartDto cartDto) {
        CartDto savedCart = cartService.save(cartDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/cart/" + savedCart.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public List<CartDto> getProductList() {
        return cartService.findAll();
    }

    @DeleteMapping(value = "/{cartId}", produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("cartId") Long id) {
        cartService.deleteById(id);
    }

}
