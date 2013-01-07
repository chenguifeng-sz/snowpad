package com.xiboliya.snowpad;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Enumeration;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.JTextComponent;

/**
 * 实用工具类，包括可重用的各种属性和方法。设计为final类型，使本类不可被继承
 * 
 * @author chen
 * 
 */
public final class Util {
  public static final String SOFTWARE = "冰雪记事本"; // 软件名称
  public static final String VERSION = "V2.2"; // 软件版本号
  public static final String TXT_EXT = ".txt"; // txt文件的扩展名
  public static final String OS_NAME = System.getProperty("os.name", "Windows"); // 当前操作系统的名称
  public static final String FILE_SEPARATOR = System.getProperty(
      "file.separator", "/"); // 当前操作系统的文件分隔符
  public static final String LINE_SEPARATOR = System.getProperty(
      "line.separator", "\n"); // 当前操作系统的行分隔符
  public static final int BUFFER_LENGTH = 1024; // 缓冲区的大小
  public static final Font GLOBAL_FONT = new Font("宋体", Font.PLAIN, 12); // 全局的默认字体
  public static final Font TEXT_FONT = new Font("宋体", Font.PLAIN, 14); // 文本域的默认字体
  public static final int MIN_FONT_SIZE = 8; // 字体最小值
  public static final int MAX_FONT_SIZE = 100; // 字体最大值
  public static final int MIN_TABSIZE = 1; // Tab字符最小值
  public static final int MAX_TABSIZE = 99; // Tab字符最大值
  public static final int DEFAULT_TABSIZE = 4; // Tab字符默认值
  public static final String FILE_HISTORY = "FileHistory"; // 用于标识最近编辑的文件
  public static final int FILE_HISTORY_MAX = 10; // 最近编辑文件的最大存储个数
  public static final int DEFAULT_UNDO_INDEX = 0; // 撤销标识符的默认值
  public static final String[] FONT_FAMILY_NAMES = java.awt.GraphicsEnvironment
      .getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // 获取系统所有字体的名称列表
  public static final int INSERT_MAX_COLUMN = 10; // 插入字符界面的最大列数
  public static final int INSERT_MAX_ROW = 10; // 插入字符界面的最大行数
  public static final int INSERT_MAX_ELEMENT = INSERT_MAX_COLUMN
      * INSERT_MAX_ROW; // 插入字符界面的最大元素数
  public static final int INPUT_HEIGHT = 22; // 单行输入框的高度
  public static final int VIEW_HEIGHT = 18; // 标签、单选按钮、复选框的高度
  public static final int BUTTON_HEIGHT = 23; // 按钮的高度
  public static final Font VIEW_FONT = new Font("宋体", Font.PLAIN, 80); // 插入字符界面中预览标签的字体
  public static final String INSERT_SPECIAL = "﹟﹠﹡＃＠＆＊※§〃№♀♂㊣㈱℡℅⊙◎〓○●△▲▽▼◇◆□■☆★◢◣◤◥ˉ￣＿﹉﹊﹍﹎﹋﹌↑↓←→↖↗↙↘∥∣／＼∕﹨╋┳┻┫┣┃━┏┓┗┛╳╱╲"; // 特殊符号
  public static final String INSERT_PUNCTUATION = "，、。．；：？！︰…‥′‵～‖ˇˉ﹐﹑﹒?﹔﹕﹖﹗｜–︱—︳︴﹏（）︵︶｛｝︷︸〔〕︹︺【】︻︼《》︽︾〈〉︿﹀「」﹁﹂『』﹃﹄﹙﹚﹛﹜﹝﹞‘’“”〝〞ˋˊ々"; // 标点符号
  public static final String INSERT_MATH = "≈≡≠＝≤≥＜＞≮≯±＋－×÷／∫∮∝∞∧∨∑∏∪∩∈∵∴∷⊥∥∠⌒≌∽√≦≧≒﹢﹣﹤﹥﹦～∟⊿㏒㏑"; // 数学符号
  public static final String INSERT_UNIT = "°′″＄￥〒￠￡％℃℉﹩﹪‰﹫㏕㎜㎝㎞㏎㎡㎎㎏㏄¤"; // 单位符号
  public static final String INSERT_DIGIT = "⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑⒒⒓⒔⒕⒖⒗⒘⒙⒚⒛⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽⑾⑿⒀⒁⒂⒃⒄⒅⒆⒇①②③④⑤⑥⑦⑧⑨⑩㈠㈡㈢㈣㈤㈥㈦㈧㈨㈩ⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪⅫ"; // 数字符号
  public static final String INSERT_PINYIN = "āáǎàōóǒòēéěèīíǐìūúǔùǖǘǚǜüêɑńňǹɡ"; // 拼音符号
  public static final String CTRL_Z = "Ctrl+Z"; // 组合键Ctrl+Z的字符串
  public static final String CTRL_Y = "Ctrl+Y"; // 组合键Ctrl+Y的字符串
  public static final String TEXT_PREFIX = "*"; // 文件文本修改的标题栏标识符
  public static final String STYLE_PREFIX = "※"; // 文件格式修改的标题栏标识符
  public static final String STATE_CHARS = "Chars:"; // 状态栏显示信息-文本总字符数
  public static final String STATE_LINES = "Lines:"; // 状态栏显示信息-文本总行数
  public static final String STATE_CUR_LINE = "Ln:"; // 状态栏显示信息-光标当前行号
  public static final String STATE_CUR_COLUMN = "Col:"; // 状态栏显示信息-光标当前列号
  public static final String STATE_CUR_SELECT = "Sel:"; // 状态栏显示信息-当前选择的字符数
  public static final String STATE_LINE_STYLE = "LineStyle:"; // 状态栏显示信息-当前换行符格式
  public static final String STATE_ENCODING = "Encoding:"; // 状态栏显示信息-当前编码格式
  public static final String[] FILE_ENCODINGS = new String[] { "自动检测",
      CharEncoding.ANSI.getName(), CharEncoding.UBE.getName(),
      CharEncoding.ULE.getName(), CharEncoding.UTF8.getName(),
      CharEncoding.UTF8_NO_BOM.getName(), CharEncoding.BASE.getName() }; // 选择编码格式的数组
  public static final String[] DATE_STYLES = new String[] {
      "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss:SSS", "yyyy-MM-dd KK:mm:ss",
      "yyyy-MM-dd KK:mm:ss a", "yyyy-MM-dd HH:mm:ss E",
      "yyyy-MM-dd HH:mm:ss zZ", "yyyy年MM月dd日 HH时mm分ss秒",
      "G yyyy-MM-dd HH:mm:ss E zZ", "yy-M-d H:m:s", "yyyy/MM/dd HH:mm:ss",
      "yyyy.MM.dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd", "yyyy.MM.dd",
      "yy/MM/dd", "HH:mm:ss", "KK:mm:ss a", "HH:mm:ss:SSS" }; // 时间/日期格式字符串
  public static final Color COLOR_HIGHLIGHT_1 = new Color(255, 0, 0, 40); // 用于高亮显示的颜色1,其中第4个参数表示透明度，数值越小越透明
  public static final Color COLOR_HIGHLIGHT_2 = new Color(0, 255, 0, 40); // 用于高亮显示的颜色2
  public static final Color COLOR_HIGHLIGHT_3 = new Color(0, 0, 255, 40); // 用于高亮显示的颜色3
  public static final Color COLOR_HIGHLIGHT_4 = new Color(0, 255, 255, 40); // 用于高亮显示的颜色4
  public static final Color COLOR_HIGHLIGHT_5 = new Color(255, 0, 255, 40); // 用于高亮显示的颜色5

