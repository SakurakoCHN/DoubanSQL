package Movie;
 
import java.util.List;

public interface MovieDAO {
	public Movie createMovie();  //��������
	public void insertMovie(Movie movie);  //������������ݿ�
	public void updateMovie(Movie movie); //����ĳһ��¼
	public void deleteMovie(String Movie_id); //ɾ��ĳһ��¼
	public Movie getMovie(String Movie_id); //��ȡĳһ��¼
	public List<Movie>getMovieBYC(String sql); //��ȡ������¼
	
}
