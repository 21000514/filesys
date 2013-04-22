package filesys;

/**
 * Write a description of class Entite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entite
{
    protected String type;
    protected String nom;
    
    public abstract int getTaille();
    
    public String getType()
    {
    	return type;
    }
    public String getNom()
    {
    	return nom;
    }
}
