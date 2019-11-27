package JUC.Directbuffermemory;

import java.nio.ByteBuffer;

public class DirectBufferMemory {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        ByteBuffer.allocateDirect(6*1024*1024);
    }
}
