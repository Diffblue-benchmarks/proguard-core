package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFileVisitor;

public class DexFileNodeDiffblueTest {
  /**
   * Test {@link DexFileNode#visitDexFileVersion(int)}.
   *
   * <p>Method under test: {@link DexFileNode#visitDexFileVersion(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.visitDexFileVersion(int)"})
  public void testVisitDexFileVersion() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.visitDexFileVersion(1);

    // Assert
    assertEquals(1, dexFileNode.dexVersion);
  }

  /**
   * Test {@link DexFileNode#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileNode} (default constructor).
   *   <li>Then return {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#visit(int, String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexClassVisitor DexFileNode.visit(int, String, String, String[])"})
  public void testVisit_givenDexFileNode_thenReturnDexClassNode() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    DexClassVisitor actualVisitResult =
        dexFileNode.visit(1, "Class Name", "Super Class", new String[] {"Interface Names"});

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
    assertArrayEquals(
        new String[] {"Interface Names"}, ((DexClassNode) actualVisitResult).interfaceNames);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv2() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv3() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.anns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv4() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexFileNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    assertNull(dcv.anns);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Given {@link DexFileNode} (default constructor).
   *   <li>When {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_givenDexFileNode_whenDexFileVisitor_thenDexFileNodeClzsEmpty() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    assertTrue(dexFileNode.clzs.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#anns} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstAnnsSizeIsOne() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNodeList2.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#fields} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstFieldsSizeIsOne() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    List<DexFieldNode> dexFieldNodeList = dexClassNodeList2.get(0).fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#methods} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstMethodsSizeIsOne() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    List<DexMethodNode> dexMethodNodeList = dexClassNodeList2.get(0).methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.anns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstSourceIsFile() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("File", getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileNode} (default constructor).
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_whenDexFileNode_thenDexFileNodeClzsFirstSourceIsNull() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertNull(getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)} with visitor is {@link
   *       DexFileVisitor#DexFileVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_whenDexFileVisitorWithVisitorIsDexFileVisitor() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexFileVisitor(new DexFileVisitor()));

    // Assert that nothing has changed
    assertEquals(1, dexFileNode.clzs.size());
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_whenDexFileVisitor_thenDexFileNodeClzsSizeIsOne() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    assertEquals(1, dexFileNode.clzs.size());
  }

  /**
   * Test new {@link DexFileNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DexFileNode}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileNode.<init>()"})
  public void testNewDexFileNode() {
    // Arrange, Act and Assert
    assertTrue((new DexFileNode()).clzs.isEmpty());
  }
}
