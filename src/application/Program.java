package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        System.out.println("=== TEST 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.50, depart);
        sellerDao.insert(newSeller);
        System.out.println("Inseriu! Novo id: " + newSeller.getId());

        System.out.println("=== TEST 5: Seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);

        System.out.println("=== TEST 6: Seller delete ===");
        System.out.println("Digite o ID para a exclusão!");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deletado com sucesso!");

    }
}
