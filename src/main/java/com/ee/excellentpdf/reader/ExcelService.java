package com.ee.excellentpdf.reader;

import com.ee.excellentpdf.domain.SalarySlip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ExcelService {
    public List<SalarySlip> fetchSalarySlips(File file) throws IOException;
}
