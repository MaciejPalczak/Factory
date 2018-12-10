package com.github.maciejpalczakfactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        //addWorker();
        printWorkersDetails(createWorkers(2));
    }

    private static void addWorker() {
        Worker Adam = new Worker.Builder().withName("Adam").build();
        log.info("New worked added: {}", Adam.getName());
    }
    private static Set<Worker> createWorkers(int howManyWorkers) {
        Set<Worker> workers = new HashSet<>();
        int workersCreated = 0;
        while (workersCreated < howManyWorkers) {
            System.out.println("Creating new employee...\nEnter name: ");
            String name = scanner.next();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter salary: ");
            int salary = scanner.nextInt();
            try {
                workers.add(new Worker.Builder().withName(name).withAge(age).withSalary(salary).build());
                log.info("Successfully added new worker!");
            }catch(IllegalArgumentException ex){
                log.error("Exception while adding new worker: ", ex);
            }
            workersCreated++;
        }
        return workers;
    }
    private static void printWorkersDetails(Collection<Worker> workers) {
        workers.stream()

                .sorted(Comparator.comparing(Worker::getName))
                .forEach(worker -> log.info
                        ("Name: " + worker.getName() + " Age: " + worker.getAge() + " Salary: " + worker.getSalary()));
    }
}
