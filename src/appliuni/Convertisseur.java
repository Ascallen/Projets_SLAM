/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliuni;
import java.util.HashMap;

/**
 *
 * @author Baillat
 */
public class Convertisseur {
    
    private HashMap <String,Devise> listeDevises = new HashMap();
    
    public void ajouterDevise (String unNom, double unTauxChange) throws Exception {
        if(listeDevises.containsKey(unNom)){
            throw new Exception("");
        }
        else
            listeDevises.put(unNom, new Devise(unNom,unTauxChange));
    }
    
    public double convertir(double unNombre, String nomDeviseDepart, String nomDeviseCible) throws Exception {
        if(!listeDevises.containsKey(nomDeviseDepart) || !listeDevises.containsKey(nomDeviseCible) ){
            throw new Exception ("Devise inconnue");
        }
        
       unNombre=unNombre*this.getDevise(nomDeviseDepart).getTauxChange();
       if(nomDeviseCible.equals("USD"))
       {
           return unNombre;
       }
       else
       {
           return unNombre/this.getDevise(nomDeviseCible).getTauxChange();
       }
    }
    
    public Devise getDevise(String unNomDevise){
        
        return listeDevises.get(unNomDevise);
    }
   
    
    
    
}
