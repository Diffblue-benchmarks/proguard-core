package proguard.evaluation.value.object;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.object.model.ClassLoaderModel;

public class AnalyzedObjectDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnalyzedObject.isOfType(String)"})
  public void testIsOfType_givenTypedNullObjectWithType_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnalyzedObject.isOfType(String)"})
  public void testIsOfType_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnalyzedObject.isOfTypeAndNotNull(String)"})
  public void testIsOfTypeAndNotNull() {
    // Arrange, Act and Assert
    assertFalse((new TypedNullObject("Type")).isOfTypeAndNotNull("Type"));
  }

  /**
   * Test {@link AnalyzedObject#isInstanceOf(Clazz)}.
   *
   * <p>Method under test: {@link AnalyzedObject#isInstanceOf(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnalyzedObject.isInstanceOf(Clazz)"})
  public void testIsInstanceOf() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object AnalyzedObject.getPreciseValue()"})
  public void testGetPreciseValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.object.model.Model AnalyzedObject.getModeledValue()"
  })
  public void testGetModeledValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.object.model.Model AnalyzedObject.getModeledOrNullValue()"
  })
  public void testGetModeledOrNullValue() {
    // Arrange, Act and Assert
    assertNull((new TypedNullObject("Type")).getModeledOrNullValue());
  }
}
