package jeu_cannibales_missionaires;

import java.util.Queue;
import java.util.LinkedList;

public class Fifo implements Ouvert {
    Queue<Etat> fifo;

    Fifo() {
        fifo = new LinkedList<>();
    }

    @Override
    public boolean nonvide() {
        return !fifo.isEmpty();
    }

    @Override
    public void inserer(Etat e) {
        fifo.offer(e);
    }

    @Override
    public Etat extraire() {
        return fifo.poll();
    }

    @Override
    public void detruire() {
        fifo.clear();
    }

    @Override
    public boolean recherche(Etat e) {
        return fifo.contains(e);
    }
}
