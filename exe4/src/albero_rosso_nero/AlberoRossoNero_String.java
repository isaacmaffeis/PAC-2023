package albero_rosso_nero;

public interface AlberoRossoNero_String  {
	
	/** Inserire una nuova stringa nell’albero:
	 * I nuovi nodi vengono inseriti come nodi red
	 * 
	 * @param s Stringa da inserire
	 * @return true se è stata inserita correttamente, false altrimenti
	 */
	boolean insert(String s);
	
	/** Cancellare una stringa dell’albero
	 * 
	 * @param s Stringa da cancellare
	 * @return true se è stata rimossa correttamente, false altrimenti
	 */
	boolean delete(String s);
	
	/** Verificare se una stringa è stata inserita in precedenza
	 * 
	 * @param s Stringa da cercare nell'albero
	 * @return true se è presente, false altrimenti
	 */
	boolean search(String s);
	
	/** Visita inorder per concatenare tutte le stringhe presenti nell'albero 
	 * in ordine alfabetico
	 * 
	 * 
	 * @return una stringa ottenuta concatenando in ordine alfabetico
	 * tutte le stringhe memorizzate nell’albero.
	 */
	String inOrderString();

}
