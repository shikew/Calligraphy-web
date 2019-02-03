package com.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ����:
 *
 * @author lance
 * �Զ���ע��
 * @Retention �Cʲôʱ��ʹ�ø�ע��
 * @Target �Cע������ʲô�ط�
 *  RetentionPolicy.RUNTIME : ʼ�ղ��ᶪ����������Ҳ������ע�⣬
 *  ��˿���ʹ�÷�����ƶ�ȡ��ע�����Ϣ�������Զ����ע��ͨ��ʹ�����ַ�ʽ��
 *  ElementType.METHOD:������������
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UrlMapping {
    String value();
}