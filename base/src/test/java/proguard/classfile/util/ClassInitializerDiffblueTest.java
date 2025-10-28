package proguard.classfile.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassInitializerDiffblueTest {
  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}
   */
  @Test
  public void testNewClassInitializer() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() throws UnsupportedEncodingException {
    // Arrange
    ClassInitializer classInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass2() throws UnsupportedEncodingException {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassInitializer classInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass3() throws UnsupportedEncodingException {
    // Arrange
    ClassInitializer classInitializer = new ClassInitializer(new ClassPool(), KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}
   */
  @Test
  public void testNewClassInitializer2() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassInitializer actualClassInitializer = new ClassInitializer(new ClassPool(), KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer3() {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer4() {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new ProgramClass());

    // Assert
    assertEquals(0, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer5() {
    // Arrange
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, null, missingProgramMemberWarningPrinter, missingLibraryMemberWarningPrinter,
        new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(0, missingProgramMemberWarningPrinter.getWarningCount());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer6() throws UnsupportedEncodingException {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, missingClassWarningPrinter.getWarningCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor)}
   */
  @Test
  public void testNewClassInitializer7() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, true, null, null);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor)}
   */
  @Test
  public void testNewClassInitializer8() throws UnsupportedEncodingException {
    // Arrange and Act
    ClassInitializer actualClassInitializer = new ClassInitializer(new ClassPool(), KotlinConstants.dummyClassPool,
        true, null, null);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer9() {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, true, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer10() {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, true, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new ProgramClass());

    // Assert
    assertEquals(0, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer11() {
    // Arrange
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, true, null, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(0, missingProgramMemberWarningPrinter.getWarningCount());
  }

  /**
   * Method under test:
   * {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  public void testNewClassInitializer12() throws UnsupportedEncodingException {
    // Arrange
    WarningPrinter missingClassWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer = new ClassInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, true, missingClassWarningPrinter, missingProgramMemberWarningPrinter,
        missingLibraryMemberWarningPrinter, new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) superClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("java/lang/Object", ((Utf8Constant) constant4).getString());
    assertEquals("kotlin/Function", superClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(superClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(superClass.getFeatureName());
    assertNull(superClass.getSuperClass());
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
    assertNull(constantArray[Short.SIZE]);
    assertNull(((ProgramClass) superClass).kotlinMetadata);
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, missingClassWarningPrinter.getWarningCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, constantArray.length);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, superClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(superClass.getExtraFeatureNames().isEmpty());
    assertSame(superClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }
}
