package SimpleDTUPay.model;

import java.util.Optional;
import java.util.UUID;

import SimpleDTUPay.PersonRegistry;

public class Person {
    protected String name;
    protected String id;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public Optional<Person> findById(String id) {
        return Optional.ofNullable(PersonRegistry.persons.get(id));
    }
}