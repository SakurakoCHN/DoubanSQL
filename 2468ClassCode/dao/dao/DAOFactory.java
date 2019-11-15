package dao;
import DiscussResponse.*;
import Movie.*;
import MovieComment.*;
import MoviePrize.*;
public class DAOFactory {
	
private static DAOFactory instance;

static {
	instance=new DAOFactory();
}
private DAOFactory() {
}
public static DAOFactory getInstance() {
	return instance;
}

public static DiscussResponseDAO getDiscussResponseDAO()
{
	DiscussResponseDAO discussresponseDAO=new DiscussResponseDAOMSImpl();
	return discussresponseDAO;
}
public static MovieDAO getMovieDAO()
{
	MovieDAO movieDAO=new MovieDAOMSImpl();
	return movieDAO;
}
public static MovieCommentDAO getMovieCommentDAO()
{
	MovieCommentDAO moviecommentDAO=new MovieCommentDAOMSImpl();
	return moviecommentDAO;
}
public static MoviePrizeDAO getMoviePrizeDAO()
{
	MoviePrizeDAO movieprizeDAO=new MoviePrizeDAOMSImpl();
	return movieprizeDAO;
}
}