  /**
   * 由于此类为工具类，故将构造方法私有化
   */
  private Util() {
  }

  /**
   * 格式化欲保存的文件名
   * 
   * @param strFileName
   *          文件的完整路径
   * @param fileFilter
   *          当前的文件类型过滤器
   * @param strExt
   *          欲保存文件的扩展名
   * @return 格式化后的文件
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
   * 修改整个程序的默认字体
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
   * 在文本组件中查找字符串
   * 
   * @param strFindText
   *          查找的字符串
   * @param txcSource
   *          文本组件
   * @param isFindDown
   *          是否向下查找
   * @param isIgnoreCase
   *          是否区分大小写
   * @param isWrap
   *          是否循环查找
   * @return 查找的字符串位于文本组件中的索引
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
   * 在文本组件中向下查找字符串
   * 
   * @param strFindText
   *          查找的字符串
   * @param txcSource
   *          文本组件
   * @param isIgnoreCase
   *          是否区分大小写
   * @param isWrap
   *          是否循环查找
   * @return 查找的字符串位于文本组件中的索引
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
   * 在文本组件中向上查找字符串
   * 
   * @param strFindText
   *          查找的字符串
   * @param txcSource
   *          文本组件
   * @param isIgnoreCase
   *          是否区分大小写
   * @param isWrap
   *          是否循环查找
   * @return 查找的字符串位于文本组件中的索引
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
