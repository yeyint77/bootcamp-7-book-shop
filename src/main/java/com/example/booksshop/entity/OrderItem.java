package com.example.booksshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int quantity;
    @ManyToOne
    private Book book;
    @JoinColumn(name = "order_id_fk")
    @ManyToOne
    private Order order;

    public OrderItem(int quantity) {
        this.quantity = quantity;
    }
}
