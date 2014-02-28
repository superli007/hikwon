package com.zhou.hikwon.dao;

import java.util.List;

import com.zhou.hikwon.entity.Product;

public interface IProductService {
	/**
	 * �õ�������Ʒ
	 * 
	 * @return
	 */
	public List<Product> getAll();
	
	public List<Product> getByPager(int pageIndex,int pageSize);

	/**
	 * ��������ID��ȡ��Ʒʵ��
	 * 
	 * @param productId
	 * @return
	 */
	public Product getById(int productId);

	/**
	 * ������Ʒ���ƽ���ģ����ѯ
	 * 
	 * @param name
	 * @return
	 */
	public List<Product> getByName(String name);

	/**
	 * ���һ����Ʒ
	 * 
	 * @param product
	 */
	public void Insert(Product product);

	/**
	 * �޸�һ����Ʒ��Ϣ
	 * 
	 * @param product
	 */
	public void Modify(Product product);

	/**
	 * ɾ��һ����Ʒ
	 * 
	 * @param id
	 */
	public void Del(int id);

}
