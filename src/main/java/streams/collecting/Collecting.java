package streams.collecting;

import lambdas.Main;
import model.Apple;
import model.Person;

import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collecting {

    public static void main(String[] args) {

        List<Apple> apples = Main.getApples();

        //Created a stream and COLLECTED back to a list
        List<Apple> collectedApplesToList = apples.stream()
                .collect(Collectors.toList());

        Double averageWeight = apples.stream()
                                     .collect(Collectors.averagingInt(Apple::getWeight)); //Terminal operation

        System.out.println("Average weight of the apples: " + averageWeight);


        //Grouping by Color with method groupingBy which takes an Apple object and returns a Color
        Map<Apple.AppleColor, List<Apple>> groupedByColor = apples.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(groupedByColor);

        //Getting a bunch of persons
        List<Person> persons = Person.getPersons();

        //Getting the lastnames and producing a concatenated string delimited by comma
        String joinedLastNames = persons.stream()
                                        .map(Person::getLastName)
                                        .collect(Collectors.joining(", "));


        StringBuilder lastNames = new StringBuilder();
        Iterator<Person> iterator = Person.getPersons().iterator();
        while(iterator.hasNext()) {
            lastNames.append(iterator.next().getLastName());
            if(iterator.hasNext()) {
                lastNames.append(", ");
            }
        }

        System.out.println("LAST NAMES: " + lastNames);


        System.out.println("JOINED LAST NAMES: " + joinedLastNames);


        //Example of partitioning
        Map<Boolean, List<Person>> greaterThan20 = Person.getPersons().stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 30));

        System.out.println(greaterThan20);

        //Getting a summary when collecting
        IntSummaryStatistics statistics = Person.getPersons().stream()
                                                             .collect(Collectors.summarizingInt(Person::getAge));
        long count = statistics.getCount();
        int maxAge = statistics.getMax();
        int minAge = statistics.getMin();
        double averageAge = statistics.getAverage();
        System.out.println("Number of Persons: " + count );
        System.out.println("Max Age: " + maxAge );
        System.out.println("Min Age: " + minAge );
        System.out.println("Average Age: " + averageAge );

        //Variant returning zero if not present rather than Optional
        Long countPersons = Person.getPersons().stream().collect(Collectors.counting());


        Person defaultPerson = Person.getPersons().stream()
                                                  .findAny()
                                                  .orElseGet(() -> new Person("", "", 0, ""));
        System.out.println(defaultPerson);


        List<String> lastNamesList = Person.getPersons().stream()
                                                        .map(Person::getLastName)
                                                        .collect(Collectors.toList());


    }

}
