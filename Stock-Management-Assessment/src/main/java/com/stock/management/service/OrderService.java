package com.stock.management.service;

import com.stock.management.entity.*;
import com.stock.management.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;
    private final OrderHistoryRepository historyRepo;

    public Order create(List<Integer> ids) {

        double total = 0;

        for (Integer id : ids) {
            Product p = productRepo.findById(id).orElseThrow();
            total += p.getPrice();
            p.setQuantity(p.getQuantity() - 1);
            productRepo.save(p);
        }

        Order order = new Order();
        order.setTotalPrice(total);
        order.setTotalPriceWithGst(total * 1.18);

        Order saved = orderRepo.save(order);

        for (Integer id : ids) {
            historyRepo.save(new OrderHistory(null, saved.getId(), id));
        }

        return saved;
    }
}