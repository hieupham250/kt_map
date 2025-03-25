import java.util.Map;
import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;
    private float avg;

    public Student() {
    }

    public Student(String id, String name, int age, float avg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getAvg() {
        return avg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public void inputData(Map<String, Student> students, Scanner sc) {
        System.out.println("Nhập mã sinh viên: ");
        sc.nextLine();
        String id = sc.nextLine();
        while (true) {
            if (!students.containsKey(id)) {
                break;
            }
            System.out.println("Mã sinh viên đã tồn tại. Nhập lại");
            id = sc.nextLine();
        }
        System.out.println("Nhập tên sinh viên:");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi sinh viên:");
        int age = sc.nextInt();
        while (true) {
            if (age > 0) {
                break;
            } else {
                System.out.println("Tuổi không hợp lệ. Nhập lại");
                age = sc.nextInt();
            }

        }
        System.out.println("Nhập điểm trung bình:");
        sc.nextLine();
        float avg = sc.nextFloat();
        while (true) {
            if (avg > 0) {
                break;
            } else {
                System.out.println("Điểm không hợp lệ");
                avg = sc.nextFloat();
            }
        }
        students.put(id, new Student(id, name, age, avg));
    }

    @Override
    public String toString() {
        return "Mã SV: " + id + ", Tên: " + name + ", Tuổi: " + age + ", Điểm TB: " + avg;
    }
}
