package src;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Pessoa{

    protected static final long serialVersionUID = 1L;
    private long RG;
    private String name;
    private String Birthday;

    public Pessoa(){}

    public Pessoa(long RG, String name, String Birthday){
        setBirthday(Birthday);
        setName(name);
        setRG(RG);
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public long getRG() {
        return RG;
    }

    public void setRG(long RG) {
        this.RG = RG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean saveToFile(RandomAccessFile file)throws IOException{
        file.seek(file.length());
        file.writeLong(getRG());
        file.writeUTF(this.name);
        file.writeUTF(this.getBirthday());
        return true;
    }

    public boolean saveToFileIndex(RandomAccessFile file, long pointer) throws IOException{
            file.seek(file.length());
            file.writeLong(getRG());
            file.writeLong(pointer);
            return true;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nRg: " + getRG() +
                "\nBirthday: " + getBirthday();
    }
}
