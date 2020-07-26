package gittasks.DesignPatterns;

// Java code to demonstrate need of Builder Pattern 
  
// Server Side Code 
final class Student { 
  
    // instance fields 
    private int id; 
    private String name; 
    private String address; 
  
    // Setter Methods 
    // Note that all setters method 
    // return this reference 
    public Student setId(int id) 
    { 
        this.id = id; 
        return this; 
    } 
  
    public Student setName(String name) 
    { 
        this.name = name; 
        return this; 
    } 
  
    public Student setAddress(String address) 
    { 
        this.address = address; 
        return this; 
    } 
  
    @Override
    public String toString() 
    { 
        return "id = " + this.id + ", name = " + this.name +  
                               ", address = " + this.address; 
    } 
} 
  
// Client Side Code 
class StudentReceiver { 
  
    private final Student student = new Student(); 
  
    public StudentReceiver() 
    { 
  
        Thread t1 = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                student.setId(1).setName("Ram").setAddress("Noida"); 
            } 
        }); 
  
        Thread t2 = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                student.setId(2).setName("Shyam").setAddress("Delhi"); 
            } 
        }); 
  
        t1.start(); 
        t2.start(); 
    } 
  
    public Student getStudent() 
    { 
        return student; 
    } 
} 
  
// Driver class 
public class builder { 
    public static void main(String args[]) 
    { 
        StudentReceiver sr = new StudentReceiver(); 
        System.out.println(sr.getStudent()); 
    } 
} 