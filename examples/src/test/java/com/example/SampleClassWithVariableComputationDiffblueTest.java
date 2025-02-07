package com.example;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SampleClassWithVariableComputationDiffblueTest {
  /**
   * Test {@link SampleClassWithVariableComputation#getAnswer(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link SampleClassWithVariableComputation#getAnswer(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int com.example.SampleClassWithVariableComputation.getAnswer(int, int)"})
  public void testGetAnswer_whenOne_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5, SampleClassWithVariableComputation.getAnswer(1, 3));
  }

  /**
   * Test {@link SampleClassWithVariableComputation#getAnswer(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return nine.
   * </ul>
   *
   * <p>Method under test: {@link SampleClassWithVariableComputation#getAnswer(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int com.example.SampleClassWithVariableComputation.getAnswer(int, int)"})
  public void testGetAnswer_whenThree_thenReturnNine() {
    // Arrange, Act and Assert
    assertEquals(9, SampleClassWithVariableComputation.getAnswer(3, 3));
  }

  /**
   * Test {@link SampleClassWithVariableComputation#getAnswer(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return seven.
   * </ul>
   *
   * <p>Method under test: {@link SampleClassWithVariableComputation#getAnswer(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int com.example.SampleClassWithVariableComputation.getAnswer(int, int)"})
  public void testGetAnswer_whenTwo_thenReturnSeven() {
    // Arrange, Act and Assert
    assertEquals(7, SampleClassWithVariableComputation.getAnswer(2, 3));
  }

  /**
   * Test {@link SampleClassWithVariableComputation#getAnswer(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SampleClassWithVariableComputation#getAnswer(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int com.example.SampleClassWithVariableComputation.getAnswer(int, int)"})
  public void testGetAnswer_whenZero_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, SampleClassWithVariableComputation.getAnswer(0, 3));
  }
}
