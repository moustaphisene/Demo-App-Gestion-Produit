package sn.xdshoot.demoinventoryservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.xdshoot.demoinventoryservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product,String> {
}
