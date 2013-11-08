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

/**
 * ���ڱ�ʶ�ļ������ʽ��ö��
 * 
 * @author ��ԭ
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
