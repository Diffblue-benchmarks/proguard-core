package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.testutils.cpa.NamedClass;

public class DebugUtilDiffblueTest {
  /**
   * Test {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)} with {@code cfa}, {@code
   * signature}, {@code verbose}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(JvmCfa, MethodSignature, boolean)"})
  public void testAsStringWithCfaSignatureVerbose_givenLibraryClass() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
  }

  /**
   * Test {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)} with {@code cfa}, {@code
   * signature}, {@code verbose}.
   *
   * <ul>
   *   <li>Given {@link NamedClass#NamedClass(String)} with memberName is {@code cfa}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(JvmCfa, MethodSignature, boolean)"})
  public void testAsStringWithCfaSignatureVerbose_givenNamedClassWithMemberNameIsCfa() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new NamedClass("cfa"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
  }

  /**
   * Test {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)} with {@code cfa}, {@code
   * signature}, {@code verbose}.
   *
   * <ul>
   *   <li>When {@link JvmCfa} (default constructor).
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(JvmCfa, MethodSignature, boolean)"})
  public void testAsStringWithCfaSignatureVerbose_whenJvmCfa_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(
                new JvmCfa(), ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
  }

  /**
   * Test {@link DebugUtil#asString(JvmCfa, MethodSignature)} with {@code cfa}, {@code signature}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(JvmCfa, MethodSignature)"})
  public void testAsStringWithCfaSignature_givenLibraryClass() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link DebugUtil#asString(JvmCfa, MethodSignature)} with {@code cfa}, {@code signature}.
   *
   * <ul>
   *   <li>Given {@link NamedClass#NamedClass(String)} with memberName is {@code cfa}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(JvmCfa, MethodSignature)"})
  public void testAsStringWithCfaSignature_givenNamedClassWithMemberNameIsCfa() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new NamedClass("cfa"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link DebugUtil#asString(JvmCfa, MethodSignature)} with {@code cfa}, {@code signature}.
   *
   * <ul>
   *   <li>When {@link JvmCfa} (default constructor).
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(JvmCfa, MethodSignature)"})
  public void testAsStringWithCfaSignature_whenJvmCfa_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(
                new JvmCfa(), ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link DebugUtil#asString(ClassPool, String)} with {@code classPool}, {@code className}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(ClassPool, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(ClassPool, String)"})
  public void testAsStringWithClassPoolClassName_whenClassName_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> DebugUtil.asString(KotlinConstants.dummyClassPool, "Class Name"));
  }

  /**
   * Test {@link DebugUtil#asString(Clazz, Method)} with {@code clazz}, {@code method}.
   *
   * <p>Method under test: {@link DebugUtil#asString(Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(Clazz, Method)"})
  public void testAsStringWithClazzMethod() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("", DebugUtil.asString(clazz, new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link DebugUtil#asString(Clazz, Method, boolean)} with {@code clazz}, {@code method},
   * {@code verbose}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(Clazz, Method, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(Clazz, Method, boolean)"})
  public void testAsStringWithClazzMethodVerbose_whenFalse_thenReturnEmptyString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("", DebugUtil.asString(clazz, new LibraryMethod(1, "Name", "Descriptor"), false));
  }

  /**
   * Test {@link DebugUtil#asString(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.asString(Clazz)"})
  public void testAsStringWithClazz_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "_____________________________________________________________________\n"
            + "- Library class: clazz\n"
            + "  Superclass:    clazz\n"
            + "  Access flags:  0x1\n"
            + "    = public class clazz extends clazz\n"
            + "\n"
            + "Interfaces (count = 0):\n"
            + "Fields (count = 0):\n"
            + "Methods (count = 0):\n",
        DebugUtil.asString(new LibraryClass(1, "clazz", "clazz")));
  }

  /**
   * Test {@link DebugUtil#getMethodFqnList(ClassPool, String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#getMethodFqnList(ClassPool, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DebugUtil.getMethodFqnList(ClassPool, String)"})
  public void testGetMethodFqnList_whenClassName_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> DebugUtil.getMethodFqnList(KotlinConstants.dummyClassPool, "Class Name"));
  }
}
