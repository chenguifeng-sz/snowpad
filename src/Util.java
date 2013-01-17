package com.xiboliya.snowpad;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Enumeration;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.JTextComponent;

/**
 * ʵ�ù����࣬���������õĸ������Ժͷ��������Ϊfinal���ͣ�ʹ���಻�ɱ��̳�
 * 
 * @author chen
 * 
 */
public final class Util {
  public static final String SOFTWARE = "��ѩ���±�"; // �������
  public static final String VERSION = "V2.2"; // ����汾��
  public static final String TXT_EXT = ".txt"; // txt�ļ�����չ��
  public static final String OS_NAME = System.getProperty("os.name", "Windows"); // ��ǰ����ϵͳ������
  public static final String FILE_SEPARATOR = System.getProperty(
      "file.separator", "/"); // ��ǰ����ϵͳ���ļ��ָ���
  public static final String LINE_SEPARATOR = System.getProperty(
      "line.separator", "\n"); // ��ǰ����ϵͳ���зָ���
  public static final String FILE_HISTORY = "FileHistory"; // ���ڱ�ʶ����༭���ļ�
  public static final String INSERT_SPECIAL = "�|�}�~�����������졨����I�Z�Y�G�ѡ���������������������嗀�����������ߩh�i�l�m�j�k���������I�J�L�K�ΨO���ܨM����שߩϩǩ������������w�u�v"; // �������
  public static final String INSERT_PUNCTUATION = "�����������������U���E��F���������o�p�q?�r�s�t�u���C�򡪦����n������������񡲡���㡾��������硴����塸����顺�����v�w�x�y�z�{�������������A�@��"; // ������
  public static final String INSERT_MATH = "�֡ԡ٣��ܡݣ����ڡۡ��������£��ҡӡءޡġšơǡȡɡʡߡ�ˡ͡ΡϡСաס̨Q�R�P�������������N�S�S�R"; // ��ѧ����
  public static final String INSERT_UNIT = "����磤����꣥��H�����멈�T�L�M�N�Q�O�J�K�P��"; // ��λ����
  public static final String INSERT_DIGIT = "�����������������������������������¢âĢŢƢǢȢɢʢˢ̢͢΢ϢТѢҢӢԢբ֢עآ٢ڢۢܢݢޢߢ���������������������������������������������������"; // ���ַ���
  public static final String INSERT_PINYIN = "����������������������������������������������������������������"; // ƴ������
  public static final String CTRL_Z = "Ctrl+Z"; // ��ϼ�Ctrl+Z���ַ���
  public static final String CTRL_Y = "Ctrl+Y"; // ��ϼ�Ctrl+Y���ַ���
  public static final String TEXT_PREFIX = "*"; // �ļ��ı��޸ĵı�������ʶ��
  public static final String STYLE_PREFIX = "��"; // �ļ���ʽ�޸ĵı�������ʶ��
  public static final String STATE_CHARS = "Chars:"; // ״̬����ʾ��Ϣ-�ı����ַ���
  public static final String STATE_LINES = "Lines:"; // ״̬����ʾ��Ϣ-�ı�������
  public static final String STATE_CUR_LINE = "Ln:"; // ״̬����ʾ��Ϣ-��굱ǰ�к�
  public static final String STATE_CUR_COLUMN = "Col:"; // ״̬����ʾ��Ϣ-��굱ǰ�к�
  public static final String STATE_CUR_SELECT = "Sel:"; // ״̬����ʾ��Ϣ-��ǰѡ����ַ���
  public static final String STATE_LINE_STYLE = "LineStyle:"; // ״̬����ʾ��Ϣ-��ǰ���з���ʽ
  public static final String STATE_ENCODING = "Encoding:"; // ״̬����ʾ��Ϣ-��ǰ�����ʽ
  public static final String SIGN_CHARS_VIEW = "__________\n__________\n__________\n__________\n__________"; // �б�������Ŵ��ڵ�Ԥ������ĳ�ʼ���ַ���
  public static final String SIGN_CHARS = "�|���������ѡ��������������������"; // �б����
  public static final String IDENTIFIER_CHARS = "012"; // �б������ͱ�ʶ��
  public static final String[] FONT_FAMILY_NAMES = java.awt.GraphicsEnvironment
      .getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // ��ȡϵͳ��������������б�
  public static final String[] FILE_ENCODINGS = new String[] { "�Զ����",
      CharEncoding.ANSI.getName(), CharEncoding.UBE.getName(),
      CharEncoding.ULE.getName(), CharEncoding.UTF8.getName(),
      CharEncoding.UTF8_NO_BOM.getName(), CharEncoding.BASE.getName() }; // ѡ������ʽ������
  public static final String[] DATE_STYLES = new String[] { "yyyy-MM-dd",
      "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss:SSS", "yyyy-MM-dd KK:mm:ss",
      "yyyy-MM-dd KK:mm:ss a", "yyyy-MM-dd HH:mm:ss E",
      "yyyy-MM-dd HH:mm:ss zZ", "yyyy��MM��dd�� HHʱmm��ss��",
      "G yyyy-MM-dd HH:mm:ss E zZ", "yy-M-d H:m:s", "yyyy/MM/dd HH:mm:ss",
      "yyyy.MM.dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd", "yyyy.MM.dd",
      "yy/MM/dd", "HH:mm:ss", "KK:mm:ss a", "HH:mm:ss:SSS" }; // ʱ��/���ڸ�ʽ�ַ���
  public static final String[] SIGN_IDENTIFIER_NAMES = new String[] {
      "ʮ������(1.2..10.11.)", "Сдʮ��������(1.2..a.b.)", "��дʮ��������(1.2..A.B.)" }; // �б������͵���ʾ����
  public static final int INPUT_HEIGHT = 22; // ���������ĸ߶�
  public static final int VIEW_HEIGHT = 18; // ��ǩ����ѡ��ť����ѡ��ĸ߶�
  public static final int BUTTON_HEIGHT = 23; // ��ť�ĸ߶�
  public static final int BUFFER_LENGTH = 1024; // �������Ĵ�С
  public static final int MIN_FONT_SIZE = 8; // ������Сֵ
  public static final int MAX_FONT_SIZE = 100; // �������ֵ
  public static final int MIN_TABSIZE = 1; // Tab�ַ���Сֵ
  public static final int MAX_TABSIZE = 99; // Tab�ַ����ֵ
  public static final int DEFAULT_TABSIZE = 4; // Tab�ַ�Ĭ��ֵ
  public static final int FILE_HISTORY_MAX = 10; // ����༭�ļ������洢����
  public static final int DEFAULT_UNDO_INDEX = 0; // ������ʶ����Ĭ��ֵ
  public static final int INSERT_MAX_ROW = 10; // �����ַ�������������
  public static final int INSERT_MAX_COLUMN = 10; // �����ַ�������������
  public static final int INSERT_MAX_ELEMENT = INSERT_MAX_ROW
      * INSERT_MAX_COLUMN; // �����ַ���������Ԫ����
  public static final int SIGN_MAX_ROW = 5; // �б�������Ž�����������
  public static final int SIGN_MAX_COLUMN = 4; // �б�������Ž�����������
  public static final int SIGN_MAX_ELEMENT = SIGN_MAX_ROW * SIGN_MAX_COLUMN; // �б�������Ž�������Ԫ����
  public static final Color COLOR_HIGHLIGHT_1 = new Color(255, 0, 0, 40); // ���ڸ�����ʾ����ɫ1,���е�4��������ʾ͸���ȣ���ֵԽСԽ͸��
  public static final Color COLOR_HIGHLIGHT_2 = new Color(0, 255, 0, 40); // ���ڸ�����ʾ����ɫ2
  public static final Color COLOR_HIGHLIGHT_3 = new Color(0, 0, 255, 40); // ���ڸ�����ʾ����ɫ3
  public static final Color COLOR_HIGHLIGHT_4 = new Color(0, 255, 255, 40); // ���ڸ�����ʾ����ɫ4
  public static final Color COLOR_HIGHLIGHT_5 = new Color(255, 0, 255, 40); // ���ڸ�����ʾ����ɫ5
  public static final Font GLOBAL_FONT = new Font("����", Font.PLAIN, 12); // ȫ�ֵ�Ĭ������
  public static final Font TEXT_FONT = new Font("����", Font.PLAIN, 14); // �ı����Ĭ������
  public static final Font INSERT_VIEW_FONT = new Font("����", Font.PLAIN, 80); // �����ַ�������Ԥ����ǩ������
  public static final Font SIGN_VIEW_FONT = new Font("����", Font.PLAIN, 28); // �б�������Ž�����Ԥ�����������

