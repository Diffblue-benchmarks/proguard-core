package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.MemberVisitor;

public class ClassBuilderDiffblueTest {
  /**
   * Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  public void testAddInterface() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name"));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  public void testAddInterface2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addInterface("Interface Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name"));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  public void testAddInterface3() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name"));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  public void testAddInterface4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder = new ClassBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name"));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  public void testAddInterface5() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name", new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  public void testAddInterface6() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addInterface("Interface Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name", new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  public void testAddInterface7() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name", new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  public void testAddInterface8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder = new ClassBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name", new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(Clazz)}
   */
  @Test
  public void testAddInterface9() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface(new LibraryClass(5, "This Class Name", "Super Class Name")));
  }

  /**
   * Method under test: {@link ClassBuilder#addInterface(Clazz)}
   */
  @Test
  public void testAddInterface10() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder = new ClassBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface(new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  public void testAddField() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  public void testAddField2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  public void testAddField3() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  public void testAddField4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder = new ClassBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField5() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor", new AttributeSorter()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField6() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor", new AttributeSorter()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField7() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor", null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField8() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor", new ConstantPoolShrinker()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  public void testAddAndReturnField() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ProgramField actualAddAndReturnFieldResult = classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Field Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Field Name", ((Utf8Constant) constant).getString());
    assertNull(actualAddAndReturnFieldResult.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(actualAddAndReturnFieldResult.referencedClass);
    assertEquals(0, actualAddAndReturnFieldResult.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, actualAddAndReturnFieldResult.attributes.length);
    assertEquals(0, actualAddAndReturnFieldResult.u2attributesCount);
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(1, programClass.fields.length);
    assertEquals(1, programClass.u2fieldsCount);
    assertEquals(2, actualAddAndReturnFieldResult.getAccessFlags());
    assertEquals(5, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(6, actualAddAndReturnFieldResult.u2descriptorIndex);
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  public void testAddAndReturnField2() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act
    ProgramField actualAddAndReturnFieldResult = classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Field Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Field Name", ((Utf8Constant) constant).getString());
    assertNull(actualAddAndReturnFieldResult.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(actualAddAndReturnFieldResult.referencedClass);
    assertEquals(0, actualAddAndReturnFieldResult.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, actualAddAndReturnFieldResult.attributes.length);
    assertEquals(0, actualAddAndReturnFieldResult.u2attributesCount);
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(2, actualAddAndReturnFieldResult.getAccessFlags());
    ProgramField[] programFieldArray = programClass.fields;
    assertEquals(2, programFieldArray.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(5, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(6, actualAddAndReturnFieldResult.u2descriptorIndex);
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(actualAddAndReturnFieldResult.attributes, (programFieldArray[0]).attributes);
    byte[] expectedBytes = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  public void testAddAndReturnField3() {
    // Arrange
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramField actualAddAndReturnFieldResult = classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    assertNull(actualAddAndReturnFieldResult.getProcessingInfo());
    assertNull(actualAddAndReturnFieldResult.referencedClass);
    assertEquals(0, actualAddAndReturnFieldResult.getProcessingFlags());
    assertEquals(0, actualAddAndReturnFieldResult.attributes.length);
    assertEquals(0, actualAddAndReturnFieldResult.u2attributesCount);
    assertEquals(1, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(2, actualAddAndReturnFieldResult.getAccessFlags());
    assertEquals(2, actualAddAndReturnFieldResult.u2descriptorIndex);
    assertSame(programClass, classBuilder.getProgramClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  public void testAddAndReturnField4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramField actualAddAndReturnFieldResult = classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    assertNull(actualAddAndReturnFieldResult.getProcessingInfo());
    assertNull(actualAddAndReturnFieldResult.referencedClass);
    assertEquals(0, actualAddAndReturnFieldResult.getProcessingFlags());
    assertEquals(0, actualAddAndReturnFieldResult.attributes.length);
    assertEquals(0, actualAddAndReturnFieldResult.u2attributesCount);
    assertEquals(2, actualAddAndReturnFieldResult.getAccessFlags());
    assertEquals(3, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(4, actualAddAndReturnFieldResult.u2descriptorIndex);
    assertSame(programClass, classBuilder.getProgramClass());
  }

  /**
   * Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  public void testAddMethod() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  public void testAddMethod2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  public void testAddMethod3() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  public void testAddMethod4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder = new ClassBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddMethod5() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddMethod6() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddMethod7() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddMethod8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder = new ClassBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder, MemberVisitor)}
   */
  @Test
  public void testAddMethod9() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder,
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null, new AttributeSorter()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder, MemberVisitor)}
   */
  @Test
  public void testAddMethod10() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    assertSame(classBuilder,
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null, new AttributeSorter()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder, MemberVisitor)}
   */
  @Test
  public void testAddMethod11() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null, null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder, MemberVisitor)}
   */
  @Test
  public void testAddMethod12() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null,
        new BootstrapMethodsAttributeShrinker()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder, MemberVisitor)}
   */
  @Test
  public void testAddMethod13() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder,
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null, new BridgeMethodFixer()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, int, ClassBuilder.CodeBuilder, MemberVisitor)}
   */
  @Test
  public void testAddMethod14() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder,
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null, new ConstantPoolShrinker()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod15() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod16() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod17() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", null));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod18() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder,
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", new BootstrapMethodsAttributeShrinker()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod19() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", new BridgeMethodFixer()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod20() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", new ConstantPoolShrinker()));
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  public void testAddAndReturnMethod() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Method Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Method Name", ((Utf8Constant) constant).getString());
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(1, programClass.methods.length);
    assertEquals(1, programClass.u2methodsCount);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    assertEquals(5, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(6, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  public void testAddAndReturnMethod2() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Method Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Method Name", ((Utf8Constant) constant).getString());
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    ProgramMethod[] programMethodArray = programClass.methods;
    assertEquals(2, programMethodArray.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(5, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(6, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(actualAddAndReturnMethodResult.attributes, (programMethodArray[0]).attributes);
    byte[] expectedBytes = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  public void testAddAndReturnMethod3() {
    // Arrange
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor");

    // Assert
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(1, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    assertEquals(2, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertSame(programClass, classBuilder.getProgramClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  public void testAddAndReturnMethod4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor");

    // Assert
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    assertEquals(3, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(4, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertSame(programClass, classBuilder.getProgramClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddAndReturnMethod5() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor", 3, null);

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Method Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Method Name", ((Utf8Constant) constant).getString());
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(1, programClass.methods.length);
    assertEquals(1, programClass.u2methodsCount);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    assertEquals(5, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(6, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddAndReturnMethod6() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor", 3, null);

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Method Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Method Name", ((Utf8Constant) constant).getString());
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    ProgramMethod[] programMethodArray = programClass.methods;
    assertEquals(2, programMethodArray.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(5, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(6, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(actualAddAndReturnMethodResult.attributes, (programMethodArray[0]).attributes);
    byte[] expectedBytes = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddAndReturnMethod7() {
    // Arrange
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor", 3, null);

    // Assert
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(1, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    assertEquals(2, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertSame(programClass, classBuilder.getProgramClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#addAndReturnMethod(int, String, String, int, ClassBuilder.CodeBuilder)}
   */
  @Test
  public void testAddAndReturnMethod8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult = classBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor", 3, null);

    // Assert
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(0, actualAddAndReturnMethodResult.attributes.length);
    assertEquals(0, actualAddAndReturnMethodResult.u2attributesCount);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
    assertEquals(3, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(4, actualAddAndReturnMethodResult.u2descriptorIndex);
    assertSame(programClass, classBuilder.getProgramClass());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassBuilder#getConstantPoolEditor()}
   *   <li>{@link ClassBuilder#getProgramClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ConstantPoolEditor actualConstantPoolEditor = classBuilder.getConstantPoolEditor();
    ProgramClass actualProgramClass = classBuilder.getProgramClass();

    // Assert
    ProgramClass targetClass = actualConstantPoolEditor.getTargetClass();
    assertEquals("Class Name", targetClass.getName());
    assertEquals("Superclass Name", targetClass.getSuperName());
    assertNull(targetClass.getProcessingInfo());
    assertNull(targetClass.getFeatureName());
    assertNull(targetClass.getSuperClass());
    assertNull(targetClass.kotlinMetadata);
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    Attribute[] attributeArray = targetClass.attributes;
    assertEquals(0, attributeArray.length);
    ProgramField[] programFieldArray = targetClass.fields;
    assertEquals(0, programFieldArray.length);
    ProgramMethod[] programMethodArray = targetClass.methods;
    assertEquals(0, programMethodArray.length);
    Clazz[] clazzArray = targetClass.subClasses;
    assertEquals(0, clazzArray.length);
    int[] intArray = targetClass.u2interfaces;
    assertEquals(0, intArray.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(1, targetClass.getAccessFlags());
    assertEquals(1, targetClass.u4version);
    assertEquals(2, targetClass.u2thisClass);
    assertEquals(4, targetClass.u2superClass);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertSame(targetClass, actualProgramClass);
    assertSame(actualProgramClass.attributes, attributeArray);
    assertSame(actualProgramClass.constantPool, targetClass.constantPool);
    assertSame(actualProgramClass.fields, programFieldArray);
    assertSame(actualProgramClass.methods, programMethodArray);
    assertSame(actualProgramClass.subClasses, clazzArray);
    assertSame(actualProgramClass.u2interfaces, intArray);
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(int, int, String, String)}
   */
  @Test
  public void testNewClassBuilder() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("Class Name", programClass.getName());
    assertEquals("Class Name", ((Utf8Constant) constant3).getString());
    assertEquals("Superclass Name", programClass.getSuperName());
    assertEquals("Superclass Name", ((Utf8Constant) constant4).getString());
    assertNull(programClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(programClass.getFeatureName());
    assertNull(programClass.getSuperClass());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant2).javaLangClassClass);
    assertNull(((ClassConstant) constant2).referencedClass);
    assertNull(constantArray[0]);
    assertNull(constantArray[10]);
    assertNull(constantArray[11]);
    assertNull(constantArray[12]);
    assertNull(constantArray[13]);
    assertNull(constantArray[14]);
    assertNull(constantArray[15]);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertNull(constantArray[19]);
    assertNull(constantArray[20]);
    assertNull(constantArray[21]);
    assertNull(constantArray[22]);
    assertNull(constantArray[23]);
    assertNull(constantArray[231]);
    assertNull(constantArray[232]);
    assertNull(constantArray[233]);
    assertNull(constantArray[234]);
    assertNull(constantArray[235]);
    assertNull(constantArray[236]);
    assertNull(constantArray[237]);
    assertNull(constantArray[238]);
    assertNull(constantArray[239]);
    assertNull(constantArray[24]);
    assertNull(constantArray[240]);
    assertNull(constantArray[241]);
    assertNull(constantArray[242]);
    assertNull(constantArray[243]);
    assertNull(constantArray[244]);
    assertNull(constantArray[245]);
    assertNull(constantArray[246]);
    assertNull(constantArray[247]);
    assertNull(constantArray[248]);
    assertNull(constantArray[249]);
    assertNull(constantArray[250]);
    assertNull(constantArray[251]);
    assertNull(constantArray[252]);
    assertNull(constantArray[253]);
    assertNull(constantArray[254]);
    assertNull(constantArray[255]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertNull(constantArray[ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE]);
    assertNull(programClass.kotlinMetadata);
    assertEquals(0, programClass.getInterfaceCount());
    assertEquals(0, programClass.getProcessingFlags());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, programClass.attributes.length);
    assertEquals(0, programClass.fields.length);
    assertEquals(0, programClass.methods.length);
    assertEquals(0, programClass.subClasses.length);
    assertEquals(0, programClass.u2interfaces.length);
    assertEquals(0, programClass.subClassCount);
    assertEquals(0, programClass.u2attributesCount);
    assertEquals(0, programClass.u2fieldsCount);
    assertEquals(0, programClass.u2methodsCount);
    assertEquals(1, programClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, programClass.u4version);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, programClass.u2superClass);
    assertEquals(5, programClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(programClass.getExtraFeatureNames().isEmpty());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes2 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(int, int, String, String)}
   */
  @Test
  public void testNewClassBuilder2() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Class Name", null);

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Class Name", programClass.getName());
    assertEquals("Class Name", ((Utf8Constant) constant2).getString());
    assertNull(programClass.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(programClass.getSuperName());
    assertNull(programClass.getFeatureName());
    assertNull(programClass.getSuperClass());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(constantArray[0]);
    assertNull(constantArray[10]);
    assertNull(constantArray[11]);
    assertNull(constantArray[12]);
    assertNull(constantArray[13]);
    assertNull(constantArray[14]);
    assertNull(constantArray[15]);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertNull(constantArray[19]);
    assertNull(constantArray[20]);
    assertNull(constantArray[21]);
    assertNull(constantArray[22]);
    assertNull(constantArray[23]);
    assertNull(constantArray[231]);
    assertNull(constantArray[232]);
    assertNull(constantArray[233]);
    assertNull(constantArray[234]);
    assertNull(constantArray[235]);
    assertNull(constantArray[236]);
    assertNull(constantArray[237]);
    assertNull(constantArray[238]);
    assertNull(constantArray[239]);
    assertNull(constantArray[24]);
    assertNull(constantArray[240]);
    assertNull(constantArray[241]);
    assertNull(constantArray[242]);
    assertNull(constantArray[243]);
    assertNull(constantArray[244]);
    assertNull(constantArray[245]);
    assertNull(constantArray[246]);
    assertNull(constantArray[247]);
    assertNull(constantArray[248]);
    assertNull(constantArray[249]);
    assertNull(constantArray[250]);
    assertNull(constantArray[251]);
    assertNull(constantArray[252]);
    assertNull(constantArray[253]);
    assertNull(constantArray[254]);
    assertNull(constantArray[255]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertNull(constantArray[ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE]);
    assertNull(programClass.kotlinMetadata);
    assertEquals(0, programClass.getInterfaceCount());
    assertEquals(0, programClass.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, programClass.attributes.length);
    assertEquals(0, programClass.fields.length);
    assertEquals(0, programClass.methods.length);
    assertEquals(0, programClass.subClasses.length);
    assertEquals(0, programClass.u2interfaces.length);
    assertEquals(0, programClass.subClassCount);
    assertEquals(0, programClass.u2attributesCount);
    assertEquals(0, programClass.u2fieldsCount);
    assertEquals(0, programClass.u2methodsCount);
    assertEquals(0, programClass.u2superClass);
    assertEquals(1, programClass.getAccessFlags());
    assertEquals(1, constant2.getTag());
    assertEquals(1, programClass.u4version);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, programClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertTrue(programClass.getExtraFeatureNames().isEmpty());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(int, int, String, String)}
   */
  @Test
  public void testNewClassBuilder3() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Test.class", "Test.class");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Test.class", programClass.getName());
    assertEquals("Test.class", programClass.getSuperName());
    assertEquals("Test.class", ((Utf8Constant) constant2).getString());
    assertNull(programClass.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(programClass.getFeatureName());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(constantArray[0]);
    assertNull(constantArray[10]);
    assertNull(constantArray[11]);
    assertNull(constantArray[12]);
    assertNull(constantArray[13]);
    assertNull(constantArray[14]);
    assertNull(constantArray[15]);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertNull(constantArray[19]);
    assertNull(constantArray[20]);
    assertNull(constantArray[21]);
    assertNull(constantArray[22]);
    assertNull(constantArray[23]);
    assertNull(constantArray[231]);
    assertNull(constantArray[232]);
    assertNull(constantArray[233]);
    assertNull(constantArray[234]);
    assertNull(constantArray[235]);
    assertNull(constantArray[236]);
    assertNull(constantArray[237]);
    assertNull(constantArray[238]);
    assertNull(constantArray[239]);
    assertNull(constantArray[24]);
    assertNull(constantArray[240]);
    assertNull(constantArray[241]);
    assertNull(constantArray[242]);
    assertNull(constantArray[243]);
    assertNull(constantArray[244]);
    assertNull(constantArray[245]);
    assertNull(constantArray[246]);
    assertNull(constantArray[247]);
    assertNull(constantArray[248]);
    assertNull(constantArray[249]);
    assertNull(constantArray[250]);
    assertNull(constantArray[251]);
    assertNull(constantArray[252]);
    assertNull(constantArray[253]);
    assertNull(constantArray[254]);
    assertNull(constantArray[255]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertNull(constantArray[ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE]);
    assertNull(programClass.kotlinMetadata);
    assertEquals(0, programClass.getInterfaceCount());
    assertEquals(0, programClass.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, programClass.attributes.length);
    assertEquals(0, programClass.fields.length);
    assertEquals(0, programClass.methods.length);
    assertEquals(0, programClass.subClasses.length);
    assertEquals(0, programClass.u2interfaces.length);
    assertEquals(0, programClass.subClassCount);
    assertEquals(0, programClass.u2attributesCount);
    assertEquals(0, programClass.u2fieldsCount);
    assertEquals(0, programClass.u2methodsCount);
    assertEquals(1, programClass.getAccessFlags());
    assertEquals(1, constant2.getTag());
    assertEquals(1, programClass.u4version);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, programClass.u2superClass);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, programClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertTrue(programClass.getExtraFeatureNames().isEmpty());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, programClass.getSuperClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Test.class".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(int, int, String, String, String, int, Object)}
   */
  @Test
  public void testNewClassBuilder4() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name", "Feature Name", 1,
        "Processing Info");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("Class Name", programClass.getName());
    assertEquals("Class Name", ((Utf8Constant) constant3).getString());
    assertEquals("Feature Name", programClass.getFeatureName());
    assertEquals("Processing Info", programClass.getProcessingInfo());
    assertEquals("Superclass Name", programClass.getSuperName());
    assertEquals("Superclass Name", ((Utf8Constant) constant4).getString());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(programClass.getSuperClass());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant2).javaLangClassClass);
    assertNull(((ClassConstant) constant2).referencedClass);
    assertNull(constantArray[0]);
    assertNull(constantArray[10]);
    assertNull(constantArray[11]);
    assertNull(constantArray[12]);
    assertNull(constantArray[13]);
    assertNull(constantArray[14]);
    assertNull(constantArray[15]);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertNull(constantArray[19]);
    assertNull(constantArray[20]);
    assertNull(constantArray[21]);
    assertNull(constantArray[22]);
    assertNull(constantArray[23]);
    assertNull(constantArray[231]);
    assertNull(constantArray[232]);
    assertNull(constantArray[233]);
    assertNull(constantArray[234]);
    assertNull(constantArray[235]);
    assertNull(constantArray[236]);
    assertNull(constantArray[237]);
    assertNull(constantArray[238]);
    assertNull(constantArray[239]);
    assertNull(constantArray[24]);
    assertNull(constantArray[240]);
    assertNull(constantArray[241]);
    assertNull(constantArray[242]);
    assertNull(constantArray[243]);
    assertNull(constantArray[244]);
    assertNull(constantArray[245]);
    assertNull(constantArray[246]);
    assertNull(constantArray[247]);
    assertNull(constantArray[248]);
    assertNull(constantArray[249]);
    assertNull(constantArray[250]);
    assertNull(constantArray[251]);
    assertNull(constantArray[252]);
    assertNull(constantArray[253]);
    assertNull(constantArray[254]);
    assertNull(constantArray[255]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertNull(constantArray[ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE]);
    assertNull(programClass.kotlinMetadata);
    assertEquals(0, programClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, programClass.attributes.length);
    assertEquals(0, programClass.fields.length);
    assertEquals(0, programClass.methods.length);
    assertEquals(0, programClass.subClasses.length);
    assertEquals(0, programClass.u2interfaces.length);
    assertEquals(0, programClass.subClassCount);
    assertEquals(0, programClass.u2attributesCount);
    assertEquals(0, programClass.u2fieldsCount);
    assertEquals(0, programClass.u2methodsCount);
    assertEquals(1, programClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, programClass.getProcessingFlags());
    assertEquals(1, programClass.u4version);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, programClass.u2superClass);
    assertEquals(5, programClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(programClass.getExtraFeatureNames().isEmpty());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes2 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(int, int, String, String, String, int, Object)}
   */
  @Test
  public void testNewClassBuilder5() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Class Name", null, "Feature Name", 1, "Processing Info");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Class Name", programClass.getName());
    assertEquals("Class Name", ((Utf8Constant) constant2).getString());
    assertEquals("Feature Name", programClass.getFeatureName());
    assertEquals("Processing Info", programClass.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(constantArray[0]);
    assertNull(constantArray[10]);
    assertNull(constantArray[11]);
    assertNull(constantArray[12]);
    assertNull(constantArray[13]);
    assertNull(constantArray[14]);
    assertNull(constantArray[15]);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertNull(constantArray[19]);
    assertNull(constantArray[20]);
    assertNull(constantArray[21]);
    assertNull(constantArray[22]);
    assertNull(constantArray[23]);
    assertNull(constantArray[231]);
    assertNull(constantArray[232]);
    assertNull(constantArray[233]);
    assertNull(constantArray[234]);
    assertNull(constantArray[235]);
    assertNull(constantArray[236]);
    assertNull(constantArray[237]);
    assertNull(constantArray[238]);
    assertNull(constantArray[239]);
    assertNull(constantArray[24]);
    assertNull(constantArray[240]);
    assertNull(constantArray[241]);
    assertNull(constantArray[242]);
    assertNull(constantArray[243]);
    assertNull(constantArray[244]);
    assertNull(constantArray[245]);
    assertNull(constantArray[246]);
    assertNull(constantArray[247]);
    assertNull(constantArray[248]);
    assertNull(constantArray[249]);
    assertNull(constantArray[250]);
    assertNull(constantArray[251]);
    assertNull(constantArray[252]);
    assertNull(constantArray[253]);
    assertNull(constantArray[254]);
    assertNull(constantArray[255]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertNull(constantArray[ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE]);
    assertNull(programClass.kotlinMetadata);
    assertEquals(0, programClass.getInterfaceCount());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, programClass.attributes.length);
    assertEquals(0, programClass.fields.length);
    assertEquals(0, programClass.methods.length);
    assertEquals(0, programClass.subClasses.length);
    assertEquals(0, programClass.u2interfaces.length);
    assertEquals(0, programClass.subClassCount);
    assertEquals(0, programClass.u2attributesCount);
    assertEquals(0, programClass.u2fieldsCount);
    assertEquals(0, programClass.u2methodsCount);
    assertEquals(0, programClass.u2superClass);
    assertEquals(1, programClass.getAccessFlags());
    assertEquals(1, constant2.getTag());
    assertEquals(1, programClass.getProcessingFlags());
    assertEquals(1, programClass.u4version);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, programClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertTrue(programClass.getExtraFeatureNames().isEmpty());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass)}
   */
  @Test
  public void testNewClassBuilder6() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass)}
   */
  @Test
  public void testNewClassBuilder7() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.u2constantPoolCount = 2;

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewClassBuilder8() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass, KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewClassBuilder9() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.u2constantPoolCount = 1;

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewClassBuilder10() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.u2constantPoolCount = 2;

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }
}
