package www.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import www.ecom.constants.AppConstants;
import www.ecom.dto.ProductDto;
import www.ecom.entity.Product;
import www.ecom.exception.ProductServiceException;
import www.ecom.mapper.CategoryMapper;
import www.ecom.mapper.ProductMapper;
import www.ecom.repo.ProductRepo;

public class ProductServiceImpl implements ProductService  {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public ProductDto addProduct(ProductDto productDto, MultipartFile file) {
		Product product = ProductMapper.convertToEntity(productDto);
		Product savedProduct = productRepo.save(product);
		return ProductMapper.convertToDto(savedProduct);
	}
	
	@Override
	public ProductDto updateProduct(Integer productId, ProductDto productDto, MultipartFile file) {
		Product existingProduct = productRepo.findById(productId)
		.orElseThrow(() -> new ProductServiceException(AppConstants.PRODUCT_NOT_FOUND,AppConstants.PRODUCT_NOT_FOUND_ERR_CD));
		existingProduct.setName(productDto.getName());
		existingProduct.setDesc(productDto.getDesc());
		existingProduct.setPrice(productDto.getPrice());
		existingProduct.setStock(productDto.getStock());
		existingProduct.setImage(productDto.getImage());
		existingProduct.setDiscount(productDto.getDiscount());
		existingProduct.setPriceBeforeDiscount(productDto.getPriceBeforeDiscount());
		existingProduct.setCategory(CategoryMapper.convertToEntity(productDto.getCategory()));
		Product updatedProduct = productRepo.save(existingProduct);
		return ProductMapper.convertToDto(updatedProduct);
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepo.findAll();
		return products.stream().map(ProductMapper::convertToDto).collect(Collectors.toList());
	}
	
	@Override
	public ProductDto getProductById(Integer productId) {
		Product product = productRepo.findById(productId)
		.orElseThrow(() -> new ProductServiceException(AppConstants.PRODUCT_NOT_FOUND,AppConstants.PRODUCT_NOT_FOUND_ERR_CD));
		return ProductMapper.convertToDto(product);
	}
	
	@Override
	public ProductDto deleteProductById(Integer productId) {
		Product product = productRepo.findById(productId)
		.orElseThrow(() -> new ProductServiceException(AppConstants.PRODUCT_NOT_FOUND,AppConstants.PRODUCT_NOT_FOUND_ERR_CD));
		productRepo.delete(product);
		return ProductMapper.convertToDto(product);
	}
	
	@Override
	public boolean updateStock(Integer productId, Integer quantity) {
		Product product = productRepo.findById(productId)
		.orElseThrow(() -> new ProductServiceException(AppConstants.PRODUCT_NOT_FOUND,AppConstants.PRODUCT_NOT_FOUND_ERR_CD));
		product.setStock(quantity);
		productRepo.save(product);
		return true;
	}
	

}
