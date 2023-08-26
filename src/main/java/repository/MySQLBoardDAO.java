package org.sp.mybatisapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sp.mybatisapp.domain.Board;
import org.sp.mybatisapp.mybatis.MybatisConfig;

//오직  Board 테이블에 대한 CRUD만을 담당하기 위한 객체
public class MySQLBoardDAO {
	MybatisConfig config=MybatisConfig.getInstance(); //싱글턴으로 생성
	
	//글등록
	public int insert(Board board) {
		SqlSession sqlSession=config.getSqlSession();
		int result=sqlSession.insert("Board.insert", board);
		System.out.println("쿼리문 수행 결과는 "+result);
		//하나의 업무를 이루는 DML 모두 성공해야 전체를 성공으로 확정짓는 논리적 
		//업무 단위
		sqlSession.commit(); //트랜잭션 완료,확정
		return result;
	}
	
	//글목록 
	public List selectAll() {
		SqlSession sqlSession=config.getSqlSession();
		List list=sqlSession.selectList("Board.selectAll");
		return list;
	}
	
	//글한건 보기 
	public Board select(int board_idx) {
		SqlSession sqlSession=config.getSqlSession();
		return sqlSession.selectOne("Board.select", board_idx);
	}
	
	// 한건 수정
	public int update(Board board) {
		return 0;
	}
	
	//한건삭제 
	public int delete(int board_idx) {
		return 0;
	}
}











