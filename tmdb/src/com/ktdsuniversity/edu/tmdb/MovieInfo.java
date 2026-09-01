package com.ktdsuniversity.edu.tmdb;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.appr.vo.ApprVO;
import com.ktdsuniversity.edu.tmdb.bckgrnd.vo.BckgrndVO;
import com.ktdsuniversity.edu.tmdb.common.utils.DBConnector;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.kwrd.vo.KwrdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;
import com.ktdsuniversity.edu.tmdb.pstr.vo.PstrVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

public class MovieInfo {

	private DBConnector connector;
	
	public MovieInfo() {
		this.connector = DBConnector.builder()
									.setDriverClassName("oracle.jdbc.driver.OracleDriver")
									.setUrl("jdbc:oracle:thin:@//localhost:1521/XE")
									.setSchemaName("TMDB")
									.setPassword("TMDB")
									.connect();
	}
	
	public MvVO selectMovie(String mvId) {
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
		query.append(" WHERE DEL_YN = 'N'                            ");
		query.append("   AND MV_ID = ?                               ");
		 
		return connector.selectBuilder(MvVO.class, query)
						.setParams(pstmt -> pstmt.setString(1, mvId))
						.selectOne();
	}
	
	public void setGenres(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.GNR_ID           ");
		query.append("	 , G.NM                 ");
		query.append("  FROM GNR G              ");
		query.append(" INNER JOIN MV_GNR MG     ");
		query.append(" 	ON G.GNR_ID = MG.GNR_ID ");
		query.append(" WHERE MG.MV_ID = ?       ");
		
		List<GnrVO> genres = this.connector.selectBuilder(GnrVO.class, query)
								 .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
								 .selectList();
		movie.setGnrList(genres);
	}
	
	public void setKeywords(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT K.KWRD_ID            ");
		query.append("	 , K.NM                   ");
		query.append("  FROM KWRD K               ");
		query.append(" INNER JOIN MV_KWRD MK      ");
		query.append(" 	ON K.KWRD_ID = MK.KWRD_ID ");
		query.append(" WHERE MK.MV_ID = ?         ");
		
		List<KwrdVO> kwrds = this.connector.selectBuilder(KwrdVO.class, query)
								 .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
								 .selectList();
		movie.setKwrdList(kwrds);
	}
	
	public void setVideos(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.MV_ID              ");
		query.append("	 , V.VD_ID                ");
		query.append("	 , V.VD_URL               ");
		query.append("  FROM VD V                 ");
		query.append(" INNER JOIN MV M            ");
		query.append(" 	ON V.MV_ID = M.MV_ID      ");
		query.append(" WHERE M.MV_ID = ?          ");
		
		List<VdVO> videos = this.connector.selectBuilder(VdVO.class, query)
								   .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
								   .selectList();
		movie.setVdList(videos);
	}
	
	public void setBackgrounds(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT B.MV_ID          ");
		query.append("	 , B.BCKGRND_ID       ");
		query.append("	 , B.BCKGRND_URL      ");
		query.append("  FROM BCKGRND B        ");
		query.append(" INNER JOIN MV M        ");
		query.append(" 	ON B.MV_ID = M.MV_ID  ");
		query.append(" WHERE M.MV_ID = ?      ");
		List<BckgrndVO> backgrounds = this.connector.selectBuilder(BckgrndVO.class, query)
										  .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
										  .selectList();
		movie.setBckgrndList(backgrounds);
	}
	
	public void setPosters(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT P.MV_ID          ");
		query.append("	 , P.PSTR_ID          ");
		query.append("	 , P.PSTR_URL         ");
		query.append("  FROM PSTR P           ");
		query.append(" INNER JOIN MV M        ");
		query.append(" 	ON P.MV_ID = M.MV_ID  ");
		query.append(" WHERE M.MV_ID = ?      ");
		List<PstrVO> posters = this.connector.selectBuilder(PstrVO.class, query)
								   .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
								   .selectList();
		movie.setPstrList(posters);
	}
	
