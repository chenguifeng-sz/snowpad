package com.xiboliya.snowpad;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 * ��ʾ��ǰ�е�������
 * 
 * @author ��ԭ
 * 
 */
public class CurrentLine {
  private JTextArea txaSource = null; // ��ǰ�����ڵ��ı���
  private int lineNum = -1; // ��ǰ�к�
  private int startIndex = -1; // ��ǰ���׵�ƫ����
  private int endIndex = -1; // ��ǰ��β��ƫ����
  private int currentIndex = -1; // ��ǰ����ƫ����
  private String strLine = null; // ��ǰ�е��ı�

  /**
   * ���췽��
   * 
   * @param txaSource
   *          ��ǰ���ı���
   */
  public CurrentLine(JTextArea txaSource) {
    this.txaSource = txaSource;
    this.init();
  }

  /**
   * ��ʼ����������ֵ
   */
  private void init() {
    if (this.txaSource == null) {
      return;
    }
    try {
      // ��ȡ��ǰ����ƫ����
      this.currentIndex = this.txaSource.getCaretPosition();
      // ��ȡָ��ƫ���������кţ������кŵ�ȡֵ��Χ��x>=0 && x<�ı���������
      this.lineNum = this.txaSource.getLineOfOffset(this.currentIndex);
      // ��ȡָ������ʼ����ƫ������ָ���кŵ�ȡֵ��Χ��x>=0 && x<�ı���������
      this.startIndex = this.txaSource.getLineStartOffset(this.lineNum);
      // ��ȡָ���н�β����ƫ������ָ���кŵ�ȡֵ��Χ��x>=0 && x<�ı���������
      this.endIndex = this.txaSource.getLineEndOffset(this.lineNum);
      // ��ȡ��ǰ�е��ı�
      this.strLine = this.txaSource.getText().substring(this.startIndex,
          this.endIndex);
    } catch (BadLocationException x) {
      x.printStackTrace();
    }
  }

  /**
   * ��ȡ��ǰ���׵�ƫ����
   * 
   * @return ƫ����
   */
  public int getStartIndex() {
    return this.startIndex;
  }

  /**
   * ��ȡ��ǰ��β��ƫ����
   * 
   * @return ƫ����
   */
  public int getEndIndex() {
    return this.endIndex;
  }

  /**
   * ��ȡ��ǰ����ƫ����
   * 
   * @return ƫ����
   */
  public int getCurrentIndex() {
    return this.currentIndex;
  }

  /**
   * ��ȡ��ǰ�к�
   * 
   * @return ��ǰ�к�
   */
  public int getLineNum() {
    return this.lineNum;
  }

  /**
   * ��ȡ��ǰ�е��ı�
   * 
   * @return �ı�
   */
  public String getStrLine() {
    return this.strLine;
  }
}
