package sn.xdshoot.demoinventoryservices.web;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.web.bind.annotation.*;
import sn.xdshoot.demoinventoryservices.entities.Product;
import sn.xdshoot.demoinventoryservices.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();
    }
    @GetMapping("/auth")
    public Authentication authentication (Authentication authentication){
        return authentication;

    }

}
