package com.refactoring.ch08.class07.before;

import com.refactoring.ch08.class07.Person;

import java.util.List;

public class CalculatorStep03 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("kim", 18, 28000000),
                new Person("lee", 19, 30000000),
                new Person("park", 21, 35000000)
        );

        var peopleStatistics = new PeopleStatistics(people);
        System.out.println(String.format("average Age: %.2f, average Salary: %.2f", peopleStatistics.getAverageAge(), peopleStatistics.getAverageSalary()));

        System.out.println(String.format("Total Age: %d, Total Salary: %d", peopleStatistics.getTotalAge(), peopleStatistics.getTotalSalary()));
    }

    private static class PeopleStatistics {
        private List<Person> people;
        private int totalAge;
        private int totalSalary;

        public int getTotalAge() {
            return totalAge;
        }

        public int getTotalSalary() {
            return totalSalary;
        }

        public PeopleStatistics(List<Person> people) {
            this.people = people;
            totalAge();
            totalSalary();
        }

        private void totalAge() {
            totalAge = people.stream()
                    .mapToInt(Person::getAge)
                    .sum();
        }

        private void totalSalary() {
            totalSalary = people.stream()
                    .mapToInt(Person::getSalary)
                    .sum();
        }

        public double getAverageSalary() {
            return (double) totalSalary / people.size();
        }

        public double getAverageAge() {
            return (double) totalAge / people.size();
        }
    }

}
