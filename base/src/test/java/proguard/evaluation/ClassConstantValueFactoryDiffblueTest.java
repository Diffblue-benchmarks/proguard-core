package proguard.evaluation;

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
import proguard.classfile.constant.ClassConstant;
import proguard.evaluation.value.ParticularReferenceValue;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ClassModel;
import proguard.evaluation.value.object.model.Model;

public class ClassConstantValueFactoryDiffblueTest {
  /**
   * Test {@link ClassConstantValueFactory#ClassConstantValueFactory(ValueFactory)}.
   *
   * <p>Method under test: {@link ClassConstantValueFactory#ClassConstantValueFactory(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassConstantValueFactory.<init>(ValueFactory)"})
  public void testNewClassConstantValueFactory() {
    // Arrange and Act
    ClassConstantValueFactory actualClassConstantValueFactory =
        new ClassConstantValueFactory(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(
        actualClassConstantValueFactory.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualClassConstantValueFactory.value);
  }

  /**
   * Test {@link ClassConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassConstantValueFactory#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassConstantValueFactory.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant() {
    // Arrange
    ClassConstantValueFactory classConstantValueFactory =
        new ClassConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    classConstantValueFactory.visitClassConstant(clazz, new ClassConstant());

    // Assert
    Value value = classConstantValueFactory.value;
    assertTrue(value instanceof ParticularReferenceValue);
    AnalyzedObject value2 = ((ParticularReferenceValue) value).getValue();
    Model modeledOrNullValue = value2.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ClassModel);
    assertEquals("Ljava/lang/Class;", ((ParticularReferenceValue) value).getType());
    assertEquals("Ljava/lang/Class;", modeledOrNullValue.getType());
    assertNull(((ParticularReferenceValue) value).getReferencedClass());
    assertNull(((ClassModel) modeledOrNullValue).getClazz());
    assertEquals(1, ((ParticularReferenceValue) value).isNotNull());
    assertFalse(((ParticularReferenceValue) value).mayBeExtension());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((ParticularReferenceValue) value).isNull());
    assertSame(modeledOrNullValue, value2.getModeledValue());
  }

  /**
   * Test {@link ClassConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassConstantValueFactory#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassConstantValueFactory.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant2() {
    // Arrange
    ClassConstantValueFactory classConstantValueFactory =
        new ClassConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    classConstantValueFactory.visitClassConstant(clazz, new ClassConstant());

    // Assert
    Value value = classConstantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    AnalyzedObject value2 = ((UnknownReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }
}
