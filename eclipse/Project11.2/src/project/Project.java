package project;

import java.util.GregorianCalendar;

public class Project {

	public static void main(String[] args){
		Person p = new Person();
		Student stu = new Student();
		Employee e = new Employee();
		Faculty f = new Faculty();
		Staff sta = new Staff();
		
		System.out.println(p.toString());
		System.out.println(stu.toString());
		System.out.println(e.toString());
		System.out.println(f.toString());
		System.out.println(sta.toString());
	}
}

class Person {
	  protected String name;
	  protected String address;
	  protected String phoneNumber;
	  protected String email;

	  @Override
	  public String toString() {
	    return "Person";
	  }
}

class Student extends Person {
	  public static int FRESHMAN = 1;
	  public static int SOPHOMORE = 2;
	  public static int JUNIOR = 3;
	  public static int SENIOR = 4;

	  protected int status;

	  @Override
	  public String toString() {
	    return "Student";
	  }
}

class Employee extends Person {
	  protected String office;
	  protected int salary;
	  protected MyDate dateHired;

	  @Override
	  public String toString() {
	    return "Employee";
	  }
}

class Faculty extends Employee {
	  public static int LECTURER = 1;
	  public static int ASSISTANT_PROFESSOR = 2;
	  public static int ASSOCIATE_PROFESSOR = 3;
	  public static int PROFESSOR = 4;

	  protected String officeHours;
	  protected int rank;

	  @Override
	  public String toString() {
	    return "Faculty";
	  }
}

class Staff extends Employee {
	  protected String title;

	  @Override
	  public String toString() {
	    return "Staff's title is " + title;
	  }
}

class MyDate {
	  private int year;
	  private int month;
	  private int day;
	  
	  MyDate() {    
	    GregorianCalendar date = new GregorianCalendar();
	    // Find year, month, and day from date. You write your own code to replace the out-dated get methods
	    year = date.get(GregorianCalendar.YEAR);
	    month = date.get(GregorianCalendar.MONTH);
	    day = date.get(GregorianCalendar.DAY_OF_MONTH);
	  }
	  
	  MyDate(long elapsedTime) {   
	    GregorianCalendar date = new GregorianCalendar();
	    date.setTimeInMillis(elapsedTime);
	    // Find year, month, and day from date. You write your own code to replace the out-dated get methods
	    year = date.get(GregorianCalendar.YEAR);
	    month = date.get(GregorianCalendar.MONTH);
	    day = date.get(GregorianCalendar.DAY_OF_MONTH);
	  }
	    
	  MyDate(int year, int month, int day) {
	    this.year = year;
	    this.month = month;
	    this.day = day;
	  }
	  
	  public int getYear() {
	    return year;
	  }

	  public int getMonth() {
	    return month;
	  }
	  
	  public int getDay() {
	    return day;
	  }
	  
	  public void setYear(int year) {
	    this.year = year;
	  }
	  
	  public void setMonth(int month) {
	    this.month = month;
	  }
	  
	  public void setDay(int day) {
	    this.day = day;
	  }  
}
