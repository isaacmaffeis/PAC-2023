public class Main {
	public static void main(String[] args) {
    
		SaxParser p = new SaxParser();
		p.parseDocument("libro.xml");
		p.printBooks();
		
  }
}