package com.example.Task_2.seed;
import com.example.Task_2.model.Course;
import com.example.Task_2.model.Instructor;
import com.example.Task_2.model.Student;
import com.example.Task_2.repository.CourseRepository;
import com.example.Task_2.repository.InstructorRepository;
import com.example.Task_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseSeeder {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void seedDatabase() {
        // Clear existing data
        studentRepository.deleteAll();
        courseRepository.deleteAll();
        instructorRepository.deleteAll();

        // 1. Create Instructors
        Instructor instructor1 = new Instructor("Alice Instructor", "alice.instructor@example.com");
        Instructor instructor2 = new Instructor("Bob Instructor", "bob.instructor@example.com");
        Instructor instructor3 = new Instructor("Charlie Instructor", "charlie.instructor@example.com");
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);

        // 2. Create Courses and assign them to instructors
        Course course1 = new Course("Mathematics", "MATH101", 3, instructor1);
        Course course2 = new Course("Physics", "PHYS101", 4, instructor1);
        Course course3 = new Course("Chemistry", "CHEM101", 3, instructor1);
        Course course4 = new Course("History", "HIST101", 3, instructor2);
        Course course5 = new Course("Geography", "GEO101", 2, instructor2);
        Course course6 = new Course("Computer Science", "CS101", 4, instructor3);
        Course course7 = new Course("Literature", "LIT101", 3, instructor3);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);
        courseRepository.save(course7);

        // 3. Create Students
        Student student1 = new Student("John Doe", "john@example.com");
        Student student2 = new Student("Jane Doe", "jane@example.com");
        Student student3 = new Student("Jim Bean", "jim@example.com");
        Student student4 = new Student("Jill Smith", "jill@example.com");
        Student student5 = new Student("Mark Twain", "mark@example.com");
        Student student6 = new Student("Susan Collins", "susan@example.com");
        Student student7 = new Student("Peter Parker", "peter@example.com");
        Student student8 = new Student("Bruce Wayne", "bruce@example.com");
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
        studentRepository.save(student8);

        // 4. Enroll Students in Courses using the CourseRepository methods
        // Course 1: Mathematics - enroll student1, student2, student3
        courseRepository.enrollStudent(course1.getId(), student1.getId());
        courseRepository.enrollStudent(course1.getId(), student2.getId());
        courseRepository.enrollStudent(course1.getId(), student3.getId());

        // Course 2: Physics - enroll student2, student3, student4
        courseRepository.enrollStudent(course2.getId(), student2.getId());
        courseRepository.enrollStudent(course2.getId(), student3.getId());
        courseRepository.enrollStudent(course2.getId(), student4.getId());

        // Course 3: Chemistry - enroll student1, student5
        courseRepository.enrollStudent(course3.getId(), student1.getId());
        courseRepository.enrollStudent(course3.getId(), student5.getId());

        // Course 4: History - enroll student3, student4, student6
        courseRepository.enrollStudent(course4.getId(), student3.getId());
        courseRepository.enrollStudent(course4.getId(), student4.getId());
        courseRepository.enrollStudent(course4.getId(), student6.getId());

        // Course 5: Geography - enroll student5, student6, student7
        courseRepository.enrollStudent(course5.getId(), student5.getId());
        courseRepository.enrollStudent(course5.getId(), student6.getId());
        courseRepository.enrollStudent(course5.getId(), student7.getId());

        // Course 6: Computer Science - enroll student7, student8
        courseRepository.enrollStudent(course6.getId(), student7.getId());
        courseRepository.enrollStudent(course6.getId(), student8.getId());

        // Course 7: Literature - enroll student6, student7, student8
        courseRepository.enrollStudent(course7.getId(), student6.getId());
        courseRepository.enrollStudent(course7.getId(), student7.getId());
        courseRepository.enrollStudent(course7.getId(), student8.getId());
    }
}
