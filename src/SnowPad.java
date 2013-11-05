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

  /**
   * ���������ڣ���������ʱָ�����򿪵��ļ���������Ϊ���
   * 
   * @param args
   *          �����в������磺java -jar SnowPad.jar test1.pl test2.pl��
   *          ��ʾ�򿪵�ǰĿ¼�е�test1.pl��test2.pl�ļ�
   */
  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(Util.SYSTEM_LOOK_AND_FEEL_CLASS_NAME);
        } catch (Exception x) {
          x.printStackTrace();
        }
        Util.setDefaultFont();
        System.setProperty("java.awt.im.style", "on-the-spot"); // ȥ���ı�����������ʱ�����������봰��
        new SnowPadFrame(args); // ��ʼ�������ͬʱ���ļ�
      }
    });
  }
}
