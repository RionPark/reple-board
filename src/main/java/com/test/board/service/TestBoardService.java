package com.test.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.board.mapper.TestBoardMapper;
import com.test.board.mapper.TestCommentMapper;
import com.test.board.vo.ResultVO;
import com.test.board.vo.TestBoardVO;
import com.test.board.vo.TestCommentVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestBoardService {

	@Resource
	private TestBoardMapper tbMapper;
	@Resource
	private TestCommentMapper tcMapper;
	
	public Page<TestBoardVO> selectTestBoardList(TestBoardVO tb, int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		Page<TestBoardVO> page =  tbMapper.selectTestBoardList(tb);
		log.info("page=>{}",page);
		return page;
	}
	
	public int insertTestBoard(TestBoardVO tb) {
		return tbMapper.insertTestBoard(tb);
	}

	public TestBoardVO selectTestBoard(int tbNum) {
		return tbMapper.selectTestBoard(tbNum);
	}

	public ResultVO getTestBoardWithTcList(TestBoardVO tb) {
		ResultVO rVO = new ResultVO();
		rVO.setTb(tbMapper.selectTestBoard(tb.getTbNum()));
		TestCommentVO tc = new TestCommentVO();
		tc.setTbNum(tb.getTbNum());
		rVO.setTcList(tcMapper.selectTestCommentList(tc));
		return rVO;
	}
}







