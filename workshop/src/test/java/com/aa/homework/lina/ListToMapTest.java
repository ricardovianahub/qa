package com.aa.homework.lina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListToMapTest {

    private static class Animal {
        private String name;
        private Integer age;
        private String type;

        public Animal(String name, Integer age, String type) {
            this.name = name;
            this.age = age;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getType() {
            return type;
        }
    }
    private List<Animal> animalList;
    private Map<String, Animal> animalMap;

    @BeforeEach
    void setup() {
        animalList = new ArrayList<>();
        animalList.add(new Animal("Bessie", 10, "cow"));
        animalList.add(new Animal("Lassie", 2, "dog"));
        animalList.add(new Animal("Mittens", 5, "cat"));
        animalList.add(new Animal("Jessie", 9, "cow"));
        animalMap = new HashMap<>();
        for (Animal animal : animalList) {
            animalMap.put(animal.getType(), animal);
        }
    }

    @Test
    void doIhaveACowList() {
        boolean isFound = false;
        for (Animal animal : animalList) {
            if ("cow".equals(animal.getType())) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);
        assertEquals(4, animalList.size());
    }

    @Test
    void doIhaveACowMap() {
        assertTrue(animalMap.containsKey("cow"));
        assertEquals(3, animalMap.size());
    }

}
