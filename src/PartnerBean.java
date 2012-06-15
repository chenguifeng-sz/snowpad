package com.xiboliya.snowpad;

/**
 * ��������/ֵ�Եļ���
 * 
 * @author chen
 * 
 */
public class PartnerBean {
  private Object object = null;
  private int index = -1;

  /**
   * ���췽��
   */
  public PartnerBean() {
  }

  /**
   * ���췽��
   * 
   * @param object
   *          ��Ҫ�����ֵ
   * @param index
   *          ��Ҫ����ļ�
   */
  public PartnerBean(Object object, int index) {
    this.setObject(object);
    this.setIndex(index);
  }

  /**
   * ��ȡ��ǰֵ
   * 
   * @return ��ǰֵ
   */
  public Object getObject() {
    return this.object;
  }

  /**
   * ��ȡ��ǰ��
   * 
   * @return ��ǰ��
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * ���õ�ǰֵ
   * 
   * @param object
   *          ��Ҫ�����ֵ
   */
  public void setObject(Object object) {
    this.object = object;
  }

  /**
   * ���õ�ǰ��
   * 
   * @param index
   *          ��Ҫ����ļ�
   */
  public void setIndex(int index) {
    this.index = index;
  }
}
