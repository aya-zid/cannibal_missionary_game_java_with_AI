package jeu_cannibales_missionaires;

public class DepartDeuxCan implements Operation {
    @Override
    public Etat_can_miss Action(Etat e) {
        Etat_can_miss etat = (Etat_can_miss) e;
        if (etat.isBateau() && etat.getNb_can() > 1) {
            Etat_can_miss nouveauEtat = etat.clone();
            nouveauEtat.setNb_can(etat.getNb_can() - 2);
            nouveauEtat.setBateau(false);
            if (nouveauEtat.isValid()) {
                return nouveauEtat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "move 2 cannibals to the left";
    }
}
