/*
zur Klausur bereitgestellte Klasse LowPriorityPacket
Datenpaket mit nirdriger Priorität
*/

public class LowPriorityPacket extends Packet{
	LowPriorityPacket(int s){	// Packet mit 's' Bytes
		super(1,s);
	}
}
