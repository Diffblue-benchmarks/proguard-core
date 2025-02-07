package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.EndLocal;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.Epiogue;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.LineNumber;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.Prologue;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.RestartLocal;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.StartLocalNode;
import proguard.dexfile.reader.visitors.DexDebugVisitor;

class DexDebugNodeDiffblueTest {
  /**
   * Test {@link DexDebugNode#addDebug(DexDebugOpNode)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#addDebug(DexDebugOpNode)}
   */
  @Test
  @DisplayName(
      "Test addDebug(DexDebugOpNode); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.addDebug(proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode)"
  })
  void testAddDebug_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());

    // Act
    dexDebugNode.addDebug(dexDebugNode2);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test DexDebugOpNode_EndLocal {@link DexDebugOpNode.EndLocal#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.EndLocal#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_EndLocal accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$EndLocal.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testDexDebugOpNode_EndLocalAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    EndLocal endLocal = new EndLocal(new DexLabel(), 1);
    DexDebugNode cv = new DexDebugNode();

    // Act
    endLocal.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof EndLocal);
    assertEquals(1, ((EndLocal) getResult).reg);
    assertSame(endLocal.label, ((EndLocal) getResult).label);
  }

  /**
   * Test DexDebugOpNode_EndLocal {@link DexDebugOpNode.EndLocal#EndLocal(DexLabel, int)}.
   *
   * <p>Method under test: {@link DexDebugOpNode.EndLocal#EndLocal(DexLabel, int)}
   */
  @Test
  @DisplayName("Test DexDebugOpNode_EndLocal new EndLocal(DexLabel, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$EndLocal.<init>(proguard.dexfile.reader.DexLabel, int)"
  })
  void testDexDebugOpNode_EndLocalNewEndLocal() {
    // Arrange, Act and Assert
    assertEquals(1, (new EndLocal(new DexLabel(), 1)).reg);
  }

  /**
   * Test DexDebugOpNode_Epiogue {@link DexDebugOpNode.Epiogue#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.Epiogue#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_Epiogue accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$Epiogue.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testDexDebugOpNode_EpiogueAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    Epiogue epiogue = new Epiogue(new DexLabel());
    DexDebugNode cv = new DexDebugNode();

    // Act
    epiogue.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    assertSame(epiogue.label, ((Epiogue) getResult).label);
  }

  /**
   * Test DexDebugOpNode_LineNumber {@link DexDebugOpNode.LineNumber#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.LineNumber#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_LineNumber accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$LineNumber.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testDexDebugOpNode_LineNumberAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    LineNumber lineNumber = new LineNumber(new DexLabel(), 2);
    DexDebugNode cv = new DexDebugNode();

    // Act
    lineNumber.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof LineNumber);
    assertEquals(2, ((LineNumber) getResult).line);
    assertSame(lineNumber.label, ((LineNumber) getResult).label);
  }

  /**
   * Test DexDebugOpNode_LineNumber {@link DexDebugOpNode.LineNumber#LineNumber(DexLabel, int)}.
   *
   * <p>Method under test: {@link DexDebugOpNode.LineNumber#LineNumber(DexLabel, int)}
   */
  @Test
  @DisplayName("Test DexDebugOpNode_LineNumber new LineNumber(DexLabel, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$LineNumber.<init>(proguard.dexfile.reader.DexLabel, int)"
  })
  void testDexDebugOpNode_LineNumberNewLineNumber() {
    // Arrange, Act and Assert
    assertEquals(2, (new LineNumber(new DexLabel(), 2)).line);
  }

  /**
   * Test DexDebugOpNode_Prologue {@link DexDebugOpNode.Prologue#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.Prologue#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_Prologue accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$Prologue.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testDexDebugOpNode_PrologueAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    Prologue prologue = new Prologue(new DexLabel());
    DexDebugNode cv = new DexDebugNode();

    // Act
    prologue.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Prologue);
    assertSame(prologue.label, ((Prologue) getResult).label);
  }

  /**
   * Test DexDebugOpNode_RestartLocal {@link DexDebugOpNode.RestartLocal#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.RestartLocal#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_RestartLocal accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$RestartLocal.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testDexDebugOpNode_RestartLocalAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    RestartLocal restartLocal = new RestartLocal(new DexLabel(), 1);
    DexDebugNode cv = new DexDebugNode();

    // Act
    restartLocal.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof RestartLocal);
    assertEquals(1, ((RestartLocal) getResult).reg);
    assertSame(restartLocal.label, ((RestartLocal) getResult).label);
  }

  /**
   * Test DexDebugOpNode_RestartLocal {@link DexDebugOpNode.RestartLocal#RestartLocal(DexLabel,
   * int)}.
   *
   * <p>Method under test: {@link DexDebugOpNode.RestartLocal#RestartLocal(DexLabel, int)}
   */
  @Test
  @DisplayName("Test DexDebugOpNode_RestartLocal new RestartLocal(DexLabel, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$RestartLocal.<init>(proguard.dexfile.reader.DexLabel, int)"
  })
  void testDexDebugOpNode_RestartLocalNewRestartLocal() {
    // Arrange, Act and Assert
    assertEquals(1, (new RestartLocal(new DexLabel(), 1)).reg);
  }

  /**
   * Test DexDebugOpNode_StartLocalNode {@link StartLocalNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link StartLocalNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_StartLocalNode accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$StartLocalNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testDexDebugOpNode_StartLocalNodeAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    StartLocalNode startLocalNode =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");
    DexDebugNode cv = new DexDebugNode();

    // Act
    startLocalNode.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof StartLocalNode);
    assertEquals("Name", ((StartLocalNode) getResult).name);
    assertEquals("Signature", ((StartLocalNode) getResult).signature);
    assertEquals("Type", ((StartLocalNode) getResult).type);
    assertEquals(1, ((StartLocalNode) getResult).reg);
    assertSame(startLocalNode.label, ((StartLocalNode) getResult).label);
  }

  /**
   * Test DexDebugOpNode_StartLocalNode {@link StartLocalNode#StartLocalNode(DexLabel, int, String,
   * String, String)}.
   *
   * <p>Method under test: {@link StartLocalNode#StartLocalNode(DexLabel, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test DexDebugOpNode_StartLocalNode new StartLocalNode(DexLabel, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode$DexDebugOpNode$StartLocalNode.<init>(proguard.dexfile.reader.DexLabel, int, java.lang.String, java.lang.String, java.lang.String)"
  })
  void testDexDebugOpNode_StartLocalNodeNewStartLocalNode() {
    // Arrange and Act
    StartLocalNode actualStartLocalNode =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    // Assert
    assertEquals("Name", actualStartLocalNode.name);
    assertEquals("Signature", actualStartLocalNode.signature);
    assertEquals("Type", actualStartLocalNode.type);
    assertEquals(1, actualStartLocalNode.reg);
  }

  /**
   * Test {@link DexDebugNode#visitRestartLocal(int, DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitRestartLocal(int, DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitRestartLocal(int, DexLabel); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitRestartLocal(int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitRestartLocal_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitRestartLocal(1, label);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof RestartLocal);
    assertEquals(1, ((RestartLocal) getResult).reg);
    assertSame(label, ((RestartLocal) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitParameterName(int, String)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) {@link DexDebugNode#parameterNames} is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitParameterName(int, String)}
   */
  @Test
  @DisplayName(
      "Test visitParameterName(int, String); given DexDebugNode (default constructor) parameterNames is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitParameterName(int, java.lang.String)"
  })
  void testVisitParameterName_givenDexDebugNodeParameterNamesIsArrayList() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.parameterNames = new ArrayList<>();

    // Act
    dexDebugNode.visitParameterName(1, "Name");

    // Assert
    List<String> stringList = dexDebugNode.parameterNames;
    assertEquals(2, stringList.size());
    assertEquals("Name", stringList.get(1));
    assertNull(stringList.get(0));
  }

  /**
   * Test {@link DexDebugNode#visitParameterName(int, String)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#parameterNames} size
   *       is two.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitParameterName(int, String)}
   */
  @Test
  @DisplayName(
      "Test visitParameterName(int, String); given DexDebugNode (default constructor); then DexDebugNode (default constructor) parameterNames size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitParameterName(int, java.lang.String)"
  })
  void testVisitParameterName_givenDexDebugNode_thenDexDebugNodeParameterNamesSizeIsTwo() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();

    // Act
    dexDebugNode.visitParameterName(1, "Name");

    // Assert
    List<String> stringList = dexDebugNode.parameterNames;
    assertEquals(2, stringList.size());
    assertEquals("Name", stringList.get(1));
    assertNull(stringList.get(0));
  }

  /**
   * Test {@link DexDebugNode#visitLineNumber(int, DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitLineNumber(int, DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumber(int, DexLabel); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitLineNumber(int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitLineNumber_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitLineNumber(2, label);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof LineNumber);
    assertEquals(2, ((LineNumber) getResult).line);
    assertSame(label, ((LineNumber) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitStartLocal(int, DexLabel, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitStartLocal(int, DexLabel, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test visitStartLocal(int, DexLabel, String, String, String); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitStartLocal(int, proguard.dexfile.reader.DexLabel, java.lang.String, java.lang.String, java.lang.String)"
  })
  void testVisitStartLocal_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitStartLocal(1, label, "Name", "Type", "Signature");

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof StartLocalNode);
    assertEquals("Name", ((StartLocalNode) getResult).name);
    assertEquals("Signature", ((StartLocalNode) getResult).signature);
    assertEquals("Type", ((StartLocalNode) getResult).type);
    assertEquals(1, ((StartLocalNode) getResult).reg);
    assertSame(label, ((StartLocalNode) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitEndLocal(int, DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitEndLocal(int, DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitEndLocal(int, DexLabel); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitEndLocal(int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitEndLocal_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitEndLocal(1, label);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof EndLocal);
    assertEquals(1, ((EndLocal) getResult).reg);
    assertSame(label, ((EndLocal) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    EndLocal dexDebugNode2 = new EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    LineNumber dexDebugNode2 = new LineNumber(new DexLabel(), 2);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept3() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    RestartLocal dexDebugNode2 = new RestartLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept4() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    StartLocalNode dexDebugNode2 =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept5() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    EndLocal dexDebugNode2 = new EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept6() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    LineNumber dexDebugNode2 = new LineNumber(new DexLabel(), 2);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept7() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    RestartLocal dexDebugNode2 = new RestartLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexDebugVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept8() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    StartLocalNode dexDebugNode2 =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitParameterName one and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); given DexDebugNode (default constructor) visitParameterName one and 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_givenDexDebugNodeVisitParameterNameOneAndName() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitParameterName one and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); given DexDebugNode (default constructor) visitParameterName one and 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_givenDexDebugNodeVisitParameterNameOneAndName2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitSetFile {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); given DexDebugNode (default constructor) visitSetFile 'File'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_givenDexDebugNodeVisitSetFileFile() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitSetFile {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); given DexDebugNode (default constructor) visitSetFile 'File'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_givenDexDebugNodeVisitSetFileFile2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitSetFile {@code File}.
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#fineName} is {@code
   *       File}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); given DexDebugNode (default constructor) visitSetFile 'File'; then DexDebugNode (default constructor) fineName is 'File'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_givenDexDebugNodeVisitSetFileFile_thenDexDebugNodeFineNameIsFile() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof Epiogue);
    assertEquals("File", v.fineName);
    assertSame(dexDebugNode2.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>When {@link DexDebugVisitor#DexDebugVisitor()}.
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); given DexDebugNode (default constructor); when DexDebugVisitor(); then DexDebugNode (default constructor) debugNodes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_givenDexDebugNode_whenDexDebugVisitor_thenDexDebugNodeDebugNodesEmpty() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    assertTrue(dexDebugNode.debugNodes.isEmpty());
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.EndLocal}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first EndLocal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstEndLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    EndLocal dexDebugNode2 = new EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof EndLocal);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof Epiogue);
    assertEquals(1, ((EndLocal) getResult).reg);
    assertSame(dexDebugNode2.label, ((EndLocal) getResult).label);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Epiogue#Epiogue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first is Epiogue(DexLabel) with label is DexLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstIsEpiogueWithLabelIsDexLabel() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Epiogue#Epiogue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first is Epiogue(DexLabel) with label is DexLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstIsEpiogueWithLabelIsDexLabel2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Prologue#Prologue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first is Prologue(DexLabel) with label is DexLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstIsPrologueWithLabelIsDexLabel() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Prologue dexDebugNode2 = new Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Prologue#Prologue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first is Prologue(DexLabel) with label is DexLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstIsPrologueWithLabelIsDexLabel2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Prologue dexDebugNode2 = new Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.LineNumber}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first LineNumber")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstLineNumber() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    LineNumber dexDebugNode2 = new LineNumber(new DexLabel(), 2);

    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof LineNumber);
    assertEquals(2, ((LineNumber) getResult2).line);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((LineNumber) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.Prologue}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first Prologue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstPrologue() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Prologue dexDebugNode2 = new Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof Prologue);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((Prologue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.RestartLocal}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first RestartLocal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstRestartLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    RestartLocal dexDebugNode2 = new RestartLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof RestartLocal);
    assertEquals(1, ((RestartLocal) getResult2).reg);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((RestartLocal) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link StartLocalNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) debugNodes first StartLocalNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeDebugNodesFirstStartLocalNode() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    StartLocalNode dexDebugNode2 =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);
    dexDebugNode.addDebug(new Epiogue(new DexLabel()));
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof StartLocalNode);
    assertEquals("Name", ((StartLocalNode) getResult).name);
    assertEquals("Signature", ((StartLocalNode) getResult).signature);
    assertEquals("Type", ((StartLocalNode) getResult).type);
    assertSame(dexDebugNode2.label, ((StartLocalNode) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#parameterNames}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); then DexDebugNode (default constructor) parameterNames")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_thenDexDebugNodeParameterNames() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    dexDebugNode.addDebug(new Epiogue(new DexLabel()));
    dexDebugNode.addDebug(new Epiogue(new DexLabel()));
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    assertEquals(dexDebugNode.parameterNames, v.parameterNames);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.Epiogue}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexDebugVisitor); when DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes first Epiogue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.accept(proguard.dexfile.reader.visitors.DexDebugVisitor)"
  })
  void testAccept_whenDexDebugNode_thenDexDebugNodeDebugNodesFirstEpiogue() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof Epiogue);
    assertSame(dexDebugNode2.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#visitPrologue(DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitPrologue(DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitPrologue(DexLabel); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitPrologue(proguard.dexfile.reader.DexLabel)"
  })
  void testVisitPrologue_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugNode.visitPrologue(dexLabel);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Prologue);
    assertSame(dexLabel, ((Prologue) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitEpiogue(DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitEpiogue(DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitEpiogue(DexLabel); given DexDebugNode (default constructor); then DexDebugNode (default constructor) debugNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.visitEpiogue(proguard.dexfile.reader.DexLabel)"
  })
  void testVisitEpiogue_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugNode.visitEpiogue(dexLabel);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    assertSame(dexLabel, ((Epiogue) getResult).label);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DexDebugNode}
   *   <li>{@link DexDebugNode#visitSetFile(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexDebugNode.<init>()",
    "void proguard.dexfile.reader.node.DexDebugNode.visitSetFile(java.lang.String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DexDebugNode actualDexDebugNode = new DexDebugNode();
    actualDexDebugNode.visitSetFile("File");

    // Assert
    assertTrue(actualDexDebugNode.debugNodes.isEmpty());
  }
}
