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
 * ��������/ֵ�Եļ���
 * 
 * @author ��ԭ
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
