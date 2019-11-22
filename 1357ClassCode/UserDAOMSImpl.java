package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAOMSImpl extends DAOBase implements UserDAO {//�̳�DAOBase���ӻ��࣬ʵ��UserDAO�ӿ��������ķ���
			@SuppressWarnings("resource")
			public static void Input(User user) throws IOException{
//�˷������������û���Ϣ
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("������һ���û�����Ϣ��");
				System.out.println("�û�ID��");	
		 		user.setUser_id(ReadStr.nextLine());
		 		System.out.println("�û�����");
		 		user.setUser_name(ReadStr.nextLine());
		 		System.out.println("�û����룺");
		 		user.setUser_password(ReadStr.nextLine());
		 		
		 		System.out.println("�û��Ա�");
		 		user.setUser_sex(ReadStr.nextLine());
		 		System.out.println("�û��绰��");
		 		user.setUser_phone(ReadStr.nextLine());
		 		System.out.println("�û����գ�");
		 		user.setUser_birthday(ReadStr.nextLine());
		 		
		 		
			}
			private static final String CREATE_USER_SQL ="INSERT INTO User values(?,?,?,?,?,?)";
			@Override
			public void insertUser(User user) {//ʵ�ֲ��뷽��������
				Connection conn = null;
				PreparedStatement pst = null;
				try{
					conn = getConnection();//�������ݿ�
					Input(user);//�����û���Ϣ
					pst = conn.prepareStatement(CREATE_USER_SQL);
					pst.setString(1,user.getUser_id());
					pst.setString(2, user.getUser_name());
					pst.setString(3, user.getUser_password());
					pst.setString(4, user.getUser_sex());
					pst.setString(5, user.getUser_phone());
					pst.setString(6, user.getUser_birthday());
					
					int row=pst.executeUpdate();
					System.out.println("�ɹ�������"+row+"������!");
					pst.close();
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(pst!=null)
						try {
							pst.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			@Override
			public void updateUser(User user) {//ʵ�ָ��£��ģ�����
				//��ɾ�����ٲ��룻
				// TODO Auto-generated method stub
				try{
					Connection conn = null;
					Statement stmt = null;
					int rs ;
					try {
						conn = getConnection();//�������ݿ�
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("������Ҫ�����û���ID��");	 
						stmt = conn.createStatement();
						String sql = "delete from User where User_id=";

						rs = stmt.executeUpdate(sql+ReadStr.nextLine());

						insertUser(user);
						//��ʽ�ͷ���Դ
						stmt.close();		
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(stmt!=null)
							try {
								stmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}catch(Exception e){
					e.printStackTrace();
				}			
			}
			@Override
			public void deleteUser(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int rs ;
				try {
					conn = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ���û���ID��");		 
			 		sid=ReadStr.nextLine();
					stmt = conn.createStatement();
					String sql = "delete from User where User_id=";
					rs = stmt.executeUpdate(sql+Integer.parseInt(sid));//���ؽ��
					System.out.println("�ɹ�ɾ����"+rs+"������!");
					//��ʽ�ͷ���Դ
					stmt.close();		
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			private static final String SEARCH_USERC1 = "SELECT User_id,User_name,User_password,User_sex,User_phone,User_birthday FROM User WHERE User_id=";
			@Override
			public User getUser(String sid) {//ʵ�ֲ�ѯһ���û���Ϣ�ķ���
				// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				User user = new User();
				try{
					conn = getConnection();
					stmt = conn.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ�û�ID��");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_USERC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						user.setUser_id(rs.getString("User_id"));
						user.setUser_name(rs.getString("User_name"));
						user.setUser_password(rs.getString("User_password"));
						user.setUser_sex(rs.getString("User_sex"));
						user.setUser_phone(rs.getString("User_phone"));
						user.setUser_birthday(rs.getString("User_birthday"));
						
						System.out.println(user.getUser_id()+""+user.getUser_name()+user.getUser_sex()+""+user.getUser_phone()+""+user.getUser_birthday());
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(rs!=null)
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				return null;
			}
			private static final String SEARCH_USERTC = "SELECT user_id,user_name,user_age,user_sex,user_telephone,user_address,user_password FROM buyer ";
			@Override
			public List<User> getUserByC(String sql) {
//ʵ�ֲ�ѯ����û���Ϣ�ķ���
				
				List<User> users = new ArrayList<User>();
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try{
					conn = getConnection();
					stmt = conn.createStatement();
					System.out.println("���潫��������������ݣ�");
					String endsql = null;
					
						endsql = SEARCH_USERTC;
					
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						User user = new User();
						user.setUser_id(rs.getString("User_id"));
						user.setUser_name(rs.getString("User_name"));
						user.setUser_password(rs.getString("User_password"));
						user.setUser_sex(rs.getString("User_sex"));
						user.setUser_phone(rs.getString("User_phone"));
						user.setUser_birthday(rs.getString("User_birthday"));
						
						users.add(user);
					}
					for(int i=0;i<users.size();i++){
						User s = new User();
				 		s=users.get(i);
				 		System.out.println(s.getUser_id()+""+s.getUser_name()+s.getUser_sex()+""+s.getUser_phone()+""+s.getUser_birthday());
					
					}
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(rs!=null)
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				return users;
			}
}
