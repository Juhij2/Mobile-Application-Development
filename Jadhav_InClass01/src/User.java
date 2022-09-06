package com.company;

/*
 Assignment: InClass01
 File: User.java
 Student Name: Juhi Jayant Jadhav

 */

public class User {
    String firstname, lastname, email, gender, city, state;
    Integer age;

    User(String strings) {
        String[] arr = strings.split(",");

        this.firstname = arr[0];
        this.lastname = arr[1];
        this.age= Integer.valueOf(arr[2]);
        this.email = arr[3];
        this.gender = arr[4];
        this.city = arr[5];
        this.state = arr[6];

    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;
        User n = (User) o;
        return n.getFirstname().equals(this.firstname) &&
                n.getState().equals(this.state) &&
                n.getLastname().equals(this.lastname) &&
                n.getAge().equals(this.age) &&
                n.getCity().equals(this.city) &&
                n.getEmail().equals(this.email) &&
                n.getGender().equals(this.gender);

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getAge() {
        return age;
    }
}
