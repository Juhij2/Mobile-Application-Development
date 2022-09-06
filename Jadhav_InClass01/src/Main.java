package com.company;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
 Assignment: InClass01
 File: Main.java
 Student Name: Juhi Jayant Jadhav
 */


import static com.company.Data.users;

public class Main {

    public static void main(String[] args) {
        fizzBuzz();

        while (true){
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter number to check even or odd: ");
            int num = scanner.nextInt();
            if (num==0) { // press 0 to break the loop.
                break;
            }else {
                isEven(num);

            }
        }

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements you want to store: ");
        int n = sc.nextInt();

        Integer[] MinNumber= new Integer[n];
        System.out.println("Enter the elements of array:");
        for (int i=0; i<n; i++){
            MinNumber[i] = sc.nextInt();
        }
        System.out.println("Array elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.println(MinNumber[i]);

        }
        System.out.println(getMinimum(MinNumber));

        ArrayList<User> user = new ArrayList<User>();
        ArrayList<User> otherUsers = new ArrayList<User>();
        user = getParsedUsers(users);
        System.out.println(user);

        otherUsers = getParsedUsers(Data.otherUsers);

        printUsers_OMN(user);

        printUsersSortedByAge(user);

        printUsersOldest10(user);

        printUserStateStats(user);

        getWordOverlap(Data.words_1, Data.words_2);

        getUserOverlap(user, otherUsers);

    }

    //Question 1
    public static void fizzBuzz(){
        System.out.println("Question1: FizzBuzz");
        int i;
        for (i=1; i<=20; i++) {
            if (i%3==0 && i%5==0) {
                System.out.println("FizzBuzz");
            } else if (i%3==0) {
                System.out.println("Fizz");
            } else if (i%5==0 ) {
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }

        }

    }

    //Question 2
    public static boolean isEven(Integer num){
        System.out.println(num%2==0);
        return (num%2==0);

    }

    //Question 3
    public static Integer getMinimum(Integer[] numbers){
        System.out.println("Question3: getMinimum");
        //System.out.println("numbers:" +numbers);
        if(numbers.length==0) {
            return null;
        }

        int minimum = numbers[0];

        for(int i = 0; i<numbers.length; i++) {
            if(numbers[i]<minimum) {
                minimum = numbers[i];
            }else {
                minimum = minimum;
            }

        }
        return minimum;
    }


    //Question 4
    public static ArrayList<User> getParsedUsers(String[] strings){
        //System.out.println("Question4: getparsedusers");
        ArrayList<User> StringArray =  new ArrayList<User>();
        for (String str: strings) {

            User user = new User(str);
            StringArray.add(user);

        }
        return StringArray;


    }

    //Question 5
    public static void printUsers_OMN(ArrayList<User> users){
        System.out.println("Method that prints user that starts with O, M or N");
        for (User user: users) {
            if (user.getFirstname().startsWith("O") || user.getFirstname().startsWith("M") || user.getFirstname().startsWith("N")) {
                System.out.println(user.getFirstname() + " " + user.getLastname());
            }
        }
    }


    //Question 6
    public static void printUsersSortedByAge(ArrayList<User> users){
        Collections.sort(users, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println("print users sorted by age");
        System.out.println(users);
    }

    //Question 7
    public static void printUsersOldest10(ArrayList<User> users){
        System.out.println("Print top 10 oldest users");
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        List<User> result = users.stream().limit(10).collect(Collectors.toList());
        System.out.println(result);

    }


    //Question 8
    public static void printUserStateStats(ArrayList<User> users){
        System.out.println("Print User state Stats");
        Map<String, Long> result = new HashMap<>();
        result = users.stream().collect(Collectors.groupingBy(User::getState, Collectors.counting()));
        System.out.println(result);
    }

    //Question 9
    public static Set<String> getWordOverlap(String[] listA, String[] listB){
        System.out.println("Get words overlap");
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (String a: listA) {
            set.add(a);
        }

        for (String b: listB) {
            if (set.contains(b)) result.add(b);
        }
        System.out.println(result);
        return result;
    }


    //Question 10
    public static ArrayList<User> getUserOverlap(ArrayList<User> usersA, ArrayList<User> usersB){
        System.out.println("get User overlap");
        List<User> result = usersA.stream()
                .filter(e -> usersB.contains(e))
                .collect(Collectors.toList());
        System.out.println(result);
        return new ArrayList<>(result);

    }

}
