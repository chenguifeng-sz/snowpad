package com.xiboliya.snowpad;

import javax.swing.InputMap;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.undo.UndoManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * ʵ�ֳ������������Ҽ���ݲ˵���JTextArea�ؼ�
 * 
 * @author ��ԭ
 * 
 */
public class BaseTextArea extends JTextArea {
  private static final long serialVersionUID = 1L;
  private int newFileIndex = 1; // �½��ļ������
  private File file = null;
  private String title = Util.NEW_FILE_NAME;
  private LinkedList<PartnerBean> highlighterList = new LinkedList<PartnerBean>(); // ����ı��������и������������
  private LineSeparator lineSeparator = LineSeparator.DEFAULT; // ���з���ʽ
  private CharEncoding charEncoding = CharEncoding.BASE; // �ַ������ʽ
  private KeyAdapter autoIndentKeyAdapter = null; // �����Զ������ļ���������
  private KeyAdapter tabReplaceKeyAdapter = null; // ���������Կո����Tab���ļ���������
  private Color[] colorStyle = null; // ��ɫ����
  private boolean isSaved = false; // �ļ��Ƿ��ѱ��棬����ѱ�����Ϊtrue
  private boolean isTextChanged = false; // �ı������Ƿ����޸ģ�������޸���Ϊtrue
  private boolean isStyleChanged = false; // �ı���ʽ�Ƿ����޸ģ�������޸���Ϊtrue
  private boolean fileExistsLabel = false; // ���ļ�ɾ�����ƶ������ڱ�ʶ�Ƿ��ѵ�������ʾ��
  private boolean tabReplaceBySpace = false; // �Ƿ��Կո����Tab��
  private boolean autoIndent = false; // �Ƿ���Զ�����
  private boolean isLineNumberView = false; // �Ƿ���ʾ�к���
  private UndoManager undoManager = new UndoManager(); // ����������
  private int undoIndex = Util.DEFAULT_UNDO_INDEX; // ������ʶ������ʼ��ΪĬ��ֵ����ֵ���ı��ʾ�ı����޸�

  /**
   * Ĭ�ϵĹ��췽��
   */
  public BaseTextArea() {
    super();
    this.init();
  }

  public BaseTextArea(Setting setting) {
    this();
    this.loadSetting(setting);
  }

