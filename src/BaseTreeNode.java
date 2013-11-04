package com.xiboliya.snowpad;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Ӧ����JTree�е��Զ���ڵ�
 * 
 * @author ��ԭ
 * 
 */
public class BaseTreeNode extends DefaultMutableTreeNode {
  private static final long serialVersionUID = 1L;
  private String content = null;

  public BaseTreeNode(String name) {
    super(name);
  }

  public BaseTreeNode(String name, String content) {
    super(name);
    this.setContent(content);
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
