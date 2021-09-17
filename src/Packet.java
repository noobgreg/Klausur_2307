/*
zur Klausur bereitgestellte Klasse Packet
Implementiert ein Datenpaket
*/


public abstract class Packet implements Comparable<Packet>{
	private int priority;    // Priorität dieses Pakets
	private int size;        // Länge dieses Pakets (in Bytes)

	public Packet(int p, int s) {
		priority = p;
		size = s;
	}

	public int getPriority() {
		return priority;
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		return "[" + priority + "," + size + "]";
	}

	//Methode aus der Schnittstelle Comparable
	@Override
	public int compareTo(Packet other) {
		// positiver Rückgabewert, wenn Paket other kleiner ist
		return Integer.compare(this.priority, other.priority);
	}
}