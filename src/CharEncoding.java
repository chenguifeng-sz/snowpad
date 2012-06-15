package com.xiboliya.snowpad;

/**
 * ���ڱ�ʶ�ļ������ʽ��ö��
 * 
 * @author chen
 * 
 */
public enum CharEncoding {
  /**
   * ANSI��ʽ����
   */
  ANSI,
  /**
   * Ĭ�ϸ�ʽ����
   */
  BASE,
  /**
   * Unicode Big Endian��ʽ����
   */
  UBE,
  /**
   * Unicode Little Endian��ʽ����
   */
  ULE,
  /**
   * UTF-8��ʽ����
   */
  UTF8,
  /**
   * UTF-8��BOM��ʽ����
   */
  UTF8_NO_BOM;
  /**
   * ��д����ķ���
   */
  public String toString() {
    switch (this) {
    case ANSI:
      return "US-ASCII";
    case UBE:
      return "UTF-16BE";
    case ULE:
      return "UTF-16LE";
    case UTF8:
    case UTF8_NO_BOM:
      return "UTF-8";
    case BASE:
    default:
      return "GB18030";
    }
  }

  /**
   * ��ȡ�����ʽ������
   * 
   * @return �����ʽ������
   */
  public String getName() {
    switch (this) {
    case ANSI:
      return "ANSI";
    case UBE:
      return "Unicode Big Endian";
    case ULE:
      return "Unicode Little Endian";
    case UTF8:
      return "UTF-8";
    case UTF8_NO_BOM:
      return "UTF-8 No BOM";
    case BASE:
    default:
      return "GB18030";
    }
  }
}
