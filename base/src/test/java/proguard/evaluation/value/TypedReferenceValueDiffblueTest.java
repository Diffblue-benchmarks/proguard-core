package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
import proguard.evaluation.value.object.AnalyzedObject;

public class TypedReferenceValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedReferenceValue#TypedReferenceValue(String, Clazz, boolean, boolean)}
   *   <li>{@link TypedReferenceValue#getReferencedClass()}
   *   <li>{@link TypedReferenceValue#getType()}
   *   <li>{@link TypedReferenceValue#mayBeExtension()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypedReferenceValue.<init>(String, Clazz, boolean, boolean)",
    "Clazz TypedReferenceValue.getReferencedClass()",
    "String TypedReferenceValue.getType()",
    "boolean TypedReferenceValue.mayBeExtension()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    TypedReferenceValue actualTypedReferenceValue =
        new TypedReferenceValue("Type", referencedClass, true, true);
    Clazz actualReferencedClass = actualTypedReferenceValue.getReferencedClass();
    String actualType = actualTypedReferenceValue.getType();

    // Assert
    assertEquals("Type", actualType);
    assertTrue(actualTypedReferenceValue.mayBeExtension());
    assertSame(referencedClass, actualReferencedClass);
  }

  /**
   * Test {@link TypedReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.isNull()"})
  public void testIsNull_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER, (new TypedReferenceValue("Type", new LibraryClass(), true, false)).isNull());
  }

  /**
   * Test {@link TypedReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.isNull()"})
  public void testIsNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new TypedReferenceValue(null, new LibraryClass(), true, true)).isNull());
  }

  /**
   * Test {@link TypedReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.isNull()"})
  public void testIsNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).isNull());
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Other Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf3() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf4() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", null, true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf5() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(Short.SIZE, "Type", "Type"), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_thenReturnNever() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_thenReturnOne() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Other Type", new LibraryClass(), true, false);

    // Act and Assert
    assertEquals(1, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Object;}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_whenLjavaLangObject_thenReturnZero() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.instanceOf("Ljava/lang/Object;", new LibraryClass()));
  }

  /**
   * Test {@link TypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TypedReferenceValue("Type", new LibraryClass(), true, true))
            .instanceOf("Other Type", null));
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true));
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), false));
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnIdentifiedReferenceValue() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        typedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.isSpecific());
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnIdentifiedReferenceValue2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        typedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), false);

    // Assert
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.isSpecific());
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnParticularReferenceValue() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        typedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof ParticularReferenceValue);
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCastResult.isNull());
    assertTrue(actualCastResult.isParticular());
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        typedReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory} (default constructor).
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenBasicValueFactory_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    BasicValueFactory valueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        typedReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Object;}.
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenLjavaLangObject_thenReturnTypeIsLjavaLangObject() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCastResult =
        typedReferenceValue.cast("Ljava/lang/Object;", referencedClass, valueFactory, true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCastResult.getType());
    ReferenceValue expectedGeneralizedType =
        valueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;
    assertSame(
        expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenMultiTypedReferenceValueFactory_thenReturnType() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        typedReferenceValue.cast(
            "Type", referencedClass, new MultiTypedReferenceValueFactory(), true);

    // Assert
    Clazz referencedClass2 = actualCastResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenMultiTypedReferenceValueFactory_thenReturnTypeIsNull() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCastResult =
        typedReferenceValue.cast(null, referencedClass, valueFactory, true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertNull(actualCastResult.getType());
    ReferenceValue expectedGeneralizedType = valueFactory.REFERENCE_VALUE_NULL;
    assertSame(
        expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Test {@link TypedReferenceValue#generalizeMayBeNull(boolean)}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalizeMayBeNull(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalizeMayBeNull(boolean)"})
  public void testGeneralizeMayBeNull() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(typedReferenceValue, typedReferenceValue.generalizeMayBeNull(true));
  }

  /**
   * Test {@link TypedReferenceValue#generalizeMayBeNull(boolean)}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalizeMayBeNull(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalizeMayBeNull(boolean)"})
  public void testGeneralizeMayBeNull_thenReferencedClassReturnLibraryClass() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeMayBeNullResult =
        (new TypedReferenceValue("Type", referencedClass, true, false)).generalizeMayBeNull(true);

    // Assert
    Clazz referencedClass2 = actualGeneralizeMayBeNullResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeMayBeNullResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeMayBeNullResult.getType());
    assertEquals(0, actualGeneralizeMayBeNullResult.isNotNull());
    assertEquals(0, actualGeneralizeMayBeNullResult.isNull());
    assertFalse(actualGeneralizeMayBeNullResult.isCategory2());
    assertFalse(actualGeneralizeMayBeNullResult.isParticular());
    assertFalse(actualGeneralizeMayBeNullResult.isSpecific());
    assertTrue(actualGeneralizeMayBeNullResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeMayBeNullResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeMayBeNullResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue3() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue4() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        typedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(typedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue5() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, typedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue6() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act and Assert
    assertSame(
        other,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue7() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue other =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, arrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue8() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue9() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, arrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue10() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertSame(
        identifiedReferenceValue,
        identifiedReferenceValue.generalize(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue12() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other, (new TypedReferenceValue(null, new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue13() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other, (new TypedReferenceValue("", new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue14() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other,
        (new TypedReferenceValue("Type", new LibraryClass(), false, true)).generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue15() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        typedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(typedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue16() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue17() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue2() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnReference_value_null() {
    // Arrange
    ReferenceValue other = PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL;

    // Act and Assert
    assertSame(
        other, (new TypedReferenceValue(null, new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnTypeIsLjavaLangObject() {
    // Arrange and Act
    ReferenceValue actualGeneralizeResult =
        (new TypedReferenceValue("Type", new LibraryClass(), true, true))
            .generalize(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_null_thenReturnType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        (new ArrayReferenceValue(
                "Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value2() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, typedReferenceValue.generalize(other));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue3() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue4() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue6() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.generalize(
            new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue7() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.generalize(
            new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue8() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", null, true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        typedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue9() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        typedReferenceValue.generalize(new TypedReferenceValue("Type", null, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link TypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue10() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act and Assert
    assertSame(
        typedReferenceValue,
        typedReferenceValue.generalize(
            (TypedReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Act and Assert
    assertEquals(
        0,
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue8() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TypedReferenceValue(null, new LibraryClass(), true, true))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue9() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            null, new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new TypedReferenceValue(null, new LibraryClass(), true, true))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TypedReferenceValue("Type", new LibraryClass(), true, true))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link TypedReferenceValueFactory#REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TypedReferenceValue("Type", new LibraryClass(), true, true))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_null() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TypedReferenceValue("Type", new LibraryClass(), true, true))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(
        0,
        typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(
        0,
        typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue3() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act and Assert
    assertEquals(
        0,
        typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue4() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(
        0,
        typedReferenceValue.equal(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue5() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        typedReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), true, false)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue6() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act and Assert
    assertEquals(
        0,
        typedReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), false, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue7() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        typedReferenceValue.equal(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue8() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), false, true);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        typedReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), false, true)));
  }

  /**
   * Test {@link TypedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TypedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue_thenReturnOne() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(
        1,
        typedReferenceValue.equal(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TypedReferenceValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TypedReferenceValue.isParticular()"})
  public void testIsParticular_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TypedReferenceValue("Type", new LibraryClass(), true, true)).isParticular());
  }

  /**
   * Test {@link TypedReferenceValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TypedReferenceValue.isParticular()"})
  public void testIsParticular_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TypedReferenceValue(null, new LibraryClass(), true, true)).isParticular());
  }

  /**
   * Test {@link TypedReferenceValue#internalType()}.
   *
   * <ul>
   *   <li>Then return {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.internalType()"})
  public void testInternalType_thenReturnLjavaLangObject() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/Object;",
        (new TypedReferenceValue(null, new LibraryClass(), true, true)).internalType());
  }

  /**
   * Test {@link TypedReferenceValue#internalType()}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.internalType()"})
  public void testInternalType_thenReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "Type", (new TypedReferenceValue("Type", new LibraryClass(), true, true)).internalType());
  }

  /**
   * Test {@link TypedReferenceValue#allowsIncompleteClassHierarchy()}.
   *
   * <p>Method under test: {@link TypedReferenceValue#allowsIncompleteClassHierarchy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TypedReferenceValue.allowsIncompleteClassHierarchy()"})
  public void testAllowsIncompleteClassHierarchy() {
    // Arrange, Act and Assert
    assertFalse(TypedReferenceValue.allowsIncompleteClassHierarchy());
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}, and {@link TypedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedReferenceValue#equals(Object)}
   *   <li>{@link TypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);
    TypedReferenceValue typedReferenceValue2 =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(typedReferenceValue, typedReferenceValue2);
    int expectedHashCodeResult = typedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, typedReferenceValue2.hashCode());
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}, and {@link TypedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedReferenceValue#equals(Object)}
   *   <li>{@link TypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);
    TypedReferenceValue typedReferenceValue2 =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(typedReferenceValue, typedReferenceValue2);
    int expectedHashCodeResult = typedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, typedReferenceValue2.hashCode());
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}, and {@link TypedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedReferenceValue#equals(Object)}
   *   <li>{@link TypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(typedReferenceValue, typedReferenceValue);
    int expectedHashCodeResult = typedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, typedReferenceValue.hashCode());
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertNotEquals(
        typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    // Act and Assert
    assertNotEquals(
        typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act and Assert
    assertNotEquals(
        typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act and Assert
    assertNotEquals(
        typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedReferenceValue("Type", new LibraryClass(), true, true), null);
  }

  /**
   * Test {@link TypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TypedReferenceValue.equals(Object)",
    "int TypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TypedReferenceValue("Type", new LibraryClass(), true, true),
        "Different type to TypedReferenceValue");
  }

  /**
   * Test {@link TypedReferenceValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code n}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.toString()"})
  public void testToString_thenReturnN() {
    // Arrange, Act and Assert
    assertEquals("n", (new TypedReferenceValue(null, new LibraryClass(), true, true)).toString());
  }

  /**
   * Test {@link TypedReferenceValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.toString()"})
  public void testToString_thenReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "Type", (new TypedReferenceValue("Type", new LibraryClass(), true, true)).toString());
  }

  /**
   * Test {@link TypedReferenceValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Type?}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.toString()"})
  public void testToString_thenReturnType2() {
    // Arrange, Act and Assert
    assertEquals("Type?", (new TypedReferenceValue("Type", null, true, true)).toString());
  }

  /**
   * Test {@link TypedReferenceValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Type=}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.toString()"})
  public void testToString_thenReturnType3() {
    // Arrange, Act and Assert
    assertEquals(
        "Type=", (new TypedReferenceValue("Type", new LibraryClass(), false, true)).toString());
  }

  /**
   * Test {@link TypedReferenceValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Type!}.
   * </ul>
   *
   * <p>Method under test: {@link TypedReferenceValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypedReferenceValue.toString()"})
  public void testToString_thenReturnType4() {
    // Arrange, Act and Assert
    assertEquals(
        "Type!", (new TypedReferenceValue("Type", new LibraryClass(), true, false)).toString());
  }
}
