package me.code;

public class Main {

    public static void main(String[] args) {
        ByteBuffer buffer = new ByteBuffer(256);

        buffer.writeInt(5);
        buffer.writeBoolean(true);
        buffer.writeString("Hejsan");

        buffer.printData();
        buffer.printDataAsChars();

        buffer.reset();

        System.out.println(buffer.readInt());
        System.out.println(buffer.readBoolean());
        System.out.println(buffer.readString());
    }
}
