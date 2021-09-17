import java.util.NoSuchElementException;

public class Buffer<T extends Packet> implements BufferIF<T> {

    private int sizePackets; // size packets variable
    private int sizeBytes; // size bytes variable
    private int capacity; // capacity variable
    public T[] array;

    @SuppressWarnings("unchecked")
    public Buffer(int pufferSizeInBytes) { // Konstruktor
        array = (T[]) new Packet[pufferSizeInBytes];
        capacity = pufferSizeInBytes;
    }

    @Override
    public int getSizePackets() { // Methode, die den aktuellen Füllstand des Puffers liefert
        return sizePackets;
    }

    @Override
    public int getSizeBytes() { // Methode, die den aktuellen Füllstand des Puffers liefert(anzahl bytes aller pakete)
        return sizeBytes;
    }

    @Override
    public int getCapacity() { // Methode, liefert die maximale Kapazität des Puffers(in bytes oder Paketen, je nach Konstruktor)
        return capacity;
    }

    @Override
    public Boolean insertPacket(T p) { // Methode, die p in den Puffer einfügt und liefert True, wenn p eingefügt werden konnte, sonst False

        if(getSizePackets() == getCapacity()) { // der Buffer voll ist, dann entferne ein Paket
            removePacket();
        }

        boolean insertErfolg = false; // boolean wert der zurückgegeben wird

        array[sizePackets] = p; // neues Paket wird in das Array eingefügt
        sizePackets++; // Anzahl der Pakete im Array wird um eins erhöht

        sizeBytes += p.getSize();

        if (sizePackets <= getCapacity()) { // wenn die Anzahl der Pakete im Array kleiner oder gleich der maximalen Arraykapazität ist,...
            insertErfolg = true; // ...dann war die insertion erfolgreich, sonst nicht
        }

        return insertErfolg;
    }

    @Override
    public T removePacket() { // Methode, die ein paket aus dem Puffer löscht und es zurückgibt oder NoSuchElementException wirft
        if(sizePackets == 0) throw new NoSuchElementException(); // werfe exception, falls array leer ist

        T ret = array[0]; // speichere das Paket, welches entfernt wird, um es zurückzugeben

        System.arraycopy(array, 1, array, 0, sizePackets-1); // kopiere alles in ein neues array, indem das erste element entfernt wird und alle pakete um eins nach links rücken

        sizePackets--; // reduziere größe um eins
        array[sizePackets] = null;

        sizeBytes -= ret.getSize();

        return ret; // entfernt element
    }

    @Override
    public T get(int pos) throws NoSuchElementException { // Methode, die das Paket an der Position "pos" liefert ohne es zu entfernen, oder wirft Exception

        if(pos > sizePackets+1){
            throw new NoSuchElementException();
        }

        return array[pos-1]; // gebe das pakete an der position pos zurück
    }
}
