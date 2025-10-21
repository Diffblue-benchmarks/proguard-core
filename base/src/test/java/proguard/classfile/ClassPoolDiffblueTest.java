package proguard.classfile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassPoolDiffblueTest {
  /**
   * Test {@link ClassPool#ClassPool()}.
   *
   * <p>Method under test: {@link ClassPool#ClassPool()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPool.<init>()"})
  public void testNewClassPool() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool()).size());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPool.<init>(Clazz[])"})
  public void testNewClassPool_thenReturnSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPool.<init>(Iterable)"})
  public void testNewClassPool_whenArrayList_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ClassPool(new ArrayList<>())).size());
  }

  /**
   * Test {@link ClassPool#removeClass(String)} with {@code className}.
   *
   * <p>Method under test: {@link ClassPool#removeClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz ClassPool.removeClass(String)"})
  public void testRemoveClassWithClassName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz ClassPool.getClass(String)"})
  public void testGetClassWithString_whenClassName_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz ClassPool.getClass(String)"})
  public void testGetClassWithString_whenKotlinFunction_thenReturnProgramClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPool.contains(Clazz)"})
  public void testContains() {
    // Arrange, Act and Assert
    assertFalse(KotlinConstants.dummyClassPool.contains(new LibraryClass()));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ClassPool.refreshedKeysCopy(Map)"})
  public void testRefreshedKeysCopy_givenFoo_whenHashMapFooIs42_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ClassPool.refreshedKeysCopy(Map)"})
  public void testRefreshedKeysCopy_whenHashMap_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ClassPool.refreshedValuesCopy(Map)"})
  public void testRefreshedValuesCopy_givenFoo_whenHashMap42IsFoo_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ClassPool.refreshedValuesCopy(Map)"})
  public void testRefreshedValuesCopy_whenHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(KotlinConstants.dummyClassPool.refreshedValuesCopy(new HashMap<>()).isEmpty());
  }
}
