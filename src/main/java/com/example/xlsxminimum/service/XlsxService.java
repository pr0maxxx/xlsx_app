package com.example.xlsxminimum.service;


import com.example.xlsxminimum.util.KthMinFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class XlsxService {
    public int findKthMinimum(String filePath, int k) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        }
        if (k > numbers.size()) throw new IllegalArgumentException("k is too large");
        int[] array = numbers.stream().mapToInt(i -> i).toArray();
        return KthMinFinder.findKthSmallest(array, k);
    }
}