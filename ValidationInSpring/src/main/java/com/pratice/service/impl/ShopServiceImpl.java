package com.pratice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratice.dto.ShopDTO;
import com.pratice.model.Shop;
import com.pratice.repository.ShopRepository;
import com.pratice.service.ShopServiceI;

@Service
public class ShopServiceImpl implements ShopServiceI {

    @Autowired
    private ShopRepository repository;

    @Override
    public Shop getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    @Transactional
    @Override
    public ShopDTO postProduct(ShopDTO dto) {
        Shop shop = new Shop();
        shop.setProductName(dto.getProductName());
        shop.setPrice(dto.getPrice());
        shop.setRemark(dto.getRemark());

        Shop savedShop = repository.save(shop);
        return new ShopDTO(savedShop.getProductName(), savedShop.getPrice(), savedShop.getRemark());
    }
}
