import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> students = new HashMap<String, Student>();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới các sinh viên");
            System.out.println("3. Xóa sinh viên theo mã sinh viên");
            System.out.println("4. Tính điểm trung bình của tất cả sinh viên");
            System.out.println("5. In thông tin sinh viên có điểm trung bình lớn nhất");
            System.out.println("6. In thông tin sinh viên có tuổi nhỏ nhất");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayStudents(students);
                    break;
                case 2:
                    addStudent(students, sc);
                    break;
                case 3:
                    deleteStudent(students, sc);
                    break;
                case 4:
                    caculateStudentAvg(students);
                    break;
                case 5:
                    avgMax(students);
                    break;
                case 6:
                    ageMin(students);
                    break;
                case 7:
                    System.out.println("Kết thúc");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public static void displayStudents(Map<String, Student> students) {
        if(students.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        for(Map.Entry<String,Student> student : students.entrySet()) {
            System.out.println(student.getValue().toString());
        }
    }

    public static void addStudent(Map<String,Student> students, Scanner sc) {
        Student student = new Student();
        student.inputData(students, sc);
        System.out.println("Thêm thành công");
    }

    public static void deleteStudent(Map<String,Student> students, Scanner sc) {
        if(students.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = sc.next();
        if(students.containsKey(id)) {
            students.remove(id);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy mã sinh viên");
        }
    }

    public static void caculateStudentAvg(Map<String,Student> students) {
        float total = 0;
        for(Map.Entry<String,Student> student : students.entrySet()) {
            total += student.getValue().getAvg();
        }
        float avg = total / students.size();
        System.out.println("Điểm TB của tất cả sinh viên: " + String.format("%.2f", avg));
    }

    public static void avgMax(Map<String,Student> students) {
        List<Student> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(Student::getAge).reversed());
        System.out.println(list.getFirst().toString());
    }

    public static void ageMin(Map<String,Student> students) {
        List<Student> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(Student::getAge).reversed());
        System.out.println(list.getFirst().toString());
    }
}