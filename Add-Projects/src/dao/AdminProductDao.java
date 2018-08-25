package dao;

import domain.Categroy;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class AdminProductDao {

    public List<Product> findAllProduct() throws SQLException {
        //返回全部商品列表的写法
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = " select *from oduct";
        List<Product> productList =queryRunner.query(sql, new BeanListHandler < Product > (Product.class));
        return productList;
    }

    public List<Categroy> findAllCategroy() {
        //返回全部商品类型
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select *from category";
        List<Categroy> categroyList = null;
        try {
            categroyList = queryRunner.query(sql, new BeanListHandler<Categroy>(Categroy.class));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categroyList;
    }

    public void addProduct(Product product) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into oduct values(?,?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql, product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(),
                product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(), product.getCid());
    }

    public void delProduct(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from oduct where pid =?";
        queryRunner.update(sql, pid);
    }

    public Product findAllProductByPid(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select *from oduct where pid =?";
        Product product = new Product();
        product= queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);
        return product;
    }

    public void updateProduct(Product product) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        System.out.println(product.getPid());
        System.out.println(product.getMarket_price());
        System.out.println(product.getCid());
        System.out.println(product.getPdesc());
        String sql = "update oduct set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
        queryRunner.update(sql,product.getPname(),product.getMarket_price(),
                product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
                product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
    }
}
