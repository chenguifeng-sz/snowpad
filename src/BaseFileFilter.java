package com.xiboliya.snowpad;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * �����õ��ļ�������
 * 
 * @author chen
 * 
 */
public class BaseFileFilter extends FileFilter {
  private String ext = ""; // �ļ���չ��
  private String description = ""; // ��������
  private boolean isAcceptDirectory = true; // �Ƿ���ʾĿ¼�������ʾ��Ϊtrue

  public BaseFileFilter(String ext, String description) {
    this(ext, description, true);
  }

  public BaseFileFilter(String ext, String description,
      boolean isAcceptDirectory) {
    this.ext = ext;
    this.description = description;
    this.isAcceptDirectory = isAcceptDirectory;
  }

  public boolean accept(File file) {
    if (this.isAcceptDirectory && file.isDirectory()) { // ��ʾĿ¼
      return true;
    } else if (file.isFile()
        && file.getName().toLowerCase().endsWith(this.ext.toLowerCase())) { // ��ʾָ����չ�����ļ�
      return true;
    } else {
      return false;
    }
  }

  public String getDescription() {
    return this.description; // �����ļ�ѡ��������ʾ����������
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }

  public String getExt() {
    return this.ext;
  }
}
