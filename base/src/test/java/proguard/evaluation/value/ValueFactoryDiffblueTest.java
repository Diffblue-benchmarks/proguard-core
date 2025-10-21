package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;

public class ValueFactoryDiffblueTest {
  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz, Object)} with {@code Clazz}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ValueFactory.createReferenceValue(Clazz, Object)"})
  public void testCreateReferenceValueWithClazzObject_thenReferencedClassReturnLibraryClass() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz, (Object) null);

    // Assert
    Clazz referencedClass = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals("LThis Class Name;", actualCreateReferenceValueResult.getType());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
    assertSame(clazz, referencedClass);
  }

  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz)} with {@code Clazz}.
   *
   * <ul>
   *   <li>Then return mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ValueFactory.createReferenceValue(Clazz)"})
  public void testCreateReferenceValueWithClazz_thenReturnMayBeExtension() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz)} with {@code Clazz}.
   *
   * <ul>
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ValueFactory.createReferenceValue(Clazz)"})
  public void testCreateReferenceValueWithClazz_thenReturnNotMayBeExtension() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(Value.NEVER, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }
}
