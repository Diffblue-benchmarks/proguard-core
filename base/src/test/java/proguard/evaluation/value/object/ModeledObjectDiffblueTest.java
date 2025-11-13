package proguard.evaluation.value.object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;

class ModeledObjectDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModeledObject#ModeledObject(Model)}
   *   <li>{@link ModeledObject#toString()}
   *   <li>{@link ModeledObject#getModeledValue()}
   *   <li>{@link ModeledObject#isModeled()}
   *   <li>{@link ModeledObject#isNull()}
   *   <li>{@link ModeledObject#isPrecise()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ModeledObject.<init>(Model)",
    "Model ModeledObject.getModeledValue()",
    "boolean ModeledObject.isModeled()",
    "boolean ModeledObject.isNull()",
    "boolean ModeledObject.isPrecise()",
    "java.lang.String ModeledObject.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ClassLoaderModel value = new ClassLoaderModel();

    // Act
    ModeledObject actualModeledObject = new ModeledObject(value);
    actualModeledObject.toString();
    Model actualModeledValue = actualModeledObject.getModeledValue();
    boolean actualIsModeledResult = actualModeledObject.isModeled();
    boolean actualIsNullResult = actualModeledObject.isNull();

    // Assert
    assertFalse(actualIsNullResult);
    assertFalse(actualModeledObject.isPrecise());
    assertTrue(actualIsModeledResult);
    assertSame(value, actualModeledValue);
  }

  /**
   * Test {@link ModeledObject#getType()}.
   *
   * <ul>
   *   <li>Then return {@code Ljava/lang/ClassLoader;}.
   * </ul>
   *
   * <p>Method under test: {@link ModeledObject#getType()}
   */
  @Test
  @DisplayName("Test getType(); then return 'Ljava/lang/ClassLoader;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ModeledObject.getType()"})
  void testGetType_thenReturnLjavaLangClassLoader() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", new ModeledObject(new ClassLoaderModel()).getType());
  }

  /**
   * Test {@link ModeledObject#equals(Object)}, and {@link ModeledObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModeledObject#equals(Object)}
   *   <li>{@link ModeledObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModeledObject modeledObject = new ModeledObject(null);
    ModeledObject modeledObject2 = new ModeledObject(null);

    // Act and Assert
    assertEquals(modeledObject, modeledObject2);
    assertEquals(modeledObject.hashCode(), modeledObject2.hashCode());
  }

  /**
   * Test {@link ModeledObject#equals(Object)}, and {@link ModeledObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModeledObject#equals(Object)}
   *   <li>{@link ModeledObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModeledObject modeledObject = new ModeledObject(new ClassLoaderModel());

    // Act and Assert
    assertEquals(modeledObject, modeledObject);
    int expectedHashCodeResult = modeledObject.hashCode();
    assertEquals(expectedHashCodeResult, modeledObject.hashCode());
  }

  /**
   * Test {@link ModeledObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModeledObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ModeledObject modeledObject = new ModeledObject(new ClassLoaderModel());

    // Act and Assert
    assertNotEquals(modeledObject, new ModeledObject(new ClassLoaderModel()));
  }

  /**
   * Test {@link ModeledObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModeledObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModeledObject(new ClassLoaderModel()), null);
  }

  /**
   * Test {@link ModeledObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModeledObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModeledObject(new ClassLoaderModel()), "Different type to ModeledObject");
  }
}
