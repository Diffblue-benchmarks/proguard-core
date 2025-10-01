package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InternalTypeEnumeration.<init>(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InternalTypeEnumeration.typeCount()"})
  void testTypeCount() {
    // Arrange, Act and Assert
    assertEquals(10, new InternalTypeEnumeration("Descriptor").typeCount());
  }

  /**
   * Test {@link InternalTypeEnumeration#typesSize()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#typesSize()}
   */
  @Test
  @DisplayName("Test typesSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InternalTypeEnumeration.typesSize()"})
  void testTypesSize() {
    // Arrange, Act and Assert
    assertEquals(11, new InternalTypeEnumeration("Descriptor").typesSize());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasFormalTypeParameters()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasFormalTypeParameters()}
   */
  @Test
  @DisplayName("Test hasFormalTypeParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InternalTypeEnumeration.hasFormalTypeParameters()"})
  void testHasFormalTypeParameters() {
    // Arrange, Act and Assert
    assertFalse(new InternalTypeEnumeration("Descriptor").hasFormalTypeParameters());
  }

  /**
   * Test {@link InternalTypeEnumeration#formalTypeParameters()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#formalTypeParameters()}
   */
  @Test
  @DisplayName("Test formalTypeParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTypeEnumeration.formalTypeParameters()"})
  void testFormalTypeParameters() {
    // Arrange, Act and Assert
    assertEquals("", new InternalTypeEnumeration("Descriptor").formalTypeParameters());
  }

  /**
   * Test {@link InternalTypeEnumeration#isMethodSignature()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#isMethodSignature()}
   */
  @Test
  @DisplayName("Test isMethodSignature()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InternalTypeEnumeration.isMethodSignature()"})
  void testIsMethodSignature() {
    // Arrange, Act and Assert
    assertFalse(new InternalTypeEnumeration("Descriptor").isMethodSignature());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasMoreTypes()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasMoreTypes()}
   */
  @Test
  @DisplayName("Test hasMoreTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InternalTypeEnumeration.hasMoreTypes()"})
  void testHasMoreTypes() {
    // Arrange, Act and Assert
    assertTrue(new InternalTypeEnumeration("Descriptor").hasMoreTypes());
  }

  /**
   * Test {@link InternalTypeEnumeration#nextType()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#nextType()}
   */
  @Test
  @DisplayName("Test nextType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTypeEnumeration.nextType()"})
  void testNextType() {
    // Arrange
    InternalTypeEnumeration internalTypeEnumeration = new InternalTypeEnumeration("Descriptor");

    // Act and Assert
    assertEquals("D", internalTypeEnumeration.nextType());
    String actualNextResult = internalTypeEnumeration.next();
    String actualNextResult2 = internalTypeEnumeration.next();
    String actualNextResult3 = internalTypeEnumeration.next();
    String actualNextResult4 = internalTypeEnumeration.next();
    String actualNextResult5 = internalTypeEnumeration.next();
    String actualNextResult6 = internalTypeEnumeration.next();
    String actualNextResult7 = internalTypeEnumeration.next();
    String actualNextResult8 = internalTypeEnumeration.next();
    String actualNextResult9 = internalTypeEnumeration.next();
    assertFalse(internalTypeEnumeration.hasNext());
    assertEquals("e", actualNextResult);
    assertEquals("s", actualNextResult2);
    assertEquals("c", actualNextResult3);
    assertEquals("r", actualNextResult4);
    assertEquals("i", actualNextResult5);
    assertEquals("p", actualNextResult6);
    assertEquals("t", actualNextResult7);
    assertEquals("o", actualNextResult8);
    assertEquals("r", actualNextResult9);
  }

  /**
   * Test {@link InternalTypeEnumeration#hasNext()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InternalTypeEnumeration.hasNext()"})
  void testHasNext() {
    // Arrange, Act and Assert
    assertTrue(new InternalTypeEnumeration("Descriptor").hasNext());
  }

  /**
   * Test {@link InternalTypeEnumeration#next()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#next()}
   */
  @Test
  @DisplayName("Test next()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTypeEnumeration.next()"})
  void testNext() {
    // Arrange
    InternalTypeEnumeration internalTypeEnumeration = new InternalTypeEnumeration("Descriptor");

    // Act and Assert
    assertEquals("D", internalTypeEnumeration.next());
    String actualNextResult = internalTypeEnumeration.next();
    String actualNextResult2 = internalTypeEnumeration.next();
    String actualNextResult3 = internalTypeEnumeration.next();
    String actualNextResult4 = internalTypeEnumeration.next();
    String actualNextResult5 = internalTypeEnumeration.next();
    String actualNextResult6 = internalTypeEnumeration.next();
    String actualNextResult7 = internalTypeEnumeration.next();
    String actualNextResult8 = internalTypeEnumeration.next();
    String actualNextResult9 = internalTypeEnumeration.next();
    assertFalse(internalTypeEnumeration.hasNext());
    assertEquals("e", actualNextResult);
    assertEquals("s", actualNextResult2);
    assertEquals("c", actualNextResult3);
    assertEquals("r", actualNextResult4);
    assertEquals("i", actualNextResult5);
    assertEquals("p", actualNextResult6);
    assertEquals("t", actualNextResult7);
    assertEquals("o", actualNextResult8);
    assertEquals("r", actualNextResult9);
  }
}
