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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexMethodNode;

class DexMethodVisitorDiffblueTest {
  /**
   * Test {@link DexMethodVisitor#DexMethodVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexMethodVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#DexMethodVisitor()}
   */
  @Test
  @DisplayName("Test new DexMethodVisitor(); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexMethodVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexMethodVisitor.<init>(proguard.dexfile.reader.visitors.DexMethodVisitor)"
  })
  void testNewDexMethodVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitor);
  }

  /**
   * Test {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexMethodVisitor#DexMethodVisitor()}.
   *   <li>Then return {@link DexMethodVisitor#visitor} {@link DexMethodVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)}
   *   <li>{@link DexMethodVisitor#DexMethodVisitor()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test new DexMethodVisitor(DexMethodVisitor); when DexMethodVisitor(); then return visitor visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexMethodVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexMethodVisitor.<init>(proguard.dexfile.reader.visitors.DexMethodVisitor)"
  })
  void testNewDexMethodVisitor_whenDexMethodVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexMethodVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)} with mv is {@link
   *       DexMethodVisitor#DexMethodVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexMethodVisitor(DexMethodVisitor) with mv is DexMethodVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexMethodVisitor.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_givenDexMethodVisitorWithMvIsDexMethodVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexMethodVisitor(new DexMethodVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexMethodVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexMethodVisitor.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_givenDexMethodVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility); then return DexAnnotationNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.visitors.DexMethodVisitor.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexMethodNode mv =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    DexMethodVisitor dexMethodVisitor = new DexMethodVisitor(mv);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodVisitor.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexMethodVisitor dexMethodVisitor2 = dexMethodVisitor.visitor;
    assertTrue(dexMethodVisitor2 instanceof DexMethodNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertNull(((DexAnnotationNode) actualVisitAnnotationResult).visitor);
    List<DexAnnotationNode> dexAnnotationNodeList = ((DexMethodNode) dexMethodVisitor2).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(mv.anns, dexAnnotationNodeList);
  }

  /**
   * Test {@link DexMethodVisitor#visitCode()}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitCode()}
   */
  @Test
  @DisplayName("Test visitCode(); given DexMethodVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor proguard.dexfile.reader.visitors.DexMethodVisitor.visitCode()"
  })
  void testVisitCode_givenDexMethodVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitCode());
  }

  /**
   * Test {@link DexMethodVisitor#visitCode()}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)} with mv is {@link
   *       DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitCode()}
   */
  @Test
  @DisplayName(
      "Test visitCode(); given DexMethodVisitor(DexMethodVisitor) with mv is DexMethodVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor proguard.dexfile.reader.visitors.DexMethodVisitor.visitCode()"
  })
  void testVisitCode_givenDexMethodVisitorWithMvIsDexMethodVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitCode());
  }

  /**
   * Test {@link DexMethodVisitor#visitEnd()}.
   *
   * <ul>
   *   <li>Given {@link DexMethodNode} {@link DexMethodVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexMethodVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitEnd()}
   */
  @Test
  @DisplayName(
      "Test visitEnd(); given DexMethodNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexMethodVisitor.visitEnd()"})
  void testVisitEnd_givenDexMethodNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexMethodNode mv = mock(DexMethodNode.class);
    doNothing().when(mv).visitEnd();

    // Act
    (new DexMethodVisitor(mv)).visitEnd();

    // Assert
    verify(mv).visitEnd();
  }
}
