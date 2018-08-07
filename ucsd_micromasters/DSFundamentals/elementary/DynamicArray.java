import java.util.Arrays;

public class DynamicArray {

    private int[] arrayList;
    int INTIAL_SIZE = 4;
    int appendIndex = 0;

    public DynamicArray() {
        arrayList = new int[INTIAL_SIZE];
    }

    public int get(int index) {
        return arrayList[index];
    }

    public void append(int val) {
        try {
            arrayList[appendIndex] = val;
            appendIndex++;
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            int newLength = arrayList.length*2;
            arrayList = Arrays.copyOf(arrayList, newLength);
            this.append(val);
        }
    }

    @Override
    public String toString() {
        String rv="";
        for(int i = 0; i < arrayList.length; i++) {
            rv += arrayList[i] + ", ";
        }
        return rv;
    }
}