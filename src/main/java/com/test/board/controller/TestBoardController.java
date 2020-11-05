package com.test.board.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.test.board.service.TestBoardService;
import com.test.board.vo.ResultVO;
import com.test.board.vo.TestBoardVO;

@RestController
public class TestBoardController {
	@Resource
	private TestBoardService tbService;
	@GetMapping("/tbs/{pageNum}/{pageSize}")
	public PageInfo<TestBoardVO> getTestBoards(TestBoardVO tb, @PathVariable int pageNum,@PathVariable int pageSize){
		PageInfo<TestBoardVO> pageInfo = 
				new PageInfo<>(tbService.selectTestBoardList(tb,pageNum, pageSize));
		return pageInfo;
	}
	
	public int insertTestBoard(@RequestBody TestBoardVO tb) {
		return tbService.insertTestBoard(tb);
	}
	@GetMapping("/tb/{tbNum}")
	public TestBoardVO getTestBoard(@PathVariable int tbNum){
		return tbService.selectTestBoard(tbNum);
	}
	@GetMapping("/tb/{tbNum}/tcs")
	public ResultVO getTestBoardWithTcList(TestBoardVO tb){
		return tbService.getTestBoardWithTcList(tb);
	}
}





