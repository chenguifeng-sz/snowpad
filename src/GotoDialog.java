package com.xiboliya.snowpad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 * "ת��"�Ի���
 * 
 * @author chen
 * 
 */
public class GotoDialog extends BaseDialog implements ActionListener {
  private static final long serialVersionUID = 1L;
  private JTabbedPane tpnMain = new JTabbedPane();
  private JPanel pnlMain = (JPanel) this.getContentPane();
  private BaseKeyAdapter keyAdapter = new BaseKeyAdapter(this);
  private BaseKeyAdapter buttonKeyAdapter = new BaseKeyAdapter(this, false);
  // �к�
  private JPanel pnlLine = new JPanel();
  private JLabel lblCurLine = new JLabel();
  private JLabel lblEndLine = new JLabel();
  private JLabel lblGotoLine = new JLabel("ת���кţ�");
  private BaseTextField txtGotoLine = new BaseTextField();
  private JButton btnGotoLine = new JButton("ȷ��");
  private JButton btnCancelLine = new JButton("ȡ��");
  // ƫ����
  private JPanel pnlOffset = new JPanel();
  private JLabel lblCurOffset = new JLabel();
  private JLabel lblEndOffset = new JLabel();
  private JLabel lblGotoOffset = new JLabel("ת��ƫ������");
  private BaseTextField txtGotoOffset = new BaseTextField();
  private JButton btnGotoOffset = new JButton("ȷ��");
  private JButton btnCancelOffset = new JButton("ȡ��");

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
    this.setSize(240, 190);
    this.setVisible(true);
  }

  private void init() {
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
    this.btnGotoLine.setBounds(20, 90, 85, 23);
    this.btnCancelLine.setBounds(120, 90, 85, 23);
    this.pnlLine.add(this.btnGotoLine);
    this.pnlLine.add(this.btnCancelLine);
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
    this.btnGotoOffset.setBounds(20, 90, 85, Util.BUTTON_HEIGHT);
    this.btnCancelOffset.setBounds(120, 90, 85, Util.BUTTON_HEIGHT);
    this.pnlOffset.add(this.btnGotoOffset);
    this.pnlOffset.add(this.btnCancelOffset);

    this.tpnMain.add(this.pnlLine, "�к�");
    this.tpnMain.add(this.pnlOffset, "ƫ����");
    this.pnlMain.add(this.tpnMain, BorderLayout.CENTER);
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
   * ���µ�ǰ�кźͽ�β�кŵ���ʾ
   */
  private void updateView() {
    CurrentLine currentLine = new CurrentLine(this.txaSource);
    int lineNum = currentLine.getLineNum() + 1;
    this.lblCurLine.setText("��ǰ�кţ�" + lineNum);
    this.lblEndLine.setText("��β�кţ�" + this.txaSource.getLineCount());
    int currentIndex = currentLine.getCurrentIndex();
    this.lblCurOffset.setText("��ǰƫ������" + currentIndex);
    this.lblEndOffset.setText("��βƫ������" + this.txaSource.getText().length());
  }

  private void addListeners() {
    this.btnGotoLine.addActionListener(this);
    this.btnCancelLine.addActionListener(this);
    this.txtGotoLine.addKeyListener(this.keyAdapter);
    this.btnCancelLine.addKeyListener(this.buttonKeyAdapter);
    this.btnGotoLine.addKeyListener(this.buttonKeyAdapter);
    this.btnGotoOffset.addActionListener(this);
    this.btnCancelOffset.addActionListener(this);
    this.txtGotoOffset.addKeyListener(this.keyAdapter);
    this.btnCancelOffset.addKeyListener(this.buttonKeyAdapter);
    this.btnGotoOffset.addKeyListener(this.buttonKeyAdapter);
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

  public void actionPerformed(ActionEvent e) {
    if (this.btnCancelLine.equals(e.getSource())
        || this.btnCancelOffset.equals(e.getSource())) {
      this.onCancel();
    } else if (this.btnGotoLine.equals(e.getSource())
        || this.btnGotoOffset.equals(e.getSource())) {
      this.onEnter();
    }
  }

  /**
   * Ĭ�ϵ�"ȷ��"��������
   */
  public void onEnter() {
    if (this.getTabbedIndex() == 0) {
      this.gotoLine();
    } else {
      this.gotoOffset();
    }
  }

  /**
   * Ĭ�ϵ�"ȡ��"��������
   */
  public void onCancel() {
    this.cancelGoto();
  }
}
