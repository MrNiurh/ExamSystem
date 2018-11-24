package com.ssm.sample.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiReadExcel {

	public static void main(String[] args) throws IOException {

		// 需要解析的 Excel 文件
		// File file = new File("f:/test.xlsx");
		File file = new File("f:/test.xlsx");

		Workbook workbook = null;
		String fileName = file.getName();
		if (fileName.endsWith("xls")) {
			workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
		} else if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
		}

		if (workbook != null) {
			Sheet sheet = workbook.getSheetAt(0);
			// 获得当前sheet的开始行
			int firstRowNum = sheet.getFirstRowNum();
			// 获得当前sheet的结束行
			int lastRowNum = sheet.getLastRowNum();
			// 循环除了第一行的所有行
			for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
				// 获得当前行
				Row row = sheet.getRow(rowNum);
				if (row == null) {
					continue;
				}
				// 获得当前行的开始列
				int firstCellNum = row.getFirstCellNum();
				// 获得当前行的列数
				int lastCellNum = row.getPhysicalNumberOfCells();
				String[] cells = new String[row.getPhysicalNumberOfCells()];
				// 循环当前行
				for (int cellNum = firstCellNum; cellNum < lastCellNum + firstCellNum; cellNum++) {
					Cell cell = row.getCell(cellNum);
					String value = (String) getCellValue(cell);
					System.out.print(value + "\t");
				}
				System.out.println();
			}

		}

	}

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}
}
