import java.util.Comparator;

public class BufferPacketByteComparator implements Comparator<Buffer<Packet>> {

    @Override
    public int compare(Buffer o1, Buffer o2) {

        int paketeCompare = o1.getSizePackets() - o2.getSizePackets();
        int bytesCompare = o1.getSizeBytes() - o2.getSizeBytes();

        return (paketeCompare == 0) ? bytesCompare : paketeCompare;
    }

}
