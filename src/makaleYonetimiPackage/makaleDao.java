package makaleYonetimiPackage;


import makaleYonetimiPackage.makale;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akif
 */
public interface makaleDao {
    public ArrayList<makale> getAllMakale();
    public void setAllMakaleToDatabase(ArrayList<String> makaleler);
    public makale getMakale(String id); 
    
}
