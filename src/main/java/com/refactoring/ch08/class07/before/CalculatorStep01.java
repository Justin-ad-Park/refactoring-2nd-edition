package com.refactoring.ch08.class07.before;

import com.refactoring.ch08.class07.Person;

import java.util.List;

public class CalculatorStep01 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("kim", 18, 28000000),
                new Person("lee", 19, 30000000),
                new Person("park", 21, 35000000)
        );

        var averageAge = getAverageAge(people);

        var averageSalary = getAverageSalary(people);

        System.out.println(String.format("average Age: %.2f, average Salary: %.2f", averageAge, averageSalary));

    }

    private static double getAverageSalary(List<Person> people) {
        return people.stream()
                .mapToInt(Person::getSalary)
                .average().orElse(0);
    }

    private static double getAverageAge(List<Person> people) {
        return people.stream()
                .mapToInt(Person::getAge)
                .average().orElse(0);
    }

}
