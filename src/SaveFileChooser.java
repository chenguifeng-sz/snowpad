package com.xiboliya.snowpad;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 * "����"�ļ�ѡ����
 * 
 * @author chen
 * 
 */
public class SaveFileChooser extends JFileChooser {
  private static final long serialVersionUID = 1L;

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
    this.setSelectedFile(file);
    if (null != file && file.exists()) { // ���û�ѡ����ļ��Ѿ�����ʱ����������ʾ��
      int result = JOptionPane.showConfirmDialog(this, file + " �Ѵ��ڡ�\n�Ƿ񸲸ǣ�",
          "����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (JOptionPane.YES_OPTION == result) { // �û�ѡ�񸲸�
        super.approveSelection();
      }
    } else {
      super.approveSelection();
    }
  }
}