	public void setCasts(MvVO movie) {
		// 출연진 조회 Mv has a Appr
		final StringBuffer query = new StringBuffer();
		query.append("SELECT INVLVD_ID ");
		query.append("	 , MV_ID       ");
		query.append("	 , RL          ");
		query.append("	 , STR_ID      ");
		query.append("  FROM APPR      ");
		query.append(" WHERE MV_ID = ? ");
		List<ApprVO> appears = this.connector.selectBuilder(ApprVO.class, query)
								   .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
								   .selectList();
		movie.setApprList(appears);
		
//		query = new StringBuffer();
		query.delete(0, query.length());
		query.append("SELECT INVLVD_ID     ");
		query.append("	 , NM              ");
		query.append("	 , PRFL_PHT_URL    ");
		query.append("  FROM INVLVD        ");
		query.append(" WHERE INVLVD_ID = ? ");
		
		// Appr has a Invlvd
		appears.forEach(appr -> {
			// 람다 함수 내부에서는 외부의 지역 변수를 사용할 수 없다.
			// 람다 함수 내부에서 사용할 수 있는 것 => 람다 내부의 지역변수, 람다 외부의 상수, 멤버변수
			InvlvdVO involved = this.connector.selectBuilder(InvlvdVO.class, query)
									.setParams(pstmt -> pstmt.setString(1, appr.getInvlvdId()))
									.selectOne();
			appr.setInvlvdVO(involved);
		});
	}
	
	public void setFilmmakers(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT FLMMKR_ID   ");
		query.append("	 , INVLVD_ID     ");
		query.append("	 , MV_ID         ");
		query.append("	 , PRT           ");
		query.append("	 , RL            ");
		query.append("  FROM FLMMKR      ");
		query.append(" WHERE MV_ID = ?   ");
		
		List<FlmmkrVO> filmmakers = this.connector.selectBuilder(FlmmkrVO.class, query)
										.setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
										.selectList();
		movie.setFlmmkrList(filmmakers);

		query.delete(0, query.length());
		query.append("  SELECT INVLVD_ID    "); 
		query.append("	 , NM               ");
		query.append("	 , PRFL_PHT_URL     ");
		query.append("  FROM INVLVD         ");
		query.append(" WHERE INVLVD_ID = ?  ");
		
		filmmakers.forEach(flmmkr -> {
			InvlvdVO involved = this.connector.selectBuilder(InvlvdVO.class, query)
					.setParams(pstmt -> pstmt.setString(1, flmmkr.getInvlvdId()))
					.selectOne();
			flmmkr.setInvlvdVO(involved);
		});
	}
	
	public static void main(String[] args) {
		MovieInfo movieInfo = new MovieInfo();
		
		MvVO movie = movieInfo.selectMovie("5-the-odyssey");
		movieInfo.setGenres(movie);
		movieInfo.setKeywords(movie);
		movieInfo.setVideos(movie);
		movieInfo.setBackgrounds(movie);
		movieInfo.setPosters(movie);
		movieInfo.setCasts(movie);
		movieInfo.setFilmmakers(movie);
		
		System.out.println(movie);
		System.out.println("---장르명---");
		movie.getGnrList().forEach(gnr -> System.out.println(gnr.getNm()));
		
		System.out.println();
		System.out.println("---키워드---");
		movie.getKwrdList().forEach(kwrd -> System.out.println(kwrd.getNm()));
		
		System.out.println();
		System.out.println("---비디오---");
		movie.getVdList().forEach(vd -> System.out.println(vd.getVdId()));
		
		System.out.println();
		System.out.println("---배경---");
		movie.getBckgrndList().forEach(bckgrnd -> System.out.println(bckgrnd.getBckgrndId()));
		
		System.out.println();
		System.out.println("---포스터---");
		movie.getPstrList().forEach(pstr -> System.out.println(pstr.getPstrId()));
		
		System.out.println();
		System.out.println("---출연 배우---");
		movie.getApprList().forEach(appr -> {
			System.out.println(appr.getInvlvdVO().getNm() + " - " + appr.getRl());
		});
		
		System.out.println();
		System.out.println("---제작진---");
		movie.getFlmmkrList().forEach(flmmkr -> {
			System.out.println(flmmkr.getInvlvdVO().getNm() + " - " + flmmkr.getPrt() + " - " + flmmkr.getRl());
		});
		
		// App 종료 직전 모든 Connection을 닫는다.
		movieInfo.connector.close();
	}
	
}
