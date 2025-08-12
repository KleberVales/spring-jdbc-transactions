package com.example.springjdbctransactions;

import com.example.springjdbctransactions.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcTransactionsApplication implements CommandLineRunner {

	private final ProductService productService;

	public SpringJdbcTransactionsApplication(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTransactionsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		productService.addProduct("Notebook", 3500.00);
		productService.addProduct("Mouse", 120.00);

		System.out.println("Produtos cadastrados:");
		productService.getAllProducts().forEach(System.out::println);

		// Teste de rollback
		try {
			productService.addProduct("Produto inválido", -50.00);
		} catch (RuntimeException e) {
			System.out.println("Rollback aplicado: " + e.getMessage());
		}

		System.out.println("Produtos finais:");
		productService.getAllProducts().forEach(System.out::println);
	}
}

/*
	O programa deve mostrar uma listagem que esta na tabela produto.
	Depois e programa deve tentar fazer uma operaçao de rollback que deve dar errado por causa que o preço é invalido
	Depois deve mostrar a lista de produtos finais
 */
