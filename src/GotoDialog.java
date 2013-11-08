/**
 * Copyright (C) 2013 ��ԭ
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.xiboliya.snowpad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;

/**
 * "ת��"�Ի���
 * 
 * @author ��ԭ
 * 
 */
public class GotoDialog extends BaseDialog implements ActionListener,
    ChangeListener {
  private static final long serialVersionUID = 1L;
  private JTabbedPane tpnMain = new JTabbedPane();
  private JPanel pnlMain = (JPanel) this.getContentPane();
  private JPanel pnlBottom = new JPanel();
  private BaseKeyAdapter keyAdapter = new BaseKeyAdapter(this);
  private BaseKeyAdapter buttonKeyAdapter = new BaseKeyAdapter(this, false);
  private boolean percentChanged = false; // ���ڱ�ʶ�Ƿ��ƶ����ٷֱȵĻ���
  private JButton btnGoto = new JButton("ȷ��");
  private JButton btnCancel = new JButton("ȡ��");
  // �к�
  private JPanel pnlLine = new JPanel();
  private JLabel lblCurLine = new JLabel();
  private JLabel lblEndLine = new JLabel();
  private JLabel lblGotoLine = new JLabel("ת���кţ�");
  private BaseTextField txtGotoLine = new BaseTextField(true, "\\d*"); // �����û�ֻ����������
  // ƫ����
  private JPanel pnlOffset = new JPanel();
  private JLabel lblCurOffset = new JLabel();
  private JLabel lblEndOffset = new JLabel();
  private JLabel lblGotoOffset = new JLabel("ת��ƫ������");
  private BaseTextField txtGotoOffset = new BaseTextField(true, "\\d*"); // �����û�ֻ����������
  // �ٷֱ�
  private JSlider sldPercent = new JSlider();
  private JPanel pnlPercent = new JPanel();
  private JLabel lblGotoPercent = new JLabel("ת���ٷֱȣ�");
  private BaseTextField txtGotoPercent = new BaseTextField();

  public GotoDialog(JFrame owner, boolean modal, JTextArea txaSource) {
    super(owner, modal);
    if (txaSource == null) {
      return;
    }
    this.txaSource = txaSource;
    this.setTitle("ת��");
    this.init();
    this.updateView();
    this.addListeners();
    this.setSize(240, 195);
    this.setVisible(true);
  }

  private void init() {
    this.pnlMain.setLayout(null);
    // �к�
    this.pnlLine.setLayout(null);
    this.lblCurLine.setBounds(15, 10, 220, Util.VIEW_HEIGHT);
    this.lblEndLine.setBounds(15, 35, 220, Util.VIEW_HEIGHT);
    this.pnlLine.add(this.lblCurLine);
    this.pnlLine.add(this.lblEndLine);
    this.lblGotoLine.setBounds(15, 60, 80, Util.VIEW_HEIGHT);
    this.txtGotoLine.setBounds(95, 58, 100, Util.INPUT_HEIGHT);
    this.pnlLine.add(this.lblGotoLine);
    this.pnlLine.add(this.txtGotoLine);
    // ƫ����
    this.pnlOffset.setLayout(null);
    this.lblCurOffset.setBounds(15, 10, 220, Util.VIEW_HEIGHT);
    this.lblEndOffset.setBounds(15, 35, 220, Util.VIEW_HEIGHT);
    this.pnlOffset.add(this.lblCurOffset);
    this.pnlOffset.add(this.lblEndOffset);
    this.lblGotoOffset.setBounds(15, 60, 80, Util.VIEW_HEIGHT);
    this.txtGotoOffset.setBounds(95, 58, 100, Util.INPUT_HEIGHT);
    this.pnlOffset.add(this.lblGotoOffset);
    this.pnlOffset.add(this.txtGotoOffset);
    // �ٷֱ�
    this.pnlPercent.setLayout(null);
    this.sldPercent.setBounds(20, 10, 200, 35);
    this.lblGotoPercent.setBounds(15, 60, 80, Util.VIEW_HEIGHT);
    this.txtGotoPercent.setBounds(95, 58, 100, Util.INPUT_HEIGHT);
    this.txtGotoPercent.setEditable(false);
    this.txtGotoPercent.setFocusable(false);
    this.pnlPercent.add(this.sldPercent);
    this.pnlPercent.add(this.lblGotoPercent);
    this.pnlPercent.add(this.txtGotoPercent);
    // ��ť
    this.pnlBottom.setLayout(null);
    this.pnlBottom.setBounds(0, 130, 240, 65);
    this.btnGoto.setBounds(25, 5, 85, Util.BUTTON_HEIGHT);
    this.btnCancel.setBounds(128, 5, 85, Util.BUTTON_HEIGHT);
    this.pnlBottom.add(this.btnGoto);
    this.pnlBottom.add(this.btnCancel);

    this.tpnMain.setBounds(0, 0, 240, 130);
    this.tpnMain.add(this.pnlLine, "�к�");
    this.tpnMain.add(this.pnlOffset, "ƫ����");
    this.tpnMain.add(this.pnlPercent, "�ٷֱ�");
    this.pnlMain.add(this.tpnMain);
    this.pnlMain.add(this.pnlBottom);
    this.setTabbedIndex(0);
    this.tpnMain.setFocusable(false);
  }

  /**
   * ��д����ķ��������ñ������Ƿ�ɼ�
   */
  public void setVisible(boolean visible) {
    if (visible) {
      this.updateView();
    }
    super.setVisible(visible);
  }

  /**
   * ����ѡ��ĵ�ǰ��ͼ
   * 
   * @param index
   *          ��ͼ��������
   */
  private void setTabbedIndex(int index) {
    this.tpnMain.setSelectedIndex(index);
  }

  /**
   * ��ȡѡ���ǰ��ͼ��������
   * 
   * @return ��ǰ��ͼ��������
   */
  private int getTabbedIndex() {
    return this.tpnMain.getSelectedIndex();
  }

  /**
   * ���µ�ǰ�ͽ�β״̬����ʾ���������кš�ƫ������ٷֱ�
   */
  private void updateView() {
    CurrentLine currentLine = new CurrentLine(this.txaSource);
    int total = this.txaSource.getText().length();
    int lineNum = currentLine.getLineNum() + 1;
    this.lblCurLine.setText("��ǰ�кţ�" + lineNum);
    this.lblEndLine.setText("��β�кţ�" + this.txaSource.getLineCount());
    int currentIndex = currentLine.getCurrentIndex();
    this.lblCurOffset.setText("��ǰƫ������" + currentIndex);
    this.lblEndOffset.setText("��βƫ������" + total);
    this.sldPercent.setValue(currentIndex * 100 / total);
    this.percentChanged = false;
    this.txtGotoPercent.setText(this.sldPercent.getValue() + "%");
  }

  private void addListeners() {
    this.btnGoto.addActionListener(this);
    this.btnGoto.addKeyListener(this.buttonKeyAdapter);
    this.btnCancel.addActionListener(this);
    this.btnCancel.addKeyListener(this.buttonKeyAdapter);
    this.txtGotoLine.addKeyListener(this.keyAdapter);
    this.txtGotoOffset.addKeyListener(this.keyAdapter);
    this.sldPercent.addChangeListener(this);
    this.sldPercent.addKeyListener(this.keyAdapter);
  }

  /**
   * "ȡ��"��ť�Ĵ�����
   */
  private void cancelGoto() {
    this.dispose();
    this.txtGotoLine.setText("");
    this.txtGotoOffset.setText("");
  }

  /**
   * ת��ָ���к�
   */
  private void gotoLine() {
    int total = this.txaSource.getLineCount(); // �ı���������
    String str = this.txtGotoLine.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(this, "�кŲ���Ϊ�գ�", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
      this.txtGotoLine.requestFocus();
      return;
    }
    int target = 1; // ָ�����к�
    try {
      target = Integer.parseInt(str);
    } catch (NumberFormatException x) {
      x.printStackTrace();
      JOptionPane.showMessageDialog(this, "��ʽ������������ֵ��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
      this.txtGotoLine.requestFocus();
      this.txtGotoLine.selectAll();
      return;
    }
    if (target <= 0) {
      JOptionPane.showMessageDialog(this, "�кű������0��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
    } else if (target > total) {
      JOptionPane.showMessageDialog(this, "�кų�����Χ��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
    } else {
      try {
        // ��ȡָ������ʼ����ƫ������ָ���кŵ�ȡֵ��Χ��x>=0 && x<�ı���������
        int offset = this.txaSource.getLineStartOffset(target - 1);
        this.txaSource.setCaretPosition(offset);
      } catch (BadLocationException x) {
        x.printStackTrace();
      }
      this.cancelGoto();
    }
    this.txtGotoLine.requestFocus();
    this.txtGotoLine.selectAll();
  }

  /**
   * ת��ָ��ƫ����
   */
  private void gotoOffset() {
    int total = this.txaSource.getText().length(); // �ı�����ƫ����
    String str = this.txtGotoOffset.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(this, "ƫ��������Ϊ�գ�", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
      this.txtGotoOffset.requestFocus();
      return;
    }
    int target = 0; // ָ����ƫ����
    try {
      target = Integer.parseInt(str);
    } catch (NumberFormatException x) {
      x.printStackTrace();
      JOptionPane.showMessageDialog(this, "��ʽ������������ֵ��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
      this.txtGotoOffset.requestFocus();
      this.txtGotoOffset.selectAll();
      return;
    }
    if (target < 0) {
      JOptionPane.showMessageDialog(this, "ƫ����������ڵ���0��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
    } else if (target > total) {
      JOptionPane.showMessageDialog(this, "ƫ����������Χ��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
    } else {
      this.txaSource.setCaretPosition(target);
      this.cancelGoto();
    }
    this.txtGotoOffset.requestFocus();
    this.txtGotoOffset.selectAll();
  }

  /**
   * ת��ָ���ٷֱ�
   */
  private void gotoPercent() {
    if (percentChanged) {
      int total = this.txaSource.getText().length(); // �ı�����ƫ����
      int target = this.sldPercent.getValue(); // ָ���İٷֱ�
      int offset = total * target / 100;
      this.txaSource.setCaretPosition(offset);
    }
    this.cancelGoto();
  }

  public void actionPerformed(ActionEvent e) {
    if (this.btnCancel.equals(e.getSource())) {
      this.onCancel();
    } else if (this.btnGoto.equals(e.getSource())) {
      this.onEnter();
    }
  }

  public void stateChanged(ChangeEvent e) {
    if (this.sldPercent.equals(e.getSource())) {
      this.percentChanged = true;
      this.txtGotoPercent.setText(this.sldPercent.getValue() + "%");
    }
  }

  /**
   * Ĭ�ϵ�"ȷ��"��������
   */
  public void onEnter() {
    if (this.getTabbedIndex() == 0) {
      this.gotoLine();
    } else if (this.getTabbedIndex() == 1) {
      this.gotoOffset();
    } else {
      this.gotoPercent();
    }
  }

  /**
   * Ĭ�ϵ�"ȡ��"��������
   */
  public void onCancel() {
    this.cancelGoto();
  }
}
