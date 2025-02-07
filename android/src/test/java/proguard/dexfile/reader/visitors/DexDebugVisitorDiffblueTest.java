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
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexDebugNode;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.Epiogue;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.Prologue;

class DexDebugVisitorDiffblueTest {
  /**
   * Test {@link DexDebugVisitor#DexDebugVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexDebugVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugVisitor#DexDebugVisitor()}
   */
  @Test
  @DisplayName("Test new DexDebugVisitor(); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.<init>(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testNewDexDebugVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexDebugVisitor()).visitor);
  }

  /**
   * Test {@link DexDebugVisitor#DexDebugVisitor(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexDebugVisitor#DexDebugVisitor()}.
   *   <li>Then return {@link DexDebugVisitor#visitor} {@link DexDebugVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexDebugVisitor#DexDebugVisitor(DexDebugVisitor)}
   *   <li>{@link DexDebugVisitor#DexDebugVisitor()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test new DexDebugVisitor(DexDebugVisitor); when DexDebugVisitor(); then return visitor visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.<init>(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testNewDexDebugVisitor_whenDexDebugVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexDebugVisitor(new DexDebugVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexDebugVisitor#visitParameterName(int, String)}.
   *
   * <p>Method under test: {@link DexDebugVisitor#visitParameterName(int, String)}
   */
  @Test
  @DisplayName("Test visitParameterName(int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitParameterName(int, java.lang.String)"
  })
  void testVisitParameterName() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitParameterName(1, "Name");

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.parameterNames, ((DexDebugNode) dexDebugVisitor2).parameterNames);
  }

  /**
   * Test {@link DexDebugVisitor#visitStartLocal(int, DexLabel, String, String, String)}.
   *
   * <p>Method under test: {@link DexDebugVisitor#visitStartLocal(int, DexLabel, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test visitStartLocal(int, DexLabel, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitStartLocal(int, proguard.dexfile.reader.DexLabel, java.lang.String, java.lang.String, java.lang.String)"
  })
  void testVisitStartLocal() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitStartLocal(1, new DexLabel(), "Name", "Type", "Signature");

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Test {@link DexDebugVisitor#visitLineNumber(int, DexLabel)}.
   *
   * <p>Method under test: {@link DexDebugVisitor#visitLineNumber(int, DexLabel)}
   */
  @Test
  @DisplayName("Test visitLineNumber(int, DexLabel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitLineNumber(int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitLineNumber() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitLineNumber(2, new DexLabel());

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Test {@link DexDebugVisitor#visitEndLocal(int, DexLabel)}.
   *
   * <p>Method under test: {@link DexDebugVisitor#visitEndLocal(int, DexLabel)}
   */
  @Test
  @DisplayName("Test visitEndLocal(int, DexLabel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitEndLocal(int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitEndLocal() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitEndLocal(1, new DexLabel());

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Test {@link DexDebugVisitor#visitSetFile(String)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugVisitor#DexDebugVisitor(DexDebugVisitor)} with visitor is {@link
   *       DexDebugNode} (default constructor) {@link DexDebugVisitor#visitor} {@link DexDebugNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugVisitor#visitSetFile(String)}
   */
  @Test
  @DisplayName(
      "Test visitSetFile(String); then DexDebugVisitor(DexDebugVisitor) with visitor is DexDebugNode (default constructor) visitor DexDebugNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitSetFile(java.lang.String)"
  })
  void testVisitSetFile_thenDexDebugVisitorWithVisitorIsDexDebugNodeVisitorDexDebugNode() {
    // Arrange
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(new DexDebugNode());

    // Act
    dexDebugVisitor.visitSetFile("File");

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertEquals("File", ((DexDebugNode) dexDebugVisitor2).fineName);
  }

  /**
   * Test {@link DexDebugVisitor#visitPrologue(DexLabel)}.
   *
   * <p>Method under test: {@link DexDebugVisitor#visitPrologue(DexLabel)}
   */
  @Test
  @DisplayName("Test visitPrologue(DexLabel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitPrologue(proguard.dexfile.reader.DexLabel)"
  })
  void testVisitPrologue() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugVisitor.visitPrologue(dexLabel);

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    List<DexDebugOpNode> dexDebugOpNodeList = ((DexDebugNode) dexDebugVisitor2).debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Prologue);
    assertSame(dexLabel, ((Prologue) getResult).label);
    assertSame(visitor.debugNodes, dexDebugOpNodeList);
  }

  /**
   * Test {@link DexDebugVisitor#visitEpiogue(DexLabel)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugVisitor#DexDebugVisitor(DexDebugVisitor)} with visitor is {@link
   *       DexDebugNode} (default constructor) {@link DexDebugVisitor#visitor} {@link DexDebugNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugVisitor#visitEpiogue(DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitEpiogue(DexLabel); then DexDebugVisitor(DexDebugVisitor) with visitor is DexDebugNode (default constructor) visitor DexDebugNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitEpiogue(proguard.dexfile.reader.DexLabel)"
  })
  void testVisitEpiogue_thenDexDebugVisitorWithVisitorIsDexDebugNodeVisitorDexDebugNode() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugVisitor.visitEpiogue(dexLabel);

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    List<DexDebugOpNode> dexDebugOpNodeList = ((DexDebugNode) dexDebugVisitor2).debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    assertSame(dexLabel, ((Epiogue) getResult).label);
    assertSame(visitor.debugNodes, dexDebugOpNodeList);
  }

  /**
   * Test {@link DexDebugVisitor#visitRestartLocal(int, DexLabel)}.
   *
   * <p>Method under test: {@link DexDebugVisitor#visitRestartLocal(int, DexLabel)}
   */
  @Test
  @DisplayName("Test visitRestartLocal(int, DexLabel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexDebugVisitor.visitRestartLocal(int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitRestartLocal() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitRestartLocal(1, new DexLabel());

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Test {@link DexDebugVisitor#visitEnd()}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} {@link DexDebugVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexDebugVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugVisitor#visitEnd()}
   */
  @Test
  @DisplayName("Test visitEnd(); given DexDebugNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexDebugVisitor.visitEnd()"})
  void testVisitEnd_givenDexDebugNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexDebugNode visitor = mock(DexDebugNode.class);
    doNothing().when(visitor).visitEnd();

    // Act
    (new DexDebugVisitor(visitor)).visitEnd();

    // Assert
    verify(visitor).visitEnd();
  }
}
