package jeu_cannibales_missionaires;

public interface Ouvert {
	    public boolean nonvide();
	    public void inserer(Etat e);
	    public Etat extraire();
	    public void detruire();
	    public boolean recherche (Etat e);
}
