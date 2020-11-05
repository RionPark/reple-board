package com.test.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.test.board.vo.TestBoardVO;

@Mapper
public interface TestBoardMapper {

	public Page<TestBoardVO> selectTestBoardList(TestBoardVO tb);
	public int insertTestBoard(TestBoardVO tb);
	public TestBoardVO selectTestBoard(int tbNum);
}
