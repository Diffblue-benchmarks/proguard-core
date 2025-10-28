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
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFieldVisitor;
import proguard.dexfile.reader.visitors.DexFileVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

public class DexClassNodeDiffblueTest {
  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertNull(dexClassNode.source);
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNode.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexFieldNode> dexFieldNodeList = dexClassNode.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    List<DexMethodNode> dexMethodNodeList = dexClassNode.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept5() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept6() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNode.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept7() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexFieldNode> dexFieldNodeList = dexClassNode.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept8() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    List<DexMethodNode> dexMethodNodeList = dexClassNode.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept9() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept10() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    assertNull(dcv.anns);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept11() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");

    // Act
    dexClassNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    assertEquals("File", dexClassNode.source);
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept12() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    dexClassNode.visitSource("File");
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept13() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);
    dexClassNode.visitSource("File");
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    assertNull(dcv.anns);
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(dcv.methods);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept14() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);
    dexClassNode.visitSource("File");
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(dcv.anns);
    assertNull(getResult.anns);
    assertNull(dcv.fields);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept15() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    dexClassNode.visitSource("File");

    // Act
    dexClassNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    assertEquals("File", dexClassNode.source);
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNode.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept16() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);
    dexClassNode.visitSource("File");

    // Act
    dexClassNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    assertEquals("File", dexClassNode.source);
    assertNull(dexClassNode.anns);
    List<DexFieldNode> dexFieldNodeList = dexClassNode.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(dexClassNode.methods);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept17() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);
    dexClassNode.visitSource("File");

    // Act
    dexClassNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    assertEquals("File", dexClassNode.source);
    List<DexMethodNode> dexMethodNodeList = dexClassNode.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(dexClassNode.anns);
    assertNull(getResult.anns);
    assertNull(dexClassNode.fields);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept18() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept19() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(new DexFileVisitor(new DexFileVisitor()));

    // Assert that nothing has changed
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept20() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("Class Name", getResult.className);
    assertEquals("Super Class", getResult.superClass);
    assertNull(getResult.source);
    assertNull(dexClassNode.anns);
    assertNull(getResult.anns);
    assertNull(dexClassNode.fields);
    assertNull(getResult.fields);
    assertNull(dexClassNode.methods);
    assertNull(getResult.methods);
    assertEquals(1, getResult.access);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept21() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexClassNode.accept(new DexFileVisitor(new DexFileNode()));

    // Assert
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept22() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("Class Name", getResult.className);
    List<DexAnnotationNode> dexAnnotationNodeList = getResult.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult2 = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult2.type);
    assertEquals("Super Class", getResult.superClass);
    assertNull(getResult.source);
    assertNull(dexClassNode.fields);
    assertNull(getResult.fields);
    assertNull(dexClassNode.methods);
    assertNull(getResult.methods);
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexClassNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    assertEquals(1, getResult.access);
    assertEquals(Visibility.BUILD, getResult2.visibility);
    assertTrue(dexAnnotationNodeList2.get(0).items.isEmpty());
    assertTrue(getResult2.items.isEmpty());
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept23() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("Class Name", getResult.className);
    assertEquals("Super Class", getResult.superClass);
    assertNull(getResult.source);
    assertNull(dexClassNode.anns);
    assertNull(getResult.anns);
    List<DexFieldNode> dexFieldNodeList = getResult.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult2 = dexFieldNodeList.get(0);
    assertNull(getResult2.anns);
    assertNull(dexClassNode.methods);
    assertNull(getResult.methods);
    List<DexFieldNode> dexFieldNodeList2 = dexClassNode.fields;
    assertEquals(1, dexFieldNodeList2.size());
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    assertSame(field, dexFieldNodeList2.get(0).field);
    assertSame(field, getResult2.field);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept24() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("Class Name", getResult.className);
    assertEquals("Super Class", getResult.superClass);
    List<DexMethodNode> dexMethodNodeList = getResult.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult2 = dexMethodNodeList.get(0);
    assertNull(getResult2.parameterAnns);
    assertNull(getResult.source);
    assertNull(dexClassNode.anns);
    assertNull(getResult.anns);
    assertNull(getResult2.anns);
    assertNull(dexClassNode.fields);
    assertNull(getResult.fields);
    assertNull(getResult2.codeNode);
    List<DexMethodNode> dexMethodNodeList2 = dexClassNode.methods;
    assertEquals(1, dexMethodNodeList2.size());
    assertEquals(1, getResult.access);
    assertEquals(1, getResult2.access);
    assertSame(method, dexMethodNodeList2.get(0).method);
    assertSame(method, getResult2.method);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
  }

  /**
   * Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  public void testAccept25() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.visitSource("File");
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("Class Name", getResult.className);
    assertEquals("File", getResult.source);
    assertEquals("Super Class", getResult.superClass);
    assertNull(dexClassNode.anns);
    assertNull(getResult.anns);
    assertNull(dexClassNode.fields);
    assertNull(getResult.fields);
    assertNull(dexClassNode.methods);
    assertNull(getResult.methods);
    assertEquals(1, getResult.access);
    String[] stringArray = getResult.interfaceNames;
    assertSame(dexClassNode.interfaceNames, stringArray);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
  }

  /**
   * Method under test: {@link DexClassNode#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexClassNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Method under test: {@link DexClassNode#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexClassNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Method under test: {@link DexClassNode#visitField(int, Field, Object)}
   */
  @Test
  public void testVisitField() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    DexFieldVisitor actualVisitFieldResult = dexClassNode.visitField(1, new Field("Owner", "Name", "Type"),
        Constant.Null);

    // Assert
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertEquals(1, dexClassNode.fields.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
  }

  /**
   * Method under test: {@link DexClassNode#visitField(int, Field, Object)}
   */
  @Test
  public void testVisitField2() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.fields = new ArrayList<>();

    // Act
    DexFieldVisitor actualVisitFieldResult = dexClassNode.visitField(1, new Field("Owner", "Name", "Type"),
        Constant.Null);

    // Assert
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertEquals(1, dexClassNode.fields.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
  }

  /**
   * Method under test: {@link DexClassNode#visitMethod(int, Method)}
   */
  @Test
  public void testVisitMethod() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    DexMethodVisitor actualVisitMethodResult = dexClassNode.visitMethod(1, new Method("Owner", "Name", proto));

    // Assert
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertEquals(1, dexClassNode.methods.size());
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method.getProto());
    assertArrayEquals(new String[]{"Parameter Types"}, method.getParameterTypes());
  }

  /**
   * Method under test: {@link DexClassNode#visitMethod(int, Method)}
   */
  @Test
  public void testVisitMethod2() {
    // Arrange
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    dexClassNode.methods = new ArrayList<>();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    DexMethodVisitor actualVisitMethodResult = dexClassNode.visitMethod(1, new Method("Owner", "Name", proto));

    // Assert
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertEquals(1, dexClassNode.methods.size());
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method.getProto());
    assertArrayEquals(new String[]{"Parameter Types"}, method.getParameterTypes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DexClassNode#DexClassNode(int, String, String, String[])}
   *   <li>{@link DexClassNode#visitSource(String)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DexClassNode actualDexClassNode = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});
    actualDexClassNode.visitSource("File");

    // Assert
    assertEquals("Class Name", actualDexClassNode.className);
    assertEquals("File", actualDexClassNode.source);
    assertEquals("Super Class", actualDexClassNode.superClass);
    assertNull(actualDexClassNode.anns);
    assertNull(actualDexClassNode.fields);
    assertNull(actualDexClassNode.methods);
    assertEquals(1, actualDexClassNode.access);
    assertArrayEquals(new String[]{"Interface Names"}, actualDexClassNode.interfaceNames);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DexClassNode#DexClassNode(DexClassVisitor, int, String, String, String[])}
   *   <li>{@link DexClassNode#visitSource(String)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    DexClassNode actualDexClassNode = new DexClassNode(new DexClassVisitor(), 1, "Class Name", "Super Class",
        new String[]{"Interface Names"});
    actualDexClassNode.visitSource("File");

    // Assert
    assertEquals("Class Name", actualDexClassNode.className);
    assertEquals("File", actualDexClassNode.source);
    assertEquals("Super Class", actualDexClassNode.superClass);
    assertNull(actualDexClassNode.anns);
    assertNull(actualDexClassNode.fields);
    assertNull(actualDexClassNode.methods);
    assertEquals(1, actualDexClassNode.access);
    assertArrayEquals(new String[]{"Interface Names"}, actualDexClassNode.interfaceNames);
  }
}
