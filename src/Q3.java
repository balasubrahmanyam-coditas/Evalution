interface  Test{
    void square(int number);
}
class Arithmetic implements Test{


    @Override
    public void square(int number) {
        int result = number*number;
        System.out.println(result);
    }
}
public class Q3 {
    public static void main(String[] args) {
        Test test = new Arithmetic();
        test.square(5);



    }
}
/*
25

Process finished with exit code 0

 */