package com.example.booksshop.service;

import com.example.booksshop.dto.CartItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class CartBean {

    private Set<CartItem> cartItems =
            new HashSet<>();

    public void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public Integer cartSize(){
        return cartItems.size();
    }

}
