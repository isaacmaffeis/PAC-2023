package albero_rosso_nero;

public class AlberoRossoNero_Demo {
	
	public static void main(String[] args) {
		
		AlberoRossoNero_String alberoRossoNero = new AlberoRossoNero_String_Impl();
		
		System.out.println("Albero vuoto: " + alberoRossoNero.inOrderString());

		alberoRossoNero.insert("AAA");
		
		System.out.println("Inserimento di AAA: " + alberoRossoNero.inOrderString());
		
		alberoRossoNero.insert("AAB");

		alberoRossoNero.insert("BCD");

		alberoRossoNero.insert("MNO");

		alberoRossoNero.insert("BOZ");
		
		alberoRossoNero.insert("ABC");
		
		alberoRossoNero.insert("ABD");

		System.out.println("Serie di inserimenti: " + alberoRossoNero.inOrderString());
		
		alberoRossoNero.delete("ABD");

		System.out.println("Rimozione di ABD: " + alberoRossoNero.inOrderString());
		
		System.out.println("Rimozione di XYZ: " + alberoRossoNero.inOrderString());
		
		System.out.println("Search di ABC: " + alberoRossoNero.search("ABC"));

		System.out.println("Search di XYZ: " + alberoRossoNero.search("XYZ"));
		
	}

}
