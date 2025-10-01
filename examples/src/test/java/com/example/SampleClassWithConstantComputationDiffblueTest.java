package com.example;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SampleClassWithConstantComputationDiffblueTest {
  /**
   * Test {@link SampleClassWithConstantComputation#getAnswer()}.
   *
   * <p>Method under test: {@link SampleClassWithConstantComputation#getAnswer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SampleClassWithConstantComputation.getAnswer()"})
  public void testGetAnswer() {
    // Arrange, Act and Assert
    assertEquals(42, SampleClassWithConstantComputation.getAnswer());
  }
}
