package com.xiboliya.snowpad;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * "����"��"�滻"�Ի���
 * 
 * @author ��ԭ
 * 
 */
public class FindReplaceDialog extends BaseDialog implements ActionListener,
    CaretListener, ChangeListener {
  private static final long serialVersionUID = 1L;
  private JPanel pnlMain = (JPanel) this.getContentPane();
  private JTabbedPane tpnMain = new JTabbedPane();
  private boolean isFindDown = true; // ���²���
  private boolean isIgnoreCase = true; // ���Դ�Сд
  private boolean isWrap = false; // ѭ������
  private boolean isTransfer = false; // ת����չ
  private BaseKeyAdapter keyAdapter = new BaseKeyAdapter(this);
  private BaseKeyAdapter buttonKeyAdapter = new BaseKeyAdapter(this, false);
  private String strFind = ""; // ���ҵ��ַ���
  // ����
  private JPanel pnlFind = new JPanel();
  private JLabel lblFindTextF = new JLabel("�������ݣ�");
  private BaseTextField txtFindTextF = new BaseTextField();
  private JCheckBox chkNotIgnoreCaseF = new JCheckBox("���ִ�Сд(C)", false);
  private JCheckBox chkIsWrapF = new JCheckBox("ѭ������(W)", false);
  private JCheckBox chkTransferF = new JCheckBox("ת����չ(T)", false);
  private JButton btnHelpF = new JButton(Util.HELP_ICON);
  private JRadioButton radFindUpF = new JRadioButton("����(U)", false);
  private JRadioButton radFindDownF = new JRadioButton("����(D)", true);
  private JButton btnFindF = new JButton("����(F)");
  private JButton btnCountF = new JButton("ͳ�ƴ���(T)");
  private JButton btnCancelF = new JButton("ȡ��");
  private ButtonGroup bgpFindUpDownF = new ButtonGroup();
  private JPanel pnlFindUpDownF = new JPanel(new GridLayout(2, 1));
  // �滻
  private JPanel pnlReplace = new JPanel();
  private JLabel lblFindTextR = new JLabel("�������ݣ�");
  private JLabel lblReplaceTextR = new JLabel("�滻Ϊ��");
  private BaseTextField txtFindTextR = new BaseTextField();
  private BaseTextField txtReplaceTextR = new BaseTextField();
  private JCheckBox chkNotIgnoreCaseR = new JCheckBox("���ִ�Сд(C)", false);
  private JCheckBox chkIsWrapR = new JCheckBox("ѭ������(W)", false);
  private JCheckBox chkTransferR = new JCheckBox("ת����չ(T)", false);
  private JButton btnHelpR = new JButton(Util.HELP_ICON);
  private JRadioButton radFindUpR = new JRadioButton("����(U)", false);
  private JRadioButton radFindDownR = new JRadioButton("����(D)", true);
  private JButton btnFindR = new JButton("����(F)");
  private JButton btnReplaceR = new JButton("�滻(R)");
  private JButton btnReplaceAllR = new JButton("ȫ���滻(A)");
  private JButton btnCancelR = new JButton("ȡ��");
  private ButtonGroup bgpFindUpDownR = new ButtonGroup();
  private JPanel pnlFindUpDownR = new JPanel(new GridLayout(2, 1));

  public FindReplaceDialog(JFrame owner, boolean modal, JTextArea txaSource,
      boolean visible) {
    super(owner, modal);
    if (txaSource == null) {
      return;
    }
    this.txaSource = txaSource;
    this.setTitle("����");
    this.init();
    this.setMnemonic();
    this.addListeners();
    this.setSize(390, 205);
    this.setVisible(visible);
  }

  /**
   * �����ʼ��
   */
  private void init() {
    // ����
    this.pnlFind.setLayout(null);
    this.lblFindTextF.setBounds(10, 10, 70, Util.VIEW_HEIGHT);
    this.txtFindTextF.setBounds(80, 9, 180, Util.INPUT_HEIGHT);
    this.pnlFind.add(this.lblFindTextF);
    this.pnlFind.add(this.txtFindTextF);
    this.chkNotIgnoreCaseF.setBounds(10, 50, 110, Util.VIEW_HEIGHT);
    this.pnlFind.add(this.chkNotIgnoreCaseF);
    this.chkIsWrapF.setBounds(10, 70, 110, Util.VIEW_HEIGHT);
    this.pnlFind.add(this.chkIsWrapF);
    this.chkTransferF.setBounds(10, 90, 95, Util.VIEW_HEIGHT);
    this.chkTransferF.setToolTipText("��ʹ��\\n��\\tת���ַ�");
    this.pnlFind.add(this.chkTransferF);
    this.btnHelpF.setBounds(105, 90, 12, Util.VIEW_HEIGHT);
    this.pnlFind.add(this.btnHelpF);
    this.btnHelpF.setToolTipText("���ܼ��");
    this.btnHelpF.setContentAreaFilled(false);
    this.btnHelpF.setFocusable(false);
    this.pnlFindUpDownF.setBounds(145, 40, 95, 70);
    this.pnlFindUpDownF.setBorder(new TitledBorder("����"));
    this.pnlFindUpDownF.add(this.radFindUpF);
    this.pnlFindUpDownF.add(this.radFindDownF);
    this.pnlFind.add(this.pnlFindUpDownF);
    this.btnFindF.setEnabled(false);
    this.btnFindF.setBounds(270, 10, 100, Util.BUTTON_HEIGHT);
    this.btnCountF.setEnabled(false);
    this.btnCountF.setBounds(270, 48, 100, Util.BUTTON_HEIGHT);
    this.btnCancelF.setBounds(270, 86, 100, Util.BUTTON_HEIGHT);
    this.pnlFind.add(this.btnFindF);
    this.pnlFind.add(this.btnCountF);
    this.pnlFind.add(this.btnCancelF);
    this.bgpFindUpDownF.add(this.radFindDownF);
    this.bgpFindUpDownF.add(this.radFindUpF);
    // �滻
    this.pnlReplace.setLayout(null);
    this.lblFindTextR.setBounds(10, 10, 70, Util.VIEW_HEIGHT);
    this.txtFindTextR.setBounds(80, 9, 180, Util.INPUT_HEIGHT);
    this.pnlReplace.add(this.lblFindTextR);
    this.pnlReplace.add(this.txtFindTextR);
    this.lblReplaceTextR.setBounds(10, 38, 70, Util.VIEW_HEIGHT);
    this.txtReplaceTextR.setBounds(80, 37, 180, Util.INPUT_HEIGHT);
    this.pnlReplace.add(this.lblReplaceTextR);
    this.pnlReplace.add(this.txtReplaceTextR);
    this.chkNotIgnoreCaseR.setBounds(10, 70, 110, Util.VIEW_HEIGHT);
    this.pnlReplace.add(this.chkNotIgnoreCaseR);
    this.chkIsWrapR.setBounds(10, 90, 110, Util.VIEW_HEIGHT);
    this.pnlReplace.add(this.chkIsWrapR);
    this.chkTransferR.setBounds(10, 110, 95, Util.VIEW_HEIGHT);
    this.chkTransferR.setToolTipText("��ʹ��\\n��\\tת���ַ�");
    this.pnlReplace.add(this.chkTransferR);
    this.btnHelpR.setBounds(105, 110, 12, Util.VIEW_HEIGHT);
    this.pnlReplace.add(this.btnHelpR);
    this.btnHelpR.setToolTipText("���ܼ��");
    this.btnHelpR.setContentAreaFilled(false);
    this.btnHelpR.setFocusable(false);
    this.pnlFindUpDownR.setBounds(145, 60, 95, 70);
    this.pnlFindUpDownR.setBorder(new TitledBorder("����"));
    this.pnlFindUpDownR.add(this.radFindUpR);
    this.pnlFindUpDownR.add(this.radFindDownR);
    this.pnlReplace.add(this.pnlFindUpDownR);
    this.btnFindR.setEnabled(false);
    this.btnReplaceR.setEnabled(false);
    this.btnReplaceAllR.setEnabled(false);
    this.btnFindR.setBounds(270, 10, 100, Util.BUTTON_HEIGHT);
    this.btnReplaceR.setBounds(270, 40, 100, Util.BUTTON_HEIGHT);
    this.btnReplaceAllR.setBounds(270, 70, 100, Util.BUTTON_HEIGHT);
    this.btnCancelR.setBounds(270, 100, 100, Util.BUTTON_HEIGHT);
    this.pnlReplace.add(this.btnFindR);
    this.pnlReplace.add(this.btnReplaceR);
    this.pnlReplace.add(this.btnReplaceAllR);
    this.pnlReplace.add(this.btnCancelR);
    this.bgpFindUpDownR.add(this.radFindDownR);
    this.bgpFindUpDownR.add(this.radFindUpR);
    // ������
    this.tpnMain.add(this.pnlFind, "����");
    this.tpnMain.add(this.pnlReplace, "�滻");
    this.pnlMain.add(this.tpnMain, BorderLayout.CENTER);
    this.setTabbedIndex(0);
    this.tpnMain.setFocusable(false);
  }

  /**
   * ����ѡ��ĵ�ǰ��ͼ
   * 
   * @param index
   *          ��ͼ��������
   */
  public void setTabbedIndex(int index) {
    this.tpnMain.setSelectedIndex(index);
  }

  /**
   * ��ȡѡ���ǰ��ͼ��������
   * 
   * @return ��ǰ��ͼ��������
   */
  public int getTabbedIndex() {
    return this.tpnMain.getSelectedIndex();
  }

  /**
   * ѡ�С��������ݡ��е��ı�
   */
  public void setFindTextSelect() {
    int tabbedIndex = this.getTabbedIndex();
    if (tabbedIndex == 0) {
      this.txtFindTextF.selectAll();
    } else {
      this.txtFindTextR.selectAll();
    }
  }

  /**
   * ��ȡ���ҵ��ַ���
   * 
   * @return ���ҵ��ַ���
   */
  public String getFindText() {
    return this.strFind;
  }

  /**
   * ���ò��ҵ��ַ���
   * 
   * @param strFind
   *          ���ҵ��ַ���
   * @param isUpdate
   *          �Ƿ�ͬ�������ı������ʾ������Ϊtrue��������Ϊfalse
   */
  public void setFindText(String strFind, boolean isUpdate) {
    this.strFind = strFind;
    if (isUpdate) {
      this.txtFindTextF.setText(strFind);
      this.txtFindTextR.setText(strFind);
      if (this.getTabbedIndex() == 0) {
        this.txtFindTextF.selectAll();
      } else if (this.getTabbedIndex() == 1) {
        this.txtFindTextR.selectAll();
      }
    }
  }

  /**
   * ��ȡ�����滻���ַ���
   * 
   * @return �����滻���ַ���
   */
  public String getReplaceText() {
    return this.txtReplaceTextR.getText();
  }

  /**
   * ���������滻���ַ���
   * 
   * @param strReplace
   *          �����滻���ַ���
   */
  public void setReplaceText(String strReplace) {
    this.txtReplaceTextR.setText(strReplace);
  }

  /**
   * Ϊ��������ÿ�ݼ�
   */
  private void setMnemonic() {
    // ����
    this.chkNotIgnoreCaseF.setMnemonic('C');
    this.chkIsWrapF.setMnemonic('W');
    this.chkTransferF.setMnemonic('T');
    this.btnFindF.setMnemonic('F');
    this.btnCountF.setMnemonic('T');
    this.radFindUpF.setMnemonic('U');
    this.radFindDownF.setMnemonic('D');
    // �滻
    this.chkNotIgnoreCaseR.setMnemonic('C');
    this.chkIsWrapR.setMnemonic('W');
    this.chkTransferR.setMnemonic('T');
    this.btnFindR.setMnemonic('F');
    this.btnReplaceR.setMnemonic('R');
    this.btnReplaceAllR.setMnemonic('A');
    this.radFindUpR.setMnemonic('U');
    this.radFindDownR.setMnemonic('D');
  }

  /**
   * Ϊ�������Ӽ�����
   */
  private void addListeners() {
    this.tpnMain.addChangeListener(this);
    // ����
    this.txtFindTextF.addCaretListener(this);
    this.btnFindF.addActionListener(this);
    this.btnCountF.addActionListener(this);
    this.btnCancelF.addActionListener(this);
    this.radFindDownF.addActionListener(this);
    this.radFindUpF.addActionListener(this);
    this.chkNotIgnoreCaseF.addActionListener(this);
    this.chkIsWrapF.addActionListener(this);
    this.chkTransferF.addActionListener(this);
    this.btnHelpF.addActionListener(this);
    this.txtFindTextF.addKeyListener(this.keyAdapter);
    this.chkNotIgnoreCaseF.addKeyListener(this.keyAdapter);
    this.chkIsWrapF.addKeyListener(this.keyAdapter);
    this.chkTransferF.addKeyListener(this.keyAdapter);
    this.radFindDownF.addKeyListener(this.keyAdapter);
    this.radFindUpF.addKeyListener(this.keyAdapter);
    this.btnCancelF.addKeyListener(this.buttonKeyAdapter);
    this.btnFindF.addKeyListener(this.buttonKeyAdapter);
    this.btnCountF.addKeyListener(this.buttonKeyAdapter);
    // �滻
    this.txtFindTextR.addCaretListener(this);
    this.btnFindR.addActionListener(this);
    this.btnReplaceR.addActionListener(this);
    this.btnReplaceAllR.addActionListener(this);
    this.btnCancelR.addActionListener(this);
    this.radFindDownR.addActionListener(this);
    this.radFindUpR.addActionListener(this);
    this.chkNotIgnoreCaseR.addActionListener(this);
    this.chkIsWrapR.addActionListener(this);
    this.chkTransferR.addActionListener(this);
    this.btnHelpR.addActionListener(this);
    this.txtFindTextR.addKeyListener(this.keyAdapter);
    this.txtReplaceTextR.addKeyListener(this.keyAdapter);
    this.chkNotIgnoreCaseR.addKeyListener(this.keyAdapter);
    this.chkIsWrapR.addKeyListener(this.keyAdapter);
    this.chkTransferR.addKeyListener(this.keyAdapter);
    this.radFindDownR.addKeyListener(this.keyAdapter);
    this.radFindUpR.addKeyListener(this.keyAdapter);
    this.btnCancelR.addKeyListener(this.buttonKeyAdapter);
    this.btnReplaceR.addKeyListener(this.buttonKeyAdapter);
    this.btnFindR.addKeyListener(this.buttonKeyAdapter);
    this.btnReplaceAllR.addKeyListener(this.buttonKeyAdapter);
  }

  /**
   * Ϊ���������¼��Ĵ�����
   */
  public void actionPerformed(ActionEvent e) {
    // ����
    if (this.btnCancelF.equals(e.getSource())) {
      this.onCancel();
    } else if (this.btnFindF.equals(e.getSource())) {
      this.onEnter();
    } else if (this.btnCountF.equals(e.getSource())) {
      this.getTextCount();
    } else if (this.chkNotIgnoreCaseF.equals(e.getSource())) {
      boolean selected = this.chkNotIgnoreCaseF.isSelected();
      this.isIgnoreCase = !selected;
      this.chkNotIgnoreCaseR.setSelected(selected);
    } else if (this.chkIsWrapF.equals(e.getSource())) {
      boolean selected = this.chkIsWrapF.isSelected();
      this.isWrap = selected;
      this.chkIsWrapR.setSelected(selected);
    } else if (this.chkTransferF.equals(e.getSource())) {
      boolean selected = this.chkTransferF.isSelected();
      this.isTransfer = selected;
      this.chkTransferR.setSelected(selected);
    } else if (this.btnHelpF.equals(e.getSource())) {
      this.showHelp();
    } else if (this.radFindDownF.equals(e.getSource())) {
      this.isFindDown = true;
      this.radFindDownR.setSelected(true);
    } else if (this.radFindUpF.equals(e.getSource())) {
      this.isFindDown = false;
      this.radFindUpR.setSelected(true);
    }
    // �滻
    else if (this.btnCancelR.equals(e.getSource())) {
      this.onCancel();
    } else if (this.btnFindR.equals(e.getSource())) {
      this.findText(this.isFindDown);
    } else if (this.btnReplaceR.equals(e.getSource())) {
      this.onEnter();
    } else if (this.btnReplaceAllR.equals(e.getSource())) {
      this.replaceAllText();
    } else if (this.chkNotIgnoreCaseR.equals(e.getSource())) {
      boolean selected = this.chkNotIgnoreCaseR.isSelected();
      this.isIgnoreCase = !selected;
      this.chkNotIgnoreCaseF.setSelected(selected);
    } else if (this.chkIsWrapR.equals(e.getSource())) {
      boolean selected = this.chkIsWrapR.isSelected();
      this.isWrap = selected;
      this.chkIsWrapF.setSelected(selected);
    } else if (this.chkTransferR.equals(e.getSource())) {
      boolean selected = this.chkTransferR.isSelected();
      this.isTransfer = selected;
      this.chkTransferF.setSelected(selected);
    } else if (this.btnHelpR.equals(e.getSource())) {
      this.showHelp();
    } else if (this.radFindDownR.equals(e.getSource())) {
      this.isFindDown = true;
      this.radFindDownF.setSelected(true);
    } else if (this.radFindUpR.equals(e.getSource())) {
      this.isFindDown = false;
      this.radFindUpF.setSelected(true);
    }
  }

  /**
   * Ĭ�ϵġ�ȡ������������
   */
  public void onCancel() {
    this.dispose();
  }

  /**
   * Ĭ�ϵġ�ȷ������������
   */
  public void onEnter() {
    if (this.tpnMain.getSelectedIndex() == 0) {
      this.findText(this.isFindDown);
    } else {
      this.replaceText();
    }
  }

  /**
   * ������������
   */
  private void showHelp() {
    JOptionPane.showMessageDialog(this,
        "������ѡ�������Խ��ı����в�����������������ַ�����ת���滻��\n���磬����ʹ��\\n���滻�У�\\t����Tab�ַ���",
        Util.SOFTWARE, JOptionPane.NO_OPTION);
  }

  /**
   * �����ַ���
   * 
   * @param isFindDown
   *          ���ҵķ���������²�����Ϊtrue����֮��Ϊfalse
   * @return ���ҽ����������ҳɹ�����true����֮��Ϊfalse
   */
  public boolean findText(boolean isFindDown) {
    if (this.strFind != null && !this.strFind.isEmpty()) {
      int index = Util.findText(this.strFind, this.txaSource, isFindDown,
          this.isIgnoreCase, this.isWrap, this.isTransfer);
      if (index >= 0) {
        if (this.isTransfer) {
          this.txaSource.select(index, index + this.strFind.length()
              - Util.transfer_count);
        } else {
          this.txaSource.select(index, index + this.strFind.length());
        }
        return true;
      } else {
        JOptionPane.showMessageDialog(this, "�Ҳ���\"" + this.strFind + "\"",
            Util.SOFTWARE, JOptionPane.NO_OPTION);
      }
    }
    return false;
  }

  /**
   * �滻�ַ���
   */
  private void replaceText() {
    boolean isEquals = false;
    String strSel = this.txaSource.getSelectedText();
    String strFindTemp = this.txtFindTextR.getText();
    String strReplaceTemp = this.txtReplaceTextR.getText();
    if (strSel != null) {
      if (this.isTransfer) {
        strFindTemp = Util.transfer(strFindTemp);
        strReplaceTemp = Util.transfer(strReplaceTemp);
      }
      if (this.isIgnoreCase) {
        if (strSel.equalsIgnoreCase(strFindTemp)) {
          isEquals = true;
        }
      } else {
        if (strSel.equals(strFindTemp)) {
          isEquals = true;
        }
      }
    }
    if (isEquals) {
      this.txaSource.replaceSelection(strReplaceTemp);
    }
    this.findText(this.isFindDown);
  }

  /**
   * �滻�����ַ���
   */
  private void replaceAllText() {
    String strFindText = this.txtFindTextR.getText();
    String strReplaceText = this.txtReplaceTextR.getText();
    StringBuilder stbTextAll = new StringBuilder(this.txaSource.getText()); //
    StringBuilder stbTextAllTemp = new StringBuilder(stbTextAll); //
    if (this.isTransfer) {
      strFindText = Util.transfer(strFindText);
      strReplaceText = Util.transfer(strReplaceText);
    }
    StringBuilder stbFindTextTemp = new StringBuilder(strFindText);
    if (strFindText != null && strFindText.length() > 0) {
      int caretPos = 0; // ��ǰ���ĸ�����ֵ��ʼ�����ַ���
      int index = 0;
      int times = 0; // ѭ������
      int oldPos = this.txaSource.getCaretPosition(); // �滻֮ǰ�ı���Ĳ����λ��
      int newPos = oldPos; // �滻֮��Ĳ����λ��
      int offset = strFindText.length() - strReplaceText.length(); // �������滻���ַ������ȵĲ�ֵ
      if (this.isIgnoreCase) {
        stbFindTextTemp = new StringBuilder(stbFindTextTemp.toString()
            .toLowerCase());
        stbTextAllTemp = new StringBuilder(stbTextAllTemp.toString()
            .toLowerCase());
      }
      while (caretPos >= 0) {
        index = stbTextAllTemp.indexOf(stbFindTextTemp.toString(), caretPos);
        if (index >= 0) {
          stbTextAll.replace(index, index + stbFindTextTemp.length(),
              strReplaceText);
          caretPos = index + strReplaceText.length();
          if (caretPos < oldPos) {
            newPos -= offset;
          }
          stbTextAllTemp = new StringBuilder(stbTextAll); //
          if (this.isIgnoreCase) {
            stbTextAllTemp = new StringBuilder(stbTextAllTemp.toString()
                .toLowerCase());
          }
        } else {
          break;
        }
        times++;
      }
      if (times > 0) {
        this.txaSource.setText(stbTextAll.toString());
        this.txaSource.setCaretPosition(Util.checkCaretPosition(this.txaSource,
            newPos));
        JOptionPane.showMessageDialog(this, "���滻 " + times + " ����",
            Util.SOFTWARE, JOptionPane.NO_OPTION);
      } else {
        JOptionPane.showMessageDialog(this, "�Ҳ���\"" + this.strFind + "\"",
            Util.SOFTWARE, JOptionPane.NO_OPTION);
      }
    }
  }

  /**
   * "ͳ�ƴ���"�Ĵ�����
   */
  private void getTextCount() {
    if (this.strFind == null || this.strFind.isEmpty()) {
      return;
    }
    String strText = this.txaSource.getText();
    String strFindTemp = this.strFind;
    if (this.isTransfer) {
      strFindTemp = Util.transfer(strFindTemp);
    }
    if (this.isIgnoreCase) {
      strFindTemp = strFindTemp.toLowerCase();
      strText = strText.toLowerCase();
    }
    int index = strText.indexOf(strFindTemp);
    int times = 0; // �ַ������ִ���
    while (index >= 0) {
      index = strText.indexOf(strFindTemp, index + strFindTemp.length());
      times++;
    }
    JOptionPane.showMessageDialog(this, "���ҵ� " + times + " ����", Util.SOFTWARE,
        JOptionPane.NO_OPTION);
  }

  /**
   * ���ı���Ĺ�귢���仯ʱ���������¼�
   */
  public void caretUpdate(CaretEvent e) {
    // ����
    if (this.txtFindTextF.equals(e.getSource())) {
      this.strFind = this.txtFindTextF.getText();
      if (this.strFind.isEmpty()) {
        this.btnFindF.setEnabled(false);
        this.btnCountF.setEnabled(false);
      } else {
        this.btnFindF.setEnabled(true);
        this.btnCountF.setEnabled(true);
      }
    }
    // �滻
    else if (this.txtFindTextR.equals(e.getSource())) {
      this.strFind = this.txtFindTextR.getText();
      if (this.strFind.isEmpty()) {
        this.btnFindR.setEnabled(false);
        this.btnReplaceR.setEnabled(false);
        this.btnReplaceAllR.setEnabled(false);
      } else {
        this.btnFindR.setEnabled(true);
        this.btnReplaceR.setEnabled(true);
        this.btnReplaceAllR.setEnabled(true);
      }
    }
  }

  /**
   * ��ѡ��ı䵱ǰ��ͼʱ����
   */
  public void stateChanged(ChangeEvent e) {
    if (this.tpnMain.getSelectedIndex() == 0) {
      this.setTitle(this.tpnMain.getTitleAt(0));
      this.txtFindTextF.setText(this.strFind);
      this.txtFindTextF.selectAll();
    } else if (this.tpnMain.getSelectedIndex() == 1) {
      this.setTitle(this.tpnMain.getTitleAt(1));
      this.txtFindTextR.setText(this.strFind);
      this.txtFindTextR.selectAll();
    }
  }
}