  /**
   * ���ڴ���Ϊ�����࣬�ʽ����췽��˽�л�
   */
  private Util() {
  }

  /**
   * ��ȡ�ı����е�ǰѡ���ڵ�������
   * 
   * @param txaSource
   *          �ض����ı���
   * @return ���浱ǰѡ���������е��ַ�����
   */
  public static String[] getCurrentLinesArray(JTextArea txaSource) {
    if (txaSource == null) {
      return null;
    }
    int lineCount = txaSource.getLineCount();
    CurrentLines currentLines = new CurrentLines(txaSource);
    int startIndex = currentLines.getStartIndex();
    int endIndex = currentLines.getEndIndex();
    int endLineNum = currentLines.getEndLineNum() + 1;
    String strContent = currentLines.getStrContent();
    String strText = txaSource.getText();
    if (strContent.endsWith("\n")
        && (endIndex != strText.length() || (endLineNum == lineCount - 1 && strText
            .endsWith("\n")))) {
      endIndex--;
    }
    txaSource.select(startIndex, endIndex);
    String strSel = txaSource.getSelectedText();
    if (strSel == null) {
      strSel = "";
    }
    return strSel.split("\n", -1); // ����ǰѡ�����ı����д�������ĩβ�Ķദ����
  }

  /**
   * ��ʽ����������ļ���
   * 
   * @param strFileName
   *          �ļ�������·��
   * @param fileFilter
   *          ��ǰ���ļ����͹�����
   * @param strExt
   *          �������ļ�����չ��
   * @return ��ʽ������ļ�
   */
  public static File checkFileName(String strFileName,
      BaseFileFilter fileFilter, String strExt) {
    if (strFileName == null || strFileName.isEmpty() || fileFilter == null
        || strExt == null || strExt.isEmpty()) {
      return null;
    }
    if (fileFilter.getExt().equalsIgnoreCase(strExt)) {
      if (!strFileName.toLowerCase().endsWith(strExt.toLowerCase())) {
        strFileName += strExt;
      }
    }
    return new File(strFileName);
  }

