package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SampleClassWithArrayDiffblueTest {
  /**
   * Method under test: {@link SampleClassWithArray#getAnswer()}
   */
  @Test
  public void testGetAnswer() {
    // Arrange, Act and Assert
    assertEquals(42, SampleClassWithArray.getAnswer());
  }
}
