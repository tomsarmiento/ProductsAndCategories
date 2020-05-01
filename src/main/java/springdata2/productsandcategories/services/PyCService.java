package springdata2.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springdata2.productsandcategories.models.Category;
//import springdata2.productsandcategories.models.CategoryProduct;
import springdata2.productsandcategories.models.Product;
import springdata2.productsandcategories.repositories.CategoryRepository;
import springdata2.productsandcategories.repositories.ProductRepository;
import springdata2.productsandcategories.repositories.PyCRepository;

@Service
public class PyCService {
	private final ProductRepository prRepo;
	private final CategoryRepository caRepo;
	//private final PyCRepository pycRepo;
	
	public PyCService(ProductRepository prRepo, CategoryRepository caRepo, PyCRepository pycRepo) {
		this.prRepo = prRepo;
		this.caRepo = caRepo;
	//	this.pycRepo = pycRepo;
	}
	
	public List<Product> allProducts(){
		return (List<Product>) prRepo.findAll();
	}
	
	public List<Category> allCategories(){
		return (List<Category>) caRepo.findAll();
	}
	
	public Product findProductById(Long id) {
		Optional<Product> optPr = prRepo.findById(id);
		if(optPr.isPresent()) {
			return optPr.get();
		}
		else {
			return null;
		}
	}
	
	public Category findCategoryById(Long id) {
		Optional<Category> optCa = caRepo.findById(id);
		if(optCa.isPresent()) {
			return optCa.get();
		}
		else {
			return null;
		}
	}
	
	public void createProduct(Product p) {
		prRepo.save(p);
	}
	
	public void createCategory(Category c) {
		caRepo.save(c);
	}
	
	public void addProductToCategory(Long prId, Long caId) {
		Product p = prRepo.findById(prId).get();
		Category c = caRepo.findById(caId).get();
		
		List<Category> categories = p.getCategories();
		
		categories.add(c);
		
		p.setCategories(categories);
		
		caRepo.save(c);
	}
	
	public List<Product> findProductsNull(Long caId){
		Category c = caRepo.findById(caId).get();
		List<Product> caProducts = c.getProducts();
		List<Product> allProducts = ((List<Product>) prRepo.findAll());
		allProducts.removeAll(caProducts);
		return allProducts;
		
	}

	public List<Category> findCategoriesNull(Long prId){
		List<Category> prCategories = prRepo.findById(prId).get().getCategories();
		List<Category> allCategories = (List<Category>) caRepo.findAll();
		allCategories.removeAll(prCategories);
		return allCategories;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
