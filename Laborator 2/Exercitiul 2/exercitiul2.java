public class exercitiul2 {
    public static void main(String[] args) {
        Person p1 = new Person("Doe", "John", 24, "1123444", "student");
        Person p2 = new Person("Roe", "Jane", 56, "2233444", "teacher");

        System.out.println(p1.getSurname() + " " + p1.getName() + " " + p1.getAge() + " " + p1.getIdNo() + " " + p1.getType());
        System.out.println(p2.getSurname() + " " + p2.getName() + " " + p2.getAge() + " " + p2.getIdNo() + " " + p2.getType());
    }
}
