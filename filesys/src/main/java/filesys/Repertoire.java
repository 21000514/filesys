package filesys;

import java.util.ArrayList;

import Exceptions.AddNullException;
import Exceptions.IsInHimselfException;
import Exceptions.NomExistePasException;

/**
 * Classe Repertoire
 * 
 * @author (RASAMOELA Gilberto, HAMEUR Youssef) 
 * @version (22/04/2013)
 */
public class Repertoire extends Entite
{
    /** Liste des fichiers et repertoires contenu dans le repertoire */
    private ArrayList<Entite> contenu = new ArrayList<Entite>();

    /**
     * Constructeur par défaut de la classe Repertoire
     */
    public Repertoire()
    {
       type = "R";
       nom="racine";
    }
    
    /**
     * Constructeur de la classe Repertoire prenant un nom en parametre
     */
    public Repertoire(String parnom)
    {
       type="R";
       nom=parnom;
    }
    /**
     * Methode permettant d'ajouter un objet de la classe Entite dans le contenu du repertoire
     */
    public void add(Entite entite) throws AddNullException, NomExistePasException, IsInHimselfException
    {
    	if (entite == null)
    	{
    		throw new AddNullException("On ne peut pas ajouter une référence null à un répertoire");
    	}
    	if (nomExistePas(entite.getNom())== false)
    	{
    		throw new NomExistePasException("On ne peut pas ajouter dans un répertoire un élément de même nom qu'un élément déjà dans le répertoire");
    	}
    	if (isInHimself(entite))
    	{
    		throw new IsInHimselfException("Un répertoire ne peut pas être un sous-répertoire de lui-même (même indirectement)");

    	}
    	
     contenu.add(entite);
    }
    
    /**
     * Methode qui retourne true si le repertoire est un sous-répertoire de lui-même, indirectement ou non
     * @return booleen indiquant si le repertoire est dans lui-meme ou non
     */
    public boolean isInHimself(Entite e)
    {
    	Repertoire r = null;
    	boolean res=false;
    	
    	if (e.getType().equals("R"))
    	{
    		r = (Repertoire) e;
    		if (r.equals(this))
    		{
    			res=true;
    		}
    		else
    		{
    			for (Entite e2 : r.getContenu())
    			{
    				if (isInHimself(e2))
    					res=true;
    			}
    		}
    	}
    	
    	
    	return res;
    }
    
    /**
     * Methode retournant true si le nom en parametre est celui d'une Entite presente dans le repertoire
     * @return boolen indiquant si le nom est deja existant ou non
     */
    public boolean nomExistePas(String nom)
    {
    	boolean b = true;
    	for (Entite e : contenu)
    	{
    		if(nom.equals(e.getNom()))
    			b = false;
    	}
    	
    	return b;
    }
    /**
     * Retourne la taille totale des fichiers et repertoires contenus dans ce repertoire
     * @return la taille du repertoire
     */
    public int getTaille()
    {
       int taille=0; 

       for(Entite e : contenu)
       {
       taille+=e.getTaille(); 
       }
        
       return taille;
    }
    /**
     * Renvoie la liste du contenu du repertoire
     * @return la liste des Entites du repertoire
     */
    public ArrayList<Entite> getContenu()
    {
    	return contenu;
    }
}
