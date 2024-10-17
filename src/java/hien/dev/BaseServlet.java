/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hien.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import hien.dev.data.dao.CategoryDao;
import hien.dev.data.dao.Database;
import hien.dev.data.dao.DatabaseDao;
import hien.dev.data.model.Category;

/**
 *
 * @author USER
 */
public class BaseServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        DatabaseDao.init(new Database());
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
       List<Category> categoryList = categoryDao.findAll();
       
       request.setAttribute("categoryList", categoryList);
    }
}
