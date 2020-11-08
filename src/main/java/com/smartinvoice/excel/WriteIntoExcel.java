package com.smartinvoice.excel;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.record.cf.BorderFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Service;

import com.smartinvoice.model.Users;


@Service
public class WriteIntoExcel {

	public static HSSFWorkbook dowExcel(List<Users> userList2) {
		try {
			HSSFWorkbook sampleWorkbook = null;
			HSSFSheet sampleDataSheet = null;

			int i = 0;
			int j = 1;
			/**
			 * Create a new instance for HSSFWorkBook class and create a sample work-sheet
			 * using HSSFSheet class to write data.
			 */
			sampleWorkbook = new HSSFWorkbook();
			sampleDataSheet = sampleWorkbook.createSheet("INVOICE DATA");
			int columnWidth[] = new int[] { 2500, 6000, 8000, 8000, 5000, 5000, 5000, 5000, 20000, 20000, 4000, 4000,
					5000, 5000, 4000, 20000 };
			for (int width : columnWidth)
				sampleDataSheet.setColumnWidth(i++, width);
			HSSFRow headerRow = sampleDataSheet.createRow(0);
			/**
			 * Call the setHeaderStyle method and set the styles for the all the three
			 * header cells.
			 */
			HSSFCellStyle headerStyle = setHeaderStyle(sampleWorkbook, true);
			String columns[] = new String[] { "Company", "Delegates Name", "Email", "Role", "Contact Number" };
			headerRow.setHeightInPoints(50);
			i = 0;
			for (String columnName : columns) {
				HSSFCell headerCell = headerRow.createCell(i++);
				headerCell.setCellStyle(headerStyle);
				headerCell.setCellValue(new HSSFRichTextString(columnName));
			}
			HSSFCellStyle cellStyle = setHeaderStyle(sampleWorkbook, false);
			/*
			 * HSSFCellStyle commStyle = setCommentsStyle(sampleWorkbook, false);
			 * HSSFCellStyle nameStyle = setNameStyle(sampleWorkbook, false);
			 */
			/**
			 * Set the cell value for all the data rows.
			 */
			for (Users users : userList2) {
				HSSFRow dataRow = sampleDataSheet.createRow(j++);
				i = 0;
				HSSFCell dataCell1 = dataRow.createCell(i++);
				dataCell1.setCellValue(users.getCompany());
				HSSFCell dataCell2 = dataRow.createCell(i++);
				dataCell2.setCellValue(users.getDelegatesName());
				HSSFCell dataCell3 = dataRow.createCell(i++);
				dataCell3.setCellValue(users.getEmail());
				HSSFCell dataCell4 = dataRow.createCell(i++);
				dataCell4.setCellValue(users.getRole());
				HSSFCell dataCell5 = dataRow.createCell(i++);
				dataCell5.setCellValue(users.getContactNumber());
			}
			HSSFPalette palette = sampleWorkbook.getCustomPalette();
			palette.setColorAtIndex(HSSFColor.ORANGE.index, (byte) 255, (byte) 133, (byte) 18);
			return sampleWorkbook;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static HSSFCellStyle setHeaderStyle(HSSFWorkbook sampleWorkBook, boolean b) {
		HSSFFont font = sampleWorkBook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		if (b) {
			// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.BLACK.index);
		}
		HSSFCellStyle cellStyle = sampleWorkBook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);
		if (b) {
			cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBorderBottom(BorderFormatting.BORDER_THIN);
			cellStyle.setBorderTop(BorderFormatting.BORDER_THICK);
			cellStyle.setBorderLeft(BorderFormatting.BORDER_THIN);
			cellStyle.setBorderRight(BorderFormatting.BORDER_THIN);
		}
		return cellStyle;
	}

}
