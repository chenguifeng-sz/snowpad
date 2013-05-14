package com.xiboliya.snowpad;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 * "��"�ļ�ѡ����
 * 
 * @author ��ԭ
 * 
 */
public class OpenFileChooser extends JFileChooser {
  private static final long serialVersionUID = 1L;

  public OpenFileChooser() {
    super();
    Util.addChoosableFileFilters(this);
  }

  /**
   * ���û�ȷ��ʱ�����ô˷���
   */
  public void approveSelection() {
    File file = this.getSelectedFile();
    FileFilter fileFilter = this.getFileFilter(); // ��ȡ��ǰ���ļ�������
    if (fileFilter instanceof BaseFileFilter) { // ���⵱ǰΪĬ�Ϲ�����ʱ���������쳣
      BaseFileFilter baseFileFilter = (BaseFileFilter) fileFilter;
      file = Util.checkFileName(file.getAbsolutePath(), baseFileFilter,
          baseFileFilter.getExt());
    }
    if (file != null && file.exists()) {
      this.setSelectedFile(file);
      super.approveSelection();
    } else { // ���û�δѡ���ļ���ѡ����ļ�������ʱ����������ʾ��
      JOptionPane.showMessageDialog(this, "�ļ������ڣ�������ѡ��", Util.SOFTWARE,
          JOptionPane.CANCEL_OPTION);
    }
  }
}