  /**
   * �޸����������Ĭ������
   */
  public static void setDefaultFont() {
    FontUIResource fontRes = new FontUIResource(GLOBAL_FONT);
    Enumeration<Object> keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof FontUIResource) {
        UIManager.put(key, fontRes);
      }
    }
  }

  /**
   * ���ı�����в����ַ���
   * 
   * @param strFindText
   *          ���ҵ��ַ���
   * @param txcSource
   *          �ı����
   * @param isFindDown
   *          �Ƿ����²���
   * @param isIgnoreCase
   *          �Ƿ����ִ�Сд
   * @param isWrap
   *          �Ƿ�ѭ������
   * @return ���ҵ��ַ���λ���ı�����е�����
   */
  public static int findText(String strFindText, JTextComponent txcSource,
      boolean isFindDown, boolean isIgnoreCase, boolean isWrap) {
    if (isFindDown) {
      return findDownText(strFindText, txcSource, isIgnoreCase, isWrap);
    } else {
      return findUpText(strFindText, txcSource, isIgnoreCase, isWrap);
    }
  }

  /**
   * ���ı���������²����ַ���
   * 
   * @param strFindText
   *          ���ҵ��ַ���
   * @param txcSource
   *          �ı����
   * @param isIgnoreCase
   *          �Ƿ����ִ�Сд
   * @param isWrap
   *          �Ƿ�ѭ������
   * @return ���ҵ��ַ���λ���ı�����е�����
   */
  private static int findDownText(String strFindText, JTextComponent txcSource,
      boolean isIgnoreCase, boolean isWrap) {
    if (strFindText == null || txcSource == null || strFindText.isEmpty()
        || txcSource.getText().isEmpty()) {
      return -1;
    }
    int result = -1;
    String strSourceAll = txcSource.getText();
    int caretPos = txcSource.getCaretPosition();
    String strSource = strSourceAll.substring(caretPos);
    if (isIgnoreCase) {
      strFindText = strFindText.toLowerCase();
      strSourceAll = strSourceAll.toLowerCase();
      strSource = strSource.toLowerCase();
    }
    int index = strSource.indexOf(strFindText);
    if (index >= 0) {
      result = caretPos + index;
    } else {
      if (isWrap) {
        result = strSourceAll.indexOf(strFindText);
      }
    }
    return result;
  }

  /**
   * ���ı���������ϲ����ַ���
   * 
   * @param strFindText
   *          ���ҵ��ַ���
   * @param txcSource
   *          �ı����
   * @param isIgnoreCase
   *          �Ƿ����ִ�Сд
   * @param isWrap
   *          �Ƿ�ѭ������
   * @return ���ҵ��ַ���λ���ı�����е�����
   */
  private static int findUpText(String strFindText, JTextComponent txcSource,
      boolean isIgnoreCase, boolean isWrap) {
    if (strFindText == null || txcSource == null || strFindText.isEmpty()
        || txcSource.getText().isEmpty()) {
      return -1;
    }
    int result = -1;
    int caretPos = txcSource.getCaretPosition();
    if (txcSource.getSelectedText() != null) {
      if (isIgnoreCase) {
        if (txcSource.getSelectedText().equalsIgnoreCase(strFindText)) {
          caretPos -= strFindText.length();
        }
      } else {
        if (txcSource.getSelectedText().equals(strFindText)) {
          caretPos -= strFindText.length();
        }
      }
    }
    String strSourceAll = txcSource.getText();
    String strSource = strSourceAll.substring(0, caretPos);
    if (isIgnoreCase) {
      strFindText = strFindText.toLowerCase();
      strSourceAll = strSourceAll.toLowerCase();
      strSource = strSource.toLowerCase();
    }
    result = strSource.lastIndexOf(strFindText);
    if (result < 0 && isWrap) {
      result = strSourceAll.lastIndexOf(strFindText);
    }
    return result;
  }
}
