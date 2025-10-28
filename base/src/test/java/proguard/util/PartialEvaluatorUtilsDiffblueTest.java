package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.evaluation.PartialEvaluator;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.Stack;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ReferenceValue;

public class PartialEvaluatorUtilsDiffblueTest {
  /**
   * Method under test: {@link PartialEvaluatorUtils#getStackValue(Stack, int)}
   */
  @Test
  public void testGetStackValue() {
    // Arrange, Act and Assert
    assertNull(PartialEvaluatorUtils.getStackValue(new Stack(3), 1));
    assertNull(PartialEvaluatorUtils.getStackValue(null, 1));
    assertNull(PartialEvaluatorUtils.getStackValue(new Stack(3), -1));
  }

  /**
   * Method under test:
   * {@link PartialEvaluatorUtils#getStackBefore(PartialEvaluator, int, int)}
   */
  @Test
  public void testGetStackBefore() {
    // Arrange, Act and Assert
    assertNull(PartialEvaluatorUtils.getStackBefore(new PartialEvaluator(), 2, 1));
  }

  /**
   * Method under test:
   * {@link PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}
   */
  @Test
  public void testGetIdFromSpecificReferenceValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> PartialEvaluatorUtils.getIdFromSpecificReferenceValue(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test:
   * {@link PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}
   */
  @Test
  public void testGetIdFromSpecificReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals("Id", PartialEvaluatorUtils.getIdFromSpecificReferenceValue(new IdentifiedReferenceValue("Type",
        referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }
}
