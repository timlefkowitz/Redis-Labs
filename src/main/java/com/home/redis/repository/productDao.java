package com.home.redis.repository;

import com.home.redis.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productDao {


    private static final String HASH_KEY = "product";
    @Autowired
    private RedisTemplate template;

    public product save(product product){
        template.opsForHash().put(HASH_KEY, product.getId(),product);
        return product;
    }

    public List<product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public product findProductsById(int id){
        return (product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY, id);
        return "product removed !!!";
    }
}
