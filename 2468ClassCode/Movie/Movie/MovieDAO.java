package Movie;
 
import java.util.List;

public interface MovieDAO {
	public Movie createMovie();  //创建对象
	public void insertMovie(Movie movie);  //插入对象至数据库
	public void updateMovie(Movie movie); //更新某一记录
	public void deleteMovie(String Movie_id); //删除某一记录
	public Movie getMovie(String Movie_id); //获取某一记录
	public List<Movie>getMovieBYC(String sql); //获取多条记录
	
}
