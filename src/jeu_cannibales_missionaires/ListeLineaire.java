package jeu_cannibales_missionaires;

import java.util.ArrayList;
import java.util.List;

public class ListeLineaire implements Ferme {
    List<Etat> liste;

    ListeLineaire() {
        liste = new ArrayList<>();
    }

    @Override
    public boolean nonvide() {
        return !liste.isEmpty();
    }

    @Override
    public void inserer(Etat e) {
        liste.add(e);
    }

    @Override
    public void detruire() {
        liste.clear();
    }

    @Override
    public boolean recherche(Etat e) {
        return liste.contains(e);
    }
}
