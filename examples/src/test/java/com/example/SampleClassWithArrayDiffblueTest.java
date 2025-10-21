package com.example;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SampleClassWithArrayDiffblueTest {
  /**
   * Test {@link SampleClassWithArray#getAnswer()}.
   *
   * <p>Method under test: {@link SampleClassWithArray#getAnswer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SampleClassWithArray.getAnswer()"})
  public void testGetAnswer() {
    // Arrange, Act and Assert
    assertEquals(42, SampleClassWithArray.getAnswer());
  }
}
