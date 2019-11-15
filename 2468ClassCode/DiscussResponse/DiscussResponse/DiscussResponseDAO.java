package DiscussResponse;

import java.util.List;

public interface DiscussResponseDAO {
	public DiscussResponse createDiscussResponse();  //创建对象
	public void insertDiscussResponse(DiscussResponse discussresponse);  //插入对象至数据库
	public void updateDiscussResponse(DiscussResponse discussresponse); //更新某一记录
	public void deleteDiscussResponse(String Discuss_id); //删除某一记录
	public DiscussResponse getDiscussResponse(String Discuss_id); //获取某一记录
	public List<DiscussResponse>getDiscussResponseBYC(String sql); //获取多条记录

}
