package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService  {

	public static void main(String[] args) {
		
		System.out.println();

	}
	
	private static PorderDaoImpl porderdaoimpl=new PorderDaoImpl();

	@Override
	public void addPorder(Porder porder) {
		if(porder.getShirt()>=0 && porder.getTrousers()>=0 && porder.getSneakers()>=0) 
		{
			porderdaoimpl.add(porder);
		}
		
	}

	@Override
	public String AllPorder() {
		List<Porder> l=porderdaoimpl.selectAll();
		String show="";
		
		for(Porder p:l)
		{
			int sum=p.getShirt()*499
					+p.getTrousers()*680
					+p.getSneakers()*1300;
			
			show=show+"訂單:"+p.getId()+
					"\t客戶:"+p.getName()+
					"\t襯衫:"+p.getShirt()+
					"\t長褲:"+p.getTrousers()+
					"\t球鞋:"+p.getSneakers()+
					"\t金額:"+sum+"元\n";
		}
		
		return show;
	}

	@Override
	public List<Porder> findAllPorder() {
		
		return porderdaoimpl.selectAll();
	}

	@Override
	public Porder findById(int id) {
		
		Porder porder=null;
		if(id>0)
		{
			List<Porder> l=porderdaoimpl.selectById(id);
			if(l.size()>0)
			{
				porder=l.get(0);
						
			}
		}
																		
		return porder;
	}

	@Override
	public void updatePorder(String name, int id) {
		Porder p=findById(id);
		p.setName(name);
		
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(int shirt, int trousers, int sneakers, int id) {
		Porder p=findById(id);
		p.setShirt(shirt);
		p.setTrousers(trousers);
		p.setSneakers(sneakers);
		
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(Porder porder) {
		Porder p=findById(porder.getId());
		
	}

	@Override
	public void deletePorderById(int id) {
		if(id>0) {
			porderdaoimpl.delete(id);
		}
		
	}

}
