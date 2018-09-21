
public class DirectAccess {
    private String[] table = new String[(int)Math.pow(10, 7)];

    public void add(int number, String name) {
        try {
            table[number] = name;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("number must 7 digit integer");
        }
    }

    public String find(int number) {
        if(table[number] == null || table[number] == "") {
            return "not found";
        }
        return table[number];
    }

    public void del(int number) {
        try {
            table[number] = "";
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("number must 7 digit integer");
        }
    }
}