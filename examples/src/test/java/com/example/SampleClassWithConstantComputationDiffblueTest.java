package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SampleClassWithConstantComputationDiffblueTest {
  /**
   * Method under test: {@link SampleClassWithConstantComputation#getAnswer()}
   */
  @Test
  public void testGetAnswer() {
    // Arrange, Act and Assert
    assertEquals(42, SampleClassWithConstantComputation.getAnswer());
  }
}
