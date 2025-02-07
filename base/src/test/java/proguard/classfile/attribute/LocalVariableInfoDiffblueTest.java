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

class LocalVariableInfoDiffblueTest {
  /**
   * Test {@link LocalVariableInfo#LocalVariableInfo()}.
   *
   * <p>Method under test: {@link LocalVariableInfo#LocalVariableInfo()}
   */
  @Test
  @DisplayName("Test new LocalVariableInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableInfo.<init>()",
    "void proguard.classfile.attribute.LocalVariableInfo.<init>(int, int, int, int, int)"
  })
  void testNewLocalVariableInfo() {
    // Arrange and Act
    LocalVariableInfo actualLocalVariableInfo = new LocalVariableInfo();

    // Assert
    assertNull(actualLocalVariableInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableInfo#LocalVariableInfo(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#LocalVariableInfo(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new LocalVariableInfo(int, int, int, int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableInfo.<init>()",
    "void proguard.classfile.attribute.LocalVariableInfo.<init>(int, int, int, int, int)"
  })
  void testNewLocalVariableInfo_whenOne() {
    // Arrange and Act
    LocalVariableInfo actualLocalVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Assert
    assertNull(actualLocalVariableInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableInfo#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LocalVariableInfo.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = localVariableInfo.getName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link LocalVariableInfo#getDescriptor(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#getDescriptor(Clazz)}
   */
  @Test
  @DisplayName("Test getDescriptor(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LocalVariableInfo.getDescriptor(proguard.classfile.Clazz)"
  })
  void testGetDescriptor_givenString_thenReturnString() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualDescriptor = localVariableInfo.getDescriptor(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualDescriptor);
  }

  /**
   * Test {@link LocalVariableInfo#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableInfo.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);
    localVariableInfo.referencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    localVariableInfo.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 1, 1, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo2() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 3, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo3() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 0, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo4() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 3, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo5() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 0, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo6() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 3);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo7() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 0);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo8() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 1, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Given {@link LocalVariableInfo#LocalVariableInfo()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object); given LocalVariableInfo(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo_givenLocalVariableInfo_thenReturnMinusOne() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo();

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo_thenReturnZero() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(0, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalVariableInfo#LocalVariableInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @DisplayName("Test compareTo(Object); when LocalVariableInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LocalVariableInfo.compareTo(java.lang.Object)"
  })
  void testCompareTo_whenLocalVariableInfo() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo()));
  }
}
