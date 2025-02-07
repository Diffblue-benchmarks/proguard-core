package proguard.dexfile.reader.visitors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexFieldNode;

class DexFieldVisitorDiffblueTest {
  /**
   * Test {@link DexFieldVisitor#DexFieldVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexFieldVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#DexFieldVisitor()}
   */
  @Test
  @DisplayName("Test new DexFieldVisitor(); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexFieldVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexFieldVisitor.<init>(proguard.dexfile.reader.visitors.DexFieldVisitor)"
  })
  void testNewDexFieldVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor()).visitor);
  }

  /**
   * Test {@link DexFieldVisitor#DexFieldVisitor(DexFieldVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexFieldVisitor#DexFieldVisitor()}.
   *   <li>Then return {@link DexFieldVisitor#visitor} {@link DexFieldVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexFieldVisitor#DexFieldVisitor(DexFieldVisitor)}
   *   <li>{@link DexFieldVisitor#DexFieldVisitor()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test new DexFieldVisitor(DexFieldVisitor); when DexFieldVisitor(); then return visitor visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexFieldVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexFieldVisitor.<init>(proguard.dexfile.reader.visitors.DexFieldVisitor)"
  })
  void testNewDexFieldVisitor_whenDexFieldVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor(new DexFieldVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexFieldVisitor#visitEnd()}.
   *
   * <ul>
   *   <li>Given {@link DexFieldNode} {@link DexFieldVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexFieldVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitEnd()}
   */
  @Test
  @DisplayName("Test visitEnd(); given DexFieldNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexFieldVisitor.visitEnd()"})
  void testVisitEnd_givenDexFieldNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexFieldNode visitor = mock(DexFieldNode.class);
    doNothing().when(visitor).visitEnd();

    // Act
    (new DexFieldVisitor(visitor)).visitEnd();

    // Assert
    verify(visitor).visitEnd();
  }

  /**
   * Test {@link DexFieldVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexFieldVisitor#DexFieldVisitor(DexFieldVisitor)} with visitor is {@link
   *       DexFieldVisitor#DexFieldVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexFieldVisitor(DexFieldVisitor) with visitor is DexFieldVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexFieldVisitor.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_givenDexFieldVisitorWithVisitorIsDexFieldVisitor() {
    // Arrange, Act and Assert
    assertNull(
        (new DexFieldVisitor(new DexFieldVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexFieldVisitor#DexFieldVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexFieldVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexFieldVisitor.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_givenDexFieldVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor()).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility); then return DexAnnotationNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexFieldVisitor.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexFieldNode visitor = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    DexFieldVisitor dexFieldVisitor = new DexFieldVisitor(visitor);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexFieldVisitor.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexFieldVisitor dexFieldVisitor2 = dexFieldVisitor.visitor;
    assertTrue(dexFieldVisitor2 instanceof DexFieldNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertNull(((DexAnnotationNode) actualVisitAnnotationResult).visitor);
    List<DexAnnotationNode> dexAnnotationNodeList = ((DexFieldNode) dexFieldVisitor2).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(visitor.anns, dexAnnotationNodeList);
  }
}
