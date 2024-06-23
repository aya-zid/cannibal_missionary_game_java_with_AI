package jeu_cannibales_missionaires;

import java.util.Objects;

public class Etat_can_miss extends Etat implements Cloneable{
   
	private int nb_can;
    private int nb_miss;
    private boolean bateau;
    
    public int getNb_can() {
		return nb_can;
	}
	public void setNb_can(int nb_can) {
		this.nb_can = nb_can;
	}
	public int getNb_miss() {
		return nb_miss;
	}
	public void setNb_miss(int nb_miss) {
		this.nb_miss = nb_miss;
	}
	public boolean isBateau() {
		return bateau;
	}
	public void setBateau(boolean bateau) {
		this.bateau = bateau;
	}
	public Etat_can_miss( int nb_miss,int nb_can ,boolean bateau) {
    	super(null,null);
    	this.nb_can=nb_can;
    	this.nb_miss=nb_miss;
    	this.bateau=bateau;
    }
	@Override
	public String toString() {
        return "("+nb_miss+","+nb_can+","+bateau+")";
    }
    public boolean testBut(){
        return(nb_can==0 && nb_miss==0 && bateau==false);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etat_can_miss that = (Etat_can_miss) o;
        return nb_can == that.nb_can &&
               nb_miss == that.nb_miss &&
               bateau == that.bateau;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nb_can, nb_miss, bateau);
    }

    @Override
    public Etat_can_miss clone() {
        try {
            return (Etat_can_miss) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isValid() {
        if (nb_miss < 0 || nb_can < 0 || nb_miss > 3 || nb_can > 3) {
            return false;
        }
        if (nb_miss < nb_can && nb_miss > 0) {
            return false;
        }
        int other_miss = 3 - nb_miss;
        int other_can = 3 - nb_can;
        if (other_miss < other_can && other_miss > 0) {
            return false;
        }
        return true;
    }}