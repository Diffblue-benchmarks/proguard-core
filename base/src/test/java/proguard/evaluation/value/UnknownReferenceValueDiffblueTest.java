package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;

public class UnknownReferenceValueDiffblueTest {
  /**
   * Test {@link UnknownReferenceValue#mayBeExtension()}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#mayBeExtension()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownReferenceValue.mayBeExtension()"})
  public void testMayBeExtension() {
    // Arrange, Act and Assert
    assertTrue((new UnknownReferenceValue()).mayBeExtension());
  }

  /**
   * Test {@link UnknownReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnknownReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory} (default constructor).
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenBasicValueFactory_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    BasicValueFactory valueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenEmptyString() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenMultiTypedReferenceValueFactory_thenReturnMultiTypedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        unknownReferenceValue.cast(
            "Type", referencedClass, new MultiTypedReferenceValueFactory(), true);

    // Assert
    Clazz referencedClass2 = actualCastResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link ParticularReferenceValueFactory} (default constructor).
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenParticularReferenceValueFactory_thenReturnIdentifiedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        unknownReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    Clazz referencedClass2 = actualCastResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link UnknownReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue UnknownReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        unknownReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue UnknownReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnTracedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        unknownReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue UnknownReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(
        unknownReferenceValue, unknownReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link UnknownReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnknownReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link UnknownReferenceValue#internalType()}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnknownReferenceValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/Object;", (new UnknownReferenceValue()).internalType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownReferenceValue}
   *   <li>{@link UnknownReferenceValue#toString()}
   *   <li>{@link UnknownReferenceValue#getReferencedClass()}
   *   <li>{@link UnknownReferenceValue#getType()}
   *   <li>{@link UnknownReferenceValue#isNull()}
   *   <li>{@link UnknownReferenceValue#isParticular()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownReferenceValue.<init>()",
    "Clazz UnknownReferenceValue.getReferencedClass()",
    "String UnknownReferenceValue.getType()",
    "int UnknownReferenceValue.isNull()",
    "boolean UnknownReferenceValue.isParticular()",
    "String UnknownReferenceValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UnknownReferenceValue actualUnknownReferenceValue = new UnknownReferenceValue();
    String actualToStringResult = actualUnknownReferenceValue.toString();
    Clazz actualReferencedClass = actualUnknownReferenceValue.getReferencedClass();
    String actualType = actualUnknownReferenceValue.getType();
    int actualIsNullResult = actualUnknownReferenceValue.isNull();

    // Assert
    assertEquals("Ljava/lang/Object;", actualType);
    assertEquals("a", actualToStringResult);
    assertNull(actualReferencedClass);
    assertEquals(0, actualIsNullResult);
    assertFalse(actualUnknownReferenceValue.isParticular());
  }
}
