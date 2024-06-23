package jeu_cannibales_missionaires;

public class DepartUnCan implements Operation  {
	/*@Override
	public Etat Action (Etat e) {
		Etat_can_miss etat_courant=(Etat_can_miss) e;
		int var1=3-etat_courant.getNb_miss();
		int var2=3-etat_courant.getNb_can()+1;
		if((etat_courant.isBateau())&&(etat_courant.getNb_can()>=1)&&((var1>=var2)||(var1==0)))
			return new Etat_can_miss(etat_courant.getNb_miss(),etat_courant.getNb_can()-1,false);
		else return null;
		
	}*/
	@Override
    public Etat_can_miss Action(Etat e) {
        Etat_can_miss etat = (Etat_can_miss) e;
        if (etat.isBateau() && etat.getNb_can() > 0) {
            Etat_can_miss nouveauEtat = etat.clone();
            nouveauEtat.setNb_can(etat.getNb_can() - 1);
            nouveauEtat.setBateau(false);
            if (nouveauEtat.isValid()) {
                return nouveauEtat;
            }
        }
        return null;
    }
	@Override
	public String toString() {
        return "move 1 cannibal to the left";
    }
}
     