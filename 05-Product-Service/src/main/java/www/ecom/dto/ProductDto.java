package www.ecom.dto;

public class ProductDto {
	
	private Integer productId;
	private String name;
	private String desc;
	private Double price;
	private Integer stock;
	private String image;
	private Integer discount;
	private Double priceBeforeDiscount;
	private Integer categoryId;
	private CategoryDto category;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Double getPriceBeforeDiscount() {
		return priceBeforeDiscount;
	}
	public void setPriceBeforeDiscount(Double priceBeforeDiscount) {
		this.priceBeforeDiscount = priceBeforeDiscount;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(Integer productId, String name, String desc, Double price, Integer stock, String image,
			Integer discount, Double priceBeforeDiscount, Integer categoryId, CategoryDto category) {
		super();
		this.productId = productId;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.discount = discount;
		this.priceBeforeDiscount = priceBeforeDiscount;
		this.categoryId = categoryId;
		this.category = category;
	}
	
	
	
}
