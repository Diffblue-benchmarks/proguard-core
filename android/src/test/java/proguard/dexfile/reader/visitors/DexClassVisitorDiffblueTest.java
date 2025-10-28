package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexClassNode;
import proguard.dexfile.reader.node.DexFieldNode;
import proguard.dexfile.reader.node.DexMethodNode;

public class DexClassVisitorDiffblueTest {
  /**
   * Method under test: {@link DexClassVisitor#DexClassVisitor()}
   */
  @Test
  public void testNewDexClassVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexClassVisitor()).visitor);
    assertNull((new DexClassVisitor(new DexClassVisitor())).visitor.visitor);
  }

  /**
   * Method under test:
   * {@link DexClassVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange, Act and Assert
    assertNull((new DexClassVisitor()).visitAnnotation("Name", Visibility.BUILD));
    assertNull((new DexClassVisitor(new DexClassVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Method under test:
   * {@link DexClassVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    DexClassVisitor dexClassVisitor = new DexClassVisitor(dcv);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexClassVisitor.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertNull(((DexAnnotationNode) actualVisitAnnotationResult).visitor);
    List<DexAnnotationNode> dexAnnotationNodeList = ((DexClassNode) dexClassVisitor2).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(dcv.anns, dexAnnotationNodeList);
  }

  /**
   * Method under test: {@link DexClassVisitor#visitField(int, Field, Object)}
   */
  @Test
  public void testVisitField() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor();

    // Act and Assert
    assertNull(dexClassVisitor.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null));
  }

  /**
   * Method under test: {@link DexClassVisitor#visitField(int, Field, Object)}
   */
  @Test
  public void testVisitField2() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor(new DexClassVisitor());

    // Act and Assert
    assertNull(dexClassVisitor.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null));
  }

  /**
   * Method under test: {@link DexClassVisitor#visitField(int, Field, Object)}
   */
  @Test
  public void testVisitField3() {
    // Arrange
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    DexClassVisitor dexClassVisitor = new DexClassVisitor(dcv);

    // Act
    DexFieldVisitor actualVisitFieldResult = dexClassVisitor.visitField(1, new Field("Owner", "Name", "Type"),
        Constant.Null);

    // Assert
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertNull(((DexFieldNode) actualVisitFieldResult).visitor);
    List<DexFieldNode> dexFieldNodeList = ((DexClassNode) dexClassVisitor2).fields;
    assertEquals(1, dexFieldNodeList.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
    assertSame(dcv.fields, dexFieldNodeList);
  }

  /**
   * Method under test: {@link DexClassVisitor#visitMethod(int, Method)}
   */
  @Test
  public void testVisitMethod() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor();

    // Act and Assert
    assertNull(dexClassVisitor.visitMethod(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"))));
  }

  /**
   * Method under test: {@link DexClassVisitor#visitMethod(int, Method)}
   */
  @Test
  public void testVisitMethod2() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor(new DexClassVisitor());

    // Act and Assert
    assertNull(dexClassVisitor.visitMethod(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"))));
  }

  /**
   * Method under test: {@link DexClassVisitor#visitMethod(int, Method)}
   */
  @Test
  public void testVisitMethod3() {
    // Arrange
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    DexClassVisitor dexClassVisitor = new DexClassVisitor(dcv);
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    DexMethodVisitor actualVisitMethodResult = dexClassVisitor.visitMethod(1, new Method("Owner", "Name", proto));

    // Assert
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertNull(((DexMethodNode) actualVisitMethodResult).visitor);
    List<DexMethodNode> dexMethodNodeList = ((DexClassNode) dexClassVisitor2).methods;
    assertEquals(1, dexMethodNodeList.size());
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method.getProto());
    assertSame(dcv.methods, dexMethodNodeList);
    assertArrayEquals(new String[]{"Parameter Types"}, method.getParameterTypes());
  }

  /**
   * Method under test: {@link DexClassVisitor#visitSource(String)}
   */
  @Test
  public void testVisitSource() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor(
        new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"}));

    // Act
    dexClassVisitor.visitSource("File");

    // Assert
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertEquals("File", ((DexClassNode) dexClassVisitor2).source);
  }
}
