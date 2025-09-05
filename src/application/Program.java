package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: Seller findByDepartment ===");
        Department depart = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(depart);

        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("=== TEST 3: Seller findAll ===");

        List<Seller> list1 = sellerDao.findAll();
        for (Seller s : list1) {
            System.out.println(s);
        }


    }
}
