package com.example;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SampleClassWithObjectsDiffblueTest {
  /**
   * Test {@link SampleClassWithObjects#getAnswer(Number)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SampleClassWithObjects#getAnswer(Number)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Number SampleClassWithObjects.getAnswer(Number)"})
  public void testGetAnswer_whenNull_thenReturnIntValueIsFortyTwo() {
    // Arrange and Act
    Number actualAnswer = SampleClassWithObjects.getAnswer(null);

    // Assert
    assertEquals(42, actualAnswer.intValue());
  }

  /**
   * Test {@link SampleClassWithObjects#getAnswer(Number)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleClassWithObjects#getAnswer(Number)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Number SampleClassWithObjects.getAnswer(Number)"})
  public void testGetAnswer_whenValueOfOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, SampleClassWithObjects.getAnswer(Integer.valueOf(1)).intValue());
  }
}
