package me.code;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ByteBuffer {

    private byte[] data;
    private int position = 0;

    public ByteBuffer() {
        this.data = new byte[64];
    }

    public ByteBuffer(int initialCapacity) {
        this.data = new byte[initialCapacity];
    }

    public void writeInt(int num) {
        data[position++] = (byte) ((num >>> 24) & 0xFF);
        data[position++] = (byte) ((num >>> 16) & 0xFF);
        data[position++] = (byte) ((num >>> 8) & 0xFF);
        data[position++] = (byte) ((num) & 0xFF);
    }

    public void writeLong(long num) {
        data[position++] = (byte) ((num >>> 56) & 0xFF);
        data[position++] = (byte) ((num >>> 48) & 0xFF);
        data[position++] = (byte) ((num >>> 40) & 0xFF);
        data[position++] = (byte) ((num >>> 32) & 0xFF);
        data[position++] = (byte) ((num >>> 24) & 0xFF);
        data[position++] = (byte) ((num >>> 16) & 0xFF);
        data[position++] = (byte) ((num >>> 8) & 0xFF);
        data[position++] = (byte) ((num) & 0xFF);
    }

    public void writeBoolean(boolean b) {
        data[position++] = b ? (byte) 1 : (byte) 0;
    }

    public void writeString(String s) {
        writeInt(s.length());
        for (int i = 0; i < s.length(); i++)
            data[position++] = (byte) s.charAt(i);
    }

    public int readInt() {
        return (data[position++] << 24)
                + (data[position++] << 16)
                + (data[position++] << 8)
                + (data[position++]);
    }

    public boolean readBoolean() {
        return data[position++] == 1;
    }

    public String readString() {
        int length = readInt();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = (char) data[position++];
            s.append(c);
        }

        return s.toString();
    }

    public void printData() {
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }

    public void printDataAsChars() {
        for (int i = 0; i < data.length; i++)
            System.out.print((char) data[i] + " ");
        System.out.println();
    }

    public void reset() {
        this.position = 0;
    }

}
