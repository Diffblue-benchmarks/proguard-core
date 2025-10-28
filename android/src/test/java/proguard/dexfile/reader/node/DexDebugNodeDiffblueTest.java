package proguard.dexfile.reader.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.visitors.DexDebugVisitor;

public class DexDebugNodeDiffblueTest {
  /**
   * Method under test: {@link DexDebugNode#addDebug(DexDebugNode.DexDebugOpNode)}
   */
  @Test
  public void testAddDebug() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());

    // Act
    dexDebugNode.addDebug(dexDebugNode2);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.EndLocal#accept(DexDebugVisitor)}
   */
  @Test
  public void testDexDebugOpNode_EndLocalAccept() {
    // Arrange
    DexDebugNode.DexDebugOpNode.EndLocal endLocal = new DexDebugNode.DexDebugOpNode.EndLocal(new DexLabel(), 1);
    DexDebugNode cv = new DexDebugNode();

    // Act
    endLocal.accept(cv);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.EndLocal);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.EndLocal) getResult).reg);
    assertSame(endLocal.label, ((DexDebugNode.DexDebugOpNode.EndLocal) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.EndLocal#EndLocal(DexLabel, int)}
   */
  @Test
  public void testDexDebugOpNode_EndLocalNewEndLocal() {
    // Arrange, Act and Assert
    assertEquals(1, (new DexDebugNode.DexDebugOpNode.EndLocal(new DexLabel(), 1)).reg);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.Epiogue#accept(DexDebugVisitor)}
   */
  @Test
  public void testDexDebugOpNode_EpiogueAccept() {
    // Arrange
    DexDebugNode.DexDebugOpNode.Epiogue epiogue = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    DexDebugNode cv = new DexDebugNode();

    // Act
    epiogue.accept(cv);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertSame(epiogue.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.LineNumber#accept(DexDebugVisitor)}
   */
  @Test
  public void testDexDebugOpNode_LineNumberAccept() {
    // Arrange
    DexDebugNode.DexDebugOpNode.LineNumber lineNumber = new DexDebugNode.DexDebugOpNode.LineNumber(new DexLabel(), 2);
    DexDebugNode cv = new DexDebugNode();

    // Act
    lineNumber.accept(cv);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.LineNumber);
    assertEquals(2, ((DexDebugNode.DexDebugOpNode.LineNumber) getResult).line);
    assertSame(lineNumber.label, ((DexDebugNode.DexDebugOpNode.LineNumber) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.LineNumber#LineNumber(DexLabel, int)}
   */
  @Test
  public void testDexDebugOpNode_LineNumberNewLineNumber() {
    // Arrange, Act and Assert
    assertEquals(2, (new DexDebugNode.DexDebugOpNode.LineNumber(new DexLabel(), 2)).line);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.Prologue#accept(DexDebugVisitor)}
   */
  @Test
  public void testDexDebugOpNode_PrologueAccept() {
    // Arrange
    DexDebugNode.DexDebugOpNode.Prologue prologue = new DexDebugNode.DexDebugOpNode.Prologue(new DexLabel());
    DexDebugNode cv = new DexDebugNode();

    // Act
    prologue.accept(cv);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Prologue);
    assertSame(prologue.label, ((DexDebugNode.DexDebugOpNode.Prologue) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.RestartLocal#accept(DexDebugVisitor)}
   */
  @Test
  public void testDexDebugOpNode_RestartLocalAccept() {
    // Arrange
    DexDebugNode.DexDebugOpNode.RestartLocal restartLocal = new DexDebugNode.DexDebugOpNode.RestartLocal(new DexLabel(),
        1);
    DexDebugNode cv = new DexDebugNode();

    // Act
    restartLocal.accept(cv);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.RestartLocal);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.RestartLocal) getResult).reg);
    assertSame(restartLocal.label, ((DexDebugNode.DexDebugOpNode.RestartLocal) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.RestartLocal#RestartLocal(DexLabel, int)}
   */
  @Test
  public void testDexDebugOpNode_RestartLocalNewRestartLocal() {
    // Arrange, Act and Assert
    assertEquals(1, (new DexDebugNode.DexDebugOpNode.RestartLocal(new DexLabel(), 1)).reg);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.StartLocalNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testDexDebugOpNode_StartLocalNodeAccept() {
    // Arrange
    DexDebugNode.DexDebugOpNode.StartLocalNode startLocalNode = new DexDebugNode.DexDebugOpNode.StartLocalNode(
        new DexLabel(), 1, "Name", "Type", "Signature");
    DexDebugNode cv = new DexDebugNode();

    // Act
    startLocalNode.accept(cv);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.StartLocalNode);
    assertEquals("Name", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).name);
    assertEquals("Signature", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).signature);
    assertEquals("Type", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).type);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).reg);
    assertSame(startLocalNode.label, ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode.DexDebugOpNode.StartLocalNode#StartLocalNode(DexLabel, int, String, String, String)}
   */
  @Test
  public void testDexDebugOpNode_StartLocalNodeNewStartLocalNode() {
    // Arrange and Act
    DexDebugNode.DexDebugOpNode.StartLocalNode actualStartLocalNode = new DexDebugNode.DexDebugOpNode.StartLocalNode(
        new DexLabel(), 1, "Name", "Type", "Signature");

    // Assert
    assertEquals("Name", actualStartLocalNode.name);
    assertEquals("Signature", actualStartLocalNode.signature);
    assertEquals("Type", actualStartLocalNode.type);
    assertEquals(1, actualStartLocalNode.reg);
  }

  /**
   * Method under test: {@link DexDebugNode#visitRestartLocal(int, DexLabel)}
   */
  @Test
  public void testVisitRestartLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitRestartLocal(1, label);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.RestartLocal);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.RestartLocal) getResult).reg);
    assertSame(label, ((DexDebugNode.DexDebugOpNode.RestartLocal) getResult).label);
  }

  /**
   * Method under test: {@link DexDebugNode#visitParameterName(int, String)}
   */
  @Test
  public void testVisitParameterName() {
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
   * Method under test: {@link DexDebugNode#visitParameterName(int, String)}
   */
  @Test
  public void testVisitParameterName2() {
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
   * Method under test: {@link DexDebugNode#visitLineNumber(int, DexLabel)}
   */
  @Test
  public void testVisitLineNumber() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitLineNumber(2, label);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.LineNumber);
    assertEquals(2, ((DexDebugNode.DexDebugOpNode.LineNumber) getResult).line);
    assertSame(label, ((DexDebugNode.DexDebugOpNode.LineNumber) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexDebugNode#visitStartLocal(int, DexLabel, String, String, String)}
   */
  @Test
  public void testVisitStartLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitStartLocal(1, label, "Name", "Type", "Signature");

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.StartLocalNode);
    assertEquals("Name", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).name);
    assertEquals("Signature", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).signature);
    assertEquals("Type", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).type);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).reg);
    assertSame(label, ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult).label);
  }

  /**
   * Method under test: {@link DexDebugNode#visitEndLocal(int, DexLabel)}
   */
  @Test
  public void testVisitEndLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitEndLocal(1, label);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.EndLocal);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.EndLocal) getResult).reg);
    assertSame(label, ((DexDebugNode.DexDebugOpNode.EndLocal) getResult).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    assertTrue(dexDebugNode.debugNodes.isEmpty());
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    assertEquals("File", dexDebugNode.fineName);
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<String> stringList = dexDebugNode.parameterNames;
    assertEquals(2, stringList.size());
    assertEquals("Name", stringList.get(1));
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept5() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.EndLocal dexDebugNode2 = new DexDebugNode.DexDebugOpNode.EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept6() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.LineNumber dexDebugNode2 = new DexDebugNode.DexDebugOpNode.LineNumber(new DexLabel(),
        2);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept7() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Prologue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept8() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.RestartLocal dexDebugNode2 = new DexDebugNode.DexDebugOpNode.RestartLocal(
        new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept9() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.StartLocalNode dexDebugNode2 = new DexDebugNode.DexDebugOpNode.StartLocalNode(
        new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept10() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept11() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    assertEquals("File", dexDebugNode.fineName);
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept12() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<String> stringList = dexDebugNode.parameterNames;
    assertEquals(2, stringList.size());
    assertEquals("Name", stringList.get(1));
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept13() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.EndLocal dexDebugNode2 = new DexDebugNode.DexDebugOpNode.EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept14() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.LineNumber dexDebugNode2 = new DexDebugNode.DexDebugOpNode.LineNumber(new DexLabel(),
        2);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept15() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Prologue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept16() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.RestartLocal dexDebugNode2 = new DexDebugNode.DexDebugOpNode.RestartLocal(
        new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept17() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.StartLocalNode dexDebugNode2 = new DexDebugNode.DexDebugOpNode.StartLocalNode(
        new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept18() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertNull(v.fineName);
    assertNull(v.parameterNames);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept19() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.EndLocal dexDebugNode2 = new DexDebugNode.DexDebugOpNode.EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.EndLocal);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertNull(v.fineName);
    assertNull(v.parameterNames);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.EndLocal) getResult).reg);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.EndLocal) getResult).label);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept20() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.LineNumber dexDebugNode2 = new DexDebugNode.DexDebugOpNode.LineNumber(new DexLabel(),
        2);

    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.LineNumber);
    assertNull(v.fineName);
    assertNull(v.parameterNames);
    assertEquals(2, ((DexDebugNode.DexDebugOpNode.LineNumber) getResult2).line);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.LineNumber) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept21() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.Prologue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.Prologue);
    assertNull(v.fineName);
    assertNull(v.parameterNames);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.Prologue) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept22() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.RestartLocal dexDebugNode2 = new DexDebugNode.DexDebugOpNode.RestartLocal(
        new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.RestartLocal);
    assertNull(v.fineName);
    assertNull(v.parameterNames);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.RestartLocal) getResult2).reg);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.RestartLocal) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept23() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexDebugNode.DexDebugOpNode.StartLocalNode dexDebugNode2 = new DexDebugNode.DexDebugOpNode.StartLocalNode(
        new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.StartLocalNode);
    assertEquals("Name", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult2).name);
    assertEquals("Signature", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult2).signature);
    assertEquals("Type", ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult2).type);
    assertNull(v.fineName);
    assertNull(v.parameterNames);
    assertEquals(1, ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult2).reg);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.StartLocalNode) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept24() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertEquals("File", v.fineName);
    assertNull(v.parameterNames);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  public void testAccept25() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode2 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    DexDebugNode.DexDebugOpNode.Epiogue dexDebugNode3 = new DexDebugNode.DexDebugOpNode.Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    DexDebugNode.DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertNull(v.fineName);
    assertEquals(dexDebugNode.parameterNames, v.parameterNames);
    assertSame(dexDebugNode2.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult2).label);
  }

  /**
   * Method under test: {@link DexDebugNode#visitPrologue(DexLabel)}
   */
  @Test
  public void testVisitPrologue() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugNode.visitPrologue(dexLabel);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Prologue);
    assertSame(dexLabel, ((DexDebugNode.DexDebugOpNode.Prologue) getResult).label);
  }

  /**
   * Method under test: {@link DexDebugNode#visitEpiogue(DexLabel)}
   */
  @Test
  public void testVisitEpiogue() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugNode.visitEpiogue(dexLabel);

    // Assert
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertSame(dexLabel, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DexDebugNode}
   *   <li>{@link DexDebugNode#visitSetFile(String)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DexDebugNode actualDexDebugNode = new DexDebugNode();
    actualDexDebugNode.visitSetFile("File");

    // Assert
    assertTrue(actualDexDebugNode.debugNodes.isEmpty());
  }
}
