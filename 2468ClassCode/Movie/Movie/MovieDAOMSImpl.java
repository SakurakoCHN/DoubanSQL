package Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DAOBase;
public class MovieDAOMSImpl extends DAOBase implements MovieDAO {


	public Movie createMovie() {
		Movie m=new Movie();
		Scanner in=new Scanner(System.in);
		System.out.print("����һ��Movie����\n");
		System.out.print("����Movie_id(��Ӱid):");
		m.setMovie_id(in.nextLine());
		System.out.print("����Movie_name(����):");
		m.setMovie_name(in.nextLine());
		System.out.print("����Movie_director(����):");
		m.setMovie_director(in.nextLine());
		System.out.print("����Movie_writer(���):");
		m.setMovie_writer(in.nextLine());
		System.out.print("����Movie_actor1(����1):");
		m.setMovie_actor1(in.nextLine());
		System.out.print("����Movie_actor2(����2):");
		m.setMovie_actor2(in.nextLine());
		System.out.print("����Movie_actor3(����3):");
		m.setMovie_actor3(in.nextLine());
		System.out.print("����Movie_type(����):");
		m.setMovie_type(in.nextLine());
		System.out.print("����Movie_language(����):");
		m.setMovie_language(in.nextLine());
		System.out.print("����Movie_date(��ӳ����):");
		m.setMovie_date(in.nextLine());
		
		System.out.print("�Ѵ���Movie����!\n");
		in.close();
		return m;
	}

	private static final String insert_Movie_SQL="insert into Movie values(?,?,?,?,?,?,?,?,?,?)";
	public void insertMovie(Movie movie) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			System.out.print("��ʼ����Movie�������ݿ�\n");
			con=getConnection();
			ps=con.prepareStatement(insert_Movie_SQL);
			ps.setString(1,movie.getMovie_id());
			ps.setString(2,movie.getMovie_name());
			ps.setString(3,movie.getMovie_director());
			ps.setString(4,movie.getMovie_writer());
			ps.setString(5,movie.getMovie_actor1());
			ps.setString(6,movie.getMovie_actor2());
			ps.setString(7,movie.getMovie_actor3());
			ps.setString(8,movie.getMovie_type());
			ps.setString(9,movie.getMovie_language());
			ps.setString(10,movie.getMovie_date());
		    ps.executeQuery();
		    ps.close();
		    con.close();
		    System.out.print("�������!\n");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	private static final String update_Movie_SQL1="update Movie set ";
	private static final String update_Movie_SQL2=" where Movie_id=";
	public void updateMovie(Movie movie) {
		Connection con=null;
		Statement st=null;
		Scanner in=new Scanner(System.in);
		String update_content;
		String sql;
		try {
			update_content=in.nextLine();
			con=getConnection();
			st=con.createStatement();
			sql=update_Movie_SQL1+update_content+update_Movie_SQL2+movie.getMovie_id();
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

	private static final String delete_Movie_SQL="delete from Movie where Movie_id=?";
	public void deleteMovie(String Movie_id) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner in=new Scanner(System.in);
		try {
			System.out.print("��ʼɾ��Movie����\n");
			con=getConnection();
			ps=con.prepareStatement(delete_Movie_SQL);
			System.out.print("����Ҫɾ����Movie_id");
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

	private static final String search_Movie_SQl = "select * from Movie where Movie_id=?";
	public Movie getMovie(String Movie_id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner in=new Scanner(System.in);
		Movie m=new Movie();
		try {
			System.out.print("��ȡMovie����\n");
			con=getConnection();
			ps=con.prepareStatement(search_Movie_SQl);
			System.out.print("�����ȡ�����Movie_id\n");
			ps.setString(1, in.nextLine());
			rs=ps.executeQuery();
			if(rs.next())
			{
				m.setMovie_id(rs.getString("Movie_id"));
				m.setMovie_name(rs.getString("Movie_name"));
				m.setMovie_director(rs.getString("Movie_director"));
				m.setMovie_writer(rs.getString("Movie_writer"));
				m.setMovie_actor1(rs.getString("Movie_actor1"));
				m.setMovie_actor2(rs.getString("Movie_actor2"));
				m.setMovie_actor3(rs.getString("Movie_actor3"));
				m.setMovie_type(rs.getString("Movie_type"));
				m.setMovie_language(rs.getString("Movie_language"));
				m.setMovie_date(rs.getString("Movie_date"));	
			}
			else m=null;
			
			in.close();
			ps.close();
		    con.close();
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}

	private static final String searchList_Movie_SQl = "select * from Movie";
	public List<Movie> getMovieBYC(String sql) {
		List<Movie> ms = new ArrayList<Movie>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			st = con.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = searchList_Movie_SQl;
			}else{
				finalsql = searchList_Movie_SQl + " where "+sql;
			}
			rs=st.executeQuery(finalsql);
			while(rs.next()){
				Movie m=new Movie();
				m.setMovie_id(rs.getString("Movie_id"));
				m.setMovie_name(rs.getString("Movie_name"));
				m.setMovie_director(rs.getString("Movie_director"));
				m.setMovie_writer(rs.getString("Movie_writer"));
				m.setMovie_actor1(rs.getString("Movie_actor1"));
				m.setMovie_actor2(rs.getString("Movie_actor2"));
				m.setMovie_actor3(rs.getString("Movie_actor3"));
				m.setMovie_type(rs.getString("Movie_type"));
				m.setMovie_language(rs.getString("Movie_language"));
				m.setMovie_date(rs.getString("Movie_date"));	
				ms.add(m);						
			}
			
			rs.close();
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ms;
		
	}

}
