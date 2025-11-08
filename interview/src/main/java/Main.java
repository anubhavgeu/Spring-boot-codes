public class Main {
    static {
        System.out.println("Hello 1");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("Other");
        System.out.println("Hello 2");
        Other o = new Other();
    }
}
