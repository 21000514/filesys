package filesys;

/**Classe Entite.
 * @author (RASAMOELA Gilberto)
 * @version (22/04/2013)
 */
public abstract class Entite
{
    protected String type;
    protected String nom;
    /**Methode abstraite retournant la taille de l'Entite
     */
    public abstract int getTaille();
    
    /**
     * Methode retournant le type de l'Entite
     * @return type d'Entite
     */
    public String getType()
    {
    	return type;
    }
    /**
     * Methode retournant le nom de l'Entite
     * @return nom de l'Entite
     */
    public String getNom()
    {
    	return nom;
    }
}
