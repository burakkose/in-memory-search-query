package net.koseburak.sample;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

import java.util.List;

public class PersonAttributes {
    public static final Attribute<Person, Integer> AGE = new SimpleAttribute<Person, Integer>("age") {
        @Override
        public Integer getValue(Person person, QueryOptions queryOptions) {
            return person.getAge();
        }
    };
    public static final Attribute<Person, Person.Gender> GENDER = new SimpleAttribute<Person, Person.Gender>("gender") {
        @Override
        public Person.Gender getValue(Person person, QueryOptions queryOptions) {
            return person.getGender();
        }
    };
    public static final Attribute<Person, Person> FRIENDS = new MultiValueAttribute<Person, Person>("friends") {
        @Override
        public List<Person> getValues(Person person, QueryOptions queryOptions) {
            return person.getFriends();
        }
    };
    public static final Attribute<Person, String> NAME = new SimpleAttribute<Person, String>("name") {
        @Override
        public String getValue(Person person, QueryOptions queryOptions) {
            return person.getName();
        }

    };
}
