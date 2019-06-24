package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.entity.Category;
import com.shop.entity.OrderDetails;
import com.shop.entity.Product;
import com.shop.entity.ProductCategory;

public interface ProductItemsService {
	public List<Product> selectProductByPage(int pageNum);
	public int selectAllPageNum();
	public int selectAllProductNum();
	public List<Product> productAjaxCon(String keyWord);
	public Product selectProductDetailById(int id);
	public List<Category> getCategorys();
	public void deleteProductById(int id);
	public void insertProduct(Product product);
	public void updateProduct(Product product);
	public void updateProductstorageByProductId(int productId,int num);
	public int getProductstorageByProductId(int id);
	public List<Product> searchProductBySearchButton(String keyWord);
}
