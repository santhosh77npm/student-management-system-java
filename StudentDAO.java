import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    public void deleteStudent(int id) {

    try {

        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM students WHERE id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student Deleted Successfully");
        } else {
            System.out.println("Student ID Not Found");
        }

    } catch (Exception e) {
        System.out.println(e);
    }
}
public void updateStudent(int id, String name, int age, String course, String email) {

    try {

        Connection con = DBConnection.getConnection();

        String query = "UPDATE students SET name=?, age=?, course=?, email=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, course);
        ps.setString(4, email);
        ps.setInt(5, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {
            System.out.println("Student Updated Successfully");
        } else {
            System.out.println("Student ID Not Found");
        }

    } catch (Exception e) {
        System.out.println(e);
    }
}
    public void addStudent(Student s) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, age, course, email) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getEmail());

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Email: " + rs.getString("email"));

                System.out.println("----------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}