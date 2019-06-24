package com.shop.mapper;

import java.util.List;
import java.util.Map;

import com.shop.entity.Category;
import com.shop.entity.OrderDetails;
import com.shop.entity.Product;

public interface ProductMapper {
	public List<Product> selectAllProduct(Map<String, Integer> page);
	public int selectProductNum();
	public List<Product> selectFiveProductByKeyWord(String keyWord);
	public Product selectProductById(int id);
	public List<Category> getCategorys();
	public void deleteProductById(int id);
	public void insertProduct(Product product);
	public void updateProduct(Product product);
	public void updateProductstorageByProductId(int productId,int num);
	public int getProductstorageByProductId(int id);
	public List<Product> searchProductBySearchButton(String keyWord);
}
