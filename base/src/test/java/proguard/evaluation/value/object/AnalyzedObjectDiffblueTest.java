package proguard.evaluation.value.object;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.object.model.ClassLoaderModel;

public class AnalyzedObjectDiffblueTest {
  /**
   * Method under test: {@link AnalyzedObject#isOfType(String)}
   */
  @Test
  public void testIsOfType() {
    // Arrange, Act and Assert
    assertTrue((new TypedNullObject("Type")).isOfType("Type"));
    assertFalse((new TypedNullObject("proguard.evaluation.value.object.TypedNullObject")).isOfType("Type"));
  }

  /**
   * Method under test: {@link AnalyzedObject#isOfTypeAndNotNull(String)}
   */
  @Test
  public void testIsOfTypeAndNotNull() {
    // Arrange, Act and Assert
    assertFalse((new TypedNullObject("Type")).isOfTypeAndNotNull("Type"));
  }

  /**
   * Method under test: {@link AnalyzedObject#isInstanceOf(Clazz)}
   */
  @Test
  public void testIsInstanceOf() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("Type");

    // Act and Assert
    assertFalse(typedNullObject.isInstanceOf(new LibraryClass()));
  }

  /**
   * Method under test: {@link AnalyzedObject#getPreciseValue()}
   */
  @Test
  public void testGetPreciseValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ModeledObject(new ClassLoaderModel())).getPreciseValue());
  }

  /**
   * Method under test: {@link AnalyzedObject#getModeledValue()}
   */
  @Test
  public void testGetModeledValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new TypedNullObject("Type")).getModeledValue());
  }

  /**
   * Method under test: {@link AnalyzedObject#getModeledOrNullValue()}
   */
  @Test
  public void testGetModeledOrNullValue() {
    // Arrange, Act and Assert
    assertNull((new TypedNullObject("Type")).getModeledOrNullValue());
  }
}
