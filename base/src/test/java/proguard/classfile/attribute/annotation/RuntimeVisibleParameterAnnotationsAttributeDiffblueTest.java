package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class RuntimeVisibleParameterAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute()}
   */
  @Test
  @DisplayName("Test new RuntimeVisibleParameterAnnotationsAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute.<init>(int, int, int[], proguard.classfile.attribute.annotation.Annotation[][])"
  })
  void testNewRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleParameterAnnotationsAttribute actualRuntimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}
   */
  @Test
  @DisplayName(
      "Test new RuntimeVisibleParameterAnnotationsAttribute(int, int, int[], Annotation[][]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute.<init>(int, int, int[], proguard.classfile.attribute.annotation.Annotation[][])"
  })
  void testNewRuntimeVisibleParameterAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeVisibleParameterAnnotationsAttribute actualRuntimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute(
            1, 3, new int[] {3, 1, 3, 1}, new Annotation[][] {new Annotation[] {new Annotation()}});

    // Assert
    assertNull(actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeVisibleParameterAnnotationsAttribute#accept(Clazz, Method,
   * AttributeVisitor)} with {@code clazz}, {@code method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeVisibleParameterAnnotationsAttribute#accept(Clazz, Method,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor() {
    // Arrange
    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleParameterAnnotationsAttribute>any());

    // Act
    runtimeVisibleParameterAnnotationsAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeVisibleParameterAnnotationsAttribute.class));
  }
}
