/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliuni;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Baillat
 */
public class DeviseTest {
    
    public DeviseTest() {
    }

    @Test
   public void testConstructeur()
   {
       try {
       String nom ="USD";
       double tauxChange=1.0;
       
       Devise devise = new Devise(nom,tauxChange);
       
       assertEquals(nom,devise.getNom());
       assertEquals(tauxChange,devise.getTauxChange(),0.1);
       }
       catch (Exception e){
           System.out.println("Erreur" + e.getMessage());
       }
       }
   
   public void testReglesMetier() throws Exception
   {
       Devise devise;
       try {
           devise = new Devise ("EURO",0);
           fail("Erreur");
       }
       catch (Exception e){
           
       }
   }
    
}
