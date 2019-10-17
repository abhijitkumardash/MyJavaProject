package com.capgemini.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.capgemini.dev.beans.*;
import com.capgemini.dev.util.*;

public class MovieJDBCImple implements MovieDAO 
{
	public boolean createMovie(Movie m) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean b=false;

		String sql = "insert into movies_info value(?,?,?,?)";
		try 
		{
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getMovieId());
			pstmt.setString(2,m.getName());
			pstmt.setInt(3, m.getRating());
			pstmt.setString(4, m.getDescription());
			int count= pstmt.executeUpdate();

			if(count>0) 
			{
				b=true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}

			if(pstmt != null) 
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return b;
	}
	
	public boolean deleteMovie(int movieId) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		boolean b=false;

		String sql = "delete from movies_info where movie_id=?";
		try 
		{
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movieId);
			rs= pstmt.executeQuery();

			if(rs.next()) 
			{
				b=true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null) 
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(rs != null) 
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return b;

	}

	@SuppressWarnings("null")
	public boolean updateRatings(int movieId, int rating) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean b=false;
		Movie m = null;

		String sql = "update movies_info set movie_desc=? where movie_id=?";
		try 
		{
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getDescription());
			pstmt.setInt(1, m.getMovieId());
			int count= pstmt.executeUpdate();

			if(count>0) 
			{
				b=true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null) 
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return b;


	}

	public Movie searchById(int id) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from movies_info where movie_id = ?";
		Movie m = null;
		try 
		{
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) 
			{
				m = new Movie();
				m.setMovieId(id);
				m.setName(rs.getString("movie_name"));
				m.setRating(rs.getInt("movie_rating"));
				m.setDescription(rs.getString("movie_desc"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}

			if(pstmt != null) 
			{
				try 
				{
					pstmt.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(rs != null) 
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return m;
	}
}