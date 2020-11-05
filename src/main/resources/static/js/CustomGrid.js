/**
 * 
 */

$.fn.CustomGrid = function(conf){
	var cols = conf.cols;
	var tHeadHtml = '';
	var tBodyHtml = '';
	var tObj = $(this);
	if(conf.color){
		tObj.css({color:conf.color});
	}
	if(conf.bgColor){
		tObj.css({'background-color':conf.bgColor});
	}
	var init = function(){
		$.ajax({
			url : conf.url,
			type : conf.type?conf.type:'GET',
			success : function(res){
				console.log(res);
				rendor(res);
				if(conf.pageCallBack){
					conf.pageCallBack(res.total);
				}
			}
		});
	}
	function rendor(res){
		tHeadHtml += '<tr>';
		for(var col of cols){
			tHeadHtml += `<td>${col.label}</td>`;
		}
		tHeadHtml += '</tr>';
		for(var data of res.list){
			tBodyHtml += '<tr>';
			for(var col of cols){
				tBodyHtml += `<td>${data[col.name]}</td>`;
			}
			tBodyHtml += '</tr>';
		}
		var tPageHtml = '';
		if(conf.page){
			tPageHtml = '<tr>';
			tPageHtml += '<td colspan="' + cols.length + '">여기에 페이지 나오면됨</td>' 
			tPageHtml += '</tr>';
		}
		tObj.html(tHeadHtml + tBodyHtml + tPageHtml);
	}
	init();
}
