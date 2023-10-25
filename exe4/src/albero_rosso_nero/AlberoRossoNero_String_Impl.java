package albero_rosso_nero;

import java.util.Iterator;
import java.util.TreeSet;

public class AlberoRossoNero_String_Impl implements AlberoRossoNero_String {

	private TreeSet<String> alberoRossoNero;

	public AlberoRossoNero_String_Impl() {
		this.alberoRossoNero = new TreeSet<>();
	}

	@Override
	public boolean insert(String s) {
		return alberoRossoNero.add(s);
	}

	@Override
	public boolean delete(String s) {
		return alberoRossoNero.remove(s);
	}

	@Override
	public boolean search(String s) {
		return alberoRossoNero.contains(s);
	}

	@Override
	public String inOrderString() {
		Iterator<String> i = alberoRossoNero.iterator();
		StringBuilder builder = new StringBuilder();
		if (i.hasNext())
			builder.append(i.next());
		while(i.hasNext()) {
			builder.append(", ");
			builder.append(i.next());

		}
		if (builder.isEmpty())
			builder.append("null");
		else 
			builder.append(".");
		return builder.toString();
	}

}
