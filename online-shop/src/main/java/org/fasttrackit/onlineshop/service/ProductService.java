package src.main.java.org.fasttrackit.onlineshop.service;

import src.main.java.org.fasttrackit.onlineshop.domain.Product;
import src.main.java.org.fasttrackit.onlineshop.persistance.ProductRepository;
import src.main.java.org.fasttrackit.onlineshop.transfer.SaveProductRequest;

import java.util.logging.Logger;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    // IoC - inversion of control
    private final ProductRepository productRepository;

    // Dependency injection
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(SaveProductRequest request){
        LOGGER.info("Creating product {}", request);
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImageUrl(request.getImageUrl());

        return productRepository.save(product);

    }
}
