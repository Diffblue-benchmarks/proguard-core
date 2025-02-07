package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassPoolVisitor;
import proguard.classfile.visitor.ClassVisitor;

class ClassPoolDiffblueTest {
  /**
   * Test {@link ClassPool#ClassPool()}.
   *
   * <p>Method under test: {@link ClassPool#ClassPool()}
   */
  @Test
  @DisplayName("Test new ClassPool()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassPool.<init>()"})
  void testNewClassPool() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool()).size());
  }

  /**
   * Test {@link ClassPool#ClassPool(ClassPool)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#ClassPool(ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassPool(ClassPool); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassPool.<init>(proguard.classfile.ClassPool)"})
  void testNewClassPool_thenReturnSizeIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ClassPool(new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"))))
            .size());
  }

  /**
   * Test {@link ClassPool#ClassPool(Clazz[])}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#ClassPool(Clazz[])}
   */
  @Test
  @DisplayName("Test new ClassPool(Clazz[]); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassPool.<init>(proguard.classfile.Clazz[])"})
  void testNewClassPool_thenReturnSizeIsOne2() {
    // Arrange, Act and Assert
    assertEquals(
        1, (new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"))).size());
  }

  /**
   * Test {@link ClassPool#ClassPool(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#ClassPool(Iterable)}
   */
  @Test
  @DisplayName("Test new ClassPool(Iterable); when ArrayList(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassPool.<init>(java.lang.Iterable)"})
  void testNewClassPool_whenArrayList_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool(new ArrayList<>())).size());
  }

  /**
   * Test {@link ClassPool#ClassPool(ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ClassPool#ClassPool()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#ClassPool(ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassPool(ClassPool); when ClassPool(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassPool.<init>(proguard.classfile.ClassPool)"})
  void testNewClassPool_whenClassPool_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool(new ClassPool())).size());
  }

  /**
   * Test {@link ClassPool#removeClass(String)} with {@code className}.
   *
   * <p>Method under test: {@link ClassPool#removeClass(String)}
   */
  @Test
  @DisplayName("Test removeClass(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.classfile.ClassPool.removeClass(java.lang.String)"
  })
  void testRemoveClassWithClassName() {
    // Arrange, Act and Assert
    assertNull(KotlinConstants.dummyClassPool.removeClass("Class Name"));
  }

  /**
   * Test {@link ClassPool#getClass(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#getClass(String)}
   */
  @Test
  @DisplayName("Test getClass(String) with 'String'; when 'Class Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.classfile.ClassPool.getClass(java.lang.String)"
  })
  void testGetClassWithString_whenClassName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(KotlinConstants.dummyClassPool.getClass("Class Name"));
  }

  /**
   * Test {@link ClassPool#getClass(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code kotlin/Function}.
   *   <li>Then return {@link ProgramClass}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#getClass(String)}
   */
  @Test
  @DisplayName(
      "Test getClass(String) with 'String'; when 'kotlin/Function'; then return ProgramClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.classfile.ClassPool.getClass(java.lang.String)"
  })
  void testGetClassWithString_whenKotlinFunction_thenReturnProgramClass() {
    // Arrange and Act
    Clazz actualClass = KotlinConstants.dummyClassPool.getClass("kotlin/Function");

    // Assert
    assertTrue(actualClass instanceof ProgramClass);
    assertEquals("kotlin/Function", actualClass.getName());
    assertNull(actualClass.getProcessingInfo());
    assertNull(actualClass.getFeatureName());
    assertNull(actualClass.getSuperClass());
    assertNull(((ProgramClass) actualClass).kotlinMetadata);
    assertEquals(0, actualClass.getInterfaceCount());
    assertEquals(0, ((ProgramClass) actualClass).attributes.length);
    assertEquals(0, ((ProgramClass) actualClass).fields.length);
    assertEquals(0, ((ProgramClass) actualClass).methods.length);
    assertEquals(0, ((ProgramClass) actualClass).subClasses.length);
    assertEquals(0, ((ProgramClass) actualClass).subClassCount);
    assertEquals(0, ((ProgramClass) actualClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) actualClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) actualClass).u2methodsCount);
    assertEquals(1, actualClass.getAccessFlags());
    assertEquals(2, ((ProgramClass) actualClass).u2thisClass);
    assertEquals(4, ((ProgramClass) actualClass).u2superClass);
    assertEquals(5, ((ProgramClass) actualClass).u2constantPoolCount);
    assertEquals(7340032, actualClass.getProcessingFlags());
    assertTrue(actualClass.getExtraFeatureNames().isEmpty());
    assertEquals(AccessConstants.NATIVE, ((ProgramClass) actualClass).constantPool.length);
    assertEquals(ClassConstants.NAME_JAVA_LANG_OBJECT, actualClass.getSuperName());
    assertEquals(VersionConstants.CLASS_VERSION_11_MAJOR, ((ProgramClass) actualClass).u4version);
    assertArrayEquals(new int[] {}, ((ProgramClass) actualClass).u2interfaces);
  }

  /**
   * Test {@link ClassPool#contains(Clazz)}.
   *
   * <p>Method under test: {@link ClassPool#contains(Clazz)}
   */
  @Test
  @DisplayName("Test contains(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ClassPool.contains(proguard.classfile.Clazz)"})
  void testContains() {
    // Arrange, Act and Assert
    assertFalse(KotlinConstants.dummyClassPool.contains(new LibraryClass()));
  }

  /**
   * Test {@link ClassPool#refreshedCopy()}.
   *
   * <ul>
   *   <li>Given {@link ClassPool#ClassPool()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#refreshedCopy()}
   */
  @Test
  @DisplayName("Test refreshedCopy(); given ClassPool(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.classfile.ClassPool proguard.classfile.ClassPool.refreshedCopy()"})
  void testRefreshedCopy_givenClassPool_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool()).refreshedCopy().size());
  }

  /**
   * Test {@link ClassPool#refreshedCopy()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#refreshedCopy()}
   */
  @Test
  @DisplayName("Test refreshedCopy(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.classfile.ClassPool proguard.classfile.ClassPool.refreshedCopy()"})
  void testRefreshedCopy_thenReturnSizeIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")))
            .refreshedCopy()
            .size());
  }

  /**
   * Test {@link ClassPool#refreshedKeysCopy(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#refreshedKeysCopy(Map)}
   */
  @Test
  @DisplayName(
      "Test refreshedKeysCopy(Map); given 'foo'; when HashMap() 'foo' is '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map proguard.classfile.ClassPool.refreshedKeysCopy(java.util.Map)"})
  void testRefreshedKeysCopy_givenFoo_whenHashMapFooIs42_thenReturnEmpty() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", "42");

    // Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedKeysCopy(map).isEmpty());
  }

  /**
   * Test {@link ClassPool#refreshedKeysCopy(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#refreshedKeysCopy(Map)}
   */
  @Test
  @DisplayName("Test refreshedKeysCopy(Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map proguard.classfile.ClassPool.refreshedKeysCopy(java.util.Map)"})
  void testRefreshedKeysCopy_whenHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedKeysCopy(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link ClassPool#refreshedValuesCopy(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#refreshedValuesCopy(Map)}
   */
  @Test
  @DisplayName(
      "Test refreshedValuesCopy(Map); given 'foo'; when HashMap() '42' is 'foo'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.classfile.ClassPool.refreshedValuesCopy(java.util.Map)"
  })
  void testRefreshedValuesCopy_givenFoo_whenHashMap42IsFoo_thenReturnEmpty() {
    // Arrange
    HashMap<Object, String> map = new HashMap<>();
    map.put("42", "foo");

    // Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedValuesCopy(map).isEmpty());
  }

  /**
   * Test {@link ClassPool#refreshedValuesCopy(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#refreshedValuesCopy(Map)}
   */
  @Test
  @DisplayName("Test refreshedValuesCopy(Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.classfile.ClassPool.refreshedValuesCopy(java.util.Map)"
  })
  void testRefreshedValuesCopy_whenHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedValuesCopy(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link ClassPool#accept(ClassPoolVisitor)}.
   *
   * <p>Method under test: {@link ClassPool#accept(ClassPoolVisitor)}
   */
  @Test
  @DisplayName("Test accept(ClassPoolVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ClassPool.accept(proguard.classfile.visitor.ClassPoolVisitor)"
  })
  void testAccept() {
    // Arrange
    ClassPoolVisitor classPoolVisitor = mock(ClassPoolVisitor.class);
    doNothing().when(classPoolVisitor).visitClassPool(Mockito.<ClassPool>any());

    // Act
    KotlinConstants.dummyClassPool.accept(classPoolVisitor);

    // Assert
    verify(classPoolVisitor).visitClassPool(isA(ClassPool.class));
  }

  /**
   * Test {@link ClassPool#classAccept(String, ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@code kotlin/Function}.
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPool#classAccept(String, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test classAccept(String, ClassVisitor); when 'kotlin/Function'; then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ClassPool.classAccept(java.lang.String, proguard.classfile.visitor.ClassVisitor)"
  })
  void testClassAccept_whenKotlinFunction_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    KotlinConstants.dummyClassPool.classAccept("kotlin/Function", classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }
}
