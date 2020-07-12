package com.xue.cloud.serviceImpl;

import java.util.List;

import com.xue.cloud.dao.BugDao;
import com.xue.cloud.dao.ProjectDao;
import com.xue.cloud.model.BugMes;
import com.xue.cloud.model.BugByPage;
import com.xue.cloud.model.ProjectByPage;
import com.xue.cloud.service.BugService;

public class BugServiceImpl implements BugService{
	@Override
	public List<BugMes> selectByProIdName(int proId, int currentPage, String name) {
		// TODO ���� proid\currenpage ����ô����bug��ѯ
		
		if (currentPage != 0) {
			String sql = "select bid,bug_name,pro_id,phe_content,phe_id,stage,record,happ_time,str_user,str_time,str_id,cause,confirm_user,con_time,state from bug where pro_id = ? and bug_name like ? limit ?,?";
			return BugDao.query(sql, proId, "%" + name + "%" ,(currentPage - 1) * BugByPage.PAGEBUGNUM,BugByPage.PAGEBUGNUM);
		} else {
			String sql = "select bid,bug_name,pro_id,phe_content,phe_id,stage,record,happ_time,str_user,str_time,str_id,cause,confirm_user,con_time,state from bug where pro_id = ? and bug_name like ?";
			return  BugDao.query(sql, proId, "%" + name + "%" );
		}
	}

	@Override
	public boolean deleteByBugId(int id) {//����bugidɾ������bug���ݣ�
		// TODO //����bugidɾ������bug���ݣ�
		//дsqlyuju
		String sql = "delete from bug where bid = ?";
		return BugDao.update(sql, id);
	}

	@Override
	public boolean insertBug(BugMes bugMes) {
		// TODO �����ݿ��м���bug��Ϣ
		String sql = "insert into bug values(default,?,?,?,?,?, ?, ?,default ,default,default,default,default,default,?)" ;
		return BugDao.update(sql, bugMes.getName(),bugMes.getProId(),bugMes.getPheContent(),bugMes.getPheId(),bugMes.getStage(),bugMes.getRecoro(),bugMes.getHappTime(),bugMes.getState());
	}

	@Override
	public boolean uodateBugByNoState(int no) {
		// TODO �ر�
		String sql = "update bug set state = 4 where BID = ?";
		return BugDao.update(sql, no);
	}

	@Override
	public BugMes selectBugByBugId(int id) {
		// TODO ����bugid��ѯbug����
		String sql = "select bid,bug_name,pro_id,phe_content,phe_id,stage,record,happ_time,str_user,str_time,str_id,cause,confirm_user,con_time,state from bug where bid = ?"; 
		List<BugMes> list = BugDao.query(sql, id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} 
		return null;
	}
	
}
