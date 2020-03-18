public class exercitiul3 {
    public static void main(String[] args) {
        Room r1 = new Room("12A", "normal", 3);
        Room r2 = new Room("12B", "tech", 7);

        System.out.println(r1.getNumber() + " " + r1.getType() + " " + r1.getFloor());
        System.out.println(r2.getNumber() + " " + r2.getType() + " " + r2.getFloor());

    }
}
