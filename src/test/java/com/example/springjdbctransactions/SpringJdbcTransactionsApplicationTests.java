package com.example.springjdbctransactions;

import com.example.springjdbctransactions.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService service;

	@Test
	@Transactional
	void testRollbackOnError() {
		service.addProduct("Teclado", 200);
		try {
			service.addProduct("Produto inválido", -10);
		} catch (RuntimeException ignored) {}

		assertEquals(1, service.getAllProducts().size());
	}
}
