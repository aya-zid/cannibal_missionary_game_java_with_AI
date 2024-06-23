package jeu_cannibales_missionaires;

public abstract class Etat {
	private Etat pere;
    private Operation op;
    
    public Etat(Etat pere,Operation op) 
    { this.pere=pere; 
      this.op=op;
    }
    public Etat getPere() {
		return pere;
	}
	public void setPere(Etat pere) {
		this.pere = pere;
	}
	public Operation getOp() {
		return op;
	}
	public void setOp(Operation op) {
		this.op = op;
	}
	
    public abstract boolean testBut();
}
