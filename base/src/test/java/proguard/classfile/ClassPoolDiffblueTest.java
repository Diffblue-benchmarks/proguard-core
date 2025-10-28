package proguard.classfile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassPoolDiffblueTest {
  /**
   * Method under test: {@link ClassPool#removeClass(String)}
   */
  @Test
  public void testRemoveClass() {
    // Arrange, Act and Assert
    assertNull(KotlinConstants.dummyClassPool.removeClass("Class Name"));
  }

  /**
   * Method under test: {@link ClassPool#getClass(String)}
   */
  @Test
  public void testGetClass() {
    // Arrange, Act and Assert
    assertNull(KotlinConstants.dummyClassPool.getClass("Class Name"));
  }

  /**
   * Method under test: {@link ClassPool#getClass(String)}
   */
  @Test
  public void testGetClass2() throws UnsupportedEncodingException {
    // Arrange and Act
    Clazz actualClass = KotlinConstants.dummyClassPool.getClass("kotlin/Function");

    // Assert
    assertTrue(actualClass instanceof ProgramClass);
    Constant[] constantArray = ((ProgramClass) actualClass).constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof ClassConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[3];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals("kotlin/Function", actualClass.getName());
    assertEquals("kotlin/Function", ((Utf8Constant) constant3).getString());
    assertNull(actualClass.getProcessingInfo());
    assertNull(constant3.getProcessingInfo());
    assertNull(constant.getProcessingInfo());
    assertNull(constant4.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertNull(actualClass.getFeatureName());
    assertNull(actualClass.getSuperClass());
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
    assertNull(constantArray[AccessConstants.FINAL]);
    assertNull(((ProgramClass) actualClass).kotlinMetadata);
    assertEquals(0, actualClass.getInterfaceCount());
    assertEquals(0, constant3.getProcessingFlags());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant4.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(0, ((ProgramClass) actualClass).attributes.length);
    assertEquals(0, ((ProgramClass) actualClass).fields.length);
    assertEquals(0, ((ProgramClass) actualClass).methods.length);
    assertEquals(0, ((ProgramClass) actualClass).subClasses.length);
    assertEquals(0, ((ProgramClass) actualClass).u2interfaces.length);
    assertEquals(0, ((ProgramClass) actualClass).subClassCount);
    assertEquals(0, ((ProgramClass) actualClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) actualClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) actualClass).u2methodsCount);
    assertEquals(1, actualClass.getAccessFlags());
    assertEquals(1, constant3.getTag());
    assertEquals(1, constant4.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(2, ((ProgramClass) actualClass).u2thisClass);
    assertEquals(3, ((ClassConstant) constant2).u2nameIndex);
    assertEquals(4, ((ProgramClass) actualClass).u2superClass);
    assertEquals(5, ((ProgramClass) actualClass).u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertEquals(7, constant2.getTag());
    assertEquals(7340032, actualClass.getProcessingFlags());
    assertFalse(constant3.isCategory2());
    assertFalse(constant.isCategory2());
    assertFalse(constant4.isCategory2());
    assertFalse(constant2.isCategory2());
    assertTrue(actualClass.getExtraFeatureNames().isEmpty());
    assertEquals(AccessConstants.NATIVE, constantArray.length);
    assertEquals(ClassConstants.NAME_JAVA_LANG_OBJECT, actualClass.getSuperName());
    assertEquals(ClassConstants.NAME_JAVA_LANG_OBJECT, ((Utf8Constant) constant4).getString());
    assertEquals(VersionConstants.CLASS_VERSION_11_MAJOR, ((ProgramClass) actualClass).u4version);
    assertSame(actualClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "java/lang/Object".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes2 = "kotlin/Function".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Method under test: {@link ClassPool#contains(Clazz)}
   */
  @Test
  public void testContains() {
    // Arrange, Act and Assert
    assertFalse(KotlinConstants.dummyClassPool.contains(new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassPool#refreshedKeysCopy(Map)}
   */
  @Test
  public void testRefreshedKeysCopy() {
    // Arrange, Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedKeysCopy(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link ClassPool#refreshedKeysCopy(Map)}
   */
  @Test
  public void testRefreshedKeysCopy2() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", "42");

    // Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedKeysCopy(map).isEmpty());
  }

  /**
   * Method under test: {@link ClassPool#refreshedValuesCopy(Map)}
   */
  @Test
  public void testRefreshedValuesCopy() {
    // Arrange, Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedValuesCopy(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link ClassPool#refreshedValuesCopy(Map)}
   */
  @Test
  public void testRefreshedValuesCopy2() {
    // Arrange
    HashMap<Object, String> map = new HashMap<>();
    map.put("42", "foo");

    // Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedValuesCopy(map).isEmpty());
  }

  /**
   * Method under test: {@link ClassPool#ClassPool()}
   */
  @Test
  public void testNewClassPool() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool()).size());
    assertEquals(0, (new ClassPool(new ArrayList<>())).size());
    assertEquals(1, (new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"))).size());
  }
}
