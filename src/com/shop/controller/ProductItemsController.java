package com.shop.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.shop.entity.Product;
import com.shop.service.ProductItemsService;

@Controller
public class ProductItemsController{
	
	@Autowired
	ProductItemsService productItemsService;
	
	@RequestMapping("/queryItems.action")
	public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自动生成的方法存根
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		
		int allPageNum = productItemsService.selectAllPageNum();
		
		List<Product> list = productItemsService.selectProductByPage(pageNum);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("productItem",list);
		
		modelAndView.addObject("allPageNum",allPageNum);
		modelAndView.addObject("nowPage",pageNum);
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/selectProductDetail.action")
	public ModelAndView selectProductDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));
		Product product = productItemsService.selectProductDetailById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("productDetail",product);
		modelAndView.setViewName("productDetail");
		return modelAndView;
	}
	@RequestMapping("/searchBox.action")
	public void searchBox(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
		String keyWord = request.getParameter("keyWord");
		List<Product> list = productItemsService.productAjaxCon(keyWord);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (list!=null) {
			out.println("<ul>");
			for (Product product : list) {
				out.print("<li><a href='selectProductDetail.action?id="+product.getId()+"' target='_blank'>"+product.getName()+"</a></li>");
			}
				out.println("</ul>");
		}	
	}
	@RequestMapping("/searchButton.action")
	public ModelAndView searchButton(HttpServletRequest request,HttpServletResponse response)throws Exception{
		//解决中文Url乱码问题
		String keyWord  = new String(request.getParameter("keyWord").getBytes("ISO8859-1"),"utf-8");
		System.out.println(keyWord);
		List<Product> products = productItemsService.searchProductBySearchButton(keyWord);
		//关于分页，暂取消分页
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("productItem",products);
		modelAndView.setViewName("search");
		return modelAndView;
	}
	
	//商品删除
	@RequestMapping("/admin/deleteProduct/{id}/{page}")
	public String deleteProductAjax(@PathVariable("id") int id,@PathVariable("page") int page,HttpServletRequest request,HttpServletResponse response)throws Exception{
		int productId = id;
		productItemsService.deleteProductById(productId);
		return "redirect:/admin/showShops/"+page;
	}
	//商品添加，商品信息更新
	@RequestMapping("/admin/updateProduct")
	public String updateProduct(Product product,@RequestParam("productId") String productId,@RequestParam("imgUpload")MultipartFile imgUpload,HttpServletRequest request,HttpServletResponse response ) {
		if(!imgUpload.isEmpty()) {
			//获取到上传文件嘞后缀名
			String originalFilename = imgUpload.getOriginalFilename();
			//找到图片要存的真实路径
			String dirPath = request.getServletContext().getRealPath("/images/women_pro/");
			File filePath = new File(dirPath);
			//路径不存在就创建路径
			if(!filePath.exists()) {
				filePath.mkdirs();
			}
			
			//中文乱码？待解决
			String newFileName = UUID.randomUUID()+"_"+originalFilename.substring(originalFilename.lastIndexOf("."));
			try {
				File saveFile = new File(dirPath+"/"+newFileName);
				saveFile.setWritable(true, false);
				imgUpload.transferTo(saveFile);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			product.setImg("images/women_pro/"+newFileName);
		}
		//如果Id存在，证明是编辑模式
		if (!productId.equals("")&&productId!=null&&!productId.trim().equals("0")) {
			int id = Integer.valueOf(productId);
			product.setId(id);
			productItemsService.updateProduct(product);
		}else {
			productItemsService.insertProduct(product);
		}
		return "redirect:/admin/showShops/1";
	}
	
}
