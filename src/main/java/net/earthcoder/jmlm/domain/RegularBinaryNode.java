package net.earthcoder.jmlm.domain;

public final class RegularBinaryNode extends BinaryNode {

    private static final int BINARYNODE_LEVEL_STEP = 1;

    private BinaryNode father;
    private BinaryNode refer;

    public RegularBinaryNode(Human content, BinaryNode refer, BinaryNode father, Long value) {
        super(content, value);
        this.refer = refer;
        this.father = father;
        level = getFather().getLevel() + RegularBinaryNode.BINARYNODE_LEVEL_STEP;
        initRelationshipSet();
    }

    private void initRelationshipSet() {
        for (Relationship relation : father.getRelationshipSet()) {
            getRelationshipSet().add(new Relationship(relation.getBinaryNode(), relation.getFlag()));
        }
        getRelationshipSet().add(new Relationship(father, null));
    }

    @Override
    protected BinaryNode getFather() {
        return father;
    }

    public BinaryNode getRefer() {
        return refer;
    }
}
