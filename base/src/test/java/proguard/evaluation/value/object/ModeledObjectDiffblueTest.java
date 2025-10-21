package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;

public class ModeledObjectDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModeledObject.<init>(Model)",
    "Model ModeledObject.getModeledValue()",
    "boolean ModeledObject.isModeled()",
    "boolean ModeledObject.isNull()",
    "boolean ModeledObject.isPrecise()",
    "java.lang.String ModeledObject.toString()"
  })
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ModeledObject.getType()"})
  public void testGetType_thenReturnLjavaLangClassLoader() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", (new ModeledObject(new ClassLoaderModel())).getType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModeledObject.equals(Object)", "int ModeledObject.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModeledObject(new ClassLoaderModel()), "Different type to ModeledObject");
  }
}
