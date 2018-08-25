package service;


import dao.AdminProductDao;
import domain.Categroy;
import domain.Product;
import web.AdminDelProductServlet;

import java.sql.SQLException;
import java.util.List;

public class AdminProductServlet  {

    //查询所有商品
    public List<Product> findAllProduct() throws SQLException {

        //因为没有复杂业务，所以直接调用dao层
        AdminProductDao adminProductDao = new AdminProductDao();

        return adminProductDao.findAllProduct();
    }

    public List<Categroy> findAllCategroy() {
        AdminProductDao adminProductDao = new AdminProductDao();
        return adminProductDao.findAllCategroy();
    }

    public void addProduct(Product product) throws SQLException {
        AdminProductDao adminProductDao = new AdminProductDao();
        adminProductDao.addProduct(product);
    }

    public void delProduct(String pid) throws SQLException {
        AdminProductDao adminProductDao = new AdminProductDao();
        adminProductDao.delProduct(pid);
    }

    public Product findAllProductByPid(String pid) throws SQLException {
        AdminProductDao adminProductDao = new AdminProductDao();
        return adminProductDao.findAllProductByPid(pid);
    }

    public void updateProduct(Product product) throws SQLException {
        AdminProductDao adminProductDao = new AdminProductDao();
        adminProductDao.updateProduct(product);
    }
}
