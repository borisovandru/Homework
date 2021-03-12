package ru.geekbrains.lesson4;

// ** Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//* Конструктор класса должен заполнить эти поля при создании объекта;
//* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//* Создать массив из 5 сотрудников;
//* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

public class lesson4 {
    public static void main(String[] args) {
        Employee[] empCorp = new Employee[5];
        empCorp[0] = new Employee("Suvorov Alexander", "Engineer", "suvorov@mailbox.com", "89771231252",35000,43);
        empCorp[1] = new Employee("Petrov Petr", "Designer", "petrov@mailbox.com", "89261231443",45000,51);
        empCorp[2] = new Employee("Ivanov Ivan", "Electrician", "ivanov@mailbox.com", "89371231556",28000,33);
        empCorp[3] = new Employee("Lebedev Masha", "Lawyer", "lebedeva@mailbox.com", "89271231688",56000,38);
        empCorp[4] = new Employee("Fedorovic Fedor", "Loader", "fedorovic@mailbox.com", "89601231778",12000,32);
        for (Employee employee : empCorp)
            if (employee.getAge()>40)
                System.out.println(employee);
    }

    static class Employee {
        private final String name;
        private final String position;
        private final String email;
        private final String phone;
        private final int salary;
        private final int age;

        public Employee(String name, String position, String email, String phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return (name + "\n-"
                    + position + "\n-"
                    + email + "\n-"
                    + phone + "\n-"
                    + salary + "\n-"
                    + age);
        }
    }
}
