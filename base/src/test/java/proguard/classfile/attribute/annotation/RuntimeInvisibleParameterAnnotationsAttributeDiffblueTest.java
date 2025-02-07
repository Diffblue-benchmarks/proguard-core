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

class RuntimeInvisibleParameterAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute()}
   */
  @Test
  @DisplayName("Test new RuntimeInvisibleParameterAnnotationsAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute.<init>(int, int, int[], proguard.classfile.attribute.annotation.Annotation[][])"
  })
  void testNewRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleParameterAnnotationsAttribute
        actualRuntimeInvisibleParameterAnnotationsAttribute =
            new RuntimeInvisibleParameterAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}
   */
  @Test
  @DisplayName(
      "Test new RuntimeInvisibleParameterAnnotationsAttribute(int, int, int[], Annotation[][]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute.<init>(int, int, int[], proguard.classfile.attribute.annotation.Annotation[][])"
  })
  void testNewRuntimeInvisibleParameterAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeInvisibleParameterAnnotationsAttribute
        actualRuntimeInvisibleParameterAnnotationsAttribute =
            new RuntimeInvisibleParameterAnnotationsAttribute(
                1,
                3,
                new int[] {3, 1, 3, 1},
                new Annotation[][] {new Annotation[] {new Annotation()}});

    // Assert
    assertNull(actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeInvisibleParameterAnnotationsAttribute#accept(Clazz, Method,
   * AttributeVisitor)} with {@code clazz}, {@code method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleParameterAnnotationsAttribute#accept(Clazz,
   * Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor() {
    // Arrange
    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleParameterAnnotationsAttribute>any());

    // Act
    runtimeInvisibleParameterAnnotationsAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleParameterAnnotationsAttribute.class));
  }
}
