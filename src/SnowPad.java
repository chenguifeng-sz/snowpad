package com.xiboliya.snowpad;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * �����������
 * 
 * @author ��ԭ
 * 
 */
public class SnowPad {
  static String strFile = null; // ��ʾ�ļ�·�����ַ���

  /**
   * ����������
   * 
   * @param args
   *          �����в������磺java -jar SnowPad.jar ../test.pl����ʾ�򿪵�ǰĿ¼�ĸ�Ŀ¼�е�test.pl�ļ�
   */
  public static void main(String[] args) {
    if (args.length > 0) {
      strFile = args[0]; // ͨ����������������ʱ���ɴ�һ���ļ�·���Ĳ���
    }
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(Util.SYSTEM_LOOK_AND_FEEL_CLASS_NAME);
        } catch (Exception x) {
          x.printStackTrace();
        }
        Util.setDefaultFont();
        new SnowPadFrame(strFile); // ��ʼ�������ͬʱ���ļ�
      }
    });
  }
}
