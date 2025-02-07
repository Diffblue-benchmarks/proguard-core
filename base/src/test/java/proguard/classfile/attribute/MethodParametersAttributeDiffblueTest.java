package proguard.classfile.attribute;

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

class MethodParametersAttributeDiffblueTest {
  /**
   * Test {@link MethodParametersAttribute#MethodParametersAttribute()}.
   *
   * <p>Method under test: {@link MethodParametersAttribute#MethodParametersAttribute()}
   */
  @Test
  @DisplayName("Test new MethodParametersAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.MethodParametersAttribute.<init>()",
    "void proguard.classfile.attribute.MethodParametersAttribute.<init>(int, int, proguard.classfile.attribute.ParameterInfo[])"
  })
  void testNewMethodParametersAttribute() {
    // Arrange and Act
    MethodParametersAttribute actualMethodParametersAttribute = new MethodParametersAttribute();

    // Assert
    assertNull(actualMethodParametersAttribute.getProcessingInfo());
    assertEquals(0, actualMethodParametersAttribute.getProcessingFlags());
  }

  /**
   * Test {@link MethodParametersAttribute#MethodParametersAttribute(int, int, ParameterInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link MethodParametersAttribute#MethodParametersAttribute(int, int,
   * ParameterInfo[])}
   */
  @Test
  @DisplayName("Test new MethodParametersAttribute(int, int, ParameterInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.MethodParametersAttribute.<init>()",
    "void proguard.classfile.attribute.MethodParametersAttribute.<init>(int, int, proguard.classfile.attribute.ParameterInfo[])"
  })
  void testNewMethodParametersAttribute_whenOne() {
    // Arrange and Act
    MethodParametersAttribute actualMethodParametersAttribute =
        new MethodParametersAttribute(1, 3, new ParameterInfo[] {new ParameterInfo(1, 1)});

    // Assert
    assertNull(actualMethodParametersAttribute.getProcessingInfo());
    assertEquals(0, actualMethodParametersAttribute.getProcessingFlags());
  }

  /**
   * Test {@link MethodParametersAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code
   * clazz}, {@code method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link MethodParametersAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.MethodParametersAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor() {
    // Arrange
    MethodParametersAttribute methodParametersAttribute = new MethodParametersAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitMethodParametersAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<MethodParametersAttribute>any());

    // Act
    methodParametersAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitMethodParametersAttribute(
            isA(Clazz.class), isA(Method.class), isA(MethodParametersAttribute.class));
  }
}
