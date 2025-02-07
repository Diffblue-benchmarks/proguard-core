package proguard.dexfile.reader.visitors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexAnnotationNode.Item;

class DexAnnotationVisitorDiffblueTest {
  /**
   * Test {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationVisitor#DexAnnotationVisitor()}
   */
  @Test
  @DisplayName("Test new DexAnnotationVisitor(); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexAnnotationVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexAnnotationVisitor.<init>(proguard.dexfile.reader.visitors.DexAnnotationVisitor)"
  })
  void testNewDexAnnotationVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexAnnotationVisitor()).visitor);
  }

  /**
   * Test {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationVisitor#visitor} {@link DexAnnotationVisitor#visitor} is
   *       {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)}
   *   <li>{@link DexAnnotationVisitor#DexAnnotationVisitor()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test new DexAnnotationVisitor(DexAnnotationVisitor); then return visitor visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexAnnotationVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexAnnotationVisitor.<init>(proguard.dexfile.reader.visitors.DexAnnotationVisitor)"
  })
  void testNewDexAnnotationVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexAnnotationVisitor(new DexAnnotationVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexAnnotationVisitor#visit(String, Object)}.
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visit(String, Object)}
   */
  @Test
  @DisplayName("Test visit(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexAnnotationVisitor.visit(java.lang.String, java.lang.Object)"
  })
  void testVisit() {
    // Arrange
    DexAnnotationNode visitor = new DexAnnotationNode("Type", Visibility.BUILD);

    DexAnnotationVisitor dexAnnotationVisitor = new DexAnnotationVisitor(visitor);

    // Act
    dexAnnotationVisitor.visit("Name", Constant.Null);

    // Assert
    DexAnnotationVisitor dexAnnotationVisitor2 = dexAnnotationVisitor.visitor;
    assertTrue(dexAnnotationVisitor2 instanceof DexAnnotationNode);
    assertSame(visitor.items, ((DexAnnotationNode) dexAnnotationVisitor2).items);
  }

  /**
   * Test {@link DexAnnotationVisitor#visitEnum(String, String, String)}.
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitEnum(String, String, String)}
   */
  @Test
  @DisplayName("Test visitEnum(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitEnum(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testVisitEnum() {
    // Arrange
    DexAnnotationNode visitor = new DexAnnotationNode("Type", Visibility.BUILD);

    DexAnnotationVisitor dexAnnotationVisitor = new DexAnnotationVisitor(visitor);

    // Act
    dexAnnotationVisitor.visitEnum("Name", "The characteristics of someone or something", "42");

    // Assert
    DexAnnotationVisitor dexAnnotationVisitor2 = dexAnnotationVisitor.visitor;
    assertTrue(dexAnnotationVisitor2 instanceof DexAnnotationNode);
    assertSame(visitor.items, ((DexAnnotationNode) dexAnnotationVisitor2).items);
  }

  /**
   * Test {@link DexAnnotationVisitor#visitAnnotation(String, String)}.
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitAnnotation(String, String)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitAnnotation(java.lang.String, java.lang.String)"
  })
  void testVisitAnnotation() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexAnnotationNode.visitAnnotation("Name", "The characteristics of someone or something");

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    assertEquals("Name", itemList.get(0).name);
    assertEquals(
        "The characteristics of someone or something",
        ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(Visibility.RUNTIME, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexAnnotationVisitor#visitAnnotation(String, String)}.
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitAnnotation(String, String)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitAnnotation(java.lang.String, java.lang.String)"
  })
  void testVisitAnnotation2() {
    // Arrange
    DexAnnotationNode visitor = new DexAnnotationNode("Type", Visibility.BUILD);

    DexAnnotationVisitor dexAnnotationVisitor = new DexAnnotationVisitor(visitor);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexAnnotationVisitor.visitAnnotation("Name", "The characteristics of someone or something");

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexAnnotationVisitor dexAnnotationVisitor2 = dexAnnotationVisitor.visitor;
    assertTrue(dexAnnotationVisitor2 instanceof DexAnnotationNode);
    List<Item> itemList = ((DexAnnotationNode) dexAnnotationVisitor2).items;
    assertEquals(1, itemList.size());
    assertEquals("Name", itemList.get(0).name);
    assertEquals(
        "The characteristics of someone or something",
        ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(Visibility.RUNTIME, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(visitor.items, itemList);
  }

  /**
   * Test {@link DexAnnotationVisitor#visitAnnotation(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)} with
   *       visitor is {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitAnnotation(String, String)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, String); given DexAnnotationVisitor(DexAnnotationVisitor) with visitor is DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitAnnotation(java.lang.String, java.lang.String)"
  })
  void testVisitAnnotation_givenDexAnnotationVisitorWithVisitorIsDexAnnotationVisitor() {
    // Arrange, Act and Assert
    assertNull(
        (new DexAnnotationVisitor(new DexAnnotationVisitor()))
            .visitAnnotation("Name", "The characteristics of someone or something"));
  }

  /**
   * Test {@link DexAnnotationVisitor#visitAnnotation(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitAnnotation(String, String)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, String); given DexAnnotationVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitAnnotation(java.lang.String, java.lang.String)"
  })
  void testVisitAnnotation_givenDexAnnotationVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexAnnotationVisitor())
            .visitAnnotation("Name", "The characteristics of someone or something"));
  }

  /**
   * Test {@link DexAnnotationVisitor#visitAnnotation(String, String)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitAnnotation(String, String)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, String); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitAnnotation(java.lang.String, java.lang.String)"
  })
  void testVisitAnnotation_thenReturnVisitorIsNull() {
    // Arrange
    DexAnnotationNode visitor = mock(DexAnnotationNode.class);
    DexAnnotationVisitor dexAnnotationVisitor = new DexAnnotationVisitor();
    when(visitor.visitAnnotation(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(dexAnnotationVisitor);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        (new DexAnnotationVisitor(visitor))
            .visitAnnotation("Name", "The characteristics of someone or something");

    // Assert
    verify(visitor).visitAnnotation(eq("Name"), eq("The characteristics of someone or something"));
    assertNull(actualVisitAnnotationResult.visitor);
    assertSame(dexAnnotationVisitor, actualVisitAnnotationResult);
  }

  /**
   * Test {@link DexAnnotationVisitor#visitEnd()}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationNode} {@link DexAnnotationVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexAnnotationVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitEnd()}
   */
  @Test
  @DisplayName(
      "Test visitEnd(); given DexAnnotationNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexAnnotationVisitor.visitEnd()"})
  void testVisitEnd_givenDexAnnotationNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexAnnotationNode visitor = mock(DexAnnotationNode.class);
    doNothing().when(visitor).visitEnd();

    // Act
    (new DexAnnotationVisitor(visitor)).visitEnd();

    // Assert
    verify(visitor).visitEnd();
  }
}
