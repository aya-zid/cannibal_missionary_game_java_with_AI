package jeu_cannibales_missionaires;

public class RetourUnMiss implements Operation {
    @Override
    public Etat_can_miss Action(Etat e) {
        Etat_can_miss etat = (Etat_can_miss) e;
        if (!etat.isBateau() && etat.getNb_miss() < 3) {
            Etat_can_miss nouveauEtat = etat.clone();
            nouveauEtat.setNb_miss(etat.getNb_miss() + 1);
            nouveauEtat.setBateau(true);
            if (nouveauEtat.isValid()) {
                return nouveauEtat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
    	return "move 1 missionary to the right";
    }
}
