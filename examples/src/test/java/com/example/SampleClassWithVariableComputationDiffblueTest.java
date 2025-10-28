package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SampleClassWithVariableComputationDiffblueTest {
  /**
   * Method under test:
   * {@link SampleClassWithVariableComputation#getAnswer(int, int)}
   */
  @Test
  public void testGetAnswer() {
    // Arrange, Act and Assert
    assertEquals(9, SampleClassWithVariableComputation.getAnswer(3, 3));
    assertEquals(7, SampleClassWithVariableComputation.getAnswer(2, 3));
    assertEquals(5, SampleClassWithVariableComputation.getAnswer(1, 3));
    assertEquals(3, SampleClassWithVariableComputation.getAnswer(0, 3));
  }
}
