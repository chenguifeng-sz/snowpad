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
 * ���ڱ�ʶ���з���ʽ��ö��
 * 
 * @author ��ԭ
 * 
 */
public enum LineSeparator {
  /**
   * ��ǰ����ϵͳ���зָ���
   */
  DEFAULT,
  /**
   * Unix/Linux����ϵͳ���зָ���
   */
  UNIX,
  /**
   * Macintosh����ϵͳ���зָ���
   */
  MACINTOSH,
  /**
   * Windows����ϵͳ���зָ���
   */
  WINDOWS;
  /**
   * ��д����ķ���
   */
  public String toString() {
    switch (this) {
    case UNIX:
      return "\n";
    case MACINTOSH:
      return "\r";
    case WINDOWS:
      return "\r\n";
    case DEFAULT:
    default:
      return Util.LINE_SEPARATOR;
    }
  }

  /**
   * ��ȡ���з���ʽ������
   * 
   * @return ���з���ʽ������
   */
  public String getName() {
    switch (this) {
    case UNIX:
      return "Unix/Linux";
    case MACINTOSH:
      return "Macintosh";
    case WINDOWS:
      return "Windows";
    default:
      if (Util.LINE_SEPARATOR.equals("\n")) {
        return "Unix/Linux";
      } else if (Util.LINE_SEPARATOR.equals("\r")) {
        return "Macintosh";
      } else {
        return "Windows";
      }
    }
  }
}
