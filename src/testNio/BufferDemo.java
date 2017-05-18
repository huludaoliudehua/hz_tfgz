package testNio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		int byteRead = inChannel.read(buf);
		while(byteRead != -1){
			buf.flip();
			while(buf.hasRemaining()){
				System.out.println(buf.get());
			}
			buf.clear();
			byteRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
