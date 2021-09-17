import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

        HighPriorityPacket h1 = new HighPriorityPacket(1);
        HighPriorityPacket h2 = new HighPriorityPacket(2);
        HighPriorityPacket h3 = new HighPriorityPacket(3);
        HighPriorityPacket h4 = new HighPriorityPacket(4);
        HighPriorityPacket h5 = new HighPriorityPacket(5);

        Buffer buffer = new Buffer(5);
        buffer.insertPacket(h1);
        buffer.insertPacket(h2);
        buffer.insertPacket(h3);
        buffer.insertPacket(h4);
        buffer.insertPacket(h5);
        //buffer.insertPacket(h1);

        System.out.println(buffer.removePacket());
        System.out.println(buffer.removePacket());
        System.out.println(buffer.removePacket());
        System.out.println(buffer.removePacket());

        System.out.println(Arrays.toString(buffer.array));
        System.out.println(buffer.array.length);

    }
}