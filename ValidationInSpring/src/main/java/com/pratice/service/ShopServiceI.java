package com.pratice.service;

import com.pratice.dto.ShopDTO;
import com.pratice.model.Shop;

public interface ShopServiceI {

    Shop getProductById(Long id);

    ShopDTO postProduct(ShopDTO shopDto);
}
