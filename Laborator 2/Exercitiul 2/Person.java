public class Person {
    private String name;
    private String surname;
    private int age;
    private String idNo;
    private String type;

    public Person(String name, String surname, int age, String idNo, String type) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.idNo = idNo;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean changeType() {
        boolean changed = false;
        if(type.equals("teacher")) {
            type = "doctor";
            changed = true;
        }
        return changed;
    }

    public boolean changeTypeIsTheSame(String type) {
        return this.type.equals(type);
    }

    public String getPersonData() {
        return this.getName() + " " + this.getSurname() + " " + this.getAge() + " " + this.getIdNo() + " " + this.getType();
    }
}
