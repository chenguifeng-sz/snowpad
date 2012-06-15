package com.xiboliya.snowpad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * "�����ַ�"�Ի���
 * 
 * @author chen
 * 
 */
public class InsertCharDialog extends BaseDialog implements ActionListener,
    FocusListener {
  private static final long serialVersionUID = 1L;
  private JPanel pnlMain = (JPanel) this.getContentPane();
  private JPanel pnlLeft = new JPanel(new BorderLayout());
  private JPanel pnlRight = new JPanel(null);
  private JTabbedPane tpnMain = new JTabbedPane();
  private GridLayout gridLayout = new GridLayout(Util.INSERT_MAX_ROW,
      Util.INSERT_MAX_COLUMN, 0, 0);
  private JButton btnOk = new JButton("����");
  private JButton btnCancel = new JButton("�ر�");
  private JLabel lblView = new JLabel();
  private JTextArea txaSource = null;
  private BaseKeyAdapter keyAdapter = new BaseKeyAdapter(this);

  /**
   * ���췽��
   * 
   * @param owner
   *          ������ʾ�öԻ���ĸ����
   * @param modal
   *          �Ƿ�Ϊģʽ�Ի���
   * @param txaSource
   *          ��Բ������ı���
   * @param hashtable
   *          ������ʾ�ַ��Ĺ�ϣ����Ϊ��ǩ��ֵΪ�ñ�ǩ�µ��ַ�����
   */
  public InsertCharDialog(JFrame owner, boolean modal, JTextArea txaSource,
      Hashtable<String, String> hashtable) {
    super(owner, modal);
    if (txaSource == null) {
      return;
    }
    this.txaSource = txaSource;
    this.init();
    this.addListeners();
    this.setSize(340, 275);
    this.fillTabbedPane(hashtable);
    this.setVisible(true);
  }

  /**
   * ��ʼ������
   */
  private void init() {
    this.setTitle("�����ַ�");
    this.pnlMain.setLayout(null);
    this.pnlLeft.setBounds(0, 0, 230, 245);
    this.pnlRight.setBounds(230, 0, 110, 240);
    this.pnlMain.add(this.pnlLeft);
    this.pnlMain.add(this.pnlRight);
    this.pnlLeft.add(this.tpnMain, BorderLayout.CENTER);
    this.btnOk.setBounds(10, 30, 85, Util.BUTTON_HEIGHT);
    this.btnCancel.setBounds(10, 70, 85, Util.BUTTON_HEIGHT);
    this.lblView.setBounds(6, 125, 96, 96);
    this.lblView.setBorder(new EtchedBorder());
    this.lblView.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblView.setOpaque(true);
    this.pnlRight.add(this.btnOk);
    this.pnlRight.add(this.btnCancel);
    this.pnlRight.add(this.lblView);
    this.tpnMain.setFocusable(false);
    this.lblView.setFont(Util.VIEW_FONT);
    this.btnOk.setFocusable(false);
    this.btnCancel.setFocusable(false);
  }

  /**
   * ������б�ǩҳ���ַ�
   * 
   * @param hashtable
   *          ������ʾ�ַ��Ĺ�ϣ����Ϊ��ǩ��ֵΪ�ñ�ǩ�µ��ַ�����
   */
  private void fillTabbedPane(Hashtable<String, String> hashtable) {
    if (hashtable.isEmpty()) {
      return;
    }
    Enumeration<String> enumeration = hashtable.keys();
    while (enumeration.hasMoreElements()) {
      String strTitle = enumeration.nextElement();
      String strElement = hashtable.get(strTitle);
      this.fillElements(strElement, strTitle);
    }
  }

  /**
   * ���һ����ǩҳ���ַ�
   * 
   * @param strElement
   *          �ַ�����
   * @param strTitle
   *          ��ǩҳ����
   */
  private void fillElements(String strElement, String strTitle) {
    if (strElement == null || strTitle == null || strElement.isEmpty()
        || strTitle.isEmpty()) {
      return;
    }
    JPanel pnlTemp = new JPanel(this.gridLayout);
    int elementCount = strElement.length();
    if (elementCount > Util.INSERT_MAX_ELEMENT) {
      elementCount = Util.INSERT_MAX_ELEMENT;
    }
    int index = 0;
    for (; index < elementCount; index++) {
      char charElement = strElement.charAt(index);
      JLabel lblElement = this.createElement(String.valueOf(charElement));
      pnlTemp.add(lblElement);
    }
    for (; index < Util.INSERT_MAX_ELEMENT; index++) {
      JLabel lblElement = this.createElement("");
      pnlTemp.add(lblElement);
    }
    this.tpnMain.add(pnlTemp, strTitle);
  }

  /**
   * ����һ���ı���ǩ
   * 
   * @param strElement
   *          ��ʾ���ַ�
   * @return �´������ı���ǩ
   */
  private JLabel createElement(String strElement) {
    JLabel lblElement = new JLabel(strElement);
    if (!strElement.isEmpty()) {
      lblElement.setHorizontalAlignment(SwingConstants.CENTER);
      lblElement.setFocusable(true); // ���ñ�ǩ���Ի�ý���
      lblElement.setOpaque(true); // ���ñ�ǩ���Ի��Ʊ���
      lblElement.setBorder(new EtchedBorder());
      lblElement.setBackground(Color.WHITE);
      lblElement.addKeyListener(this.keyAdapter);
      lblElement.addFocusListener(this);
      lblElement.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JLabel lblTemp = (JLabel) e.getSource();
          lblTemp.requestFocus(); // ����굥��ʱ����ý���
          if (e.getClickCount() == 2) {
            onEnter();
          }
        }
      });
    }
    return lblElement;
  }

  /**
   * Ԥ����ǰѡ�е��ַ�
   * 
   * @param strView
   *          ��ǰѡ���ı���ǩ���ַ�
   */
  private void setView(String strView) {
    this.lblView.setText(strView);
  }

  /**
   * ����¼�������
   */
  private void addListeners() {
    this.btnOk.addActionListener(this);
    this.btnCancel.addActionListener(this);
  }

  /**
   * Ϊ���������¼��Ĵ�����
   */
  public void actionPerformed(ActionEvent e) {
    if (this.btnOk.equals(e.getSource())) {
      this.onEnter();
    } else if (this.btnCancel.equals(e.getSource())) {
      this.onCancel();
    }
  }

  /**
   * Ĭ�ϵ�"ȷ��"��������
   */
  public void onEnter() {
    this.txaSource.replaceSelection(this.lblView.getText());
  }

  /**
   * Ĭ�ϵ�"ȡ��"��������
   */
  public void onCancel() {
    this.dispose();
  }

  /**
   * ���ı���ǩ��ý���ʱ�����������¼�
   */
  public void focusGained(FocusEvent e) {
    JLabel lblTemp = (JLabel) e.getSource();
    lblTemp.setBackground(Color.PINK);
    this.setView(lblTemp.getText());
  }

  /**
   * ���ı���ǩʧȥ����ʱ�����������¼�
   */
  public void focusLost(FocusEvent e) {
    JLabel lblTemp = (JLabel) e.getSource();
    lblTemp.setBackground(Color.WHITE);
  }
}
