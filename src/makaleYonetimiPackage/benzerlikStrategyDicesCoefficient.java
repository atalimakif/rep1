/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makaleYonetimiPackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author akif
 */
public class benzerlikStrategyDicesCoefficient implements benzerlikStrategy{

    @Override
    public double karşılaştır(String Context1, String Context2) {
        Context1=Context1.toLowerCase();
        Context2=Context2.toLowerCase();
        Context2 = Context2.replaceAll("[!?,./<*\\\"']", "");
        Context1 = Context1.replaceAll("[!?,./<*\\\"']", "");
        if(Context1==Context2)
            return 1;
        if(Context1==""||Context2=="")
            return 0;
        Set<String> nx = new HashSet<String>();
        Set<String> ny = new HashSet<String>();

        for (int i=0; i < Context1.length()-2; i++) {
                char x1 = Context1.charAt(i);
                char x2 = Context1.charAt(i+1);
                char x3 = Context1.charAt(i+2);
                String tmp = "" + x1 + x2+x3;
                nx.add(tmp);
        }
        for (int j=0; j < Context2.length()-2; j++) {
                char y1 = Context2.charAt(j);
                char y2 = Context2.charAt(j+1);
                char y3 = Context2.charAt(j+2);
                String tmp = "" + y1 + y2 +y3;
                ny.add(tmp);
        }

        Set<String> intersection = new HashSet<String>(nx);
        intersection.retainAll(ny);
        double totcombigrams = intersection.size();

        double k= (2*totcombigrams) / (nx.size()+ny.size());

        return k;
    }
}
