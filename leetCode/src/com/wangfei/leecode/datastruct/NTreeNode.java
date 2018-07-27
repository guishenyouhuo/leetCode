package com.wangfei.leecode.datastruct;

import java.util.List;

public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val,List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
