package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.visitor.ClassVisitor;

class LocalVariableTypeInfoDiffblueTest {
  /**
   * Test {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTypeInfo.<init>()",
    "void proguard.classfile.attribute.LocalVariableTypeInfo.<init>(int, int, int, int, int)"
  })
  void testNewLocalVariableTypeInfo() {
    // Arrange and Act
    LocalVariableTypeInfo actualLocalVariableTypeInfo = new LocalVariableTypeInfo();

    // Assert
    assertNull(actualLocalVariableTypeInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeInfo#LocalVariableTypeInfo(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#LocalVariableTypeInfo(int, int, int, int,
   * int)}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeInfo(int, int, int, int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTypeInfo.<init>()",
    "void proguard.classfile.attribute.LocalVariableTypeInfo.<init>(int, int, int, int, int)"
  })
  void testNewLocalVariableTypeInfo_whenOne() {
    // Arrange and Act
    LocalVariableTypeInfo actualLocalVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Assert
    assertNull(actualLocalVariableTypeInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeInfo#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LocalVariableTypeInfo.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = localVariableTypeInfo.getName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link LocalVariableTypeInfo#getSignature(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#getSignature(Clazz)}
   */
  @Test
  @DisplayName("Test getSignature(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LocalVariableTypeInfo.getSignature(proguard.classfile.Clazz)"
  })
  void testGetSignature_givenString_thenReturnString() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualSignature = localVariableTypeInfo.getSignature(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualSignature);
  }

  /**
   * Test {@link LocalVariableTypeInfo#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTypeInfo.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    localVariableTypeInfo.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    localVariableTypeInfo.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 1, 1, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo2() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 3, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo3() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 0, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo4() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 3, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo5() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 0, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo6() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 3);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo7() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 0);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo8() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 1, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Given {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object); given LocalVariableTypeInfo(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo_givenLocalVariableTypeInfo_thenReturnMinusOne() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo();

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo_thenReturnZero() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(0, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object); when LocalVariableTypeInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableTypeInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo_whenLocalVariableTypeInfo() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo()));
  }
}
