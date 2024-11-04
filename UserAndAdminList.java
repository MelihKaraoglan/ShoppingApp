package eticaret;
import java.util.ArrayList;
import java.util.List;

public class UserAndAdminList {
    private List<Customer> customerList;
    private List<Admin> adminList;

    public UserAndAdminList() {
        customerList = new ArrayList<>();
        adminList = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers() {
        adminList.add(new Admin("Melih Karaoğlan", "melihkaraoglann@gmail.com", "melihbaba5858"));
        adminList.add(new Admin("Arda Sakarya", "ardasakarya@gmail.com", "ardababapiro"));
        customerList.add(new Customer("John Doe", "john@example.com", "jjbabajava"));
    }

    public boolean login(String email, String password, String role) {
        if (role.equalsIgnoreCase("admin")) {
            for (Admin admin : adminList) {
                if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                    return true;
                }
            }
        } else if (role.equalsIgnoreCase("customer")) {
            for (Customer customer : customerList) {
                if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Admin getAdminByEmail(String email) {
        for (Admin admin : adminList) {
            if (admin.getEmail().equals(email)) {
                return admin;
            }
        }
        return null;
    }

    public Customer getUserByEmail(String email) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }
}
