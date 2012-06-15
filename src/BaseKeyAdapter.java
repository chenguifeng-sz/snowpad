package com.xiboliya.snowpad;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ���û�����Esc��ʱ�رյ�ǰ�Ի��򣬰�Enter��ʱִ����Ӧ�����ļ����¼���
 * 
 * @author chen
 * 
 */
public class BaseKeyAdapter extends KeyAdapter {
  private BaseDialog dialog = null;
  private boolean applyEnter = true;

  public BaseKeyAdapter(BaseDialog dialog) {
    this.dialog = dialog;
  }

  public BaseKeyAdapter(BaseDialog dialog, boolean applyEnter) {
    this.dialog = dialog;
    this.applyEnter = applyEnter;
  }

  public void keyPressed(KeyEvent e) {
    if (null == this.dialog) {
      return;
    }
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      this.dialog.onCancel();
    } else if (e.getKeyCode() == KeyEvent.VK_ENTER && this.applyEnter) {
      this.dialog.onEnter();
    }
  }
}