  private void init() {
    this.undoManager.setLimit(-1); // ���ô˳������������ֵ����༭����С��0��ֵ��ʾ�༭���������ƣ�Ĭ��ֵΪ100��
    this.disableShortcut();
    // ��ʼ�������Զ������ļ���������
    this.autoIndentKeyAdapter = new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          toAutoIndent();
        }
      }
    };
    // ��ʼ�����������Կո����Tab���ļ���������
    this.tabReplaceKeyAdapter = new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB) {
          toTabReplace();
        }
      }
    };
  }

  public void loadSetting(Setting setting) {
    if (setting == null) {
      return;
    }
    this.setLineWrap(setting.isLineWrap);
    this.setWrapStyleWord(setting.isWrapStyleWord);
    this.setLineSeparator(setting.lineSeparator);
    this.setCharEncoding(setting.charEncoding);
    this.setFont(setting.font);
    this.setDragEnabled(setting.textDrag);
    this.setAutoIndent(setting.autoIndent);
    this.setTabReplaceBySpace(setting.tabReplaceBySpace);
    this.setColorStyle(setting.colorStyle);
    this.setTabSize(setting.tabSize);
    this.setSaved(setting.isSaved);
    this.setTextChanged(setting.isTextChanged);
    this.setStyleChanged(setting.isStyleChanged);
    this.setFileExistsLabel(setting.fileExistsLabel);
    this.setLineNumberView(setting.isLineNumberView);
  }

  private void disableShortcut() {
    // ����JTextArea�����Ĭ���ȼ���Ctrl+C��Ctrl+H��Ctrl+V��Ctrl+X
    InputMap inputMap = this.getInputMap();
    inputMap.put(
        KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK),
        "CTRL_C");
    inputMap.put(
        KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK),
        "CTRL_H");
    inputMap.put(
        KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK),
        "CTRL_V");
    inputMap.put(
        KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK),
        "CTRL_X");
  }

  /**
   * ���س���ʱ��������
   */
  private void toAutoIndent() {
    CurrentLines currentLines = new CurrentLines(this,
        CurrentLines.LineExtend.EXTEND_UP);
    String strContentExtend = currentLines.getStrContentExtend();
    if (strContentExtend == null) {
      return;
    }
    int currentIndex = currentLines.getCurrentIndex();
    if (this.getText().charAt(currentIndex - 1) != '\n') { // ������ǻ��в���������������
      return;
    }
    String strSpace = "";
    for (int i = 0; i < strContentExtend.length(); i++) {
      switch (strContentExtend.charAt(i)) {
      case ' ':
      case '\t':
      case '��':
        strSpace += strContentExtend.charAt(i);
        break;
      default:
        break;
      }
      if (strSpace.length() == i) {
        break;
      }
    }
    if (!strSpace.isEmpty()) {
      this.insert(strSpace, this.getCaretPosition());
    }
  }

  /**
   * ��Tab��ʱ�����滻Ϊ�����Ŀո�
   */
  private void toTabReplace() {
    int currentIndex = this.getCaretPosition();
    if (this.getText().charAt(currentIndex - 1) != '\t') { // �ı����������ǰһ���ַ��Ƿ�ΪTab
      return;
    }
    int tabSize = this.getTabSize();
    String strSpace = "";
    for (int i = 0; i < tabSize; i++) {
      strSpace += " ";
    }
    this.replaceRange(strSpace, currentIndex - 1, currentIndex);
  }

  public void setFile(File file) {
    if (file != null) {
      try {
        this.file = file.getCanonicalFile(); // ��ȡ�˳���·�����Ĺ淶��ʽ
        this.setTitle(this.file.getName());
      } catch (IOException x) {
        x.printStackTrace();
      }
    } else {
      this.file = file;
    }
  }

  public File getFile() {
    return this.file;
  }

  public String getFileName() {
    if (this.file != null) {
      return file.getAbsolutePath();
    }
    return null;
  }

  public void setTitle(String title) {
    if (title != null) {
      this.title = title;
    }
  }

  public String getTitle() {
    return this.title;
  }

  public LinkedList<PartnerBean> getHighlighterList() {
    return this.highlighterList;
  }

  public void setLineSeparator(LineSeparator lineSeparator) {
    this.lineSeparator = lineSeparator;
  }

  public LineSeparator getLineSeparator() {
    return this.lineSeparator;
  }

  public void setCharEncoding(CharEncoding charEncoding) {
    this.charEncoding = charEncoding;
  }

  public CharEncoding getCharEncoding() {
    return this.charEncoding;
  }

  public void setSaved(boolean isSaved) {
    this.isSaved = isSaved;
  }

  public boolean getSaved() {
    return this.isSaved;
  }

  public void setTextChanged(boolean isTextChanged) {
    this.isTextChanged = isTextChanged;
  }

  public boolean getTextChanged() {
    return this.isTextChanged;
  }

  public void setStyleChanged(boolean isStyleChanged) {
    this.isStyleChanged = isStyleChanged;
  }

  public boolean getStyleChanged() {
    return this.isStyleChanged;
  }

  public void setFileExistsLabel(boolean fileExistsLabel) {
    this.fileExistsLabel = fileExistsLabel;
  }

  public boolean getFileExistsLabel() {
    return this.fileExistsLabel;
  }

  public void setColorStyle(Color[] colorStyle) {
    if (colorStyle == null) {
      return;
    }
    this.colorStyle = colorStyle;
    this.setForeground(colorStyle[0]);
    this.setBackground(colorStyle[1]);
    this.setCaretColor(colorStyle[2]);
    this.setSelectedTextColor(colorStyle[3]);
    this.setSelectionColor(colorStyle[4]);
  }

  public Color[] getColorStyle() {
    return this.colorStyle;
  }

  public void setAutoIndent(boolean enable) {
    if (enable) {
      this.addKeyListener(this.autoIndentKeyAdapter);
    } else {
      this.removeKeyListener(this.autoIndentKeyAdapter);
    }
    this.autoIndent = enable;
  }

  public boolean getAutoIndent() {
    return this.autoIndent;
  }

  public void setTabReplaceBySpace(boolean enable) {
    if (enable) {
      this.addKeyListener(this.tabReplaceKeyAdapter);
    } else {
      this.removeKeyListener(this.tabReplaceKeyAdapter);
    }
    this.tabReplaceBySpace = enable;
  }

  public boolean getTabReplaceBySpace() {
    return this.tabReplaceBySpace;
  }

  public UndoManager getUndoManager() {
    return this.undoManager;
  }

  public int getUndoIndex() {
    return this.undoIndex;
  }

  public void setUndoIndex(int undoIndex) {
    this.undoIndex = undoIndex;
  }

  public void setNewFileIndex(int newFileIndex) {
    this.newFileIndex = newFileIndex;
  }

  public int getNewFileIndex() {
    return this.newFileIndex;
  }

  public boolean getLineNumberView() {
    return this.isLineNumberView;
  }

  public void setLineNumberView(boolean isLineNumberView) {
    this.isLineNumberView = isLineNumberView;
  }
}
