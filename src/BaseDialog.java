package com.xiboliya.snowpad;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * ����ͳһ��Ϊ��JDialog������
 * 
 * @author chen
 * 
 */
public abstract class BaseDialog extends JDialog {
  private static final long serialVersionUID = 1L;
  private JFrame owner = null;

  public BaseDialog(JFrame owner, boolean modal) {
    super(owner, modal);
    this.owner = owner;
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  }

  /**
   * "ȷ��"������Ĭ�Ϸ�������Ϊ���󷽷����������ʵ��
   */
  public abstract void onEnter();

  /**
   * "ȡ��"������Ĭ�Ϸ�������Ϊ���󷽷����������ʵ��
   */
  public abstract void onCancel();

  /**
   * ��д����ķ�������ʾ�����ص�ǰ����
   */
  public void setVisible(boolean visible) {
    if (visible) {
      this.setLocationRelativeTo(this.owner);
    }
    super.setVisible(visible);
  }
}
