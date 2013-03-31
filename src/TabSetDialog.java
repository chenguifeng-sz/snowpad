package com.xiboliya.snowpad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * "Tab�ַ�����"�Ի���
 * 
 * @author chen
 * 
 */
public class TabSetDialog extends BaseDialog implements ActionListener {
  private static final long serialVersionUID = 1L;
  private JPanel pnlMain = (JPanel) this.getContentPane();
  private JLabel lblTabSize = new JLabel("Tab����ռ�ַ�����");
  private BaseTextField txtTabSize = new BaseTextField();
  private JCheckBox chkReplaceBySpace = new JCheckBox("�Կո����Tab��(R)", false);
  private JButton btnOk = new JButton("ȷ��");
  private JButton btnCancel = new JButton("ȡ��");
  private BaseKeyAdapter keyAdapter = new BaseKeyAdapter(this);
  private BaseKeyAdapter buttonKeyAdapter = new BaseKeyAdapter(this, false);
  private boolean isReplaceBySpace = false; // �Կո����Tab��

  public TabSetDialog(JFrame owner, boolean modal, JTextArea txaSource) {
    super(owner, modal);
    if (txaSource == null) {
      return;
    }
    this.txaSource = txaSource;
    this.init();
    this.initTabSize();
    this.addListeners();
    this.setSize(240, 130);
    this.setVisible(true);
  }

  /**
   * ��ʼ������
   */
  private void init() {
    this.setTitle("Tab�ַ�����");
    this.pnlMain.setLayout(null);
    this.lblTabSize.setBounds(20, 10, 120, Util.VIEW_HEIGHT);
    this.txtTabSize.setBounds(140, 10, 50, Util.INPUT_HEIGHT);
    this.pnlMain.add(this.lblTabSize);
    this.pnlMain.add(this.txtTabSize);
    this.chkReplaceBySpace.setBounds(36, 40, 150, Util.VIEW_HEIGHT);
    this.chkReplaceBySpace.setMnemonic('R');
    this.pnlMain.add(this.chkReplaceBySpace);
    this.btnOk.setBounds(20, 65, 85, Util.BUTTON_HEIGHT);
    this.btnCancel.setBounds(130, 65, 85, Util.BUTTON_HEIGHT);
    this.pnlMain.add(this.btnOk);
    this.pnlMain.add(this.btnCancel);
  }

  /**
   * ��д����ķ��������ñ������Ƿ�ɼ�
   */
  public void setVisible(boolean visible) {
    if (visible) {
      this.initTabSize();
    }
    super.setVisible(visible);
  }

  /**
   * ��ʼ���ı���
   */
  private void initTabSize() {
    this.txtTabSize.setText(String.valueOf(this.txaSource.getTabSize()));
    this.txtTabSize.selectAll();
  }

  /**
   * ����¼�������
   */
  private void addListeners() {
    this.txtTabSize.addKeyListener(this.keyAdapter);
    this.btnOk.addActionListener(this);
    this.btnOk.addKeyListener(this.buttonKeyAdapter);
    this.btnCancel.addActionListener(this);
    this.btnCancel.addKeyListener(this.buttonKeyAdapter);
    this.chkReplaceBySpace.addActionListener(this);
    this.chkReplaceBySpace.addKeyListener(this.keyAdapter);
  }

  /**
   * Ϊ���������¼��Ĵ�����
   */
  public void actionPerformed(ActionEvent e) {
    if (this.btnOk.equals(e.getSource())) {
      this.onEnter();
    } else if (this.btnCancel.equals(e.getSource())) {
      this.onCancel();
    } else if (this.chkReplaceBySpace.equals(e.getSource())) {
      this.setReplaceBySpace(this.chkReplaceBySpace.isSelected());
    }
  }

  /**
   * ����Tab��ռ�ַ���
   */
  private void setTabSize() {
    int tabSize = Util.DEFAULT_TABSIZE; // Tab����ռ�ַ���
    try {
      tabSize = Integer.parseInt(this.txtTabSize.getText().trim());
    } catch (NumberFormatException x) {
      x.printStackTrace();
      JOptionPane.showMessageDialog(this, "��ʽ�������������֣�", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
      this.txtTabSize.setText("");
      return;
    }
    if (tabSize < Util.MIN_TABSIZE) {
      JOptionPane.showMessageDialog(this, "������ڵ���" + Util.MIN_TABSIZE + "��",
          Util.SOFTWARE, JOptionPane.CANCEL_OPTION);
      this.txtTabSize.setText(String.valueOf(Util.MIN_TABSIZE));
    } else if (tabSize > Util.MAX_TABSIZE) {
      JOptionPane.showMessageDialog(this, "����С�ڵ���" + Util.MAX_TABSIZE + "��",
          Util.SOFTWARE, JOptionPane.CANCEL_OPTION);
      this.txtTabSize.setText(String.valueOf(Util.MAX_TABSIZE));
    } else {
      this.txaSource.setTabSize(tabSize);
      this.dispose();
    }
  }

  /**
   * ��ȡ�Ƿ��Կո����Tab��
   */
  public boolean getReplaceBySpace() {
    return this.isReplaceBySpace;
  }

  /**
   * �����Ƿ��Կո����Tab��
   */
  public void setReplaceBySpace(boolean isReplaceBySpace) {
    this.isReplaceBySpace = isReplaceBySpace;
  }

  /**
   * Ĭ�ϵ�"ȷ��"��������
   */
  public void onEnter() {
    this.setTabSize();
  }

  /**
   * Ĭ�ϵ�"ȡ��"��������
   */
  public void onCancel() {
    this.dispose();
  }
}
