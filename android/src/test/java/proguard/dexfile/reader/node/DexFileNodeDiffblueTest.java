package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFileVisitor;

public class DexFileNodeDiffblueTest {
  /**
   * Method under test: {@link DexFileNode#visitDexFileVersion(int)}
   */
  @Test
  public void testVisitDexFileVersion() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.visitDexFileVersion(1);

    // Assert
    assertEquals(1, dexFileNode.dexVersion);
  }

  /**
   * Method under test: {@link DexFileNode#visit(int, String, String, String[])}
   */
  @Test
  public void testVisit() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    DexClassVisitor actualVisitResult = dexFileNode.visit(1, "Class Name", "Super Class",
        new String[]{"Interface Names"});

    // Assert
    assertTrue(actualVisitResult instanceof DexClassNode);
    assertEquals("Class Name", ((DexClassNode) actualVisitResult).className);
    assertEquals("Super Class", ((DexClassNode) actualVisitResult).superClass);
    assertNull(((DexClassNode) actualVisitResult).source);
    assertNull(((DexClassNode) actualVisitResult).anns);
    assertNull(((DexClassNode) actualVisitResult).fields);
    assertNull(((DexClassNode) actualVisitResult).methods);
    assertEquals(1, dexFileNode.clzs.size());
    assertEquals(1, ((DexClassNode) actualVisitResult).access);
    assertArrayEquals(new String[]{"Interface Names"}, ((DexClassNode) actualVisitResult).interfaceNames);
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertTrue(dexFileNode.clzs.isEmpty());
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept5() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitMethod(1, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept6() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept7() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertNull(dcv.source);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept8() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept9() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    assertNull(dcv.source);
    assertNull(dcv.anns);
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(dcv.methods);
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept10() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept11() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(dcv.source);
    assertNull(dcv.anns);
    assertNull(getResult.anns);
    assertNull(dcv.fields);
    assertNull(getResult.codeNode);
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept12() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitMethod(1, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept13() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    assertNull(dcv.anns);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept14() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept15() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept16() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept17() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    assertTrue(dexFileNode.clzs.isEmpty());
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept18() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept19() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexFileVisitor(new DexFileVisitor()));

    // Assert that nothing has changed
    List<DexClassNode> dexClassNodeList2 = dexFileNode.clzs;
    assertEquals(1, dexClassNodeList2.size());
    assertSame(dexClassNode, dexClassNodeList2.get(0));
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept20() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode);
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("Class Name", getResult.className);
    DexClassNode getResult2 = dexClassNodeList2.get(1);
    assertEquals("Class Name", getResult2.className);
    assertEquals("Super Class", getResult.superClass);
    assertEquals("Super Class", getResult2.superClass);
    assertNull(getResult.source);
    assertNull(getResult2.source);
    assertNull(getResult.anns);
    assertNull(getResult2.anns);
    assertNull(getResult.fields);
    assertNull(getResult2.fields);
    assertNull(getResult.methods);
    assertNull(getResult2.methods);
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    String[] stringArray2 = getResult2.interfaceNames;
    assertSame(dexClassNode2.interfaceNames, stringArray2);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray2);
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept21() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("Class Name", getResult.className);
    DexClassNode getResult2 = dexClassNodeList2.get(1);
    assertEquals("Class Name", getResult2.className);
    List<DexAnnotationNode> dexAnnotationNodeList = getResult.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult3 = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult3.type);
    assertEquals("Super Class", getResult.superClass);
    assertEquals("Super Class", getResult2.superClass);
    assertNull(getResult.source);
    assertNull(getResult2.source);
    assertNull(getResult2.anns);
    assertNull(getResult.fields);
    assertNull(getResult2.fields);
    assertNull(getResult.methods);
    assertNull(getResult2.methods);
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    assertEquals(Visibility.BUILD, getResult3.visibility);
    assertTrue(getResult3.items.isEmpty());
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    String[] stringArray2 = getResult2.interfaceNames;
    assertSame(dexClassNode2.interfaceNames, stringArray2);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray2);
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept22() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("Class Name", getResult.className);
    DexClassNode getResult2 = dexClassNodeList2.get(1);
    assertEquals("Class Name", getResult2.className);
    assertEquals("Super Class", getResult.superClass);
    assertEquals("Super Class", getResult2.superClass);
    assertNull(getResult.source);
    assertNull(getResult2.source);
    assertNull(getResult.anns);
    assertNull(getResult2.anns);
    List<DexFieldNode> dexFieldNodeList = getResult.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult3 = dexFieldNodeList.get(0);
    assertNull(getResult3.anns);
    assertNull(getResult2.fields);
    assertNull(getResult.methods);
    assertNull(getResult2.methods);
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    assertEquals(1, getResult3.access);
    assertSame(field, getResult3.field);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    String[] stringArray2 = getResult2.interfaceNames;
    assertSame(dexClassNode2.interfaceNames, stringArray2);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray2);
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept23() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("Class Name", getResult.className);
    DexClassNode getResult2 = dexClassNodeList2.get(1);
    assertEquals("Class Name", getResult2.className);
    assertEquals("Super Class", getResult.superClass);
    assertEquals("Super Class", getResult2.superClass);
    List<DexMethodNode> dexMethodNodeList = getResult.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult3 = dexMethodNodeList.get(0);
    assertNull(getResult3.parameterAnns);
    assertNull(getResult.source);
    assertNull(getResult2.source);
    assertNull(getResult.anns);
    assertNull(getResult2.anns);
    assertNull(getResult3.anns);
    assertNull(getResult.fields);
    assertNull(getResult2.fields);
    assertNull(getResult2.methods);
    assertNull(getResult3.codeNode);
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    assertEquals(1, getResult3.access);
    assertSame(method, getResult3.method);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    String[] stringArray2 = getResult2.interfaceNames;
    assertSame(dexClassNode2.interfaceNames, stringArray2);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray2);
  }

  /**
   * Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept24() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("Class Name", getResult.className);
    DexClassNode getResult2 = dexClassNodeList2.get(1);
    assertEquals("Class Name", getResult2.className);
    assertEquals("File", getResult.source);
    assertEquals("Super Class", getResult.superClass);
    assertEquals("Super Class", getResult2.superClass);
    assertNull(getResult2.source);
    assertNull(getResult.anns);
    assertNull(getResult2.anns);
    assertNull(getResult.fields);
    assertNull(getResult2.fields);
    assertNull(getResult.methods);
    assertNull(getResult2.methods);
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    String[] stringArray2 = getResult2.interfaceNames;
    assertSame(dexClassNode2.interfaceNames, stringArray2);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray2);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DexFileNode}
   */
  @Test
  public void testNewDexFileNode() {
    // Arrange, Act and Assert
    assertTrue((new DexFileNode()).clzs.isEmpty());
  }
}
