package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
public class Test001 {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Test001 test001 = new Test001();
		List<Object> list = test001.init1();
		System.out.println(list.size());
		 for ( int i = 0; i <list.size(); i++) {
		      if (excelFieldIsNull((Object[])list.get(i))) {
		          list.remove(i);  // ok
		          i--; // 因为位置发生改变，所以必须修改i的位置
		     }
		}
		System.out.println(list.size());
		for (Object object : list) {
			System.out.println(object);
		}
	}
	public List<Object> init() {
		List<Object> list = new ArrayList<Object>();
		list.add(new Eexcel("w1", "w2", "w3"));
		list.add(new Eexcel("e1", "e2", "e3"));
		list.add(new Eexcel("r1", "r2", "r3"));
		list.add(new Eexcel());
		list.add(new Eexcel());
		list.add(new Eexcel("r1", "r2", "r3"));
		list.add(new Eexcel("r1", "r2", "r3"));
		return list;
	}
	
	public List<Object> init1(){
		List<Object> list = new ArrayList<Object>();
		list.add(new Object[]{"w1", "w2", "w3"});
		list.add(new Object[]{"e1", "e2", "e3"});
		list.add(new Object[]{"r1", "r2", "r3"});
		list.add(new Object[]{null, null, null});
		list.add(new Object[]{null, null, null});
		list.add(new Object[]{"w1", "w2", "w3"});
		return list;
	}
	static boolean objectFieldIsNull(Object object) {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.get(object) != null) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				System.err.println(e.toString());
			}
		}
		return true;
	}
	static boolean excelFieldIsNull(Object[] arrObject){
		for (Object object : arrObject) {
			if(object!=null){
				return false;
			}
		}
		return true;
	}
	
}
