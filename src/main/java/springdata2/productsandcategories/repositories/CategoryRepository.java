package springdata2.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdata2.productsandcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
