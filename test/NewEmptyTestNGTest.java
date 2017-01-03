/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import makaleYonetimiPackage.benzerlikStrategy;
import makaleYonetimiPackage.benzerlikStrategyDicesCoefficient;
import makaleYonetimiPackage.benzerlikStrategyJaccard;
import makaleYonetimiPackage.makale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author akif
 */
public class NewEmptyTestNGTest {
    
    public NewEmptyTestNGTest() {
    }
    @Test
    public void test1(){//CSV dosyasından veri çekilmesini kontrol ediyor
        try {
            ArrayList<makale> makaleList = new ArrayList<makale>();
            
            CSVReader csvr = new CSVReader(new FileReader("resource/ACM.csv"));
            String line[];
            try {
                while((line=csvr.readNext()) != null){
                     
                    makale mk = new makale(line[0].trim(),line[1].trim(),line[2].trim(),line[3].trim(),Integer.parseInt(line[4].trim()));
                    makaleList.add(mk);
                
                }
            } catch (IOException ex) {
                Logger.getLogger(NewEmptyTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            assertEquals("The WASA2 object-oriented workflow management system", makaleList.get(0).getTitle());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewEmptyTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void test2(){///OSYM sitesinden jsoup ile çekilen verinin doğruluğunu test ediyor
        try {
            Document doc;
            
            doc = Jsoup.connect("http://www.osym.gov.tr/TR,8797/takvim.html").get();
            Elements sınavlar = doc.select("div.row div.col-sm-6"); /// ilk indexte sınav yoktur başlıklar vardır
            Elements tarihler = doc.select("div.row div.col-sm-2"); /// her sınava karşılık gelen 3 tane tarih vardır
            assertEquals(sınavlar.size()*3, tarihler.size());
        } catch (IOException ex) {
            Logger.getLogger(NewEmptyTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void test3(){///DicesCoefficien algoritmasını kontrol ediyor
        benzerlikStrategy strategy = new benzerlikStrategyDicesCoefficient();
        double benzerlik = strategy.karşılaştır("The WASA2 object-oriented workflow management system", "The WASA2 object-oriented workflow management system");
        double d=1;
        assertEquals(d, benzerlik);
    }
    
    @Test
    public void test4(){
        benzerlikStrategy strategy = new benzerlikStrategyJaccard();
        double benzerlik = strategy.karşılaştır("The WASA2 object-oriented workflow management system", "The WASA2 object-oriented workflow management system");
        double d=1;
        assertEquals(d, benzerlik);
    }

}
