
public class Employees {
    private int id_number;
    private String full_name;
    private String telephone;
    private String position;
    private int salary;
    private String family_status;
    private String birthday;
    private String address;


    public Employees(int id_number, String full_name, String telephone, String address) {
        this.id_number = id_number;
        this.full_name = full_name;
        this.telephone = telephone;
        this.address = address;
    }

    public Employees(String full_name, String family_status, String birthday) {
        this.full_name = full_name;
        this.family_status = family_status;
        this.birthday = birthday;
    }

    public Employees(int id_number, String full_name, String position, String telephone, String birthday) {
        this.id_number = id_number;
        this.full_name = full_name;
        this.position = position;
        this.telephone = telephone;
        this.birthday = birthday;
    }

    public int getId_number() {
            return id_number;
        }

        public String getFull_name() {
            return full_name;
        }

        public String getTelephone() {
            return telephone;
        }

        public String getPosition() {
            return position;
        }

        public String getFamily_status() {
            return family_status;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getAddress() {
            return address;
        }
}
