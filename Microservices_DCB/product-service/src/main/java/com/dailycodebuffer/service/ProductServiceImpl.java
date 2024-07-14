package com.dailycodebuffer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.entity.Product;
import com.dailycodebuffer.model.ProductRequest;
import com.dailycodebuffer.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public long addProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.productName(productRequest.getName()).quantity(productRequest.getQuantity()).price(productRequest.getPrice()).build();
		productRepository.save(product);
		return product.getProductId();
	}

}
