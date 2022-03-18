package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    Department marketing = new Department(1, "Marketing");
    Department sales = new Department(2, "Sales");
    Department engineering = new Department(3, "Engineering");
    Employee deanJohnson = new Employee();
    Employee angieSmith = new Employee(2, "Angie", "Smith", "asmith@teams.com", engineering, "08/21/2020");
    Employee margaretThompson = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", marketing, "08/21/2020");
    Map<String, Project> projects = new HashMap<>();
    Project teams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");
    Project marketingLandingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
    List<Employee> marketingTeamMembers = new ArrayList<>();
    List<Employee> teamsTeamMembers = new ArrayList<>();

    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        angieSmith.raiseSalary(10);


        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("\n------------- DEPARTMENTS ------------------------------");
        for (Department department : departments)
            System.out.println(department.getName());
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        deanJohnson.setEmployeeId(1);
        deanJohnson.setFirstName("Dean");
        deanJohnson.setLastName("Johnson");
        deanJohnson.setEmail("djohnson@teams.com");
        deanJohnson.setSalary(60000);
        deanJohnson.setDepartment(engineering);
        deanJohnson.setHireDate("08/21/2020");
        employees.add(deanJohnson);
        employees.add(angieSmith);
        employees.add(margaretThompson);

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        

        for (Employee singular : employees) {
            System.out.println(singular.getFullName() + " (" + singular.getSalary() + ") " + singular.getDepartment().getName());
        }

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        for (Employee employee : employees) {
            if (employee.getDepartment().getName() == "Engineering") {
                teamsTeamMembers.add(employee);
            }
        }
        teams.setTeamMembers(teamsTeamMembers);
        projects.put("TEams", teams);

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        for (Employee employee : employees) {
            if (employee.getDepartment().getName() == "Marketing") {
                marketingTeamMembers.add(employee);
            }
        }
        marketingLandingPage.setTeamMembers(marketingTeamMembers);
        projects.put("Marketing Landing Page", marketingLandingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> project : projects.entrySet()) {
            System.out.println(project.getKey() + ": " + project.getValue().getTeamMembers().size());
        }
    }
}
