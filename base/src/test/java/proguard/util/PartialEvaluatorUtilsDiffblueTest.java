package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.evaluation.PartialEvaluator;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.Stack;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedArrayReferenceValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ReferenceValue;

public class PartialEvaluatorUtilsDiffblueTest {
  /**
   * Test {@link PartialEvaluatorUtils#getStackValue(Stack, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluatorUtils#getStackValue(Stack, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.Value PartialEvaluatorUtils.getStackValue(Stack, int)"
  })
  public void testGetStackValue_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PartialEvaluatorUtils.getStackValue(new Stack(3), -1));
  }

  /**
   * Test {@link PartialEvaluatorUtils#getStackValue(Stack, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluatorUtils#getStackValue(Stack, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.Value PartialEvaluatorUtils.getStackValue(Stack, int)"
  })
  public void testGetStackValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PartialEvaluatorUtils.getStackValue(null, 1));
  }

  /**
   * Test {@link PartialEvaluatorUtils#getStackValue(Stack, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluatorUtils#getStackValue(Stack, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.Value PartialEvaluatorUtils.getStackValue(Stack, int)"
  })
  public void testGetStackValue_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PartialEvaluatorUtils.getStackValue(new Stack(3), 1));
  }

  /**
   * Test {@link PartialEvaluatorUtils#getStackBefore(PartialEvaluator, int, int)}.
   *
   * <ul>
   *   <li>When {@link PartialEvaluator#PartialEvaluator()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluatorUtils#getStackBefore(PartialEvaluator, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.Value PartialEvaluatorUtils.getStackBefore(PartialEvaluator, int, int)"
  })
  public void testGetStackBefore_whenPartialEvaluator_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PartialEvaluatorUtils.getStackBefore(new PartialEvaluator(), 2, 1));
  }

  /**
   * Test {@link PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}.
   *
   * <ul>
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "java.lang.Object PartialEvaluatorUtils.getIdFromSpecificReferenceValue(ReferenceValue)"
  })
  public void testGetIdFromSpecificReferenceValue_thenReturnId() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Id",
        PartialEvaluatorUtils.getIdFromSpecificReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "java.lang.Object PartialEvaluatorUtils.getIdFromSpecificReferenceValue(ReferenceValue)"
  })
  public void testGetIdFromSpecificReferenceValue_thenReturnIntValueIsOne() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        1,
        ((Integer)
                PartialEvaluatorUtils.getIdFromSpecificReferenceValue(
                    new IdentifiedArrayReferenceValue(
                        "Type",
                        referencedClass,
                        true,
                        BasicValueFactory.INTEGER_VALUE,
                        new ParticularReferenceValueFactory(),
                        1)))
            .intValue());
  }

  /**
   * Test {@link PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PartialEvaluatorUtils#getIdFromSpecificReferenceValue(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "java.lang.Object PartialEvaluatorUtils.getIdFromSpecificReferenceValue(ReferenceValue)"
  })
  public void testGetIdFromSpecificReferenceValue_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            PartialEvaluatorUtils.getIdFromSpecificReferenceValue(
                BasicValueFactory.REFERENCE_VALUE));
  }
}
