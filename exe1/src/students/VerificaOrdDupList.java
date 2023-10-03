package students;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VerificaOrdDupList implements AlgoDup {
	
	List<Studente> list;

	public VerificaOrdDupList(LinkedList<Studente> list) {
		this.list = list;
	}
	
	@Override
	public boolean verificaDup() {
		
		Collections.sort(list);
		//System.out.println(list.toString());
		
		int i = 0;
		for (Iterator<Studente> iterator = list.iterator(); iterator.hasNext();) {
			Studente studente1 = (Studente) iterator.next();
			i+=1;
			for (Iterator<Studente> iterator2 = list.listIterator(i); iterator2.hasNext();) {
				Studente studente2 = (Studente) iterator2.next();
				if (studente1.equals(studente2))
					return true;
			}
		}
		return false;
	}
}
