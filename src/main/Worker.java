package com.github.factory;

import java.util.Objects;

class Worker {
    private final String name;
    private final int age;
    private final int salary;

    int getAge() {
        return age;
    }

    int getSalary() {
        return salary;
    }

    String getName() {
        return name;

    }
    private Worker(String name, int age, int salary) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(getName(), worker.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    static class Builder {
        private String name;
        private int age;
        private int salary;

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withAge(int age) {
            this.age = age;
            return this;
        }

        Builder withSalary(int salary) {
            this.salary = salary;
            return this;
        }

        Worker build() {
            return new Worker(name, age, salary);
        }
    }
}