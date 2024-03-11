package ma.enset.firstappjpaspringboot.ProductsApp.Repository;

import ma.enset.firstappjpaspringboot.ProductsApp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Solution1
    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);
    //Solution2
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String mc);

    @Query("select p from Product p where p.price>:x")
    List<Product> searchByprice(@Param("x") double price);

}
