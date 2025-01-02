package com.ex.junitbook.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.*;

@TestInstance(Lifecycle.PER_METHOD)
@DisplayName("테스트 대상 시스템 테스트")
class SystemUnderTestTest {

    private static ResourceForAllTests resourceForAllTests;
    private SystemUnderTest systemUnderTest;

    @BeforeAll
    static void setUpClass() {
        resourceForAllTests = new ResourceForAllTests("테스트를 위한 리소스");
    }

    @AfterAll
    static void tearDownClass() {
        resourceForAllTests.close();
    }

    @BeforeEach
    void setUp() {
        systemUnderTest = new SystemUnderTest("테스트 대상 시스템");
    }

    @AfterEach
    void tearDown() {
        systemUnderTest.close();
    }

    @Test
    @DisplayName("정상 동작 테스트")
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();

        assertTrue(canReceiveRegularWork);
    }

    @Test
    @DisplayName("추가 동작 테스트")
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();

        assertFalse(canReceiveAdditionalWork);
    }
}