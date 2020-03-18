
public class exercitiul4 {
    public static void main(String[] args) {
        Room r1 = new Room("12A", "normal", 3);
        Room r2 = new Room("12B", "tech", 7);
        Person p1 = new Person("Doe", "John", 24, "1123444", "student");
        Person p2 = new Person("Roe", "Jane", 56, "2233444", "teacher");
        Subject s1 = new Subject(r1, 24, p1);
        Subject s2 = new Subject(r2, 27, p2);

        s1.getSubjectData();
        s2.getSubjectData();
    }
}
