package makaleYonetimiPackage;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class FileOperator {
    @SuppressWarnings("UseSpecificCatch")
    public ArrayList<makale> makeEverythingBeatiful(String fPath, ArrayList<String> istenilenMakaleler) throws IOException 
    { 
        ArrayList<makale> makaleList = new ArrayList<makale>();
        
        CSVReader csvr = new CSVReader(new FileReader(fPath));    
        String line[];
        while((line=csvr.readNext()) != null){
            if(istenilenMakaleler.contains(line[0].trim())){
                makale mk = new makale(line[0].trim(),line[1].trim(),line[2].trim(),line[3].trim(),Integer.parseInt(line[4].trim()));
                makaleList.add(mk); 
            }
        }
        
        for (makale m : makaleList) {
            String id = m.getId();           
            if(!new File(id+".pdf").exists())
            {
                Document doc = Jsoup.connect("http://dl.acm.org/citation.cfm?id=" + id).userAgent("Chrome").get();
                Elements e =doc.select("a[name=FullTextPDF]"); 
                String yol ="http://dl.acm.org/"+ e.attr("href");
                HttpDownloadUtility.downloadFile(yol, id+".pdf");
            }      
            PDDocument pd= PDDocument.load(new File(id+".pdf"));
            String contxt = new PDFTextStripper().getText(pd);
            pd.close();
            //new File(id+".pdf").delete();
            m.setContext(contxt);
        }   
        
        return makaleList;
    } 
  
}

