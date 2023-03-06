package model;

public class Student implements Comparable<Student>
{
    //1. variables
    private long id;
    private String name;
    private String surname;
    private Faculty faculty;
    private String personCode;

    private static long studentCounter = 0;

    //constructors
    //no-args constructor
    public Student(){
        setId();
        setName("Unknown");
        setSurname("Unknown");
        setFaculty(Faculty.other);
        setPersonCode("000000-00000");
    }
    //args constructor
    public Student(String name, String surname, Faculty faculty, String personCode){
        setId();
        setName(name);
        setSurname(surname);
        setFaculty(faculty);
        setPersonCode(personCode);
    }


    //getters and setters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setId(){
        id = studentCounter;
        studentCounter++;
    }

    public void setName(String inputName) {
        if(inputName != null && inputName.matches("[A-ŽĪĶĻŠČ]")){
            name = inputName;
        } else {
            name = "Unknown";
        }
    }

    public void setPersonCode(String inputPersonCode){
        if(inputPersonCode != null && inputPersonCode.matches("[0-9]{6}[-][0-9]{5}")){
            personCode = inputPersonCode;
        } else {
            personCode = "000000-00000";
        }
    }

    public void setFaculty(Faculty inputFaculty){
        if(inputFaculty != null){
            faculty = inputFaculty;
        } else {
            faculty = Faculty.other;
        }
    }

    public String toString(){
        return "" + id + ": " + name + " " + surname + ", " + personCode + ", " + faculty;
    }

    @Override
    public int compareTo(Student o) {
        if(surname.charAt(0) > o.surname.charAt(0)) {
            return 1;
        } else if(surname.charAt(0) > o.surname.charAt(0)){
            return -1;
        } else {
            return 0;
        }
    }
}
