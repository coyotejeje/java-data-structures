package fr.coyotejeje;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WorkingWithMaps {
    public static void main(String[] args) {

        Map<Person, Diamon>  map = new HashMap<>();
        map.put(new Person("Alfred"), new Diamon("African Diamond"));

        System.out.println(new Person("Alfred").hashCode());
        System.out.println(new Person("Alfred").hashCode());
        System.out.println(map.get(new Person("Alfred")));
    }

    private static void maps(Map<Integer, Person> map) {
        map.put(1, new Person("John"));
        map.put(2, new Person("Alexa"));
        map.put(3, new Person("Mariam"));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.containsKey(4));
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        System.out.println(map.remove(3));
        map.entrySet()
                .forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
        map.forEach((key, person) -> {
            System.out.println(key + " - " + person);
        });
        System.out.println(map.getOrDefault(3, new Person("default")));
        System.out.println(map.values());
    }

    static class Person{
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
    record Diamon(String name){}
}
