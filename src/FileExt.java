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
 * ���ڱ�ʶ�ļ���չ����ö��
 * 
 * @author ��ԭ
 * 
 */
public enum FileExt {
  /**
   * Ada����Դ�ļ�
   */
  ADA,
  /**
   * Active Server Page(��̬������ҳ��)
   */
  ASP,
  /**
   * Batch(�������ļ�)
   */
  BAT,
  /**
   * C Source(C����Դ�ļ�)
   */
  C,
  /**
   * C++ Source(C++����Դ�ļ�)
   */
  CPP,
  /**
   * C# Source(C#����Դ�ļ�)
   */
  CS,
  /**
   * Cascading Style Sheet(�����ʽ��)
   */
  CSS,
  /**
   * C/C++ Head(C/C++����ͷ�ļ�)
   */
  H,
  /**
   * Hypertext Markup Language(���ı��������)
   */
  HTM,
  /**
   * Hypertext Markup Language(���ı��������)
   */
  HTML,
  /**
   * Device INFormation File(����������Ϣ�ļ�)
   */
  INF,
  /**
   * Initialization File(��ʼ�������ļ�)
   */
  INI,
  /**
   * java����Դ�ļ�
   */
  JAVA,
  /**
   * javaScript�ű�����Դ�ļ�
   */
  JS,
  /**
   * Java Server Page(java������ҳ��)
   */
  JSP,
  /**
   * LISt Processor(�б�������)
   */
  LISP,
  /**
   * ��־�ļ�
   */
  LOG,
  /**
   * Lua��Ƕ��ʽ�ű�����
   */
  LUA,
  /**
   * Objective-C����Դ�ļ�
   */
  M,
  /**
   * Makefile�����ļ�
   */
  MK,
  /**
   * Pascal����Դ�ļ�
   */
  PAS,
  /**
   * �����ļ�
   */
  PATCH,
  /**
   * PHP:Hypertext Preprocessor(���ı�Ԥ��������)
   */
  PHP,
  /**
   * Perl�ű�����Դ�ļ�
   */
  PL,
  /**
   * Python�ű�����Դ�ļ�
   */
  PY,
  /**
   * Ruby�ű�����Դ�ļ�
   */
  RB,
  /**
   * ע�������ļ�
   */
  REG,
  /**
   * Shell�ű�����Դ�ļ�
   */
  SH,
  /**
   * Structured Query Language(�ṹ����ѯ����)
   */
  SQL,
  /**
   * Smalltalk����Դ�ļ�
   */
  ST,
  /**
   * ��ͨ�ı��ļ�
   */
  TXT,
  /**
   * Visual Basic(VB����Դ�ļ�)
   */
  VB,
  /**
   * Extensible Markup Language(����չ�������)
   */
  XML;

  /**
   * ��д����ķ���
   */
  public String toString() {
    switch (this) {
    case ADA:
      return ".ada";
    case ASP:
      return ".asp";
    case BAT:
      return ".bat";
    case C:
      return ".c";
    case CPP:
      return ".cpp";
    case CS:
      return ".cs";
    case CSS:
      return ".css";
    case H:
      return ".h";
    case HTM:
      return ".htm";
    case HTML:
      return ".html";
    case INF:
      return ".inf";
    case INI:
      return ".ini";
    case JAVA:
      return ".java";
    case JS:
      return ".js";
    case JSP:
      return ".jsp";
    case LISP:
      return ".lisp";
    case LOG:
      return ".log";
    case LUA:
      return ".lua";
    case M:
      return ".m";
    case MK:
      return ".mk";
    case PAS:
      return ".pas";
    case PATCH:
      return ".patch";
    case PHP:
      return ".php";
    case PL:
      return ".pl";
    case PY:
      return ".py";
    case RB:
      return ".rb";
    case REG:
      return ".reg";
    case SH:
      return ".sh";
    case SQL:
      return ".sql";
    case ST:
      return ".st";
    case TXT:
      return ".txt";
    case VB:
      return ".vb";
    case XML:
      return ".xml";
    default:
      return ".txt";
    }
  }

  /**
   * ��ȡ�ļ���չ������������
   * 
   * @return �ļ���չ������������
   */
  public String getDescription() {
    switch (this) {
    case ADA:
      return "Ada����Դ�ļ�(.ada)";
    case ASP:
      return "��̬������ҳ���ļ�(.asp)";
    case BAT:
      return "�������ļ�(.bat)";
    case C:
      return "C����Դ�ļ�(.c)";
    case CPP:
      return "C++����Դ�ļ�(.cpp)";
    case CS:
      return "C#����Դ�ļ�(.cs)";
    case CSS:
      return "�����ʽ���ļ�(.css)";
    case H:
      return "C/C++����ͷ�ļ�(.h)";
    case HTM:
      return "���ı���������ļ�(.htm)";
    case HTML:
      return "���ı���������ļ�(.html)";
    case INF:
      return "����������Ϣ�ļ�(.inf)";
    case INI:
      return "��ʼ�������ļ�(.ini)";
    case JAVA:
      return "java����Դ�ļ�(.java)";
    case JS:
      return "javaScript�ű�����Դ�ļ�(.js)";
    case JSP:
      return "java������ҳ���ļ�(.jsp)";
    case LISP:
      return "�б��������ļ�(.lisp)";
    case LOG:
      return "��־�ļ�(.log)";
    case LUA:
      return "Lua��Ƕ��ʽ�ű������ļ�(.lua)";
    case M:
      return "Objective-C����Դ�ļ�(.m)";
    case MK:
      return "Makefile�����ļ�(.mk)";
    case PAS:
      return "Pascal����Դ�ļ�(.pas)";
    case PATCH:
      return "�����ļ�(.patch)";
    case PHP:
      return "���ı�Ԥ���������ļ�(.php)";
    case PL:
      return "Perl�ű�����Դ�ļ�(.pl)";
    case PY:
      return "Python�ű�����Դ�ļ�(.py)";
    case RB:
      return "Ruby�ű�����Դ�ļ�(.rb)";
    case REG:
      return "ע�������ļ�(.reg)";
    case SH:
      return "Shell�ű�����Դ�ļ�(.sh)";
    case SQL:
      return "�ṹ����ѯ�����ļ�(.sql)";
    case ST:
      return "Smalltalk����Դ�ļ�(.st)";
    case TXT:
      return "��ͨ�ı��ļ�(.txt)";
    case VB:
      return "VB����Դ�ļ�(.vb)";
    case XML:
      return "����չ��������ļ�(.xml)";
    default:
      return "��ͨ�ı��ļ�(.txt)";
    }
  }
}
