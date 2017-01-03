/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makaleYonetimiPackage;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author akif
 */
public class benzerlikStrategyJaccard implements benzerlikStrategy{

    @Override
    public double karşılaştır(String Context1, String Context2) {
        if(Context1==Context2)
            return 1;
        if(Context1==""||Context2=="")
            return 0;
        Context1=Context1.toLowerCase();
        Context2=Context2.toLowerCase();
        Context2 = Context2.replaceAll("[!?,./<*\\\"']", "");
        Context1 = Context1.replaceAll("[!?,./<*\\\"']", "");
        String[] kelimeler1 = Context1.split("\\s+") ;
        String[] kelimeler2 = Context2.split("\\s+") ;
        ArrayList<String> words1=new ArrayList<String>();
        ArrayList<String> words2=new ArrayList<String>();
        
        for(String s : kelimeler1)
        {
            if(!words1.contains(s))
            words1.add(s);
        }
        for(String s : kelimeler2)
        {
            if(!words2.contains(s))
            words2.add(s);
        }
        ArrayList<String> intersection=new ArrayList<String>();
        ArrayList<String> union=new ArrayList<String>();
        
        for(String s : words1)
        {
            if(words2.contains(s))
                intersection.add(s);
        }
        union=words1;
        for(String s : words2)
        {
            if(!words1.contains(s))
                union.add(s);
        }
        double benzerlikOranı = (double)intersection.size()/(double)union.size();
        
        return benzerlikOranı;
    }
    
    
}
