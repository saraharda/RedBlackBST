import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 3/10/17.
 */
public class RedBlackBSTNodeTest {
    protected RedBlackBSTNode nullNode;
    protected RedBlackBSTNode dataNode;
    protected RedBlackBSTNode threeNode;

    @Before
    public void setup() {
        nullNode = new RedBlackBSTNode();
        dataNode = new RedBlackBSTNode(new Integer(25));

        threeNode = new RedBlackBSTNode(new Integer(20));
        threeNode.setBlack();
        threeNode.setRight( new RedBlackBSTNode(45));
        threeNode.setLeft( new RedBlackBSTNode(15));
    }

    @Test
    public void constructorTest() {
        assertNotNull(nullNode);

        assertNotNull(dataNode);
        assertEquals( new Integer(25), dataNode.data);

        assertTrue( dataNode.getLeft().isNull() );
        assertTrue( dataNode.getRight().isNull() );
        assertNull( dataNode.getParent() );
    }

    @Test
    public void getSetTest() {
        assertTrue( dataNode.isRed() );
        assertFalse( dataNode.isBlack() );
        assertTrue( nullNode.isBlack() );
        assertFalse( nullNode.isRed() );

        dataNode.setBlack();
        assertTrue( dataNode.isBlack() );

        dataNode.setRed();
        assertTrue( dataNode.isRed() );
    }

    @Test
    public void validateLeafNodesBlackTest() {
        assertTrue( dataNode.validateLeafNodesBlack() );

        dataNode.getLeft().setRed();
        assertFalse( dataNode.validateLeafNodesBlack() );
    }

    @Test
    public void validateRedHasBlackChildren() {
        assertTrue( dataNode.validateRedHasBlackChildren() );

        assertTrue( threeNode.validateRedHasBlackChildren() );
        threeNode.setRed();
        threeNode.getRight().setBlack();
        assertFalse( threeNode.validateRedHasBlackChildren() );
    }

    @Test
    public void validateBlackHeight() {
        assertEquals( 0, nullNode.validateBlackHeight());
        assertEquals( 1, dataNode.validateBlackHeight());
        threeNode.getRight().setBlack();
        threeNode.getLeft().setBlack();
        assertEquals( 2, threeNode.validateBlackHeight());
    }
}
