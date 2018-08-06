package com.tkd.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadLargeFile {

	public static void main(String[] args) throws IOException {
		long currentTIme = System.currentTimeMillis();
		RandomAccessFile ranFile = new RandomAccessFile("D:\\2GB.txt", "r");
		FileChannel channel = ranFile.getChannel();
		
		ByteBuffer buff = ByteBuffer.allocate(1000);
		
		int bytesRead = channel.read(buff);
		while(bytesRead != -1) {
			System.out.println("Read: "+ bytesRead);
			buff.flip();
			while(buff.hasRemaining()) {
				buff.get();
			}
			buff.clear();
			bytesRead = channel.read(buff);
		}
		ranFile.close();
		
		System.out.println("Time: " + (System.currentTimeMillis() - currentTIme));
	}

}
