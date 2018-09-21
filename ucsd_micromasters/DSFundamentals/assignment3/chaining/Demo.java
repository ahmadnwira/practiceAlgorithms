import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        ChainingDict d = new ChainingDict(5);

        d.add("a", "a is the key");
        assert d.getVal("b") == "not found";
        assert d.getVal("a") == "a is the key";

        d.add("a", "should override previous value");
        assert d.getVal("a") == "should override previous value";

    }
}