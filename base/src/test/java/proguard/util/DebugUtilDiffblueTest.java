package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.MemberVisitor;
import proguard.testutils.cpa.NamedClass;

class DebugUtilDiffblueTest {
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
  @DisplayName(
      "Test asString(JvmCfa, MethodSignature, boolean) with 'cfa', 'signature', 'verbose'; given LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.analysis.cpa.jvm.cfa.JvmCfa, proguard.classfile.MethodSignature, boolean)"
  })
  void testAsStringWithCfaSignatureVerbose_givenLibraryClass() {
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
  @DisplayName(
      "Test asString(JvmCfa, MethodSignature, boolean) with 'cfa', 'signature', 'verbose'; given NamedClass(String) with memberName is 'cfa'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.analysis.cpa.jvm.cfa.JvmCfa, proguard.classfile.MethodSignature, boolean)"
  })
  void testAsStringWithCfaSignatureVerbose_givenNamedClassWithMemberNameIsCfa() {
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
  @DisplayName(
      "Test asString(JvmCfa, MethodSignature, boolean) with 'cfa', 'signature', 'verbose'; when JvmCfa (default constructor); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.analysis.cpa.jvm.cfa.JvmCfa, proguard.classfile.MethodSignature, boolean)"
  })
  void testAsStringWithCfaSignatureVerbose_whenJvmCfa_thenThrowIllegalStateException() {
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
  @DisplayName(
      "Test asString(JvmCfa, MethodSignature) with 'cfa', 'signature'; given LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.analysis.cpa.jvm.cfa.JvmCfa, proguard.classfile.MethodSignature)"
  })
  void testAsStringWithCfaSignature_givenLibraryClass() {
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
  @DisplayName(
      "Test asString(JvmCfa, MethodSignature) with 'cfa', 'signature'; given NamedClass(String) with memberName is 'cfa'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.analysis.cpa.jvm.cfa.JvmCfa, proguard.classfile.MethodSignature)"
  })
  void testAsStringWithCfaSignature_givenNamedClassWithMemberNameIsCfa() {
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
  @DisplayName(
      "Test asString(JvmCfa, MethodSignature) with 'cfa', 'signature'; when JvmCfa (default constructor); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.analysis.cpa.jvm.cfa.JvmCfa, proguard.classfile.MethodSignature)"
  })
  void testAsStringWithCfaSignature_whenJvmCfa_thenThrowIllegalStateException() {
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
  @DisplayName(
      "Test asString(ClassPool, String) with 'classPool', 'className'; when 'Class Name'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.ClassPool, java.lang.String)"
  })
  void testAsStringWithClassPoolClassName_whenClassName_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> DebugUtil.asString(KotlinConstants.dummyClassPool, "Class Name"));
  }

  /**
   * Test {@link DebugUtil#asString(ClassPool, MethodSignature)} with {@code classPool}, {@code
   * signature}.
   *
   * <p>Method under test: {@link DebugUtil#asString(ClassPool, MethodSignature)}
   */
  @Test
  @DisplayName("Test asString(ClassPool, MethodSignature) with 'classPool', 'signature'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.ClassPool, proguard.classfile.MethodSignature)"
  })
  void testAsStringWithClassPoolSignature() {
    // Arrange
    ClassPool classPool = mock(ClassPool.class);
    when(classPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(4, "classPool", "classPool"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(classPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    verify(classPool).getClass(eq("java/lang/ClassLoader"));
  }

  /**
   * Test {@link DebugUtil#asString(ClassPool, MethodSignature, boolean)} with {@code classPool},
   * {@code signature}, {@code verbose}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(ClassPool, MethodSignature, boolean)}
   */
  @Test
  @DisplayName(
      "Test asString(ClassPool, MethodSignature, boolean) with 'classPool', 'signature', 'verbose'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, boolean)"
  })
  void testAsStringWithClassPoolSignatureVerbose_thenReturnEmptyString() {
    // Arrange
    Method method = mock(Method.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any())).thenReturn(method);
    ClassPool classPool = mock(ClassPool.class);
    when(classPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);

    // Act
    String actualAsStringResult =
        DebugUtil.asString(classPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true);

    // Assert
    verify(classPool).getClass(eq("java/lang/ClassLoader"));
    verify(libraryClass)
        .findMethod(eq("findLoadedClass"), eq("(Ljava/lang/String;)Ljava/lang/Class;"));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    assertEquals("", actualAsStringResult);
  }

  /**
   * Test {@link DebugUtil#asString(ClassPool, MethodSignature, boolean)} with {@code classPool},
   * {@code signature}, {@code verbose}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(ClassPool, MethodSignature, boolean)}
   */
  @Test
  @DisplayName(
      "Test asString(ClassPool, MethodSignature, boolean) with 'classPool', 'signature', 'verbose'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, boolean)"
  })
  void testAsStringWithClassPoolSignatureVerbose_thenThrowIllegalStateException() {
    // Arrange
    ClassPool classPool = mock(ClassPool.class);
    when(classPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "classPool", "classPool"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(
                classPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
    verify(classPool).getClass(eq("java/lang/ClassLoader"));
  }

  /**
   * Test {@link DebugUtil#asString(ClassPool, MethodSignature)} with {@code classPool}, {@code
   * signature}.
   *
   * <ul>
   *   <li>Then calls {@link Member#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(ClassPool, MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test asString(ClassPool, MethodSignature) with 'classPool', 'signature'; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.ClassPool, proguard.classfile.MethodSignature)"
  })
  void testAsStringWithClassPoolSignature_thenCallsAccept() {
    // Arrange
    Method method = mock(Method.class);
    doThrow(new IllegalStateException("foo"))
        .when(method)
        .accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any())).thenReturn(method);
    ClassPool classPool = mock(ClassPool.class);
    when(classPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            DebugUtil.asString(classPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    verify(classPool).getClass(eq("java/lang/ClassLoader"));
    verify(libraryClass)
        .findMethod(eq("findLoadedClass"), eq("(Ljava/lang/String;)Ljava/lang/Class;"));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link DebugUtil#asString(ClassPool, MethodSignature)} with {@code classPool}, {@code
   * signature}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtil#asString(ClassPool, MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test asString(ClassPool, MethodSignature) with 'classPool', 'signature'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.ClassPool, proguard.classfile.MethodSignature)"
  })
  void testAsStringWithClassPoolSignature_thenReturnEmptyString() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1, "Name", "Descriptor"));
    ClassPool classPool = mock(ClassPool.class);
    when(classPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);

    // Act
    String actualAsStringResult =
        DebugUtil.asString(classPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    verify(classPool).getClass(eq("java/lang/ClassLoader"));
    verify(libraryClass)
        .findMethod(eq("findLoadedClass"), eq("(Ljava/lang/String;)Ljava/lang/Class;"));
    assertEquals("", actualAsStringResult);
  }

  /**
   * Test {@link DebugUtil#asString(Clazz, Method)} with {@code clazz}, {@code method}.
   *
   * <p>Method under test: {@link DebugUtil#asString(Clazz, Method)}
   */
  @Test
  @DisplayName("Test asString(Clazz, Method) with 'clazz', 'method'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testAsStringWithClazzMethod() {
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
  @DisplayName(
      "Test asString(Clazz, Method, boolean) with 'clazz', 'method', 'verbose'; when 'false'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.Clazz, proguard.classfile.Method, boolean)"
  })
  void testAsStringWithClazzMethodVerbose_whenFalse_thenReturnEmptyString() {
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
  @DisplayName("Test asString(Clazz) with 'clazz'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.DebugUtil.asString(proguard.classfile.Clazz)"})
  void testAsStringWithClazz_thenReturnAString() {
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
  @DisplayName(
      "Test getMethodFqnList(ClassPool, String); when 'Class Name'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.DebugUtil.getMethodFqnList(proguard.classfile.ClassPool, java.lang.String)"
  })
  void testGetMethodFqnList_whenClassName_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> DebugUtil.getMethodFqnList(KotlinConstants.dummyClassPool, "Class Name"));
  }
}
