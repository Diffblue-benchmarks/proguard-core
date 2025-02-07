package proguard.evaluation.value.object;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.object.model.ClassLoaderModel;

class AnalyzedObjectDiffblueTest {
  /**
   * Test {@link AnalyzedObject#isOfType(String)}.
   *
   * <ul>
   *   <li>Given {@link TypedNullObject#TypedNullObject(String)} with {@code Type}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObject#isOfType(String)}
   */
  @Test
  @DisplayName(
      "Test isOfType(String); given TypedNullObject(String) with 'Type'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.AnalyzedObject.isOfType(java.lang.String)"
  })
  void testIsOfType_givenTypedNullObjectWithType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TypedNullObject("Type")).isOfType("Type"));
  }

  /**
   * Test {@link AnalyzedObject#isOfType(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObject#isOfType(String)}
   */
  @Test
  @DisplayName("Test isOfType(String); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.AnalyzedObject.isOfType(java.lang.String)"
  })
  void testIsOfType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TypedNullObject("proguard.evaluation.value.object.TypedNullObject")).isOfType("Type"));
  }

  /**
   * Test {@link AnalyzedObject#isOfTypeAndNotNull(String)}.
   *
   * <p>Method under test: {@link AnalyzedObject#isOfTypeAndNotNull(String)}
   */
  @Test
  @DisplayName("Test isOfTypeAndNotNull(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.AnalyzedObject.isOfTypeAndNotNull(java.lang.String)"
  })
  void testIsOfTypeAndNotNull() {
    // Arrange, Act and Assert
    assertFalse((new TypedNullObject("Type")).isOfTypeAndNotNull("Type"));
  }

  /**
   * Test {@link AnalyzedObject#isInstanceOf(Clazz)}.
   *
   * <p>Method under test: {@link AnalyzedObject#isInstanceOf(Clazz)}
   */
  @Test
  @DisplayName("Test isInstanceOf(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.AnalyzedObject.isInstanceOf(proguard.classfile.Clazz)"
  })
  void testIsInstanceOf() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("Type");

    // Act and Assert
    assertFalse(typedNullObject.isInstanceOf(new LibraryClass()));
  }

  /**
   * Test {@link AnalyzedObject#getPreciseValue()}.
   *
   * <p>Method under test: {@link AnalyzedObject#getPreciseValue()}
   */
  @Test
  @DisplayName("Test getPreciseValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.object.AnalyzedObject.getPreciseValue()"
  })
  void testGetPreciseValue() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> (new ModeledObject(new ClassLoaderModel())).getPreciseValue());
  }

  /**
   * Test {@link AnalyzedObject#getModeledValue()}.
   *
   * <p>Method under test: {@link AnalyzedObject#getModeledValue()}
   */
  @Test
  @DisplayName("Test getModeledValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.model.Model proguard.evaluation.value.object.AnalyzedObject.getModeledValue()"
  })
  void testGetModeledValue() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> (new TypedNullObject("Type")).getModeledValue());
  }

  /**
   * Test {@link AnalyzedObject#getModeledOrNullValue()}.
   *
   * <p>Method under test: {@link AnalyzedObject#getModeledOrNullValue()}
   */
  @Test
  @DisplayName("Test getModeledOrNullValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.model.Model proguard.evaluation.value.object.AnalyzedObject.getModeledOrNullValue()"
  })
  void testGetModeledOrNullValue() {
    // Arrange, Act and Assert
    assertNull((new TypedNullObject("Type")).getModeledOrNullValue());
  }
}
