package src;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Index {

    private long Rg;
    private long pointer;

    public Index(long Rg, long pointer){
        setRg(Rg);
        setPointer(pointer);
    }

    public Index(){
//        setRg(0);
//        setPointer(0);
    }

    public boolean saveToFileIndex(RandomAccessFile file) throws IOException {
        file.seek(file.length());
        file.writeLong(getRg());
        file.writeLong(getPointer());
        return true;
    }

    public long getRg() {
        return Rg;
    }

    public void setRg(long rg) {
        Rg = rg;
    }

    public long getPointer() {
        return pointer;
    }

    public void setPointer(long pointer) {
        this.pointer = pointer;
    }

    public static int getSizeHash(){
        return (Long.BYTES + Long.BYTES);
    }

    @Override
    public String toString() {
        return "Rg: " + getRg() + "\nPointer: " + getPointer();
    }
}
