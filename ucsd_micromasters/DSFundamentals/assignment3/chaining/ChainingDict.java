import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.management.openmbean.KeyAlreadyExistsException;

class Node
{
    String key; String val;
    public Node(String key, String val) {
        this.key = key;
        this.val = val;
    }
}

public class ChainingDict
{
    private int m;
    private int p = 1000000007;
    private int x = 263;
    private LinkedList<Node>[] table;

    public ChainingDict(int bucketsNumber) {
        m = bucketsNumber;
        table = new LinkedList[m];
    }

    public int getBucketIndex(String word) {
        int rv=0;
        for (int i = 0; i < word.length(); i++){
            int c = word.charAt(i);
            rv += (c*(int)Math.pow(x, i)) % p;
        }
        return rv%m;
    }

    private Node findNode(String key) {
        int i = getBucketIndex(key);

        if(table[i] == null) {
            throw new NoSuchElementException("Not Found");
        }

        for(Node node: table[i]) {
            if(node.key == key) {
                return node;
            }
        }
        throw new NoSuchElementException("Not Found");
    }

    public void add(String key, String word) {
        int i = getBucketIndex(key);

        if(table[i] == null) {
           table[i] = new LinkedList<Node>();
        }
        try {
            Node node = findNode(key);
            node.val = word;
        }
        catch(NoSuchElementException e) {
            Node entry = new Node(key, word);
            table[i].add(entry);
        }
    }

    public String getVal(String key) {
        try {
            return findNode(key).val;
        }
        catch(NoSuchElementException e) {
            return "not found";
        }
    }
}


