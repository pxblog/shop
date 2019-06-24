package com.shop.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.entity.OrderDetails;
import com.shop.entity.Product;
import com.shop.mapper.ProductMapper;
import com.shop.service.ProductItemsService;

@Service("productItemsService")
public class ProductItemsServiceImpl implements ProductItemsService{
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<Product> selectProductByPage(int pageNum) {
		// TODO 自动生成的方法存根
		int pageSize = 8;
		int ProductNum = productMapper.selectProductNum();
		int allPageNum = ProductNum/pageSize;
		
		Map<String,Integer> page = new HashMap<String,Integer>();
		page.put("productNumByPageNum",(pageNum-1)*pageSize);
		page.put("pageSize",pageSize);
		
		return productMapper.selectAllProduct(page);
	}

	@Override
	public int selectAllPageNum() {
		// TODO 自动生成的方法存根
		//设置向上取整
		int pageNum = (int) Math.ceil(((double)productMapper.selectProductNum())/8);
		return pageNum;
	}

	@Override
	public List<Product> productAjaxCon(String keyWord) {
		// TODO 自动生成的方法存根
		List<Product> list = null;
		if(!keyWord.equals("")) {
			list = productMapper.selectFiveProductByKeyWord(keyWord);
		}
		return list;
	}

	@Override
	public Product selectProductDetailById(int id) {
		// TODO 自动生成的方法存根
		return productMapper.selectProductById(id);
	}

	@Override
	public List<Category> getCategorys() {
		// TODO 自动生成的方法存根
		return productMapper.getCategorys();
	}

	@Override
	public void deleteProductById(int id) {
		// TODO 自动生成的方法存根
		productMapper.deleteProductById(id);
	}

	@Override
	public int selectAllProductNum() {
		// TODO 自动生成的方法存根
		return productMapper.selectProductNum();
	}

	@Override
	public void insertProduct(Product product) {
		// TODO 自动生成的方法存根
		productMapper.insertProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO 自动生成的方法存根
		productMapper.updateProduct(product);
	}

	@Override
	public void updateProductstorageByProductId(int productId,int num) {
		// TODO 自动生成的方法存根
		productMapper.updateProductstorageByProductId(productId,num);
	}

	@Override
	public int getProductstorageByProductId(int id) {
		// TODO 自动生成的方法存根
		return productMapper.getProductstorageByProductId(id);
	}

	@Override
	public List<Product> searchProductBySearchButton(String keyWord) {
		// TODO 自动生成的方法存根
		return productMapper.searchProductBySearchButton(keyWord);
	}

	
}
