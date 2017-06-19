import java.util.List;

import csvsample.Person;
import csvsample.Sort;
import csvsample.csv.CSVParser;

public class App {
    public static void main(String[] args) {
        String path = ClassLoader.getSystemResource("test.csv").getFile();

        List<Person> persons = CSVParser.parseFromFile(path, Person.class);
        persons.forEach(System.out::println);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");

        Sort.bubleSort(persons, Person::compareTo);
        persons.forEach(System.out::println);
    }
}
