package com.yxysoft.basic.controller;


import java.io.IOException;

import java.util.List;


import javax.servlet.http.HttpServletResponse;




import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxysoft.basic.model.QueryVo2;
import com.yxysoft.basic.model.QueryVo3;

import com.yxysoft.basic.service.StatementService;



@Controller
@RequestMapping(value="/statement")
public class StatementController {

	
	@Autowired
	private StatementService StatementS;
	@ResponseBody
	@RequestMapping("/list")
	public List<QueryVo3> queryStatementList(QueryVo2 vo){
		List<QueryVo3> list=StatementS.queryStatementList(vo);
		return list;
	}
	
	
	
    
    
    
    
    /**
	 * 分区数据导出功能
	 * @throws IOException 
	 */
    @RequestMapping("/export")
	public String exportXls(QueryVo2 vo,HttpServletResponse response) throws IOException{
		
	    //第一步：查询所有数据
        List<QueryVo3> list=StatementS.queryStatementList(vo);
		
		//第二步：使用POI将数据写到Excel文件中
		//在内存中创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个标签页
		HSSFSheet sheet = workbook.createSheet("考勤明细");
		//创建标题行
		HSSFRow headRow = sheet.createRow(0);

		headRow.createCell(0).setCellValue("部门");
		headRow.createCell(1).setCellValue("姓名");
		headRow.createCell(2).setCellValue("工号");
		headRow.createCell(3).setCellValue("加班天数");
		headRow.createCell(4).setCellValue("请假天数");
		/*headRow.createCell(5).setCellValue("缺勤天数");*/
		headRow.createCell(5).setCellValue("打卡天数");
		headRow.createCell(6).setCellValue("补卡天数");
        
		 for (QueryVo3 qu: list) {

			HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
			row.createCell(0).setCellValue(qu.getDepartment());
			row.createCell(1).setCellValue(qu.getUser_name());
			row.createCell(2).setCellValue(qu.getUser_code());

			row.createCell(3).setCellValue((qu.getP1() == null) ? 0 : qu.getP1());
			row.createCell(4).setCellValue((qu.getP2() == null) ? 0 : qu.getP2());

			/* row.createCell(5).setCellValue(qu.getP2()-qu.getP1()); */
			row.createCell(5).setCellValue((qu.getP4() == null) ? 0 : qu.getP4());
			row.createCell(6).setCellValue((qu.getP5() == null) ? 0 : qu.getP5());
		}

		//第三步：使用输出流进行文件下载（一个流、两个头）
		
		String filename = "Excel.xls";
		//String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		//ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		//ServletActionContext.getResponse().setContentType(contentType);
		
		//获取客户端浏览器类型
		//String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		//filename = FileUtils.encodeDownloadFilename(filename, agent);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + filename);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
			return filename;
	}
	
}
