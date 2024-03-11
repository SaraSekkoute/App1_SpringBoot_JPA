package ma.enset.firstappjpaspringboot;

import ma.enset.firstappjpaspringboot.ProductsApp.Repository.ProductRepository;
import ma.enset.firstappjpaspringboot.ProductsApp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootApplication
public class FirstSbAppSdJpaApplication implements CommandLineRunner {

@Autowired
private ProductRepository productRepository;


	public static void main(String[] args) {

		SpringApplication.run(FirstSbAppSdJpaApplication.class, args);//auto il fait appel a methode run
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"Clavier",45555,7));
		productRepository.save(new Product(null,"Pc",7005,4));
		productRepository.save(new Product(null,"Sourie",8090,2));
		List<Product> Products=productRepository.findAll();
		Products.forEach(p->{
			System.out.println(p.toString());
		});
		Product p=productRepository.findById(Long.valueOf(1)).get();

		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getPrice());


		System.out.println("find By Name Contains c ****************************************************************");
		//List<Product> productList =productRepository.findByNameContains("c");
	  List<Product> productList =productRepository.search("%c%");
      productList.forEach(pr->System.out.println(pr));
		System.out.println("find By Price Greater Than 34000****************************************************************");
		//List<Product> productList_price =productRepository.findByPriceGreaterThan(34000);
		List<Product> productList_price =productRepository.searchByprice(34000);
		productList_price.forEach(prd->System.out.println(prd));

	}
}
