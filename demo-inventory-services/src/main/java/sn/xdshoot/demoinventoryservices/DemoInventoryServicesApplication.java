package sn.xdshoot.demoinventoryservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.xdshoot.demoinventoryservices.entities.Product;
import sn.xdshoot.demoinventoryservices.repositories.ProductRepository;

import java.util.UUID;

@SpringBootApplication
public class DemoInventoryServicesApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoInventoryServicesApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Laptop")
                            .price(7998727)
                            .quantity(838)
                            .description("Portable Computer")
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Destop")
                    .price(999922)
                    .quantity(88)
                    .description("Desktop Computer")
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Router")
                    .price(25000)
                    .quantity(8)
                    .description("Network device")
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Server")
                    .price(17998727)
                    .quantity(88)
                    .description("Server Computer")
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Keyboard")
                    .price(78727)
                    .quantity(8)
                    .description("Accessories Computer")
                    .build());

        };

    }

}
