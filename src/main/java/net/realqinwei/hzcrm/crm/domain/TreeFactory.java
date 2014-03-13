package net.realqinwei.hzcrm.crm.domain;

import java.util.*;

import net.realqinwei.hzcrm.crm.been.Node;
import net.realqinwei.hzcrm.crm.domain.exception.AddErrorException;

public final class TreeFactory {

    public NodeRepository getNodeRepository() {
        return nodeRepository;
    }

    public void setNodeRepository(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    private NodeRepository nodeRepository;

	public SortedSet<Node> getBill() {

		List<Node> allUsers = this.getNodeRepository().findAll();

		SortedSet<Node> sortedAllUsers = new TreeSet<Node>();
		sortedAllUsers.addAll(allUsers);
		return sortedAllUsers;
	}

	public TreeComponent<Node> getTree() throws AddErrorException {

		List<Node> allUsers = this.getNodeRepository().findAll();

		SortedSet<Node> sortedAllUsers = new TreeSet<Node>();
		sortedAllUsers.addAll(allUsers);

		Queue<Node> allUsersQueue = new LinkedList<Node>();
		for (Node user : sortedAllUsers) {
			allUsersQueue.offer(user);
		}

		TreeComponent<Node> tree = new TreeComponent<Node>();
        Node tmpUser = null;
		while (!allUsersQueue.isEmpty() && null != tree) {
			tmpUser = allUsersQueue.poll();

			tree.addComponent(null == tmpUser.getUserReferID() ? null
					: this.getNodeRepository().findById(tmpUser.getUserReferID()),
					tmpUser);

		}
		
		//tree.view();

		return tree;
	}
}
