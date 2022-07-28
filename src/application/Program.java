package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println();
        System.out.println("=== TEST 1: department insert ===");

        Department department = new Department(null, "Music");
        departmentDao.insert(department);
        System.out.println("Inserted! New id= " + department.getId());


        System.out.println();
        System.out.println("=== TEST 2: department update ===");

        department = departmentDao.findById(6);
        department.setName("Tools");
        departmentDao.update(department);
        System.out.println("Update completed");


        System.out.println();
        System.out.println("=== TEST 3: department update ===");
        department = departmentDao.findById(3);
        System.out.println(department);


        System.out.println();
        System.out.println("=== TEST 4: department findAll ===");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }


        System.out.println();
        System.out.println("=== TEST 5: department delete ===");
        System.out.print("Enter ID to delete: ");
        int id = key.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");



        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment ===");
        department = new Department(2, null);
        List<Seller> list2 = sellerDao.findByDepartment(department);
        for (Seller obj : list2) {
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 3: seller findByAll ===");
        list2 = sellerDao.findAll();
        for (Seller obj2 : list2) {
            System.out.println(obj2);
        }

        System.out.println();
        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id= " + newSeller.getId());

        System.out.println();
        System.out.println("=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println();
        System.out.println("=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        id = key.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed ");

        key.close();


    }
}
