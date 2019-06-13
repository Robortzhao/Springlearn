package com.springlearn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao=null;
	
	/**
	 * �������ע��
	 * 1. ʹ��propagation ָ������ת����Ϊ������ǰ������һ�����񷽷�����ʱ���ʹ������Ĭ��ȡֵΪ REQUIRED ,��ʹ�õ��÷���������
	 * REQUIRES_NEW: ʹ���Լ������񣬵����߹���
	 * 2. ʹ��isolation ָ������ĸ��뼶����õ�ΪIsolation.READ_COMMITTED
	 * 3. Ĭ�������Spring������ʽ��������е�����ʱ�쳣�ع���Ҳ����ͨ����Ӧ���������ã�ͨ�������ȡĬ��ֵ����
	 * 4. ʹ��readOnly ָ�������Ƿ�Ϊֻ������ʾ�������ֻ��ȡ���ݲ��������ݣ��������԰������ݿ������Ż�����
	 * 	      �������һ��ֻ�����ݿ�ķ�����Ӧ����readOnly=true
	 * 5. ʹ��timeout ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			isolation = Isolation.READ_COMMITTED,
			readOnly = false,
			noRollbackFor = {UserAccountException.class},
			
			timeout = 3 )
	@Override
	public void purchase(String username, String isbn) {
		/**
		 * 1.��ȡ��ĵ���
		 * 2.������Ŀ��
		 * 3�������û����
		 */
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int price  = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}
}
