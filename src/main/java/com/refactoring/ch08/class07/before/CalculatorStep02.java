package com.refactoring.ch08.class07.before;

import com.refactoring.ch08.class07.Person;

import java.util.List;

public class CalculatorStep02 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("kim", 18, 28000000),
                new Person("lee", 19, 30000000),
                new Person("park", 21, 35000000)
        );

        var peopleStatistics = new PeopleStatistics(people);
        System.out.println(String.format("average Age: %.2f, average Salary: %.2f", peopleStatistics.getAverageAge(), peopleStatistics.getAverageSalary()));

    }

    private static class PeopleStatistics {
        private List<Person> people;

        public PeopleStatistics(List<Person> people) {
            this.people = people;
        }

        public double getAverageSalary() {
            return people.stream()
                    .mapToInt(Person::getSalary)
                    .average().orElse(0);
        }

        public double getAverageAge() {
            return people.stream()
                    .mapToInt(Person::getAge)
                    .average().orElse(0);
        }
    }


}
