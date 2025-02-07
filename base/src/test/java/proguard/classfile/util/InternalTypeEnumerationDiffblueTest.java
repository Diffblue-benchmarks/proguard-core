package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InternalTypeEnumerationDiffblueTest {
  /**
   * Test {@link InternalTypeEnumeration#InternalTypeEnumeration(String)}.
   *
   * <ul>
   *   <li>When {@code Descriptor}.
   *   <li>Then return next is {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTypeEnumeration#InternalTypeEnumeration(String)}
   */
  @Test
  @DisplayName(
      "Test new InternalTypeEnumeration(String); when 'Descriptor'; then return next is 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InternalTypeEnumeration.<init>(java.lang.String)"
  })
  void testNewInternalTypeEnumeration_whenDescriptor_thenReturnNextIsD() {
    // Arrange and Act
    InternalTypeEnumeration actualInternalTypeEnumeration =
        new InternalTypeEnumeration("Descriptor");

    // Assert
    String actualNextResult = actualInternalTypeEnumeration.next();
    String actualNextResult2 = actualInternalTypeEnumeration.next();
    String actualNextResult3 = actualInternalTypeEnumeration.next();
    String actualNextResult4 = actualInternalTypeEnumeration.next();
    String actualNextResult5 = actualInternalTypeEnumeration.next();
    String actualNextResult6 = actualInternalTypeEnumeration.next();
    String actualNextResult7 = actualInternalTypeEnumeration.next();
    String actualNextResult8 = actualInternalTypeEnumeration.next();
    String actualNextResult9 = actualInternalTypeEnumeration.next();
    assertEquals("D", actualNextResult);
    assertEquals("c", actualNextResult4);
    assertEquals("e", actualNextResult2);
    assertEquals("i", actualNextResult6);
    assertEquals("o", actualNextResult9);
    assertEquals("p", actualNextResult7);
    assertEquals("r", actualNextResult5);
    assertEquals("r", actualInternalTypeEnumeration.next());
    assertEquals("s", actualNextResult3);
    assertEquals("t", actualNextResult8);
    assertFalse(actualInternalTypeEnumeration.hasNext());
  }

  /**
   * Test {@link InternalTypeEnumeration#typeCount()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#typeCount()}
   */
  @Test
  @DisplayName("Test typeCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.InternalTypeEnumeration.typeCount()"})
  void testTypeCount() {
    // Arrange, Act and Assert
    assertEquals(10, (new InternalTypeEnumeration("Descriptor")).typeCount());
  }

  /**
   * Test {@link InternalTypeEnumeration#typesSize()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#typesSize()}
   */
  @Test
  @DisplayName("Test typesSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.InternalTypeEnumeration.typesSize()"})
  void testTypesSize() {
    // Arrange, Act and Assert
    assertEquals(11, (new InternalTypeEnumeration("Descriptor")).typesSize());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasFormalTypeParameters()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasFormalTypeParameters()}
   */
  @Test
  @DisplayName("Test hasFormalTypeParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InternalTypeEnumeration.hasFormalTypeParameters()"
  })
  void testHasFormalTypeParameters() {
    // Arrange, Act and Assert
    assertFalse((new InternalTypeEnumeration("Descriptor")).hasFormalTypeParameters());
  }

  /**
   * Test {@link InternalTypeEnumeration#formalTypeParameters()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#formalTypeParameters()}
   */
  @Test
  @DisplayName("Test formalTypeParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.InternalTypeEnumeration.formalTypeParameters()"
  })
  void testFormalTypeParameters() {
    // Arrange, Act and Assert
    assertEquals("", (new InternalTypeEnumeration("Descriptor")).formalTypeParameters());
  }

  /**
   * Test {@link InternalTypeEnumeration#isMethodSignature()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#isMethodSignature()}
   */
  @Test
  @DisplayName("Test isMethodSignature()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.InternalTypeEnumeration.isMethodSignature()"})
  void testIsMethodSignature() {
    // Arrange, Act and Assert
    assertFalse((new InternalTypeEnumeration("Descriptor")).isMethodSignature());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasMoreTypes()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasMoreTypes()}
   */
  @Test
  @DisplayName("Test hasMoreTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.InternalTypeEnumeration.hasMoreTypes()"})
  void testHasMoreTypes() {
    // Arrange, Act and Assert
    assertTrue((new InternalTypeEnumeration("Descriptor")).hasMoreTypes());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasNext()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.InternalTypeEnumeration.hasNext()"})
  void testHasNext() {
    // Arrange, Act and Assert
    assertTrue((new InternalTypeEnumeration("Descriptor")).hasNext());
  }
}
