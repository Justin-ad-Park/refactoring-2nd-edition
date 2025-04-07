package com.refactoring.ch08.class07.before;

import com.refactoring.ch08.class07.Person;

import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("kim", 18, 28000000),
                new Person("lee", 19, 30000000),
                new Person("park", 20, 35000000)
        );

        var averageAge = 0;
        var averageSalary = 0;

        for(Person person : people) {
            averageAge += person.getAge();
            averageSalary += person.getSalary();
        }

        averageAge = averageAge / people.size();
        averageSalary = averageSalary / people.size();

        System.out.println(String.format("average Age: %d, average Salary: %d", averageAge, averageSalary));

    }

}
