package kodlamaio.northWind.businnes.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northWind.businnes.abstracts.ProductService;
import kodlamaio.northWind.core.utilities.results.DataResult;
import kodlamaio.northWind.core.utilities.results.Result;
import kodlamaio.northWind.core.utilities.results.SuccesResult;
import kodlamaio.northWind.core.utilities.results.SuccessDataResult;
import kodlamaio.northWind.dataAccess.abstracts.ProductDao;
import kodlamaio.northWind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		
		this.productDao = productDao;
	}


	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(
				this.productDao.findAll(),"Data Listelendi ") ;
	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccesResult("Ürün eklendi") ;
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		        return new SuccessDataResult<Product>(
				this.productDao.getByProductName(productName),"Data Listelendi ") ;
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        
		//business codes
		
				return new SuccessDataResult<Product>(
						this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi ") ;
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
				return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data Listelendi ") ;
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
				return new SuccessDataResult<List<Product>>(
				this.productDao.getByCategoryIn(categories),"Data Listelendi ") ;
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
				return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameContains(productName),"Data Listelendi ") ;
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
				return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameStartsWith(productName),"Data Listelendi ") ;
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
				return new SuccessDataResult<List<Product>>(
				this.productDao.getByNameAndCategory(productName, categoryId),"Data Listelendi ") ;
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		
		Sort sort= Sort.by(Sort.Direction.ASC,"productName");
		
		return new SuccessDataResult<>(this.productDao.findAll(sort));
	}



	
	

}
