class Student{
    int id;
    String name;
    Address address;

    public Student(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
class TeacherTeches{
    int id;
    String name;
    Address address;

    public TeacherTeches(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class Q5 {
    public static void main(String[] args) {
        Address address = new Address(212,534980,"Ramoji","Chennai","India");
        //Address address2 = new Address(212,534980,"Ramoji","Chennai","India");
        Student student = new Student(1,"Lucky",address);
        TeacherTeches teacher = new TeacherTeches(2,"John",address);
        System.out.println(student);
        System.out.println(teacher);

    }
}
/*
Student{id=1, name='Lucky', address='Address{HouseNo=212, pincode=534980, Area='Ramoji', City='Chennai', Country='India'}'}
Teacher{id=2, name='John', address=Address{HouseNo=212, pincode=534980, Area='Ramoji', City='Chennai', Country='India'}}

Process finished with exit code 0

 */