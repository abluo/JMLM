package net.realqinwei.hzcrm.crm.service.impl;

import java.util.List;

import net.realqinwei.hzcrm.crm.been.Node;
import net.realqinwei.hzcrm.crm.dao.intf.NodeDAO;
import net.realqinwei.hzcrm.crm.service.intf.NodeService;

public final class NodeServiceImpl implements NodeService {
    
    private NodeDAO nodeDAO;

    @Override
    public void save(Node node) {
        this.nodeDAO.saveNode(node);
    }
    
    @Override
    public List<Node> getNodes() {
        return this.nodeDAO.findAll();
    }
    
    public NodeDAO getNodeDAO() {
        return nodeDAO;
    }

    public void setNodeDAO(NodeDAO nodeDAO) {
        this.nodeDAO = nodeDAO;
    }
}
