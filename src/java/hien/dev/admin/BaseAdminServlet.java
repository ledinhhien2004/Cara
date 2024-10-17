/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hien.dev.admin;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import hien.dev.data.dao.Database;
import hien.dev.data.dao.DatabaseDao;

/**
 *
 * @author USER
 */
public class BaseAdminServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        DatabaseDao.init(new Database());
    }
}