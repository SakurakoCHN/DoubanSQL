package DiscussResponse;

import java.util.List;

public interface DiscussResponseDAO {
	public DiscussResponse createDiscussResponse();  //��������
	public void insertDiscussResponse(DiscussResponse discussresponse);  //������������ݿ�
	public void updateDiscussResponse(DiscussResponse discussresponse); //����ĳһ��¼
	public void deleteDiscussResponse(String Discuss_id); //ɾ��ĳһ��¼
	public DiscussResponse getDiscussResponse(String Discuss_id); //��ȡĳһ��¼
	public List<DiscussResponse>getDiscussResponseBYC(String sql); //��ȡ������¼

}
