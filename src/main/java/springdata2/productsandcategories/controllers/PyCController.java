package springdata2.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springdata2.productsandcategories.models.Category;
import springdata2.productsandcategories.models.Product;
import springdata2.productsandcategories.services.PyCService;

@Controller
public class PyCController {
	private final PyCService serv;

	public PyCController(PyCService serv) {
		super();
		this.serv = serv;
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("products", serv.allProducts());
		model.addAttribute("categories", serv.allCategories());
		return "files/index.jsp";
	}
	
	@RequestMapping("/products/{id}")
	public String product(@PathVariable Long id, Model model) {
		model.addAttribute("product", serv.findProductById(id));
		model.addAttribute("categoriesNull", serv.findCategoriesNull(id));
		return "files/products.jsp";
	}
	
	@RequestMapping("/categories/{id}")
	public String category(@PathVariable Long id, Model model) {
		model.addAttribute("category", serv.findCategoryById(id));
		model.addAttribute("productsNull", serv.findProductsNull(id));
		return "files/categories.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute Product p) {
		return "files/newproduct.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute Product p, BindingResult rslt) {
		if(rslt.hasErrors()) {
			return "files/newproduct";
		}
		else {
			serv.createProduct(p);
			return "redirect:/index";
		}
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute Category c) {
		return "files/newcategory.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute Category c, BindingResult rslt) {
		if(rslt.hasErrors()) {
			return "files/newcategory";
		}
		else {
			serv.createCategory(c);
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/categories/{caId}/add", method=RequestMethod.GET)
	public String addProductToCategory(@PathVariable Long caId,@RequestParam("id") Long prId) {
		serv.addProductToCategory(prId, caId);
		return "redirect:/categories/"+caId;
	}
	
	@RequestMapping(value="products/{prId}/add", method=RequestMethod.GET)
	public String addCategoryToProduct(@PathVariable Long prId, @RequestParam("id") Long caId) {
		serv.addProductToCategory(prId, caId);
		return "redirect:/products/"+prId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
