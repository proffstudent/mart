package main.services;

import main.models.pojo.Lection;
import main.models.dao.LectionDAO;

import java.util.List;

/**
 * Created by smoldyrev on 24.02.17.
 */
public class LectionService {

    public static List<Lection> getAllLections(){
        return LectionDAO.getAllLections();
    }

    public static int deleteLectioOnId(int id){

        return LectionDAO.deleteLection(id);
    }

    public static int updateLectionOnId(Lection lection){

        return LectionDAO.updateLection(lection);
    }

    public static int insertLection(Lection lection){

        return LectionDAO.insertLection(lection);
    }

    public static List<Lection> getNearedLection() {
        return LectionDAO.getNearedLections();
    }
}
