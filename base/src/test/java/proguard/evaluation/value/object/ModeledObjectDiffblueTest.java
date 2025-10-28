package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;

public class ModeledObjectDiffblueTest {
  /**
   * Method under test: {@link ModeledObject#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", (new ModeledObject(new ClassLoaderModel())).getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModeledObject#equals(Object)}
   *   <li>{@link ModeledObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModeledObject modeledObject = new ModeledObject(null);
    ModeledObject modeledObject2 = new ModeledObject(null);

    // Act and Assert
    assertEquals(modeledObject, modeledObject2);
    int expectedHashCodeResult = modeledObject.hashCode();
    assertEquals(expectedHashCodeResult, modeledObject2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModeledObject#equals(Object)}
   *   <li>{@link ModeledObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModeledObject modeledObject = new ModeledObject(new ClassLoaderModel());

    // Act and Assert
    assertEquals(modeledObject, modeledObject);
    int expectedHashCodeResult = modeledObject.hashCode();
    assertEquals(expectedHashCodeResult, modeledObject.hashCode());
  }

  /**
   * Method under test: {@link ModeledObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ModeledObject modeledObject = new ModeledObject(new ClassLoaderModel());

    // Act and Assert
    assertNotEquals(modeledObject, new ModeledObject(new ClassLoaderModel()));
  }

  /**
   * Method under test: {@link ModeledObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModeledObject(new ClassLoaderModel()), null);
  }

  /**
   * Method under test: {@link ModeledObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModeledObject(new ClassLoaderModel()), "Different type to ModeledObject");
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
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
}
