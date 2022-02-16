package com.makotojava.learn.hellojunit5;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the
 * {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform
 * JUnitPlatform} class.</li>
 * <li>Give the class a cool
 * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the
 * JUnit test
 * report.</li>
 * </ol>
 *
 */
@RunWith(JUnitPlatform.class)
@DisplayName("JUnit 5 tests")
public class JUnit5AppTest {

  // Create a JDK Logger here
  private static final Logger log = LoggerFactory.getLogger(JUnit5AppTest.class);

  // Create a fixture for the class under test
  private App app = new App();

  // Do something before ANY test is run in this class
  @BeforeAll
  public static void init() {
    log.info("Before all: init()");
  }

  // Do something after ALL tests in this class are run
  @AfterAll
  public static void done() {
    log.info("after all: done()");
  }

  @BeforeEach
  public void setUp() throws Exception {
    log.info("Before each: setUp()");
  }

  @AfterEach
  public void tearDown() throws Exception {
    log.info("After each: tearDown()");
  }

  // Create an instance of the test class before each @Test method is executed

  // Destroy reference to the instance of the test class after each @Test method
  // is executed

  // Disabled test
  void testNotRun() {
  }

  /**
   * testAdd() - Exercises:
   * <ol>
   * <li>Tell JUnit this method is a test method.</li>
   * <li>Give it a cool display name for the test report.</li>
   * <li>The reference to the class under test cannot be null. If it is, the test
   * should fail.</li>
   * <li>Create a group of three tests of the add methods with the following
   * arrays of positive numbers:
   * <ol>
   * <li>1, 2, 3, 4</li>
   * <li>20, 934, 110</li>
   * <li>2, 4, 6</li>
   * </ol>
   * Ensure the actual sum matches the expected sum for each group of numbers.
   * Make sure that all groups of numbers are
   * tested (i.e., if one fails, it should not fail the test method). Hint: use
   * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
   * assertAll()}
   * </ol>
   */
  @Test
  @DisplayName("Adding operands test")
  public void testAdd() {
    App app = new App();
    long[] test1 = { 1, 2, 3, 4 };
    long result1 = app.add(test1);
    long expected1 = 10;

    long[] test2 = { 20, 934, 110 };
    long result2 = app.add(test2);
    long expected2 = 1064;
    // assertEquals(result2, expected2);

    long[] test3 = { 2, 4, 6 };
    long result3 = app.add(test3);
    long expected3 = 12;
    // assertEquals(result3, expected3);

    assertAll("Adding operands", 
    () -> {assertEquals(result1, expected1);}, 
    () -> {assertEquals(result2, expected2);},
    () -> {assertEquals(result3, expected3);}
    );
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use
   * {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool
   * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the
   * JUnit test
   * report.</li>
   * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App
   * App} class specifically for this nested
   * class:
   * <ul>
   * <li>Set the <code>classUnderTest</code> variable in a method called
   * <code>setUp()</code> that runs before the test
   * method does (hint: use
   * {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
   * </ul>
   * <li>Set the <code>classUnderTest</code> variable to null in a method called
   * <code>tearDown()</code> that runs after
   * the
   * test method does (hint: use
   * {@link org.junit.jupiter.api.BeforeEach @AfterEach})</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Negative number tests")
  class NegativeNumbersTest {

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test
     * should fail.</li>
     * <li>Create a group of three tests of the add methods with the following
     * arrays of positive numbers:
     * <ol>
     * <li>-1, -2, -3, -4</li>
     * <li>-20, -934, -110</li>
     * <li>-2, -4, -6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers.
     * Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
     * assertAll()}
     * </ol>
     */

    @Test
    @DisplayName("Adding negative operands test")
    public void testAdd() {
      App app = new App();
      long[] test1 = {-1, -2, -3, -4};
      long result1 = app.add(test1);
      long expected1 = -1 - 2 - 3 - 4;

      long[] test2 = {-20, -934, -110};
      long result2 = app.add(test2);
      long expected2 = -20 - 934 - 110;
      // assertEquals(result2, expected2);

      long[] test3 = {-2, -4, -6};
      long result3 = app.add(test3);
      long expected3 = -2 - 4 - 6;
      // assertEquals(result3, expected3);

      assertAll("Adding", () -> assertEquals(result1, expected1), () -> assertEquals(result2, expected2),
          () -> assertEquals(result3, expected3));
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use
   * {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool
   * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the
   * JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Positive and negative numbers test")
  class PositiveAndNegativeNumbersTest {

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test
     * should fail.</li>
     * <li>Create a group of three tests of the add methods with the following
     * arrays of positive numbers:
     * <ol>
     * <li>-1, 2, -3, 4</li>
     * <li>-20, 934, -110</li>
     * <li>-2, -4, 6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers.
     * Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
     * assertAll()}
     * </ol>
     */

    @Test
    @DisplayName("Adding positive and negative operands test")
    public void testAdd() {
      App app = new App();
      long[] test1 = {-1, -2, -3, -4};
      long result1 = app.add(test1);
      long expected1 = -1 - 2 - 3 - 4;

      long[] test2 = {-20, -934, -110};
      long result2 = app.add(test2);
      long expected2 = -20 - 934 - 110;

      long[] test3 = {-2, -4, -6};
      long result3 = app.add(test3);
      long expected3 = -2 - 4 - 6;

      assertAll("Adding", () -> assertEquals(result1, expected1), () -> assertEquals(result2, expected2),
          () -> assertEquals(result3, expected3));
    }

    /**
     * testAdd_OnlyOnFriday - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along
     * with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean) assumeTrue()})
     * that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the
     * test is skipped.</li>
     * <li>Pass the following numbers as operands to the
     * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Test adding on Friday")
    public void testAdd_OnlyOnFriday() {
      LocalDateTime date = LocalDateTime.now();
      if (date.getDayOfWeek() == DayOfWeek.FRIDAY) log.info("Test was skipped because it is not Friday");
      assumeTrue(date.getDayOfWeek() == DayOfWeek.FRIDAY, "Today is not Friday");
      long[] operands = { 1, 2, 3, 4, 5 };
      long expected = 15;
      long result = app.add(operands);
      assertEquals(expected, result);
    }

    /**
     * testAdd_OnlyOnFriday_WithLambda - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along
     * with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
     * assumingThat()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the
     * test is skipped.</li>
     * <li>Pass the following numbers as operands to the
     * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Test adding on Friday with lambda")
    public void testAdd_OnlyOnFriday_WithLambda() {
      LocalDateTime date = LocalDateTime.now();
      long[] operands = { 1, 2, 3, 4, 5 };
      long expected = 15;
      long result = app.add(operands);
      assumingThat(date.getDayOfWeek().getValue() == 5,
          () -> {
            assertEquals(expected, result);
          });
    }

  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use
   * {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool
   * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the
   * JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Single operand tests")
  class JUnit5AppSingleOperandTest {

    /**
     * testAdd_NumbersGt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test
     * should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays
     * of positive numbers:
     * <ol>
     * <li>1</li>
     * <li>0</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers.
     * Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
     * assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Adding positive numbers with one operand test")
    public void testAdd_NumbersGt0() {
      long[] test1 = {1};
      long result1 = app.add(test1);
      long expected1 = 1;
      long[] test2 = {0};
      long result2 = app.add(test2);
      long expected2 = 0;
      assertAll("Adding", () -> assertEquals(result1, expected1), () -> assertEquals(result2, expected2));
    }

    /**
     * testAdd_NumbersLt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test
     * should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays
     * of positive numbers:
     * <ol>
     * <li>-1</li>
     * <li>-10</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers.
     * Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
     * assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Adding negative numbers with one operand test")
    public void testAdd_NumbersLt0() {
      long[] test1 = {-1};
      long result1 = app.add(test1);
      long expected1 = -1;
      long[] test2 = {-10};
      long result2 = app.add(test2);
      long expected2 = -10;
      assertAll("Adding", () -> assertEquals(result1, expected1), () -> assertEquals(result2, expected2));
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use
   * {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool
   * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the
   * JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("No operands tests")
  class JUnit5AppZeroOperandsTest {

    /**
     * testAdd_ZeroOperands_EmptyArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test
     * should fail.</li>
     * <li>Pass an empty array as operands argument to the
     * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException
     * IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * </ol>
     */
    @Test
    @DisplayName("Empty array test")
    public void testAdd_ZeroOperands_EmptyArgument() {
      long[] operands = {};
      try {
      app.add(operands);
      }catch (IllegalArgumentException exception) {
        assertThrows(IllegalArgumentException.class, ()-> app.add(operands));
      }
      
    }

    /**
     * testAdd_ZeroOperands_NullArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test
     * should fail.</li>
     * <li>Pass an empty array as operands argument to the
     * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException
     * IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * <li>The test should fail if the message in the exception is not "Operands
     * argument cannot be null".</li>
     * </ol>
     */
    @Test
    @DisplayName("Null array test")
    public void testAdd_ZeroOperands_NullArgument() {
      long[] operands = {};
      try {
        app.add(operands);
      } catch (Exception e) {
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> app.add(operands));
        assertEquals("Operands argument cannot be empty", exception.getMessage());
      }
      
      
    }

  }

}
