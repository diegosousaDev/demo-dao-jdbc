package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("====TESTE 1: Seller find by id; ==== ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("====TESTE 2: Seller find by department; ==== ");
        Department department = new Department(2,null);
        List<Seller> sellers = sellerDao.findByDepartment(department);

        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("====TESTE 3: Seller find all; ==== ");
        sellers = sellerDao.findAll();

        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("====TESTE 4: Seller Inserção; ==== ");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido com sucesso novo id: " + newSeller.getId());

        System.out.println("====TESTE 4: Seller Update; ==== ");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        seller.setEmail("martha@gmail.com");
        sellerDao.update(seller);
        System.out.println("Atualização Completa!");

        System.out.println("====TESTE 4: Seller Delete; ==== ");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID para deletar: "));
        sellerDao.deleteById(id);

    }
}
