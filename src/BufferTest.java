import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BufferTest {


    // Buffer der Größe 5 wird angelegt
    Buffer<Packet> buffer = new Buffer<>(5);

    // es werden 6 LowPrio Packete erstallt mit unterschiedlichen Bytegrößen
    LowPriorityPacket p1 = new LowPriorityPacket(10);
    LowPriorityPacket p2 = new LowPriorityPacket(10);
    LowPriorityPacket p3 = new LowPriorityPacket(10);
    LowPriorityPacket p4 = new LowPriorityPacket(10);
    LowPriorityPacket p5 = new LowPriorityPacket(5);
    LowPriorityPacket p6 = new LowPriorityPacket(1);

    // Hier wird überprüft, ob nachdem inserten die Pakete auch in der richtigen Reihenfolge(FIFO) wieder entnommen werden
    @Test
    void fivePacketsInOut() {

        // Ein Array mit 5 Paketen wird angelegt, in der Reihenfolge sollten die Pakete aus dem Buffer auch wieder entfernt werden
        LowPriorityPacket[] pfeld = new LowPriorityPacket[]{p1, p2, p3, p4, p5};

        buffer.insertPacket(p1);
        buffer.insertPacket(p2);
        buffer.insertPacket(p3);
        buffer.insertPacket(p4);
        buffer.insertPacket(p5);

        for (int i=0; i<5; i++) {
            assertEquals(pfeld[i], buffer.removePacket());
        }

    }

    // Hiermit wird überprüft, ob die richtige Exception geworfen wird, wenn man etwas aus einem leeren Puffer entnehmen möchte
    @Test
    void exceptionWhenEmpty() {

        assertThrows(NoSuchElementException.class, () -> buffer.removePacket());

    }

    // Hiermit wird überprüft, ob man nach einer vollständigen Leerung ein Paket wieder einfügen kann
    @Test
    void insertAfterEmpty() {

        buffer.insertPacket(p1);
        buffer.insertPacket(p2);
        buffer.insertPacket(p3);
        buffer.insertPacket(p4);
        buffer.insertPacket(p5);

        for (int i=0; i<buffer.array.length; i++) {
            buffer.removePacket();
        }
        assertTrue(buffer.insertPacket(p6));
    }

    // Hier wird der Puffer erstmal voll gemacht und dann auf unterschiedliche Funktionalitäten überprüft
    @Test
    void insertInFull() {

        buffer.insertPacket(p1);
        buffer.insertPacket(p2);
        buffer.insertPacket(p3);
        buffer.insertPacket(p4);
        buffer.insertPacket(p5);

        // Wird ein Paket Erfolgreich in den Puffer eingefügt...
        assertTrue(buffer.insertPacket(p6));
        // Und ist das Paket auch wirklich im Puffer vorhanden
        assertEquals(p6, buffer.get(5));

        // Ist die Gesamtzahl der Pakete richtig?
        assertEquals(5, buffer.getSizePackets());

        // Ist die Gesamtzahl der Bytes richtig?
        assertEquals(36, buffer.getSizeBytes());

        // Ist die maximale Kapazität richtig?
        assertEquals(5, buffer.getCapacity());


    }

}