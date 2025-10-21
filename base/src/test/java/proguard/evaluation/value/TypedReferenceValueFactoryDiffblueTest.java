package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.domain.value.JvmCfaReferenceValueFactory;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class TypedReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link TypedReferenceValueFactory#createReferenceValueNull()}.
   *
   * <p>Method under test: {@link TypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValueFactory.createReferenceValueNull()"})
  public void testCreateReferenceValueNull() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        typedReferenceValueFactory.REFERENCE_VALUE_NULL,
        typedReferenceValueFactory.createReferenceValueNull());
  }

  /**
   * Test {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link TypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        typedReferenceValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link TypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory =
        new JvmCfaReferenceValueFactory(new JvmCfa());

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        jvmCfaReferenceValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link TypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength3() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        typedReferenceValueFactory.createArrayReferenceValue(
            "Ljava/lang/Object;", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link TypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        typedReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link TypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory =
        new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        jvmCfaReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }
}
