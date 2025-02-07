package proguard.dexfile.reader.visitors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.node.DexClassNode;
import proguard.dexfile.reader.node.DexFileNode;

class DexFileVisitorDiffblueTest {
  /**
   * Test {@link DexFileVisitor#DexFileVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexFileVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#DexFileVisitor()}
   */
  @Test
  @DisplayName("Test new DexFileVisitor(); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexFileVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexFileVisitor.<init>(proguard.dexfile.reader.visitors.DexFileVisitor)"
  })
  void testNewDexFileVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFileVisitor()).visitor);
  }

  /**
   * Test {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then return {@link DexFileVisitor#visitor} {@link DexFileVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexFileVisitor#DexFileVisitor(DexFileVisitor)}
   *   <li>{@link DexFileVisitor#DexFileVisitor()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test new DexFileVisitor(DexFileVisitor); when DexFileVisitor(); then return visitor visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexFileVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexFileVisitor.<init>(proguard.dexfile.reader.visitors.DexFileVisitor)"
  })
  void testNewDexFileVisitor_whenDexFileVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFileVisitor(new DexFileVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexFileVisitor#visitDexFileVersion(int)}.
   *
   * <ul>
   *   <li>Then calls {@link DexFileNode#visitDexFileVersion(int)}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visitDexFileVersion(int)}
   */
  @Test
  @DisplayName("Test visitDexFileVersion(int); then calls visitDexFileVersion(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexFileVisitor.visitDexFileVersion(int)"
  })
  void testVisitDexFileVersion_thenCallsVisitDexFileVersion() {
    // Arrange
    DexFileNode visitor = mock(DexFileNode.class);
    doNothing().when(visitor).visitDexFileVersion(anyInt());

    // Act
    (new DexFileVisitor(visitor)).visitDexFileVersion(1);

    // Assert
    verify(visitor).visitDexFileVersion(eq(1));
  }

  /**
   * Test {@link DexFileVisitor#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)} with visitor is {@link
   *       DexFileNode} (default constructor).
   *   <li>Then return {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test visit(int, String, String, String[]); given DexFileVisitor(DexFileVisitor) with visitor is DexFileNode (default constructor); then return DexClassNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexClassVisitor proguard.dexfile.reader.visitors.DexFileVisitor.visit(int, java.lang.String, java.lang.String, java.lang.String[])"
  })
  void testVisit_givenDexFileVisitorWithVisitorIsDexFileNode_thenReturnDexClassNode() {
    // Arrange and Act
    DexClassVisitor actualVisitResult =
        (new DexFileVisitor(new DexFileNode()))
            .visit(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Assert
    assertTrue(actualVisitResult instanceof DexClassNode);
    assertEquals("Class Name", ((DexClassNode) actualVisitResult).className);
    assertEquals("Super Class", ((DexClassNode) actualVisitResult).superClass);
    assertNull(((DexClassNode) actualVisitResult).source);
    assertNull(((DexClassNode) actualVisitResult).anns);
    assertNull(((DexClassNode) actualVisitResult).fields);
    assertNull(((DexClassNode) actualVisitResult).methods);
    assertNull(((DexClassNode) actualVisitResult).visitor);
    assertEquals(1, ((DexClassNode) actualVisitResult).interfaceNames.length);
    assertEquals(1, ((DexClassNode) actualVisitResult).access);
  }

  /**
   * Test {@link DexFileVisitor#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)} with visitor is {@link
   *       DexFileVisitor#DexFileVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test visit(int, String, String, String[]); given DexFileVisitor(DexFileVisitor) with visitor is DexFileVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexClassVisitor proguard.dexfile.reader.visitors.DexFileVisitor.visit(int, java.lang.String, java.lang.String, java.lang.String[])"
  })
  void testVisit_givenDexFileVisitorWithVisitorIsDexFileVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexFileVisitor(new DexFileVisitor()))
            .visit(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
  }

  /**
   * Test {@link DexFileVisitor#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test visit(int, String, String, String[]); given DexFileVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexClassVisitor proguard.dexfile.reader.visitors.DexFileVisitor.visit(int, java.lang.String, java.lang.String, java.lang.String[])"
  })
  void testVisit_givenDexFileVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexFileVisitor())
            .visit(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
  }

  /**
   * Test {@link DexFileVisitor#visitEnd()}.
   *
   * <ul>
   *   <li>Given {@link DexFileNode} {@link DexFileVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexFileVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visitEnd()}
   */
  @Test
  @DisplayName("Test visitEnd(); given DexFileNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexFileVisitor.visitEnd()"})
  void testVisitEnd_givenDexFileNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexFileNode visitor = mock(DexFileNode.class);
    doNothing().when(visitor).visitEnd();

    // Act
    (new DexFileVisitor(visitor)).visitEnd();

    // Assert
    verify(visitor).visitEnd();
  }
}
