package com.xiboliya.snowpad;

/**
 * ���ڱ�ʶ���з���ʽ��ö��
 * 
 * @author chen
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
