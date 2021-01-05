package com.github.alcemirjunior.dsdelivery.services;

import com.github.alcemirjunior.dsdelivery.dto.OrderDTO;
import com.github.alcemirjunior.dsdelivery.dto.ProductDTO;
import com.github.alcemirjunior.dsdelivery.entities.Order;
import com.github.alcemirjunior.dsdelivery.entities.OrderStatus;
import com.github.alcemirjunior.dsdelivery.entities.Product;
import com.github.alcemirjunior.dsdelivery.repositories.OrderRepository;
import com.github.alcemirjunior.dsdelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream()
                .map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for(ProductDTO p : dto.getProducts()){
            Product product = productRepository.getOne(p.getId()); //getOne instancia um produto, cria uma entidade gerenciada pelo jpa pra que quando salve o pedido, tmb salve as associações de quais produtos estao neste pedido
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDTO(order);
    }
}


