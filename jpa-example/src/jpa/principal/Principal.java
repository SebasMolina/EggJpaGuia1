package jpa.principal;

import java.util.List;
import jpa.entity.Maker;
import jpa.persistence.MakerDAO;

public class Principal {

    public static void main(String[] args) {
        MakerDAO makerDAO = new MakerDAO();

        try {
            List<Maker> makers = makerDAO.getAll();

            for (Maker maker : makers) {
                System.out.println(maker.getCode());
                System.out.println(maker.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
