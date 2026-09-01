package com.ktdsuniversity.edu.tmdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ConnectionTest {

	public static MvVO selectMovie(String mvId) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException("odjbc 드라이버가 발견되지 않았습니다. 클래스 패스를 확인해 주세요.");
		}
		
		// Java -> Oracle 연결하기 위한 URL
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		// Oracle에 접속하기 위한 인증 정보
		String schemaName = "TMDB";
		String password = "TMDB";
		
		// Oracle로 접속
		Connection dbConnection = null;
		try {
			dbConnection = DriverManager.getConnection(url, schemaName, password);
			// 연결할 스키마 이름을 출력
			System.out.println(dbConnection.getSchema());
		} catch(SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.", sqle);
		}
		
		// Oracle로 쿼리를 전송하고 실행한 뒤 결과를 받아온다.
		// 영화의 정보만 조회를 해본다.
		StringBuffer query = new StringBuffer();
		query.append("SELECT MV_ID                                   ");
		query.append("     , TTL                                     ");
		query.append("     , MV_RTNG                                 ");
		query.append("     , TO_CHAR(RLS_DT, 'YYYY-MM-DD') AS RLS_DT ");
		query.append("     , RNNG_TM                                 ");
		query.append("     , SMMR                                    ");
		query.append("     , MAIN_PSTR_URL                           ");
		query.append("     , URL                                     ");
		query.append("     , FB_URL                                  ");
		query.append("     , X_URL                                   ");
		query.append("     , INSTA_URL                               ");
		query.append("     , TGLN                                    ");
		query.append("     , ORGNL_TTL                               ");
		query.append("     , SHWNG                                   ");
		query.append("     , ORGNL_LNGG                              ");
		query.append("     , BDGT                                    ");
		query.append("     , BX_OFFC_RVN                             ");
		query.append("  FROM MV                                      ");
		query.append(" WHERE DEL_YN = ?                              ");
		query.append("   AND MV_ID = ?                               ");
		
		// 위에 준비된 쿼리를 Oracle에 전송하고 실행한다.
//		List<MvVO> movieList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = dbConnection.prepareStatement(query.toString());
			// ?에 들어갈 값을 할당해준다.
			// 			첫번째?에 N을 넣어라.
			pstmt.setString(1, "N");
			// 			두번째?에 mvId를 넣어라.
			pstmt.setString(2, mvId);
			
			rs = pstmt.executeQuery();
			
			// ResultSet의 Row를 처음부터 끝까지 반복시킨다.
			MvVO mvVO = null;
			while(rs.next()) {
				// 현재 반복 중인 Row에서 각 컬럼들의 값을 추출한다.
				// 추출된 값을 MvVO에게 할당해준다.
				mvVO = new MvVO();
				mvVO.setMvId(rs.getString("MV_ID"));
				mvVO.setTtl(rs.getString("TTL"));
				mvVO.setMvRtng(rs.getString("MV_RTNG"));
				mvVO.setRlsDt(rs.getString("RLS_DT"));
				mvVO.setRnngTm(rs.getInt("RNNG_TM"));
				mvVO.setSmmr(rs.getString("SMMR"));
				mvVO.setMainPstrUrl(rs.getString("MAIN_PSTR_URL"));
				mvVO.setUrl(rs.getString("URL"));
				mvVO.setFbUrl(rs.getString("FB_URL"));
				mvVO.setXUrl(rs.getString("X_URL"));
				mvVO.setInstaUrl(rs.getString("INSTA_URL"));
				mvVO.setTgln(rs.getString("TGLN"));
				mvVO.setOrgnlTtl(rs.getString("ORGNL_TTL"));
				mvVO.setShwng(rs.getString("SHWNG"));
				mvVO.setOrgnlLngg(rs.getString("ORGNL_LNGG"));
				mvVO.setBdgt(rs.getLong("BDGT"));
				mvVO.setBxOffcRvn(rs.getLong("BX_OFFC_RVN"));
				
				// MvVO를 List<MvVO>에게 추가한다.
//				movieList.add(mvVO);
			}
			return mvVO;
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다.", sqle);
		} finally {
			// rs close
			if (rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {}
			}
			
			// pstmt close
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {}
			}
			
			// connection close
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch(SQLException e) {}
			}
		}
		
//		movieList.forEach(System.out::println);
		
	}
	
	public static List<GnrVO> selectGenre(String mvId){
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String schemaName = "TMDB";
		String password = "TMDB";
		
		Connection dbConnection = null;
		try {
			dbConnection = DriverManager.getConnection(url, schemaName, password);
			System.out.println(dbConnection.getSchema());
		} catch(SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.", sqle);
		}
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.GNR_ID           ");
		query.append("	 , G.NM                 ");
		query.append("  FROM GNR G              ");
		query.append(" INNER JOIN MV_GNR MG     ");
		query.append(" 	ON G.GNR_ID = MG.GNR_ID ");
		query.append(" WHERE MG.MV_ID = ?       ");
		
		List<GnrVO> gnrList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = dbConnection.prepareStatement(query.toString());
			pstmt.setString(1, "1-spider-man-brand-new-day");
			
			rs = pstmt.executeQuery();
			
			GnrVO gnrVO = null;
			while(rs.next()) {
				gnrVO = new GnrVO();
				gnrVO.setGnrId(rs.getString("GNR_ID"));
				gnrVO.setNm(rs.getString("NM"));
				gnrList.add(gnrVO);
			}
			
			return gnrList;
		} catch(SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다.", sqle);
		} finally {
			try {
				rs.close();
			} catch(SQLException e) {}
			try {
				pstmt.close();
			} catch(SQLException e) {}
			try {
				dbConnection.close();
			} catch(SQLException e) {}
		}
	}
	
	/**
	 * 장르에 해당하는 영화를 모두 조회한다.
	 * @param gnrId 조회하려는 장르 아이디
	 * @return 해당 장르의 영화 목록
	 */
	public static List<MvVO> selectMovieOf(String gnrId){
		return null;
	}
	
	public static void main(String[] args) {
		String movieId = "1-spider-man-brand-new-day";
		MvVO movie = selectMovie(movieId);
		System.out.println(movie);
		
		List<GnrVO> gnrList = selectGenre(movieId);
		// 하나의 영화에는 여러 개의 장르가 있다.
		movie.setGnrList(gnrList);
		System.out.println(movie.getGnrList());
		
		movie.getGnrList().forEach(gnr -> {
			System.out.println("[" + movie.getTtl() + "] 장르명: " + gnr.getNm());
		});
	}
}
