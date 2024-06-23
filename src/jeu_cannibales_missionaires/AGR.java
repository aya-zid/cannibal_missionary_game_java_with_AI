package jeu_cannibales_missionaires;

import java.util.Stack;

public class AGR {
    private Etat etat_initial;
    private Ferme ferme;
    private Ouvert ouvert;
    private Operation[] operations;

    public AGR(Etat etat_initial, Ferme ferme, Ouvert ouvert, Operation[] operations) {
        this.etat_initial = etat_initial;
        this.ferme = ferme;
        this.ouvert = ouvert;
        this.operations = operations;
    }

    public Etat explorer() {
        ouvert.inserer(etat_initial);
        while (ouvert.nonvide()) {
            Etat etat_courant = ouvert.extraire();
            
            if (etat_courant.testBut()) {
                ouvert.detruire();
                return etat_courant;
            } else {
                ferme.inserer(etat_courant);
                for (Operation op : operations) {
                    Etat_can_miss successeur = (Etat_can_miss) op.Action(etat_courant);
                    if (successeur != null && successeur.isValid() &&
                        !ouvert.recherche(successeur) && !ferme.recherche(successeur)) {
                        successeur.setOp(op);
                        successeur.setPere(etat_courant);
                        ouvert.inserer(successeur);
                    }
                }
            }
        }
        ouvert.detruire();
        return null;
    }

    public String chemin(Etat etat) {
        if (etat == null) {
            return "No solution found.";
        }

        Stack<Etat> pile = new Stack<>();
        StringBuilder chemin = new StringBuilder();
        Etat etatCourant = etat;

        while (etatCourant != null) {
            pile.push(etatCourant);
            etatCourant = etatCourant.getPere();
        }

        if (!pile.isEmpty()) {
            chemin.append(pile.pop().toString());
        }

        while (!pile.isEmpty()) {
            etatCourant = pile.pop();
            chemin.append(" -> ").append(etatCourant.getOp().toString()).append(" -> ").append(etatCourant.toString()).append("\n");
        }

        return chemin.toString();
    }
}
