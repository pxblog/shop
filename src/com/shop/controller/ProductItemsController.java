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
		// TODO �Զ����ɵķ������
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
		//�������Url��������
		String keyWord  = new String(request.getParameter("keyWord").getBytes("ISO8859-1"),"utf-8");
		System.out.println(keyWord);
		List<Product> products = productItemsService.searchProductBySearchButton(keyWord);
		//���ڷ�ҳ����ȡ����ҳ
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("productItem",products);
		modelAndView.setViewName("search");
		return modelAndView;
	}
	
	//��Ʒɾ��
	@RequestMapping("/admin/deleteProduct/{id}/{page}")
	public String deleteProductAjax(@PathVariable("id") int id,@PathVariable("page") int page,HttpServletRequest request,HttpServletResponse response)throws Exception{
		int productId = id;
		productItemsService.deleteProductById(productId);
		return "redirect:/admin/showShops/"+page;
	}
	//��Ʒ��ӣ���Ʒ��Ϣ����
	@RequestMapping("/admin/updateProduct")
	public String updateProduct(Product product,@RequestParam("productId") String productId,@RequestParam("imgUpload")MultipartFile imgUpload,HttpServletRequest request,HttpServletResponse response ) {
		if(!imgUpload.isEmpty()) {
			//��ȡ���ϴ��ļ��Ϻ�׺��
			String originalFilename = imgUpload.getOriginalFilename();
			//�ҵ�ͼƬҪ�����ʵ·��
			String dirPath = request.getServletContext().getRealPath("/images/women_pro/");
			File filePath = new File(dirPath);
			//·�������ھʹ���·��
			if(!filePath.exists()) {
				filePath.mkdirs();
			}
			
			//�������룿�����
			String newFileName = UUID.randomUUID()+"_"+originalFilename.substring(originalFilename.lastIndexOf("."));
			try {
				File saveFile = new File(dirPath+"/"+newFileName);
				saveFile.setWritable(true, false);
				imgUpload.transferTo(saveFile);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			product.setImg("images/women_pro/"+newFileName);
		}
		//���Id���ڣ�֤���Ǳ༭ģʽ
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
