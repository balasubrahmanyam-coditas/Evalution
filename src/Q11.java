class Calculate{
    private int length;
    private int breath;
    private int area;

    public Calculate() {
        this.length = length;
        this.breath = breath;
    }

    public void Area(){
        int area= length*breath;
        System.out.println(area);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreath() {
        return breath;
    }

    public void setBreath(int breath) {
        this.breath = breath;
    }

    public int getArea() {

        return getLength()*getBreath();
    }
    @Override
    public String toString() {
        return "Calculate{" +
                "length=" + length +
                ", breath=" + breath +
                ", area=" + area +
                '}';
    }
}
public class Q11 {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();

        calculate.setLength(23);
        calculate.setBreath(2);
        System.out.println(calculate.getArea());



    }
}
/*
46

Process finished with exit code 0

 */