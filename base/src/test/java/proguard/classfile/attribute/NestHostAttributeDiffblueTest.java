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
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class NestHostAttributeDiffblueTest {
  /**
   * Test {@link NestHostAttribute#NestHostAttribute()}.
   *
   * <p>Method under test: {@link NestHostAttribute#NestHostAttribute()}
   */
  @Test
  @DisplayName("Test new NestHostAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.NestHostAttribute.<init>()",
    "void proguard.classfile.attribute.NestHostAttribute.<init>(int, int)"
  })
  void testNewNestHostAttribute() {
    // Arrange and Act
    NestHostAttribute actualNestHostAttribute = new NestHostAttribute();

    // Assert
    assertNull(actualNestHostAttribute.getProcessingInfo());
    assertEquals(0, actualNestHostAttribute.getProcessingFlags());
  }

  /**
   * Test {@link NestHostAttribute#NestHostAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link NestHostAttribute#NestHostAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new NestHostAttribute(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.NestHostAttribute.<init>()",
    "void proguard.classfile.attribute.NestHostAttribute.<init>(int, int)"
  })
  void testNewNestHostAttribute_whenOne() {
    // Arrange and Act
    NestHostAttribute actualNestHostAttribute = new NestHostAttribute(1, 1);

    // Assert
    assertNull(actualNestHostAttribute.getProcessingInfo());
    assertEquals(0, actualNestHostAttribute.getProcessingFlags());
  }

  /**
   * Test {@link NestHostAttribute#getHostClassName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostAttribute#getHostClassName(Clazz)}
   */
  @Test
  @DisplayName("Test getHostClassName(Clazz); given 'Class Name'; then return 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.NestHostAttribute.getHostClassName(proguard.classfile.Clazz)"
  })
  void testGetHostClassName_givenClassName_thenReturnClassName() {
    // Arrange
    NestHostAttribute nestHostAttribute = new NestHostAttribute(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    String actualHostClassName = nestHostAttribute.getHostClassName(clazz);

    // Assert
    verify(clazz).getClassName(eq(1));
    assertEquals("Class Name", actualHostClassName);
  }

  /**
   * Test {@link NestHostAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.NestHostAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitNestHostAttribute() {
    // Arrange
    NestHostAttribute nestHostAttribute = new NestHostAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitNestHostAttribute(Mockito.<Clazz>any(), Mockito.<NestHostAttribute>any());

    // Act
    nestHostAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor).visitNestHostAttribute(isA(Clazz.class), isA(NestHostAttribute.class));
  }
}
