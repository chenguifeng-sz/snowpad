package com.xiboliya.snowpad;

import java.awt.Color;
import java.awt.Font;

/**
 * ���ڳ�ʼ���ı�������������ࡣ
 * 
 * @author chen
 * 
 */
public class Setting {
  public boolean isLineWrap = true; // �Ƿ��Զ�����
  public boolean isWrapStyleWord = true; // �Ƿ񵥴ʱ߽绻��
  public LineSeparator lineSeparator = LineSeparator.DEFAULT; // ���з���ʽ
  public CharEncoding charEncoding = CharEncoding.BASE; // �ַ������ʽ
  public Font font = Util.TEXT_FONT; // �ı�������
  public boolean textDrag = false; // �Ƿ����ק�ı�
  public boolean autoIndent = false; // �Ƿ���Զ�����
  public boolean tabReplaceBySpace = false; // �Ƿ��Կո����Tab��
  public Color[] colorStyle = null; // ��ɫ����
  public int tabSize = Util.DEFAULT_TABSIZE; // Tab����ռ�ַ���
  public boolean isSaved = false; // �ļ��Ƿ��ѱ��棬����ѱ�����Ϊtrue
  public boolean isTextChanged = false; // �ı������Ƿ����޸ģ�������޸���Ϊtrue
  public boolean isStyleChanged = false; // �ı���ʽ�Ƿ����޸ģ�������޸���Ϊtrue
  public boolean fileExistsLabel = false; // ���ļ�ɾ�����ƶ������ڱ�ʶ�Ƿ��ѵ�������ʾ��
}
