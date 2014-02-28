package com.zhou.hikwon.daompl;

import java.util.ArrayList;
import java.util.List;

import com.zhou.hikwon.activity.R;
import com.zhou.hikwon.dao.IProductService;
import com.zhou.hikwon.entity.Product;

public class ProductService implements IProductService{
	//ģ������
	private Product[] products={
			new Product(
					1,
					"SCC-B1011P/B1311P 1/3 �����ɫ�����",
					"SCC-B1011P/B1311P",
					"1/3 Super HAD IT CCD,��ɫ	ˮƽ�ֱ��ʣ�540��	����նȣ�0.12Lux/(F1.2,15IRE)	���ⲹ��	������ѹ��B1011PΪAC220V;	B1211PΪAC24V,DC12V",
					null, "Samsung", 1, R.drawable.p1, 1630,
					"kikwon��Ʒ"),
			new Product(
					2,
					"DS-7900HF-SHϵ��Ƕ��ʽ����Ӳ��¼���",
					"DS-7900HF-SH",
					"HDMI��VGA����ֱ�����߾��ɴ�1920x1080�� ֧��HDMI��VGA��CVBSͬʱ����� ֧��HDMI��VGAͬԴ����� ����ͨ��֧��4CIFʵʱ���룻 ����HIKVISION��̨����Э��ʱ�򣬿�ͨ�����ѡ�������������򲢽����������ţ� ֧�ֶ໭��ָ��²�ͬͨ������Ԥ����طţ� ֧��4/8/16·ͬ���ط� ֧�ֱ�ǩ���塢��ѯ���ط�¼���ļ��� ֧�ֻط�ʱ��¼�񳡾����Զ�������������������� ֧�ְ��¼���ѯ���طš�����¼���ļ��� ֧��¼���ļ����Ź��ܣ�",
					null, "Samsung", 1, R.drawable.p2, 2630,
					"kikwon��Ʒ"),
			new Product(
					3,
					"���ô��Ҷ������������",
					"MG6250",
					"���߷�����Ʒ��֧��StayDģʽ�����Ա��ػ�Զ��PC�������ò�����	��ϵ���ʺ���Ҫ�������ӵĳ��ϣ����磺��������ͥ��",
					null, "MAGELLAN �����ϵ��", 2, R.drawable.p3, 1633, "kikwon��Ʒ"),
			new Product(
					4,
					"���ô��Ҷ������������",
					"MG6160",
					"���߷�����Ʒ��֧��StayDģʽ�����Ա��ػ�Զ��PC�������ò�����	��ϵ���ʺ���Ҫ�������ӵĳ��ϣ����磺��������ͥ��",
					null, "MAGELLAN �����ϵ��", 2, R.drawable.p4, 1636, "kikwon��Ʒ"),
			new Product(
					5,
					"EC-200B �����",
					"EC-200B",
					"��ط�ʽ��ͨ���������ϵ翪�� ������ʽ���Ÿ�Ӧ���� ��ѹ��12V ����������350mA�������� ���ŷ�ʽ��180�� ������0.80kg ����ߴ磺(200L��35W��38H)mm �Ŵ��ź�������� ������ʱ���� ������۰塢��˿ �ſ۰�ߴ磺L100��W35��H3mm ��ؿ�ѡ�ͺţ�EC-200BL��EC-200B-1��EC-200B-2 ��ѡ������ϼУ�ZEC200���¼У�FEC100",
					null, "LCJ", 3, R.drawable.p5, 1650, "kikwon��Ʒ"),
			new Product(
					6,
					"EC-200A �����",
					"EC-200A",
					"��ط�ʽ��ͨ���������ϵ翪�� ������ʽ���Ÿ�Ӧ���� ��ѹ��12V ����������350mA�������� ���ŷ�ʽ��180�� ������0.80kg ����ߴ磺(200L��35W��38H)mm �Ŵ��ź�������� ������ʱ���� ������۰塢��˿ �ſ۰�ߴ磺L100��W35��H3mm ��ؿ�ѡ�ͺţ�EC-200BL��EC-200B-1��EC-200B-2 ��ѡ������ϼУ�ZEC200���¼У�FEC100",
					null, "LCJ", 3, R.drawable.p6, 1730, "kikwon��Ʒ")
	};
	
	private List<Product> ps =null; 
	
	public ProductService(){
		ps = new ArrayList<Product>();
		for(Product p:products){
			ps.add(p);
		}
	}
	@Override
	public List<Product> getAll() {
		return this.ps;
	}
	
	
	

	/**
	 * ��ҳ��ȡ����
	 * params:
	 * pageIndex:�����ǵڼ�ҳ(��ҳ��0��ʼ)
	 * pageSize:����ÿҳ��������¼
	 * return:���صľ��Ƿ�ҳ֮�������
	 */
	@Override
	public List<Product> getByPager(int pageIndex, int pageSize) {	
		if (pageIndex<0) pageIndex=0; 
		int totalCount = ps.size();  //������
		int pageCount=1; //��ҳ��
		if (totalCount % pageSize==0){
			pageCount = totalCount/pageSize;
		}else{
			pageCount = (totalCount/pageSize)+1;
		}
		
		if (pageIndex>pageCount-1)//˵�������һҳ
		{
			//pageIndex = pageCount-1;
			return null;
		}
		
		Object[] source = this.ps.toArray();
		
		 int endIndex=(pageIndex+1)*pageSize;
		if (endIndex>totalCount)
			endIndex=totalCount;
		
	
		List<Product> result = new ArrayList<Product>();
		for(int i=pageIndex*pageSize;i<endIndex;i++){
			result.add((Product)source[i]);
		}
		return result;
	}


	@Override
	public Product getById(int productId) {
		for(Product p:this.ps){
			if (p.getId()==productId){
				return p;
			}
		}	
		return null;
	}

	@Override
	public List<Product> getByName(String name) {
		List<Product> result = new ArrayList<Product>();
		for(Product p:this.ps){
			if (p.getName().indexOf(name)!=-1)
				result.add(p);
		}
		
		return result;
	}

	@Override
	public void Insert(Product p) {
		this.ps.add(p);
	}

	@Override
	public void Modify(Product product) {
		for(int i=0;i<this.ps.size();i++){
			if (product.getId()==ps.get(i).getId()){
				ps.set(i, product);
				break;
			}
		}
	}

	@Override
	public void Del(int id) {
		Product p= this.getById(id);
		if (p!=null)
			this.ps.remove(p);
	}


}
