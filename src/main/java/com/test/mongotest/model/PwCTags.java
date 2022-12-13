package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class PwCTags {

    public static List<String> Tags;

    static {
        Tags = Arrays.asList(
                "accounting",
                "accounts payable",
                "accounts receivable",
                "assets",
                "budget",
                "capital gains",
                "cash flow",
                "compliance",
                "corporate tax",
                "cost of goods sold",
                "deductions",
                "depreciation",
                "employee benefits",
                "expenses",
                "federal income tax",
                "fixed assets",
                "inventory",
                "investments",
                "liabilities",
                "net income",
                "operating expenses",
                "operating income",
                "payroll",
                "profit and loss",
                "profitability",
                "property tax",
                "revenue",
                "sales tax",
                "schedule C",
                "schedule D",
                "stockholders equity",
                "tax deductions",
                "tax rate",
                "tax return",
                "taxable income",
                "taxable sales",
                "taxes payable",
                "taxes withheld",
                "tax-exempt income",
                "value added tax",
                "withholding tax",
                "working capital",
                "year-end close",
                "yearly tax planning",
                "1099 form",
                "1040 form",
                "W-2 form",
                "Tax",
                "2022",
                "2021",
                "2020",
                "2019",
                "2023",
                "audit",
                "filing",
                "csv",
                "xml",
                "pdf",
                "tar",
                "parquet"
        );
    }
}

