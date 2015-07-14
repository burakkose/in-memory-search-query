package net.koseburak.sample;


import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.googlecode.cqengine.query.QueryFactory.equal;
import static com.googlecode.cqengine.query.QueryFactory.or;

public class SampleRun {
    private final Logger logger = LoggerFactory.getLogger(SampleRun.class);
    private IndexedCollection<Person> people;

    public SampleRun() {
        people = new ConcurrentIndexedCollection<Person>();
        people.addIndex(HashIndex.onAttribute(PersonAttributes.NAME));
        people.addIndex(HashIndex.onAttribute(PersonAttributes.AGE));
        loadData();
    }

    public static void main(String[] args) {
        SampleRun test = new SampleRun();
        test.run();
    }

    public void run() {
        Query<Person> query1 = or(equal(PersonAttributes.NAME, "heyc"), equal(PersonAttributes.AGE, 7));
        for (Person person : people.retrieve(query1)) {
            logger.info(person.toString());
        }
    }

    private void loadData() {
        people.add(new Person("heya", 1, Person.Gender.FEMALE));
        people.add(new Person("heyb", 2, Person.Gender.FEMALE));
        people.add(new Person("heyc", 3, Person.Gender.MALE));
        people.add(new Person("heyd", 4, Person.Gender.FEMALE));
        people.add(new Person("heye", 5, Person.Gender.MALE));
        people.add(new Person("heyf", 6, Person.Gender.FEMALE));
        people.add(new Person("heyg", 7, Person.Gender.MALE));
        people.add(new Person("heyh", 8, Person.Gender.FEMALE));
        people.add(new Person("heyi", 9, Person.Gender.MALE));
    }
}
