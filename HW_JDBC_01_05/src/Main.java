/*Используя IntellijIdea и JDBC сделайте выборку при помощи JOIN’s для таких заданий:
1) Получите контактные данные сотрудников (номера телефонов, место жительства).
2) Получите информацию о дате рождения всех холостых сотрудников и их имена.
3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
 */


import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loading success!");
        System.out.println("-----------------------");

    } catch (ClassNotFoundException ex){
        ex.printStackTrace();
    }

        Queries query = new Queries();
        Queries queryOne = new Queries();
        Queries queryTwo = new Queries();

        List<Employees> employees = query.getAllEmployees();

        System.out.println("Контактные данные сотрудников (номера телефонов, место жительства):");
        for(Employees empl : employees){
            System.out.println(empl.getId_number() + "  " +empl.getFull_name()
                        + "  " + empl.getTelephone() + "  " + empl.getAddress());
        }

        System.out.println("-------------------------------------");

        List<Employees> employeesOne = queryOne.getAllMarital();

        System.out.println("Данные о дате рождения всех холостых сотрудников:");
        for(Employees emp : employeesOne){
            System.out.println( emp.getFull_name() + "  " + emp.getBirthday() + "  " + emp.getFamily_status());
        }

        System.out.println("-------------------------------------");

        List<Employees> employeesTwo = queryTwo.getPosition();
        System.out.println("Данные обо всех менеджерах компании (номер телефона, дата рождения):");
        for(Employees em : employeesTwo){
            System.out.println(em.getId_number() + "  " + em.getFull_name() + "  "  + em.getPosition() +  "  "
                                                                    + em.getBirthday() + "  " + em.getTelephone());
        }
    }
}