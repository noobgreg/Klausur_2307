/**
 *Prog 2 Klausur 23.07.2021
 *
 *Aufgabe 1
 *
 *@author Gregor-Hendrik Laarmann, MatrikelNr: 9036940
 */
import java.util.NoSuchElementException;

public interface BufferIF<T extends Packet> {

    public int getSizePackets(); // liefert den aktuellen Füllstand des Puffers (Anzahl Pakete)
    public int getSizeBytes(); // liefert den aktuellen Füllstand des Puffers(Anzahl Bytes aller Pakete)
    public int getCapacity(); // liefert die maximale Kapazität des Puffers (in Bytes oder Paketen, je nach gefordertem Konstruktor)
    public Boolean insertPacket(T p); // fügt p in den Puffer ein und liefert TRUE wenn p eingefügt werden konnte, FALSE sonst
    public T removePacket() throws NoSuchElementException; // löscht ein Paket aus dem Puffer und gibt es zurück, oder wirft NoSuchElementException
    public T get(int pos) throws NoSuchElementException; // liefert das Paket an der Position pos, ohne es zu entfernen, oder wirft NoSuchElementExceptionDas erste Paket hat die Position 1.
}
