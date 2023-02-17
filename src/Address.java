public class Address {
    private int HouseNo, pincode;
    private String Area, City, Country;

    public Address(int houseNo, int pincode, String area, String city, String country) {
        HouseNo = houseNo;
        this.pincode = pincode;
        Area = area;
        City = city;
        Country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "HouseNo=" + HouseNo +
                ", pincode=" + pincode +
                ", Area='" + Area + '\'' +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
