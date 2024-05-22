package com.springbootprojects.myfirstproject.hero;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeroMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println(
            "Before all test methods"
        );
    }

    @AfterAll
    static void afterAll() {
        System.out.println(
            "After all test methods"
        );
    }

    @BeforeEach
    void setUp() {
        System.out.println(
            "Before each test method"
        );
    }

    @AfterEach
    void tearDown() {
        System.out.println(
            "After each test method"
        );
    }

    @Test
    public void testMethod1() {
        System.out.println(
            "This is my first test method"
        );
    }

    @Test
    public void testMethod2() {
        System.out.println(
            "This is my second test method"
        );
    }
}


