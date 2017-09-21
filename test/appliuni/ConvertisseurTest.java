/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliuni;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Baillat
 */
public class ConvertisseurTest extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp(); //To change body of generated methods, choose Tools | Templates.
        convertisseur = new Convertisseur();
        convertisseur.ajouterDevise("EUR",1.36);
        convertisseur.ajouterDevise("USD", 1.0);
        convertisseur.ajouterDevise("GBP", 1.6);
    }
    private Convertisseur convertisseur;
    
    public ConvertisseurTest() {
    }
    
    @Test
    public void testAjouterDevise() throws Exception {
     
        
        try {
            convertisseur.ajouterDevise("EUR",1.36);
            fail ("Erreur non détectée (devise déjà ajoutée)");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testConvertir() throws Exception {
        
        
      
        
        //conversion d'1 euros en euros
        double resultat = convertisseur.convertir(1.0, "EUR", "EUR");
        assertEquals(1.0,resultat,0.000000000000000000001);
        
        //conversion d'1 livre GB en dollar US
        resultat= convertisseur.convertir(1.0, "GBP", "USD");
        assertEquals(1.6, resultat,0.000000000000000001);
        
        //conversion de 20 euros en livre GB
        resultat =convertisseur.convertir(20.0, "EUR", "GBP");
        assertEquals(17.0,resultat,0.0000000000000000001);
        
        try {
            convertisseur.convertir(1.0,"YEN","USD");
            fail ("erreur non encore détectée : devise inconnue");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
