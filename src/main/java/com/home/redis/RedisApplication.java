package com.home.redis;

import com.home.redis.entity.product;
import com.home.redis.repository.productDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping("/product")
public class RedisApplication {

	@Autowired
	public productDao dao;


	@PostMapping
	public product save(@RequestBody product product){
		return dao.save(product);

	}

	@GetMapping
	public List<product> getAllproducts(){
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public product findProduct(@PathVariable int id){
		return dao.findProductsById(id);
	}
//	@DeleteMapping("/{id}")
//	public String remove(PathVariable int id){
//		return dao.deleteProduct(id);
//	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
