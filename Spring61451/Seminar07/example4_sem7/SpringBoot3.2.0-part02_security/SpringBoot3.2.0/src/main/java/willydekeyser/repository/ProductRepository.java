package willydekeyser.repository;



import lombok.Getter;
import org.springframework.stereotype.Repository;
import willydekeyser.model.Product;


import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class ProductRepository {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product)
    {
        products.add(product);
    }

}