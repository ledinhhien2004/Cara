/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hien.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import hien.dev.data.dao.CategoryDao;
import hien.dev.data.dao.DatabaseDao;
import hien.dev.data.dao.ProductDao;
import hien.dev.data.model.Category;
import hien.dev.data.model.Product;
import hien.dev.util.Constants;


/**
 *
 * @author USER
 */
public class HomeServlet extends BaseServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        DatabaseDao.init(new Database());
        super.doGet(request, response);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> hotProductList = productDao.hot(Constants.NUMBER_LIMIT);
        List<Product> newsProductList = productDao.news(Constants.NUMBER_LIMIT);
        
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();
        
        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("newsProductList", newsProductList);
        
        
        request.getRequestDispatcher("home.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
