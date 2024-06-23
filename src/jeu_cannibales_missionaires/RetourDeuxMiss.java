package jeu_cannibales_missionaires;

public class RetourDeuxMiss implements Operation {
    @Override
    public Etat_can_miss Action(Etat e) {
        Etat_can_miss etat = (Etat_can_miss) e;
        if (!etat.isBateau() && etat.getNb_miss() < 2) {
            Etat_can_miss nouveauEtat = etat.clone();
            nouveauEtat.setNb_miss(etat.getNb_miss() + 2);
            nouveauEtat.setBateau(true);
            if (nouveauEtat.isValid()) {
                return nouveauEtat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "move 2 missionaries to the right";
    }
}
