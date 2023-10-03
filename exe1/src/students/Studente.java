package students;

public class Studente implements Comparable<Studente>{
	
	private int matricola;
	private String ateneo;
	private String nome;
	
	public Studente(int matricola, String ateneo, String nome) {
		this.matricola = matricola;
		this.ateneo = ateneo;
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof Studente) {
			Studente st2 = (Studente) obj;
			return this.equals(st2);
		}
		return false;
	}
	
	private boolean equals(Studente st) {
		if(this.matricola == st.matricola) {
			if(this.ateneo.equals(st.ateneo)) {
				if(this.nome.equals(st.nome))
					return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Studente st) {
		if(this.equals(st)) return 0;
		else if(this.ateneo.equals(st.ateneo)) {
			if(this.matricola < st.matricola) return -1;
			else return 1;
		}
		else {
			if(this.ateneo.compareTo(st.ateneo) < 0) return -1;
			else return 1;
		}
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", ateneo=" + ateneo + ", nome=" + nome + "]";
	}

}
