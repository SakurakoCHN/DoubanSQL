package DiscussResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DAOBase;
public class DiscussResponseDAOMSImpl extends DAOBase implements DiscussResponseDAO {

	public DiscussResponse createDiscussResponse()
	{
		DiscussResponse dp=new DiscussResponse();
		Scanner in=new Scanner(System.in);
		System.out.print("����һ��DiscussResponse����\n");
		System.out.print("����Disscuss_id(����id):");
		dp.setDisscuss_id(in.nextLine());
		System.out.print("����User_name(�û���):");
		dp.setUser_name(in.nextLine());
		System.out.print("����Response_content(��Ӧ����):");
		dp.setResponse_content(in.nextLine());
		System.out.print("����Response_date(��Ӧ����):");
		dp.setResponse_date(in.nextLine());
		System.out.print("�Ѵ���DiscussResponse����!\n");
		in.close();
		return dp;
		
	}
	
	private static final String insert_DiscussResponse_SQL="insert into DiscussResponse values(?,?,?,?)";
	public void insertDiscussResponse(DiscussResponse discussresponse) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			System.out.print("��ʼ����DiscussResponse�������ݿ�\n");
			con=getConnection();
			ps=con.prepareStatement(insert_DiscussResponse_SQL);
			ps.setString(1,discussresponse.getDisscuss_id());
			ps.setString(2,discussresponse.getUser_name());
			ps.setString(3,discussresponse.getResponse_content());
			ps.setString(4,discussresponse.getResponse_date());
		    ps.executeQuery();
		    ps.close();
		    con.close();
		    System.out.print("�������!\n");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private static final String update_DiscussResponse_SQL1="update DiscussResponse set ";
	private static final String update_DiscussResponse_SQL2=" where Discuss_id=";
	public void updateDiscussResponse(DiscussResponse discussresponse) {
		Connection con=null;
		Statement st=null;
		Scanner in=new Scanner(System.in);
		String update_content;
		String sql;
		try {
			update_content=in.nextLine();
			con=getConnection();
			st=con.createStatement();
			sql=update_DiscussResponse_SQL1+update_content+update_DiscussResponse_SQL2+discussresponse.getDisscuss_id();
			st.executeQuery(sql);
			
		    in.close();
			st.close();
		    con.close();
		    System.out.print("�������!\n");
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private static final String delete_DiscussResponse_SQL="delete from DiscussResponse where Discuss_id=?";
	public void deleteDiscussResponse(String Discuss_id) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner in=new Scanner(System.in);
		try {
			System.out.print("��ʼɾ��DiscussResponse����\n");
			con=getConnection();
			ps=con.prepareStatement(delete_DiscussResponse_SQL);
			System.out.print("����Ҫɾ����Discuss_id");
			ps.setString(1, in.nextLine());
			ps.executeQuery();
			
			in.close();
		    ps.close();
		    con.close();
		    System.out.print("ɾ�����!\n");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	private static final String search_DiscussResponse_SQl = "select * from DiscussResponse where Discuss_id=?";
	public DiscussResponse getDiscussResponse(String Discuss_id) {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner in=new Scanner(System.in);
		DiscussResponse dr=new DiscussResponse();
		try {
			System.out.print("��ȡDiscussResponse����\n");
			con=getConnection();
			ps=con.prepareStatement(search_DiscussResponse_SQl);
			System.out.print("�����ȡ�����Discuss_id\n");
			ps.setString(1, in.nextLine());
			rs=ps.executeQuery();
			if(rs.next())
			{
				dr.setDisscuss_id(rs.getString("Discuss_id"));
				dr.setUser_name(rs.getString("User_name"));
				dr.setResponse_content(rs.getString("Response_content"));
				dr.setResponse_date(rs.getString("Response_date"));
			}
			else dr=null;
			
			in.close();
			ps.close();
		    con.close();
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dr;
		
		
	}

	private static final String searchList_DiscussResponse_SQl = "select * from DiscussResponse";
	public List<DiscussResponse> getDiscussResponseBYC(String sql) {
		List<DiscussResponse> drs = new ArrayList<DiscussResponse>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			st = con.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = searchList_DiscussResponse_SQl;
			}else{
				finalsql = searchList_DiscussResponse_SQl + " where "+sql;
			}
			rs=st.executeQuery(finalsql);
			while(rs.next()){
				DiscussResponse dr=new DiscussResponse();
				dr.setDisscuss_id(rs.getString("Discuss_id"));
				dr.setUser_name(rs.getString("User_name"));
				dr.setResponse_content(rs.getString("Response_content"));
				dr.setResponse_date(rs.getString("Response_date"));
				drs.add(dr);						
			}
			
			rs.close();
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return drs;
	}
		

}
