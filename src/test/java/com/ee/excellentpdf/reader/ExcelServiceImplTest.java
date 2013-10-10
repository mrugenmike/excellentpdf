package com.ee.excellentpdf.reader;

import com.ee.excellentpdf.domain.SalarySlip;
import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import static org.junit.Assert.*;

public class ExcelServiceImplTest {

    private File getSalarySlipAsXls() throws URISyntaxException {
        URL url = getClass().getClassLoader().getResource("salary.xls");
        URI uri = url.toURI();
        return new File(uri);
    }

    @Test
    public void itShouldConvertExcelToSalarySlips() throws URISyntaxException, IOException {

        File excelFile = getSalarySlipAsXls();
        ExcelService excelService = new ExcelServiceImpl();

        final List<SalarySlip> salarySlips = excelService.fetchSalarySlips(excelFile);

        assertEquals(salarySlips.size(),9);
        final SalarySlip salarySlip = salarySlips.get(0);
        assertEquals(salarySlip.getName(),"Vikas Seth");

    }

}
