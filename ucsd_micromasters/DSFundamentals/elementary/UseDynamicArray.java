public class UseDynamicArray {
    public static void main(String[] args) {
        DynamicArray A = new DynamicArray();

        A.append(1);
        A.append(6);
        A.append(4);
        A.append(7);
        A.append(4);
        A.append(7);

        System.out.println(A.get(1));
        System.out.println(A);
    }
}