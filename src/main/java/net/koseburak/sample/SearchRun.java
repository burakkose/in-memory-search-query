package net.koseburak.sample;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SearchRun {
    private final Logger logger = LoggerFactory.getLogger(SearchRun.class);
    private Map<String, Attribute> cacheAttributes;
    private CacheManager cm;
    private Cache cache;

    public SearchRun() {
        initializeCache();
        loadCache();
    }

    public static void main(String[] args) {
        SearchRun test = new SearchRun();
        test.run();
    }

    public void run() {
        Query query = cache.createQuery();
        query.includeKeys();
        query.includeValues();

        logger.info("Geting all data");

        for (Result res : query.execute().all()) {
            logger.info(res.getValue().toString());
        }

        logger.info("----------------------------");

        Attribute nameAtt = cacheAttributes.get("name");
        Attribute genderAtt = cacheAttributes.get("gender");
        Attribute ageAtt = cacheAttributes.get("age");

        logger.info("Getting data - Name = [*yb] and Gender = Male");

        query.addCriteria(nameAtt.ilike("*yb").and(genderAtt.eq(Person.Gender.MALE)));
        for (Result res : query.execute().all()) {
            logger.info(res.getValue().toString());
        }

        logger.info("----------------------------");
        logger.info("Getting data - Age between 4 and 6 and Gender = Female");

        Query ageQuery = cache.createQuery();
        ageQuery.includeValues();
        ageQuery.addCriteria(ageAtt.between(4, 6).and(genderAtt.eq(Person.Gender.FEMALE)));
        for (Result res : ageQuery.execute().all()) {
            logger.info(res.getValue().toString());
        }
    }

    private void initializeCache() {
        cm = CacheManager.newInstance();
        cache = cm.getCache("personCache");

        cacheAttributes = new HashMap<String, Attribute>();
        cacheAttributes.put("name", cache.getSearchAttribute("name"));
        cacheAttributes.put("gender", cache.getSearchAttribute("gender"));
        cacheAttributes.put("age", cache.getSearchAttribute("age"));
    }

    private void loadCache() {
        cache.put(new Element(1, new Person("Heya", 1, Person.Gender.MALE)));
        cache.put(new Element(2, new Person("Heyb", 2, Person.Gender.MALE)));
        cache.put(new Element(3, new Person("Heyc", 3, Person.Gender.FEMALE)));
        cache.put(new Element(4, new Person("Heyd", 4, Person.Gender.FEMALE)));
        cache.put(new Element(5, new Person("Heye", 5, Person.Gender.MALE)));
        cache.put(new Element(6, new Person("Heyf", 6, Person.Gender.FEMALE)));
    }
}
